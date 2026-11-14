package P4;

import M5.m;
import V5.w;
import V5.y;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import h5.i;
import h5.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import z5.C1884o;
import z5.C1885p;

/* loaded from: classes.dex */
public final class b implements j.c {

    /* renamed from: l, reason: collision with root package name */
    public final PackageManager f7557l;

    /* renamed from: m, reason: collision with root package name */
    public final ActivityManager f7558m;

    /* renamed from: n, reason: collision with root package name */
    public final ContentResolver f7559n;

    public b(PackageManager packageManager, ActivityManager activityManager, ContentResolver contentResolver) {
        m.e(packageManager, "packageManager");
        m.e(activityManager, "activityManager");
        m.e(contentResolver, "contentResolver");
        this.f7557l = packageManager;
        this.f7558m = activityManager;
        this.f7559n = contentResolver;
    }

    public final List a() {
        FeatureInfo[] systemAvailableFeatures = this.f7557l.getSystemAvailableFeatures();
        m.d(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1885p.o(arrayList, 10));
        int size = arrayList.size();
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            arrayList2.add(((FeatureInfo) obj).name);
        }
        return arrayList2;
    }

    public final boolean b() {
        String str = Build.BRAND;
        m.d(str, "BRAND");
        if (w.y(str, "generic", false, 2, null)) {
            String str2 = Build.DEVICE;
            m.d(str2, "DEVICE");
            if (w.y(str2, "generic", false, 2, null)) {
                return true;
            }
        }
        String str3 = Build.FINGERPRINT;
        m.d(str3, "FINGERPRINT");
        if (w.y(str3, "generic", false, 2, null)) {
            return true;
        }
        m.d(str3, "FINGERPRINT");
        if (w.y(str3, "unknown", false, 2, null)) {
            return true;
        }
        String str4 = Build.HARDWARE;
        m.d(str4, "HARDWARE");
        if (y.B(str4, "goldfish", false, 2, null)) {
            return true;
        }
        m.d(str4, "HARDWARE");
        if (y.B(str4, "ranchu", false, 2, null)) {
            return true;
        }
        String str5 = Build.MODEL;
        m.d(str5, "MODEL");
        if (y.B(str5, "google_sdk", false, 2, null)) {
            return true;
        }
        m.d(str5, "MODEL");
        if (y.B(str5, "Emulator", false, 2, null)) {
            return true;
        }
        m.d(str5, "MODEL");
        if (y.B(str5, "Android SDK built for x86", false, 2, null)) {
            return true;
        }
        String str6 = Build.MANUFACTURER;
        m.d(str6, "MANUFACTURER");
        if (y.B(str6, "Genymotion", false, 2, null)) {
            return true;
        }
        String str7 = Build.PRODUCT;
        m.d(str7, "PRODUCT");
        if (y.B(str7, "sdk", false, 2, null)) {
            return true;
        }
        m.d(str7, "PRODUCT");
        if (y.B(str7, "vbox86p", false, 2, null)) {
            return true;
        }
        m.d(str7, "PRODUCT");
        if (y.B(str7, "emulator", false, 2, null)) {
            return true;
        }
        m.d(str7, "PRODUCT");
        return y.B(str7, "simulator", false, 2, null);
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        m.e(iVar, "call");
        m.e(dVar, "result");
        if (!iVar.f16895a.equals("getDeviceInfo")) {
            dVar.notImplemented();
            return;
        }
        HashMap map = new HashMap();
        map.put("board", Build.BOARD);
        map.put("bootloader", Build.BOOTLOADER);
        map.put("brand", Build.BRAND);
        map.put("device", Build.DEVICE);
        map.put("display", Build.DISPLAY);
        map.put("fingerprint", Build.FINGERPRINT);
        map.put("hardware", Build.HARDWARE);
        map.put("host", Build.HOST);
        map.put("id", Build.ID);
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("model", Build.MODEL);
        map.put("product", Build.PRODUCT);
        map.put("time", Long.valueOf(Build.TIME));
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 25) {
            String string = Settings.Global.getString(this.f7559n, "device_name");
            if (string == null) {
                string = "";
            }
            map.put("name", string);
        }
        String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
        map.put("supported32BitAbis", C1884o.l(Arrays.copyOf(strArr, strArr.length)));
        String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
        map.put("supported64BitAbis", C1884o.l(Arrays.copyOf(strArr2, strArr2.length)));
        String[] strArr3 = Build.SUPPORTED_ABIS;
        map.put("supportedAbis", C1884o.l(Arrays.copyOf(strArr3, strArr3.length)));
        map.put("tags", Build.TAGS);
        map.put("type", Build.TYPE);
        map.put("isPhysicalDevice", Boolean.valueOf(!b()));
        map.put("systemFeatures", a());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        map.put("freeDiskSize", Long.valueOf(statFs.getFreeBytes()));
        map.put("totalDiskSize", Long.valueOf(statFs.getTotalBytes()));
        HashMap map2 = new HashMap();
        map2.put("baseOS", Build.VERSION.BASE_OS);
        map2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
        map2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
        map2.put("codename", Build.VERSION.CODENAME);
        map2.put("incremental", Build.VERSION.INCREMENTAL);
        map2.put("release", Build.VERSION.RELEASE);
        map2.put("sdkInt", Integer.valueOf(i7));
        map.put("version", map2);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f7558m.getMemoryInfo(memoryInfo);
        map.put("isLowRamDevice", Boolean.valueOf(memoryInfo.lowMemory));
        map.put("physicalRamSize", Long.valueOf(memoryInfo.totalMem / 1048576));
        map.put("availableRamSize", Long.valueOf(memoryInfo.availMem / 1048576));
        dVar.success(map);
    }
}
