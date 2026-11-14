package W5;

/* renamed from: W5.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0620f0 implements InterfaceC0645s0 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9146l;

    public C0620f0(boolean z7) {
        this.f9146l = z7;
    }

    @Override // W5.InterfaceC0645s0
    public H0 b() {
        return null;
    }

    @Override // W5.InterfaceC0645s0
    public boolean e() {
        return this.f9146l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(e() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
