package j$.sun.nio.cs;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b extends CharsetEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final e f18182a;

    @Override // java.nio.charset.CharsetEncoder
    public final boolean canEncode(char c7) {
        return c7 <= 255;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final boolean isLegalReplacement(byte[] bArr) {
        return true;
    }

    public b(c cVar) {
        super(cVar, 1.0f, 1.0f);
        e eVar = new e();
        eVar.f18185a = CoderResult.UNDERFLOW;
        this.f18182a = eVar;
    }

    public static int a(char[] cArr, int i7, byte[] bArr, int i8, int i9) {
        int i10 = 0;
        if (i9 <= 0) {
            return 0;
        }
        Objects.requireNonNull(cArr);
        Objects.requireNonNull(bArr);
        if (i7 < 0 || i7 >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i7);
        }
        if (i8 < 0 || i8 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i8);
        }
        int i11 = (i7 + i9) - 1;
        if (i11 < 0 || i11 >= cArr.length) {
            throw new ArrayIndexOutOfBoundsException(i11);
        }
        int i12 = (i8 + i9) - 1;
        if (i12 < 0 || i12 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i12);
        }
        while (i10 < i9) {
            int i13 = i7 + 1;
            char c7 = cArr[i7];
            if (c7 > 255) {
                break;
            }
            bArr[i8] = (byte) c7;
            i10++;
            i7 = i13;
            i8++;
        }
        return i10;
    }

    @Override // java.nio.charset.CharsetEncoder
    public final CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        CoderResult coderResultUnmappableForLength;
        CoderResult coderResultUnmappableForLength2;
        int i7 = 2;
        if (!charBuffer.hasArray() || !byteBuffer.hasArray()) {
            int iPosition = charBuffer.position();
            while (true) {
                try {
                    if (!charBuffer.hasRemaining()) {
                        coderResultUnmappableForLength = CoderResult.UNDERFLOW;
                        break;
                    }
                    char c7 = charBuffer.get();
                    if (c7 <= 255) {
                        if (!byteBuffer.hasRemaining()) {
                            coderResultUnmappableForLength = CoderResult.OVERFLOW;
                            break;
                        }
                        byteBuffer.put((byte) c7);
                        iPosition++;
                    } else if (this.f18182a.a(c7, charBuffer) < 0) {
                        coderResultUnmappableForLength = this.f18182a.f18185a;
                    } else {
                        if (!this.f18182a.f18186b) {
                            i7 = 1;
                        }
                        coderResultUnmappableForLength = CoderResult.unmappableForLength(i7);
                    }
                } finally {
                }
            }
            return coderResultUnmappableForLength;
        }
        char[] cArrArray = charBuffer.array();
        int iArrayOffset = charBuffer.arrayOffset();
        int iPosition2 = charBuffer.position() + iArrayOffset;
        int iLimit = charBuffer.limit() + iArrayOffset;
        if (iPosition2 > iLimit) {
            iPosition2 = iLimit;
        }
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset2 = byteBuffer.arrayOffset();
        int iPosition3 = byteBuffer.position() + iArrayOffset2;
        int iLimit2 = byteBuffer.limit() + iArrayOffset2;
        if (iPosition3 > iLimit2) {
            iPosition3 = iLimit2;
        }
        int i8 = iLimit2 - iPosition3;
        int i9 = iLimit - iPosition2;
        if (i8 >= i9) {
            i8 = i9;
        }
        try {
            int iA = a(cArrArray, iPosition2, bArrArray, iPosition3, i8);
            int i10 = iPosition2 + iA;
            int i11 = iPosition3 + iA;
            if (iA == i8) {
                coderResultUnmappableForLength2 = i8 < i9 ? CoderResult.OVERFLOW : CoderResult.UNDERFLOW;
            } else if (this.f18182a.b(cArrArray[i10], cArrArray, i10, iLimit) < 0) {
                coderResultUnmappableForLength2 = this.f18182a.f18185a;
            } else {
                if (!this.f18182a.f18186b) {
                    i7 = 1;
                }
                coderResultUnmappableForLength2 = CoderResult.unmappableForLength(i7);
            }
            return coderResultUnmappableForLength2;
        } catch (Throwable th) {
            throw th;
        }
    }
}
