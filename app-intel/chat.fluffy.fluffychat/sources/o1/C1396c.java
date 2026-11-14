package o1;

import java.util.List;

/* renamed from: o1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1396c {

    /* renamed from: a, reason: collision with root package name */
    public final long f20361a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20362b;

    /* renamed from: o1.c$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f20363a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20364b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20365c;

        /* renamed from: d, reason: collision with root package name */
        public final long f20366d;

        public a(String str, String str2, long j7, long j8) {
            this.f20363a = str;
            this.f20364b = str2;
            this.f20365c = j7;
            this.f20366d = j8;
        }
    }

    public C1396c(long j7, List list) {
        this.f20361a = j7;
        this.f20362b = list;
    }

    public p1.c a(long j7) {
        p1.c cVar;
        long j8;
        p1.c cVar2 = null;
        if (this.f20362b.size() < 2) {
            return null;
        }
        boolean z7 = true;
        int size = this.f20362b.size() - 1;
        long j9 = j7;
        long j10 = -1;
        long j11 = -1;
        long j12 = -1;
        long j13 = -1;
        while (size >= 0) {
            a aVar = (a) this.f20362b.get(size);
            boolean z8 = (aVar.f20363a.equals("video/mp4") || aVar.f20363a.equals("video/quicktime")) ? z7 : false;
            if (size == 0) {
                cVar = cVar2;
                j9 -= aVar.f20366d;
                j8 = 0;
            } else {
                cVar = cVar2;
                j8 = j9 - aVar.f20365c;
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
        return (j12 == -1 || j13 == -1 || j10 == -1 || j11 == -1) ? cVar2 : new p1.c(j10, j11, this.f20361a, j12, j13);
    }
}
