package l4;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import l4.C1305a;

/* renamed from: l4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1305a {

    /* renamed from: i, reason: collision with root package name */
    public static final String f19578i = "a";

    /* renamed from: j, reason: collision with root package name */
    public static final Collection f19579j;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19580a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19581b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19582c;

    /* renamed from: d, reason: collision with root package name */
    public final Camera f19583d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f19584e;

    /* renamed from: f, reason: collision with root package name */
    public int f19585f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Handler.Callback f19586g;

    /* renamed from: h, reason: collision with root package name */
    public final Camera.AutoFocusCallback f19587h;

    /* renamed from: l4.a$a, reason: collision with other inner class name */
    public class C0221a implements Handler.Callback {
        public C0221a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != C1305a.this.f19585f) {
                return false;
            }
            C1305a.this.h();
            return true;
        }
    }

    /* renamed from: l4.a$b */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        public static /* synthetic */ void a(b bVar) {
            C1305a.this.f19581b = false;
            C1305a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z7, Camera camera) {
            C1305a.this.f19584e.post(new Runnable() { // from class: l4.b
                @Override // java.lang.Runnable
                public final void run() {
                    C1305a.b.a(this.f19590l);
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f19579j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public C1305a(Camera camera, i iVar) {
        C0221a c0221a = new C0221a();
        this.f19586g = c0221a;
        this.f19587h = new b();
        this.f19584e = new Handler(c0221a);
        this.f19583d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z7 = iVar.c() && f19579j.contains(focusMode);
        this.f19582c = z7;
        Log.i(f19578i, "Current focus mode '" + focusMode + "'; use auto focus? " + z7);
        i();
    }

    public final synchronized void f() {
        if (!this.f19580a && !this.f19584e.hasMessages(this.f19585f)) {
            Handler handler = this.f19584e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f19585f), 2000L);
        }
    }

    public final void g() {
        this.f19584e.removeMessages(this.f19585f);
    }

    public final void h() {
        if (!this.f19582c || this.f19580a || this.f19581b) {
            return;
        }
        try {
            this.f19583d.autoFocus(this.f19587h);
            this.f19581b = true;
        } catch (RuntimeException e7) {
            Log.w(f19578i, "Unexpected exception while focusing", e7);
            f();
        }
    }

    public void i() {
        this.f19580a = false;
        h();
    }

    public void j() {
        this.f19580a = true;
        this.f19581b = false;
        g();
        if (this.f19582c) {
            try {
                this.f19583d.cancelAutoFocus();
            } catch (RuntimeException e7) {
                Log.w(f19578i, "Unexpected exception while cancelling focusing", e7);
            }
        }
    }
}
