package L0;

import E0.U;
import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import k3.D;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f5426a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f5427b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f5428c;

    /* renamed from: d, reason: collision with root package name */
    public final Random f5429d;

    public b() {
        this(new Random());
    }

    public static void b(Object obj, long j7, Map map) {
        if (map.containsKey(obj)) {
            j7 = Math.max(j7, ((Long) U.i((Long) map.get(obj))).longValue());
        }
        map.put(obj, Long.valueOf(j7));
    }

    public static int d(M0.b bVar, M0.b bVar2) {
        int iCompare = Integer.compare(bVar.f5531c, bVar2.f5531c);
        return iCompare != 0 ? iCompare : bVar.f5530b.compareTo(bVar2.f5530b);
    }

    public static int f(List list) {
        HashSet hashSet = new HashSet();
        for (int i7 = 0; i7 < list.size(); i7++) {
            hashSet.add(Integer.valueOf(((M0.b) list.get(i7)).f5531c));
        }
        return hashSet.size();
    }

    public static void h(long j7, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j7) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            map.remove(arrayList.get(i7));
        }
    }

    public final List c(List list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h(jElapsedRealtime, this.f5426a);
        h(jElapsedRealtime, this.f5427b);
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < list.size(); i7++) {
            M0.b bVar = (M0.b) list.get(i7);
            if (!this.f5426a.containsKey(bVar.f5530b) && !this.f5427b.containsKey(Integer.valueOf(bVar.f5531c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void e(M0.b bVar, long j7) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j7;
        b(bVar.f5530b, jElapsedRealtime, this.f5426a);
        int i7 = bVar.f5531c;
        if (i7 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i7), jElapsedRealtime, this.f5427b);
        }
    }

    public int g(List list) {
        HashSet hashSet = new HashSet();
        List listC = c(list);
        for (int i7 = 0; i7 < listC.size(); i7++) {
            hashSet.add(Integer.valueOf(((M0.b) listC.get(i7)).f5531c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f5426a.clear();
        this.f5427b.clear();
        this.f5428c.clear();
    }

    public M0.b j(List list) {
        List listC = c(list);
        if (listC.size() < 2) {
            return (M0.b) D.c(listC, null);
        }
        Collections.sort(listC, new Comparator() { // from class: L0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.d((M0.b) obj, (M0.b) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i7 = ((M0.b) listC.get(0)).f5531c;
        int i8 = 0;
        while (true) {
            if (i8 >= listC.size()) {
                break;
            }
            M0.b bVar = (M0.b) listC.get(i8);
            if (i7 == bVar.f5531c) {
                arrayList.add(new Pair(bVar.f5530b, Integer.valueOf(bVar.f5532d)));
                i8++;
            } else if (arrayList.size() == 1) {
                return (M0.b) listC.get(0);
            }
        }
        M0.b bVar2 = (M0.b) this.f5428c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        M0.b bVarK = k(listC.subList(0, arrayList.size()));
        this.f5428c.put(arrayList, bVarK);
        return bVarK;
    }

    public final M0.b k(List list) {
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += ((M0.b) list.get(i8)).f5532d;
        }
        int iNextInt = this.f5429d.nextInt(i7);
        int i9 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            M0.b bVar = (M0.b) list.get(i10);
            i9 += bVar.f5532d;
            if (iNextInt < i9) {
                return bVar;
            }
        }
        return (M0.b) D.d(list);
    }

    public b(Random random) {
        this.f5428c = new HashMap();
        this.f5429d = random;
        this.f5426a = new HashMap();
        this.f5427b = new HashMap();
    }
}
