package f3;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f15770a;

    public i(float f7) {
        this.f15770a = f7;
    }

    @Override // f3.c
    public float a(RectF rectF) {
        return this.f15770a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f15770a == ((i) obj).f15770a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f15770a)});
    }
}
