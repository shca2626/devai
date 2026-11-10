package O;

import N.e;
import W.i;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class v extends t {

    /* renamed from: g, reason: collision with root package name */
    public final Class f6473g;

    /* renamed from: h, reason: collision with root package name */
    public final Constructor f6474h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f6475i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f6476j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f6477k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f6478l;

    /* renamed from: m, reason: collision with root package name */
    public final Method f6479m;

    public v() {
        Class clsW;
        Constructor constructorX;
        Method methodT;
        Method methodU;
        Method methodY;
        Method methodS;
        Method methodV;
        try {
            clsW = w();
            constructorX = x(clsW);
            methodT = t(clsW);
            methodU = u(clsW);
            methodY = y(clsW);
            methodS = s(clsW);
            methodV = v(clsW);
        } catch (ClassNotFoundException | NoSuchMethodException e7) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e7.getClass().getName(), e7);
            clsW = null;
            constructorX = null;
            methodT = null;
            methodU = null;
            methodY = null;
            methodS = null;
            methodV = null;
        }
        this.f6473g = clsW;
        this.f6474h = constructorX;
        this.f6475i = methodT;
        this.f6476j = methodU;
        this.f6477k = methodY;
        this.f6478l = methodS;
        this.f6479m = methodV;
    }

    @Override // O.t, O.z
    public Typeface a(Context context, e.b bVar, Resources resources, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!r()) {
            return super.a(context, bVar, resources, i7);
        }
        Object objM = m();
        if (objM == null) {
            return null;
        }
        e.c[] cVarArrA = bVar.a();
        int length = cVarArrA.length;
        int i8 = 0;
        while (i8 < length) {
            e.c cVar = cVarArrA[i8];
            Context context2 = context;
            if (!o(context2, objM, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                n(objM);
                return null;
            }
            i8++;
            context = context2;
        }
        if (q(objM)) {
            return j(objM);
        }
        return null;
    }

    @Override // O.t, O.z
    public Typeface b(Context context, CancellationSignal cancellationSignal, i.b[] bVarArr, int i7) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Typeface typefaceJ;
        Object obj;
        if (bVarArr.length < 1) {
            return null;
        }
        if (r()) {
            Map mapH = A.h(context, bVarArr, cancellationSignal);
            Object objM = m();
            if (objM == null) {
                return null;
            }
            int length = bVarArr.length;
            int i8 = 0;
            boolean z7 = false;
            while (i8 < length) {
                i.b bVar = bVarArr[i8];
                ByteBuffer byteBuffer = (ByteBuffer) mapH.get(bVar.d());
                if (byteBuffer == null) {
                    obj = objM;
                } else {
                    boolean zP = p(objM, byteBuffer, bVar.c(), bVar.f(), bVar.g() ? 1 : 0);
                    obj = objM;
                    if (!zP) {
                        n(obj);
                        return null;
                    }
                    z7 = true;
                }
                i8++;
                objM = obj;
                z7 = z7;
            }
            Object obj2 = objM;
            if (!z7) {
                n(obj2);
                return null;
            }
            if (q(obj2) && (typefaceJ = j(obj2)) != null) {
                return Typeface.create(typefaceJ, i7);
            }
            return null;
        }
        i.b bVarH = h(bVarArr, i7);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarH.d(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarH.f()).setItalic(bVarH.g()).build();
                parcelFileDescriptorOpenFileDescriptor.close();
                return typefaceBuild;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // O.z
    public /* bridge */ /* synthetic */ Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i7) {
        return super.c(context, cancellationSignal, list, i7);
    }

    @Override // O.z
    public Typeface e(Context context, Resources resources, int i7, String str, int i8) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!r()) {
            return super.e(context, resources, i7, str, i8);
        }
        Object objM = m();
        if (objM == null) {
            return null;
        }
        if (!o(context, objM, str, 0, -1, -1, null)) {
            n(objM);
            return null;
        }
        if (q(objM)) {
            return j(objM);
        }
        return null;
    }

    public Typeface j(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f6473g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f6479m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Object m() {
        try {
            return this.f6474h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void n(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f6478l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean o(Context context, Object obj, String str, int i7, int i8, int i9, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f6475i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean p(Object obj, ByteBuffer byteBuffer, int i7, int i8, int i9) {
        try {
            return ((Boolean) this.f6476j.invoke(obj, byteBuffer, Integer.valueOf(i7), null, Integer.valueOf(i8), Integer.valueOf(i9))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean q(Object obj) {
        try {
            return ((Boolean) this.f6477k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean r() {
        if (this.f6475i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f6475i != null;
    }

    public Method s(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    public Method t(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    public Method u(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method v(Class cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class w() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor x(Class cls) {
        return cls.getConstructor(null);
    }

    public Method y(Class cls) {
        return cls.getMethod("freeze", null);
    }
}
