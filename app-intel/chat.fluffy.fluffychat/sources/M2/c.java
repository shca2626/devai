package M2;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public abstract class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, M2.d dVar);
    }

    public interface b {
        String a(String str);

        void b(String str);

        String c(String str);

        String[] d();

        void e(String str);
    }

    /* renamed from: M2.c$c, reason: collision with other inner class name */
    public interface InterfaceC0053c {
    }

    public interface d {
        void a(String str);
    }

    public static M2.d a(d dVar) {
        return new M2.d().h(dVar);
    }
}
