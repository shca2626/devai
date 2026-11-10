package O0;

import E0.M;
import android.util.SparseArray;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f6674a = new SparseArray();

    public M a(int i7) {
        M m7 = (M) this.f6674a.get(i7);
        if (m7 != null) {
            return m7;
        }
        M m8 = new M(9223372036854775806L);
        this.f6674a.put(i7, m8);
        return m8;
    }

    public void b() {
        this.f6674a.clear();
    }
}
