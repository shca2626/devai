package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f11820a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    private DataSetObserver f11821b;

    public abstract void a(ViewGroup viewGroup, int i12, Object obj);

    @Deprecated
    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public int e(Object obj) {
        return -1;
    }

    public CharSequence f(int i12) {
        return null;
    }

    public float g(int i12) {
        return 1.0f;
    }

    public abstract Object h(ViewGroup viewGroup, int i12);

    public abstract boolean i(View view, Object obj);

    public void j() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f11821b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f11820a.notifyChanged();
    }

    public void k(DataSetObserver dataSetObserver) {
        this.f11820a.registerObserver(dataSetObserver);
    }

    public void l(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable m() {
        return null;
    }

    @Deprecated
    public void n(View view, int i12, Object obj) {
    }

    public void o(ViewGroup viewGroup, int i12, Object obj) {
        n(viewGroup, i12, obj);
    }

    void p(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f11821b = dataSetObserver;
        }
    }

    @Deprecated
    public void q(View view) {
    }

    public void r(ViewGroup viewGroup) {
        q(viewGroup);
    }

    public void s(DataSetObserver dataSetObserver) {
        this.f11820a.unregisterObserver(dataSetObserver);
    }
}
