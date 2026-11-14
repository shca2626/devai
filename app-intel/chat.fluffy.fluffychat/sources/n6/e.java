package n6;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class e extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public IOException f20212l;

    /* renamed from: m, reason: collision with root package name */
    public IOException f20213m;

    public e(IOException iOException) {
        super(iOException);
        this.f20212l = iOException;
        this.f20213m = iOException;
    }

    public void a(IOException iOException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        l6.c.a(this.f20212l, iOException);
        this.f20213m = iOException;
    }

    public IOException b() {
        return this.f20212l;
    }

    public IOException c() {
        return this.f20213m;
    }
}
