package H4;

import h5.c;

/* loaded from: classes.dex */
public class g implements c.b {

    /* renamed from: a, reason: collision with root package name */
    public c.b f3519a;

    public class a implements c.d {
        public a() {
        }

        @Override // h5.c.d
        public void onCancel(Object obj) {
            g.this.f3519a = null;
        }

        @Override // h5.c.d
        public void onListen(Object obj, c.b bVar) {
            g.this.f3519a = bVar;
        }
    }

    public g(h5.b bVar, String str) {
        new h5.c(bVar, str).d(new a());
    }

    @Override // h5.c.b
    public void endOfStream() {
        c.b bVar = this.f3519a;
        if (bVar != null) {
            bVar.endOfStream();
        }
    }

    @Override // h5.c.b
    public void error(String str, String str2, Object obj) {
        c.b bVar = this.f3519a;
        if (bVar != null) {
            bVar.error(str, str2, obj);
        }
    }

    @Override // h5.c.b
    public void success(Object obj) {
        c.b bVar = this.f3519a;
        if (bVar != null) {
            bVar.success(obj);
        }
    }
}
