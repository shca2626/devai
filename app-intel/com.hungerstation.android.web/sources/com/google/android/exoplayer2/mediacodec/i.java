package com.google.android.exoplayer2.mediacodec;

import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private int f20987a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f20988b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f20989c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int[] f20990d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    private int f20991e;

    public i() {
        this.f20991e = r0.length - 1;
    }

    private void c() {
        int[] iArr = this.f20990d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i12 = this.f20987a;
        int i13 = length2 - i12;
        System.arraycopy(iArr, i12, iArr2, 0, i13);
        System.arraycopy(this.f20990d, 0, iArr2, i13, i12);
        this.f20987a = 0;
        this.f20988b = this.f20989c - 1;
        this.f20990d = iArr2;
        this.f20991e = iArr2.length - 1;
    }

    public void a(int i12) {
        if (this.f20989c == this.f20990d.length) {
            c();
        }
        int i13 = (this.f20988b + 1) & this.f20991e;
        this.f20988b = i13;
        this.f20990d[i13] = i12;
        this.f20989c++;
    }

    public void b() {
        this.f20987a = 0;
        this.f20988b = -1;
        this.f20989c = 0;
    }

    public boolean d() {
        return this.f20989c == 0;
    }

    public int e() {
        int i12 = this.f20989c;
        if (i12 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f20990d;
        int i13 = this.f20987a;
        int i14 = iArr[i13];
        this.f20987a = (i13 + 1) & this.f20991e;
        this.f20989c = i12 - 1;
        return i14;
    }
}
