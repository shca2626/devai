package a4;

import D3.p;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10818a;

    public i(boolean z7) {
        this.f10818a = z7;
    }

    public void a(p[] pVarArr) {
        if (!this.f10818a || pVarArr == null || pVarArr.length < 3) {
            return;
        }
        p pVar = pVarArr[0];
        pVarArr[0] = pVarArr[2];
        pVarArr[2] = pVar;
    }
}
