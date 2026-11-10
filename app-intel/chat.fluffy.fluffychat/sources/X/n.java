package X;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final m f9210a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final m f9211b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final m f9212c;

    /* renamed from: d, reason: collision with root package name */
    public static final m f9213d;

    /* renamed from: e, reason: collision with root package name */
    public static final m f9214e;

    /* renamed from: f, reason: collision with root package name */
    public static final m f9215f;

    public static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f9216b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f9217a;

        public a(boolean z7) {
            this.f9217a = z7;
        }

        @Override // X.n.c
        public int a(CharSequence charSequence, int i7, int i8) {
            int i9 = i8 + i7;
            boolean z7 = false;
            while (i7 < i9) {
                int iA = n.a(Character.getDirectionality(charSequence.charAt(i7)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i7++;
                        z7 = z7;
                    } else if (!this.f9217a) {
                        return 1;
                    }
                } else if (this.f9217a) {
                    return 0;
                }
                z7 = true;
                i7++;
                z7 = z7;
            }
            if (z7) {
                return this.f9217a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f9218a = new b();

        @Override // X.n.c
        public int a(CharSequence charSequence, int i7, int i8) {
            int i9 = i8 + i7;
            int iB = 2;
            while (i7 < i9 && iB == 2) {
                iB = n.b(Character.getDirectionality(charSequence.charAt(i7)));
                i7++;
            }
            return iB;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i7, int i8);
    }

    public static abstract class d implements m {

        /* renamed from: a, reason: collision with root package name */
        public final c f9219a;

        public d(c cVar) {
            this.f9219a = cVar;
        }

        public abstract boolean a();

        public final boolean b(CharSequence charSequence, int i7, int i8) {
            int iA = this.f9219a.a(charSequence, i7, i8);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }

        @Override // X.m
        public boolean isRtl(CharSequence charSequence, int i7, int i8) {
            if (charSequence == null || i7 < 0 || i8 < 0 || charSequence.length() - i8 < i7) {
                throw new IllegalArgumentException();
            }
            return this.f9219a == null ? a() : b(charSequence, i7, i8);
        }
    }

    public static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9220b;

        public e(c cVar, boolean z7) {
            super(cVar);
            this.f9220b = z7;
        }

        @Override // X.n.d
        public boolean a() {
            return this.f9220b;
        }
    }

    public static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        public static final f f9221b = new f();

        public f() {
            super(null);
        }

        @Override // X.n.d
        public boolean a() {
            return o.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f9218a;
        f9212c = new e(bVar, false);
        f9213d = new e(bVar, true);
        f9214e = new e(a.f9216b, false);
        f9215f = f.f9221b;
    }

    public static int a(int i7) {
        if (i7 != 0) {
            return (i7 == 1 || i7 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i7) {
        if (i7 != 0) {
            if (i7 == 1 || i7 == 2) {
                return 0;
            }
            switch (i7) {
                case StdKeyDeserializer.TYPE_URL /* 14 */:
                case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                    break;
                case 16:
                case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
