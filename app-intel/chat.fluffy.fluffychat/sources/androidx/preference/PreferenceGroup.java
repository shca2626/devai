package androidx.preference;

import N.k;
import R1.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import y.C1797k;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: P, reason: collision with root package name */
    public final C1797k f12928P;

    /* renamed from: Q, reason: collision with root package name */
    public final Handler f12929Q;

    /* renamed from: R, reason: collision with root package name */
    public final List f12930R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f12931S;

    /* renamed from: T, reason: collision with root package name */
    public int f12932T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f12933U;

    /* renamed from: V, reason: collision with root package name */
    public int f12934V;

    /* renamed from: W, reason: collision with root package name */
    public final Runnable f12935W;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f12928P.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12928P = new C1797k();
        this.f12929Q = new Handler(Looper.getMainLooper());
        this.f12931S = true;
        this.f12932T = 0;
        this.f12933U = false;
        this.f12934V = Integer.MAX_VALUE;
        this.f12935W = new a();
        this.f12930R = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7987v0, i7, i8);
        int i9 = g.f7991x0;
        this.f12931S = k.b(typedArrayObtainStyledAttributes, i9, i9, true);
        if (typedArrayObtainStyledAttributes.hasValue(g.f7989w0)) {
            int i10 = g.f7989w0;
            K(k.d(typedArrayObtainStyledAttributes, i10, i10, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference I(int i7) {
        return (Preference) this.f12930R.get(i7);
    }

    public int J() {
        return this.f12930R.size();
    }

    public void K(int i7) {
        if (i7 != Integer.MAX_VALUE && !r()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f12934V = i7;
    }

    @Override // androidx.preference.Preference
    public void v(boolean z7) {
        super.v(z7);
        int iJ = J();
        for (int i7 = 0; i7 < iJ; i7++) {
            I(i7).z(this, z7);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
