package Q;

import V.f;
import android.content.Context;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public class a {

    /* renamed from: Q.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0060a {
    }

    public static a b(Context context) {
        return new a();
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f7560a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f7561b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f7562c;

        public b(Signature signature) {
            this.f7560a = signature;
            this.f7561b = null;
            this.f7562c = null;
        }

        public b(Cipher cipher) {
            this.f7561b = cipher;
            this.f7560a = null;
            this.f7562c = null;
        }

        public b(Mac mac) {
            this.f7562c = mac;
            this.f7561b = null;
            this.f7560a = null;
        }
    }

    public void a(b bVar, int i7, f fVar, AbstractC0060a abstractC0060a, Handler handler) {
    }
}
