package q;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* renamed from: q.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1464b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f21241a;

    /* renamed from: q.b$a */
    public static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C1464b(ActionBarContainer actionBarContainer) {
        this.f21241a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f21241a;
        if (actionBarContainer.f11280s) {
            Drawable drawable = actionBarContainer.f11279r;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f11277p;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f21241a;
        Drawable drawable3 = actionBarContainer2.f11278q;
        if (drawable3 == null || !actionBarContainer2.f11281t) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f21241a;
        if (actionBarContainer.f11280s) {
            if (actionBarContainer.f11279r != null) {
                a.a(actionBarContainer.f11277p, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f11277p;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
