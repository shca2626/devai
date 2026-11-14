package j4;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import i4.t;
import java.security.Key;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class m {

    public interface a {
        InterfaceC1240b a(t tVar);
    }

    public static boolean b(Context context, String str, t tVar) {
        return g(context, str, tVar.m()) != null;
    }

    public static boolean c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null) != null;
    }

    public static boolean d(Context context, String str, String str2, byte[] bArr) {
        String strG = g(context, str, str2);
        if (strG == null) {
            return false;
        }
        try {
            byte[] bArrDecode = Base64.decode(strG, 0);
            if (bArrDecode.length <= 12) {
                return false;
            }
            try {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDecode, 0, 12);
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrDecode, 12, bArrDecode.length);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, new SecretKeySpec(bArr, "AES"), new GCMParameterSpec(128, bArrCopyOfRange));
                cipher.doFinal(bArrCopyOfRange2);
                return true;
            } catch (Throwable th) {
                if (th instanceof VirtualMachineError) {
                    throw th;
                }
                return false;
            }
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean e(final Context context, t tVar) {
        return f(context, tVar, new a() { // from class: j4.l
            @Override // j4.m.a
            public final InterfaceC1240b a(t tVar2) {
                return e.RSA_ECB_OAEPwithSHA_256andMGF1Padding.f18749l.a(context, tVar2);
            }
        });
    }

    public static boolean f(Context context, t tVar, a aVar) {
        t tVarX;
        String str;
        String strD = tVar.d();
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSecureKeyStorage", 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("FlutterSecureKeyStorage:" + strD, 0);
        if (tVar.r()) {
            tVarX = tVar.y();
            sharedPreferences2 = sharedPreferences;
            sharedPreferences = sharedPreferences2;
        } else {
            tVarX = tVar.x(strD);
        }
        if (c(sharedPreferences) || !c(sharedPreferences2) || !b(context, strD, tVar)) {
            return false;
        }
        try {
            Key keyB = aVar.a(tVarX).b(Base64.decode(sharedPreferences2.getString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null), 0), "AES");
            byte[] encoded = keyB.getEncoded();
            if (encoded != null && encoded.length == 16) {
                if (!d(context, strD, tVar.m(), encoded)) {
                    throw new Exception("Unwrapped key does not decrypt this instance's own data; likely a different instance's key under the same preference name");
                }
                sharedPreferences.edit().putString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(aVar.a(tVar).a(keyB), 0)).apply();
                Log.i("LegacyNamespaceKeyRecovery", "Moved wrapped key for namespace '" + strD + "'");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unwrapped key is not AES-key-shaped (");
            if (encoded == null) {
                str = "null";
            } else {
                str = encoded.length + " bytes";
            }
            sb.append(str);
            sb.append("); likely belongs to a different instance");
            throw new Exception(sb.toString());
        } catch (Throwable th) {
            if (th instanceof VirtualMachineError) {
                throw th;
            }
            Log.w("LegacyNamespaceKeyRecovery", "Could not move wrapped key for namespace '" + strD + "'", th);
            return false;
        }
    }

    public static String g(Context context, String str, String str2) {
        for (Map.Entry<String, ?> entry : context.getSharedPreferences(str, 0).getAll().entrySet()) {
            if ((entry.getValue() instanceof String) && entry.getKey().contains(str2)) {
                return (String) entry.getValue();
            }
        }
        return null;
    }
}
