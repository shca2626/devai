package u3;

import java.util.Objects;

/* renamed from: u3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1647d {

    /* renamed from: d, reason: collision with root package name */
    public static final C1647d f22800d = new C1647d("", "", false);

    /* renamed from: e, reason: collision with root package name */
    public static final C1647d f22801e = new C1647d("\n", "  ", true);

    /* renamed from: a, reason: collision with root package name */
    public final String f22802a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22803b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f22804c;

    public C1647d(String str, String str2, boolean z7) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f22802a = str;
        this.f22803b = str2;
        this.f22804c = z7;
    }

    public String a() {
        return this.f22803b;
    }

    public String b() {
        return this.f22802a;
    }

    public boolean c() {
        return this.f22804c;
    }
}
