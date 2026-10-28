// ============================================================
// Bilingual UI dictionary — Arabic-first with English toggle.
// Content (questions, interpretations) is always bilingual by
// design; this dictionary only covers interface chrome.
// ============================================================

export type UiLang = 'ar' | 'en'

export const AREA_LABELS: Record<UiLang, Record<string, string>> = {
  en: {
    business_problem: 'Business problem',
    target_users: 'Target users',
    product_format: 'Product format',
    business_model: 'Business model',
    user_journeys: 'User journeys',
    scope: 'Scope',
    constraints: 'Constraints',
    success_criteria: 'Success criteria',
    unknowns: 'Unknowns',
  },
  ar: {
    business_problem: 'المشكلة التجارية',
    target_users: 'المستخدمون المستهدفون',
    product_format: 'شكل المنتج',
    business_model: 'نموذج العمل',
    user_journeys: 'رحلات المستخدم',
    scope: 'النطاق',
    constraints: 'القيود',
    success_criteria: 'معايير النجاح',
    unknowns: 'أمور غير معروفة',
  },
}

const dict = {
  appName: { en: 'Blueprint Assistant', ar: 'مساعد المخطط' },
  appTagline: {
    en: 'From a rough idea to an approved software blueprint — step by step, with your approval at every gate.',
    ar: 'من فكرة أولية إلى مخطط برمجي معتمد — خطوة بخطوة، وبموافقتك عند كل بوابة.',
  },
  langToggle: { en: 'English', ar: 'العربية' },
  newIdea: { en: 'New idea', ar: 'فكرة جديدة' },
  workspace: { en: 'Idea workspace', ar: 'مساحة الأفكار' },
  noIdeas: { en: 'No ideas yet — start your first one.', ar: 'لا توجد أفكار بعد — ابدأ أول فكرة لك.' },
  ideasCount: { en: 'ideas', ar: 'فكرة' },
  deleteIdea: { en: 'Delete idea', ar: 'حذف الفكرة' },
  renameIdea: { en: 'Rename', ar: 'إعادة تسمية' },
  deleteConfirmTitle: { en: 'Delete this idea?', ar: 'حذف هذه الفكرة؟' },
  deleteConfirmBody: {
    en: 'This permanently deletes the idea with all its questions, features, assumptions and decisions.',
    ar: 'سيتم حذف الفكرة نهائيًا مع كل الأسئلة والميزات والافتراضات والقرارات.',
  },
  cancel: { en: 'Cancel', ar: 'إلغاء' },
  delete: { en: 'Delete', ar: 'حذف' },
  save: { en: 'Save', ar: 'حفظ' },
  // Welcome
  welcomeTitle: { en: 'What do you want to build?', ar: 'ماذا تريد أن تبني؟' },
  welcomeBody: {
    en: 'Describe your idea in Arabic or English — even incomplete. The assistant will understand it, ask the right questions, and build an approved feature baseline you can hand to any developer.',
    ar: 'صف فكرتك بالعربية أو الإنجليزية — حتى لو كانت ناقصة. سيفهمها المساعد، ويطرح الأسئلة الصحيحة، ويبني خط أساس للميزات معتمدًا منك يمكن تسليمه لأي مطور.',
  },
  tryExample: { en: 'Try this example', ar: 'جرّب هذا المثال' },
  howItWorks: { en: 'How it works', ar: 'كيف يعمل' },
  stepUnderstandDesc: {
    en: 'Your idea is interpreted bilingually — facts, open questions and assumptions are kept separate.',
    ar: 'تُفهم فكرتك بلغتيك — مع فصل الحقائق والأسئلة المفتوحة والافتراضات.',
  },
  stepDiscoverDesc: {
    en: 'An AI business analyst asks adaptive questions with honest consequences per choice.',
    ar: 'محلل أعمال ذكي يطرح أسئلة متكيفة مع تبعات صادقة لكل خيار.',
  },
  stepFeaturesDesc: {
    en: 'A feature inventory is proposed — nothing counts as decided until you accept it.',
    ar: 'يُقترح جدول الميزات — لا يُعد شيء قرارًا حتى توافق عليه.',
  },
  stepBaselineDesc: {
    en: 'Export the approved blueprint as Markdown or JSON, with a full decision trail.',
    ar: 'صدّر المخطط المعتمد بصيغة Markdown أو JSON مع سجل كامل للقرارات.',
  },
  // New idea dialog
  ideaLabel: { en: 'Describe your idea', ar: 'صف فكرتك' },
  ideaPlaceholder: {
    en: 'e.g. I want an app that connects shop owners with suppliers, compares prices, and lets merchants order from several suppliers easily…',
    ar: 'مثال: أريد تطبيق يربط بين أصحاب المحلات والموردين، ويقارن الأسعار، ويخلي التاجر يطلب المنتجات من عدة موردين بسهولة…',
  },
  arabicDetected: { en: 'Arabic detected', ar: 'تم اكتشاف العربية' },
  englishDetected: { en: 'English detected', ar: 'تم اكتشاف الإنجليزية' },
  submitIdea: { en: 'Understand my idea', ar: 'افهم فكرتي' },
  understanding1: { en: 'Reading your idea…', ar: 'يقرأ فكرتك…' },
  understanding2: { en: 'Interpreting the business intent…', ar: 'يفهم المقصود التجاري…' },
  understanding3: { en: 'Separating facts, questions and assumptions…', ar: 'يفصل الحقائق والأسئلة والافتراضات…' },
  // Stage names
  stageUnderstanding: { en: 'Understand', ar: 'الفهم' },
  stageDiscovery: { en: 'Discover', ar: 'الاستكشاف' },
  stageFeatures: { en: 'Features', ar: 'الميزات' },
  stageBaseline: { en: 'Baseline', ar: 'خط الأساس' },
  // Understand stage
  originalIdea: { en: 'Original idea', ar: 'الفكرة الأصلية' },
  englishInterpretation: { en: 'English interpretation', ar: 'التفسير الإنجليزي' },
  problemStatement: { en: 'Problem being solved', ar: 'المشكلة التي تُحل' },
  understoodTitle: { en: 'What is understood (facts)', ar: 'ما تم فهمه (حقائق)' },
  unclearTitle: { en: 'What is unclear', ar: 'ما هو غير واضح' },
  assumedTitle: { en: 'What is assumed (not yet confirmed)', ar: 'ما هو مفترض (غير مؤكد بعد)' },
  unclearNote: {
    en: 'These will be explored during discovery.',
    ar: 'سيتم استكشافها في مرحلة الاستكشاف.',
  },
  assumedNote: {
    en: 'Tracked in the assumption register until you confirm or reject them.',
    ar: 'تُتتبع في سجل الافتراضات حتى تؤكدها أو ترفضها.',
  },
  approveInterpretation: { en: 'Approve & start discovery', ar: 'أوافق — ابدأ الاستكشاف' },
  correctInterpretation: { en: 'Correct the understanding', ar: 'صحّح الفهم' },
  correctPlaceholder: {
    en: 'What did the assistant misunderstand? What should be added, removed or changed?',
    ar: 'ما الذي فهمه المساعد بشكل خاطئ؟ ما الذي يجب إضافته أو حذفه أو تغييره؟',
  },
  submitCorrections: { en: 'Re-interpret', ar: 'أعد الفهم' },
  reinterpretationNote: {
    en: 'You can correct the understanding as many times as you need before approving.',
    ar: 'يمكنك تصحيح الفهم كما تشاء قبل الموافقة.',
  },
  approvedBadge: { en: 'Approved', ar: 'معتمد' },
  lockedNote: { en: 'Locked — approved earlier. Viewing is read-only.', ar: 'مقفل — تم اعتماده مسبقًا. للعرض فقط.' },
  aiError: {
    en: 'The AI service failed. Please try again.',
    ar: 'تعذّر الاتصال بخدمة الذكاء الاصطناعي. حاول مرة أخرى.',
  },
  // Discovery stage
  coverage: { en: 'Coverage', ar: 'التغطية' },
  areasAnswered: { en: 'areas answered', ar: 'منطقة تم الإجابة عليها' },
  questionWhy: { en: 'Why this matters', ar: 'أهمية السؤال' },
  chooseAnswer: { en: 'Choose an option', ar: 'اختر خيارًا' },
  orOwnWords: { en: 'Or answer in your own words', ar: 'أو أجب بكلماتك' },
  ownWordsPlaceholder: { en: 'Type your answer (Arabic or English)…', ar: 'اكتب إجابتك (بالعربية أو الإنجليزية)…' },
  submitAnswer: { en: 'Submit answer', ar: 'إرسال الإجابة' },
  skipQuestion: { en: 'Skip this question', ar: 'تخطي هذا السؤال' },
  answeredLog: { en: 'Answered questions', ar: 'الأسئلة المجابة' },
  noQuestionsYet: { en: 'No questions yet.', ar: 'لا توجد أسئلة بعد.' },
  suggestDoneTitle: { en: 'Discovery looks sufficiently covered', ar: 'يبدو أن الاستكشاف مغطى بشكل كافٍ' },
  suggestDoneBody: {
    en: 'You can finish now and compile the discovery summary, or keep answering more questions.',
    ar: 'يمكنك الإنهاء الآن وتجميع ملخص الاستكشاف، أو الاستمرار في الإجابة على المزيد من الأسئلة.',
  },
  finishDiscovery: { en: 'Compile summary & finish', ar: 'تجميع الملخص والإنهاء' },
  askMore: { en: 'Ask me more questions', ar: 'اطرح أسئلة إضافية' },
  compiling: { en: 'Compiling the discovery summary…', ar: 'يجمّع ملخص الاستكشاف…' },
  generatingQuestion: { en: 'Preparing the next question…', ar: 'يحضّر السؤال التالي…' },
  discoverySummaryTitle: { en: 'Discovery summary', ar: 'ملخص الاستكشاف' },
  openRisks: { en: 'Open risks', ar: 'مخاطر مفتوحة' },
  // Features stage
  generateFeatures: { en: 'Generate feature inventory', ar: 'إنشاء جدول الميزات' },
  generatingFeatures1: { en: 'Reading your approved understanding…', ar: 'يقرأ فهمك المعتمد…' },
  generatingFeatures2: { en: 'Deriving modules and features…', ar: 'يستخرج الوحدات والميزات…' },
  generatingFeatures3: { en: 'Marking what needs your confirmation…', ar: 'يحدد ما يحتاج تأكيدك…' },
  colModule: { en: 'Module', ar: 'الوحدة' },
  colFeature: { en: 'Feature', ar: 'الميزة' },
  colUser: { en: 'User', ar: 'المستخدم' },
  colPriority: { en: 'Priority', ar: 'الأولوية' },
  colStatus: { en: 'Status', ar: 'الحالة' },
  colActions: { en: 'Actions', ar: 'إجراءات' },
  prioMust: { en: 'Must have', ar: 'ضرورية' },
  prioShould: { en: 'Should have', ar: 'مهمة' },
  prioCould: { en: 'Could have', ar: 'ممكنة' },
  statusProposed: { en: 'Proposed', ar: 'مقترحة' },
  statusNeedsConfirmation: { en: 'Needs confirmation', ar: 'تحتاج تأكيدًا' },
  statusAccepted: { en: 'Accepted', ar: 'مقبولة' },
  statusRejected: { en: 'Rejected', ar: 'مرفوضة' },
  statusDeferred: { en: 'Deferred', ar: 'مؤجلة' },
  accept: { en: 'Accept', ar: 'قبول' },
  reject: { en: 'Reject', ar: 'رفض' },
  defer: { en: 'Defer', ar: 'تأجيل' },
  edit: { en: 'Edit', ar: 'تعديل' },
  remove: { en: 'Remove', ar: 'إزالة' },
  addFeature: { en: 'Add feature', ar: 'إضافة ميزة' },
  filterAll: { en: 'All statuses', ar: 'كل الحالات' },
  missingFeaturesTitle: { en: 'Gaps a PM would flag', ar: 'فجوات لفت انتباه مدير المنتج' },
  dependenciesTitle: { en: 'Dependencies', ar: 'التبعيات' },
  releaseNoteTitle: { en: 'Release guidance', ar: 'توجيه الإصدار' },
  approveBaseline: { en: 'Approve feature baseline', ar: 'اعتماد خط أساس الميزات' },
  unreviewedWarning: {
    en: 'features are still unreviewed. Decide what happens to them — this choice is recorded in the decision history.',
    ar: 'ميزات لم تُراجع بعد. قرر ما سيحدث لها — سيُسجل هذا الاختيار في سجل القرارات.',
  },
  bulkAccept: { en: 'Accept all unreviewed', ar: 'قبول كل غير المراجعة' },
  bulkDefer: { en: 'Defer all unreviewed', ar: 'تأجيل كل غير المراجعة' },
  bulkReject: { en: 'Reject all unreviewed', ar: 'رفض كل غير المراجعة' },
  confirmApproval: { en: 'Confirm approval', ar: 'تأكيد الاعتماد' },
  needsConfirmationNote: {
    en: 'This feature depends on an open question or is an AI suggestion beyond your stated scope.',
    ar: 'هذه الميزة تعتمد على سؤال مفتوح أو هي اقتراح من الذكاء الاصطناعي يتجاوز نطاقك المعلن.',
  },
  countsAccepted: { en: 'accepted', ar: 'مقبولة' },
  countsDeferred: { en: 'deferred', ar: 'مؤجلة' },
  countsRejected: { en: 'rejected', ar: 'مرفوضة' },
  countsUnreviewed: { en: 'unreviewed', ar: 'غير مراجعة' },
  // Baseline stage
  baselineApprovedTitle: { en: 'Blueprint baseline approved', ar: 'تم اعتماد خط أساس المخطط' },
  baselineApprovedBody: {
    en: 'Your idea now has an approved, evidence-backed P0 baseline. Export it, or continue the conversation in the registers below.',
    ar: 'أصبح لفكرتك خط أساس P0 معتمد وموثق. صدّره، أو واصل العمل في السجلات أدناه.',
  },
  exportMarkdown: { en: 'Download Markdown', ar: 'تنزيل Markdown' },
  exportJson: { en: 'Download JSON', ar: 'تنزيل JSON' },
  assumptionRegister: { en: 'Assumption register', ar: 'سجل الافتراضات' },
  decisionHistory: { en: 'Decision history', ar: 'سجل القرارات' },
  kindSuggested: { en: 'Suggested', ar: 'مقترح' },
  kindUncertain: { en: 'Uncertain', ar: 'غير مؤكد' },
  statusOpen: { en: 'Open', ar: 'مفتوح' },
  statusConfirmed: { en: 'Confirmed', ar: 'مؤكد' },
  statusRejectedA: { en: 'Rejected', ar: 'مرفوض' },
  confirm: { en: 'Confirm', ar: 'تأكيد' },
  noAssumptions: { en: 'No assumptions tracked for this idea.', ar: 'لا توجد افتراضات مسجلة لهذه الفكرة.' },
  noDecisions: { en: 'No decisions yet.', ar: 'لا توجد قرارات بعد.' },
  lockedBaselineTeaser: {
    en: 'The baseline unlocks after you approve the feature inventory.',
    ar: 'يُفتح خط الأساس بعد اعتمادك لجدول الميزات.',
  },
  roadmapTeaserTitle: { en: 'Coming in P1', ar: 'قادم في المرحلة الأولى' },
  roadmapTeaserBody: {
    en: 'Market research with 10 verified competitors, requirements & architecture engine, and the full engineering document package.',
    ar: 'بحث السوق مع 10 منافسين موثقين، ومحرك المتطلبات والمعمارية، وحزمة وثائق الهندسة الكاملة.',
  },
  voiceInput: { en: 'Voice input', ar: 'إدخال صوتي' },
  voiceUnsupported: { en: 'Voice input is not supported in this browser', ar: 'الإدخال الصوتي غير مدعوم في هذا المتصفح' },
  listening: { en: 'Listening…', ar: 'يستمع…' },
  close: { en: 'Close', ar: 'إغلاق' },
  loading: { en: 'Loading…', ar: 'جارٍ التحميل…' },
  retry: { en: 'Retry', ar: 'إعادة المحاولة' },
  minChars: { en: 'Write at least a sentence or two.', ar: 'اكتب جملة أو جملتين على الأقل.' },
} as const

export type DictKey = keyof typeof dict

export function t(lang: UiLang, key: DictKey): string {
  return dict[key][lang]
}
