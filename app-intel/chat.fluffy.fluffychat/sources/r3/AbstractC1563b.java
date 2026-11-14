package r3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* renamed from: r3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1563b {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f22161a = Logger.getLogger(AbstractC1563b.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f22162b = new AtomicBoolean(false);

    public static boolean a() {
        return AbstractC1562a.a() || f22162b.get();
    }
}
