package u3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: u3.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class EnumC1661r {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1661r f22865l = new a("DEFAULT", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1661r f22866m = new EnumC1661r("STRING", 1) { // from class: u3.r.b
        {
            a aVar = null;
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC1661r[] f22867n = a();

    /* renamed from: u3.r$a */
    public enum a extends EnumC1661r {
        public a(String str, int i7) {
            super(str, i7, null);
        }
    }

    public EnumC1661r(String str, int i7) {
    }

    public static /* synthetic */ EnumC1661r[] a() {
        return new EnumC1661r[]{f22865l, f22866m};
    }

    public static EnumC1661r valueOf(String str) {
        return (EnumC1661r) Enum.valueOf(EnumC1661r.class, str);
    }

    public static EnumC1661r[] values() {
        return (EnumC1661r[]) f22867n.clone();
    }

    public /* synthetic */ EnumC1661r(String str, int i7, a aVar) {
        this(str, i7);
    }
}
