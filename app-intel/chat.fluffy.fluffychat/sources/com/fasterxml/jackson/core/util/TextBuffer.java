package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.NumberInput;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TextBuffer {
    static final int MAX_SEGMENT_LEN = 65536;
    static final int MIN_SEGMENT_LEN = 500;
    static final char[] NO_CHARS = new char[0];
    private final BufferRecycler _allocator;
    private char[] _currentSegment;
    private int _currentSize;
    private boolean _hasSegments;
    private char[] _inputBuffer;
    private int _inputLen;
    private int _inputStart;
    private char[] _resultArray;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this._allocator = bufferRecycler;
    }

    private char[] buf(int i7) {
        BufferRecycler bufferRecycler = this._allocator;
        return bufferRecycler != null ? bufferRecycler.allocCharBuffer(2, i7) : new char[Math.max(i7, 500)];
    }

    private char[] carr(int i7) {
        return new char[i7];
    }

    private void clearSegments() {
        this._hasSegments = false;
        this._segments.clear();
        this._segmentSize = 0;
        this._currentSize = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026 A[PHI: r0
      0x0026: PHI (r0v8 int) = (r0v6 int), (r0v7 int) binds: [B:6:0x0024, B:9:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void expand(int r3) {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r3 = r2._segments
            if (r3 != 0) goto Lb
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2._segments = r3
        Lb:
            char[] r3 = r2._currentSegment
            r0 = 1
            r2._hasSegments = r0
            java.util.ArrayList<char[]> r0 = r2._segments
            r0.add(r3)
            int r0 = r2._segmentSize
            int r1 = r3.length
            int r0 = r0 + r1
            r2._segmentSize = r0
            r0 = 0
            r2._currentSize = r0
            int r3 = r3.length
            int r0 = r3 >> 1
            int r3 = r3 + r0
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 >= r0) goto L28
        L26:
            r3 = r0
            goto L2d
        L28:
            r0 = 65536(0x10000, float:9.1835E-41)
            if (r3 <= r0) goto L2d
            goto L26
        L2d:
            char[] r3 = r2.carr(r3)
            r2._currentSegment = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer.expand(int):void");
    }

    public static TextBuffer fromInitial(char[] cArr) {
        return new TextBuffer(null, cArr);
    }

    private char[] resultArray() {
        int i7;
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        int i8 = this._inputStart;
        if (i8 >= 0) {
            int i9 = this._inputLen;
            return i9 < 1 ? NO_CHARS : i8 == 0 ? Arrays.copyOf(this._inputBuffer, i9) : Arrays.copyOfRange(this._inputBuffer, i8, i9 + i8);
        }
        int size = size();
        if (size < 1) {
            return NO_CHARS;
        }
        char[] carr = carr(size);
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size2 = arrayList.size();
            i7 = 0;
            for (int i10 = 0; i10 < size2; i10++) {
                char[] cArr = this._segments.get(i10);
                int length = cArr.length;
                System.arraycopy(cArr, 0, carr, i7, length);
                i7 += length;
            }
        } else {
            i7 = 0;
        }
        System.arraycopy(this._currentSegment, 0, carr, i7, this._currentSize);
        return carr;
    }

    private void unshare(int i7) {
        int i8 = this._inputLen;
        this._inputLen = 0;
        char[] cArr = this._inputBuffer;
        this._inputBuffer = null;
        int i9 = this._inputStart;
        this._inputStart = -1;
        int i10 = i7 + i8;
        char[] cArr2 = this._currentSegment;
        if (cArr2 == null || i10 > cArr2.length) {
            this._currentSegment = buf(i10);
        }
        if (i8 > 0) {
            System.arraycopy(cArr, i9, this._currentSegment, 0, i8);
        }
        this._segmentSize = 0;
        this._currentSize = i8;
    }

    public void append(char c7) {
        if (this._inputStart >= 0) {
            unshare(16);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        if (this._currentSize >= cArr.length) {
            expand(1);
            cArr = this._currentSegment;
        }
        int i7 = this._currentSize;
        this._currentSize = i7 + 1;
        cArr[i7] = c7;
    }

    public char[] contentsAsArray() {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrResultArray = resultArray();
        this._resultArray = cArrResultArray;
        return cArrResultArray;
    }

    public BigDecimal contentsAsDecimal() {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this._resultArray;
        if (cArr3 != null) {
            return NumberInput.parseBigDecimal(cArr3);
        }
        int i7 = this._inputStart;
        return (i7 < 0 || (cArr2 = this._inputBuffer) == null) ? (this._segmentSize != 0 || (cArr = this._currentSegment) == null) ? NumberInput.parseBigDecimal(contentsAsArray()) : NumberInput.parseBigDecimal(cArr, 0, this._currentSize) : NumberInput.parseBigDecimal(cArr2, i7, this._inputLen);
    }

    public double contentsAsDouble() {
        return NumberInput.parseDouble(contentsAsString());
    }

    public int contentsAsInt(boolean z7) {
        char[] cArr;
        int i7 = this._inputStart;
        return (i7 < 0 || (cArr = this._inputBuffer) == null) ? z7 ? -NumberInput.parseInt(this._currentSegment, 1, this._currentSize - 1) : NumberInput.parseInt(this._currentSegment, 0, this._currentSize) : z7 ? -NumberInput.parseInt(cArr, i7 + 1, this._inputLen - 1) : NumberInput.parseInt(cArr, i7, this._inputLen);
    }

    public long contentsAsLong(boolean z7) {
        char[] cArr;
        int i7 = this._inputStart;
        return (i7 < 0 || (cArr = this._inputBuffer) == null) ? z7 ? -NumberInput.parseLong(this._currentSegment, 1, this._currentSize - 1) : NumberInput.parseLong(this._currentSegment, 0, this._currentSize) : z7 ? -NumberInput.parseLong(cArr, i7 + 1, this._inputLen - 1) : NumberInput.parseLong(cArr, i7, this._inputLen);
    }

    public String contentsAsString() {
        if (this._resultString == null) {
            char[] cArr = this._resultArray;
            if (cArr != null) {
                this._resultString = new String(cArr);
            } else {
                int i7 = this._inputStart;
                if (i7 >= 0) {
                    int i8 = this._inputLen;
                    if (i8 < 1) {
                        this._resultString = "";
                        return "";
                    }
                    this._resultString = new String(this._inputBuffer, i7, i8);
                } else {
                    int i9 = this._segmentSize;
                    int i10 = this._currentSize;
                    if (i9 == 0) {
                        this._resultString = i10 != 0 ? new String(this._currentSegment, 0, i10) : "";
                    } else {
                        StringBuilder sb = new StringBuilder(i9 + i10);
                        ArrayList<char[]> arrayList = this._segments;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                char[] cArr2 = this._segments.get(i11);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this._currentSegment, 0, this._currentSize);
                        this._resultString = sb.toString();
                    }
                }
            }
        }
        return this._resultString;
    }

    public int contentsToWriter(Writer writer) throws IOException {
        int i7;
        char[] cArr = this._resultArray;
        if (cArr != null) {
            writer.write(cArr);
            return this._resultArray.length;
        }
        String str = this._resultString;
        if (str != null) {
            writer.write(str);
            return this._resultString.length();
        }
        int i8 = this._inputStart;
        if (i8 >= 0) {
            int i9 = this._inputLen;
            if (i9 > 0) {
                writer.write(this._inputBuffer, i8, i9);
            }
            return i9;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size = arrayList.size();
            i7 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                char[] cArr2 = this._segments.get(i10);
                int length = cArr2.length;
                writer.write(cArr2, 0, length);
                i7 += length;
            }
        } else {
            i7 = 0;
        }
        int i11 = this._currentSize;
        if (i11 <= 0) {
            return i7;
        }
        writer.write(this._currentSegment, 0, i11);
        return i7 + i11;
    }

    public char[] emptyAndGetCurrentSegment() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        char[] cArr = this._currentSegment;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrBuf = buf(0);
        this._currentSegment = cArrBuf;
        return cArrBuf;
    }

    public void ensureNotShared() {
        if (this._inputStart >= 0) {
            unshare(16);
        }
    }

    public char[] expandCurrentSegment() {
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i7 = (length >> 1) + length;
        if (i7 > MAX_SEGMENT_LEN) {
            i7 = (length >> 2) + length;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i7);
        this._currentSegment = cArrCopyOf;
        return cArrCopyOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[PHI: r1
      0x0027: PHI (r1v7 int) = (r1v5 int), (r1v6 int) binds: [B:6:0x0025, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] finishCurrentSegment() {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r0 = r2._segments
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2._segments = r0
        Lb:
            r0 = 1
            r2._hasSegments = r0
            java.util.ArrayList<char[]> r0 = r2._segments
            char[] r1 = r2._currentSegment
            r0.add(r1)
            char[] r0 = r2._currentSegment
            int r0 = r0.length
            int r1 = r2._segmentSize
            int r1 = r1 + r0
            r2._segmentSize = r1
            r1 = 0
            r2._currentSize = r1
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L29
        L27:
            r0 = r1
            goto L2e
        L29:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L2e
            goto L27
        L2e:
            char[] r0 = r2.carr(r0)
            r2._currentSegment = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer.finishCurrentSegment():char[]");
    }

    public char[] getBufferWithoutReset() {
        return this._currentSegment;
    }

    public char[] getCurrentSegment() {
        if (this._inputStart >= 0) {
            unshare(1);
        } else {
            char[] cArr = this._currentSegment;
            if (cArr == null) {
                this._currentSegment = buf(0);
            } else if (this._currentSize >= cArr.length) {
                expand(1);
            }
        }
        return this._currentSegment;
    }

    public int getCurrentSegmentSize() {
        return this._currentSize;
    }

    public char[] getTextBuffer() {
        if (this._inputStart >= 0) {
            return this._inputBuffer;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        String str = this._resultString;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this._resultArray = charArray;
            return charArray;
        }
        if (this._hasSegments) {
            return contentsAsArray();
        }
        char[] cArr2 = this._currentSegment;
        return cArr2 == null ? NO_CHARS : cArr2;
    }

    public int getTextOffset() {
        int i7 = this._inputStart;
        if (i7 >= 0) {
            return i7;
        }
        return 0;
    }

    public boolean hasTextAsCharacters() {
        return this._inputStart >= 0 || this._resultArray != null || this._resultString == null;
    }

    public void releaseBuffers() {
        char[] cArr;
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        BufferRecycler bufferRecycler = this._allocator;
        if (bufferRecycler == null || (cArr = this._currentSegment) == null) {
            return;
        }
        this._currentSegment = null;
        bufferRecycler.releaseCharBuffer(2, cArr);
    }

    public void resetWith(char c7) {
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(1);
        }
        this._currentSegment[0] = c7;
        this._segmentSize = 1;
        this._currentSize = 1;
    }

    public void resetWithCopy(char[] cArr, int i7, int i8) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(i8);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(cArr, i7, i8);
    }

    public void resetWithEmpty() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithShared(char[] cArr, int i7, int i8) {
        this._resultString = null;
        this._resultArray = null;
        this._inputBuffer = cArr;
        this._inputStart = i7;
        this._inputLen = i8;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithString(String str) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = str;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        this._currentSize = 0;
    }

    public String setCurrentAndReturn(int i7) {
        this._currentSize = i7;
        if (this._segmentSize > 0) {
            return contentsAsString();
        }
        String str = i7 == 0 ? "" : new String(this._currentSegment, 0, i7);
        this._resultString = str;
        return str;
    }

    public void setCurrentLength(int i7) {
        this._currentSize = i7;
    }

    public int size() {
        if (this._inputStart >= 0) {
            return this._inputLen;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this._resultString;
        return str != null ? str.length() : this._segmentSize + this._currentSize;
    }

    public String toString() {
        return contentsAsString();
    }

    public TextBuffer(BufferRecycler bufferRecycler, char[] cArr) {
        this._allocator = bufferRecycler;
        this._currentSegment = cArr;
        this._currentSize = cArr.length;
        this._inputStart = -1;
    }

    public char[] expandCurrentSegment(int i7) {
        char[] cArr = this._currentSegment;
        if (cArr.length >= i7) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i7);
        this._currentSegment = cArrCopyOf;
        return cArrCopyOf;
    }

    public void append(char[] cArr, int i7, int i8) {
        if (this._inputStart >= 0) {
            unshare(i8);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr2 = this._currentSegment;
        int length = cArr2.length;
        int i9 = this._currentSize;
        int i10 = length - i9;
        if (i10 >= i8) {
            System.arraycopy(cArr, i7, cArr2, i9, i8);
            this._currentSize += i8;
            return;
        }
        if (i10 > 0) {
            System.arraycopy(cArr, i7, cArr2, i9, i10);
            i7 += i10;
            i8 -= i10;
        }
        do {
            expand(i8);
            int iMin = Math.min(this._currentSegment.length, i8);
            System.arraycopy(cArr, i7, this._currentSegment, 0, iMin);
            this._currentSize += iMin;
            i7 += iMin;
            i8 -= iMin;
        } while (i8 > 0);
    }

    public void resetWithCopy(String str, int i7, int i8) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(i8);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(str, i7, i8);
    }

    public void append(String str, int i7, int i8) {
        if (this._inputStart >= 0) {
            unshare(i8);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i9 = this._currentSize;
        int i10 = length - i9;
        if (i10 >= i8) {
            str.getChars(i7, i7 + i8, cArr, i9);
            this._currentSize += i8;
            return;
        }
        if (i10 > 0) {
            int i11 = i7 + i10;
            str.getChars(i7, i11, cArr, i9);
            i8 -= i10;
            i7 = i11;
        }
        while (true) {
            expand(i8);
            int iMin = Math.min(this._currentSegment.length, i8);
            int i12 = i7 + iMin;
            str.getChars(i7, i12, this._currentSegment, 0);
            this._currentSize += iMin;
            i8 -= iMin;
            if (i8 <= 0) {
                return;
            } else {
                i7 = i12;
            }
        }
    }
}
