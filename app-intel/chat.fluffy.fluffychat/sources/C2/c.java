package C2;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.AbstractC0805j;
import androidx.lifecycle.InterfaceC0809n;
import java.io.IOException;
import k.AbstractC1243a;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class c {
    public static final Drawable a(Context context, int i7) {
        M5.m.e(context, "<this>");
        Drawable drawableB = AbstractC1243a.b(context, i7);
        if (drawableB != null) {
            return drawableB;
        }
        throw new IllegalStateException(M5.m.j("Invalid resource ID: ", Integer.valueOf(i7)).toString());
    }

    public static final Drawable b(Resources resources, int i7, Resources.Theme theme) {
        M5.m.e(resources, "<this>");
        Drawable drawableE = N.h.e(resources, i7, theme);
        if (drawableE != null) {
            return drawableE;
        }
        throw new IllegalStateException(M5.m.j("Invalid resource ID: ", Integer.valueOf(i7)).toString());
    }

    public static final AbstractC0805j c(Context context) {
        Object baseContext = context;
        while (!(baseContext instanceof InterfaceC0809n)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        return ((InterfaceC0809n) baseContext).a();
    }

    public static final Drawable d(Context context, Resources resources, int i7) throws XmlPullParserException, Resources.NotFoundException, IOException {
        M5.m.e(context, "<this>");
        M5.m.e(resources, "resources");
        XmlResourceParser xml = resources.getXml(i7);
        M5.m.d(xml, "resources.getXml(resId)");
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next == 2) {
            return b(resources, i7, context.getTheme());
        }
        throw new XmlPullParserException("No start tag found.");
    }
}
