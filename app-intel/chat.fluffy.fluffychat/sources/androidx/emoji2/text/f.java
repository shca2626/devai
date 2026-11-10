package androidx.emoji2.text;

import V.k;
import Y.h;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import l0.AbstractC1300i;
import l0.C1296e;
import m0.C1320b;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final C1320b f12339a;

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
        public C1296e f12344b;

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

        public final C1296e b() {
            return this.f12344b;
        }

        public void c(C1296e c1296e, int i7, int i8) {
            a aVarA = a(c1296e.b(i7));
            if (aVarA == null) {
                aVarA = new a();
                this.f12343a.put(c1296e.b(i7), aVarA);
            }
            if (i8 > i7) {
                aVarA.c(c1296e, i7 + 1, i8);
            } else {
                aVarA.f12344b = c1296e;
            }
        }

        public a(int i7) {
            this.f12343a = new SparseArray(i7);
        }
    }

    public f(Typeface typeface, C1320b c1320b) {
        this.f12342d = typeface;
        this.f12339a = c1320b;
        this.f12340b = new char[c1320b.k() * 2];
        a(c1320b);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            k.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, AbstractC1300i.b(byteBuffer));
        } finally {
            k.b();
        }
    }

    public final void a(C1320b c1320b) {
        int iK = c1320b.k();
        for (int i7 = 0; i7 < iK; i7++) {
            C1296e c1296e = new C1296e(this, i7);
            Character.toChars(c1296e.f(), this.f12340b, i7 * 2);
            h(c1296e);
        }
    }

    public char[] c() {
        return this.f12340b;
    }

    public C1320b d() {
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

    public void h(C1296e c1296e) {
        h.k(c1296e, "emoji metadata cannot be null");
        h.a(c1296e.c() > 0, "invalid metadata codepoint length");
        this.f12341c.c(c1296e, 0, c1296e.c() - 1);
    }
}
