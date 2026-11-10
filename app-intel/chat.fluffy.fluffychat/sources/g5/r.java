package g5;

import h5.j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f16447a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f16448b;

    /* renamed from: c, reason: collision with root package name */
    public h5.j f16449c;

    /* renamed from: d, reason: collision with root package name */
    public j.d f16450d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16451e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16452f;

    /* renamed from: g, reason: collision with root package name */
    public final j.c f16453g;

    public class b implements j.c {
        public b() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            String str = iVar.f16895a;
            Object obj = iVar.f16896b;
            str.getClass();
            if (!str.equals("get")) {
                if (!str.equals("put")) {
                    dVar.notImplemented();
                    return;
                }
                r.this.f16448b = (byte[]) obj;
                dVar.success(null);
                return;
            }
            r.this.f16452f = true;
            if (!r.this.f16451e) {
                r rVar = r.this;
                if (rVar.f16447a) {
                    rVar.f16450d = dVar;
                    return;
                }
            }
            r rVar2 = r.this;
            dVar.success(rVar2.i(rVar2.f16448b));
        }
    }

    public r(X4.a aVar, boolean z7) {
        this(new h5.j(aVar, "flutter/restoration", h5.p.f16910b), z7);
    }

    public void g() {
        this.f16448b = null;
    }

    public byte[] h() {
        return this.f16448b;
    }

    public final Map i(byte[] bArr) {
        HashMap map = new HashMap();
        map.put("enabled", Boolean.TRUE);
        map.put("data", bArr);
        return map;
    }

    public void j(byte[] bArr) {
        this.f16451e = true;
        j.d dVar = this.f16450d;
        if (dVar != null) {
            dVar.success(i(bArr));
            this.f16450d = null;
            this.f16448b = bArr;
        } else if (this.f16452f) {
            this.f16449c.d("push", i(bArr), new a(bArr));
        } else {
            this.f16448b = bArr;
        }
    }

    public r(h5.j jVar, boolean z7) {
        this.f16451e = false;
        this.f16452f = false;
        b bVar = new b();
        this.f16453g = bVar;
        this.f16449c = jVar;
        this.f16447a = z7;
        jVar.e(bVar);
    }

    public class a implements j.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f16454a;

        public a(byte[] bArr) {
            this.f16454a = bArr;
        }

        @Override // h5.j.d
        public void error(String str, String str2, Object obj) {
            U4.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // h5.j.d
        public void success(Object obj) {
            r.this.f16448b = this.f16454a;
        }

        @Override // h5.j.d
        public void notImplemented() {
        }
    }
}
