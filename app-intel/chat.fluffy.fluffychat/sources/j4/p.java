package j4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import i4.t;
import i4.y;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public class p {

    /* renamed from: f, reason: collision with root package name */
    public static final e f18762f = e.RSA_ECB_OAEPwithSHA_256andMGF1Padding;

    /* renamed from: g, reason: collision with root package name */
    public static final o f18763g = o.AES_GCM_NoPadding;

    /* renamed from: a, reason: collision with root package name */
    public final e f18764a;

    /* renamed from: b, reason: collision with root package name */
    public final o f18765b;

    /* renamed from: c, reason: collision with root package name */
    public final e f18766c;

    /* renamed from: d, reason: collision with root package name */
    public final o f18767d;

    /* renamed from: e, reason: collision with root package name */
    public final t f18768e;

    public p(y yVar, String str, String str2, t tVar) {
        this.f18768e = tVar;
        String strE = yVar.e("FlutterSecureSAlgorithmKey", null);
        String strE2 = yVar.e("FlutterSecureSAlgorithmStorage", null);
        if (strE == null || strE2 == null) {
            this.f18764a = f18762f;
            this.f18765b = f18763g;
        } else {
            this.f18764a = e.d(strE);
            this.f18765b = o.d(strE2);
        }
        o oVarD = o.d(str2);
        int i7 = oVarD.f18761l;
        int i8 = Build.VERSION.SDK_INT;
        this.f18767d = i7 > i8 ? f18763g : oVarD;
        e eVarD = e.d(str);
        this.f18766c = eVarD.f18751m > i8 ? f18762f : eVarD;
        if ((strE == null || strE2 == null) && !tVar.w()) {
            SharedPreferences.Editor editorB = yVar.b();
            m(editorB);
            editorB.apply();
        }
    }

    public static String j(y yVar) {
        return yVar.e("FlutterSecureSAlgorithmKey", null);
    }

    public static String k(y yVar) {
        return yVar.e("FlutterSecureSAlgorithmStorage", null);
    }

    public boolean a() {
        return this.f18764a != this.f18766c;
    }

    public n b(Context context, InterfaceC1241b interfaceC1241b, Cipher cipher, o oVar) throws Exception {
        if (oVar == o.AES_GCM_NoPadding) {
            return i(interfaceC1241b) ? new r(context, interfaceC1241b, cipher, this.f18768e) : new s(context, interfaceC1241b, cipher, this.f18768e);
        }
        oVar.getClass();
        throw new Exception("No implementation available for algorithm: " + oVar.name());
    }

    public e c() {
        return this.f18766c;
    }

    public InterfaceC1241b d(Context context) {
        return this.f18766c.f18750l.a(context, this.f18768e);
    }

    public n e(Context context, Cipher cipher) {
        return b(context, this.f18766c.f18750l.a(context, this.f18768e), cipher, this.f18767d);
    }

    public e f() {
        return this.f18764a;
    }

    public InterfaceC1241b g(Context context) {
        return this.f18764a.f18750l.a(context, this.f18768e);
    }

    public n h(Context context, Cipher cipher) {
        return b(context, this.f18764a.f18750l.a(context, this.f18768e), cipher, this.f18765b);
    }

    public final boolean i(InterfaceC1241b interfaceC1241b) {
        return interfaceC1241b instanceof j;
    }

    public boolean l() {
        return (this.f18764a == this.f18766c && this.f18765b == this.f18767d) ? false : true;
    }

    public void m(SharedPreferences.Editor editor) {
        editor.putString("FlutterSecureSAlgorithmKey", this.f18766c.name());
        editor.putString("FlutterSecureSAlgorithmStorage", this.f18767d.name());
    }
}
