package l4;

import android.graphics.Rect;
import java.util.List;
import k4.s;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public s f19655a;

    /* renamed from: b, reason: collision with root package name */
    public int f19656b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19657c = false;

    /* renamed from: d, reason: collision with root package name */
    public q f19658d = new n();

    public m(int i7, s sVar) {
        this.f19656b = i7;
        this.f19655a = sVar;
    }

    public s a(List list, boolean z7) {
        return this.f19658d.b(list, b(z7));
    }

    public s b(boolean z7) {
        s sVar = this.f19655a;
        if (sVar == null) {
            return null;
        }
        return z7 ? sVar.d() : sVar;
    }

    public int c() {
        return this.f19656b;
    }

    public Rect d(s sVar) {
        return this.f19658d.d(sVar, this.f19655a);
    }

    public void e(q qVar) {
        this.f19658d = qVar;
    }
}
