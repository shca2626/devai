package L2;

import M5.m;
import O.c;
import android.graphics.Paint;
import c5.InterfaceC0910a;
import h5.i;
import h5.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z5.C1882p;

/* loaded from: classes.dex */
public final class a implements InterfaceC0910a, j.c {

    /* renamed from: l, reason: collision with root package name */
    public j f5457l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f5458m = new Paint();

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
        j jVar = new j(bVar.b(), "emoji_picker_flutter");
        this.f5457l = jVar;
        jVar.e(this);
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "binding");
        j jVar = this.f5457l;
        if (jVar == null) {
            m.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        ArrayList arrayList;
        m.e(iVar, "call");
        m.e(dVar, "result");
        if (!m.a(iVar.f16895a, "getSupportedEmojis")) {
            dVar.notImplemented();
            return;
        }
        List list = (List) iVar.a("source");
        if (list != null) {
            arrayList = new ArrayList(C1882p.o(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(c.a(this.f5458m, (String) it.next())));
            }
        } else {
            arrayList = null;
        }
        dVar.success(arrayList);
    }
}
