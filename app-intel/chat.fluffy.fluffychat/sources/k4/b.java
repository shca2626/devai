package k4;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public D3.n f19060a;

    /* renamed from: b, reason: collision with root package name */
    public t f19061b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19062c = 2;

    public b(D3.n nVar, t tVar) {
        this.f19060a = nVar;
        this.f19061b = tVar;
    }

    public static List f(List list, t tVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(tVar.f((D3.p) it.next()));
        }
        return arrayList;
    }

    public D3.a a() {
        return this.f19060a.b();
    }

    public Bitmap b() {
        return this.f19061b.b(null, 2);
    }

    public byte[] c() {
        return this.f19060a.c();
    }

    public Map d() {
        return this.f19060a.d();
    }

    public String e() {
        return this.f19060a.f();
    }

    public String toString() {
        return this.f19060a.f();
    }
}
