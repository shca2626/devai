package i4;

import android.hardware.biometrics.BiometricPrompt;
import javax.crypto.Cipher;

/* renamed from: i4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1155a {
    public static /* synthetic */ BiometricPrompt.CryptoObject a(Cipher cipher) {
        return new BiometricPrompt.CryptoObject(cipher);
    }
}
