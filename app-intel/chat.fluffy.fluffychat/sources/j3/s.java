package j3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1229d f18727a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18728b;

    /* renamed from: c, reason: collision with root package name */
    public final c f18729c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18730d;

    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1229d f18731a;

        /* renamed from: j3.s$a$a, reason: collision with other inner class name */
        public class C0210a extends b {
            public C0210a(s sVar, CharSequence charSequence) {
                super(sVar, charSequence);
            }

            @Override // j3.s.b
            public int e(int i7) {
                return i7 + 1;
            }

            @Override // j3.s.b
            public int f(int i7) {
                return a.this.f18731a.h(this.f18733n, i7);
            }
        }

        public a(AbstractC1229d abstractC1229d) {
            this.f18731a = abstractC1229d;
        }

        @Override // j3.s.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(s sVar, CharSequence charSequence) {
            return new C0210a(sVar, charSequence);
        }
    }

    public static abstract class b extends AbstractC1227b {

        /* renamed from: n, reason: collision with root package name */
        public final CharSequence f18733n;

        /* renamed from: o, reason: collision with root package name */
        public final AbstractC1229d f18734o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f18735p;

        /* renamed from: q, reason: collision with root package name */
        public int f18736q = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f18737r;

        public b(s sVar, CharSequence charSequence) {
            this.f18734o = sVar.f18727a;
            this.f18735p = sVar.f18728b;
            this.f18737r = sVar.f18730d;
            this.f18733n = charSequence;
        }

        @Override // j3.AbstractC1227b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iF;
            int i7 = this.f18736q;
            while (true) {
                int i8 = this.f18736q;
                if (i8 == -1) {
                    return (String) b();
                }
                iF = f(i8);
                if (iF == -1) {
                    iF = this.f18733n.length();
                    this.f18736q = -1;
                } else {
                    this.f18736q = e(iF);
                }
                int i9 = this.f18736q;
                if (i9 == i7) {
                    int i10 = i9 + 1;
                    this.f18736q = i10;
                    if (i10 > this.f18733n.length()) {
                        this.f18736q = -1;
                    }
                } else {
                    while (i7 < iF && this.f18734o.m(this.f18733n.charAt(i7))) {
                        i7++;
                    }
                    while (iF > i7 && this.f18734o.m(this.f18733n.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.f18735p || i7 != iF) {
                        break;
                    }
                    i7 = this.f18736q;
                }
            }
            int i11 = this.f18737r;
            if (i11 == 1) {
                iF = this.f18733n.length();
                this.f18736q = -1;
                while (iF > i7 && this.f18734o.m(this.f18733n.charAt(iF - 1))) {
                    iF--;
                }
            } else {
                this.f18737r = i11 - 1;
            }
            return this.f18733n.subSequence(i7, iF).toString();
        }

        public abstract int e(int i7);

        public abstract int f(int i7);
    }

    public interface c {
        Iterator a(s sVar, CharSequence charSequence);
    }

    public s(c cVar) {
        this(cVar, false, AbstractC1229d.q(), Integer.MAX_VALUE);
    }

    public static s d(char c7) {
        return e(AbstractC1229d.i(c7));
    }

    public static s e(AbstractC1229d abstractC1229d) {
        o.q(abstractC1229d);
        return new s(new a(abstractC1229d));
    }

    public List f(CharSequence charSequence) {
        o.q(charSequence);
        Iterator itG = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itG.hasNext()) {
            arrayList.add((String) itG.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator g(CharSequence charSequence) {
        return this.f18729c.a(this, charSequence);
    }

    public s(c cVar, boolean z7, AbstractC1229d abstractC1229d, int i7) {
        this.f18729c = cVar;
        this.f18728b = z7;
        this.f18727a = abstractC1229d;
        this.f18730d = i7;
    }
}
