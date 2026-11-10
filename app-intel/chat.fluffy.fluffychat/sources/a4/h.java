package a4;

/* loaded from: classes.dex */
public enum h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    /* renamed from: l, reason: collision with root package name */
    public final int[] f10816l;

    /* renamed from: m, reason: collision with root package name */
    public final int f10817m;

    h(int[] iArr, int i7) {
        this.f10816l = iArr;
        this.f10817m = i7;
    }

    public static h d(int i7) {
        if (i7 == 0) {
            return TERMINATOR;
        }
        if (i7 == 1) {
            return NUMERIC;
        }
        if (i7 == 2) {
            return ALPHANUMERIC;
        }
        if (i7 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i7 == 4) {
            return BYTE;
        }
        if (i7 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i7 == 7) {
            return ECI;
        }
        if (i7 == 8) {
            return KANJI;
        }
        if (i7 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i7 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public int e(j jVar) {
        int iJ = jVar.j();
        return this.f10816l[iJ <= 9 ? (char) 0 : iJ <= 26 ? (char) 1 : (char) 2];
    }
}
