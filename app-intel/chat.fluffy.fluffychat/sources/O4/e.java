package O4;

import h5.i;
import h5.j;

/* loaded from: classes.dex */
public class e implements j.c {

    /* renamed from: l, reason: collision with root package name */
    public final a f7309l;

    public e(a aVar) {
        this.f7309l = aVar;
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if ("check".equals(iVar.f16895a)) {
            dVar.success(this.f7309l.d());
        } else {
            dVar.notImplemented();
        }
    }
}
