package d2;

import M5.m;

/* renamed from: d2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0984h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15140a = new a(null);

    /* renamed from: d2.h$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public static /* synthetic */ AbstractC0984h b(a aVar, Object obj, String str, EnumC0986j enumC0986j, InterfaceC0983g interfaceC0983g, int i7, Object obj2) {
            if ((i7 & 2) != 0) {
                enumC0986j = C0979c.f15123a.a();
            }
            if ((i7 & 4) != 0) {
                interfaceC0983g = C0977a.f15118a;
            }
            return aVar.a(obj, str, enumC0986j, interfaceC0983g);
        }

        public final AbstractC0984h a(Object obj, String str, EnumC0986j enumC0986j, InterfaceC0983g interfaceC0983g) {
            m.e(obj, "<this>");
            m.e(str, "tag");
            m.e(enumC0986j, "verificationMode");
            m.e(interfaceC0983g, "logger");
            return new C0985i(obj, str, enumC0986j, interfaceC0983g);
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

    public abstract AbstractC0984h c(String str, L5.l lVar);
}
