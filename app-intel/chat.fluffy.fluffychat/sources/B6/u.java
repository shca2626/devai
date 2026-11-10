package B6;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class u {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1207b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f1208a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public u(Context context) {
        M5.m.e(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("unifiedpush.connector", 0);
        M5.m.d(sharedPreferences, "getSharedPreferences(...)");
        this.f1208a = sharedPreferences;
    }

    public final void a(L5.l lVar) {
        M5.m.e(lVar, "block");
        String string = this.f1208a.getString("unifiedpush.distributor", null);
        boolean z7 = this.f1208a.getBoolean("unifiedpush.distributor_ack", false);
        if (string == null || ((Boolean) lVar.a(new C6.d(string, z7))).booleanValue()) {
            this.f1208a.edit().remove("unifiedpush.distributor").remove("unifiedpush.distributor_ack").apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r17, L5.l r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "block"
            M5.m.e(r2, r3)
            android.content.SharedPreferences r3 = r0.f1208a
            java.lang.String r4 = "unifiedpush.instances"
            r5 = 0
            java.util.Set r3 = r3.getStringSet(r4, r5)
            r6 = 0
            if (r3 == 0) goto Ld5
            java.util.Iterator r3 = r3.iterator()
        L1b:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto Ld5
            java.lang.Object r7 = r3.next()
            java.lang.String r7 = (java.lang.String) r7
            android.content.SharedPreferences r8 = r0.f1208a
            java.lang.Object[] r9 = new java.lang.Object[]{r7}
            r10 = 1
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r10)
            java.lang.String r11 = "%s/unifiedpush.connector"
            java.lang.String r9 = java.lang.String.format(r11, r9)
            java.lang.String r12 = "format(...)"
            M5.m.d(r9, r12)
            java.lang.String r8 = r8.getString(r9, r5)
            android.content.SharedPreferences r9 = r0.f1208a
            java.lang.Object[] r13 = new java.lang.Object[]{r7}
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r10)
            java.lang.String r14 = "%s/unifiedpush.message"
            java.lang.String r13 = java.lang.String.format(r14, r13)
            M5.m.d(r13, r12)
            java.lang.String r9 = r9.getString(r13, r5)
            android.content.SharedPreferences r13 = r0.f1208a
            java.lang.Object[] r15 = new java.lang.Object[]{r7}
            java.lang.Object[] r15 = java.util.Arrays.copyOf(r15, r10)
            java.lang.String r10 = "%s/unifiedpush.vapid"
            java.lang.String r15 = java.lang.String.format(r10, r15)
            M5.m.d(r15, r12)
            java.lang.String r13 = r13.getString(r15, r5)
            if (r8 == 0) goto L8f
            if (r1 == 0) goto L8f
            C6.b r15 = new C6.b
            C6.e r5 = new C6.e
            M5.m.b(r7)
            r5.<init>(r7, r9, r13)
            r15.<init>(r1, r8, r5)
            java.lang.Object r5 = r2.a(r15)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L8d
            goto L8f
        L8d:
            r6 = 1
            goto Ld2
        L8f:
            android.content.SharedPreferences r5 = r0.f1208a
            android.content.SharedPreferences$Editor r5 = r5.edit()
            java.lang.Object[] r8 = new java.lang.Object[]{r7}
            r9 = 1
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.lang.String r8 = java.lang.String.format(r11, r8)
            M5.m.d(r8, r12)
            android.content.SharedPreferences$Editor r5 = r5.remove(r8)
            java.lang.Object[] r8 = new java.lang.Object[]{r7}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.lang.String r8 = java.lang.String.format(r10, r8)
            M5.m.d(r8, r12)
            android.content.SharedPreferences$Editor r5 = r5.remove(r8)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r9)
            java.lang.String r7 = java.lang.String.format(r14, r7)
            M5.m.d(r7, r12)
            android.content.SharedPreferences$Editor r5 = r5.remove(r7)
            r5.apply()
        Ld2:
            r5 = 0
            goto L1b
        Ld5:
            if (r6 != 0) goto Le4
            android.content.SharedPreferences r1 = r0.f1208a
            android.content.SharedPreferences$Editor r1 = r1.edit()
            android.content.SharedPreferences$Editor r1 = r1.remove(r4)
            r1.apply()
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B6.u.b(java.lang.String, L5.l):void");
    }

    public final void c(String str, L5.l lVar) {
        M5.m.e(str, "instance");
        M5.m.e(lVar, "block");
        SharedPreferences sharedPreferences = this.f1208a;
        String str2 = String.format("%s/unifiedpush.webpush.auth", Arrays.copyOf(new Object[]{str}, 1));
        M5.m.d(str2, "format(...)");
        String string = sharedPreferences.getString(str2, null);
        SharedPreferences sharedPreferences2 = this.f1208a;
        String str3 = String.format("%s/unifiedpush.webpush.pubkey", Arrays.copyOf(new Object[]{str}, 1));
        M5.m.d(str3, "format(...)");
        String string2 = sharedPreferences2.getString(str3, null);
        SharedPreferences sharedPreferences3 = this.f1208a;
        String str4 = String.format("%s/unifiedpush.webpush.privkey", Arrays.copyOf(new Object[]{str}, 1));
        M5.m.d(str4, "format(...)");
        String string3 = sharedPreferences3.getString(str4, null);
        SharedPreferences sharedPreferences4 = this.f1208a;
        String str5 = String.format("%s/unifiedpush.webpush.iv", Arrays.copyOf(new Object[]{str}, 1));
        M5.m.d(str5, "format(...)");
        String string4 = sharedPreferences4.getString(str5, null);
        if (string == null || string2 == null || string3 == null || ((Boolean) lVar.a(new C6.f(str, string, string2, string3, string4))).booleanValue()) {
            SharedPreferences.Editor editorEdit = this.f1208a.edit();
            String str6 = String.format("%s/unifiedpush.webpush.auth", Arrays.copyOf(new Object[]{str}, 1));
            M5.m.d(str6, "format(...)");
            SharedPreferences.Editor editorRemove = editorEdit.remove(str6);
            String str7 = String.format("%s/unifiedpush.webpush.pubkey", Arrays.copyOf(new Object[]{str}, 1));
            M5.m.d(str7, "format(...)");
            SharedPreferences.Editor editorRemove2 = editorRemove.remove(str7);
            String str8 = String.format("%s/unifiedpush.webpush.privkey", Arrays.copyOf(new Object[]{str}, 1));
            M5.m.d(str8, "format(...)");
            SharedPreferences.Editor editorRemove3 = editorRemove2.remove(str8);
            String str9 = String.format("%s/unifiedpush.webpush.iv", Arrays.copyOf(new Object[]{str}, 1));
            M5.m.d(str9, "format(...)");
            editorRemove3.remove(str9).apply();
        }
    }
}
