package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final A.c f12981a = A.c.o();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f12982b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f12983c = null;

    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f12984a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12985b;

        /* renamed from: c, reason: collision with root package name */
        public final long f12986c;

        /* renamed from: d, reason: collision with root package name */
        public final long f12987d;

        public b(int i7, int i8, long j7, long j8) {
            this.f12984a = i7;
            this.f12985b = i8;
            this.f12986c = j7;
            this.f12987d = j8;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } finally {
            }
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f12984a);
                dataOutputStream.writeInt(this.f12985b);
                dataOutputStream.writeLong(this.f12986c);
                dataOutputStream.writeLong(this.f12987d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (this.f12985b == bVar.f12985b && this.f12986c == bVar.f12986c && this.f12984a == bVar.f12984a && this.f12987d == bVar.f12987d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f12985b), Long.valueOf(this.f12986c), Integer.valueOf(this.f12984a), Long.valueOf(this.f12987d));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f12988a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12989b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12990c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f12991d;

        public c(int i7, boolean z7, boolean z8, boolean z9) {
            this.f12988a = i7;
            this.f12990c = z8;
            this.f12989b = z7;
            this.f12991d = z9;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i7, boolean z7, boolean z8, boolean z9) {
        c cVar = new c(i7, z7, z8, z9);
        f12983c = cVar;
        f12981a.m(cVar);
        return f12983c;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.profileinstaller.d.c c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.d.c(android.content.Context, boolean):androidx.profileinstaller.d$c");
    }
}
