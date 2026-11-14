package w0;

import M5.g;
import M5.m;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1724a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0283a f23257b = new C0283a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map f23258a = new LinkedHashMap();

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    public static final class C0283a {
        public /* synthetic */ C0283a(g gVar) {
            this();
        }

        public C0283a() {
        }
    }

    /* renamed from: w0.a$b */
    public static final class b extends AbstractC1724a {

        /* renamed from: c, reason: collision with root package name */
        public static final b f23259c = new b();

        @Override // w0.AbstractC1724a
        public Object a(c cVar) {
            m.e(cVar, "key");
            return null;
        }
    }

    /* renamed from: w0.a$c */
    public interface c {
    }

    public abstract Object a(c cVar);

    public final Map b() {
        return this.f23258a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC1724a) && m.a(this.f23258a, ((AbstractC1724a) obj).f23258a);
    }

    public int hashCode() {
        return this.f23258a.hashCode();
    }

    public String toString() {
        return "CreationExtras(extras=" + this.f23258a + ')';
    }
}
