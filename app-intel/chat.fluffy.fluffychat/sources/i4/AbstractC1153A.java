package i4;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: i4.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1153A {
    public static t a(t tVar) {
        return tVar.r() ? tVar.y() : tVar.x(tVar.d());
    }

    public static int b(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        int i7 = 0;
        if (!all.containsKey("__androidx_security_crypto_encrypted_prefs_key_keyset__") && !all.containsKey("__androidx_security_crypto_encrypted_prefs_value_keyset__")) {
            return 0;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            if ((entry.getValue() instanceof String) && !key.equals("__androidx_security_crypto_encrypted_prefs_key_keyset__") && !key.equals("__androidx_security_crypto_encrypted_prefs_value_keyset__") && !key.startsWith("FlutterSecureSAlgorithm") && !key.equals("FlutterSecureStorageLegacyDataDiscarded")) {
                i7++;
            }
        }
        return i7;
    }

    public static boolean c(Context context, t tVar) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String str = context.getPackageName() + ".FlutterSecureStoragePluginKeyOAEP" + tVar.g();
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static Map d(Context context, t tVar) {
        y yVar = new y(context, tVar.d());
        String strE = yVar.e("FlutterSecureStorageLegacyDataDiscarded", null);
        if (strE != null) {
            yVar.b().remove("FlutterSecureStorageLegacyDataDiscarded").apply();
            return e("legacyDataDiscarded", strE, 0, false, "Unreadable data was deleted by an earlier storage access.");
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(tVar.d(), 0);
        String strM = tVar.m();
        String str = null;
        int i7 = 0;
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            if ((entry.getValue() instanceof String) && key.contains(strM) && !key.endsWith("_BACKUP")) {
                i7++;
                if (str == null) {
                    str = (String) entry.getValue();
                }
            }
        }
        if (i7 == 0) {
            int iB = b(sharedPreferences);
            return iB > 0 ? e("legacyDataUnreadable", "legacyBackendPresent", iB, false, "Data is in the EncryptedSharedPreferences (Tink) store, whose backend v11 removed. Upgrading to v10 before v11 would have migrated it.") : e("ok", "none", 0, false, "No stored data.");
        }
        String strJ = j4.p.j(yVar);
        String strK = j4.p.k(yVar);
        if (strJ == null || strK == null) {
            return f(tVar, "missingAlgorithmMarkers", i7, "Data carries no algorithm markers, so it was written by v9 or earlier. Upgrading to v10 before v11 would have migrated it.");
        }
        if (j4.e.e(strJ) || j4.o.e(strK)) {
            return f(tVar, "removedCipher", i7, "Data was encrypted with " + strJ + "/" + strK + ", removed in v11. Upgrading to v10 before v11 would have migrated it.");
        }
        try {
            j4.e eVarD = j4.e.d(strJ);
            j4.o.d(strK);
            if (eVarD == j4.e.AES_GCM_NoPadding) {
                return e("unknown", "authenticationRequired", i7, false, "Stored data is behind user authentication, so it was not read.");
            }
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(tVar.e(), 0);
            if (!c(context, tVar) || sharedPreferences2.getString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null) == null) {
                t tVarA = a(tVar);
                return (!c(context, tVarA) || context.getSharedPreferences(tVarA.e(), 0).getString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null) == null) ? f(tVar, "missingKeyMaterial", i7, "Stored data is orphaned: the key needed to decrypt it is gone.") : e("ok", "pendingNamespaceRecovery", i7, false, "Key material is at the pre-namespace-switch location; the next initialize() call will relocate it automatically.");
            }
            try {
                new j4.p(yVar, strJ, strK, tVar).h(context, null).b(Base64.decode(str, 0));
                return e("ok", "none", i7, false, "Stored data is readable.");
            } catch (Throwable th) {
                if (th instanceof VirtualMachineError) {
                    throw th;
                }
                Log.w("UpgradeInspector", "Trial decryption of stored data failed", th);
                return f(tVar, "decryptFailed", i7, "Stored data could not be decrypted: " + th.getMessage());
            }
        } catch (IllegalArgumentException unused) {
            return f(tVar, "removedCipher", i7, "Data was encrypted with unrecognised algorithm markers " + strJ + "/" + strK + ".");
        }
    }

    public static Map e(String str, String str2, int i7, boolean z7, String str3) {
        HashMap map = new HashMap();
        map.put("state", str);
        map.put("reason", str2);
        map.put("entryCount", Integer.valueOf(i7));
        map.put("willDiscardOnNextAccess", Boolean.valueOf(z7));
        map.put("details", str3);
        return map;
    }

    public static Map f(t tVar, String str, int i7, String str2) {
        return e("legacyDataUnreadable", str, i7, tVar.u(), str2);
    }
}
