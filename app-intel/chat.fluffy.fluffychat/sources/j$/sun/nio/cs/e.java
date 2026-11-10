package j$.sun.nio.cs;

import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public CoderResult f18185a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18186b;

    public final int a(char c7, CharBuffer charBuffer) {
        if (Character.isHighSurrogate(c7)) {
            if (!charBuffer.hasRemaining()) {
                this.f18185a = CoderResult.UNDERFLOW;
                return -1;
            }
            char c8 = charBuffer.get();
            if (Character.isLowSurrogate(c8)) {
                int codePoint = Character.toCodePoint(c7, c8);
                this.f18186b = true;
                this.f18185a = null;
                return codePoint;
            }
            this.f18185a = CoderResult.malformedForLength(1);
            return -1;
        }
        if (Character.isLowSurrogate(c7)) {
            this.f18185a = CoderResult.malformedForLength(1);
            return -1;
        }
        this.f18186b = false;
        this.f18185a = null;
        return c7;
    }

    public final int b(char c7, char[] cArr, int i7, int i8) {
        if (!Character.isHighSurrogate(c7)) {
            if (Character.isLowSurrogate(c7)) {
                this.f18185a = CoderResult.malformedForLength(1);
                return -1;
            }
            this.f18186b = false;
            this.f18185a = null;
            return c7;
        }
        if (i8 - i7 < 2) {
            this.f18185a = CoderResult.UNDERFLOW;
            return -1;
        }
        char c8 = cArr[i7 + 1];
        if (Character.isLowSurrogate(c8)) {
            int codePoint = Character.toCodePoint(c7, c8);
            this.f18186b = true;
            this.f18185a = null;
            return codePoint;
        }
        this.f18185a = CoderResult.malformedForLength(1);
        return -1;
    }
}
