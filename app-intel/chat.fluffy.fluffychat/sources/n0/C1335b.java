package n0;

import android.text.Editable;
import l0.C1300j;

/* renamed from: n0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1335b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f19838a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f19839b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f19840c;

    public C1335b() {
        try {
            f19840c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C1335b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f19839b == null) {
            synchronized (f19838a) {
                try {
                    if (f19839b == null) {
                        f19839b = new C1335b();
                    }
                } finally {
                }
            }
        }
        return f19839b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f19840c;
        return cls != null ? C1300j.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
