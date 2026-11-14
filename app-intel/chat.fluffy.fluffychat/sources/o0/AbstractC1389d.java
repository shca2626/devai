package o0;

import android.os.Bundle;
import o0.C1386a;

/* renamed from: o0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1389d {

    /* renamed from: o0.d$a */
    public static abstract class a {
        public abstract AbstractC1389d a();

        public AbstractC1389d b() {
            AbstractC1389d abstractC1389dA = a();
            if (abstractC1389dA.c().length() > 100) {
                throw new IllegalStateException(String.format("Key length can be at most %s", 100));
            }
            if (abstractC1389dA.d() != null && abstractC1389dA.d().length() > 1000) {
                throw new IllegalStateException(String.format("Message length can be at most %s", 1000));
            }
            if (abstractC1389dA.b() != null && abstractC1389dA.b().length() > 1000) {
                throw new IllegalStateException(String.format("Data length can be at most %s", 1000));
            }
            if (abstractC1389dA.e() == 2 || abstractC1389dA.e() == 1) {
                return abstractC1389dA;
            }
            throw new IllegalStateException("Severity must be SEVERITY_ERROR or SEVERITY_INFO");
        }

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);

        public abstract a f(int i7);
    }

    public static a a() {
        return new C1386a.b().f(1);
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
