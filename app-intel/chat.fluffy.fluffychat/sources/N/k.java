package N;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class k {
    public static int a(Context context, int i7, int i8) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i7, typedValue, true);
        return typedValue.resourceId != 0 ? i7 : i8;
    }

    public static boolean b(TypedArray typedArray, int i7, int i8, boolean z7) {
        return typedArray.getBoolean(i7, typedArray.getBoolean(i8, z7));
    }

    public static Drawable c(TypedArray typedArray, int i7, int i8) {
        Drawable drawable = typedArray.getDrawable(i7);
        return drawable == null ? typedArray.getDrawable(i8) : drawable;
    }

    public static int d(TypedArray typedArray, int i7, int i8, int i9) {
        return typedArray.getInt(i7, typedArray.getInt(i8, i9));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i7, boolean z7) {
        return !p(xmlPullParser, str) ? z7 : typedArray.getBoolean(i7, z7);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i7, int i8) {
        return !p(xmlPullParser, str) ? i8 : typedArray.getColor(i7, i8);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i7) {
        if (!p(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i7, typedValue);
        int i8 = typedValue.type;
        if (i8 != 2) {
            return (i8 < 28 || i8 > 31) ? c.d(typedArray.getResources(), typedArray.getResourceId(i7, 0), theme) : h(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i7 + ": " + typedValue);
    }

    public static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i7, int i8) {
        if (p(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i7, typedValue);
            int i9 = typedValue.type;
            if (i9 >= 28 && i9 <= 31) {
                return d.b(typedValue.data);
            }
            d dVarG = d.g(typedArray.getResources(), typedArray.getResourceId(i7, 0), theme);
            if (dVarG != null) {
                return dVarG;
            }
        }
        return d.b(i8);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i7, float f7) {
        return !p(xmlPullParser, str) ? f7 : typedArray.getFloat(i7, f7);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i7, int i8) {
        return !p(xmlPullParser, str) ? i8 : typedArray.getInt(i7, i8);
    }

    public static int l(TypedArray typedArray, int i7, int i8, int i9) {
        return typedArray.getResourceId(i7, typedArray.getResourceId(i8, i9));
    }

    public static String m(TypedArray typedArray, int i7, int i8) {
        String string = typedArray.getString(i7);
        return string == null ? typedArray.getString(i8) : string;
    }

    public static CharSequence n(TypedArray typedArray, int i7, int i8) {
        CharSequence text = typedArray.getText(i7);
        return text == null ? typedArray.getText(i8) : text;
    }

    public static CharSequence[] o(TypedArray typedArray, int i7, int i8) {
        CharSequence[] textArray = typedArray.getTextArray(i7);
        return textArray == null ? typedArray.getTextArray(i8) : textArray;
    }

    public static boolean p(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray q(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
