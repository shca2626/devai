package org.unifiedpush.android.connector.internal;

import M5.g;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/* loaded from: classes3.dex */
public final class RaiseToForegroundService extends Service {

    /* renamed from: l, reason: collision with root package name */
    public static final a f20524l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public static final Binder f20525m = new Binder();

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public a() {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return f20525m;
    }
}
