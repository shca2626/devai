package m0;

import java.nio.ByteBuffer;

/* renamed from: m0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1321c {

    /* renamed from: a, reason: collision with root package name */
    public int f19691a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f19692b;

    /* renamed from: c, reason: collision with root package name */
    public int f19693c;

    /* renamed from: d, reason: collision with root package name */
    public int f19694d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC1322d f19695e = AbstractC1322d.a();

    public int a(int i7) {
        return i7 + this.f19692b.getInt(i7);
    }

    public int b(int i7) {
        if (i7 < this.f19694d) {
            return this.f19692b.getShort(this.f19693c + i7);
        }
        return 0;
    }

    public void c(int i7, ByteBuffer byteBuffer) {
        this.f19692b = byteBuffer;
        if (byteBuffer == null) {
            this.f19691a = 0;
            this.f19693c = 0;
            this.f19694d = 0;
        } else {
            this.f19691a = i7;
            int i8 = i7 - byteBuffer.getInt(i7);
            this.f19693c = i8;
            this.f19694d = this.f19692b.getShort(i8);
        }
    }

    public int d(int i7) {
        int i8 = i7 + this.f19691a;
        return i8 + this.f19692b.getInt(i8) + 4;
    }

    public int e(int i7) {
        int i8 = i7 + this.f19691a;
        return this.f19692b.getInt(i8 + this.f19692b.getInt(i8));
    }
}
