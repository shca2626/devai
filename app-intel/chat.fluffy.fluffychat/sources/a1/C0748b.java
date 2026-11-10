package a1;

import D1.j;
import D1.k;
import D1.s;

/* renamed from: a1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0748b extends j {

    /* renamed from: p, reason: collision with root package name */
    public final s f10540p;

    public C0748b(String str, s sVar) {
        super(str);
        this.f10540p = sVar;
    }

    @Override // D1.j
    public k B(byte[] bArr, int i7, boolean z7) {
        if (z7) {
            this.f10540p.reset();
        }
        return this.f10540p.b(bArr, 0, i7);
    }
}
