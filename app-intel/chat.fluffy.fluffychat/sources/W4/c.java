package W4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: A, reason: collision with root package name */
    public static final b f9025A;

    /* renamed from: B, reason: collision with root package name */
    public static final b f9026B;

    /* renamed from: C, reason: collision with root package name */
    public static final b f9027C;

    /* renamed from: D, reason: collision with root package name */
    public static final b f9028D;

    /* renamed from: E, reason: collision with root package name */
    public static final b f9029E;

    /* renamed from: F, reason: collision with root package name */
    public static final b f9030F;

    /* renamed from: G, reason: collision with root package name */
    public static final b f9031G;

    /* renamed from: H, reason: collision with root package name */
    public static final b f9032H;

    /* renamed from: I, reason: collision with root package name */
    public static final b f9033I;

    /* renamed from: J, reason: collision with root package name */
    public static final b f9034J;

    /* renamed from: K, reason: collision with root package name */
    public static final b f9035K;

    /* renamed from: L, reason: collision with root package name */
    public static final b f9036L;

    /* renamed from: M, reason: collision with root package name */
    public static final b f9037M;

    /* renamed from: N, reason: collision with root package name */
    public static final b f9038N;

    /* renamed from: O, reason: collision with root package name */
    public static final List f9039O;

    /* renamed from: P, reason: collision with root package name */
    public static final List f9040P;

    /* renamed from: Q, reason: collision with root package name */
    public static final Map f9041Q;

    /* renamed from: R, reason: collision with root package name */
    public static final Map f9042R;

    /* renamed from: S, reason: collision with root package name */
    public static final Map f9043S;

    /* renamed from: a, reason: collision with root package name */
    public static final b f9044a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f9045b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f9046c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f9047d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f9048e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f9049f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f9050g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f9051h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f9052i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f9053j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f9054k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f9055l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f9056m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f9057n;

    /* renamed from: o, reason: collision with root package name */
    public static final b f9058o;

    /* renamed from: p, reason: collision with root package name */
    public static final b f9059p;

    /* renamed from: q, reason: collision with root package name */
    public static final b f9060q;

    /* renamed from: r, reason: collision with root package name */
    public static final b f9061r;

    /* renamed from: s, reason: collision with root package name */
    public static final b f9062s;

    /* renamed from: t, reason: collision with root package name */
    public static final b f9063t;

    /* renamed from: u, reason: collision with root package name */
    public static final b f9064u;

    /* renamed from: v, reason: collision with root package name */
    public static final b f9065v;

    /* renamed from: w, reason: collision with root package name */
    public static final b f9066w;

    /* renamed from: x, reason: collision with root package name */
    public static final b f9067x;

    /* renamed from: y, reason: collision with root package name */
    public static final b f9068y;

    /* renamed from: z, reason: collision with root package name */
    public static final b f9069z;

    public class a extends HashMap {
        public a() {
            put(c.f9045b, c.f9044a);
            put(c.f9047d, c.f9046c);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f9070a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9071b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f9072c;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        public boolean a() {
            return this.f9070a.endsWith("=");
        }

        public /* synthetic */ b(String str, String str2, String str3, boolean z7, a aVar) {
            this(str, str2, str3, z7);
        }

        public /* synthetic */ b(String str, String str2, boolean z7, a aVar) {
            this(str, str2, z7);
        }

        public b(String str, String str2) {
            this(str, str2, "io.flutter.embedding.android.", false);
        }

        public b(String str, String str2, boolean z7) {
            this(str, str2, "io.flutter.embedding.android.", z7);
        }

        public b(String str, String str2, String str3, boolean z7) {
            this.f9070a = str;
            this.f9071b = str3 + str2;
            this.f9072c = z7;
        }
    }

    static {
        boolean z7 = true;
        a aVar = null;
        b bVar = new b("--aot-shared-library-name=", "AOTSharedLibraryName", z7, aVar);
        f9044a = bVar;
        b bVar2 = new b("--aot-shared-library-name=", "aot-shared-library-name", "io.flutter.embedding.engine.loader.FlutterLoader.", true, null);
        f9045b = bVar2;
        b bVar3 = new b("--flutter-assets-dir=", "FlutterAssetsDir", z7, aVar);
        f9046c = bVar3;
        b bVar4 = new b("--flutter-assets-dir=", "flutter-assets-dir", "io.flutter.embedding.engine.loader.FlutterLoader.", true, null);
        f9047d = bVar4;
        b bVar5 = new b("--old-gen-heap-size=", "OldGenHeapSize", z7, aVar);
        f9048e = bVar5;
        b bVar6 = new b("--enable-impeller=", "EnableImpeller", z7, aVar);
        f9049f = bVar6;
        b bVar7 = new b("--impeller-backend=", "ImpellerBackend", z7, aVar);
        f9050g = bVar7;
        b bVar8 = new b("--enable-dart-profiling", "EnableDartProfiling", z7, aVar);
        f9051h = bVar8;
        b bVar9 = new b("--profile-startup", "ProfileStartup", z7, aVar);
        f9052i = bVar9;
        b bVar10 = new b("--trace-startup", "TraceStartup", z7, aVar);
        f9053j = bVar10;
        b bVar11 = new b("--merged-platform-ui-thread", "MergedPlatformUIThread", z7, aVar);
        f9054k = bVar11;
        b bVar12 = new b("--vm-snapshot-data=", "VmSnapshotData", z7, aVar);
        f9055l = bVar12;
        b bVar13 = new b("--isolate-snapshot-data=", "IsolateSnapshotData", z7, aVar);
        f9056m = bVar13;
        b bVar14 = new b("--enable-hcpp-and-surface-control", "EnableHcpp", z7, aVar);
        f9057n = bVar14;
        b bVar15 = new b("--enable-flutter-gpu", "EnableFlutterGPU", z7, aVar);
        f9058o = bVar15;
        b bVar16 = new b("--impeller-lazy-shader-mode", "ImpellerLazyShaderInitialization", z7, aVar);
        f9059p = bVar16;
        b bVar17 = new b("--impeller-antialias-lines", "ImpellerAntialiasLines", z7, aVar);
        f9060q = bVar17;
        b bVar18 = new b("--enable-opengl-gpu-tracing", "EnableOpenGLGPUTracing", aVar);
        f9061r = bVar18;
        b bVar19 = new b("--enable-vulkan-gpu-tracing", "EnableVulkanGPUTracing", aVar);
        f9062s = bVar19;
        b bVar20 = new b("--skia-deterministic-rendering", "SkiaDeterministicRendering", aVar);
        f9063t = bVar20;
        b bVar21 = new b("--enable-software-rendering", "EnableSoftwareRendering", aVar);
        f9064u = bVar21;
        b bVar22 = new b("--use-test-fonts", "UseTestFonts", aVar);
        f9065v = bVar22;
        b bVar23 = new b("--vm-service-port=", "VMServicePort", aVar);
        f9066w = bVar23;
        b bVar24 = new b("--enable-vulkan-validation", "EnableVulkanValidation", aVar);
        f9067x = bVar24;
        b bVar25 = new b("--test-flag", "TestFlag", aVar);
        f9068y = bVar25;
        b bVar26 = new b("--leak-vm=", "LeakVM", aVar);
        f9069z = bVar26;
        b bVar27 = new b("--start-paused", "StartPaused", aVar);
        f9025A = bVar27;
        b bVar28 = new b("--disable-service-auth-codes", "DisableServiceAuthCodes", aVar);
        f9026B = bVar28;
        b bVar29 = new b("--disable-service-origin-check", "DisableServiceOriginCheck", aVar);
        f9027C = bVar29;
        b bVar30 = new b("--endless-trace-buffer", "EndlessTraceBuffer", aVar);
        f9028D = bVar30;
        b bVar31 = new b("--trace-skia", "TraceSkia", aVar);
        f9029E = bVar31;
        b bVar32 = new b("--trace-skia-allowlist=", "TraceSkiaAllowList", aVar);
        f9030F = bVar32;
        b bVar33 = new b("--trace-systrace", "TraceSystrace", aVar);
        f9031G = bVar33;
        b bVar34 = new b("--trace-to-file=", "TraceToFile", aVar);
        f9032H = bVar34;
        b bVar35 = new b("--profile-microtasks", "ProfileMicrotasks", aVar);
        f9033I = bVar35;
        b bVar36 = new b("--dump-skp-on-shader-compilation", "DumpSkpOnShaderCompilation", aVar);
        f9034J = bVar36;
        b bVar37 = new b("--purge-persistent-cache", "PurgePersistentCache", aVar);
        f9035K = bVar37;
        b bVar38 = new b("--verbose-logging", "VerboseLogging", aVar);
        f9036L = bVar38;
        b bVar39 = new b("--dart-flags=", "DartFlags", aVar);
        f9037M = bVar39;
        b bVar40 = new b("--no-enable-merged-platform-ui-thread", "DisableMergedPlatformUIThread", aVar);
        f9038N = bVar40;
        List<b> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(bVar23, bVar22, bVar21, bVar20, bVar, bVar3, bVar6, bVar7, bVar24, bVar27, bVar28, bVar29, bVar30, bVar8, bVar9, bVar31, bVar32, bVar33, bVar34, bVar35, bVar36, bVar38, bVar39, bVar11, bVar40, bVar2, bVar4, bVar5, bVar12, bVar13, bVar37, bVar10, bVar26, bVar25, bVar15, bVar16, bVar17, bVar18, bVar19, bVar14));
        f9039O = listUnmodifiableList;
        f9040P = Collections.unmodifiableList(Arrays.asList(bVar40));
        f9041Q = new a();
        HashMap map = new HashMap(listUnmodifiableList.size());
        HashMap map2 = new HashMap(listUnmodifiableList.size());
        for (b bVar41 : listUnmodifiableList) {
            map.put(bVar41.f9070a, bVar41);
            map2.put(bVar41.f9071b, bVar41);
        }
        f9042R = Collections.unmodifiableMap(map);
        f9043S = Collections.unmodifiableMap(map2);
    }

    public static b a(String str) {
        int iIndexOf = str.indexOf(61);
        Map map = f9042R;
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf + 1);
        }
        b bVar = (b) map.get(str);
        b bVarC = c(bVar);
        return bVarC != null ? bVarC : bVar;
    }

    public static b b(String str) {
        b bVarA = a(str);
        if (bVarA == null) {
            bVarA = a("--" + str);
        }
        if (bVarA != null) {
            return bVarA;
        }
        return a("--" + str + "=");
    }

    public static b c(b bVar) {
        return (b) f9041Q.get(bVar);
    }

    public static boolean d(b bVar) {
        return f9040P.contains(bVar);
    }
}
