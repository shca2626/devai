package u3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: u3.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class EnumC1662r {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1662r f22859l = new a("DEFAULT", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1662r f22860m = new EnumC1662r("STRING", 1) { // from class: u3.r.b
        {
            a aVar = null;
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ EnumC1662r[] f22861n = a();

    /* renamed from: u3.r$a */
    public enum a extends EnumC1662r {
        public a(String str, int i7) {
            super(str, i7, null);
        }
    }

    public EnumC1662r(String str, int i7) {
    }

    public static /* synthetic */ EnumC1662r[] a() {
        return new EnumC1662r[]{f22859l, f22860m};
    }

    public static EnumC1662r valueOf(String str) {
        return (EnumC1662r) Enum.valueOf(EnumC1662r.class, str);
    }

    public static EnumC1662r[] values() {
        return (EnumC1662r[]) f22861n.clone();
    }

    public /* synthetic */ EnumC1662r(String str, int i7, a aVar) {
        this(str, i7);
    }
}
