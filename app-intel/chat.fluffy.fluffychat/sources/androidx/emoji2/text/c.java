package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import l0.AbstractC1297f;
import l0.C1296e;
import l0.k;
import y.C1788b;

/* loaded from: classes.dex */
public class c {

    /* renamed from: n, reason: collision with root package name */
    public static final Object f12281n = new Object();

    /* renamed from: o, reason: collision with root package name */
    public static final Object f12282o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static volatile c f12283p;

    /* renamed from: b, reason: collision with root package name */
    public final Set f12285b;

    /* renamed from: e, reason: collision with root package name */
    public final b f12288e;

    /* renamed from: f, reason: collision with root package name */
    public final g f12289f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f12290g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f12291h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f12292i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f12293j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12294k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12295l;

    /* renamed from: m, reason: collision with root package name */
    public final d f12296m;

    /* renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f12284a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    public volatile int f12286c = 3;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f12287d = new Handler(Looper.getMainLooper());

    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.d f12297b;

        /* renamed from: c, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f12298c;

        /* renamed from: androidx.emoji2.text.c$a$a, reason: collision with other inner class name */
        public class C0106a extends h {
            public C0106a() {
            }

            @Override // androidx.emoji2.text.c.h
            public void a(Throwable th) {
                a.this.f12300a.m(th);
            }

            @Override // androidx.emoji2.text.c.h
            public void b(androidx.emoji2.text.f fVar) {
                a.this.d(fVar);
            }
        }

        public a(c cVar) {
            super(cVar);
        }

        @Override // androidx.emoji2.text.c.b
        public void a() {
            try {
                this.f12300a.f12289f.a(new C0106a());
            } catch (Throwable th) {
                this.f12300a.m(th);
            }
        }

        @Override // androidx.emoji2.text.c.b
        public CharSequence b(CharSequence charSequence, int i7, int i8, int i9, boolean z7) {
            return this.f12297b.h(charSequence, i7, i8, i9, z7);
        }

