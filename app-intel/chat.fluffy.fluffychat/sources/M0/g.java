package M0;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f5569a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5570b;

    /* renamed from: c, reason: collision with root package name */
    public final List f5571c;

    /* renamed from: d, reason: collision with root package name */
    public final List f5572d;

    /* renamed from: e, reason: collision with root package name */
    public final e f5573e;

    public g(String str, long j7, List list, List list2) {
        this(str, j7, list, list2, null);
    }

    public int a(int i7) {
        int size = this.f5571c.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((a) this.f5571c.get(i8)).f5524b == i7) {
                return i8;
            }
        }
        return -1;
    }

    public g(String str, long j7, List list, List list2, e eVar) {
        this.f5569a = str;
        this.f5570b = j7;
        this.f5571c = Collections.unmodifiableList(list);
        this.f5572d = Collections.unmodifiableList(list2);
        this.f5573e = eVar;
    }
}
