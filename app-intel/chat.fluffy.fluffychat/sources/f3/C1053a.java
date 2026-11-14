package f3;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1053a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f15716a;

    public C1053a(float f7) {
        this.f15716a = f7;
    }

    @Override // f3.c
    public float a(RectF rectF) {
        return this.f15716a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1053a) && this.f15716a == ((C1053a) obj).f15716a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f15716a)});
    }
}
