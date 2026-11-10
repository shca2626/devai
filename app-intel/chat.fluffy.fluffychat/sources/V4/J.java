package V4;

import V4.P;
import android.view.KeyEvent;
import g5.e;
import java.util.Objects;

/* loaded from: classes.dex */
public class J implements P.d {

    /* renamed from: a, reason: collision with root package name */
    public final g5.e f8675a;

    /* renamed from: b, reason: collision with root package name */
    public final P.b f8676b = new P.b();

    public J(g5.e eVar) {
        this.f8675a = eVar;
    }

    @Override // V4.P.d
    public void a(KeyEvent keyEvent, final P.d.a aVar) {
        int action = keyEvent.getAction();
        if (action != 0 && action != 1) {
            aVar.a(false);
            return;
        }
        e.b bVar = new e.b(keyEvent, this.f8676b.a(keyEvent.getUnicodeChar()));
        boolean z7 = action != 0;
        g5.e eVar = this.f8675a;
        Objects.requireNonNull(aVar);
        eVar.d(bVar, z7, new e.a() { // from class: V4.I
            @Override // g5.e.a
            public final void a(boolean z8) {
                aVar.a(z8);
            }
        });
    }
}
