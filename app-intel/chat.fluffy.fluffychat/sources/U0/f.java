package U0;

import U0.f;
import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final TreeSet f8345a = new TreeSet(new Comparator() { // from class: U0.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return f.c(((f.a) obj).f8349a.f8332g, ((f.a) obj2).f8349a.f8332g);
        }
    });

    /* renamed from: b, reason: collision with root package name */
    public int f8346b;

    /* renamed from: c, reason: collision with root package name */
    public int f8347c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8348d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final d f8349a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8350b;

        public a(d dVar, long j7) {
            this.f8349a = dVar;
            this.f8350b = j7;
        }
    }

    public f() {
        f();
    }

    public static int c(int i7, int i8) {
        int iMin;
        int i9 = i7 - i8;
        return (Math.abs(i9) <= 1000 || (iMin = (Math.min(i7, i8) - Math.max(i7, i8)) + 65535) >= 1000) ? i9 : i7 < i8 ? iMin : -iMin;
    }

    public final synchronized void b(a aVar) {
        this.f8346b = aVar.f8349a.f8332g;
        this.f8345a.add(aVar);
    }

    public synchronized boolean d(d dVar, long j7) {
        if (this.f8345a.size() >= 5000) {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
        int i7 = dVar.f8332g;
        if (!this.f8348d) {
            f();
            this.f8347c = d.c(i7);
            this.f8348d = true;
            b(new a(dVar, j7));
            return true;
        }
        if (Math.abs(c(i7, d.b(this.f8346b))) < 1000) {
            if (c(i7, this.f8347c) <= 0) {
                return false;
            }
            b(new a(dVar, j7));
            return true;
        }
        this.f8347c = d.c(i7);
        this.f8345a.clear();
        b(new a(dVar, j7));
        return true;
    }

    public synchronized d e(long j7) {
        if (this.f8345a.isEmpty()) {
            return null;
        }
        a aVar = (a) this.f8345a.first();
        int i7 = aVar.f8349a.f8332g;
        if (i7 != d.b(this.f8347c) && j7 < aVar.f8350b) {
            return null;
        }
        this.f8345a.pollFirst();
        this.f8347c = i7;
        return aVar.f8349a;
    }

    public synchronized void f() {
        this.f8345a.clear();
        this.f8348d = false;
        this.f8347c = -1;
        this.f8346b = -1;
    }
}
