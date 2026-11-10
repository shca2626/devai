package l4;

import android.graphics.Rect;
import java.util.List;
import k4.s;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public s f19656a;

    /* renamed from: b, reason: collision with root package name */
    public int f19657b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19658c = false;

    /* renamed from: d, reason: collision with root package name */
    public q f19659d = new n();

    public m(int i7, s sVar) {
        this.f19657b = i7;
        this.f19656a = sVar;
    }

    public s a(List list, boolean z7) {
        return this.f19659d.b(list, b(z7));
    }

    public s b(boolean z7) {
        s sVar = this.f19656a;
        if (sVar == null) {
            return null;
        }
        return z7 ? sVar.d() : sVar;
    }

    public int c() {
        return this.f19657b;
    }

    public Rect d(s sVar) {
        return this.f19659d.d(sVar, this.f19656a);
    }

    public void e(q qVar) {
        this.f19659d = qVar;
    }
}
