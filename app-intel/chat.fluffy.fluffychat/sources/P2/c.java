package P2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import y.C1797k;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final C1797k f7547a = new C1797k();

    /* renamed from: b, reason: collision with root package name */
    public final C1797k f7548b = new C1797k();

    public static void a(c cVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            cVar.e(objectAnimator.getPropertyName(), objectAnimator.getValues());
            cVar.f(objectAnimator.getPropertyName(), d.a(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static c b(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        if (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static c c(Context context, int i7) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i7);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return d(arrayList);
        } catch (Exception e7) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i7), e7);
            return null;
        }
    }

    public static c d(List list) {
        c cVar = new c();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            a(cVar, (Animator) list.get(i7));
        }
        return cVar;
    }

    public void e(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f7548b.put(str, propertyValuesHolderArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f7547a.equals(((c) obj).f7547a);
        }
        return false;
    }

    public void f(String str, d dVar) {
        this.f7547a.put(str, dVar);
    }

    public int hashCode() {
        return this.f7547a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f7547a + "}\n";
    }
}
