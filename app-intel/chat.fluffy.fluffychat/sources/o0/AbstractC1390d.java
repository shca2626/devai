package o0;

import android.os.Bundle;
import o0.C1387a;

/* renamed from: o0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1390d {

    /* renamed from: o0.d$a */
    public static abstract class a {
        public abstract AbstractC1390d a();

        public AbstractC1390d b() {
            AbstractC1390d abstractC1390dA = a();
            if (abstractC1390dA.c().length() > 100) {
                throw new IllegalStateException(String.format("Key length can be at most %s", 100));
            }
            if (abstractC1390dA.d() != null && abstractC1390dA.d().length() > 1000) {
                throw new IllegalStateException(String.format("Message length can be at most %s", 1000));
            }
            if (abstractC1390dA.b() != null && abstractC1390dA.b().length() > 1000) {
                throw new IllegalStateException(String.format("Data length can be at most %s", 1000));
            }
            if (abstractC1390dA.e() == 2 || abstractC1390dA.e() == 1) {
                return abstractC1390dA;
            }
            throw new IllegalStateException("Severity must be SEVERITY_ERROR or SEVERITY_INFO");
        }

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);

        public abstract a f(int i7);
    }

    public static a a() {
        return new C1387a.b().f(1);
    }

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract int e();

    public Bundle f() {
        Bundle bundle = new Bundle();
        bundle.putString("androidx.enterprise.feedback.APP_STATE_KEY", c());
        bundle.putInt("androidx.enterprise.feedback.APP_STATE_SEVERITY", e());
        if (d() != null) {
            bundle.putString("androidx.enterprise.feedback.APP_STATE_MESSAGE", d());
        }
        if (b() != null) {
            bundle.putString("androidx.enterprise.feedback.APP_STATE_DATA", b());
        }
        return bundle;
    }
}
