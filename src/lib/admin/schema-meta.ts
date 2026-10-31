// AUTO-GENERATED from prisma/schema.prisma by scripts/gen-schema-meta.mjs — do not edit by hand.
// Static model metadata for the admin panel (tables, fields, relations).

export interface SchemaField {
  name: string
  type: string
  id: boolean
  unique: boolean
  hasDefault: boolean
  json: boolean
  optional: boolean
  list: boolean
}

export interface SchemaModel {
  name: string
  fields: SchemaField[]
  relations: Array<{ name: string; type: string }>
  description: string
}

export const SCHEMA_MODELS: SchemaModel[] = [
  {
    "name": "Idea",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "originalText",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "sourceLang",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "projectType",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "stage",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "interpretation",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "summary",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "featuresMeta",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "baseline",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "roles",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "questions",
        "type": "Question[]"
      },
      {
        "name": "features",
        "type": "Feature[]"
      },
      {
        "name": "assumptions",
        "type": "Assumption[]"
      },
      {
        "name": "decisions",
        "type": "Decision[]"
      },
      {
        "name": "requirements",
        "type": "Requirement[]"
      },
      {
        "name": "processes",
        "type": "ProcessFlow[]"
      },
      {
        "name": "entities",
        "type": "DataEntity[]"
      },
      {
        "name": "apiEndpoints",
        "type": "ApiEndpoint[]"
      },
      {
        "name": "screens",
        "type": "ScreenSpec[]"
      },
      {
        "name": "tasks",
        "type": "ImplTask[]"
      },
      {
        "name": "risks",
        "type": "RiskItem[]"
      },
      {
        "name": "issues",
        "type": "ConsistencyIssue[]"
      },
      {
        "name": "architecture",
        "type": "ArchitectureDoc"
      },
      {
        "name": "tradeStudy",
        "type": "ArchTradeStudy"
      },
      {
        "name": "adrs",
        "type": "ArchDecisionRecord[]"
      },
      {
        "name": "threatModel",
        "type": "ThreatModelDoc"
      },
      {
        "name": "scaleReport",
        "type": "ScaleReport"
      },
      {
        "name": "testCases",
        "type": "TestCaseRecord[]"
      },
      {
        "name": "testCoverage",
        "type": "TestCoverageDoc"
      },
      {
        "name": "edgeCases",
        "type": "EdgeCaseDoc"
      },
      {
        "name": "e2eScenarios",
        "type": "E2eScenarioRecord[]"
      },
      {
        "name": "constitutionRules",
        "type": "ConstitutionRule[]"
      },
      {
        "name": "verificationRuns",
        "type": "VerificationRun[]"
      },
      {
        "name": "decisionEntries",
        "type": "DecisionEntry[]"
      },
      {
        "name": "driftChecks",
        "type": "DriftCheck[]"
      },
      {
        "name": "siteAnalyses",
        "type": "SiteAnalysis[]"
      }
    ],
    "description": "The root entity — one product idea with its stage (understanding → package), interpretation, summary, featuresMeta, baseline snapshot and roles."
  },
  {
    "name": "Question",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "area",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "questionEn",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "questionAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "whyItMatters",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "options",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "answer",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "answerKind",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Discovery interview questions (9 areas). Each row: bilingual question, options JSON, answer, status pending/answered/skipped."
  },
  {
    "name": "Feature",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "module",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "feature",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "user",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "priority",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "rationale",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "origin",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Feature inventory rows (module/feature/user/priority) with review status proposed → accepted/rejected/deferred."
  },
  {
    "name": "Assumption",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "text",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "kind",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "source",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "The assumption register — every tentative assumption, its kind (suggested/uncertain) and open/confirmed/rejected status."
  },
  {
    "name": "Decision",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "action",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "detail",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "stage",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "The audit trail — every action that ever happened on an idea (gates, reviews, express delegation…)."
  },
  {
    "name": "Requirement",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "type",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "category",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "titleAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "description",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "acceptanceCriteria",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "provenance",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "evidence",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "featureId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "priority",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "The Project Contract — FR/NFR rows with acceptance criteria JSON, provenance and proposed/confirmed/rejected/unresolved status."
  },
  {
    "name": "ProcessFlow",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "name",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "nameAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "trigger",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "actors",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "steps",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "businessRules",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "exceptions",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "rationale",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Business process flows: steps JSON, actors, business rules, linked requirements."
  },
  {
    "name": "DataEntity",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "name",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "nameAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "description",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "fields",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "relationships",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "constraints",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "rationale",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Data model entities: fields JSON, relationships, constraints."
  },
  {
    "name": "ApiEndpoint",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "method",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "path",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "purpose",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "auth",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "request",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "response",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "errors",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedEntities",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "API contracts: method, path, request/response/errors JSON, linked requirements/entities."
  },
  {
    "name": "ScreenSpec",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "name",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "nameAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "route",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "purpose",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "roles",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "elements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "states",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "rtlNote",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "UI screen specs: elements, states, roles, RTL notes, linked requirements."
  },
  {
    "name": "ImplTask",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "titleAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "description",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "phase",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "priority",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "dependsOn",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "acceptanceCriteria",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "deliverable",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "requirementCodes",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "estimate",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Implementation plan tasks: phase, dependencies, acceptance criteria, requirement traceability."
  },
  {
    "name": "RiskItem",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "category",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "description",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "likelihood",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "impact",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "mitigation",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "basis",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "The risk register: category, likelihood, impact, mitigation, status."
  },
  {
    "name": "ConsistencyIssue",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "kind",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "severity",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "description",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "affected",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "suggestion",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "detectedBy",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Issues found by the consistency engine/AI: contradiction, omission, broken link… with severity and open/resolved/dismissed status."
  },
  {
    "name": "ArchitectureDoc",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": true,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "components",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "integrations",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "techStack",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "notes",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "basis",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "One per idea: components, integrations, tech stack JSON and notes."
  },
  {
    "name": "ArchTradeStudy",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": true,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "candidates",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "recommended",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "rationale",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Architect Lab — trade-off study: 2-3 candidate architectures (pros/cons/cost/complexity/teamFit/risks) + the reasoned recommendation."
  },
  {
    "name": "ArchDecisionRecord",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "titleAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "context",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "decision",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "alternatives",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "consequences",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Architect Lab — Architecture Decision Records (ADR-01…): context → decision → consequences, with rejected alternatives and requirement traceability."
  },
  {
    "name": "ThreatModelDoc",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": true,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "findings",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "summary",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "residual",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Architect Lab — STRIDE threat model: findings per category (Spoofing/Tampering/Repudiation/Info disclosure/DoS/Elevation) with attack path, risk and mitigation."
  },
  {
    "name": "ScaleReport",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": true,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "assumptions",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "bottlenecks",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "scenarios",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "plan",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Architect Lab — scale report: load assumptions, bottlenecks ordered by what breaks first, and 10x/100x what-if scenarios with actions."
  },
  {
    "name": "TestCaseRecord",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "level",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "kind",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirement",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedCriterion",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "preconditions",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "steps",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "expected",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "priority",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": ""
  },
  {
    "name": "TestCoverageDoc",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": true,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "covered",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "uncovered",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "score",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "note",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": ""
  },
  {
    "name": "EdgeCaseDoc",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": true,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "groups",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "note",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": ""
  },
  {
    "name": "E2eScenarioRecord",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "persona",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "given",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "when",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "then",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "screens",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "priority",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "linkedRequirements",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": ""
  },
  {
    "name": "ConstitutionRule",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "category",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "text",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "origin",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "enabled",
        "type": "Boolean",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "AI Constitution — global (ideaId null) or per-project non-negotiable rules injected into every Context Pack."
  },
  {
    "name": "PromptTemplate",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "titleAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "description",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "descriptionAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "category",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "body",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "tags",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "isBuiltin",
        "type": "Boolean",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "useCount",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "isFavorite",
        "type": "Boolean",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [],
    "description": "Prompt Playbook templates with {{variables}}; builtin or user-authored, useCount, favorite."
  },
  {
    "name": "VerificationRun",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "label",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "codeChars",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "result",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "score",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Traceability Verifier runs: pasted code snapshot, per-check verdicts JSON, deterministic score 0-100."
  },
  {
    "name": "DecisionEntry",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "title",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "titleAr",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "choice",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "rationale",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "alternatives",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "category",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "origin",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "order",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Standing APPROVED decisions (DEC-01…) checked by the Drift Detector and injected into Context Packs."
  },
  {
    "name": "DriftCheck",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "label",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "code",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "codeChars",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "result",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "drifts",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "alignment",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Drift Detector runs: pasted build snapshot, per-decision verdicts JSON, alignment score."
  },
  {
    "name": "SiteAnalysis",
    "fields": [
      {
        "name": "id",
        "type": "String",
        "id": true,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "ideaId",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "url",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "domain",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "status",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "stageDone",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "score",
        "type": "Int",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "error",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "data",
        "type": "String",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "createdAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": true,
        "json": false,
        "optional": false,
        "list": false
      },
      {
        "name": "updatedAt",
        "type": "DateTime",
        "id": false,
        "unique": false,
        "hasDefault": false,
        "json": false,
        "optional": false,
        "list": false
      }
    ],
    "relations": [
      {
        "name": "idea",
        "type": "Idea"
      }
    ],
    "description": "Site Intelligence analyses: 7 gated stages, evidence, unknowns, clone pack, completeness score."
  }
]

export const MODEL_NAMES = ['Idea', 'Question', 'Feature', 'Assumption', 'Decision', 'Requirement', 'ProcessFlow', 'DataEntity', 'ApiEndpoint', 'ScreenSpec', 'ImplTask', 'RiskItem', 'ConsistencyIssue', 'ArchitectureDoc', 'ArchTradeStudy', 'ArchDecisionRecord', 'ThreatModelDoc', 'ScaleReport', 'TestCaseRecord', 'TestCoverageDoc', 'EdgeCaseDoc', 'E2eScenarioRecord', 'ConstitutionRule', 'PromptTemplate', 'VerificationRun', 'DecisionEntry', 'DriftCheck', 'SiteAnalysis'] as const
export type ModelName = (typeof MODEL_NAMES)[number]

export function getModelMeta(name: string): SchemaModel | undefined {
  return SCHEMA_MODELS.find((m) => m.name === name)
}
