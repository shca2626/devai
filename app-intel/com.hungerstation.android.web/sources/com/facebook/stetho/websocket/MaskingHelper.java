package com.facebook.stetho.websocket;

/* loaded from: classes8.dex */
class MaskingHelper {
    MaskingHelper() {
    }

    public static void unmask(byte[] bArr, byte[] bArr2, int i12, int i13) {
        int i14 = 0;
        while (true) {
            int i15 = i13 - 1;
            if (i13 <= 0) {
                return;
            }
            bArr2[i12] = (byte) (bArr[i14 % bArr.length] ^ bArr2[i12]);
            i12++;
            i13 = i15;
            i14++;
        }
    }
}
