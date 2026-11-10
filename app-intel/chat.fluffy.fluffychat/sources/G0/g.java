package G0;

import java.io.IOException;

/* loaded from: classes.dex */
public class g extends IOException {

    /* renamed from: l, reason: collision with root package name */
    public final int f3136l;

    public g(int i7) {
        this.f3136l = i7;
    }

    public g(Throwable th, int i7) {
        super(th);
        this.f3136l = i7;
    }

    public g(String str, int i7) {
        super(str);
        this.f3136l = i7;
    }

    public g(String str, Throwable th, int i7) {
        super(str, th);
        this.f3136l = i7;
    }
}
