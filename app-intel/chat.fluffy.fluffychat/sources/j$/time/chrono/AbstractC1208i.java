package j$.time.chrono;

/* renamed from: j$.time.chrono.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1208i {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18228a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f18228a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18228a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
