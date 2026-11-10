package c3;

import android.graphics.Typeface;

/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0901a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f13963a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0139a f13964b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13965c;

    /* renamed from: c3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0139a {
        void a(Typeface typeface);
    }

    public C0901a(InterfaceC0139a interfaceC0139a, Typeface typeface) {
        this.f13963a = typeface;
        this.f13964b = interfaceC0139a;
    }

    @Override // c3.f
    public void a(int i7) {
        d(this.f13963a);
    }

    @Override // c3.f
    public void b(Typeface typeface, boolean z7) {
        d(typeface);
    }

    public void c() {
        this.f13965c = true;
    }

    public final void d(Typeface typeface) {
        if (this.f13965c) {
            return;
        }
        this.f13964b.a(typeface);
    }
}
