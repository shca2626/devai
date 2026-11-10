package I0;

/* loaded from: classes.dex */
public final class Z0 extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final int f3909l;

    public Z0(int i7) {
        super(a(i7));
        this.f3909l = i7;
    }

    public static String a(int i7) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
