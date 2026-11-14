package org.unifiedpush.android.connector.internal;

import M5.g;
import M5.m;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import y5.C1810f;
import y5.C1823s;
import z6.e;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static e f20526b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f20527c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f20528d;

    /* renamed from: a, reason: collision with root package name */
    public static final a f20525a = new a();

    /* renamed from: e, reason: collision with root package name */
    public static LinkedList f20529e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public static final c f20530f = new c();

    /* renamed from: org.unifiedpush.android.connector.internal.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0236a {

        /* renamed from: org.unifiedpush.android.connector.internal.a$a$a, reason: collision with other inner class name */
        public static final class C0237a extends AbstractC0236a {

            /* renamed from: a, reason: collision with root package name */
            public final A6.c f20531a;

            /* renamed from: b, reason: collision with root package name */
            public final String f20532b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0237a(A6.c cVar, String str) {
                super(null);
                m.e(cVar, "message");
                m.e(str, "instance");
                this.f20531a = cVar;
                this.f20532b = str;
            }

            public final String b() {
                return this.f20532b;
            }

            public final A6.c c() {
                return this.f20531a;
            }
        }

        /* renamed from: org.unifiedpush.android.connector.internal.a$a$b */
        public static final class b extends AbstractC0236a {

            /* renamed from: a, reason: collision with root package name */
            public final A6.b f20533a;

            /* renamed from: b, reason: collision with root package name */
            public final String f20534b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(A6.b bVar, String str) {
                super(null);
                m.e(bVar, "endpoint");
                m.e(str, "instance");
                this.f20533a = bVar;
                this.f20534b = str;
            }

            public final A6.b b() {
                return this.f20533a;
            }

            public final String c() {
                return this.f20534b;
            }
        }

        /* renamed from: org.unifiedpush.android.connector.internal.a$a$c */
        public static final class c extends AbstractC0236a {

            /* renamed from: a, reason: collision with root package name */
            public final z6.a f20535a;

            /* renamed from: b, reason: collision with root package name */
            public final String f20536b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(z6.a aVar, String str) {
                super(null);
                m.e(aVar, "reason");
                m.e(str, "instance");
                this.f20535a = aVar;
                this.f20536b = str;
            }

            public final String b() {
                return this.f20536b;
            }

            public final z6.a c() {
                return this.f20535a;
            }
        }

        /* renamed from: org.unifiedpush.android.connector.internal.a$a$d */
        public static final class d extends AbstractC0236a {

            /* renamed from: a, reason: collision with root package name */
            public final String f20537a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String str) {
                super(null);
                m.e(str, "instance");
                this.f20537a = str;
            }

            public final String b() {
                return this.f20537a;
            }
        }

        /* renamed from: org.unifiedpush.android.connector.internal.a$a$e */
        public static final class e extends AbstractC0236a {

            /* renamed from: a, reason: collision with root package name */
            public final String f20538a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(String str) {
                super(null);
                m.e(str, "instance");
                this.f20538a = str;
            }

            public final String b() {
                return this.f20538a;
            }
        }

        public /* synthetic */ AbstractC0236a(g gVar) {
            this();
        }

        public final void a() {
            z6.e eVar = null;
            if (this instanceof C0237a) {
                z6.e eVar2 = a.f20526b;
                if (eVar2 == null) {
                    m.o("mService");
                } else {
                    eVar = eVar2;
                }
                C0237a c0237a = (C0237a) this;
                eVar.a(c0237a.c(), c0237a.b());
                return;
            }
            if (this instanceof b) {
                z6.e eVar3 = a.f20526b;
                if (eVar3 == null) {
                    m.o("mService");
                } else {
                    eVar = eVar3;
                }
                b bVar = (b) this;
                eVar.b(bVar.b(), bVar.c());
                return;
            }
            if (this instanceof c) {
                z6.e eVar4 = a.f20526b;
                if (eVar4 == null) {
                    m.o("mService");
                } else {
                    eVar = eVar4;
                }
                c cVar = (c) this;
                eVar.c(cVar.c(), cVar.b());
                return;
            }
            if (this instanceof e) {
                z6.e eVar5 = a.f20526b;
                if (eVar5 == null) {
                    m.o("mService");
                } else {
                    eVar = eVar5;
                }
                eVar.e(((e) this).b());
                return;
            }
            if (!(this instanceof d)) {
                throw new C1810f();
            }
            z6.e eVar6 = a.f20526b;
            if (eVar6 == null) {
                m.o("mService");
            } else {
                eVar = eVar6;
            }
            eVar.d(((d) this).b());
        }

        public AbstractC0236a() {
        }
    }

    public static final class b extends TimerTask {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Context f20539l;

        public b(Context context) {
            this.f20539l = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Log.d("UnifiedPush", "Unbinding");
            this.f20539l.unbindService(a.f20530f);
        }
    }

    public static final class c implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.e(componentName, "className");
            m.e(iBinder, "service");
            Log.d("UnifiedPush", "Service is connected");
            a aVar = a.f20525a;
            a.f20526b = ((e.b) iBinder).a();
            a aVar2 = a.f20525a;
            synchronized (aVar2) {
                a.f20528d = true;
                a.f20527c = false;
                C1823s c1823s = C1823s.f24020a;
            }
            aVar2.h();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            m.e(componentName, "arg0");
            Log.d("UnifiedPush", "Service is disconnected");
            synchronized (a.f20525a) {
                a.f20528d = false;
                a.f20527c = false;
                C1823s c1823s = C1823s.f24020a;
            }
        }
    }

    public final void g(Context context) {
        Log.d("UnifiedPush", "Binding to PushService");
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent();
        intent.setAction("org.unifiedpush.android.connector.PUSH_EVENT");
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.bindService(intent, f20530f, 1);
        new Timer().schedule(new b(applicationContext), 5000L);
    }

    public final void h() {
        while (!f20529e.isEmpty()) {
            ((AbstractC0236a) f20529e.pop()).a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(android.content.Context r4, org.unifiedpush.android.connector.internal.a.AbstractC0236a r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            M5.m.e(r4, r0)
            java.lang.String r0 = "event"
            M5.m.e(r5, r0)
            monitor-enter(r3)
            boolean r0 = org.unifiedpush.android.connector.internal.a.f20528d     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L1e
            java.util.LinkedList r1 = org.unifiedpush.android.connector.internal.a.f20529e     // Catch: java.lang.Throwable -> L1c
            r1.add(r5)     // Catch: java.lang.Throwable -> L1c
            boolean r1 = org.unifiedpush.android.connector.internal.a.f20527c     // Catch: java.lang.Throwable -> L1c
            if (r1 != 0) goto L1e
            r1 = 1
            org.unifiedpush.android.connector.internal.a.f20527c = r1     // Catch: java.lang.Throwable -> L1c
            goto L1f
        L1c:
            r4 = move-exception
            goto L36
        L1e:
            r1 = 0
        L1f:
            y5.s r2 = y5.C1823s.f24020a     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r3)
            if (r0 == 0) goto L28
            r5.a()
            return
        L28:
            if (r1 == 0) goto L2e
            r3.g(r4)
            return
        L2e:
            java.lang.String r4 = "UnifiedPush"
            java.lang.String r5 = "Event has been added to the queue"
            android.util.Log.d(r4, r5)
            return
        L36:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.unifiedpush.android.connector.internal.a.i(android.content.Context, org.unifiedpush.android.connector.internal.a$a):void");
    }
}
