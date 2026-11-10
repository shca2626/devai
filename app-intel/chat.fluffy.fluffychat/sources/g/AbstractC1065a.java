package g;

import M5.m;
import android.content.Context;
import android.content.Intent;

/* renamed from: g.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1065a {

    /* renamed from: g.a$a, reason: collision with other inner class name */
    public static final class C0168a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f15910a;

        public C0168a(Object obj) {
            this.f15910a = obj;
        }

        public final Object a() {
            return this.f15910a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0168a b(Context context, Object obj) {
        m.e(context, "context");
        return null;
    }

    public abstract Object c(int i7, Intent intent);
}
