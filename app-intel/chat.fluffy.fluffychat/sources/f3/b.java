package f3;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f15717a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15718b;

    public b(float f7, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f15717a;
            f7 += ((b) cVar).f15718b;
        }
        this.f15717a = cVar;
        this.f15718b = f7;
    }

    @Override // f3.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f15717a.a(rectF) + this.f15718b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f15717a.equals(bVar.f15717a) && this.f15718b == bVar.f15718b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f15717a, Float.valueOf(this.f15718b)});
    }
}
