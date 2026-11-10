package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    private static final int INT_SPACE = 32;
    static final char PADDING_CHAR_NONE = 0;
    private static final long serialVersionUID = 1;
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    private final transient int _maxLineLength;
    final String _name;
    private final transient char _paddingChar;
    private final transient boolean _usesPadding;

    public Base64Variant(String str, String str2, boolean z7, char c7, int i7) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._usesPadding = z7;
        this._paddingChar = c7;
        this._maxLineLength = i7;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i8 = 0; i8 < length; i8++) {
            char c8 = this._base64ToAsciiC[i8];
            this._base64ToAsciiB[i8] = (byte) c8;
            this._asciiToBase64[c8] = i8;
        }
        if (z7) {
            this._asciiToBase64[c7] = -2;
        }
    }

    public void _reportBase64EOF() {
        throw new IllegalArgumentException(missingPaddingMessage());
    }

    public void _reportInvalidBase64(char c7, int i7, String str) {
        String str2;
        if (c7 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c7) + ") as character #" + (i7 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c7)) {
            str2 = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i7 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c7) || Character.isISOControl(c7)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c7) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c7 + "' (code 0x" + Integer.toHexString(c7) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    public byte[] decode(String str) {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public int decodeBase64Byte(byte b7) {
        if (b7 < 0) {
            return -1;
        }
        return this._asciiToBase64[b7];
    }

    public int decodeBase64Char(char c7) {
        if (c7 <= 127) {
            return this._asciiToBase64[c7];
        }
        return -1;
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public byte encodeBase64BitsAsByte(int i7) {
        return this._base64ToAsciiB[i7];
    }

    public char encodeBase64BitsAsChar(int i7) {
        return this._base64ToAsciiC[i7];
    }

    public int encodeBase64Chunk(int i7, char[] cArr, int i8) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i8] = cArr2[(i7 >> 18) & 63];
        cArr[i8 + 1] = cArr2[(i7 >> 12) & 63];
        int i9 = i8 + 3;
        cArr[i8 + 2] = cArr2[(i7 >> 6) & 63];
        int i10 = i8 + 4;
        cArr[i9] = cArr2[i7 & 63];
        return i10;
    }

    public int encodeBase64Partial(int i7, int i8, char[] cArr, int i9) {
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i9] = cArr2[(i7 >> 18) & 63];
        int i10 = i9 + 2;
        cArr[i9 + 1] = cArr2[(i7 >> 12) & 63];
        if (this._usesPadding) {
            int i11 = i9 + 3;
            cArr[i10] = i8 == 2 ? cArr2[(i7 >> 6) & 63] : this._paddingChar;
            int i12 = i9 + 4;
            cArr[i11] = this._paddingChar;
            return i12;
        }
        if (i8 != 2) {
            return i10;
        }
        int i13 = i9 + 3;
        cArr[i10] = cArr2[(i7 >> 6) & 63];
        return i13;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public String getName() {
        return this._name;
    }

    public byte getPaddingByte() {
        return (byte) this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public String missingPaddingMessage() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end", getName(), Character.valueOf(getPaddingChar()));
    }

    public Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String toString() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c7) {
        return c7 == this._paddingChar;
    }

    public int decodeBase64Char(int i7) {
        if (i7 <= 127) {
            return this._asciiToBase64[i7];
        }
        return -1;
    }

    public String encode(byte[] bArr, boolean z7) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z7) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i7 = length - 3;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = i8 + 2;
            int i10 = ((bArr[i8 + 1] & 255) | (bArr[i8] << 8)) << 8;
            i8 += 3;
            encodeBase64Chunk(sb, i10 | (bArr[i9] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append('\\');
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i11 = length - i8;
        if (i11 > 0) {
            int i12 = i8 + 1;
            int i13 = bArr[i8] << 16;
            if (i11 == 2) {
                i13 |= (bArr[i12] & 255) << 8;
            }
            encodeBase64Partial(sb, i13, i11);
        }
        if (z7) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb.toString();
    }

    public boolean usesPaddingChar(int i7) {
        return i7 == this._paddingChar;
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) {
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            char cCharAt = str.charAt(i7);
            if (cCharAt > ' ') {
                int iDecodeBase64Char = decodeBase64Char(cCharAt);
                if (iDecodeBase64Char < 0) {
                    _reportInvalidBase64(cCharAt, 0, null);
                }
                if (i8 >= length) {
                    _reportBase64EOF();
                }
                int i9 = i7 + 2;
                char cCharAt2 = str.charAt(i8);
                int iDecodeBase64Char2 = decodeBase64Char(cCharAt2);
                if (iDecodeBase64Char2 < 0) {
                    _reportInvalidBase64(cCharAt2, 1, null);
                }
                int i10 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (i9 >= length) {
                    if (!usesPadding()) {
                        byteArrayBuilder.append(i10 >> 4);
                        return;
                    }
                    _reportBase64EOF();
                }
                int i11 = i7 + 3;
                char cCharAt3 = str.charAt(i9);
                int iDecodeBase64Char3 = decodeBase64Char(cCharAt3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        _reportInvalidBase64(cCharAt3, 2, null);
                    }
                    if (i11 >= length) {
                        _reportBase64EOF();
                    }
                    i7 += 4;
                    char cCharAt4 = str.charAt(i11);
                    if (!usesPaddingChar(cCharAt4)) {
                        _reportInvalidBase64(cCharAt4, 3, "expected padding character '" + getPaddingChar() + "'");
                    }
                    byteArrayBuilder.append(i10 >> 4);
                } else {
                    int i12 = (i10 << 6) | iDecodeBase64Char3;
                    if (i11 >= length) {
                        if (!usesPadding()) {
                            byteArrayBuilder.appendTwoBytes(i12 >> 2);
                            return;
                        }
                        _reportBase64EOF();
                    }
                    i7 += 4;
                    char cCharAt5 = str.charAt(i11);
                    int iDecodeBase64Char4 = decodeBase64Char(cCharAt5);
                    if (iDecodeBase64Char4 < 0) {
                        if (iDecodeBase64Char4 != -2) {
                            _reportInvalidBase64(cCharAt5, 3, null);
                        }
                        byteArrayBuilder.appendTwoBytes(i12 >> 2);
                    } else {
                        byteArrayBuilder.appendThreeBytes((i12 << 6) | iDecodeBase64Char4);
                    }
                }
            } else {
                i7 = i8;
            }
        }
    }

    public void encodeBase64Chunk(StringBuilder sb, int i7) {
        sb.append(this._base64ToAsciiC[(i7 >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i7 >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(i7 >> 6) & 63]);
        sb.append(this._base64ToAsciiC[i7 & 63]);
    }

    public void encodeBase64Partial(StringBuilder sb, int i7, int i8) {
        sb.append(this._base64ToAsciiC[(i7 >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i7 >> 12) & 63]);
        if (this._usesPadding) {
            sb.append(i8 == 2 ? this._base64ToAsciiC[(i7 >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (i8 == 2) {
            sb.append(this._base64ToAsciiC[(i7 >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int i7, byte[] bArr, int i8) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i8] = bArr2[(i7 >> 18) & 63];
        bArr[i8 + 1] = bArr2[(i7 >> 12) & 63];
        int i9 = i8 + 3;
        bArr[i8 + 2] = bArr2[(i7 >> 6) & 63];
        int i10 = i8 + 4;
        bArr[i9] = bArr2[i7 & 63];
        return i10;
    }

    public int encodeBase64Partial(int i7, int i8, byte[] bArr, int i9) {
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i9] = bArr2[(i7 >> 18) & 63];
        int i10 = i9 + 2;
        bArr[i9 + 1] = bArr2[(i7 >> 12) & 63];
        if (!this._usesPadding) {
            if (i8 != 2) {
                return i10;
            }
            int i11 = i9 + 3;
            bArr[i10] = bArr2[(i7 >> 6) & 63];
            return i11;
        }
        byte b7 = (byte) this._paddingChar;
        int i12 = i9 + 3;
        bArr[i10] = i8 == 2 ? bArr2[(i7 >> 6) & 63] : b7;
        int i13 = i9 + 4;
        bArr[i12] = b7;
        return i13;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i7) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i7);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z7, char c7, int i7) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        byte[] bArr = new byte[64];
        this._base64ToAsciiB = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant._base64ToAsciiB;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant._base64ToAsciiC;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant._asciiToBase64;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._usesPadding = z7;
        this._paddingChar = c7;
        this._maxLineLength = i7;
    }

    public String encode(byte[] bArr, boolean z7, String str) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z7) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i7 = length - 3;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = i8 + 2;
            int i10 = ((bArr[i8 + 1] & 255) | (bArr[i8] << 8)) << 8;
            i8 += 3;
            encodeBase64Chunk(sb, i10 | (bArr[i9] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append(str);
                maxLineLength = getMaxLineLength() >> 2;
            }
        }
        int i11 = length - i8;
        if (i11 > 0) {
            int i12 = i8 + 1;
            int i13 = bArr[i8] << 16;
            if (i11 == 2) {
                i13 |= (bArr[i12] & 255) << 8;
            }
            encodeBase64Partial(sb, i13, i11);
        }
        if (z7) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        return sb.toString();
    }
}
