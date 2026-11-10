package J3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public StringBuilder f4779a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f4780b;

    /* renamed from: c, reason: collision with root package name */
    public Charset f4781c;

    public h() {
        this.f4781c = StandardCharsets.ISO_8859_1;
        this.f4779a = new StringBuilder();
    }

    public void a(byte b7) {
        this.f4779a.append((char) (b7 & 255));
    }

    public void b(char c7) {
        this.f4779a.append((char) (c7 & 255));
    }

    public void c(int i7) {
        d(String.valueOf(i7));
    }

    public void d(String str) {
        this.f4779a.append(str);
    }

    public void e(StringBuilder sb) {
        g();
        this.f4780b.append((CharSequence) sb);
    }

    public void f(int i7) throws D3.f {
        g();
        d dVarD = d.d(i7);
        if (dVarD == null) {
            throw D3.f.a();
        }
        this.f4781c = dVarD.e();
    }

    public final void g() {
        Charset charset = this.f4781c;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (charset.equals(charset2)) {
            if (this.f4779a.length() > 0) {
                StringBuilder sb = this.f4780b;
                if (sb == null) {
                    this.f4780b = this.f4779a;
                    this.f4779a = new StringBuilder();
                    return;
                } else {
                    sb.append((CharSequence) this.f4779a);
                    this.f4779a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.f4779a.length() > 0) {
            byte[] bytes = this.f4779a.toString().getBytes(charset2);
            this.f4779a = new StringBuilder();
            StringBuilder sb2 = this.f4780b;
            if (sb2 == null) {
                this.f4780b = new StringBuilder(new String(bytes, this.f4781c));
            } else {
                sb2.append(new String(bytes, this.f4781c));
            }
        }
    }

    public boolean h() {
        if (this.f4779a.length() != 0) {
            return false;
        }
        StringBuilder sb = this.f4780b;
        return sb == null || sb.length() == 0;
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb = this.f4780b;
        return sb == null ? "" : sb.toString();
    }

    public h(int i7) {
        this.f4781c = StandardCharsets.ISO_8859_1;
        this.f4779a = new StringBuilder(i7);
    }
}
