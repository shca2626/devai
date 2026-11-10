package z;

import M5.g;
import M5.m;
import java.util.LinkedHashMap;
import java.util.Set;

/* renamed from: z.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1828c {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f24027a;

    public C1828c() {
        this(0, 0.0f, 3, null);
    }

    public final Object a(Object obj) {
        m.e(obj, "key");
        return this.f24027a.get(obj);
    }

    public final Set b() {
        Set setEntrySet = this.f24027a.entrySet();
        m.d(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean c() {
        return this.f24027a.isEmpty();
    }

    public final Object d(Object obj, Object obj2) {
        m.e(obj, "key");
        m.e(obj2, "value");
        return this.f24027a.put(obj, obj2);
    }

    public final Object e(Object obj) {
        m.e(obj, "key");
        return this.f24027a.remove(obj);
    }

    public C1828c(int i7, float f7) {
        this.f24027a = new LinkedHashMap(i7, f7, true);
    }

    public /* synthetic */ C1828c(int i7, float f7, int i8, g gVar) {
        this((i8 & 1) != 0 ? 16 : i7, (i8 & 2) != 0 ? 0.75f : f7);
    }
}
