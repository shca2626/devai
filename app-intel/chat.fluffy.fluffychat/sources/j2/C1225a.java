package j2;

import L5.l;
import M5.g;
import M5.m;
import M5.n;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import d2.AbstractC0985h;
import d2.C0979b;
import d2.EnumC0987j;
import g2.C1100d;
import g2.InterfaceC1097a;
import g2.InterfaceC1099c;
import g2.j;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z5.C1884o;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1225a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0207a f18684b = new C0207a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final String f18685c = C1225a.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public final EnumC0987j f18686a;

    /* renamed from: j2.a$a, reason: collision with other inner class name */
    public static final class C0207a {
        public /* synthetic */ C0207a(g gVar) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    m.c(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m.e(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m.e(sidecarWindowLayoutInfo, "info");
            try {
                try {
                    List list = sidecarWindowLayoutInfo.displayFeatures;
                    return list == null ? C1884o.i() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                    m.c(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return C1884o.i();
            }
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i7;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i7));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public C0207a() {
        }
    }

    /* renamed from: j2.a$b */
    public static final class b extends n implements l {

        /* renamed from: m, reason: collision with root package name */
        public static final b f18687m = new b();

        public b() {
            super(1);
        }

        @Override // L5.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean a(SidecarDisplayFeature sidecarDisplayFeature) {
            m.e(sidecarDisplayFeature, "$this$require");
            boolean z7 = true;
            if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    /* renamed from: j2.a$c */
    public static final class c extends n implements l {

        /* renamed from: m, reason: collision with root package name */
        public static final c f18688m = new c();

        public c() {
            super(1);
        }

        @Override // L5.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean a(SidecarDisplayFeature sidecarDisplayFeature) {
            m.e(sidecarDisplayFeature, "$this$require");
            return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
        }
    }

    /* renamed from: j2.a$d */
    public static final class d extends n implements l {

        /* renamed from: m, reason: collision with root package name */
        public static final d f18689m = new d();

        public d() {
            super(1);
        }

        @Override // L5.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean a(SidecarDisplayFeature sidecarDisplayFeature) {
            m.e(sidecarDisplayFeature, "$this$require");
            boolean z7 = true;
            if (sidecarDisplayFeature.getType() == 1 && sidecarDisplayFeature.getRect().width() != 0 && sidecarDisplayFeature.getRect().height() != 0) {
                z7 = false;
            }
            return Boolean.valueOf(z7);
        }
    }

    /* renamed from: j2.a$e */
    public static final class e extends n implements l {

        /* renamed from: m, reason: collision with root package name */
        public static final e f18690m = new e();

        public e() {
            super(1);
        }

        @Override // L5.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean a(SidecarDisplayFeature sidecarDisplayFeature) {
            m.e(sidecarDisplayFeature, "$this$require");
            return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1225a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (m.a(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        C0207a c0207a = f18684b;
        return c0207a.b(sidecarDeviceState) == c0207a.b(sidecarDeviceState2);
    }

    public final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (m.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return m.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!b((SidecarDisplayFeature) list.get(i7), (SidecarDisplayFeature) list2.get(i7))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (m.a(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        C0207a c0207a = f18684b;
        return c(c0207a.c(sidecarWindowLayoutInfo), c0207a.c(sidecarWindowLayoutInfo2));
    }

    public final j e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m.e(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new j(C1884o.i());
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        C0207a c0207a = f18684b;
        c0207a.d(sidecarDeviceState2, c0207a.b(sidecarDeviceState));
        return new j(f(c0207a.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final List f(List list, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m.e(list, "sidecarDisplayFeatures");
        m.e(sidecarDeviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC1097a interfaceC1097aG = g((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (interfaceC1097aG != null) {
                arrayList.add(interfaceC1097aG);
            }
        }
        return arrayList;
    }

    public final InterfaceC1097a g(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C1100d.b bVarA;
        InterfaceC1099c.b bVar;
        m.e(sidecarDisplayFeature, "feature");
        m.e(sidecarDeviceState, "deviceState");
        AbstractC0985h.a aVar = AbstractC0985h.f15140a;
        String str = f18685c;
        m.d(str, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) AbstractC0985h.a.b(aVar, sidecarDisplayFeature, str, this.f18686a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.f18687m).c("Feature bounds must not be 0", c.f18688m).c("TYPE_FOLD must have 0 area", d.f18689m).c("Feature be pinned to either left or top", e.f18690m).a();
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type = sidecarDisplayFeature2.getType();
        if (type == 1) {
            bVarA = C1100d.b.f16180b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = C1100d.b.f16180b.b();
        }
        int iB = f18684b.b(sidecarDeviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = InterfaceC1099c.b.f16174d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = InterfaceC1099c.b.f16173c;
        }
        Rect rect = sidecarDisplayFeature.getRect();
        m.d(rect, "feature.rect");
        return new C1100d(new C0979b(rect), bVarA, bVar);
    }

    public C1225a(EnumC0987j enumC0987j) {
        m.e(enumC0987j, "verificationMode");
        this.f18686a = enumC0987j;
    }

    public /* synthetic */ C1225a(EnumC0987j enumC0987j, int i7, g gVar) {
        this((i7 & 1) != 0 ? EnumC0987j.QUIET : enumC0987j);
    }
}
