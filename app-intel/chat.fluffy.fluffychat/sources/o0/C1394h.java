package o0;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

/* renamed from: o0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1394h {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f20348a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1391e f20349b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20350c;

    public C1394h(Bundle bundle, InterfaceC1391e interfaceC1391e, boolean z7) {
        this.f20348a = bundle;
        this.f20349b = interfaceC1391e;
        this.f20350c = z7;
    }

    public Message a() {
        Message messageObtain = Message.obtain();
        messageObtain.what = this.f20350c ? 2 : 1;
        messageObtain.obj = this.f20348a;
        return messageObtain;
    }

    public void b(int i7, Throwable th) {
        InterfaceC1391e interfaceC1391e = this.f20349b;
        if (interfaceC1391e != null) {
            interfaceC1391e.a(i7, th);
            return;
        }
        Log.e("SendableMessage", "Error sending message. error: " + i7, th);
    }

    public void c() {
        InterfaceC1391e interfaceC1391e = this.f20349b;
        if (interfaceC1391e != null) {
            interfaceC1391e.a(0, null);
        }
    }
}
