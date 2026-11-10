package k3;

/* loaded from: classes.dex */
public abstract class C extends AbstractC1258B {

    public class a extends AbstractC1279v {
        public a() {
        }

        @Override // java.util.List
        public Object get(int i7) {
            return C.this.get(i7);
        }

        @Override // k3.AbstractC1277t
        public boolean k() {
            return C.this.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return C.this.size();
        }
    }

    @Override // k3.AbstractC1277t
    public int g(Object[] objArr, int i7) {
        return f().g(objArr, i7);
    }

    public abstract Object get(int i7);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: l */
    public h0 iterator() {
        return f().iterator();
    }

    @Override // k3.AbstractC1258B
    public AbstractC1279v s() {
        return new a();
    }
}
