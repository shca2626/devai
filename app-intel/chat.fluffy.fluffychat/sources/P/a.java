package P;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static void c(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int d(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter e(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static int f(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z7) {
        drawable.setAutoMirrored(z7);
    }

    public static void k(Drawable drawable, float f7, float f8) {
        drawable.setHotspot(f7, f8);
    }

    public static void l(Drawable drawable, int i7, int i8, int i9, int i10) {
        drawable.setHotspotBounds(i7, i8, i9, i10);
    }

    public static boolean m(Drawable drawable, int i7) {
        return drawable.setLayoutDirection(i7);
    }

    public static void n(Drawable drawable, int i7) {
        drawable.setTint(i7);
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable q(Drawable drawable) {
        return drawable;
    }

    public static Drawable r(Drawable drawable) {
        return drawable;
    }
}
