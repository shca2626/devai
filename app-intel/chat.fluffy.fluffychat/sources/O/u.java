package O;

import N.e;
import W.i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import y.C1797k;

/* loaded from: classes.dex */
public class u extends z {

    /* renamed from: b, reason: collision with root package name */
    public static final Class f6469b;

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor f6470c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f6471d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f6472e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e7) {
            Log.e("TypefaceCompatApi24Impl", e7.getClass().getName(), e7);
            cls = null;
            method = null;
            method2 = null;
        }
        f6470c = constructor;
        f6469b = cls;
        f6471d = method2;
        f6472e = method;
    }

    public static boolean i(Object obj, ByteBuffer byteBuffer, int i7, int i8, boolean z7) {
        try {
            return ((Boolean) f6471d.invoke(obj, byteBuffer, Integer.valueOf(i7), null, Integer.valueOf(i8), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface j(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f6469b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f6472e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean k() {
        Method method = f6471d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object l() {
        try {
            return f6470c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // O.z
    public Typeface a(Context context, e.b bVar, Resources resources, int i7) {
        Object objL = l();
        if (objL == null) {
            return null;
        }
        for (e.c cVar : bVar.a()) {
            ByteBuffer byteBufferB = A.b(context, resources, cVar.b());
            if (byteBufferB == null || !i(objL, byteBufferB, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return j(objL);
    }

    @Override // O.z
    public Typeface b(Context context, CancellationSignal cancellationSignal, i.b[] bVarArr, int i7) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objL = l();
        if (objL == null) {
            return null;
        }
        C1797k c1797k = new C1797k();
        for (i.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) c1797k.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = A.f(context, cancellationSignal, uriD);
                c1797k.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !i(objL, byteBufferF, bVar.c(), bVar.f(), bVar.g())) {
                return null;
            }
        }
        Typeface typefaceJ = j(objL);
        if (typefaceJ == null) {
            return null;
        }
        return Typeface.create(typefaceJ, i7);
    }
}
