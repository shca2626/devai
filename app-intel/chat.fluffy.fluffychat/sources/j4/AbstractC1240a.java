package j4;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import i4.t;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/* renamed from: j4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1240a {
    public static byte[] a(Context context, t tVar, Cipher cipher) throws Exception {
        String string = context.getSharedPreferences(e(tVar).e(), 0).getString("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null);
        if (string != null) {
            return cipher.doFinal(Base64.decode(string, 0));
        }
        throw new Exception("No biometric app key found to recover");
    }

    public static boolean b(SharedPreferences sharedPreferences) {
        return r.f(sharedPreferences);
    }

    public static boolean c(Context context, String str, t tVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        String strM = tVar.m();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            if ((entry.getValue() instanceof String) && entry.getKey().contains(strM)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context, t tVar) {
        return !b(context.getSharedPreferences(tVar.e(), 0)) && b(context.getSharedPreferences(e(tVar).e(), 0)) && c(context, tVar.d(), tVar);
    }

    public static t e(t tVar) {
        return tVar.r() ? tVar.y() : tVar.x(tVar.d());
    }

    public static InterfaceC1241b f(Context context, t tVar) {
        return e.AES_GCM_NoPadding.f18750l.a(context, e(tVar));
    }

    public static void g(Context context, t tVar, Cipher cipher, byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        context.getSharedPreferences(tVar.e(), 0).edit().putString("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(cipher.doFinal(bArr), 0)).apply();
    }

    public static InterfaceC1241b h(Context context, t tVar) {
        return e.AES_GCM_NoPadding.f18750l.a(context, tVar);
    }
}
