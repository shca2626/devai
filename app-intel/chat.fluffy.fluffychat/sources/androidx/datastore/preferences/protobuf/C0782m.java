package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0788t;
import java.util.Collections;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0782m {

    /* renamed from: b, reason: collision with root package name */
    public static volatile C0782m f12150b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0782m f12151c = new C0782m(true);

    /* renamed from: a, reason: collision with root package name */
    public final Map f12152a = Collections.EMPTY_MAP;

    /* renamed from: androidx.datastore.preferences.protobuf.m$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f12153a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12154b;

        public a(Object obj, int i7) {
            this.f12153a = obj;
            this.f12154b = i7;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12153a == aVar.f12153a && this.f12154b == aVar.f12154b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f12153a) * 65535) + this.f12154b;
        }
    }

    public C0782m(boolean z7) {
    }

    public static C0782m b() {
        C0782m c0782mA;
        if (V.f11988d) {
            return f12151c;
        }
        C0782m c0782m = f12150b;
        if (c0782m != null) {
            return c0782m;
        }
        synchronized (C0782m.class) {
            try {
                c0782mA = f12150b;
                if (c0782mA == null) {
                    c0782mA = AbstractC0781l.a();
                    f12150b = c0782mA;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0782mA;
    }

    public AbstractC0788t.d a(K k7, int i7) {
        android.support.v4.media.session.b.a(this.f12152a.get(new a(k7, i7)));
        return null;
    }
}
