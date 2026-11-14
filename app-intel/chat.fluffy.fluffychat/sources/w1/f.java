package w1;

import E0.E;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends AbstractC1727b {

    /* renamed from: a, reason: collision with root package name */
    public final List f23283a;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23284a;

        /* renamed from: b, reason: collision with root package name */
        public final long f23285b;

        public b(int i7, long j7) {
            this.f23284a = i7;
            this.f23285b = j7;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f23286a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f23287b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f23288c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f23289d;

        /* renamed from: e, reason: collision with root package name */
        public final long f23290e;

        /* renamed from: f, reason: collision with root package name */
        public final List f23291f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f23292g;

        /* renamed from: h, reason: collision with root package name */
        public final long f23293h;

        /* renamed from: i, reason: collision with root package name */
        public final int f23294i;

        /* renamed from: j, reason: collision with root package name */
        public final int f23295j;

        /* renamed from: k, reason: collision with root package name */
        public final int f23296k;

        public c(long j7, boolean z7, boolean z8, boolean z9, List list, long j8, boolean z10, long j9, int i7, int i8, int i9) {
            this.f23286a = j7;
            this.f23287b = z7;
            this.f23288c = z8;
            this.f23289d = z9;
            this.f23291f = Collections.unmodifiableList(list);
            this.f23290e = j8;
            this.f23292g = z10;
            this.f23293h = j9;
            this.f23294i = i7;
            this.f23295j = i8;
            this.f23296k = i9;
        }

        public static c b(E e7) {
            boolean z7;
            ArrayList arrayList;
            boolean z8;
            boolean z9;
            long j7;
            boolean z10;
            long j8;
            int i7;
            int i8;
            int iQ;
            boolean z11;
            long jS;
            long jS2 = e7.S();
            boolean z12 = true;
            if ((e7.Q() & 128) != 0) {
                z7 = true;
            } else {
                z7 = true;
                z12 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (z12) {
                arrayList = arrayList2;
                z8 = false;
                z9 = false;
                j7 = -9223372036854775807L;
                z10 = false;
                j8 = -9223372036854775807L;
                i7 = 0;
                i8 = 0;
                iQ = 0;
            } else {
                int iQ2 = e7.Q();
                boolean z13 = (iQ2 & 128) != 0 ? z7 : false;
                boolean z14 = (iQ2 & 64) != 0 ? z7 : false;
                boolean z15 = (iQ2 & 32) != 0 ? z7 : false;
                long jS3 = z14 ? e7.S() : -9223372036854775807L;
                if (!z14) {
                    int iQ3 = e7.Q();
                    ArrayList arrayList3 = new ArrayList(iQ3);
                    int i9 = 0;
                    while (i9 < iQ3) {
                        arrayList3.add(new b(e7.Q(), e7.S()));
                        i9++;
                        iQ3 = iQ3;
                    }
                    arrayList2 = arrayList3;
                }
                if (z15) {
                    long jQ = e7.Q();
                    boolean z16 = (128 & jQ) != 0;
                    jS = ((((jQ & 1) << 32) | e7.S()) * 1000) / 90;
                    z11 = z16;
                } else {
                    z11 = false;
                    jS = -9223372036854775807L;
                }
                int iY = e7.Y();
                int iQ4 = e7.Q();
                boolean z17 = z13;
                z10 = z11;
                z8 = z17;
                iQ = e7.Q();
                long j9 = jS3;
                i7 = iY;
                i8 = iQ4;
                long j10 = jS;
                arrayList = arrayList2;
                z9 = z14;
                j7 = j9;
                j8 = j10;
            }
            return new c(jS2, z12, z8, z9, arrayList, j7, z10, j8, i7, i8, iQ);
        }
    }

    public f(List list) {
        this.f23283a = Collections.unmodifiableList(list);
    }

    public static f d(E e7) {
        int iQ = e7.Q();
        ArrayList arrayList = new ArrayList(iQ);
        for (int i7 = 0; i7 < iQ; i7++) {
            arrayList.add(c.b(e7));
        }
        return new f(arrayList);
    }
}
