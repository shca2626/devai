// db.ts — data layer
import mongoose from 'mongoose' // DEC-01 said Prisma + SQLite!
export async function connect() {
  await mongoose.connect(process.env.MONGO_URL || 'mongodb://localhost:27017/shop')
}

// layout.tsx — root layout
export default function RootLayout({ children }) {
  return (
    <html lang="ar" dir="rtl">
      <body className="font-arabic antialiased">{children}</body>
    </html>
  )
}
