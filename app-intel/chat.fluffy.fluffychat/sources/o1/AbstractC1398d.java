package o1;

import B0.A;
import E0.AbstractC0332s;
import E0.f0;
import java.io.IOException;
import java.io.StringReader;
import k3.AbstractC1279v;
import o1.C1397c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: o1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1398d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f20368a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f20369b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f20370c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : f20368a) {
            if (str.contains(str2 + "=\"1\"")) {
                return true;
            }
        }
        return false;
    }

    public static C1397c b(String str) {
        try {
            return c(str);
        } catch (A | NumberFormatException | XmlPullParserException unused) {
            AbstractC0332s.h("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    public static C1397c c(String str) throws XmlPullParserException, IOException, NumberFormatException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!f0.f(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw A.a("Couldn't find xmp metadata", null);
        }
        AbstractC1279v abstractC1279vV = AbstractC1279v.v();
        long jF = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (f0.f(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!e(xmlPullParserNewPullParser)) {
                    return null;
                }
                jF = f(xmlPullParserNewPullParser);
                abstractC1279vV = d(xmlPullParserNewPullParser);
            } else if (f0.f(xmlPullParserNewPullParser, "Container:Directory")) {
                abstractC1279vV = g(xmlPullParserNewPullParser, "Container", "Item");
            } else if (f0.f(xmlPullParserNewPullParser, "GContainer:Directory")) {
                abstractC1279vV = g(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!f0.d(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (abstractC1279vV.isEmpty()) {
            return null;
        }
        return new C1397c(jF, abstractC1279vV);
    }

    public static AbstractC1279v d(XmlPullParser xmlPullParser) throws NumberFormatException {
        for (String str : f20370c) {
            String strA = f0.a(xmlPullParser, str);
            if (strA != null) {
                return AbstractC1279v.x(new C1397c.a("image/jpeg", "Primary", 0L, 0L), new C1397c.a("video/mp4", "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return AbstractC1279v.v();
    }

    public static boolean e(XmlPullParser xmlPullParser) {
        for (String str : f20368a) {
            String strA = f0.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    public static long f(XmlPullParser xmlPullParser) throws NumberFormatException {
        for (String str : f20369b) {
            String strA = f0.a(xmlPullParser, str);
            if (strA != null) {
                long j7 = Long.parseLong(strA);
                if (j7 == -1) {
                    return -9223372036854775807L;
                }
                return j7;
            }
        }
        return -9223372036854775807L;
    }

    public static AbstractC1279v g(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        AbstractC1279v.a aVarO = AbstractC1279v.o();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (f0.f(xmlPullParser, str3)) {
                String strA = f0.a(xmlPullParser, str2 + ":Mime");
                String strA2 = f0.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = f0.a(xmlPullParser, str2 + ":Length");
                String strA4 = f0.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return AbstractC1279v.v();
                }
                aVarO.a(new C1397c.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!f0.d(xmlPullParser, str4));
        return aVarO.k();
    }
}
