package o0;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

/* renamed from: o0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1393h {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f20347a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1390e f20348b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20349c;

    public C1393h(Bundle bundle, InterfaceC1390e interfaceC1390e, boolean z7) {
        this.f20347a = bundle;
        this.f20348b = interfaceC1390e;
        this.f20349c = z7;
    }

    public Message a() {
        Message messageObtain = Message.obtain();
        messageObtain.what = this.f20349c ? 2 : 1;
        messageObtain.obj = this.f20347a;
        return messageObtain;
    }

    public void b(int i7, Throwable th) {
        InterfaceC1390e interfaceC1390e = this.f20348b;
        if (interfaceC1390e != null) {
            interfaceC1390e.a(i7, th);
            return;
        }
        Log.e("SendableMessage", "Error sending message. error: " + i7, th);
    }

    public void c() {
        InterfaceC1390e interfaceC1390e = this.f20348b;
        if (interfaceC1390e != null) {
            interfaceC1390e.a(0, null);
        }
    }
}
