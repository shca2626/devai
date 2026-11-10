package u3;

import java.io.IOException;
import java.math.BigDecimal;
import w3.AbstractC1731A;
import w3.y;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class u implements v {

    /* renamed from: l, reason: collision with root package name */
    public static final u f22871l = new a("DOUBLE", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final u f22872m = new u("LAZILY_PARSED_NUMBER", 1) { // from class: u3.u.b
        {
            a aVar = null;
        }

        @Override // u3.v
        public Number a(C3.a aVar) {
            return new y(aVar.R());
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final u f22873n = new u("LONG_OR_DOUBLE", 2) { // from class: u3.u.c
        {
            a aVar = null;
        }

        @Override // u3.v
        public Number a(C3.a aVar) throws IOException {
            String strR = aVar.R();
            if (strR.indexOf(46) >= 0) {
                return e(strR, aVar);
            }
            try {
                return Long.valueOf(Long.parseLong(strR));
            } catch (NumberFormatException unused) {
                return e(strR, aVar);
            }
        }

        public final Number e(String str, C3.a aVar) throws C3.d, NumberFormatException {
            try {
                Double dValueOf = Double.valueOf(str);
                if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                    if (!aVar.C()) {
                        throw new C3.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.x());
                    }
                }
                return dValueOf;
            } catch (NumberFormatException e7) {
                throw new C1658n("Cannot parse " + str + "; at path " + aVar.x(), e7);
            }
        }
    };

    /* renamed from: o, reason: collision with root package name */
    public static final u f22874o = new u("BIG_DECIMAL", 3) { // from class: u3.u.d
        {
            a aVar = null;
        }

        @Override // u3.v
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(C3.a aVar) throws IOException {
            String strR = aVar.R();
            try {
                return AbstractC1731A.b(strR);
            } catch (NumberFormatException e7) {
                throw new C1658n("Cannot parse " + strR + "; at path " + aVar.x(), e7);
            }
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ u[] f22875p = d();

    public enum a extends u {
        public a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // u3.v
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double a(C3.a aVar) {
            return Double.valueOf(aVar.H());
        }
    }

    public u(String str, int i7) {
    }

    public static /* synthetic */ u[] d() {
        return new u[]{f22871l, f22872m, f22873n, f22874o};
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f22875p.clone();
    }

    public /* synthetic */ u(String str, int i7, a aVar) {
        this(str, i7);
    }
}
