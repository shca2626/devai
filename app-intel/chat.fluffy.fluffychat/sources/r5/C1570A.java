package r5;

import h5.c;

/* renamed from: r5.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1570A {

    /* renamed from: a, reason: collision with root package name */
    public final c.b f22169a;

    public C1570A(c.b bVar) {
        M5.m.e(bVar, "sink");
        this.f22169a = bVar;
    }

    public final void a(String str, String str2, Object obj) {
        M5.m.e(str, "errorCode");
        this.f22169a.error(str, str2, obj);
    }

    public final void b(Object obj) {
        this.f22169a.success(obj);
    }
}
