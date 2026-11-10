package G;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f2794a;

    /* renamed from: b, reason: collision with root package name */
    public int f2795b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f2796c = -1;

    /* renamed from: d, reason: collision with root package name */
    public SparseArray f2797d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    public SparseArray f2798e = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    public G.b f2799f = null;

    /* renamed from: G.a$a, reason: collision with other inner class name */
    public static class C0033a {

        /* renamed from: a, reason: collision with root package name */
        public int f2800a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f2801b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public int f2802c;

        /* renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.c f2803d;

        public C0033a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f2802c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f3062q4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == d.f3068r4) {
                    this.f2800a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2800a);
                } else if (index == d.f3074s4) {
                    this.f2802c = typedArrayObtainStyledAttributes.getResourceId(index, this.f2802c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2802c);
                    context.getResources().getResourceName(this.f2802c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f2803d = cVar;
                        cVar.f(context, this.f2802c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f2801b.add(bVar);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f2804a;

        /* renamed from: b, reason: collision with root package name */
        public float f2805b;

        /* renamed from: c, reason: collision with root package name */
        public float f2806c;

        /* renamed from: d, reason: collision with root package name */
        public float f2807d;

        /* renamed from: e, reason: collision with root package name */
        public int f2808e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.constraintlayout.widget.c f2809f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f2804a = Float.NaN;
            this.f2805b = Float.NaN;
            this.f2806c = Float.NaN;
            this.f2807d = Float.NaN;
            this.f2808e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f2887M4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == d.f2893N4) {
                    this.f2808e = typedArrayObtainStyledAttributes.getResourceId(index, this.f2808e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2808e);
                    context.getResources().getResourceName(this.f2808e);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f2809f = cVar;
                        cVar.f(context, this.f2808e);
                    }
                } else if (index == d.f2899O4) {
                    this.f2807d = typedArrayObtainStyledAttributes.getDimension(index, this.f2807d);
                } else if (index == d.f2905P4) {
                    this.f2805b = typedArrayObtainStyledAttributes.getDimension(index, this.f2805b);
                } else if (index == d.f2911Q4) {
                    this.f2806c = typedArrayObtainStyledAttributes.getDimension(index, this.f2806c);
                } else if (index == d.f2917R4) {
                    this.f2804a = typedArrayObtainStyledAttributes.getDimension(index, this.f2804a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i7) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        this.f2794a = constraintLayout;
        a(context, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r8, int r9) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r1 = 0
        Ld:
            r2 = 1
            if (r0 == r2) goto Lab
            if (r0 == 0) goto L9b
            r3 = 2
            if (r0 == r3) goto L17
            goto L9e
        L17:
            java.lang.String r0 = r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            int r4 = r0.hashCode()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L53;
                case 80204913: goto L49;
                case 1382829617: goto L3f;
                case 1657696882: goto L35;
                case 1901439077: goto L25;
                default: goto L24;
            }     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
        L24:
            goto L5d
        L25:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = r6
            goto L5e
        L2f:
            r8 = move-exception
            goto La4
        L32:
            r8 = move-exception
            goto La8
        L35:
            java.lang.String r4 = "layoutDescription"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = 0
            goto L5e
        L3f:
            java.lang.String r4 = "StateSet"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = r2
            goto L5e
        L49:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = r3
            goto L5e
        L53:
            java.lang.String r4 = "ConstraintSet"
            boolean r4 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r4 == 0) goto L5d
            r4 = r5
            goto L5e
        L5d:
            r4 = -1
        L5e:
            if (r4 == 0) goto L9e
            if (r4 == r2) goto L9e
            if (r4 == r3) goto L8e
            if (r4 == r6) goto L83
            if (r4 == r5) goto L7f
            java.lang.String r2 = "ConstraintLayoutStates"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r3.<init>()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            java.lang.String r4 = "unknown tag "
            r3.append(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r3.append(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            android.util.Log.v(r2, r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L7f:
            r7.b(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L83:
            G.a$b r0 = new G.a$b     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r0.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            if (r1 == 0) goto L9e
            r1.a(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L8e:
            G.a$a r1 = new G.a$a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r1.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            android.util.SparseArray r0 = r7.f2797d     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            int r2 = r1.f2800a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            r0.put(r2, r1)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto L9e
        L9b:
            r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
        L9e:
            int r0 = r9.next()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L32
            goto Ld
        La4:
            r8.printStackTrace()
            goto Lab
        La8:
            r8.printStackTrace()
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G.a.a(android.content.Context, int):void");
    }

    public final void b(Context context, XmlPullParser xmlPullParser) throws NumberFormatException {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i7 = 0; i7 < attributeCount; i7++) {
            if ("id".equals(xmlPullParser.getAttributeName(i7))) {
                String attributeValue = xmlPullParser.getAttributeValue(i7);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.m(context, xmlPullParser);
                this.f2798e.put(identifier, cVar);
                return;
            }
        }
    }

    public void c(G.b bVar) {
        this.f2799f = bVar;
    }
}
