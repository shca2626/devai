package g5;

import h5.j;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16461a;

    /* renamed from: b, reason: collision with root package name */
    public b f16462b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16463c;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            String str;
            if (t.this.f16462b == null) {
                return;
            }
            str = iVar.f16895a;
            U4.b.f("SensitiveContentChannel", "Received '" + str + "' message.");
            str.getClass();
            switch (str) {
                case "SensitiveContent.getContentSensitivity":
                    try {
                        dVar.success(Integer.valueOf(t.this.e(t.this.f16462b.b())));
                        break;
                    } catch (IllegalArgumentException | IllegalStateException e7) {
                        dVar.error("error", e7.getMessage(), null);
                        return;
                    }
                case "SensitiveContent.setContentSensitivity":
                    try {
                        t.this.f16462b.c(t.this.d(((Integer) iVar.b()).intValue()));
                        break;
                    } catch (IllegalArgumentException | IllegalStateException e8) {
                        dVar.error("error", e8.getMessage(), null);
                        return;
                    }
                case "SensitiveContent.isSupported":
                    dVar.success(Boolean.valueOf(t.this.f16462b.a()));
                    break;
                default:
                    U4.b.f("SensitiveContentChannel", "Method " + str + " is not implemented for the SensitiveContentChannel.");
                    dVar.notImplemented();
                    break;
            }
        }
    }

    public interface b {
        boolean a();

        int b();

        void c(int i7);
    }

    public t(X4.a aVar) {
        a aVar2 = new a();
        this.f16463c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/sensitivecontent", h5.p.f16910b);
        this.f16461a = jVar;
        jVar.e(aVar2);
    }

    public final int d(int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("contentSensitivityIndex " + i7 + " not known to the SensitiveContentChannel.");
    }

    public final int e(int i7) {
        if (i7 == 0) {
            return 0;
        }
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2) {
                return 3;
            }
        }
        return i8;
    }

    public void f(b bVar) {
        this.f16462b = bVar;
    }
}
