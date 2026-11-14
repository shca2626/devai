package m0;

import java.nio.ByteBuffer;

/* renamed from: m0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1320c {

    /* renamed from: a, reason: collision with root package name */
    public int f19690a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f19691b;

    /* renamed from: c, reason: collision with root package name */
    public int f19692c;

    /* renamed from: d, reason: collision with root package name */
    public int f19693d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC1321d f19694e = AbstractC1321d.a();

    public int a(int i7) {
        return i7 + this.f19691b.getInt(i7);
    }

    public int b(int i7) {
        if (i7 < this.f19693d) {
            return this.f19691b.getShort(this.f19692c + i7);
        }
        return 0;
    }

    public void c(int i7, ByteBuffer byteBuffer) {
        this.f19691b = byteBuffer;
        if (byteBuffer == null) {
            this.f19690a = 0;
            this.f19692c = 0;
            this.f19693d = 0;
        } else {
            this.f19690a = i7;
            int i8 = i7 - byteBuffer.getInt(i7);
            this.f19692c = i8;
            this.f19693d = this.f19691b.getShort(i8);
        }
    }

    public int d(int i7) {
        int i8 = i7 + this.f19690a;
        return i8 + this.f19691b.getInt(i8) + 4;
    }

    public int e(int i7) {
        int i8 = i7 + this.f19690a;
        return this.f19691b.getInt(i8 + this.f19691b.getInt(i8));
    }
}
