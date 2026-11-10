package E0;

import B0.D;
import B0.s;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import j$.util.DesugarTimeZone;
import j3.AbstractC1229c;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import l3.AbstractC1304a;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;

/* loaded from: classes.dex */
public abstract class U {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2093a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f2094b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f2095c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f2096d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f2097e;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f2098f;

    /* renamed from: g, reason: collision with root package name */
    public static final long[] f2099g;

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f2100h;

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f2101i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f2102j;

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f2103k;

    /* renamed from: l, reason: collision with root package name */
    public static HashMap f2104l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f2105m;

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f2106n;

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2107o;

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f2108p;

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f2109q;

    static {
        int i7 = Build.VERSION.SDK_INT;
        f2093a = i7;
        String str = Build.DEVICE;
        f2094b = str;
        String str2 = Build.MANUFACTURER;
        f2095c = str2;
        String str3 = Build.MODEL;
        f2096d = str3;
        f2097e = str + ", " + str3 + ", " + str2 + ", " + i7;
        f2098f = new byte[0];
        f2099g = new long[0];
        f2100h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt ](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)?))?");
        f2101i = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f2102j = Pattern.compile("%([A-Fa-f0-9]{2})");
        f2103k = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f2105m = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f2106n = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f2107o = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f2108p = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        f2109q = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static Handler A(Handler.Callback callback) {
        return y((Looper) j3.o.q(Looper.myLooper()), callback);
    }

    public static String A0(int i7) {
        return Integer.toString(i7, 36);
    }

    public static Handler B() {
        return C(null);
    }

    public static boolean B0(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static Handler C(Handler.Callback callback) {
        return y(Y(), callback);
    }

    public static boolean C0(String str) {
        str.getClass();
        switch (str) {
            case "image/avif":
                return Build.VERSION.SDK_INT >= 34;
            case "image/heic":
            case "image/heif":
                return Build.VERSION.SDK_INT >= 26;
            case "image/jpeg":
            case "image/webp":
            case "image/bmp":
            case "image/png":
                return true;
            default:
                return false;
        }
    }

    public static HashMap D() throws MissingResourceException {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length + f2105m.length);
        int i7 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f2105m;
            if (i7 >= strArr.length) {
                return map;
            }
            map.put(strArr[i7], strArr[i7 + 1]);
            i7 += 2;
        }
    }

    public static boolean D0(int i7) {
        return i7 == 21 || i7 == 1342177280 || i7 == 22 || i7 == 1610612736 || i7 == 4;
    }

    public static long E(long j7, int i7) {
        return g1(j7, i7, 1000000L, RoundingMode.UP);
    }

    public static boolean E0(int i7) {
        return i7 == 3 || i7 == 2 || i7 == 268435456 || i7 == 21 || i7 == 1342177280 || i7 == 22 || i7 == 1610612736 || i7 == 4;
    }

    public static Uri F(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f2103k.matcher(path);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static boolean F0(Context context) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i7 == 30) {
            String str = Build.MODEL;
            if (AbstractC1229c.a(str, "moto g(20)") || AbstractC1229c.a(str, "rmx3231")) {
                return true;
            }
        }
        return i7 == 34 && AbstractC1229c.a(Build.MODEL, "sm-x200");
    }

    public static String G(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean G0(int i7) {
        return i7 == 10 || i7 == 13;
    }

    public static String H(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static boolean H0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || Objects.equals(scheme, "file");
    }

    public static String I(byte[] bArr, int i7, int i8) {
        return new String(bArr, i7, i8, StandardCharsets.UTF_8);
    }

    public static boolean I0() {
        String strF = AbstractC1229c.f(Build.DEVICE);
        return strF.contains("emulator") || strF.contains("emu64a") || strF.contains("emu64x") || strF.contains("generic");
    }

    public static int J(Context context) {
        int iGenerateAudioSessionId = C0.s.c(context).generateAudioSessionId();
        if (iGenerateAudioSessionId != -1) {
            return iGenerateAudioSessionId;
        }
        return 0;
    }

    public static boolean J0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static int K(int i7) {
        if (i7 == 30) {
            return 34;
        }
        switch (i7) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i7) {
                    case StdKeyDeserializer.TYPE_URL /* 14 */:
                        return 25;
                    case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                    case 16:
                    case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                    case 18:
                        return 28;
                    default:
                        switch (i7) {
                            case 20:
                                return 30;
                            case 21:
                            case 22:
                                return 31;
                            default:
                                return Integer.MAX_VALUE;
                        }
                }
        }
    }

    public static boolean K0(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static AudioFormat L(int i7, int i8, int i9) {
        return new AudioFormat.Builder().setSampleRate(i7).setChannelMask(i8).setEncoding(i9).build();
    }

    public static int L0(int[] iArr, int i7) {
        for (int i8 = 0; i8 < iArr.length; i8++) {
            if (iArr[i8] == i7) {
                return i8;
            }
        }
        return -1;
    }

    public static int M(int i7) {
        if (i7 == 10) {
            return Build.VERSION.SDK_INT >= 32 ? 737532 : 6396;
        }
        if (i7 == 16) {
            return Build.VERSION.SDK_INT >= 32 ? 205215996 : 0;
        }
        if (i7 == 24) {
            return Build.VERSION.SDK_INT >= 32 ? 67108860 : 0;
        }
        switch (i7) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                switch (i7) {
                    case 13:
                        if (Build.VERSION.SDK_INT >= 32) {
                        }
                        break;
                    case StdKeyDeserializer.TYPE_URL /* 14 */:
                        if (Build.VERSION.SDK_INT >= 32) {
                        }
                        break;
                }
        }
        return 0;
    }

    public static boolean M0(E e7, E e8, Inflater inflater) {
        return e7.a() > 0 && e7.q() == 120 && z0(e7, e8, inflater);
    }

    public static String N(int i7) {
        if (i7 == 0) {
            return "undefined";
        }
        if (i7 == 1) {
            return "original";
        }
        if (i7 == 2) {
            return "depth-linear";
        }
        if (i7 == 3) {
            return "depth-inverse";
        }
        if (i7 == 4) {
            return "depth metadata";
        }
        throw new IllegalStateException("Unsupported auxiliary track type");
    }

    public static String N0(String str) {
        int i7 = 0;
        while (true) {
            String[] strArr = f2106n;
            if (i7 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i7])) {
                return strArr[i7 + 1] + str.substring(strArr[i7].length());
            }
            i7 += 2;
        }
    }

    public static D.b O(B0.D d7, D.b bVar) {
        boolean zO = d7.o();
        boolean zL = d7.L();
        boolean zC = d7.C();
        boolean zQ = d7.Q();
        boolean zH0 = d7.h0();
        boolean zY = d7.Y();
        boolean zQ2 = d7.b0().q();
        boolean z7 = false;
        D.b.a aVarD = new D.b.a().b(bVar).d(4, !zO).d(5, zL && !zO).d(6, zC && !zO).d(7, !zQ2 && (zC || !zH0 || zL) && !zO).d(8, zQ && !zO).d(9, !zQ2 && (zQ || (zH0 && zY)) && !zO).d(10, !zO).d(11, zL && !zO);
        if (zL && !zO) {
            z7 = true;
        }
        return aVarD.d(12, z7).e();
    }

    public static void O0(List list, int i7, int i8, int i9) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i10 = (i8 - i7) - 1; i10 >= 0; i10--) {
            arrayDeque.addFirst(list.remove(i7 + i10));
        }
        list.addAll(Math.min(i9, list.size()), arrayDeque);
    }

    public static int P(ByteBuffer byteBuffer, int i7) {
        int i8 = byteBuffer.getInt(i7);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i8 : Integer.reverseBytes(i8);
    }

    public static long P0(long j7) {
        return (j7 == -9223372036854775807L || j7 == Long.MIN_VALUE) ? j7 : j7 * 1000;
    }

    public static int Q(int i7) {
        if (i7 != 2) {
            if (i7 == 3) {
                return 1;
            }
            if (i7 != 4) {
                if (i7 != 21) {
                    if (i7 != 22) {
                        if (i7 != 268435456) {
                            if (i7 != 1342177280) {
                                if (i7 != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static ExecutorService Q0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: E0.S
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return U.b(str, runnable);
            }
        });
    }

    public static byte[] R(String str) {
        return AbstractC1304a.a().i().b(str);
    }

    public static ScheduledExecutorService R0(final String str) {
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: E0.T
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return U.a(str, runnable);
            }
        });
    }

    public static int S(String str, int i7) {
        int i8 = 0;
        for (String str2 : m1(str)) {
            if (i7 == B0.z.m(str2)) {
                i8++;
            }
        }
        return i8;
    }

    public static String S0(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strF = AbstractC1229c.f(str);
        String str2 = l1(strF, "-")[0];
        if (f2104l == null) {
            f2104l = D();
        }
        String str3 = (String) f2104l.get(str2);
        if (str3 != null) {
            strF = str3 + strF.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? N0(strF) : strF;
    }

    public static String T(String str, int i7) {
        String[] strArrM1 = m1(str);
        if (strArrM1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrM1) {
            if (i7 == B0.z.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static Object[] T0(Object[] objArr, Object obj) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        objArrCopyOf[objArr.length] = obj;
        return j(objArrCopyOf);
    }

    public static String U(String str, int i7) {
        String[] strArrM1 = m1(str);
        if (strArrM1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrM1) {
            if (i7 != B0.z.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static Object[] U0(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static String V(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return AbstractC1229c.g(networkCountryIso);
            }
        }
        return AbstractC1229c.g(Locale.getDefault().getCountry());
    }

    public static Object[] V0(Object[] objArr, int i7) {
        j3.o.d(i7 <= objArr.length);
        return Arrays.copyOf(objArr, i7);
    }

    public static Point W(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            display = ((WindowManager) j3.o.q((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return X(context, display);
    }

    public static Object[] W0(Object[] objArr, int i7, int i8) {
        j3.o.d(i7 >= 0);
        j3.o.d(i8 <= objArr.length);
        return Arrays.copyOfRange(objArr, i7, i8);
    }

    public static Point X(Context context, Display display) throws NumberFormatException {
        if (display.getDisplayId() == 0 && J0(context)) {
            String strS0 = Build.VERSION.SDK_INT < 28 ? s0("sys.display-size") : s0("vendor.display-size");
            if (!TextUtils.isEmpty(strS0)) {
                try {
                    String[] strArrK1 = k1(strS0.trim(), "x");
                    if (strArrK1.length == 2) {
                        int i7 = Integer.parseInt(strArrK1[0]);
                        int i8 = Integer.parseInt(strArrK1[1]);
                        if (i7 > 0 && i8 > 0) {
                            return new Point(i7, i8);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                AbstractC0332s.c("Util", "Invalid display size: " + strS0);
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        Z(display, point);
        return point;
    }

    public static long X0(String str) throws B0.A {
        Matcher matcher = f2100h.matcher(str);
        if (!matcher.matches()) {
            throw B0.A.a("Invalid date/time format: " + str, null);
        }
        int i7 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            int i8 = Integer.parseInt(matcher.group(12)) * 60;
            String strGroup = matcher.group(13);
            if (strGroup != null) {
                i8 += Integer.parseInt(strGroup);
            }
            i7 = i8;
            if ("-".equals(matcher.group(11))) {
                i7 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i7 != 0 ? timeInMillis - (i7 * 60000) : timeInMillis;
    }

    public static Looper Y() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static long Y0(String str) {
        Matcher matcher = f2101i.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d7 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d8 = d7 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d9 = d8 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d10 = d9 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d11 = d10 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        long j7 = (long) ((d11 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
        return !zIsEmpty ? -j7 : j7;
    }

    public static void Z(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static boolean Z0(Handler handler, Runnable runnable) {
        Looper looper = handler.getLooper();
        if (!looper.getThread().isAlive()) {
            return false;
        }
        if (looper != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static int a0(int i7) {
        if (i7 == 2 || i7 == 4) {
            return 6005;
        }
        if (i7 == 10) {
            return 6004;
        }
        if (i7 == 7) {
            return 6005;
        }
        if (i7 == 8) {
            return 6003;
        }
        switch (i7) {
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i7) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static void a1(ByteBuffer byteBuffer, int i7) {
        j3.o.k(((-16777216) & i7) == 0 || (i7 & (-8388608)) == -8388608, "Value out of range of 24-bit integer: %s", Integer.toHexString(i7));
        j3.o.d(byteBuffer.remaining() >= 3);
        ByteOrder byteOrderOrder = byteBuffer.order();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byteBuffer.put((byte) (byteOrderOrder == byteOrder ? (i7 & 16711680) >> 16 : i7 & 255)).put((byte) ((65280 & i7) >> 8)).put((byte) (byteBuffer.order() == byteOrder ? i7 & 255 : (i7 & 16711680) >> 16));
    }

    public static /* synthetic */ Thread b(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static int b0(String str) throws NumberFormatException {
        String[] strArrK1;
        int length;
        int i7 = 0;
        if (str == null || (length = (strArrK1 = k1(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrK1[length - 1];
        boolean z7 = length >= 3 && "neg".equals(strArrK1[length - 2]);
        try {
            i7 = Integer.parseInt((String) j3.o.q(str2));
            if (z7) {
                return -i7;
            }
        } catch (NumberFormatException unused) {
        }
        return i7;
    }

    public static void b1(List list, int i7, int i8) {
        if (i7 < 0 || i8 > list.size() || i7 > i8) {
            throw new IllegalArgumentException();
        }
        if (i7 != i8) {
            list.subList(i7, i8).clear();
        }
    }

    public static long c(long j7, long j8, long j9) {
        long jD = m3.e.d(j7, j8);
        return ((jD != Long.MIN_VALUE || j7 + j8 == Long.MIN_VALUE) && (jD != Long.MAX_VALUE || j7 + j8 == Long.MAX_VALUE)) ? jD : j9;
    }

    public static String c0(int i7) {
        if (i7 == 0) {
            return "NO";
        }
        if (i7 == 1) {
            return "NO_UNSUPPORTED_SUBTYPE";
        }
        if (i7 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i7 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i7 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static long c1(long j7, int i7) {
        return g1(j7, 1000000L, i7, RoundingMode.DOWN);
    }

    public static int d(long[] jArr, long j7, boolean z7, boolean z8) {
        int i7;
        int i8;
        int iBinarySearch = Arrays.binarySearch(jArr, j7);
        if (iBinarySearch < 0) {
            i8 = ~iBinarySearch;
        } else {
            while (true) {
                i7 = iBinarySearch + 1;
                if (i7 >= jArr.length || jArr[i7] != j7) {
                    break;
                }
                iBinarySearch = i7;
            }
            i8 = z7 ? iBinarySearch : i7;
        }
        return z8 ? Math.min(jArr.length - 1, i8) : i8;
    }

    public static int d0(ByteBuffer byteBuffer, int i7) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byte b7 = byteBuffer.get(byteOrderOrder == byteOrder ? i7 : i7 + 2);
        byte b8 = byteBuffer.get(i7 + 1);
        if (byteBuffer.order() == byteOrder) {
            i7 += 2;
        }
        return (((byteBuffer.get(i7) << 8) & 65280) | (((b7 << 24) & (-16777216)) | ((b8 << 16) & 16711680))) >> 8;
    }

    public static long d1(long j7, long j8, long j9) {
        return g1(j7, j8, j9, RoundingMode.DOWN);
    }

    public static int e(C0333t c0333t, long j7, boolean z7, boolean z8) {
        int i7;
        int iD = c0333t.d() - 1;
        int i8 = 0;
        while (i8 <= iD) {
            int i9 = (i8 + iD) >>> 1;
            if (c0333t.c(i9) < j7) {
                i8 = i9 + 1;
            } else {
                iD = i9 - 1;
            }
        }
        if (z7 && (i7 = iD + 1) < c0333t.d() && c0333t.c(i7) == j7) {
            return i7;
        }
        if (z8 && iD == -1) {
            return 0;
        }
        return iD;
    }

    public static String e0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long[] e1(List list, long j7, long j8) {
        return i1(list, j7, j8, RoundingMode.DOWN);
    }

    public static int f(List list, Comparable comparable, boolean z7, boolean z8) {
        int i7;
        int i8;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i8 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i7 = iBinarySearch - 1;
                if (i7 < 0 || ((Comparable) list.get(i7)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i7;
            }
            i8 = z7 ? iBinarySearch : i7;
        }
        return z8 ? Math.max(0, i8) : i8;
    }

    public static int f0(Context context) {
        return F0(context) ? 1 : 5;
    }

    public static void f1(long[] jArr, long j7, long j8) {
        j1(jArr, j7, j8, RoundingMode.DOWN);
    }

    public static int g(int[] iArr, int i7, boolean z7, boolean z8) {
        int i8;
        int i9;
        int iBinarySearch = Arrays.binarySearch(iArr, i7);
        if (iBinarySearch < 0) {
            i9 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i8 = iBinarySearch - 1;
                if (i8 < 0 || iArr[i8] != i7) {
                    break;
                }
                iBinarySearch = i8;
            }
            i9 = z7 ? iBinarySearch : i8;
        }
        return z8 ? Math.max(0, i9) : i9;
    }

    public static long g0(long j7, float f7) {
        return f7 == 1.0f ? j7 : Math.round(j7 * f7);
    }

    public static long g1(long j7, long j8, long j9, RoundingMode roundingMode) {
        if (j7 == 0 || j8 == 0) {
            return 0L;
        }
        return (j9 < j8 || j9 % j8 != 0) ? (j9 >= j8 || j8 % j9 != 0) ? (j9 < j7 || j9 % j7 != 0) ? (j9 >= j7 || j7 % j9 != 0) ? h1(j7, j8, j9, roundingMode) : m3.e.e(j8, m3.e.b(j7, j9, RoundingMode.UNNECESSARY)) : m3.e.b(j8, m3.e.b(j9, j7, RoundingMode.UNNECESSARY), roundingMode) : m3.e.e(j7, m3.e.b(j8, j9, RoundingMode.UNNECESSARY)) : m3.e.b(j7, m3.e.b(j9, j8, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static int h(long[] jArr, long j7, boolean z7, boolean z8) {
        int i7;
        int i8;
        int iBinarySearch = Arrays.binarySearch(jArr, j7);
        if (iBinarySearch < 0) {
            i8 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i7 = iBinarySearch - 1;
                if (i7 < 0 || jArr[i7] != j7) {
                    break;
                }
                iBinarySearch = i7;
            }
            i8 = z7 ? iBinarySearch : i7;
        }
        return z8 ? Math.max(0, i8) : i8;
    }

    public static long h0(long j7) {
        return j7 == -9223372036854775807L ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + j7;
    }

    public static long h1(long j7, long j8, long j9, RoundingMode roundingMode) {
        long jE = m3.e.e(j7, j8);
        if (jE != Long.MAX_VALUE && jE != Long.MIN_VALUE) {
            return m3.e.b(jE, j9, roundingMode);
        }
        long jC = m3.e.c(Math.abs(j8), Math.abs(j9));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jB = m3.e.b(j8, jC, roundingMode2);
        long jB2 = m3.e.b(j9, jC, roundingMode2);
        long jC2 = m3.e.c(Math.abs(j7), Math.abs(jB2));
        long jB3 = m3.e.b(j7, jC2, roundingMode2);
        long jB4 = m3.e.b(jB2, jC2, roundingMode2);
        long jE2 = m3.e.e(jB3, jB);
        if (jE2 != Long.MAX_VALUE && jE2 != Long.MIN_VALUE) {
            return m3.e.b(jE2, jB4, roundingMode);
        }
        double d7 = jB3 * (jB / jB4);
        if (d7 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d7 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return m3.b.f(d7, roundingMode);
    }

    public static int i0(int i7) {
        return j0(i7, ByteOrder.LITTLE_ENDIAN);
    }

    public static long[] i1(List list, long j7, long j8, RoundingMode roundingMode) {
        long j9 = j7;
        long j10 = j8;
        RoundingMode roundingMode2 = roundingMode;
        int size = list.size();
        long[] jArr = new long[size];
        if (j9 != 0) {
            int i7 = 0;
            if (j10 >= j9 && j10 % j9 == 0) {
                long jB = m3.e.b(j10, j9, RoundingMode.UNNECESSARY);
                while (i7 < size) {
                    jArr[i7] = m3.e.b(((Long) list.get(i7)).longValue(), jB, roundingMode2);
                    i7++;
                }
            } else if (j10 >= j9 || j9 % j10 != 0) {
                int i8 = 0;
                while (i8 < size) {
                    long jLongValue = ((Long) list.get(i8)).longValue();
                    if (jLongValue != 0) {
                        if (j10 >= jLongValue && j10 % jLongValue == 0) {
                            jArr[i8] = m3.e.b(j9, m3.e.b(j10, jLongValue, RoundingMode.UNNECESSARY), roundingMode2);
                        } else if (j10 >= jLongValue || jLongValue % j10 != 0) {
                            jArr[i8] = h1(jLongValue, j9, j10, roundingMode2);
                        } else {
                            jArr[i8] = m3.e.e(j9, m3.e.b(jLongValue, j10, RoundingMode.UNNECESSARY));
                        }
                    }
                    i8++;
                    j9 = j7;
                    j10 = j8;
                    roundingMode2 = roundingMode;
                }
            } else {
                long jB2 = m3.e.b(j9, j10, RoundingMode.UNNECESSARY);
                while (i7 < size) {
                    jArr[i7] = m3.e.e(((Long) list.get(i7)).longValue(), jB2);
                    i7++;
                }
            }
        }
        return jArr;
    }

    public static int j0(int i7, ByteOrder byteOrder) {
        if (i7 == 8) {
            return 3;
        }
        if (i7 == 16) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 2 : 268435456;
        }
        if (i7 == 24) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 21 : 1342177280;
        }
        if (i7 != 32) {
            return 0;
        }
        return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 22 : 1610612736;
    }

    public static void j1(long[] jArr, long j7, long j8, RoundingMode roundingMode) {
        if (j7 == 0) {
            Arrays.fill(jArr, 0L);
            return;
        }
        int i7 = 0;
        if (j8 >= j7 && j8 % j7 == 0) {
            long jB = m3.e.b(j8, j7, RoundingMode.UNNECESSARY);
            while (i7 < jArr.length) {
                jArr[i7] = m3.e.b(jArr[i7], jB, roundingMode);
                i7++;
            }
            return;
        }
        if (j8 < j7 && j7 % j8 == 0) {
            long jB2 = m3.e.b(j7, j8, RoundingMode.UNNECESSARY);
            while (i7 < jArr.length) {
                jArr[i7] = m3.e.e(jArr[i7], jB2);
                i7++;
            }
            return;
        }
        for (int i8 = 0; i8 < jArr.length; i8++) {
            long j9 = jArr[i8];
            if (j9 != 0) {
                if (j8 >= j9 && j8 % j9 == 0) {
                    jArr[i8] = m3.e.b(j7, m3.e.b(j8, j9, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j8 >= j9 || j9 % j8 != 0) {
                    jArr[i8] = h1(j9, j7, j8, roundingMode);
                } else {
                    jArr[i8] = m3.e.e(j7, m3.e.b(j9, j8, RoundingMode.UNNECESSARY));
                }
            }
        }
    }

    public static int k(int i7, int i8) {
        return ((i7 + i8) - 1) / i8;
    }

    public static B0.s k0(int i7, int i8, int i9) {
        return new s.b().y0("audio/raw").T(i8).z0(i9).s0(i7).P();
    }

    public static String[] k1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static long l(long j7, long j8) {
        return ((j7 + j8) - 1) / j8;
    }

    public static int l0(int i7, int i8) {
        return Q(i7) * i8;
    }

    public static String[] l1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static void m(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long m0(long j7, float f7) {
        return f7 == 1.0f ? j7 : Math.round(j7 / f7);
    }

    public static String[] m1(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : k1(str.trim(), "(\\s*,\\s*)");
    }

    public static float n(float f7, float f8, float f9) {
        return Math.max(f8, Math.min(f7, f9));
    }

    public static List n0(int i7) {
        ArrayList arrayList = new ArrayList();
        if ((i7 & 1) != 0) {
            arrayList.add("main");
        }
        if ((i7 & 2) != 0) {
            arrayList.add("alt");
        }
        if ((i7 & 4) != 0) {
            arrayList.add("supplementary");
        }
        if ((i7 & 8) != 0) {
            arrayList.add("commentary");
        }
        if ((i7 & 16) != 0) {
            arrayList.add("dub");
        }
        if ((i7 & 32) != 0) {
            arrayList.add("emergency");
        }
        if ((i7 & 64) != 0) {
            arrayList.add("caption");
        }
        if ((i7 & 128) != 0) {
            arrayList.add("subtitle");
        }
        if ((i7 & 256) != 0) {
            arrayList.add("sign");
        }
        if ((i7 & 512) != 0) {
            arrayList.add("describes-video");
        }
        if ((i7 & 1024) != 0) {
            arrayList.add("describes-music");
        }
        if ((i7 & 2048) != 0) {
            arrayList.add("enhanced-intelligibility");
        }
        if ((i7 & 4096) != 0) {
            arrayList.add("transcribes-dialog");
        }
        if ((i7 & 8192) != 0) {
            arrayList.add("easy-read");
        }
        if ((i7 & 16384) != 0) {
            arrayList.add("trick-play");
        }
        if ((i7 & PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS) != 0) {
            arrayList.add("auxiliary");
        }
        return arrayList;
    }

    public static long n1(long j7, long j8, long j9) {
        long jF = m3.e.f(j7, j8);
        return ((jF != Long.MIN_VALUE || j7 - j8 == Long.MIN_VALUE) && (jF != Long.MAX_VALUE || j7 - j8 == Long.MAX_VALUE)) ? jF : j9;
    }

    public static int o(int i7, int i8, int i9) {
        return Math.max(i8, Math.min(i7, i9));
    }

    public static List o0(int i7) {
        ArrayList arrayList = new ArrayList();
        if ((i7 & 4) != 0) {
            arrayList.add("auto");
        }
        if ((i7 & 1) != 0) {
            arrayList.add("default");
        }
        if ((i7 & 2) != 0) {
            arrayList.add("forced");
        }
        return arrayList;
    }

    public static String o1(int i7) {
        return new String(o3.g.p(i7), StandardCharsets.US_ASCII);
    }

    public static long p(long j7, long j8, long j9) {
        return Math.max(j8, Math.min(j7, j9));
    }

    public static String[] p0() {
        String[] strArrQ0 = q0();
        for (int i7 = 0; i7 < strArrQ0.length; i7++) {
            strArrQ0[i7] = S0(strArrQ0[i7]);
        }
        return strArrQ0;
    }

    public static String p1(byte[] bArr) {
        return AbstractC1304a.a().j().e(bArr);
    }

    public static boolean q(SparseArray sparseArray, int i7) {
        return sparseArray.indexOfKey(i7) >= 0;
    }

    public static String[] q0() {
        return r0(Resources.getSystem().getConfiguration());
    }

    public static long q1(int i7, int i8) {
        return r1(i8) | (r1(i7) << 32);
    }

    public static boolean r(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (Objects.equals(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String[] r0(Configuration configuration) {
        return k1(configuration.getLocales().toLanguageTags(), ",");
    }

    public static long r1(int i7) {
        return i7 & 4294967295L;
    }

    public static boolean s(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2 == null;
        }
        if (sparseArray2 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return sparseArray.contentEquals(sparseArray2);
        }
        int size = sparseArray.size();
        if (size != sparseArray2.size()) {
            return false;
        }
        for (int i7 = 0; i7 < size; i7++) {
            if (!Objects.equals(sparseArray.valueAt(i7), sparseArray2.get(sparseArray.keyAt(i7)))) {
                return false;
            }
        }
        return true;
    }

    public static String s0(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e7) {
            AbstractC0332s.d("Util", "Failed to read system property " + str, e7);
            return null;
        }
    }

    public static long s1(long j7) {
        return (j7 == -9223372036854775807L || j7 == Long.MIN_VALUE) ? j7 : j7 / 1000;
    }

    public static int t(SparseArray sparseArray) {
        if (Build.VERSION.SDK_INT >= 31) {
            return sparseArray.contentHashCode();
        }
        int iKeyAt = 17;
        for (int i7 = 0; i7 < sparseArray.size(); i7++) {
            iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i7)) * 31) + Objects.hashCode(sparseArray.valueAt(i7));
        }
        return iKeyAt;
    }

    public static String t0(int i7) {
        switch (i7) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return MediaStreamTrack.AUDIO_TRACK_KIND;
            case 2:
                return MediaStreamTrack.VIDEO_TRACK_KIND;
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i7 < 10000) {
                    return "?";
                }
                return "custom (" + i7 + ")";
        }
    }

    public static int u(byte[] bArr, int i7, int i8, int i9) {
        while (i7 < i8) {
            int iB = o3.j.b(bArr[i7]);
            i9 = v(iB & 15, v(iB >> 4, i9));
            i7++;
        }
        return i9;
    }

    public static String u0(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") AndroidXMedia3/1.9.2";
    }

    public static int v(int i7, int i8) {
        return (f2108p[(i7 ^ ((i8 >> 12) & 255)) & 255] ^ ((i8 << 4) & 65535)) & 65535;
    }

    public static byte[] v0(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static int w(byte[] bArr, int i7, int i8, int i9) {
        while (i7 < i8) {
            i9 = f2107o[((i9 >>> 24) ^ (bArr[i7] & 255)) & 255] ^ (i9 << 8);
            i7++;
        }
        return i9;
    }

    public static int w0(Uri uri) {
        int iX0;
        String scheme = uri.getScheme();
        if (scheme != null && (AbstractC1229c.a("rtsp", scheme) || AbstractC1229c.a("rtspt", scheme))) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iX0 = x0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iX0;
        }
        Matcher matcher = f2103k.matcher((CharSequence) j3.o.q(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            if (strGroup.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (strGroup.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static int x(byte[] bArr, int i7, int i8, int i9) {
        while (i7 < i8) {
            i9 = f2109q[i9 ^ (bArr[i7] & 255)];
            i7++;
        }
        return i9;
    }

    public static int x0(String str) {
        String strF = AbstractC1229c.f(str);
        strF.getClass();
        switch (strF) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static Handler y(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static int y0(Uri uri, String str) {
        if (str == null) {
            return w0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static Handler z() {
        return A(null);
    }

    public static boolean z0(E e7, E e8, Inflater inflater) {
        if (e7.a() == 0) {
            return false;
        }
        if (e8.b() < e7.a()) {
            e8.d(e7.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(e7.f(), e7.g(), e7.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(e8.f(), iInflate, e8.b() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (iInflate == e8.b()) {
                        e8.d(e8.b() * 2);
                    }
                } else {
                    e8.e0(iInflate);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static Object i(Object obj) {
        return obj;
    }

    public static Object[] j(Object[] objArr) {
        return objArr;
    }
}
