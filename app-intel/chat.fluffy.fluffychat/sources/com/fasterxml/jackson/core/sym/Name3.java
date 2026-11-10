package com.fasterxml.jackson.core.sym;

/* loaded from: classes.dex */
public final class Name3 extends Name {

    /* renamed from: q1, reason: collision with root package name */
    private final int f14196q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f14197q2;

    /* renamed from: q3, reason: collision with root package name */
    private final int f14198q3;

    public Name3(String str, int i7, int i8, int i9, int i10) {
        super(str, i7);
        this.f14196q1 = i8;
        this.f14197q2 = i9;
        this.f14198q3 = i10;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7, int i8) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7, int i8, int i9) {
        return this.f14196q1 == i7 && this.f14197q2 == i8 && this.f14198q3 == i9;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i7) {
        return i7 == 3 && iArr[0] == this.f14196q1 && iArr[1] == this.f14197q2 && iArr[2] == this.f14198q3;
    }
}
