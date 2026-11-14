package y5;

/* renamed from: y5.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1811g extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public C1811g() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1811g(String str) {
        super(str);
        M5.m.e(str, "message");
    }

    public /* synthetic */ C1811g(String str, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
