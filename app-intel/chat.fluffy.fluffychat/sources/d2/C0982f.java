package d2;

import M5.m;
import y5.C1811f;
import z5.C1878l;

/* renamed from: d2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0982f extends AbstractC0984h {

    /* renamed from: b, reason: collision with root package name */
    public final Object f15133b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15134c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15135d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0983g f15136e;

    /* renamed from: f, reason: collision with root package name */
    public final EnumC0986j f15137f;

    /* renamed from: g, reason: collision with root package name */
    public final C0988l f15138g;

    /* renamed from: d2.f$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15139a;

        static {
            int[] iArr = new int[EnumC0986j.values().length];
            try {
                iArr[EnumC0986j.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC0986j.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC0986j.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15139a = iArr;
        }
    }

    public C0982f(Object obj, String str, String str2, InterfaceC0983g interfaceC0983g, EnumC0986j enumC0986j) {
        m.e(obj, "value");
        m.e(str, "tag");
        m.e(str2, "message");
        m.e(interfaceC0983g, "logger");
        m.e(enumC0986j, "verificationMode");
        this.f15133b = obj;
        this.f15134c = str;
        this.f15135d = str2;
        this.f15136e = interfaceC0983g;
        this.f15137f = enumC0986j;
        C0988l c0988l = new C0988l(b(obj, str2));
        StackTraceElement[] stackTrace = c0988l.getStackTrace();
        m.d(stackTrace, "stackTrace");
        c0988l.setStackTrace((StackTraceElement[]) C1878l.r(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f15138g = c0988l;
    }

    @Override // d2.AbstractC0984h
    public Object a() throws C0988l {
        int i7 = a.f15139a[this.f15137f.ordinal()];
        if (i7 == 1) {
            throw this.f15138g;
        }
        if (i7 == 2) {
            this.f15136e.a(this.f15134c, b(this.f15133b, this.f15135d));
            return null;
        }
        if (i7 == 3) {
            return null;
        }
        throw new C1811f();
    }

    @Override // d2.AbstractC0984h
    public AbstractC0984h c(String str, L5.l lVar) {
        m.e(str, "message");
        m.e(lVar, "condition");
        return this;
    }
}
