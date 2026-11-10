package io.flutter.embedding.engine.renderer;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.SyncFence;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import h.InterfaceC1116a;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class FlutterRenderer implements TextureRegistry {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f17610i = false;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f17611j = false;

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f17612a;

    /* renamed from: c, reason: collision with root package name */
    public Surface f17614c;

    /* renamed from: h, reason: collision with root package name */
    public final n f17619h;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f17613b = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name */
    public boolean f17615d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f17616e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    public final Set f17617f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final List f17618g = new ArrayList();

    @InterfaceC1116a
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.b {
        private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
        private static final int MAX_DEQUEUED_IMAGES = 2;
        private static final int MAX_IMAGES = 7;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private static final boolean VERBOSE_LOGS = false;
        private static final boolean trimOnMemoryPressure = true;
        private final long id;
        private boolean released;
        private boolean ignoringFence = VERBOSE_LOGS;
        private int requestedWidth = 1;
        private int requestedHeight = 1;
        private boolean createNewReader = true;
        boolean notifiedDestroy = VERBOSE_LOGS;
        private long lastDequeueTime = 0;
        private long lastQueueTime = 0;
        private long lastScheduleTime = 0;
        private int numTrims = 0;
        private final Object lock = new Object();
        private final ArrayDeque<b> imageReaderQueue = new ArrayDeque<>();
        private final HashMap<ImageReader, b> perImageReaders = new HashMap<>();
        private ArrayList<a> lastDequeuedImage = new ArrayList<>();
        private b lastReaderDequeuedFrom = null;
        TextureRegistry.SurfaceProducer.a callback = null;

        public class a {

            /* renamed from: a, reason: collision with root package name */
            public final Image f17620a;

            /* renamed from: b, reason: collision with root package name */
            public final long f17621b;

            public a(Image image, long j7) {
                this.f17620a = image;
                this.f17621b = j7;
            }
        }

        public class b {

            /* renamed from: a, reason: collision with root package name */
            public final ImageReader f17623a;

            /* renamed from: b, reason: collision with root package name */
            public final ArrayDeque f17624b = new ArrayDeque();

            /* renamed from: c, reason: collision with root package name */
            public boolean f17625c = ImageReaderSurfaceProducer.VERBOSE_LOGS;

            public b(ImageReader imageReader) {
                this.f17623a = imageReader;
                imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.k
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader2) {
                        FlutterRenderer.ImageReaderSurfaceProducer.b.a(this.f17676a, imageReader2);
                    }
                }, new Handler(Looper.getMainLooper()));
            }

            public static /* synthetic */ void a(b bVar, ImageReader imageReader) {
                Image imageAcquireLatestImage;
                bVar.getClass();
                try {
                    imageAcquireLatestImage = imageReader.acquireLatestImage();
                } catch (IllegalStateException e7) {
                    U4.b.b(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e7);
                    imageAcquireLatestImage = null;
                }
                if (imageAcquireLatestImage == null) {
                    return;
                }
                if (ImageReaderSurfaceProducer.this.released || bVar.f17625c) {
                    imageAcquireLatestImage.close();
                } else {
                    ImageReaderSurfaceProducer.this.onImage(imageReader, imageAcquireLatestImage);
                }
            }

            public boolean c() {
                if (!this.f17624b.isEmpty() || ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom == this) {
                    return ImageReaderSurfaceProducer.VERBOSE_LOGS;
                }
                return true;
            }

            public void d() {
                this.f17625c = true;
                this.f17623a.close();
                this.f17624b.clear();
            }

            public a e() {
                if (this.f17624b.isEmpty()) {
                    return null;
                }
                return (a) this.f17624b.removeFirst();
            }

            public boolean f() {
                return this.f17624b.isEmpty();
            }

            public a g(Image image) {
                if (this.f17625c) {
                    return null;
                }
                a aVar = ImageReaderSurfaceProducer.this.new a(image, System.nanoTime());
                this.f17624b.add(aVar);
                while (this.f17624b.size() > 2) {
                    ((a) this.f17624b.removeFirst()).f17620a.close();
                }
                return aVar;
            }
        }

        public ImageReaderSurfaceProducer(long j7) {
            this.id = j7;
        }

        public static /* synthetic */ void a(ImageReaderSurfaceProducer imageReaderSurfaceProducer) {
            if (imageReaderSurfaceProducer.released) {
                return;
            }
            FlutterRenderer.this.A();
        }

        private void cleanup() {
            synchronized (this.lock) {
                try {
                    for (b bVar : this.perImageReaders.values()) {
                        if (this.lastReaderDequeuedFrom == bVar) {
                            this.lastReaderDequeuedFrom = null;
                        }
                        bVar.d();
                    }
                    this.perImageReaders.clear();
                    if (this.lastDequeuedImage.size() > 0) {
                        ArrayList<a> arrayList = this.lastDequeuedImage;
                        int size = arrayList.size();
                        int i7 = 0;
                        while (i7 < size) {
                            a aVar = arrayList.get(i7);
                            i7++;
                            aVar.f17620a.close();
                        }
                        this.lastDequeuedImage.clear();
                    }
                    b bVar2 = this.lastReaderDequeuedFrom;
                    if (bVar2 != null) {
                        bVar2.d();
                        this.lastReaderDequeuedFrom = null;
                    }
                    this.imageReaderQueue.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private ImageReader createImageReader29() {
            return ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 7, 256L);
        }

        private ImageReader createImageReader33() {
            i.a();
            ImageReader.Builder builderA = h.a(this.requestedWidth, this.requestedHeight);
            builderA.setMaxImages(7);
            builderA.setImageFormat(34);
            builderA.setUsage(256L);
            return builderA.build();
        }

        private b getActiveReader() {
            synchronized (this.lock) {
                try {
                    if (!this.createNewReader) {
                        b bVarPeekLast = this.imageReaderQueue.peekLast();
                        if (bVarPeekLast.f17623a.getSurface().isValid()) {
                            return bVarPeekLast;
                        }
                    }
                    this.createNewReader = VERBOSE_LOGS;
                    return getOrCreatePerImageReader(createImageReader());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private b getOrCreatePerImageReader(ImageReader imageReader) {
            b bVar = this.perImageReaders.get(imageReader);
            if (bVar != null) {
                return bVar;
            }
            b bVarCreatePerImageReader = createPerImageReader(imageReader);
            this.perImageReaders.put(imageReader, bVarCreatePerImageReader);
            this.imageReaderQueue.add(bVarCreatePerImageReader);
            return bVarCreatePerImageReader;
        }

        private void maybeWaitOnFence(Image image) throws IOException {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
                U4.b.a(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void releaseInternal() {
            cleanup();
            this.released = true;
            FlutterRenderer.this.x(this);
            FlutterRenderer.this.f17618g.remove(this);
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() throws IOException {
            a aVarDequeueImage = dequeueImage();
            if (aVarDequeueImage == null) {
                return null;
            }
            maybeWaitOnFence(aVarDequeueImage.f17620a);
            return aVarDequeueImage.f17620a;
        }

        public ImageReader createImageReader() {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 33) {
                return createImageReader33();
            }
            if (i7 >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        public b createPerImageReader(ImageReader imageReader) {
            return new b(imageReader);
        }

        public double deltaMillis(long j7) {
            return j7 / 1000000.0d;
        }

        public a dequeueImage() {
            a aVar;
            boolean z7;
            synchronized (this.lock) {
                try {
                    Iterator<b> it = this.imageReaderQueue.iterator();
                    aVar = null;
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        z7 = VERBOSE_LOGS;
                        if (!zHasNext) {
                            break;
                        }
                        b next = it.next();
                        a aVarE = next.e();
                        if (aVarE == null) {
                            aVar = aVarE;
                        } else {
                            while (this.lastDequeuedImage.size() > 2) {
                                this.lastDequeuedImage.remove(0).f17620a.close();
                            }
                            this.lastDequeuedImage.add(aVarE);
                            this.lastReaderDequeuedFrom = next;
                            aVar = aVarE;
                        }
                    }
                    pruneImageReaderQueue();
                    Iterator<b> it2 = this.imageReaderQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!it2.next().f()) {
                            z7 = true;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                FlutterRenderer.this.f17616e.post(new Runnable() { // from class: io.flutter.embedding.engine.renderer.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlutterRenderer.ImageReaderSurfaceProducer.a(this.f17675l);
                    }
                });
            }
            return aVar;
        }

        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer.this.f17616e.post(new f(this.id, FlutterRenderer.this.f17612a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getForcedNewSurface() {
            this.createNewReader = true;
            return getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            return getActiveReader().f17623a.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public boolean handlesCropAndRotation() {
            return VERBOSE_LOGS;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public long id() {
            return this.id;
        }

        public int numImageReaders() {
            int size;
            synchronized (this.lock) {
                size = this.imageReaderQueue.size();
            }
            return size;
        }

        public int numImages() {
            int size;
            synchronized (this.lock) {
                try {
                    Iterator<b> it = this.imageReaderQueue.iterator();
                    size = 0;
                    while (it.hasNext()) {
                        size += it.next().f17624b.size();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return size;
        }

        public int numTrims() {
            int i7;
            synchronized (this.lock) {
                i7 = this.numTrims;
            }
            return i7;
        }

        public void onImage(ImageReader imageReader, Image image) {
            a aVarG;
            synchronized (this.lock) {
                aVarG = getOrCreatePerImageReader(imageReader).g(image);
            }
            if (aVarG == null) {
                return;
            }
            FlutterRenderer.this.A();
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i7) {
            if (i7 < 40) {
                return;
            }
            synchronized (this.lock) {
                this.numTrims++;
            }
            TextureRegistry.SurfaceProducer.a aVar = this.callback;
            if (aVar != null) {
                this.notifiedDestroy = true;
                aVar.onSurfaceCleanup();
            }
            cleanup();
            this.createNewReader = true;
        }

        public int pendingDequeuedImages() {
            return this.lastDequeuedImage.size();
        }

        public void pruneImageReaderQueue() {
            b bVarPeekFirst;
            while (this.imageReaderQueue.size() > 1 && (bVarPeekFirst = this.imageReaderQueue.peekFirst()) != null && bVarPeekFirst.c()) {
                this.imageReaderQueue.removeFirst();
                this.perImageReaders.remove(bVarPeekFirst.f17623a);
                bVarPeekFirst.d();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer.this.I(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void scheduleFrame() {
            FlutterRenderer.this.A();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setCallback(TextureRegistry.SurfaceProducer.a aVar) {
            this.callback = aVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int i7, int i8) {
            int iMax = Math.max(1, i7);
            int iMax2 = Math.max(1, i8);
            if (this.requestedWidth == iMax && this.requestedHeight == iMax2) {
                return;
            }
            this.createNewReader = true;
            this.requestedHeight = iMax2;
            this.requestedWidth = iMax;
        }

        public void waitOnFence(Image image) throws IOException {
            try {
                SyncFence fence = image.getFence();
                try {
                    fence.awaitForever();
                    if (fence != null) {
                        fence.close();
                    }
                } finally {
                }
            } catch (IOException unused) {
            }
        }
    }

    @InterfaceC1116a
    public final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        public ImageTextureRegistryEntry(long j7) {
            this.id = j7;
        }

        private void maybeWaitOnFence(Image image) throws IOException {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
                U4.b.a(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void waitOnFence(Image image) throws IOException {
            try {
                SyncFence fence = image.getFence();
                try {
                    fence.awaitForever();
                    if (fence != null) {
                        fence.close();
                    }
                } finally {
                }
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() throws IOException {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image);
            return image;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    super.finalize();
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.f17616e.post(new f(this.id, FlutterRenderer.this.f17612a));
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image image2;
            if (this.released) {
                return;
            }
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                U4.b.b(TAG, "Dropping PlatformView Frame");
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.A();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer.this.I(this.id);
        }
    }

    public class a implements n {
        public a() {
        }

        @Override // io.flutter.embedding.engine.renderer.n
        public void c() {
            FlutterRenderer.this.f17615d = false;
        }

        @Override // io.flutter.embedding.engine.renderer.n
        public void f() {
            FlutterRenderer.this.f17615d = true;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f17628a;

        /* renamed from: b, reason: collision with root package name */
        public final d f17629b;

        /* renamed from: c, reason: collision with root package name */
        public final c f17630c;

        public b(Rect rect, d dVar, c cVar) {
            this.f17628a = rect;
            this.f17629b = dVar;
            this.f17630c = cVar;
        }
    }

    public enum c {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);


        /* renamed from: l, reason: collision with root package name */
        public final int f17635l;

        c(int i7) {
            this.f17635l = i7;
        }
    }

    public enum d {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);


        /* renamed from: l, reason: collision with root package name */
        public final int f17641l;

        d(int i7) {
            this.f17641l = i7;
        }
    }

    public final class e implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.b {

        /* renamed from: a, reason: collision with root package name */
        public final long f17642a;

        /* renamed from: b, reason: collision with root package name */
        public final SurfaceTextureWrapper f17643b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f17644c;

        /* renamed from: d, reason: collision with root package name */
        public TextureRegistry.b f17645d;

        public e(long j7, SurfaceTexture surfaceTexture) {
            this.f17642a = j7;
            this.f17643b = new SurfaceTextureWrapper(surfaceTexture, new Runnable() { // from class: io.flutter.embedding.engine.renderer.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17677l.getClass();
                }
            });
            surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.m
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    FlutterRenderer.e.a(this.f17678l, surfaceTexture2);
                }
            }, new Handler());
        }

        public static /* synthetic */ void a(e eVar, SurfaceTexture surfaceTexture) {
            if (eVar.f17644c || !FlutterRenderer.this.f17612a.isAttached()) {
                return;
            }
            eVar.f17643b.markDirty();
            FlutterRenderer.this.A();
        }

        public final void c() {
            FlutterRenderer.this.x(this);
        }

        public SurfaceTextureWrapper d() {
            return this.f17643b;
        }

        public void finalize() throws Throwable {
            try {
                if (this.f17644c) {
                    return;
                }
                FlutterRenderer.this.f17616e.post(new f(this.f17642a, FlutterRenderer.this.f17612a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.f17642a;
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i7) {
            TextureRegistry.b bVar = this.f17645d;
            if (bVar != null) {
                bVar.onTrimMemory(i7);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.f17644c) {
                return;
            }
            U4.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f17642a + ").");
            this.f17643b.release();
            FlutterRenderer.this.I(this.f17642a);
            c();
            this.f17644c = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(TextureRegistry.a aVar) {
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnTrimMemoryListener(TextureRegistry.b bVar) {
            this.f17645d = bVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            return this.f17643b.surfaceTexture();
        }
    }

    public static final class f implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final long f17647l;

        /* renamed from: m, reason: collision with root package name */
        public final FlutterJNI f17648m;

        public f(long j7, FlutterJNI flutterJNI) {
            this.f17647l = j7;
            this.f17648m = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17648m.isAttached()) {
                U4.b.f("FlutterRenderer", "Releasing a Texture (" + this.f17647l + ").");
                this.f17648m.unregisterTexture(this.f17647l);
            }
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public float f17649a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f17650b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f17651c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f17652d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f17653e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f17654f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f17655g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f17656h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f17657i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f17658j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f17659k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f17660l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f17661m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f17662n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f17663o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f17664p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f17665q = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f17666r = 0;

        /* renamed from: s, reason: collision with root package name */
        public int f17667s = 0;

        /* renamed from: t, reason: collision with root package name */
        public int f17668t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f17669u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f17670v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f17671w = -1;

        /* renamed from: x, reason: collision with root package name */
        public int f17672x = -1;

        /* renamed from: y, reason: collision with root package name */
        public final List f17673y = new ArrayList();

        /* renamed from: z, reason: collision with root package name */
        public final List f17674z = new ArrayList();

        public void c(List list) {
            this.f17674z.clear();
            this.f17674z.addAll(list);
        }

        public void d(List list) {
            this.f17673y.clear();
            this.f17673y.addAll(list);
        }

        public boolean e() {
            int i7 = this.f17650b;
            if (i7 == 0) {
                U4.b.a("FlutterRenderer", "Width is zero. " + this.f17652d + "," + this.f17653e);
                return this.f17652d > 0 || this.f17653e > 0;
            }
            int i8 = this.f17651c;
            if (i8 != 0) {
                return i7 > 0 && i8 > 0 && this.f17649a > 0.0f;
            }
            U4.b.a("FlutterRenderer", "Height is zero. " + this.f17654f + "," + this.f17655g);
            return this.f17654f > 0 || this.f17655g > 0;
        }
    }

    public FlutterRenderer(FlutterJNI flutterJNI) {
        a aVar = new a();
        this.f17619h = aVar;
        this.f17612a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
    }

    public static boolean o() {
        return Build.VERSION.SDK_INT <= 29 && "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public void A() {
        this.f17612a.scheduleFrame();
    }

    public void B(boolean z7) {
        this.f17612a.setSemanticsEnabled(z7);
    }

    public void C(g gVar) {
        if (gVar.e()) {
            U4.b.f("FlutterRenderer", "Setting viewport metrics\nSize: " + gVar.f17650b + " x " + gVar.f17651c + "\nSize Constraints: " + gVar.f17652d + "," + gVar.f17653e + " x " + gVar.f17654f + "," + gVar.f17655g + "\nPadding - L: " + gVar.f17659k + ", T: " + gVar.f17656h + ", R: " + gVar.f17657i + ", B: " + gVar.f17658j + "\nInsets - L: " + gVar.f17663o + ", T: " + gVar.f17660l + ", R: " + gVar.f17661m + ", B: " + gVar.f17662n + "\nSystem Gesture Insets - L: " + gVar.f17667s + ", T: " + gVar.f17664p + ", R: " + gVar.f17665q + ", B: " + gVar.f17665q + "\nDisplay Features: " + gVar.f17673y.size() + "\nDisplay Cutouts: " + gVar.f17674z.size() + "\nDisplay Corner Radii - TL: " + gVar.f17669u + ", TR: " + gVar.f17670v + ", BR: " + gVar.f17671w + ", BL: " + gVar.f17672x);
            int size = gVar.f17673y.size() + gVar.f17674z.size();
            int[] iArr = new int[size * 4];
            int[] iArr2 = new int[size];
            int[] iArr3 = new int[size];
            for (int i7 = 0; i7 < gVar.f17673y.size(); i7++) {
                b bVar = (b) gVar.f17673y.get(i7);
                H(iArr, i7 * 4, bVar.f17628a);
                iArr2[i7] = bVar.f17629b.f17641l;
                iArr3[i7] = bVar.f17630c.f17635l;
            }
            int size2 = gVar.f17673y.size() * 4;
            for (int i8 = 0; i8 < gVar.f17674z.size(); i8++) {
                b bVar2 = (b) gVar.f17674z.get(i8);
                H(iArr, (i8 * 4) + size2, bVar2.f17628a);
                iArr2[gVar.f17673y.size() + i8] = bVar2.f17629b.f17641l;
                iArr3[gVar.f17673y.size() + i8] = bVar2.f17630c.f17635l;
            }
            this.f17612a.setViewportMetrics(gVar.f17649a, gVar.f17650b, gVar.f17651c, gVar.f17656h, gVar.f17657i, gVar.f17658j, gVar.f17659k, gVar.f17660l, gVar.f17661m, gVar.f17662n, gVar.f17663o, gVar.f17664p, gVar.f17665q, gVar.f17666r, gVar.f17667s, gVar.f17668t, iArr, iArr2, iArr3, gVar.f17652d, gVar.f17653e, gVar.f17654f, gVar.f17655g, gVar.f17669u, gVar.f17670v, gVar.f17671w, gVar.f17672x);
        }
    }

    public void D(Surface surface, boolean z7) {
        if (!z7) {
            E();
        }
        this.f17614c = surface;
        if (z7) {
            this.f17612a.onSurfaceWindowChanged(surface);
        } else {
            this.f17612a.onSurfaceCreated(surface);
        }
    }

    public void E() {
        if (this.f17614c != null) {
            this.f17612a.onSurfaceDestroyed();
            if (this.f17615d) {
                this.f17619h.c();
            }
            this.f17615d = false;
            this.f17614c = null;
        }
    }

    public void F(int i7, int i8) {
        this.f17612a.onSurfaceChanged(i7, i8);
    }

    public void G(Surface surface) {
        this.f17614c = surface;
        this.f17612a.onSurfaceWindowChanged(surface);
    }

    public final void H(int[] iArr, int i7, Rect rect) {
        iArr[i7] = rect.left;
        iArr[i7 + 1] = rect.top;
        iArr[i7 + 2] = rect.right;
        iArr[i7 + 3] = rect.bottom;
    }

    public final void I(long j7) {
        this.f17612a.unregisterTexture(j7);
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer a(TextureRegistry.c cVar) {
        if (f17610i || Build.VERSION.SDK_INT < 29 || o()) {
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntryD = d();
            q qVar = new q(surfaceTextureEntryD.id(), this.f17616e, this.f17612a, surfaceTextureEntryD);
            U4.b.f("FlutterRenderer", "New SurfaceTextureSurfaceProducer ID: " + surfaceTextureEntryD.id());
            return qVar;
        }
        long andIncrement = this.f17613b.getAndIncrement();
        ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(andIncrement);
        boolean z7 = cVar == TextureRegistry.c.resetInBackground;
        s(andIncrement, imageReaderSurfaceProducer, z7);
        if (z7) {
            k(imageReaderSurfaceProducer);
        }
        this.f17618g.add(imageReaderSurfaceProducer);
        U4.b.f("FlutterRenderer", "New ImageReaderSurfaceProducer ID: " + andIncrement);
        return imageReaderSurfaceProducer;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry b() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.f17613b.getAndIncrement());
        U4.b.f("FlutterRenderer", "New ImageTextureEntry ID: " + imageTextureRegistryEntry.id());
        s(imageTextureRegistryEntry.id(), imageTextureRegistryEntry, false);
        return imageTextureRegistryEntry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry d() {
        U4.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return u(new SurfaceTexture(0));
    }

    public void j(n nVar) {
        this.f17612a.addIsDisplayingFlutterUiListener(nVar);
        if (this.f17615d) {
            nVar.f();
        }
    }

    public void k(TextureRegistry.b bVar) {
        m();
        this.f17617f.add(new WeakReference(bVar));
    }

    public void l(o oVar) {
        this.f17612a.addResizingFlutterUiListener(oVar);
    }

    public final void m() {
        Iterator it = this.f17617f.iterator();
        while (it.hasNext()) {
            if (((TextureRegistry.b) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
    }

    public void n(ByteBuffer byteBuffer, int i7) {
        this.f17612a.dispatchPointerDataPacket(byteBuffer, i7);
    }

    public boolean p() {
        return this.f17615d;
    }

    public boolean q() {
        return this.f17612a.getIsSoftwareRenderingEnabled();
    }

    public void r(int i7) {
        Iterator it = this.f17617f.iterator();
        while (it.hasNext()) {
            TextureRegistry.b bVar = (TextureRegistry.b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onTrimMemory(i7);
            } else {
                it.remove();
            }
        }
    }

    public final void s(long j7, TextureRegistry.ImageConsumer imageConsumer, boolean z7) {
        this.f17612a.registerImageTexture(j7, imageConsumer, z7);
    }

    public final TextureRegistry.SurfaceTextureEntry t(long j7, SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        e eVar = new e(j7, surfaceTexture);
        U4.b.f("FlutterRenderer", "New SurfaceTexture ID: " + eVar.id());
        v(eVar.id(), eVar.d());
        k(eVar);
        return eVar;
    }

    public TextureRegistry.SurfaceTextureEntry u(SurfaceTexture surfaceTexture) {
        return t(this.f17613b.getAndIncrement(), surfaceTexture);
    }

    public final void v(long j7, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f17612a.registerTexture(j7, surfaceTextureWrapper);
    }

    public void w(n nVar) {
        this.f17612a.removeIsDisplayingFlutterUiListener(nVar);
    }

    public void x(TextureRegistry.b bVar) {
        for (WeakReference weakReference : this.f17617f) {
            if (weakReference.get() == bVar) {
                this.f17617f.remove(weakReference);
                return;
            }
        }
    }

    public void y(o oVar) {
        this.f17612a.removeResizingFlutterUiListener(oVar);
    }

    public void z() {
        U4.b.f("FlutterRenderer", "restoreSurfaceProducers called; notifying SurfaceProducers");
        for (ImageReaderSurfaceProducer imageReaderSurfaceProducer : this.f17618g) {
            TextureRegistry.SurfaceProducer.a aVar = imageReaderSurfaceProducer.callback;
            if (aVar != null && imageReaderSurfaceProducer.notifiedDestroy) {
                imageReaderSurfaceProducer.notifiedDestroy = false;
                aVar.onSurfaceAvailable();
            }
        }
    }
}
