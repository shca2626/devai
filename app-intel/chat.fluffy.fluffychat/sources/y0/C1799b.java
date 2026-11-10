package y0;

import androidx.lifecycle.InterfaceC0808n;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import y.l;

/* renamed from: y0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1799b extends AbstractC1798a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0808n f23822a;

    /* renamed from: b, reason: collision with root package name */
    public final a f23823b;

    /* renamed from: y0.b$a */
    public static class a extends M {

        /* renamed from: d, reason: collision with root package name */
        public static final N.c f23824d = new C0291a();

        /* renamed from: b, reason: collision with root package name */
        public l f23825b = new l();

        /* renamed from: c, reason: collision with root package name */
        public boolean f23826c = false;

        /* renamed from: y0.b$a$a, reason: collision with other inner class name */
        public static class C0291a implements N.c {
            @Override // androidx.lifecycle.N.c
            public M a(Class cls) {
                return new a();
            }
        }

        public static a f(O o7) {
            return (a) new N(o7, f23824d).b(a.class);
        }

        @Override // androidx.lifecycle.M
        public void d() {
            super.d();
            if (this.f23825b.n() <= 0) {
                this.f23825b.b();
            } else {
                android.support.v4.media.session.b.a(this.f23825b.o(0));
                throw null;
            }
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f23825b.n() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f23825b.n() <= 0) {
                    return;
                }
                android.support.v4.media.session.b.a(this.f23825b.o(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f23825b.h(0));
                printWriter.print(": ");
                throw null;
            }
        }

        public void g() {
            if (this.f23825b.n() <= 0) {
                return;
            }
            android.support.v4.media.session.b.a(this.f23825b.o(0));
            throw null;
        }
    }

    public C1799b(InterfaceC0808n interfaceC0808n, O o7) {
        this.f23822a = interfaceC0808n;
        this.f23823b = a.f(o7);
    }

    @Override // y0.AbstractC1798a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f23823b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // y0.AbstractC1798a
    public void c() {
        this.f23823b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Y.b.a(this.f23822a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
