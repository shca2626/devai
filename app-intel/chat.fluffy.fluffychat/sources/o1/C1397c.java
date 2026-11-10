package o1;

import java.util.List;

/* renamed from: o1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1397c {

    /* renamed from: a, reason: collision with root package name */
    public final long f20362a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20363b;

    /* renamed from: o1.c$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f20364a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20365b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20366c;

        /* renamed from: d, reason: collision with root package name */
        public final long f20367d;

        public a(String str, String str2, long j7, long j8) {
            this.f20364a = str;
            this.f20365b = str2;
            this.f20366c = j7;
            this.f20367d = j8;
        }
    }

    public C1397c(long j7, List list) {
        this.f20362a = j7;
        this.f20363b = list;
    }

    public p1.c a(long j7) {
        p1.c cVar;
        long j8;
        p1.c cVar2 = null;
        if (this.f20363b.size() < 2) {
            return null;
        }
        boolean z7 = true;
        int size = this.f20363b.size() - 1;
        long j9 = j7;
        long j10 = -1;
        long j11 = -1;
        long j12 = -1;
        long j13 = -1;
        while (size >= 0) {
            a aVar = (a) this.f20363b.get(size);
            boolean z8 = (aVar.f20364a.equals("video/mp4") || aVar.f20364a.equals("video/quicktime")) ? z7 : false;
            if (size == 0) {
                cVar = cVar2;
                j9 -= aVar.f20367d;
                j8 = 0;
            } else {
                cVar = cVar2;
                j8 = j9 - aVar.f20366c;
            }
            long j14 = j9;
            j9 = j8;
            if (z8 && j9 != j14) {
                j13 = j14 - j9;
                j12 = j9;
            }
            if (size == 0) {
                j11 = j14;
                j10 = j9;
            }
            size--;
            cVar2 = cVar;
            z7 = true;
        }
        return (j12 == -1 || j13 == -1 || j10 == -1 || j11 == -1) ? cVar2 : new p1.c(j10, j11, this.f20362a, j12, j13);
    }
}
