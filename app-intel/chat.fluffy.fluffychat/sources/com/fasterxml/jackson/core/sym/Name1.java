package com.fasterxml.jackson.core.sym;

/* loaded from: classes.dex */
public final class Name1 extends Name {
    private static final Name1 EMPTY = new Name1("", 0, 0);

    /* renamed from: q, reason: collision with root package name */
    private final int f14193q;

    public Name1(String str, int i7, int i8) {
        super(str, i7);
        this.f14193q = i8;
    }

    public static Name1 getEmptyName() {
        return EMPTY;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7, int i8, int i9) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7) {
        return i7 == this.f14193q;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i7, int i8) {
        return i7 == this.f14193q && i8 == 0;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i7) {
        return i7 == 1 && iArr[0] == this.f14193q;
    }
}
