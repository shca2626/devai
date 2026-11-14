package h0;

import W5.InterfaceC0652w;

/* loaded from: classes.dex */
public abstract class w {

    public static final class a extends w {

        /* renamed from: a, reason: collision with root package name */
        public final L5.p f16790a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC0652w f16791b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC1121D f16792c;

        /* renamed from: d, reason: collision with root package name */
        public final C5.i f16793d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(L5.p pVar, InterfaceC0652w interfaceC0652w, AbstractC1121D abstractC1121D, C5.i iVar) {
            super(null);
            M5.m.e(pVar, "transform");
            M5.m.e(interfaceC0652w, "ack");
            M5.m.e(iVar, "callerContext");
            this.f16790a = pVar;
            this.f16791b = interfaceC0652w;
            this.f16792c = abstractC1121D;
            this.f16793d = iVar;
        }

        public final InterfaceC0652w a() {
            return this.f16791b;
        }

        public final C5.i b() {
            return this.f16793d;
        }

        public AbstractC1121D c() {
            return this.f16792c;
        }

        public final L5.p d() {
            return this.f16790a;
        }
    }

    public /* synthetic */ w(M5.g gVar) {
        this();
    }

    public w() {
    }
}
