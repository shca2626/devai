package X2;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class a {
    public static Drawable a(Drawable drawable, Drawable drawable2) {
        int intrinsicHeight;
        int intrinsicWidth;
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        if (drawable2.getIntrinsicWidth() == -1 || drawable2.getIntrinsicHeight() == -1) {
            int intrinsicWidth2 = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
            intrinsicWidth = intrinsicWidth2;
        } else if (drawable2.getIntrinsicWidth() > drawable.getIntrinsicWidth() || drawable2.getIntrinsicHeight() > drawable.getIntrinsicHeight()) {
            float intrinsicWidth3 = drawable2.getIntrinsicWidth() / drawable2.getIntrinsicHeight();
            if (intrinsicWidth3 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                intrinsicWidth = drawable.getIntrinsicWidth();
                intrinsicHeight = (int) (intrinsicWidth / intrinsicWidth3);
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
                intrinsicWidth = (int) (intrinsicWidth3 * intrinsicHeight);
            }
        } else {
            intrinsicWidth = drawable2.getIntrinsicWidth();
            intrinsicHeight = drawable2.getIntrinsicHeight();
        }
        layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    public static Drawable b(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        return c(drawable, colorStateList, mode, false);
    }

    public static Drawable c(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode, boolean z7) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (z7) {
                drawable.mutate();
            }
            return drawable;
        }
        Drawable drawableMutate = P.a.r(drawable).mutate();
        if (mode != null) {
            P.a.p(drawableMutate, mode);
        }
        return drawableMutate;
    }

    public static int[] d(int[] iArr) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            if (i8 == 16842912) {
                return iArr;
            }
            if (i8 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i7] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    public static PorterDuffColorFilter e(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
