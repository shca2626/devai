package q;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21318a;

    /* renamed from: b, reason: collision with root package name */
    public final View f21319b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f21320c;

    /* renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f21321d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f21322e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f21323f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f21324g;

    public l0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f21321d = layoutParams;
        this.f21322e = new Rect();
        this.f21323f = new int[2];
        this.f21324g = new int[2];
        this.f21318a = context;
        View viewInflate = LayoutInflater.from(context).inflate(i.g.f17083s, (ViewGroup) null);
        this.f21319b = viewInflate;
        this.f21320c = (TextView) viewInflate.findViewById(i.f.f17057s);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.i.f17099a;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 2) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return ((Activity) context).getWindow().getDecorView();
                }
            }
        }
        return rootView;
    }

    public final void a(View view, int i7, int i8, boolean z7, WindowManager.LayoutParams layoutParams) throws Resources.NotFoundException {
        int height;
        int i9;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f21318a.getResources().getDimensionPixelOffset(i.d.f16975k);
        if (view.getWidth() < dimensionPixelOffset) {
            i7 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f21318a.getResources().getDimensionPixelOffset(i.d.f16974j);
            height = i8 + dimensionPixelOffset2;
            i9 = i8 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i9 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f21318a.getResources().getDimensionPixelOffset(z7 ? i.d.f16977m : i.d.f16976l);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f21322e);
        Rect rect = this.f21322e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f21318a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f21322e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f21324g);
        view.getLocationOnScreen(this.f21323f);
        int[] iArr = this.f21323f;
        int i10 = iArr[0];
        int[] iArr2 = this.f21324g;
        int i11 = i10 - iArr2[0];
        iArr[0] = i11;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i11 + i7) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f21319b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f21319b.getMeasuredHeight();
        int i12 = this.f21323f[1];
        int i13 = ((i9 + i12) - dimensionPixelOffset3) - measuredHeight;
        int i14 = i12 + height + dimensionPixelOffset3;
        if (z7) {
            if (i13 >= 0) {
                layoutParams.y = i13;
                return;
            } else {
                layoutParams.y = i14;
                return;
            }
        }
        if (measuredHeight + i14 <= this.f21322e.height()) {
            layoutParams.y = i14;
        } else {
            layoutParams.y = i13;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f21318a.getSystemService("window")).removeView(this.f21319b);
        }
    }

    public boolean d() {
        return this.f21319b.getParent() != null;
    }

    public void e(View view, int i7, int i8, boolean z7, CharSequence charSequence) throws Resources.NotFoundException {
        if (d()) {
            c();
        }
        this.f21320c.setText(charSequence);
        a(view, i7, i8, z7, this.f21321d);
        ((WindowManager) this.f21318a.getSystemService("window")).addView(this.f21319b, this.f21321d);
    }
}
