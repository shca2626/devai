package Z;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public final c f9959a;

    public static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final View f9960a;

        public a(View view) {
            this.f9960a = view;
        }
    }

    public static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public View f9961b;

        public b(View view) {
            super(view);
            this.f9961b = view;
        }
    }

    public static class c {
    }

    public S(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f9959a = new b(view);
        } else {
            this.f9959a = new a(view);
        }
    }
}
