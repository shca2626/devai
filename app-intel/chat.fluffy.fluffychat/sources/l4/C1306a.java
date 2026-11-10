package l4;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import l4.C1306a;

/* renamed from: l4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1306a {

    /* renamed from: i, reason: collision with root package name */
    public static final String f19579i = "a";

    /* renamed from: j, reason: collision with root package name */
    public static final Collection f19580j;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19581a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19582b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19583c;

    /* renamed from: d, reason: collision with root package name */
    public final Camera f19584d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f19585e;

    /* renamed from: f, reason: collision with root package name */
    public int f19586f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Handler.Callback f19587g;

    /* renamed from: h, reason: collision with root package name */
    public final Camera.AutoFocusCallback f19588h;

    /* renamed from: l4.a$a, reason: collision with other inner class name */
    public class C0221a implements Handler.Callback {
        public C0221a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != C1306a.this.f19586f) {
                return false;
            }
            C1306a.this.h();
            return true;
        }
    }

    /* renamed from: l4.a$b */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        public static /* synthetic */ void a(b bVar) {
            C1306a.this.f19582b = false;
            C1306a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z7, Camera camera) {
            C1306a.this.f19585e.post(new Runnable() { // from class: l4.b
                @Override // java.lang.Runnable
                public final void run() {
                    C1306a.b.a(this.f19591l);
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f19580j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public C1306a(Camera camera, i iVar) {
        C0221a c0221a = new C0221a();
        this.f19587g = c0221a;
        this.f19588h = new b();
        this.f19585e = new Handler(c0221a);
        this.f19584d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z7 = iVar.c() && f19580j.contains(focusMode);
        this.f19583c = z7;
        Log.i(f19579i, "Current focus mode '" + focusMode + "'; use auto focus? " + z7);
        i();
    }

    public final synchronized void f() {
        if (!this.f19581a && !this.f19585e.hasMessages(this.f19586f)) {
            Handler handler = this.f19585e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f19586f), 2000L);
        }
    }

    public final void g() {
        this.f19585e.removeMessages(this.f19586f);
    }

    public final void h() {
        if (!this.f19583c || this.f19581a || this.f19582b) {
            return;
        }
        try {
            this.f19584d.autoFocus(this.f19588h);
            this.f19582b = true;
        } catch (RuntimeException e7) {
            Log.w(f19579i, "Unexpected exception while focusing", e7);
            f();
        }
    }

    public void i() {
        this.f19581a = false;
        h();
    }

    public void j() {
        this.f19581a = true;
        this.f19582b = false;
        g();
        if (this.f19583c) {
            try {
                this.f19584d.cancelAutoFocus();
            } catch (RuntimeException e7) {
                Log.w(f19579i, "Unexpected exception while cancelling focusing", e7);
            }
        }
    }
}
