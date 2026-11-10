package cl;

import cl.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes8.dex */
public class z {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator<b> f17444h = new Comparator() { // from class: cl.x
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return z.g((z.b) obj, (z.b) obj2);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator<b> f17445i = new Comparator() { // from class: cl.y
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return z.h((z.b) obj, (z.b) obj2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f17446a;

    /* renamed from: e, reason: collision with root package name */
    private int f17450e;

    /* renamed from: f, reason: collision with root package name */
    private int f17451f;

    /* renamed from: g, reason: collision with root package name */
    private int f17452g;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f17448c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f17447b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private int f17449d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f17453a;

        /* renamed from: b, reason: collision with root package name */
        public int f17454b;

        /* renamed from: c, reason: collision with root package name */
        public float f17455c;

        private b() {
        }
    }

    public z(int i12) {
        this.f17446a = i12;
    }

    private void d() {
        if (this.f17449d != 1) {
            Collections.sort(this.f17447b, f17444h);
            this.f17449d = 1;
        }
    }

    private void e() {
        if (this.f17449d != 0) {
            Collections.sort(this.f17447b, f17445i);
            this.f17449d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f17453a - bVar2.f17453a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f17455c, bVar2.f17455c);
    }

    public void c(int i12, float f12) {
        b bVar;
        d();
        int i13 = this.f17452g;
        if (i13 > 0) {
            b[] bVarArr = this.f17448c;
            int i14 = i13 - 1;
            this.f17452g = i14;
            bVar = bVarArr[i14];
        } else {
            bVar = new b();
        }
        int i15 = this.f17450e;
        this.f17450e = i15 + 1;
        bVar.f17453a = i15;
        bVar.f17454b = i12;
        bVar.f17455c = f12;
        this.f17447b.add(bVar);
        this.f17451f += i12;
        while (true) {
            int i16 = this.f17451f;
            int i17 = this.f17446a;
            if (i16 <= i17) {
                return;
            }
            int i18 = i16 - i17;
            b bVar2 = this.f17447b.get(0);
            int i19 = bVar2.f17454b;
            if (i19 <= i18) {
                this.f17451f -= i19;
                this.f17447b.remove(0);
                int i22 = this.f17452g;
                if (i22 < 5) {
                    b[] bVarArr2 = this.f17448c;
                    this.f17452g = i22 + 1;
                    bVarArr2[i22] = bVar2;
                }
            } else {
                bVar2.f17454b = i19 - i18;
                this.f17451f -= i18;
            }
        }
    }

    public float f(float f12) {
        e();
        float f13 = f12 * this.f17451f;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f17447b.size(); i13++) {
            b bVar = this.f17447b.get(i13);
            i12 += bVar.f17454b;
            if (i12 >= f13) {
                return bVar.f17455c;
            }
        }
        if (this.f17447b.isEmpty()) {
            return Float.NaN;
        }
        return this.f17447b.get(r5.size() - 1).f17455c;
    }

    public void i() {
        this.f17447b.clear();
        this.f17449d = -1;
        this.f17450e = 0;
        this.f17451f = 0;
    }
}
