package g5;

import h5.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16482a;

    /* renamed from: b, reason: collision with root package name */
    public b f16483b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16484c;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (v.this.f16483b == null) {
                U4.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = iVar.f16895a;
            Object obj = iVar.f16896b;
            U4.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.getClass();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.notImplemented();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                v.this.f16483b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e7) {
                dVar.error("error", e7.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, j.d dVar);
    }

    public v(X4.a aVar) {
        a aVar2 = new a();
        this.f16484c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/spellcheck", h5.p.f16910b);
        this.f16482a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f16483b = bVar;
    }
}
