package W;

import O.s;
import W.i;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import y.C1795j;
import y.C1796k;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final C1795j f8911a = new C1795j(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f8912b = j.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8913c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final C1796k f8914d = new C1796k();

    public class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8915a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8916b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ W.e f8917c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f8918d;

        public a(String str, Context context, W.e eVar, int i7) {
            this.f8915a = str;
            this.f8916b = context;
            this.f8917c = eVar;
            this.f8918d = i7;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return h.c(this.f8915a, this.f8916b, g.a(new Object[]{this.f8917c}), this.f8918d);
        }
    }

    public class b implements Y.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ W.a f8919a;

        public b(W.a aVar) {
            this.f8919a = aVar;
        }

        @Override // Y.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f8919a.b(eVar);
        }
    }

    public class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8920a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8921b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f8922c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f8923d;

        public c(String str, Context context, List list, int i7) {
            this.f8920a = str;
            this.f8921b = context;
            this.f8922c = list;
            this.f8923d = i7;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return h.c(this.f8920a, this.f8921b, this.f8922c, this.f8923d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements Y.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8924a;

        public d(String str) {
            this.f8924a = str;
        }

        @Override // Y.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (h.f8913c) {
                try {
                    C1796k c1796k = h.f8914d;
                    ArrayList arrayList = (ArrayList) c1796k.get(this.f8924a);
                    if (arrayList == null) {
                        return;
                    }
                    c1796k.remove(this.f8924a);
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        ((Y.a) arrayList.get(i7)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(List list, int i7) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < list.size(); i8++) {
            sb.append(((W.e) list.get(i8)).d());
            sb.append("-");
            sb.append(i7);
            if (i8 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static int b(i.a aVar) {
        int i7 = 1;
        if (aVar.e() != 0) {
            return aVar.e() != 1 ? -3 : -2;
        }
        i.b[] bVarArrC = aVar.c();
        if (bVarArrC != null && bVarArrC.length != 0) {
            i7 = 0;
            for (i.b bVar : bVarArrC) {
                int iA = bVar.a();
                if (iA != 0) {
                    if (iA < 0) {
                        return -3;
                    }
                    return iA;
                }
            }
        }
        return i7;
    }

    public static e c(String str, Context context, List list, int i7) {
        Y1.a.c("getFontSync");
        try {
            C1795j c1795j = f8911a;
            Typeface typeface = (Typeface) c1795j.c(str);
            if (typeface != null) {
                return new e(typeface);
            }
            i.a aVarE = W.d.e(context, list, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = (!aVarE.f() || Build.VERSION.SDK_INT < 29) ? s.b(context, null, aVarE.c(), i7) : s.c(context, null, aVarE.d(), i7);
            if (typefaceB == null) {
                return new e(-3);
            }
            c1795j.e(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            Y1.a.f();
        }
    }

    public static Typeface d(Context context, List list, int i7, Executor executor, W.a aVar) {
        String strA = a(list, i7);
        Typeface typeface = (Typeface) f8911a.c(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f8913c) {
            try {
                C1796k c1796k = f8914d;
                ArrayList arrayList = (ArrayList) c1796k.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                c1796k.put(strA, arrayList2);
                c cVar = new c(strA, context, list, i7);
                if (executor == null) {
                    executor = f8912b;
                }
                j.c(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, W.e eVar, W.a aVar, int i7, int i8) {
        String strA = a(g.a(new Object[]{eVar}), i7);
        Typeface typeface = (Typeface) f8911a.c(strA);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i8 == -1) {
            e eVarC = c(strA, context, g.a(new Object[]{eVar}), i7);
            aVar.b(eVarC);
            return eVarC.f8925a;
        }
        try {
            e eVar2 = (e) j.d(f8912b, new a(strA, context, eVar, i7), i8);
            aVar.b(eVar2);
            return eVar2.f8925a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f8925a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8926b;

        public e(int i7) {
            this.f8925a = null;
            this.f8926b = i7;
        }

        public boolean a() {
            return this.f8926b == 0;
        }

        public e(Typeface typeface) {
            this.f8925a = typeface;
            this.f8926b = 0;
        }
    }
}
