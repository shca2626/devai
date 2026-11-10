package c5;

import android.content.Context;
import io.flutter.plugin.platform.InterfaceC1181m;
import io.flutter.view.TextureRegistry;

/* renamed from: c5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0910a {

    /* renamed from: c5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0140a {
    }

    /* renamed from: c5.a$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f14038a;

        /* renamed from: b, reason: collision with root package name */
        public final io.flutter.embedding.engine.a f14039b;

        /* renamed from: c, reason: collision with root package name */
        public final h5.b f14040c;

        /* renamed from: d, reason: collision with root package name */
        public final TextureRegistry f14041d;

        /* renamed from: e, reason: collision with root package name */
        public final InterfaceC1181m f14042e;

        /* renamed from: f, reason: collision with root package name */
        public final InterfaceC0140a f14043f;

        /* renamed from: g, reason: collision with root package name */
        public final io.flutter.embedding.engine.b f14044g;

        public b(Context context, io.flutter.embedding.engine.a aVar, h5.b bVar, TextureRegistry textureRegistry, InterfaceC1181m interfaceC1181m, InterfaceC0140a interfaceC0140a, io.flutter.embedding.engine.b bVar2) {
            this.f14038a = context;
            this.f14039b = aVar;
            this.f14040c = bVar;
            this.f14041d = textureRegistry;
            this.f14042e = interfaceC1181m;
            this.f14043f = interfaceC0140a;
            this.f14044g = bVar2;
        }

        public Context a() {
            return this.f14038a;
        }

        public h5.b b() {
            return this.f14040c;
        }

        public io.flutter.embedding.engine.a c() {
            return this.f14039b;
        }

        public InterfaceC1181m d() {
            return this.f14042e;
        }

        public TextureRegistry e() {
            return this.f14041d;
        }
    }

    void onAttachedToEngine(b bVar);

    void onDetachedFromEngine(b bVar);
}
