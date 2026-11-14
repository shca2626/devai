package b1;

import java.util.List;

/* renamed from: b1.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0824A implements y {

    /* renamed from: a, reason: collision with root package name */
    public final y f13511a;

    public AbstractC0824A(y yVar) {
        this.f13511a = yVar;
    }

    @Override // b1.y
    public void a() {
        this.f13511a.a();
    }

    @Override // b1.y
    public boolean b(int i7, long j7) {
        return this.f13511a.b(i7, j7);
    }

    @Override // b1.y
    public int d() {
        return this.f13511a.d();
    }

    @Override // b1.y
    public boolean e(long j7, Z0.f fVar, List list) {
        return this.f13511a.e(j7, fVar, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractC0824A) {
            return this.f13511a.equals(((AbstractC0824A) obj).f13511a);
        }
        return false;
    }

    @Override // b1.y
    public void f(boolean z7) {
        this.f13511a.f(z7);
    }

    @Override // b1.y
    public void h() {
        this.f13511a.h();
    }

    public int hashCode() {
        return this.f13511a.hashCode();
    }

    @Override // b1.InterfaceC0826C
    public int i(int i7) {
        return this.f13511a.i(i7);
    }

    @Override // b1.y
    public int j(long j7, List list) {
        return this.f13511a.j(j7, list);
    }

    @Override // b1.y
    public int k() {
        return this.f13511a.k();
    }

    @Override // b1.InterfaceC0826C
    public int length() {
        return this.f13511a.length();
    }

    @Override // b1.y
    public int n() {
        return this.f13511a.n();
    }

    @Override // b1.y
    public boolean o(int i7, long j7) {
        return this.f13511a.o(i7, j7);
    }

    @Override // b1.y
    public void p(long j7, long j8, long j9, List list, Z0.o[] oVarArr) {
        this.f13511a.p(j7, j8, j9, list, oVarArr);
    }

    @Override // b1.y
    public void q(float f7) {
        this.f13511a.q(f7);
    }

    @Override // b1.y
    public Object r() {
        return this.f13511a.r();
    }

    @Override // b1.y
    public void s() {
        this.f13511a.s();
    }

    @Override // b1.y
    public void t() {
        this.f13511a.t();
    }

    @Override // b1.InterfaceC0826C
    public int u(int i7) {
        return this.f13511a.u(i7);
    }

    public y v() {
        return this.f13511a;
    }
}
