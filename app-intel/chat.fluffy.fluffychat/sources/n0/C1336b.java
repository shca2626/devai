package n0;

import android.text.Editable;
import l0.C1301j;

/* renamed from: n0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1336b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f19839a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f19840b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f19841c;

    public C1336b() {
        try {
            f19841c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C1336b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f19840b == null) {
            synchronized (f19839a) {
                try {
                    if (f19840b == null) {
                        f19840b = new C1336b();
                    }
                } finally {
                }
            }
        }
        return f19840b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f19841c;
        return cls != null ? C1301j.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
