package u4;

import M5.m;
import android.media.MediaFormat;
import s4.InterfaceC1611f;
import t4.InterfaceC1633a;
import v4.C1686c;
import v4.EnumC1684a;
import y5.C1811f;
import y5.C1813h;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22885a = new a(null);

    public static final class a {

        /* renamed from: u4.f$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0278a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f22886a;

            static {
                int[] iArr = new int[EnumC1684a.values().length];
                try {
                    iArr[EnumC1684a.f23005n.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC1684a.f23006o.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC1684a.f23007p.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC1684a.f23008q.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EnumC1684a.f23009r.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[EnumC1684a.f23010s.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[EnumC1684a.f23011t.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[EnumC1684a.f23012u.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[EnumC1684a.f23013v.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                f22886a = iArr;
            }
        }

        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(C1686c c1686c) {
            m.e(c1686c, "config");
            if (c1686c.n() != null || c(c1686c).d(c1686c)) {
                return;
            }
            throw new IllegalArgumentException("Streaming is not supported for encoder '" + c1686c.i().e() + "'");
        }

        public final C1813h b(C1686c c1686c, InterfaceC1633a interfaceC1633a) {
            m.e(c1686c, "config");
            m.e(interfaceC1633a, "listener");
            return g.f22887a.d(c(c1686c), c1686c, interfaceC1633a);
        }

        public final f c(C1686c c1686c) {
            switch (C0278a.f22886a[c1686c.i().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return new C1664a();
                case 4:
                    return new C1665b();
                case 5:
                    return new c();
                case 6:
                    return new e();
                case 7:
                    return new j();
                case 8:
                    return new i();
                case 9:
                    return new k();
                default:
                    throw new C1811f();
            }
        }

        public a() {
        }
    }

    public /* synthetic */ f(M5.g gVar) {
        this();
    }

    public abstract InterfaceC1611f a(MediaFormat mediaFormat, String str);

    public abstract MediaFormat b(C1686c c1686c);

    public abstract String c();

    public boolean d(C1686c c1686c) {
        m.e(c1686c, "config");
        return false;
    }

    public f() {
    }
}
