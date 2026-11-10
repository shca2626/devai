package j3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1230d f18728a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18729b;

    /* renamed from: c, reason: collision with root package name */
    public final c f18730c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18731d;

    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1230d f18732a;

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
                return a.this.f18732a.h(this.f18734n, i7);
            }
        }

        public a(AbstractC1230d abstractC1230d) {
            this.f18732a = abstractC1230d;
        }

        @Override // j3.s.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(s sVar, CharSequence charSequence) {
            return new C0210a(sVar, charSequence);
        }
    }

    public static abstract class b extends AbstractC1228b {

        /* renamed from: n, reason: collision with root package name */
        public final CharSequence f18734n;

        /* renamed from: o, reason: collision with root package name */
        public final AbstractC1230d f18735o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f18736p;

        /* renamed from: q, reason: collision with root package name */
        public int f18737q = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f18738r;

        public b(s sVar, CharSequence charSequence) {
            this.f18735o = sVar.f18728a;
            this.f18736p = sVar.f18729b;
            this.f18738r = sVar.f18731d;
            this.f18734n = charSequence;
        }

        @Override // j3.AbstractC1228b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iF;
            int i7 = this.f18737q;
            while (true) {
                int i8 = this.f18737q;
                if (i8 == -1) {
                    return (String) b();
                }
                iF = f(i8);
                if (iF == -1) {
                    iF = this.f18734n.length();
                    this.f18737q = -1;
                } else {
                    this.f18737q = e(iF);
                }
                int i9 = this.f18737q;
                if (i9 == i7) {
                    int i10 = i9 + 1;
                    this.f18737q = i10;
                    if (i10 > this.f18734n.length()) {
                        this.f18737q = -1;
                    }
                } else {
                    while (i7 < iF && this.f18735o.m(this.f18734n.charAt(i7))) {
                        i7++;
                    }
                    while (iF > i7 && this.f18735o.m(this.f18734n.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.f18736p || i7 != iF) {
                        break;
                    }
                    i7 = this.f18737q;
                }
            }
            int i11 = this.f18738r;
            if (i11 == 1) {
                iF = this.f18734n.length();
                this.f18737q = -1;
                while (iF > i7 && this.f18735o.m(this.f18734n.charAt(iF - 1))) {
                    iF--;
                }
            } else {
                this.f18738r = i11 - 1;
            }
            return this.f18734n.subSequence(i7, iF).toString();
        }

        public abstract int e(int i7);

        public abstract int f(int i7);
    }

    public interface c {
        Iterator a(s sVar, CharSequence charSequence);
    }

    public s(c cVar) {
        this(cVar, false, AbstractC1230d.q(), Integer.MAX_VALUE);
    }

    public static s d(char c7) {
        return e(AbstractC1230d.i(c7));
    }

    public static s e(AbstractC1230d abstractC1230d) {
        o.q(abstractC1230d);
        return new s(new a(abstractC1230d));
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
        return this.f18730c.a(this, charSequence);
    }

    public s(c cVar, boolean z7, AbstractC1230d abstractC1230d, int i7) {
        this.f18730c = cVar;
        this.f18729b = z7;
        this.f18728a = abstractC1230d;
        this.f18731d = i7;
    }
}
