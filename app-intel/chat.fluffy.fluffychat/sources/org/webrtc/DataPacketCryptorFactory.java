package org.webrtc;

/* loaded from: classes3.dex */
public class DataPacketCryptorFactory {
    public static DataPacketCryptor createDataPacketCryptor(FrameCryptorAlgorithm frameCryptorAlgorithm, FrameCryptorKeyProvider frameCryptorKeyProvider) {
        return nativeCreateDataPacketCryptor(frameCryptorAlgorithm.getValue(), frameCryptorKeyProvider.getNativeKeyProvider());
    }

    private static native DataPacketCryptor nativeCreateDataPacketCryptor(int i7, long j7);
}
