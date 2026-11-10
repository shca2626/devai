package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class NameN extends Name {

    /* renamed from: q, reason: collision with root package name */
    private final int[] f14199q;

    /* renamed from: q1, reason: collision with root package name */
    private final int f14200q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f14201q2;

    /* renamed from: q3, reason: collision with root package name */
    private final int f14202q3;

    /* renamed from: q4, reason: collision with root package name */
    private final int f14203q4;
    private final int qlen;

    public NameN(String str, int i7, int i8, int i9, int i10, int i11, int[] iArr, int i12) {
        super(str, i7);
        this.f14200q1 = i8;
        this.f14201q2 = i9;
        this.f14202q3 = i10;
        this.f14203q4 = i11;
        this.f14199q = iArr;
        this.qlen = i12;
    }

    private final boolean _equals2(int[] iArr) {
        int i7 = this.qlen - 4;
        for (int i8 = 0; i8 < i7; i8++) {
            if (iArr[i8 + 4] != this.f14199q[i8]) {
                return false;
            }
        }
        return true;
    }

    public static NameN construct(String str, int i7, int[] iArr, int i8) {
        if (i8 >= 4) {
            return new NameN(str, i7, iArr[0], iArr[1], iArr[2], iArr[3], i8 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i8) : null, i8);
        }
        throw new IllegalArgumentException();
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
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i7) {
        if (i7 != this.qlen || iArr[0] != this.f14200q1 || iArr[1] != this.f14201q2 || iArr[2] != this.f14202q3 || iArr[3] != this.f14203q4) {
            return false;
        }
        switch (i7) {
            case 8:
                if (iArr[7] != this.f14199q[3]) {
                }
                break;
            case 7:
                if (iArr[6] != this.f14199q[2]) {
                }
                break;
            case 6:
                if (iArr[5] != this.f14199q[1]) {
                }
                break;
            case 5:
                if (iArr[4] != this.f14199q[0]) {
                }
                break;
            case 4:
                return true;
        }
        return false;
    }
}
