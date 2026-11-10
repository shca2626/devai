package v2;

import java.io.File;

/* loaded from: classes.dex */
public final class l extends h {

    /* renamed from: d, reason: collision with root package name */
    public static volatile int f22939d;

    /* renamed from: b, reason: collision with root package name */
    public static final l f22937b = new l();

    /* renamed from: c, reason: collision with root package name */
    public static final File f22938c = new File("/proc/self/fd");

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f22940e = true;

    public l() {
        super(null);
    }

    @Override // v2.h
    public boolean a(y2.h hVar, C2.l lVar) {
        M5.m.e(hVar, "size");
        if (hVar instanceof y2.c) {
            y2.c cVar = (y2.c) hVar;
            if (cVar.f() < 75 || cVar.e() < 75) {
                return false;
            }
        }
        return b(lVar);
    }

    public final synchronized boolean b(C2.l lVar) {
        try {
            int i7 = f22939d;
            f22939d = i7 + 1;
            if (i7 >= 50) {
                f22939d = 0;
                String[] list = f22938c.list();
                if (list == null) {
                    list = new String[0];
                }
                int length = list.length;
                f22940e = length < 750;
                if (!f22940e && lVar != null && lVar.a() <= 5) {
                    lVar.b("LimitedFileDescriptorHardwareBitmapService", 5, M5.m.j("Unable to allocate more hardware bitmaps. Number of used file descriptors: ", Integer.valueOf(length)), null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22940e;
    }
}
