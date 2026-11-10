package G2;

/* loaded from: classes.dex */
public enum a {
    denied,
    deniedForever,
    whileInUse,
    always;

    public int d() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i7 = 1;
        if (iOrdinal != 1) {
            i7 = 2;
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return 3;
                }
                throw new IndexOutOfBoundsException();
            }
        }
        return i7;
    }
}
