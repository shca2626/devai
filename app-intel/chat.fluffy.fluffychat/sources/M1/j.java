package M1;

import D1.k;
import E0.U;
import j3.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public final class j implements k {

    /* renamed from: l, reason: collision with root package name */
    public final List f5677l;

    /* renamed from: m, reason: collision with root package name */
    public final long[] f5678m;

    /* renamed from: n, reason: collision with root package name */
    public final long[] f5679n;

    public j(List list) {
        this.f5677l = Collections.unmodifiableList(new ArrayList(list));
        this.f5678m = new long[list.size() * 2];
        for (int i7 = 0; i7 < list.size(); i7++) {
            d dVar = (d) list.get(i7);
            int i8 = i7 * 2;
            long[] jArr = this.f5678m;
            jArr[i8] = dVar.f5648b;
            jArr[i8 + 1] = dVar.f5649c;
        }
        long[] jArr2 = this.f5678m;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f5679n = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // D1.k
    public int a(long j7) {
        int iD = U.d(this.f5679n, j7, false, false);
        if (iD < this.f5679n.length) {
            return iD;
        }
        return -1;
    }

    @Override // D1.k
    public long d(int i7) {
        o.d(i7 >= 0);
        o.d(i7 < this.f5679n.length);
        return this.f5679n[i7];
    }

    @Override // D1.k
    public List e(long j7) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < this.f5677l.size(); i7++) {
            long[] jArr = this.f5678m;
            int i8 = i7 * 2;
            if (jArr[i8] <= j7 && j7 < jArr[i8 + 1]) {
                d dVar = (d) this.f5677l.get(i7);
                D0.a aVar = dVar.f5647a;
                if (aVar.f1556e == -3.4028235E38f) {
                    arrayList2.add(dVar);
                } else {
                    arrayList.add(aVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: M1.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((d) obj).f5648b, ((d) obj2).f5648b);
            }
        });
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            arrayList.add(((d) arrayList2.get(i9)).f5647a.a().h((-1) - i9, 1).a());
        }
        return arrayList;
    }

    @Override // D1.k
    public int f() {
        return this.f5679n.length;
    }
}
