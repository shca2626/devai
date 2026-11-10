package N;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class f {
    public static a a(a aVar, int i7, int i8, boolean z7, int i9) {
        return aVar != null ? aVar : z7 ? new a(i7, i9, i8) : new a(i7, i8);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayQ = k.q(resources, theme, attributeSet, J.g.f4360F);
        float fJ = k.j(typedArrayQ, xmlPullParser, "startX", J.g.f4369O, 0.0f);
        float fJ2 = k.j(typedArrayQ, xmlPullParser, "startY", J.g.f4370P, 0.0f);
        float fJ3 = k.j(typedArrayQ, xmlPullParser, "endX", J.g.f4371Q, 0.0f);
        float fJ4 = k.j(typedArrayQ, xmlPullParser, "endY", J.g.f4372R, 0.0f);
        float fJ5 = k.j(typedArrayQ, xmlPullParser, "centerX", J.g.f4364J, 0.0f);
        float fJ6 = k.j(typedArrayQ, xmlPullParser, "centerY", J.g.f4365K, 0.0f);
        int iK = k.k(typedArrayQ, xmlPullParser, "type", J.g.f4363I, 0);
        int iF = k.f(typedArrayQ, xmlPullParser, "startColor", J.g.f4361G, 0);
        boolean zP = k.p(xmlPullParser, "centerColor");
        int iF2 = k.f(typedArrayQ, xmlPullParser, "centerColor", J.g.f4368N, 0);
        int iF3 = k.f(typedArrayQ, xmlPullParser, "endColor", J.g.f4362H, 0);
        int iK2 = k.k(typedArrayQ, xmlPullParser, "tileMode", J.g.f4367M, 0);
        float fJ7 = k.j(typedArrayQ, xmlPullParser, "gradientRadius", J.g.f4366L, 0.0f);
        typedArrayQ.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zP, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.f5755a, aVarA.f5756b, d(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.f5755a, aVarA.f5756b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.f5755a, aVarA.f5756b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        return new N.f.a(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static N.f.a c(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L85
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L85
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = J.g.f4373S
            android.content.res.TypedArray r3 = N.k.q(r8, r11, r10, r3)
            int r5 = J.g.f4374T
            boolean r5 = r3.hasValue(r5)
            int r6 = J.g.f4375U
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = J.g.f4374T
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = J.g.f4375U
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            N.f$a r8 = new N.f$a
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: N.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):N.f$a");
    }

    public static Shader.TileMode d(int i7) {
        return i7 != 1 ? i7 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f5755a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f5756b;

        public a(List list, List list2) {
            int size = list.size();
            this.f5755a = new int[size];
            this.f5756b = new float[size];
            for (int i7 = 0; i7 < size; i7++) {
                this.f5755a[i7] = ((Integer) list.get(i7)).intValue();
                this.f5756b[i7] = ((Float) list2.get(i7)).floatValue();
            }
        }

        public a(int i7, int i8) {
            this.f5755a = new int[]{i7, i8};
            this.f5756b = new float[]{0.0f, 1.0f};
        }

        public a(int i7, int i8, int i9) {
            this.f5755a = new int[]{i7, i8, i9};
            this.f5756b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
