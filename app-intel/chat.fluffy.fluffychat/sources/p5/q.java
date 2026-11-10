package p5;

import h5.C1144a;
import h5.b;
import java.util.List;
import java.util.Map;
import p5.q;
import y5.C1810e;
import y5.InterfaceC1809d;
import z5.C1880n;

/* loaded from: classes.dex */
public interface q {

    /* renamed from: i, reason: collision with root package name */
    public static final a f21000i = a.f21001a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f21001a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final InterfaceC1809d f21002b = C1810e.a(new L5.a() { // from class: p5.g
            @Override // L5.a
            public final Object d() {
                return q.a.k();
            }
        });

        public static final C1451e k() {
            return new C1451e();
        }

        public static /* synthetic */ void n(a aVar, h5.b bVar, q qVar, String str, int i7, Object obj) {
            if ((i7 & 4) != 0) {
                str = "";
            }
            aVar.m(bVar, qVar, str);
        }

        public static final void o(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.remove((String) obj2)));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void p(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.c(str, ((Boolean) obj3).booleanValue())));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void q(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.String");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.f(str, (String) obj3)));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void r(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Long");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.e(str, ((Long) obj3).longValue())));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void s(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Double");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.d(str, ((Double) obj3).doubleValue())));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void t(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.String");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.g(str, (String) obj3)));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void u(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.h(str, (List) obj3)));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void v(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                listA = C1880n.d(Boolean.valueOf(qVar.b((String) obj2, (List) list.get(1))));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public static final void w(q qVar, Object obj, C1144a.e eVar) {
            List listA;
            M5.m.e(eVar, "reply");
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                listA = C1880n.d(qVar.a((String) obj2, (List) list.get(1)));
            } catch (Throwable th) {
                listA = C1452f.f20990a.a(th);
            }
            eVar.a(listA);
        }

        public final h5.h l() {
            return (h5.h) f21002b.getValue();
        }

        public final void m(h5.b bVar, final q qVar, String str) {
            String str2;
            M5.m.e(bVar, "binaryMessenger");
            M5.m.e(str, "messageChannelSuffix");
            if (str.length() > 0) {
                str2 = "." + str;
            } else {
                str2 = "";
            }
            b.c cVarC = bVar.c();
            C1144a c1144a = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.remove" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a.e(new C1144a.d() { // from class: p5.h
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.o(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a.e(null);
            }
            C1144a c1144a2 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setBool" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a2.e(new C1144a.d() { // from class: p5.i
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.p(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a2.e(null);
            }
            C1144a c1144a3 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setString" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a3.e(new C1144a.d() { // from class: p5.j
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.q(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a3.e(null);
            }
            C1144a c1144a4 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setInt" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a4.e(new C1144a.d() { // from class: p5.k
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.r(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a4.e(null);
            }
            C1144a c1144a5 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDouble" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a5.e(new C1144a.d() { // from class: p5.l
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.s(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a5.e(null);
            }
            C1144a c1144a6 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setEncodedStringList" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a6.e(new C1144a.d() { // from class: p5.m
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.t(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a6.e(null);
            }
            C1144a c1144a7 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDeprecatedStringList" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a7.e(new C1144a.d() { // from class: p5.n
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.u(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a7.e(null);
            }
            C1144a c1144a8 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.clear" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a8.e(new C1144a.d() { // from class: p5.o
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.v(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a8.e(null);
            }
            C1144a c1144a9 = new C1144a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.getAll" + str2, l(), cVarC);
            if (qVar != null) {
                c1144a9.e(new C1144a.d() { // from class: p5.p
                    @Override // h5.C1144a.d
                    public final void a(Object obj, C1144a.e eVar) {
                        q.a.w(qVar, obj, eVar);
                    }
                });
            } else {
                c1144a9.e(null);
            }
        }
    }

    Map a(String str, List list);

    boolean b(String str, List list);

    boolean c(String str, boolean z7);

    boolean d(String str, double d7);

    boolean e(String str, long j7);

    boolean f(String str, String str2);

    boolean g(String str, String str2);

    boolean h(String str, List list);

    boolean remove(String str);
}
