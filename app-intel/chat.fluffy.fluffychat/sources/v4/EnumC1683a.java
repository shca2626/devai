package v4;

import M5.g;
import M5.m;
import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: v4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1683a {

    /* renamed from: m, reason: collision with root package name */
    public static final C0279a f23010m;

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1683a f23011n = new EnumC1683a("AacLc", 0, "aacLc");

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1683a f23012o = new EnumC1683a("AacEld", 1, "aacEld");

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC1683a f23013p = new EnumC1683a("AacHe", 2, "aacHe");

    /* renamed from: q, reason: collision with root package name */
    public static final EnumC1683a f23014q = new EnumC1683a("AmrNb", 3, "amrNb");

    /* renamed from: r, reason: collision with root package name */
    public static final EnumC1683a f23015r = new EnumC1683a("AmrWb", 4, "amrWb");

    /* renamed from: s, reason: collision with root package name */
    public static final EnumC1683a f23016s = new EnumC1683a("Flac", 5, "flac");

    /* renamed from: t, reason: collision with root package name */
    public static final EnumC1683a f23017t = new EnumC1683a("Pcm16bits", 6, "pcm16bits");

    /* renamed from: u, reason: collision with root package name */
    public static final EnumC1683a f23018u = new EnumC1683a("Opus", 7, "opus");

    /* renamed from: v, reason: collision with root package name */
    public static final EnumC1683a f23019v = new EnumC1683a("Wav", 8, "wav");

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ EnumC1683a[] f23020w;

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ F5.a f23021x;

    /* renamed from: l, reason: collision with root package name */
    public final String f23022l;

    /* renamed from: v4.a$a, reason: collision with other inner class name */
    public static final class C0279a {
        public /* synthetic */ C0279a(g gVar) {
            this();
        }

        public final EnumC1683a a(String str) {
            Object next;
            m.e(str, "value");
            Iterator<E> it = EnumC1683a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (m.a(((EnumC1683a) next).e(), str)) {
                    break;
                }
            }
            EnumC1683a enumC1683a = (EnumC1683a) next;
            return enumC1683a == null ? EnumC1683a.f23011n : enumC1683a;
        }

        public C0279a() {
        }
    }

    static {
        EnumC1683a[] enumC1683aArrA = a();
        f23020w = enumC1683aArrA;
        f23021x = F5.b.a(enumC1683aArrA);
        f23010m = new C0279a(null);
    }

    public EnumC1683a(String str, int i7, String str2) {
        this.f23022l = str2;
    }

    public static final /* synthetic */ EnumC1683a[] a() {
        return new EnumC1683a[]{f23011n, f23012o, f23013p, f23014q, f23015r, f23016s, f23017t, f23018u, f23019v};
    }

    public static F5.a d() {
        return f23021x;
    }

    public static EnumC1683a valueOf(String str) {
        return (EnumC1683a) Enum.valueOf(EnumC1683a.class, str);
    }

    public static EnumC1683a[] values() {
        return (EnumC1683a[]) f23020w.clone();
    }

    public final String e() {
        return this.f23022l;
    }
}
