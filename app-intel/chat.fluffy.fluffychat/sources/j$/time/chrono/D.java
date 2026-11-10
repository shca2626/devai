package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class D implements m {
    public static final D BEFORE_ROC;
    public static final D ROC;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ D[] f18209a;

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f18209a.clone();
    }

    static {
        D d7 = new D("BEFORE_ROC", 0);
        BEFORE_ROC = d7;
        D d8 = new D("ROC", 1);
        ROC = d8;
        f18209a = new D[]{d7, d8};
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return ordinal();
    }
}
