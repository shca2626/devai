package androidx.emoji2.text;

import V.k;
import Y.h;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import l0.AbstractC1299i;
import l0.C1295e;
import m0.C1319b;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final C1319b f12339a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f12340b;

    /* renamed from: c, reason: collision with root package name */
    public final a f12341c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f12342d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray f12343a;

        /* renamed from: b, reason: collision with root package name */
        public C1295e f12344b;

        public a() {
            this(1);
        }

        public a a(int i7) {
            SparseArray sparseArray = this.f12343a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i7);
        }

        public final C1295e b() {
            return this.f12344b;
        }

        public void c(C1295e c1295e, int i7, int i8) {
            a aVarA = a(c1295e.b(i7));
            if (aVarA == null) {
                aVarA = new a();
                this.f12343a.put(c1295e.b(i7), aVarA);
            }
            if (i8 > i7) {
                aVarA.c(c1295e, i7 + 1, i8);
            } else {
                aVarA.f12344b = c1295e;
            }
        }

        public a(int i7) {
            this.f12343a = new SparseArray(i7);
        }
    }

    public f(Typeface typeface, C1319b c1319b) {
        this.f12342d = typeface;
        this.f12339a = c1319b;
        this.f12340b = new char[c1319b.k() * 2];
        a(c1319b);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            k.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, AbstractC1299i.b(byteBuffer));
        } finally {
            k.b();
        }
    }

    public final void a(C1319b c1319b) {
        int iK = c1319b.k();
        for (int i7 = 0; i7 < iK; i7++) {
            C1295e c1295e = new C1295e(this, i7);
            Character.toChars(c1295e.f(), this.f12340b, i7 * 2);
            h(c1295e);
        }
    }

    public char[] c() {
        return this.f12340b;
    }

    public C1319b d() {
        return this.f12339a;
    }

    public int e() {
        return this.f12339a.l();
    }

    public a f() {
        return this.f12341c;
    }

    public Typeface g() {
        return this.f12342d;
    }

    public void h(C1295e c1295e) {
        h.k(c1295e, "emoji metadata cannot be null");
        h.a(c1295e.c() > 0, "invalid metadata codepoint length");
        this.f12341c.c(c1295e, 0, c1295e.c() - 1);
    }
}
