package O;

import N.e;
import W.i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f6480a = new ConcurrentHashMap();

    public class a implements b {
        public a() {
        }

        @Override // O.z.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(i.b bVar) {
            return bVar.f();
        }

        @Override // O.z.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(i.b bVar) {
            return bVar.g();
        }
    }

    public interface b {
        int a(Object obj);

        boolean b(Object obj);
    }

    public static Object f(Object[] objArr, int i7, b bVar) {
        return g(objArr, (i7 & 1) == 0 ? 400 : 700, (i7 & 2) != 0, bVar);
    }

    public static Object g(Object[] objArr, int i7, boolean z7, b bVar) {
        Object obj = null;
        int i8 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(bVar.a(obj2) - i7) * 2) + (bVar.b(obj2) == z7 ? 0 : 1);
            if (obj == null || i8 > iAbs) {
                obj = obj2;
                i8 = iAbs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, e.b bVar, Resources resources, int i7);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, i.b[] bVarArr, int i7);

    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i7) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface d(Context context, InputStream inputStream) {
        File fileE = A.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (A.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i7, String str, int i8) {
        File fileE = A.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (A.c(fileE, resources, i7)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public i.b h(i.b[] bVarArr, int i7) {
        return (i.b) f(bVarArr, i7, new a());
    }
}
