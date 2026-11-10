package J1;

import D0.a;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import j3.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f4661a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4662b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4663c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4664d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4665e;

    /* renamed from: f, reason: collision with root package name */
    public final g f4666f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f4667g;

    /* renamed from: h, reason: collision with root package name */
    public final String f4668h;

    /* renamed from: i, reason: collision with root package name */
    public final String f4669i;

    /* renamed from: j, reason: collision with root package name */
    public final c f4670j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f4671k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f4672l;

    /* renamed from: m, reason: collision with root package name */
    public List f4673m;

    public c(String str, String str2, long j7, long j8, g gVar, String[] strArr, String str3, String str4, c cVar) {
        this.f4661a = str;
        this.f4662b = str2;
        this.f4669i = str4;
        this.f4666f = gVar;
        this.f4667g = strArr;
        this.f4663c = str2 != null;
        this.f4664d = j7;
        this.f4665e = j8;
        this.f4668h = (String) o.q(str3);
        this.f4670j = cVar;
        this.f4671k = new HashMap();
        this.f4672l = new HashMap();
    }

    public static c c(String str, long j7, long j8, g gVar, String[] strArr, String str2, String str3, c cVar) {
        return new c(str, null, j7, j8, gVar, strArr, str2, str3, cVar);
    }

    public static c d(String str) {
        return new c(null, f.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length(); i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                int i9 = i8;
                while (i9 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i9) == ' ') {
                    i9++;
                }
                int i10 = i9 - i8;
                if (i10 > 0) {
                    spannableStringBuilder.delete(i7, i10 + i7);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i11 = 0; i11 < spannableStringBuilder.length() - 1; i11++) {
            if (spannableStringBuilder.charAt(i11) == '\n') {
                int i12 = i11 + 1;
                if (spannableStringBuilder.charAt(i12) == ' ') {
                    spannableStringBuilder.delete(i12, i11 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i13 = 0; i13 < spannableStringBuilder.length() - 1; i13++) {
            if (spannableStringBuilder.charAt(i13) == ' ') {
                int i14 = i13 + 1;
                if (spannableStringBuilder.charAt(i14) == '\n') {
                    spannableStringBuilder.delete(i13, i14);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    public static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            a.b bVar = new a.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) o.q(((a.b) map.get(str)).e());
    }

    public void a(c cVar) {
        if (this.f4673m == null) {
            this.f4673m = new ArrayList();
        }
        this.f4673m.add(cVar);
    }

    public final void b(Map map, a.b bVar, int i7, int i8, int i9) {
        g gVarF = f.f(this.f4666f, this.f4667g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (gVarF != null) {
            f.a(spannableStringBuilder2, i7, i8, gVarF, this.f4670j, map, i9);
            if ("p".equals(this.f4661a)) {
                if (gVarF.m() != Float.MAX_VALUE) {
                    bVar.m((gVarF.m() * (-90.0f)) / 100.0f);
                }
                if (gVarF.o() != null) {
                    bVar.p(gVarF.o());
                }
                if (gVarF.i() != null) {
                    bVar.j(gVarF.i());
                }
            }
        }
    }

    public c f(int i7) {
        List list = this.f4673m;
        if (list != null) {
            return (c) list.get(i7);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.f4673m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j7, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        n(j7, this.f4668h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j7, false, this.f4668h, treeMap);
        o(j7, map, map2, this.f4668h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            Pair pair = (Pair) obj;
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                e eVar = (e) o.q((e) map2.get(pair.first));
                arrayList2.add(new a.b().f(bitmapDecodeByteArray).k(eVar.f4689b).l(0).h(eVar.f4690c, 0).i(eVar.f4692e).n(eVar.f4693f).g(eVar.f4694g).r(eVar.f4697j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) o.q((e) map2.get(entry.getKey()));
            a.b bVar = (a.b) entry.getValue();
            e((SpannableStringBuilder) o.q(bVar.e()));
            bVar.h(eVar2.f4690c, eVar2.f4691d);
            bVar.i(eVar2.f4692e);
            bVar.k(eVar2.f4689b);
            bVar.n(eVar2.f4693f);
            bVar.q(eVar2.f4696i, eVar2.f4695h);
            bVar.r(eVar2.f4697j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet treeSet, boolean z7) {
        boolean zEquals = "p".equals(this.f4661a);
        boolean zEquals2 = "div".equals(this.f4661a);
        if (z7 || zEquals || (zEquals2 && this.f4669i != null)) {
            long j7 = this.f4664d;
            if (j7 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j7));
            }
            long j8 = this.f4665e;
            if (j8 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j8));
            }
        }
        if (this.f4673m == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f4673m.size(); i7++) {
            ((c) this.f4673m.get(i7)).i(treeSet, z7 || zEquals);
        }
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i7 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i7] = ((Long) it.next()).longValue();
            i7++;
        }
        return jArr;
    }

    public String[] l() {
        return this.f4667g;
    }

    public boolean m(long j7) {
        long j8 = this.f4664d;
        if (j8 == -9223372036854775807L && this.f4665e == -9223372036854775807L) {
            return true;
        }
        if (j8 <= j7 && this.f4665e == -9223372036854775807L) {
            return true;
        }
        if (j8 != -9223372036854775807L || j7 >= this.f4665e) {
            return j8 <= j7 && j7 < this.f4665e;
        }
        return true;
    }

    public final void n(long j7, String str, List list) {
        if (!"".equals(this.f4668h)) {
            str = this.f4668h;
        }
        if (m(j7) && "div".equals(this.f4661a) && this.f4669i != null) {
            list.add(new Pair(str, this.f4669i));
            return;
        }
        for (int i7 = 0; i7 < g(); i7++) {
            f(i7).n(j7, str, list);
        }
    }

    public final void o(long j7, Map map, Map map2, String str, Map map3) {
        if (m(j7)) {
            String str2 = "".equals(this.f4668h) ? str : this.f4668h;
            Iterator it = this.f4672l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int iIntValue = this.f4671k.containsKey(str3) ? ((Integer) this.f4671k.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (a.b) o.q((a.b) map3.get(str3)), iIntValue, iIntValue2, ((e) o.q((e) map2.get(str2))).f4697j);
                }
            }
            for (int i7 = 0; i7 < g(); i7++) {
                f(i7).o(j7, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j7, boolean z7, String str, Map map) {
        boolean z8;
        Map map2;
        long j8;
        this.f4671k.clear();
        this.f4672l.clear();
        if ("metadata".equals(this.f4661a)) {
            return;
        }
        if (!"".equals(this.f4668h)) {
            str = this.f4668h;
        }
        String str2 = str;
        if (this.f4663c && z7) {
            k(str2, map).append((CharSequence) o.q(this.f4662b));
            return;
        }
        if ("br".equals(this.f4661a) && z7) {
            k(str2, map).append('\n');
            return;
        }
        if (m(j7)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f4671k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) o.q(((a.b) entry.getValue()).e())).length()));
            }
            boolean zEquals = "p".equals(this.f4661a);
            int i7 = 0;
            while (i7 < g()) {
                c cVarF = f(i7);
                if (z7 || zEquals) {
                    z8 = true;
                    map2 = map;
                    j8 = j7;
                } else {
                    z8 = false;
                    j8 = j7;
                    map2 = map;
                }
                cVarF.p(j8, z8, str2, map2);
                i7++;
                j7 = j8;
                map = map2;
            }
            Map map3 = map;
            if (zEquals) {
                f.c(k(str2, map3));
            }
            for (Map.Entry entry2 : map3.entrySet()) {
                this.f4672l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) o.q(((a.b) entry2.getValue()).e())).length()));
            }
        }
    }
}
