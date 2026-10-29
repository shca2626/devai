import { db } from '@/lib/db'
import type { ReadinessMetric, ReadinessReport } from '@/lib/types'

// ============================================================
// Readiness gate — answers "is the analysis actually complete?"
// The score is a weighted sum of REAL checks, and the lockable
// flag depends on hard blockers, never on a cosmetic 100%.
// A complete-looking document set with an undecided critical
// business decision will NOT pass here.
// ============================================================

function parseCodes(raw: string | null | undefined): string[] {
  if (!raw) return []
  try {
    const v = JSON.parse(raw)
    return Array.isArray(v) ? v.filter((c): c is string => typeof c === 'string') : []
  } catch {
    return []
  }
}

function pct(n: number, d: number): number {
  return d === 0 ? 1 : n / d
}

export async function computeReadiness(ideaId: string): Promise<ReadinessReport> {
  const [requirements, processes, entities, apis, screens, tasks, risks, issues, assumptions, architecture] =
    await Promise.all([
      db.requirement.findMany({ where: { ideaId } }),
      db.processFlow.findMany({ where: { ideaId } }),
      db.dataEntity.findMany({ where: { ideaId } }),
      db.apiEndpoint.findMany({ where: { ideaId } }),
      db.screenSpec.findMany({ where: { ideaId } }),
      db.implTask.findMany({ where: { ideaId } }),
      db.riskItem.findMany({ where: { ideaId } }),
      db.consistencyIssue.findMany({ where: { ideaId } }),
      db.assumption.findMany({ where: { ideaId, status: 'open' } }),
      db.architectureDoc.findUnique({ where: { ideaId } }),
    ])

  const confirmedFRs = requirements.filter((r) => r.status === 'confirmed' && r.type === 'functional')
  const confirmedTasks = tasks.filter((t) => t.status === 'confirmed')
  const confirmedProcesses = processes.filter((p) => p.status === 'confirmed')
  const confirmedScreens = screens.filter((s) => s.status === 'confirmed')
  const openCritical = issues.filter((i) => i.status === 'open' && i.severity === 'critical')
  const openMajor = issues.filter((i) => i.status === 'open' && i.severity === 'major')
  const unresolvedMust = requirements.filter((r) => r.status === 'unresolved' && r.priority === 'must')

  const procLinks = new Set(confirmedProcesses.flatMap((p) => parseCodes(p.linkedRequirements)))
  const screenLinks = new Set(confirmedScreens.flatMap((s) => parseCodes(s.linkedRequirements)))
  const taskLinks = new Set(confirmedTasks.flatMap((t) => parseCodes(t.requirementCodes)))

  const frWithCriteria = confirmedFRs.filter((r) => {
    try {
      return Array.isArray(JSON.parse(r.acceptanceCriteria)) && JSON.parse(r.acceptanceCriteria).length > 0
    } catch {
      return false
    }
  })

  const unreviewed = {
    requirements: requirements.filter((r) => r.status === 'proposed').length,
    processes: processes.filter((p) => p.status === 'proposed' || p.status === 'needs_revision').length,
    entities: entities.filter((e) => e.status === 'proposed' || e.status === 'needs_revision').length,
    apis: apis.filter((a) => a.status === 'proposed' || a.status === 'needs_revision').length,
    screens: screens.filter((s) => s.status === 'proposed' || s.status === 'needs_revision').length,
    tasks: tasks.filter((t) => t.status === 'proposed' || t.status === 'needs_revision').length,
    risks: risks.filter((r) => r.status === 'proposed').length,
  }

  const tasksComplete = confirmedTasks.filter(
    (t) => t.deliverable && parseCodes(t.acceptanceCriteria).length > 0
  )

  const designReviewed =
    unreviewed.processes === 0 &&
    unreviewed.entities === 0 &&
    unreviewed.apis === 0 &&
    unreviewed.screens === 0 &&
    confirmedProcesses.length > 0 &&
    entities.filter((e) => e.status === 'confirmed').length > 0 &&
    apis.filter((a) => a.status === 'confirmed').length > 0 &&
    confirmedScreens.length > 0 &&
    architecture?.status === 'confirmed'

  const metrics: ReadinessMetric[] = []
  const add = (m: ReadinessMetric) => metrics.push(m)

  add({
    id: 'requirements_reviewed',
    label: 'All requirements reviewed',
    labelAr: 'تمت مراجعة جميع المتطلبات',
    weight: 10,
    pass: unreviewed.requirements === 0,
    blocker: true,
    detail: unreviewed.requirements === 0 ? 'No requirement is left unreviewed.' : `${unreviewed.requirements} requirement(s) still proposed.`,
  })
  add({
    id: 'fr_acceptance',
    label: 'Every confirmed FR has acceptance criteria',
    labelAr: 'لكل متطلب وظيفي معتمد معايير قبول',
    weight: 10,
    pass: confirmedFRs.length > 0 && frWithCriteria.length === confirmedFRs.length,
    blocker: true,
    detail:
      confirmedFRs.length === 0
        ? 'No confirmed functional requirements yet.'
        : `${frWithCriteria.length}/${confirmedFRs.length} confirmed FRs have testable acceptance criteria.`,
  })
  add({
    id: 'fr_process_coverage',
    label: 'Every confirmed FR realized by a process',
    labelAr: 'كل متطلب وظيفي يتحقق عبر عملية أعمال',
    weight: 12,
    pass: confirmedFRs.length > 0 && confirmedFRs.every((r) => procLinks.has(r.code)),
    blocker: false,
    detail:
      confirmedFRs.length === 0
        ? 'No confirmed functional requirements yet.'
        : `${confirmedFRs.filter((r) => procLinks.has(r.code)).length}/${confirmedFRs.length} linked to a confirmed process.`,
  })
  add({
    id: 'fr_screen_coverage',
    label: 'User-facing FRs have a screen',
    labelAr: 'المتطلبات الظاهرة للمستخدم لها شاشات',
    weight: 6,
    pass: confirmedFRs.length > 0 && confirmedFRs.every((r) => screenLinks.has(r.code)),
    blocker: false,
    detail:
      confirmedFRs.length === 0
        ? 'No confirmed functional requirements yet.'
        : `${confirmedFRs.filter((r) => screenLinks.has(r.code)).length}/${confirmedFRs.length} covered by a confirmed screen.`,
  })
  add({
    id: 'fr_task_coverage',
    label: 'Every confirmed FR has an implementation task',
    labelAr: 'لكل متطلب وظيفي مهمة تنفيذ',
    weight: 15,
    pass: confirmedFRs.length > 0 && confirmedFRs.every((r) => taskLinks.has(r.code)),
    blocker: true,
    detail:
      confirmedFRs.length === 0
        ? 'No confirmed functional requirements yet.'
        : `${confirmedFRs.filter((r) => taskLinks.has(r.code)).length}/${confirmedFRs.length} covered by a confirmed task.`,
  })
  add({
    id: 'design_approved',
    label: 'System design approved (data, API, screens, architecture)',
    labelAr: 'اعتماد تصميم النظام (البيانات، الواجهات، الشاشات، المعمارية)',
    weight: 12,
    pass: designReviewed,
    blocker: true,
    detail: designReviewed
      ? 'Processes, entities, APIs, screens and architecture are all reviewed and confirmed.'
      : `Unreviewed — processes: ${unreviewed.processes}, entities: ${unreviewed.entities}, APIs: ${unreviewed.apis}, screens: ${unreviewed.screens}, architecture: ${architecture ? (architecture.status === 'confirmed' ? 'confirmed' : architecture.status) : 'missing'}.`,
  })
  add({
    id: 'task_completeness',
    label: 'Tasks have dependencies & defined outcomes',
    labelAr: 'المهام لها تبعيات ونتائج محددة',
    weight: 10,
    pass: confirmedTasks.length > 0 && tasksComplete.length === confirmedTasks.length,
    blocker: true,
    detail:
      confirmedTasks.length === 0
        ? 'No confirmed tasks yet.'
        : `${tasksComplete.length}/${confirmedTasks.length} confirmed tasks have acceptance criteria and a deliverable.`,
  })
  add({
    id: 'no_critical_issues',
    label: 'No open critical consistency issues',
    labelAr: 'لا توجد تعارضات حرجة مفتوحة',
    weight: 10,
    pass: openCritical.length === 0,
    blocker: true,
    detail: openCritical.length === 0 ? 'No open critical contradictions.' : `${openCritical.length} critical issue(s) open.`,
  })
  add({
    id: 'no_unresolved_must',
    label: 'No unresolved must-have requirements',
    labelAr: 'لا متطلبات ضرورية غير محسومة',
    weight: 10,
    pass: unresolvedMust.length === 0,
    blocker: true,
    detail:
      unresolvedMust.length === 0
        ? 'All must-priority requirements are decided.'
        : `${unresolvedMust.length} must-priority requirement(s) unresolved: ${unresolvedMust.map((r) => r.code).join(', ')}.`,
  })
  add({
    id: 'risks_reviewed',
    label: 'All risks have a mitigation decision',
    labelAr: 'لكل مخاطرة قرار معالجة',
    weight: 5,
    pass: risks.length === 0 ? false : unreviewed.risks === 0,
    blocker: false,
    detail: risks.length === 0 ? 'No risk register generated yet.' : unreviewed.risks === 0 ? 'Every risk is mitigated or accepted.' : `${unreviewed.risks} risk(s) unreviewed.`,
  })

  const score = Math.round(metrics.reduce((sum, m) => sum + (m.pass ? m.weight : 0), 0))
  const blockers = metrics.filter((m) => m.blocker && !m.pass).map((m) => `${m.label}: ${m.detail}`)
  const warnings: string[] = []
  if (openMajor.length > 0) warnings.push(`${openMajor.length} major consistency issue(s) are still open — recommended to resolve before implementation.`)
  if (assumptions.length > 0) warnings.push(`${assumptions.length} assumption(s) in the register are still unconfirmed — they were NOT treated as decided.`)

  return {
    score,
    lockable: blockers.length === 0,
    metrics,
    blockers,
    warnings,
  }
}
