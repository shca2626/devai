// Pure prompt-template helpers — shared by the server engine
// and client components (no server-only imports allowed here).

/** Extract unique {{variable}} names from a template body. */
export function templateVariables(body: string): string[] {
  const matches = body.match(/\{\{\s*([a-zA-Z_][a-zA-Z0-9_]*)\s*\}\}/g) ?? []
  return [...new Set(matches.map((m) => m.replace(/[{}\s]/g, '')))]
}

/** Substitute {{variable}} placeholders; unfilled ones stay visible. */
export function expandTemplate(body: string, values: Record<string, string>): string {
  return body.replace(/\{\{\s*([a-zA-Z_][a-zA-Z0-9_]*)\s*\}\}/g, (whole, name: string) =>
    values[name]?.trim() ? values[name] : whole
  )
}
