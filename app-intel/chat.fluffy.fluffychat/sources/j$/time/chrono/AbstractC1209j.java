package j$.time.chrono;

/* renamed from: j$.time.chrono.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1209j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18229a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f18229a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18229a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
