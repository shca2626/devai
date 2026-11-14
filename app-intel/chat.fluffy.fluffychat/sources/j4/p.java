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
    public static final e f18761f = e.RSA_ECB_OAEPwithSHA_256andMGF1Padding;

    /* renamed from: g, reason: collision with root package name */
    public static final o f18762g = o.AES_GCM_NoPadding;

    /* renamed from: a, reason: collision with root package name */
    public final e f18763a;

    /* renamed from: b, reason: collision with root package name */
    public final o f18764b;

    /* renamed from: c, reason: collision with root package name */
    public final e f18765c;

    /* renamed from: d, reason: collision with root package name */
    public final o f18766d;

    /* renamed from: e, reason: collision with root package name */
    public final t f18767e;

    public p(y yVar, String str, String str2, t tVar) {
        this.f18767e = tVar;
        String strE = yVar.e("FlutterSecureSAlgorithmKey", null);
        String strE2 = yVar.e("FlutterSecureSAlgorithmStorage", null);
        if (strE == null || strE2 == null) {
            this.f18763a = f18761f;
            this.f18764b = f18762g;
        } else {
            this.f18763a = e.d(strE);
            this.f18764b = o.d(strE2);
        }
        o oVarD = o.d(str2);
        int i7 = oVarD.f18760l;
        int i8 = Build.VERSION.SDK_INT;
        this.f18766d = i7 > i8 ? f18762g : oVarD;
        e eVarD = e.d(str);
        this.f18765c = eVarD.f18750m > i8 ? f18761f : eVarD;
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
        return this.f18763a != this.f18765c;
    }

    public n b(Context context, InterfaceC1240b interfaceC1240b, Cipher cipher, o oVar) throws Exception {
        if (oVar == o.AES_GCM_NoPadding) {
            return i(interfaceC1240b) ? new r(context, interfaceC1240b, cipher, this.f18767e) : new s(context, interfaceC1240b, cipher, this.f18767e);
        }
        oVar.getClass();
        throw new Exception("No implementation available for algorithm: " + oVar.name());
    }

    public e c() {
        return this.f18765c;
    }

    public InterfaceC1240b d(Context context) {
        return this.f18765c.f18749l.a(context, this.f18767e);
    }

    public n e(Context context, Cipher cipher) {
        return b(context, this.f18765c.f18749l.a(context, this.f18767e), cipher, this.f18766d);
    }

    public e f() {
        return this.f18763a;
    }

    public InterfaceC1240b g(Context context) {
        return this.f18763a.f18749l.a(context, this.f18767e);
    }

    public n h(Context context, Cipher cipher) {
        return b(context, this.f18763a.f18749l.a(context, this.f18767e), cipher, this.f18764b);
    }

    public final boolean i(InterfaceC1240b interfaceC1240b) {
        return interfaceC1240b instanceof j;
    }

    public boolean l() {
        return (this.f18763a == this.f18765c && this.f18764b == this.f18766d) ? false : true;
    }

    public void m(SharedPreferences.Editor editor) {
        editor.putString("FlutterSecureSAlgorithmKey", this.f18765c.name());
        editor.putString("FlutterSecureSAlgorithmStorage", this.f18766d.name());
    }
}
