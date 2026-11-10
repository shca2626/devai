package V5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e implements Iterator, N5.a {

    /* renamed from: q, reason: collision with root package name */
    public static final a f8868q = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f8869l;

    /* renamed from: m, reason: collision with root package name */
    public int f8870m;

    /* renamed from: n, reason: collision with root package name */
    public int f8871n;

    /* renamed from: o, reason: collision with root package name */
    public int f8872o;

    /* renamed from: p, reason: collision with root package name */
    public int f8873p;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public e(CharSequence charSequence) {
        M5.m.e(charSequence, "string");
        this.f8869l = charSequence;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f8870m = 0;
        int i7 = this.f8872o;
        int i8 = this.f8871n;
        this.f8871n = this.f8873p + i7;
        return this.f8869l.subSequence(i8, i7).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i7;
        int i8;
        int i9 = this.f8870m;
        if (i9 != 0) {
            return i9 == 1;
        }
        if (this.f8873p < 0) {
            this.f8870m = 2;
            return false;
        }
        int length = this.f8869l.length();
        int length2 = this.f8869l.length();
        for (int i10 = this.f8871n; i10 < length2; i10++) {
            char cCharAt = this.f8869l.charAt(i10);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i7 = (cCharAt == '\r' && (i8 = i10 + 1) < this.f8869l.length() && this.f8869l.charAt(i8) == '\n') ? 2 : 1;
                length = i10;
                this.f8870m = 1;
                this.f8873p = i7;
                this.f8872o = length;
                return true;
            }
        }
        i7 = -1;
        this.f8870m = 1;
        this.f8873p = i7;
        this.f8872o = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
