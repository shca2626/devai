package N;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Shader f5741a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f5742b;

    /* renamed from: c, reason: collision with root package name */
    public int f5743c;

    public d(Shader shader, ColorStateList colorStateList, int i7) {
        this.f5741a = shader;
        this.f5742b = colorStateList;
        this.f5743c = i7;
    }

    public static d a(Resources resources, int i7, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i7);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static d b(int i7) {
        return new d(null, null, i7);
    }

    public static d c(ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static d d(Shader shader) {
        return new d(shader, null, 0);
    }

    public static d g(Resources resources, int i7, Resources.Theme theme) {
        try {
            return a(resources, i7, theme);
        } catch (Exception e7) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e7);
            return null;
        }
    }

    public int e() {
        return this.f5743c;
    }

    public Shader f() {
        return this.f5741a;
    }

    public boolean h() {
        return this.f5741a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f5741a == null && (colorStateList = this.f5742b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (!i()) {
            return false;
        }
        ColorStateList colorStateList = this.f5742b;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState == this.f5743c) {
            return false;
        }
        this.f5743c = colorForState;
        return true;
    }

    public void k(int i7) {
        this.f5743c = i7;
    }

    public boolean l() {
        return h() || this.f5743c != 0;
    }
}
