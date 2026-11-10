package g1;

/* loaded from: classes.dex */
public interface N {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final O f15966a;

        /* renamed from: b, reason: collision with root package name */
        public final O f15967b;

        public a(O o7) {
            this(o7, o7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f15966a.equals(aVar.f15966a) && this.f15967b.equals(aVar.f15967b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f15966a.hashCode() * 31) + this.f15967b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f15966a);
            if (this.f15966a.equals(this.f15967b)) {
                str = "";
            } else {
                str = ", " + this.f15967b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(O o7, O o8) {
            this.f15966a = (O) j3.o.q(o7);
            this.f15967b = (O) j3.o.q(o8);
        }
    }

    public static class b implements N {

        /* renamed from: a, reason: collision with root package name */
        public final long f15968a;

        /* renamed from: b, reason: collision with root package name */
        public final a f15969b;

        public b(long j7) {
            this(j7, 0L);
        }

        @Override // g1.N
        public boolean e() {
            return false;
        }

        @Override // g1.N
        public a g(long j7) {
            return this.f15969b;
        }

        @Override // g1.N
        public long i() {
            return this.f15968a;
        }

        public b(long j7, long j8) {
            this.f15968a = j7;
            this.f15969b = new a(j8 == 0 ? O.f15970c : new O(0L, j8));
        }
    }

    boolean e();

    default boolean f() {
        return false;
    }

    a g(long j7);

    long i();
}
