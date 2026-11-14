package N;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import com.fasterxml.jackson.core.JsonLocation;
import d.AbstractC0951F;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class e {

    public interface a {
    }

    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final c[] f5744a;

        public b(c[] cVarArr) {
            this.f5744a = cVarArr;
        }

        public c[] a() {
            return this.f5744a;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f5745a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5746b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5747c;

        /* renamed from: d, reason: collision with root package name */
        public final String f5748d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5749e;

        /* renamed from: f, reason: collision with root package name */
        public final int f5750f;

        public c(String str, int i7, boolean z7, String str2, int i8, int i9) {
            this.f5745a = str;
            this.f5746b = i7;
            this.f5747c = z7;
            this.f5748d = str2;
            this.f5749e = i8;
            this.f5750f = i9;
        }

        public String a() {
            return this.f5745a;
        }

        public int b() {
            return this.f5750f;
        }

        public int c() {
            return this.f5749e;
        }

        public String d() {
            return this.f5748d;
        }

        public int e() {
            return this.f5746b;
        }

        public boolean f() {
            return this.f5747c;
        }
    }

    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        public final List f5751a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5752b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5753c;

        /* renamed from: d, reason: collision with root package name */
        public final String f5754d;

        public d(List list, int i7, int i8, String str) {
            this.f5751a = list;
            this.f5753c = i7;
            this.f5752b = i8;
            this.f5754d = str;
        }

        public int a() {
            return this.f5753c;
        }

        public List b() {
            return this.f5751a;
        }

        public String c() {
            return this.f5754d;
        }

        public int d() {
            return this.f5752b;
        }
    }

    public static int a(TypedArray typedArray, int i7) {
        return typedArray.getType(i7);
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return e(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i7) throws Resources.NotFoundException {
        if (i7 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i7);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i8 = 0; i8 < typedArrayObtainTypedArray.length(); i8++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i8, 0);
                    if (resourceId != 0) {
                        arrayList.add(i(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(i(resources.getStringArray(i7)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static W.e d(XmlPullParser xmlPullParser, Resources resources, String str, String str2, List list) throws Exception {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), J.g.f4356B);
        try {
            String string = typedArrayObtainAttributes.getString(J.g.f4357C);
            String string2 = typedArrayObtainAttributes.getString(J.g.f4358D);
            String string3 = typedArrayObtainAttributes.getString(J.g.f4359E);
            if (string == null) {
                throw new XmlPullParserException("query attribute must be set in fallback element");
            }
            while (xmlPullParser.next() != 3) {
                h(xmlPullParser);
            }
            W.e eVar = new W.e(str, str2, string, list, string2, string3);
            AbstractC0951F.a(typedArrayObtainAttributes);
            return eVar;
        } catch (Throwable th) {
            if (typedArrayObtainAttributes == null) {
                throw th;
            }
            try {
                AbstractC0951F.a(typedArrayObtainAttributes);
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return f(xmlPullParser, resources);
        }
        h(xmlPullParser);
        return null;
    }

    public static a f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), J.g.f4383h);
        String string = typedArrayObtainAttributes.getString(J.g.f4384i);
        String string2 = typedArrayObtainAttributes.getString(J.g.f4389n);
        String string3 = typedArrayObtainAttributes.getString(J.g.f4390o);
        String string4 = typedArrayObtainAttributes.getString(J.g.f4386k);
        int resourceId = typedArrayObtainAttributes.getResourceId(J.g.f4385j, 0);
        int integer = typedArrayObtainAttributes.getInteger(J.g.f4387l, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(J.g.f4388m, JsonLocation.MAX_CONTENT_SNIPPET);
        String string5 = typedArrayObtainAttributes.getString(J.g.f4391p);
        typedArrayObtainAttributes.recycle();
        if (string == null || string2 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(g(xmlPullParser, resources));
                    } else {
                        h(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((c[]) arrayList.toArray(new c[0]));
        }
        List listC = c(resources, resourceId);
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("fallback")) {
                    arrayList2.add(d(xmlPullParser, resources, string, string2, listC));
                } else {
                    h(xmlPullParser);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            return new d(arrayList2, integer, integer2, string5);
        }
        if (string3 == null) {
            throw new IllegalArgumentException("The provider font XML requires query attribute or fallback children.");
        }
        arrayList2.add(new W.e(string, string2, string3, listC, null, null));
        if (string4 != null) {
            arrayList2.add(new W.e(string, string2, string4, listC, null, null));
        }
        return new d(arrayList2, integer, integer2, string5);
    }

    public static c g(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), J.g.f4392q);
        int i7 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(J.g.f4401z) ? J.g.f4401z : J.g.f4394s, 400);
        boolean z7 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(J.g.f4399x) ? J.g.f4399x : J.g.f4395t, 0);
        int i8 = typedArrayObtainAttributes.hasValue(J.g.f4355A) ? J.g.f4355A : J.g.f4396u;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(J.g.f4400y) ? J.g.f4400y : J.g.f4397v);
        int i9 = typedArrayObtainAttributes.getInt(i8, 0);
        int i10 = typedArrayObtainAttributes.hasValue(J.g.f4398w) ? J.g.f4398w : J.g.f4393r;
        int resourceId = typedArrayObtainAttributes.getResourceId(i10, 0);
        String string2 = typedArrayObtainAttributes.getString(i10);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            h(xmlPullParser);
        }
        return new c(string2, i7, z7, string, i9, resourceId);
    }

    public static void h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i7 = 1;
        while (i7 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i7++;
            } else if (next == 3) {
                i7--;
            }
        }
    }

    public static List i(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
