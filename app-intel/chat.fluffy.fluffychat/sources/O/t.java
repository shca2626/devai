package O;

import N.e;
import W.i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class t extends z {

    /* renamed from: b, reason: collision with root package name */
    public static Class f6464b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Constructor f6465c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Method f6466d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Method f6467e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f6468f = false;

    public static boolean i(Object obj, String str, int i7, boolean z7) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        l();
        try {
            return ((Boolean) f6466d.invoke(obj, str, Integer.valueOf(i7), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    private static Typeface j(Object obj) throws NoSuchMethodException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        l();
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f6464b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f6467e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static void l() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f6468f) {
            return;
        }
        f6468f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e7) {
            Log.e("TypefaceCompatApi21Impl", e7.getClass().getName(), e7);
            method = null;
            cls = null;
            method2 = null;
        }
        f6465c = constructor;
        f6464b = cls;
        f6466d = method2;
        f6467e = method;
    }

    private static Object m() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        l();
        try {
            return f6465c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // O.z
    public Typeface a(Context context, e.b bVar, Resources resources, int i7) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Object objM = m();
        for (e.c cVar : bVar.a()) {
            File fileE = A.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!A.c(fileE, resources, cVar.b())) {
                    return null;
                }
                if (!i(objM, fileE.getPath(), cVar.e(), cVar.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return j(objM);
    }

    @Override // O.z
    public Typeface b(Context context, CancellationSignal cancellationSignal, i.b[] bVarArr, int i7) throws IOException {
        Typeface typefaceD;
        if (bVarArr.length < 1) {
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
                File fileK = k(parcelFileDescriptorOpenFileDescriptor);
                if (fileK == null || !fileK.canRead()) {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        typefaceD = super.d(context, fileInputStream);
                        fileInputStream.close();
                    } finally {
                    }
                } else {
                    typefaceD = Typeface.createFromFile(fileK);
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                return typefaceD;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final File k(ParcelFileDescriptor parcelFileDescriptor) throws ErrnoException {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }
}
