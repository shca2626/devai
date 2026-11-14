package d2;

import M5.m;

/* renamed from: d2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0985h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15140a = new a(null);

    /* renamed from: d2.h$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public static /* synthetic */ AbstractC0985h b(a aVar, Object obj, String str, EnumC0987j enumC0987j, InterfaceC0984g interfaceC0984g, int i7, Object obj2) {
            if ((i7 & 2) != 0) {
                enumC0987j = C0980c.f15123a.a();
            }
            if ((i7 & 4) != 0) {
                interfaceC0984g = C0978a.f15118a;
            }
            return aVar.a(obj, str, enumC0987j, interfaceC0984g);
        }

        public final AbstractC0985h a(Object obj, String str, EnumC0987j enumC0987j, InterfaceC0984g interfaceC0984g) {
            m.e(obj, "<this>");
            m.e(str, "tag");
            m.e(enumC0987j, "verificationMode");
            m.e(interfaceC0984g, "logger");
            return new C0986i(obj, str, enumC0987j, interfaceC0984g);
        }

        public a() {
        }
    }

    public abstract Object a();

    public final String b(Object obj, String str) {
        m.e(obj, "value");
        m.e(str, "message");
        return str + " value: " + obj;
    }

    public abstract AbstractC0985h c(String str, L5.l lVar);
}
