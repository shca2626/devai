package z6;

import M5.m;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;

/* loaded from: classes3.dex */
public abstract class e extends Service {

    /* renamed from: l, reason: collision with root package name */
    public static final a f24188l = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public final class b extends Binder {
        public b() {
        }

        public final e a() {
            if (Binder.getCallingUid() == Process.myUid()) {
                return e.this;
            }
            throw new SecurityException("Binding allowed only within the app");
        }
    }

    public abstract void a(A6.c cVar, String str);

    public abstract void b(A6.b bVar, String str);

    public abstract void c(z6.a aVar, String str);

    public void d(String str) {
        m.e(str, "instance");
    }

    public abstract void e(String str);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new b();
    }
}
