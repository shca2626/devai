package b6;

import W5.InterfaceC0633m;
import W5.T;
import W5.W;

/* renamed from: b6.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0888w extends W5.J implements W {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ W f13813n;

    /* renamed from: o, reason: collision with root package name */
    public final W5.J f13814o;

    /* renamed from: p, reason: collision with root package name */
    public final String f13815p;

    /* JADX WARN: Multi-variable type inference failed */
    public C0888w(W5.J j7, String str) {
        W w7 = j7 instanceof W ? (W) j7 : null;
        this.f13813n = w7 == null ? T.a() : w7;
        this.f13814o = j7;
        this.f13815p = str;
    }

    @Override // W5.W
    public void P(long j7, InterfaceC0633m interfaceC0633m) {
        this.f13813n.P(j7, interfaceC0633m);
    }

    @Override // W5.J
    public void U(C5.i iVar, Runnable runnable) {
        this.f13814o.U(iVar, runnable);
    }

    @Override // W5.J
    public boolean V(C5.i iVar) {
        return this.f13814o.V(iVar);
    }

    @Override // W5.J
    public String toString() {
        return this.f13815p;
    }
}
