package v4;

import M5.g;
import M5.m;
import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: v4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1684a {

    /* renamed from: m, reason: collision with root package name */
    public static final C0279a f23004m;

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1684a f23005n = new EnumC1684a("AacLc", 0, "aacLc");

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1684a f23006o = new EnumC1684a("AacEld", 1, "aacEld");

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC1684a f23007p = new EnumC1684a("AacHe", 2, "aacHe");

    /* renamed from: q, reason: collision with root package name */
    public static final EnumC1684a f23008q = new EnumC1684a("AmrNb", 3, "amrNb");

    /* renamed from: r, reason: collision with root package name */
    public static final EnumC1684a f23009r = new EnumC1684a("AmrWb", 4, "amrWb");

    /* renamed from: s, reason: collision with root package name */
    public static final EnumC1684a f23010s = new EnumC1684a("Flac", 5, "flac");

    /* renamed from: t, reason: collision with root package name */
    public static final EnumC1684a f23011t = new EnumC1684a("Pcm16bits", 6, "pcm16bits");

    /* renamed from: u, reason: collision with root package name */
    public static final EnumC1684a f23012u = new EnumC1684a("Opus", 7, "opus");

    /* renamed from: v, reason: collision with root package name */
    public static final EnumC1684a f23013v = new EnumC1684a("Wav", 8, "wav");

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ EnumC1684a[] f23014w;

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ F5.a f23015x;

    /* renamed from: l, reason: collision with root package name */
    public final String f23016l;

    /* renamed from: v4.a$a, reason: collision with other inner class name */
    public static final class C0279a {
        public /* synthetic */ C0279a(g gVar) {
            this();
        }

        public final EnumC1684a a(String str) {
            Object next;
            m.e(str, "value");
            Iterator<E> it = EnumC1684a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (m.a(((EnumC1684a) next).e(), str)) {
                    break;
                }
            }
            EnumC1684a enumC1684a = (EnumC1684a) next;
            return enumC1684a == null ? EnumC1684a.f23005n : enumC1684a;
        }

        public C0279a() {
        }
    }

    static {
        EnumC1684a[] enumC1684aArrA = a();
        f23014w = enumC1684aArrA;
        f23015x = F5.b.a(enumC1684aArrA);
        f23004m = new C0279a(null);
    }

    public EnumC1684a(String str, int i7, String str2) {
        this.f23016l = str2;
    }

    public static final /* synthetic */ EnumC1684a[] a() {
        return new EnumC1684a[]{f23005n, f23006o, f23007p, f23008q, f23009r, f23010s, f23011t, f23012u, f23013v};
    }

    public static F5.a d() {
        return f23015x;
    }

    public static EnumC1684a valueOf(String str) {
        return (EnumC1684a) Enum.valueOf(EnumC1684a.class, str);
    }

    public static EnumC1684a[] values() {
        return (EnumC1684a[]) f23014w.clone();
    }

    public final String e() {
        return this.f23016l;
    }
}
