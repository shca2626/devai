package j4;

import android.content.Context;
import i4.t;

/* loaded from: classes.dex */
public enum e {
    RSA_ECB_OAEPwithSHA_256andMGF1Padding(new f() { // from class: j4.c
        @Override // j4.f
        public final InterfaceC1240b a(Context context, t tVar) {
            return new k(context, tVar);
        }
    }, 23),
    AES_GCM_NoPadding(new f() { // from class: j4.d
        @Override // j4.f
        public final InterfaceC1240b a(Context context, t tVar) {
            return new j(context, tVar);
        }
    }, 23);


    /* renamed from: l, reason: collision with root package name */
    public final f f18749l;

    /* renamed from: m, reason: collision with root package name */
    public final int f18750m;

    e(f fVar, int i7) {
        this.f18749l = fVar;
        this.f18750m = i7;
    }

    public static e d(String str) {
        return "AES_GCM_NoPadding_BIOMETRIC".equals(str) ? AES_GCM_NoPadding : "RSA_ECB_PKCS1Padding".equals(str) ? RSA_ECB_OAEPwithSHA_256andMGF1Padding : valueOf(str);
    }

    public static boolean e(String str) {
        return "RSA_ECB_PKCS1Padding".equals(str);
    }
}
