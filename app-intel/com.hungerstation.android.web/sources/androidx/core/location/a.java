package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Field f6571a;

    /* renamed from: b, reason: collision with root package name */
    private static Integer f6572b;

    /* renamed from: c, reason: collision with root package name */
    private static Integer f6573c;

    /* renamed from: d, reason: collision with root package name */
    private static Integer f6574d;

    /* renamed from: androidx.core.location.a$a, reason: collision with other inner class name */
    private static class C0119a {
        static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        static void g(Location location) throws IllegalAccessException, IllegalArgumentException {
            try {
                a.d().setByte(location, (byte) (a.d().getByte(location) & (~a.e())));
            } catch (IllegalAccessException e12) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e12);
                throw illegalAccessError;
            } catch (NoSuchFieldException e13) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e13);
                throw noSuchFieldError;
            }
        }

        static void h(Location location) throws IllegalAccessException, IllegalArgumentException {
            try {
                a.d().setByte(location, (byte) (a.d().getByte(location) & (~a.f())));
            } catch (IllegalAccessException e12) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e12);
                throw illegalAccessError;
            } catch (NoSuchFieldException e13) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e13);
                throw noSuchFieldError;
            }
        }

        static void i(Location location) throws IllegalAccessException, IllegalArgumentException {
            try {
                a.d().setByte(location, (byte) (a.d().getByte(location) & (~a.g())));
            } catch (IllegalAccessException | NoSuchFieldException e12) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e12);
                throw illegalAccessError;
            }
        }

        static void j(Location location, float f12) {
            location.setBearingAccuracyDegrees(f12);
        }

        static void k(Location location, float f12) {
            location.setSpeedAccuracyMetersPerSecond(f12);
        }

        static void l(Location location, float f12) {
            location.setVerticalAccuracyMeters(f12);
        }
    }

    private static boolean a(Location location, String str) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(str);
    }

    public static float b(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C0119a.a(location);
        }
        Bundle extras = location.getExtras();
        return extras == null ? BitmapDescriptorFactory.HUE_RED : extras.getFloat("bearingAccuracy", BitmapDescriptorFactory.HUE_RED);
    }

    public static long c(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    @SuppressLint({"BlockedPrivateApi"})
    static Field d() throws NoSuchFieldException, SecurityException {
        if (f6571a == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            f6571a = declaredField;
            declaredField.setAccessible(true);
        }
        return f6571a;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int e() throws IllegalAccessException, NoSuchFieldException, SecurityException {
        if (f6573c == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f6573c = Integer.valueOf(declaredField.getInt(null));
        }
        return f6573c.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int f() throws IllegalAccessException, NoSuchFieldException, SecurityException {
        if (f6572b == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f6572b = Integer.valueOf(declaredField.getInt(null));
        }
        return f6572b.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int g() throws IllegalAccessException, NoSuchFieldException, SecurityException {
        if (f6574d == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f6574d = Integer.valueOf(declaredField.getInt(null));
        }
        return f6574d.intValue();
    }

    public static float h(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C0119a.b(location);
        }
        Bundle extras = location.getExtras();
        return extras == null ? BitmapDescriptorFactory.HUE_RED : extras.getFloat("speedAccuracy", BitmapDescriptorFactory.HUE_RED);
    }

    public static float i(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C0119a.c(location);
        }
        Bundle extras = location.getExtras();
        return extras == null ? BitmapDescriptorFactory.HUE_RED : extras.getFloat(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, BitmapDescriptorFactory.HUE_RED);
    }

    public static boolean j(Location location) {
        return Build.VERSION.SDK_INT >= 26 ? C0119a.d(location) : a(location, "bearingAccuracy");
    }

    public static boolean k(Location location) {
        return Build.VERSION.SDK_INT >= 26 ? C0119a.e(location) : a(location, "speedAccuracy");
    }

    public static boolean l(Location location) {
        return Build.VERSION.SDK_INT >= 26 ? C0119a.f(location) : a(location, FusedLocationProviderClient.KEY_VERTICAL_ACCURACY);
    }

    public static boolean m(Location location) {
        return location.isFromMockProvider();
    }
}
