package X4;

import a5.C0765d;
import android.content.res.AssetManager;
import h5.b;
import h5.q;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.List;
import u5.C1669d;

/* loaded from: classes.dex */
public class a implements h5.b {

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f9296a;

    /* renamed from: b, reason: collision with root package name */
    public final AssetManager f9297b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9298c;

    /* renamed from: d, reason: collision with root package name */
    public final X4.c f9299d;

    /* renamed from: e, reason: collision with root package name */
    public final h5.b f9300e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9301f;

    /* renamed from: g, reason: collision with root package name */
    public String f9302g;

    /* renamed from: h, reason: collision with root package name */
    public final b.a f9303h;

    /* renamed from: X4.a$a, reason: collision with other inner class name */
    public class C0080a implements b.a {
        public C0080a() {
        }

        @Override // h5.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
            a.this.f9302g = q.f16913b.b(byteBuffer);
            a.h(a.this);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final AssetManager f9305a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9306b;

        /* renamed from: c, reason: collision with root package name */
        public final FlutterCallbackInformation f9307c;

        public b(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.f9305a = assetManager;
            this.f9306b = str;
            this.f9307c = flutterCallbackInformation;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.f9306b + ", library path: " + this.f9307c.callbackLibraryPath + ", function: " + this.f9307c.callbackName + " )";
        }
    }

    public static class d implements h5.b {

        /* renamed from: a, reason: collision with root package name */
        public final X4.c f9311a;

        public /* synthetic */ d(X4.c cVar, C0080a c0080a) {
            this(cVar);
        }

        @Override // h5.b
        public b.c a(b.d dVar) {
            return this.f9311a.a(dVar);
        }

        @Override // h5.b
        public void b(String str, b.a aVar) {
            this.f9311a.b(str, aVar);
        }

        @Override // h5.b
        public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
            this.f9311a.d(str, byteBuffer, interfaceC0193b);
        }

        @Override // h5.b
        public void e(String str, ByteBuffer byteBuffer) {
            this.f9311a.d(str, byteBuffer, null);
        }

        @Override // h5.b
        public void f(String str, b.a aVar, b.c cVar) {
            this.f9311a.f(str, aVar, cVar);
        }

        public d(X4.c cVar) {
            this.f9311a = cVar;
        }
    }

    public interface e {
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager, long j7) {
        this.f9301f = false;
        C0080a c0080a = new C0080a();
        this.f9303h = c0080a;
        this.f9296a = flutterJNI;
        this.f9297b = assetManager;
        this.f9298c = j7;
        X4.c cVar = new X4.c(flutterJNI);
        this.f9299d = cVar;
        cVar.b("flutter/isolate", c0080a);
        this.f9300e = new d(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f9301f = true;
        }
    }

    public static /* synthetic */ e h(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // h5.b
    public b.c a(b.d dVar) {
        return this.f9300e.a(dVar);
    }

    @Override // h5.b
    public void b(String str, b.a aVar) {
        this.f9300e.b(str, aVar);
    }

    @Override // h5.b
    public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
        this.f9300e.d(str, byteBuffer, interfaceC0193b);
    }

    @Override // h5.b
    public void e(String str, ByteBuffer byteBuffer) {
        this.f9300e.e(str, byteBuffer);
    }

    @Override // h5.b
    public void f(String str, b.a aVar, b.c cVar) {
        this.f9300e.f(str, aVar, cVar);
    }

    public void i(b bVar) {
        if (this.f9301f) {
            U4.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        C1669d c1669dJ = C1669d.j("DartExecutor#executeDartCallback");
        try {
            U4.b.f("DartExecutor", "Executing Dart callback: " + bVar);
            FlutterJNI flutterJNI = this.f9296a;
            String str = bVar.f9306b;
            FlutterCallbackInformation flutterCallbackInformation = bVar.f9307c;
            flutterJNI.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, bVar.f9305a, null, this.f9298c);
            this.f9301f = true;
            if (c1669dJ != null) {
                c1669dJ.close();
            }
        } finally {
        }
    }

    public void j(c cVar) {
        k(cVar, null);
    }

    public void k(c cVar, List list) {
        if (this.f9301f) {
            U4.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        C1669d c1669dJ = C1669d.j("DartExecutor#executeDartEntrypoint");
        try {
            U4.b.f("DartExecutor", "Executing Dart entrypoint: " + cVar);
            this.f9296a.runBundleAndSnapshotFromLibrary(cVar.f9308a, cVar.f9310c, cVar.f9309b, this.f9297b, list, this.f9298c);
            this.f9301f = true;
            if (c1669dJ != null) {
                c1669dJ.close();
            }
        } finally {
        }
    }

    public h5.b l() {
        return this.f9300e;
    }

    public boolean m() {
        return this.f9301f;
    }

    public void n() {
        if (this.f9296a.isAttached()) {
            this.f9296a.notifyLowMemoryWarning();
        }
    }

    public void o() {
        U4.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f9296a.setPlatformMessageHandler(this.f9299d);
    }

    public void p() {
        U4.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f9296a.setPlatformMessageHandler(null);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f9308a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9309b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9310c;

        public c(String str, String str2) {
            this.f9308a = str;
            this.f9309b = null;
            this.f9310c = str2;
        }

        public static c a() {
            C0765d c0765dC = U4.a.e().c();
            if (c0765dC.p()) {
                return new c(c0765dC.h(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f9308a.equals(cVar.f9308a)) {
                return this.f9310c.equals(cVar.f9310c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f9308a.hashCode() * 31) + this.f9310c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f9308a + ", function: " + this.f9310c + " )";
        }

        public c(String str, String str2, String str3) {
            this.f9308a = str;
            this.f9309b = str2;
            this.f9310c = str3;
        }
    }
}
