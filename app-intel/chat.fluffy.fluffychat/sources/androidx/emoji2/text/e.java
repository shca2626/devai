package androidx.emoji2.text;

import O.A;
import V.k;
import W.i;
import Y.h;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.emoji2.text.c;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import l0.AbstractC1293c;

/* loaded from: classes.dex */
public class e extends c.AbstractC0107c {

    /* renamed from: j, reason: collision with root package name */
    public static final a f12326j = new a();

    public static class a {
        public Typeface a(Context context, i.b bVar) {
            return i.a(context, null, new i.b[]{bVar});
        }

        public i.a b(Context context, W.e eVar) {
            return i.b(context, null, eVar);
        }

        public void c(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class b implements c.g {

        /* renamed from: a, reason: collision with root package name */
        public final Context f12327a;

        /* renamed from: b, reason: collision with root package name */
        public final W.e f12328b;

        /* renamed from: c, reason: collision with root package name */
        public final a f12329c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f12330d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Handler f12331e;

        /* renamed from: f, reason: collision with root package name */
        public Executor f12332f;

        /* renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f12333g;

        /* renamed from: h, reason: collision with root package name */
        public c f12334h;

        /* renamed from: i, reason: collision with root package name */
        public c.h f12335i;

        /* renamed from: j, reason: collision with root package name */
        public ContentObserver f12336j;

        /* renamed from: k, reason: collision with root package name */
        public Runnable f12337k;

        public class a extends ContentObserver {
            public a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z7, Uri uri) {
                b.this.d();
            }
        }

        public b(Context context, W.e eVar, a aVar) {
            h.k(context, "Context cannot be null");
            h.k(eVar, "FontRequest cannot be null");
            this.f12327a = context.getApplicationContext();
            this.f12328b = eVar;
            this.f12329c = aVar;
        }

        @Override // androidx.emoji2.text.c.g
        public void a(c.h hVar) {
            h.k(hVar, "LoaderCallback cannot be null");
            synchronized (this.f12330d) {
                this.f12335i = hVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f12330d) {
                try {
                    this.f12335i = null;
                    ContentObserver contentObserver = this.f12336j;
                    if (contentObserver != null) {
                        this.f12329c.d(this.f12327a, contentObserver);
                        this.f12336j = null;
                    }
                    Handler handler = this.f12331e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f12337k);
                    }
                    this.f12331e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f12333g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f12332f = null;
                    this.f12333g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.f12330d) {
                try {
                    if (this.f12335i == null) {
                        return;
                    }
                    try {
                        i.b bVarE = e();
                        int iA = bVarE.a();
                        if (iA == 2) {
                            synchronized (this.f12330d) {
                                try {
                                    c cVar = this.f12334h;
                                    if (cVar != null) {
                                        long jA = cVar.a();
                                        if (jA >= 0) {
                                            f(bVarE.d(), jA);
                                            return;
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        if (iA != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iA + ")");
                        }
                        try {
                            k.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f12329c.a(this.f12327a, bVarE);
                            ByteBuffer byteBufferF = A.f(this.f12327a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            f fVarB = f.b(typefaceA, byteBufferF);
                            k.b();
                            synchronized (this.f12330d) {
                                try {
                                    c.h hVar = this.f12335i;
                                    if (hVar != null) {
                                        hVar.b(fVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            k.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f12330d) {
                            try {
                                c.h hVar2 = this.f12335i;
                                if (hVar2 != null) {
                                    hVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void d() {
            synchronized (this.f12330d) {
                try {
                    if (this.f12335i == null) {
                        return;
                    }
                    if (this.f12332f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = AbstractC1293c.b("emojiCompat");
                        this.f12333g = threadPoolExecutorB;
                        this.f12332f = threadPoolExecutorB;
                    }
                    this.f12332f.execute(new Runnable() { // from class: l0.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f19526l.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final i.b e() {
            try {
                i.a aVarB = this.f12329c.b(this.f12327a, this.f12328b);
                if (aVarB.e() == 0) {
                    i.b[] bVarArrC = aVarB.c();
                    if (bVarArrC == null || bVarArrC.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrC[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.e() + ")");
            } catch (PackageManager.NameNotFoundException e7) {
                throw new RuntimeException("provider not found", e7);
            }
        }

        public final void f(Uri uri, long j7) {
            synchronized (this.f12330d) {
                try {
                    Handler handlerC = this.f12331e;
                    if (handlerC == null) {
                        handlerC = AbstractC1293c.c();
                        this.f12331e = handlerC;
                    }
                    if (this.f12336j == null) {
                        a aVar = new a(handlerC);
                        this.f12336j = aVar;
                        this.f12329c.c(this.f12327a, uri, aVar);
                    }
                    if (this.f12337k == null) {
                        this.f12337k = new Runnable() { // from class: l0.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f19527l.d();
                            }
                        };
                    }
                    handlerC.postDelayed(this.f12337k, j7);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g(Executor executor) {
            synchronized (this.f12330d) {
                this.f12332f = executor;
            }
        }
    }

    public static abstract class c {
        public abstract long a();
    }

    public e(Context context, W.e eVar) {
        super(new b(context, eVar, f12326j));
    }

    public e c(Executor executor) {
        ((b) a()).g(executor);
        return this;
    }
}
