package androidx.preference;

import R1.c;
import R1.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: P, reason: collision with root package name */
    public int f12938P;

    /* renamed from: Q, reason: collision with root package name */
    public int f12939Q;

    /* renamed from: R, reason: collision with root package name */
    public int f12940R;

    /* renamed from: S, reason: collision with root package name */
    public int f12941S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f12942T;

    /* renamed from: U, reason: collision with root package name */
    public SeekBar f12943U;

    /* renamed from: V, reason: collision with root package name */
    public TextView f12944V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f12945W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f12946X;

    /* renamed from: Y, reason: collision with root package name */
    public boolean f12947Y;

    /* renamed from: Z, reason: collision with root package name */
    public final SeekBar.OnSeekBarChangeListener f12948Z;

    /* renamed from: a0, reason: collision with root package name */
    public final View.OnKeyListener f12949a0;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i7, boolean z7) {
            if (z7) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f12947Y || !seekBarPreference.f12942T) {
                    seekBarPreference.L(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.M(i7 + seekBarPreference2.f12939Q);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f12942T = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f12942T = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f12939Q != seekBarPreference.f12938P) {
                seekBarPreference.L(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i7, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f12945W && (i7 == 21 || i7 == 22)) || i7 == 23 || i7 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f12943U;
            if (seekBar != null) {
                return seekBar.onKeyDown(i7, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12948Z = new a();
        this.f12949a0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7892C0, i7, i8);
        this.f12939Q = typedArrayObtainStyledAttributes.getInt(g.f7898F0, 0);
        I(typedArrayObtainStyledAttributes.getInt(g.f7894D0, 100));
        J(typedArrayObtainStyledAttributes.getInt(g.f7900G0, 0));
        this.f12945W = typedArrayObtainStyledAttributes.getBoolean(g.f7896E0, true);
        this.f12946X = typedArrayObtainStyledAttributes.getBoolean(g.f7902H0, false);
        this.f12947Y = typedArrayObtainStyledAttributes.getBoolean(g.f7904I0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void I(int i7) {
        int i8 = this.f12939Q;
        if (i7 < i8) {
            i7 = i8;
        }
        if (i7 != this.f12940R) {
            this.f12940R = i7;
            u();
        }
    }

    public final void J(int i7) {
        if (i7 != this.f12941S) {
            this.f12941S = Math.min(this.f12940R - this.f12939Q, Math.abs(i7));
            u();
        }
    }

    public final void K(int i7, boolean z7) {
        int i8 = this.f12939Q;
        if (i7 < i8) {
            i7 = i8;
        }
        int i9 = this.f12940R;
        if (i7 > i9) {
            i7 = i9;
        }
        if (i7 != this.f12938P) {
            this.f12938P = i7;
            M(i7);
            D(i7);
            if (z7) {
                u();
            }
        }
    }

    public void L(SeekBar seekBar) {
        int progress = this.f12939Q + seekBar.getProgress();
        if (progress != this.f12938P) {
            if (a(Integer.valueOf(progress))) {
                K(progress, false);
            } else {
                seekBar.setProgress(this.f12938P - this.f12939Q);
                M(this.f12938P);
            }
        }
    }

    public void M(int i7) {
        TextView textView = this.f12944V;
        if (textView != null) {
            textView.setText(String.valueOf(i7));
        }
    }

    @Override // androidx.preference.Preference
    public Object y(TypedArray typedArray, int i7) {
        return Integer.valueOf(typedArray.getInt(i7, 0));
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f7881h);
    }
}
