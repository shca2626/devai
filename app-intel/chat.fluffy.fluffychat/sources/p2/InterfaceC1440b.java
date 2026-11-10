package p2;

import android.graphics.Bitmap;

/* renamed from: p2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1440b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f20754a = a.f20755a;

    /* renamed from: p2.b$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f20755a = new a();

        public final InterfaceC1440b a() {
            return new j();
        }
    }

    void b(Bitmap bitmap);

    Bitmap c(int i7, int i8, Bitmap.Config config);

    Bitmap removeLast();
}
