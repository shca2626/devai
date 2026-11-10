package Z;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;

/* loaded from: classes.dex */
public class Q {

    /* renamed from: a, reason: collision with root package name */
    public final d f9957a;

    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public final ScrollFeedbackProvider f9958a;

        public b(View view) {
            this.f9958a = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // Z.Q.d
        public void onScrollLimit(int i7, int i8, int i9, boolean z7) {
            this.f9958a.onScrollLimit(i7, i8, i9, z7);
        }

        @Override // Z.Q.d
        public void onScrollProgress(int i7, int i8, int i9, int i10) {
            this.f9958a.onScrollProgress(i7, i8, i9, i10);
        }
    }

    public interface d {
        void onScrollLimit(int i7, int i8, int i9, boolean z7);

        void onScrollProgress(int i7, int i8, int i9, int i10);
    }

    public Q(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f9957a = new b(view);
        } else {
            this.f9957a = new c();
        }
    }

    public static Q a(View view) {
        return new Q(view);
    }

    public void b(int i7, int i8, int i9, boolean z7) {
        this.f9957a.onScrollLimit(i7, i8, i9, z7);
    }

    public void c(int i7, int i8, int i9, int i10) {
        this.f9957a.onScrollProgress(i7, i8, i9, i10);
    }

    public static class c implements d {
        public c() {
        }

        @Override // Z.Q.d
        public void onScrollLimit(int i7, int i8, int i9, boolean z7) {
        }

        @Override // Z.Q.d
        public void onScrollProgress(int i7, int i8, int i9, int i10) {
        }
    }
}
