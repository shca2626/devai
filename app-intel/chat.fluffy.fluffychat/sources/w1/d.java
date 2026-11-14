package w1;

import E0.E;
import E0.M;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends AbstractC1727b {

    /* renamed from: a, reason: collision with root package name */
    public final long f23267a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23268b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23269c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23270d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f23271e;

    /* renamed from: f, reason: collision with root package name */
    public final long f23272f;

    /* renamed from: g, reason: collision with root package name */
    public final long f23273g;

    /* renamed from: h, reason: collision with root package name */
    public final List f23274h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f23275i;

    /* renamed from: j, reason: collision with root package name */
    public final long f23276j;

    /* renamed from: k, reason: collision with root package name */
    public final int f23277k;

    /* renamed from: l, reason: collision with root package name */
    public final int f23278l;

    /* renamed from: m, reason: collision with root package name */
    public final int f23279m;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23280a;

        /* renamed from: b, reason: collision with root package name */
        public final long f23281b;

        /* renamed from: c, reason: collision with root package name */
        public final long f23282c;

        public b(int i7, long j7, long j8) {
            this.f23280a = i7;
            this.f23281b = j7;
            this.f23282c = j8;
        }
    }

    public d(long j7, boolean z7, boolean z8, boolean z9, boolean z10, long j8, long j9, List list, boolean z11, long j10, int i7, int i8, int i9) {
        this.f23267a = j7;
        this.f23268b = z7;
        this.f23269c = z8;
        this.f23270d = z9;
        this.f23271e = z10;
        this.f23272f = j8;
        this.f23273g = j9;
        this.f23274h = Collections.unmodifiableList(list);
        this.f23275i = z11;
        this.f23276j = j10;
        this.f23277k = i7;
        this.f23278l = i8;
        this.f23279m = i9;
    }

    public static d d(E e7, long j7, M m7) {
        List list;
        long j8;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i7;
        int iQ;
        int iQ2;
        boolean z11;
        int i8;
        long jE;
        long jS = e7.S();
        boolean z12 = (e7.Q() & 128) != 0;
        List list2 = Collections.EMPTY_LIST;
        long jS2 = -9223372036854775807L;
        if (z12) {
            list = list2;
            j8 = -9223372036854775807L;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            i7 = 0;
            iQ = 0;
            iQ2 = 0;
        } else {
            int iQ3 = e7.Q();
            boolean z13 = (iQ3 & 128) != 0;
            boolean z14 = (iQ3 & 64) != 0;
            boolean z15 = (iQ3 & 32) != 0;
            boolean z16 = (iQ3 & 16) != 0;
            long jE2 = (!z14 || z16) ? -9223372036854775807L : g.e(e7, j7);
            if (!z14) {
                int iQ4 = e7.Q();
                ArrayList arrayList = new ArrayList(iQ4);
                int i9 = 0;
                while (i9 < iQ4) {
                    int iQ5 = e7.Q();
                    if (z16) {
                        i8 = iQ4;
                        jE = -9223372036854775807L;
                    } else {
                        i8 = iQ4;
                        jE = g.e(e7, j7);
                    }
                    arrayList.add(new b(iQ5, jE, m7.b(jE)));
                    i9++;
                    iQ4 = i8;
                }
                list2 = arrayList;
            }
            if (z15) {
                long jQ = e7.Q();
                boolean z17 = (128 & jQ) != 0;
                jS2 = ((((jQ & 1) << 32) | e7.S()) * 1000) / 90;
                z11 = z17;
            } else {
                z11 = false;
            }
            int iY = e7.Y();
            long j9 = jE2;
            j8 = jS2;
            jS2 = j9;
            iQ = e7.Q();
            iQ2 = e7.Q();
            i7 = iY;
            z10 = z11;
            z7 = z13;
            z8 = z14;
            list = list2;
            z9 = z16;
        }
        return new d(jS, z12, z7, z8, z9, jS2, m7.b(jS2), list, z10, j8, i7, iQ, iQ2);
    }

    @Override // w1.AbstractC1727b
    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f23272f + ", programSplicePlaybackPositionUs= " + this.f23273g + " }";
    }
}
