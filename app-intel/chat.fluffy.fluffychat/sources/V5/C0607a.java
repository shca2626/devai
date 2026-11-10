package V5;

/* renamed from: V5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0607a {
    public static int a(int i7) {
        if (2 <= i7 && i7 < 37) {
            return i7;
        }
        throw new IllegalArgumentException("radix " + i7 + " was not in valid range " + new S5.c(2, 36));
    }

    public static final int b(char c7, int i7) {
        return Character.digit((int) c7, i7);
    }

    public static final boolean c(char c7) {
        return Character.isWhitespace(c7) || Character.isSpaceChar(c7);
    }
}
