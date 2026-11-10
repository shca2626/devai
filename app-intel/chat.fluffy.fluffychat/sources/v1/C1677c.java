package v1;

import B0.y;
import E0.U;
import j3.o;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import k3.AbstractC1272n;
import v1.C1677c;

/* renamed from: v1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1677c implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f22904a;

    /* renamed from: v1.c$a */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        public static final Comparator f22905d = new Comparator() { // from class: v1.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                C1677c.a aVar = (C1677c.a) obj;
                C1677c.a aVar2 = (C1677c.a) obj2;
                return AbstractC1272n.j().e(aVar.f22906a, aVar2.f22906a).e(aVar.f22907b, aVar2.f22907b).d(aVar.f22908c, aVar2.f22908c).i();
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f22906a;

        /* renamed from: b, reason: collision with root package name */
        public final long f22907b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22908c;

        public a(long j7, long j8, int i7) {
            o.d(j7 < j8);
            this.f22906a = j7;
            this.f22907b = j8;
            this.f22908c = i7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f22906a == aVar.f22906a && this.f22907b == aVar.f22907b && this.f22908c == aVar.f22908c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f22906a), Long.valueOf(this.f22907b), Integer.valueOf(this.f22908c));
        }

        public String toString() {
            return U.G("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f22906a), Long.valueOf(this.f22907b), Integer.valueOf(this.f22908c));
        }
    }

    public C1677c(List list) {
        this.f22904a = list;
        o.d(!d(list));
    }

    public static boolean d(List list) {
        if (list.isEmpty()) {
            return false;
        }
        long j7 = ((a) list.get(0)).f22907b;
        for (int i7 = 1; i7 < list.size(); i7++) {
            if (((a) list.get(i7)).f22906a < j7) {
                return true;
            }
            j7 = ((a) list.get(i7)).f22907b;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1677c.class != obj.getClass()) {
            return false;
        }
        return this.f22904a.equals(((C1677c) obj).f22904a);
    }

    public int hashCode() {
        return this.f22904a.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f22904a;
    }
}