        @Override // androidx.emoji2.text.c.b
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f12298c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f12300a.f12290g);
        }

        public void d(androidx.emoji2.text.f fVar) {
            if (fVar == null) {
                this.f12300a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f12298c = fVar;
            androidx.emoji2.text.f fVar2 = this.f12298c;
            i iVar = new i();
            d dVar = this.f12300a.f12296m;
            c cVar = this.f12300a;
            this.f12297b = new androidx.emoji2.text.d(fVar2, iVar, dVar, cVar.f12291h, cVar.f12292i);
            this.f12300a.n();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f12300a;

        public b(c cVar) {
            this.f12300a = cVar;
        }

        public abstract void a();

        public abstract CharSequence b(CharSequence charSequence, int i7, int i8, int i9, boolean z7);

        public abstract void c(EditorInfo editorInfo);
    }

    /* renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0107c {

        /* renamed from: a, reason: collision with root package name */
        public final g f12301a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12302b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f12303c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f12304d;

        /* renamed from: e, reason: collision with root package name */
        public Set f12305e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f12306f;

        /* renamed from: g, reason: collision with root package name */
        public int f12307g = -16711936;

        /* renamed from: h, reason: collision with root package name */
        public int f12308h = 0;

        /* renamed from: i, reason: collision with root package name */
        public d f12309i = new androidx.emoji2.text.b();

        public AbstractC0107c(g gVar) {
            Y.h.k(gVar, "metadataLoader cannot be null.");
            this.f12301a = gVar;
        }

        public final g a() {
            return this.f12301a;
        }

        public AbstractC0107c b(int i7) {
            this.f12308h = i7;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence charSequence, int i7, int i8, int i9);
    }

    public static abstract class e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class f implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final List f12310l;

        /* renamed from: m, reason: collision with root package name */
        public final Throwable f12311m;

        /* renamed from: n, reason: collision with root package name */
        public final int f12312n;

        public f(e eVar, int i7) {
            this(Arrays.asList((e) Y.h.k(eVar, "initCallback cannot be null")), i7, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f12310l.size();
            int i7 = 0;
            if (this.f12312n != 1) {
                while (i7 < size) {
                    ((e) this.f12310l.get(i7)).a(this.f12311m);
                    i7++;
                }
            } else {
                while (i7 < size) {
                    ((e) this.f12310l.get(i7)).b();
                    i7++;
                }
            }
        }

        public f(Collection collection, int i7) {
            this(collection, i7, null);
        }

        public f(Collection collection, int i7, Throwable th) {
            Y.h.k(collection, "initCallbacks cannot be null");
            this.f12310l = new ArrayList(collection);
            this.f12312n = i7;
            this.f12311m = th;
        }
    }

    public interface g {
        void a(h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(androidx.emoji2.text.f fVar);
    }

    public static class i {
        public AbstractC1297f a(C1296e c1296e) {
            return new k(c1296e);
        }
    }

    public c(AbstractC0107c abstractC0107c) {
        this.f12290g = abstractC0107c.f12302b;
        this.f12291h = abstractC0107c.f12303c;
        this.f12292i = abstractC0107c.f12304d;
        this.f12293j = abstractC0107c.f12306f;
        this.f12294k = abstractC0107c.f12307g;
        this.f12289f = abstractC0107c.f12301a;
        this.f12295l = abstractC0107c.f12308h;
        this.f12296m = abstractC0107c.f12309i;
        C1788b c1788b = new C1788b();
        this.f12285b = c1788b;
        Set set = abstractC0107c.f12305e;
        if (set != null && !set.isEmpty()) {
            c1788b.addAll(abstractC0107c.f12305e);
        }
        this.f12288e = new a(this);
        l();
    }

    public static c b() {
        c cVar;
        synchronized (f12281n) {
            cVar = f12283p;
            Y.h.l(cVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return cVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i7, int i8, boolean z7) {
        return androidx.emoji2.text.d.c(inputConnection, editable, i7, i8, z7);
    }

    public static boolean f(Editable editable, int i7, KeyEvent keyEvent) {
        return androidx.emoji2.text.d.d(editable, i7, keyEvent);
    }

    public static c g(AbstractC0107c abstractC0107c) {
        c cVar;
        c cVar2 = f12283p;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (f12281n) {
            try {
                cVar = f12283p;
                if (cVar == null) {
                    cVar = new c(abstractC0107c);
                    f12283p = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static boolean h() {
        return f12283p != null;
    }

    public int c() {
        return this.f12294k;
    }

    public int d() {
        this.f12284a.readLock().lock();
        try {
            return this.f12286c;
        } finally {
            this.f12284a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f12293j;
    }

    public final boolean j() {
        return d() == 1;
    }

    public void k() {
        Y.h.l(this.f12295l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f12284a.writeLock().lock();
        try {
            if (this.f12286c == 0) {
                return;
            }
            this.f12286c = 0;
            this.f12284a.writeLock().unlock();
            this.f12288e.a();
        } finally {
            this.f12284a.writeLock().unlock();
        }
    }

    public final void l() {
        this.f12284a.writeLock().lock();
        try {
            if (this.f12295l == 0) {
                this.f12286c = 0;
            }
            this.f12284a.writeLock().unlock();
            if (d() == 0) {
                this.f12288e.a();
            }
        } catch (Throwable th) {
            this.f12284a.writeLock().unlock();
            throw th;
        }
    }

    public void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f12284a.writeLock().lock();
        try {
            this.f12286c = 2;
            arrayList.addAll(this.f12285b);
            this.f12285b.clear();
            this.f12284a.writeLock().unlock();
            this.f12287d.post(new f(arrayList, this.f12286c, th));
        } catch (Throwable th2) {
            this.f12284a.writeLock().unlock();
            throw th2;
        }
    }

    public void n() {
        ArrayList arrayList = new ArrayList();
        this.f12284a.writeLock().lock();
        try {
            this.f12286c = 1;
            arrayList.addAll(this.f12285b);
            this.f12285b.clear();
            this.f12284a.writeLock().unlock();
            this.f12287d.post(new f(arrayList, this.f12286c));
        } catch (Throwable th) {
            this.f12284a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i7, int i8) {
        return q(charSequence, i7, i8, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i7, int i8, int i9) {
        return r(charSequence, i7, i8, i9, 0);
    }

    public CharSequence r(CharSequence charSequence, int i7, int i8, int i9, int i10) {
        boolean z7;
        Y.h.l(j(), "Not initialized yet");
        Y.h.h(i7, "start cannot be negative");
        Y.h.h(i8, "end cannot be negative");
        Y.h.h(i9, "maxEmojiCount cannot be negative");
        Y.h.a(i7 <= i8, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Y.h.a(i7 <= charSequence.length(), "start should be < than charSequence length");
        Y.h.a(i8 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i7 == i8) {
            return charSequence;
        }
        if (i10 != 1) {
            z7 = i10 != 2 ? this.f12290g : false;
        } else {
            z7 = true;
        }
        return this.f12288e.b(charSequence, i7, i8, i9, z7);
    }

    public void s(e eVar) {
        Y.h.k(eVar, "initCallback cannot be null");
        this.f12284a.writeLock().lock();
        try {
            if (this.f12286c == 1 || this.f12286c == 2) {
                this.f12287d.post(new f(eVar, this.f12286c));
            } else {
                this.f12285b.add(eVar);
            }
            this.f12284a.writeLock().unlock();
        } catch (Throwable th) {
            this.f12284a.writeLock().unlock();
            throw th;
        }
    }

    public void t(e eVar) {
        Y.h.k(eVar, "initCallback cannot be null");
        this.f12284a.writeLock().lock();
        try {
            this.f12285b.remove(eVar);
        } finally {
            this.f12284a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f12288e.c(editorInfo);
    }
}
