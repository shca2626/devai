package com.fasterxml.jackson.core.sym;

/* loaded from: classes.dex */
public final class Name2 extends Name {

    /* renamed from: q1, reason: collision with root package name */
    private final int f14194q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f14195q2;

    public Name2(String str, int i7, int i8, int i9) {
        super(str, i7);
        this.f14194q1 = i8;
        this.f14195q2 = i9;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7, int i8, int i9) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7, int i8) {
        return i7 == this.f14194q1 && i8 == this.f14195q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i7) {
        return i7 == 2 && iArr[0] == this.f14194q1 && iArr[1] == this.f14195q2;
    }
}
