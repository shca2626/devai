package h0;

import W5.InterfaceC0651w;

/* loaded from: classes.dex */
public abstract class w {

    public static final class a extends w {

        /* renamed from: a, reason: collision with root package name */
        public final L5.p f16790a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC0651w f16791b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC1120D f16792c;

        /* renamed from: d, reason: collision with root package name */
        public final C5.i f16793d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(L5.p pVar, InterfaceC0651w interfaceC0651w, AbstractC1120D abstractC1120D, C5.i iVar) {
            super(null);
            M5.m.e(pVar, "transform");
            M5.m.e(interfaceC0651w, "ack");
            M5.m.e(iVar, "callerContext");
            this.f16790a = pVar;
            this.f16791b = interfaceC0651w;
            this.f16792c = abstractC1120D;
            this.f16793d = iVar;
        }

        public final InterfaceC0651w a() {
            return this.f16791b;
        }

        public final C5.i b() {
            return this.f16793d;
        }

        public AbstractC1120D c() {
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
