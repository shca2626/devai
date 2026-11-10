package N1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f6330a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6331b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6332c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f6333d;

    /* renamed from: e, reason: collision with root package name */
    public int f6334e;

    public w(int i7, int i8) {
        this.f6330a = i7;
        byte[] bArr = new byte[i8 + 3];
        this.f6333d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i7, int i8) {
        if (this.f6331b) {
            int i9 = i8 - i7;
            byte[] bArr2 = this.f6333d;
            int length = bArr2.length;
            int i10 = this.f6334e;
            if (length < i10 + i9) {
                this.f6333d = Arrays.copyOf(bArr2, (i10 + i9) * 2);
            }
            System.arraycopy(bArr, i7, this.f6333d, this.f6334e, i9);
            this.f6334e += i9;
        }
    }

    public boolean b(int i7) {
        if (!this.f6331b) {
            return false;
        }
        this.f6334e -= i7;
        this.f6331b = false;
        this.f6332c = true;
        return true;
    }

    public boolean c() {
        return this.f6332c;
    }

    public void d() {
        this.f6331b = false;
        this.f6332c = false;
    }

    public void e(int i7) {
        j3.o.v(!this.f6331b);
        boolean z7 = i7 == this.f6330a;
        this.f6331b = z7;
        if (z7) {
            this.f6334e = 3;
            this.f6332c = false;
        }
    }
}
