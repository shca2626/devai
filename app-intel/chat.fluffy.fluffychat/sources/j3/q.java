package j3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class q {

    public static class b implements p, Serializable {

        /* renamed from: l, reason: collision with root package name */
        public final List f18721l;

        @Override // j3.p
        public boolean apply(Object obj) {
            for (int i7 = 0; i7 < this.f18721l.size(); i7++) {
                if (!((p) this.f18721l.get(i7)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f18721l.equals(((b) obj).f18721l);
            }
            return false;
        }

        public int hashCode() {
            return this.f18721l.hashCode() + 306654252;
        }

        public String toString() {
            return q.e("and", this.f18721l);
        }

        public b(List list) {
            this.f18721l = list;
        }
    }

    public static p b() {
        return c.f18722l.d();
    }

    public static p c(p pVar, p pVar2) {
        return new b(d((p) o.q(pVar), (p) o.q(pVar2)));
    }

    public static List d(p pVar, p pVar2) {
        return Arrays.asList(pVar, pVar2);
    }

    public static String e(String str, Iterable iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z7 = true;
        for (Object obj : iterable) {
            if (!z7) {
                sb.append(',');
            }
            sb.append(obj);
            z7 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class c implements p {

        /* renamed from: l, reason: collision with root package name */
        public static final c f18722l = new a("ALWAYS_TRUE", 0);

        /* renamed from: m, reason: collision with root package name */
        public static final c f18723m = new b("ALWAYS_FALSE", 1);

        /* renamed from: n, reason: collision with root package name */
        public static final c f18724n = new C0209c("IS_NULL", 2);

        /* renamed from: o, reason: collision with root package name */
        public static final c f18725o = new d("NOT_NULL", 3);

        /* renamed from: p, reason: collision with root package name */
        public static final /* synthetic */ c[] f18726p = a();

        public enum a extends c {
            public a(String str, int i7) {
                super(str, i7);
            }

            @Override // j3.p
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        public enum b extends c {
            public b(String str, int i7) {
                super(str, i7);
            }

            @Override // j3.p
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* renamed from: j3.q$c$c, reason: collision with other inner class name */
        public enum C0209c extends c {
            public C0209c(String str, int i7) {
                super(str, i7);
            }

            @Override // j3.p
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        public enum d extends c {
            public d(String str, int i7) {
                super(str, i7);
            }

            @Override // j3.p
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        public c(String str, int i7) {
        }

        public static /* synthetic */ c[] a() {
            return new c[]{f18722l, f18723m, f18724n, f18725o};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f18726p.clone();
        }

        public p d() {
            return this;
        }
    }
}
