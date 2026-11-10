package u3;

import java.util.Objects;

/* renamed from: u3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1648d {

    /* renamed from: d, reason: collision with root package name */
    public static final C1648d f22794d = new C1648d("", "", false);

    /* renamed from: e, reason: collision with root package name */
    public static final C1648d f22795e = new C1648d("\n", "  ", true);

    /* renamed from: a, reason: collision with root package name */
    public final String f22796a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22797b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f22798c;

    public C1648d(String str, String str2, boolean z7) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f22796a = str;
        this.f22797b = str2;
        this.f22798c = z7;
    }

    public String a() {
        return this.f22797b;
    }

    public String b() {
        return this.f22796a;
    }

    public boolean c() {
        return this.f22798c;
    }
}
