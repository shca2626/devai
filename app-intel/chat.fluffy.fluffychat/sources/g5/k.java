package g5;

import h5.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16348a;

    /* renamed from: b, reason: collision with root package name */
    public g f16349b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16350c;

    public class a implements j.c {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x00da  */
        @Override // h5.j.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onMethodCall(h5.i r6, h5.j.d r7) throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 756
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: g5.k.a.onMethodCall(h5.i, h5.j$d):void");
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f16352a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16353b;

        public b(int i7, String str) {
            this.f16352a = i7;
            this.f16353b = str;
        }
    }

    public enum c {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");


        /* renamed from: l, reason: collision with root package name */
        public String f16357l;

        c(String str) {
            this.f16357l = str;
        }

        public static c d(String str) throws NoSuchFieldException {
            for (c cVar : values()) {
                if (cVar.f16357l.equals(str)) {
                    return cVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum d {
        PLAIN_TEXT("text/plain");


        /* renamed from: l, reason: collision with root package name */
        public String f16360l;

        d(String str) {
            this.f16360l = str;
        }

        public static d d(String str) throws NoSuchFieldException {
            for (d dVar : values()) {
                if (dVar.f16360l.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum e {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");


        /* renamed from: l, reason: collision with root package name */
        public String f16366l;

        e(String str) {
            this.f16366l = str;
        }

        public static e d(String str) throws NoSuchFieldException {
            for (e eVar : values()) {
                if (eVar.f16366l.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum f {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick"),
        SUCCESS_NOTIFICATION("HapticFeedbackType.successNotification"),
        WARNING_NOTIFICATION("HapticFeedbackType.warningNotification"),
        ERROR_NOTIFICATION("HapticFeedbackType.errorNotification");


        /* renamed from: l, reason: collision with root package name */
        public final String f16376l;

        f(String str) {
            this.f16376l = str;
        }

        public static f d(String str) throws NoSuchFieldException {
            for (f fVar : values()) {
                String str2 = fVar.f16376l;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface g {
        void b();

        void g(boolean z7);

        void h(j jVar);

        void i(h hVar);

        void j(List list);

        void k(i iVar);

        void l(b bVar);

        CharSequence m(d dVar);

        void n(String str);

        void o(String str);

        void p(f fVar);

        void q();

        void r();

        void s(int i7);

        boolean t();
    }

    public enum h {
        CLICK("SystemSoundType.click"),
        TICK("SystemSoundType.tick"),
        ALERT("SystemSoundType.alert");


        /* renamed from: l, reason: collision with root package name */
        public final String f16381l;

        h(String str) {
            this.f16381l = str;
        }

        public static h d(String str) throws NoSuchFieldException {
            for (h hVar : values()) {
                if (hVar.f16381l.equals(str)) {
                    return hVar;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public final Integer f16382a;

        /* renamed from: b, reason: collision with root package name */
        public final c f16383b;

        /* renamed from: c, reason: collision with root package name */
        public final Boolean f16384c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f16385d;

        /* renamed from: e, reason: collision with root package name */
        public final c f16386e;

        /* renamed from: f, reason: collision with root package name */
        public final Integer f16387f;

        /* renamed from: g, reason: collision with root package name */
        public final Boolean f16388g;

        public i(Integer num, c cVar, Boolean bool, Integer num2, c cVar2, Integer num3, Boolean bool2) {
            this.f16382a = num;
            this.f16383b = cVar;
            this.f16384c = bool;
            this.f16385d = num2;
            this.f16386e = cVar2;
            this.f16387f = num3;
            this.f16388g = bool2;
        }
    }

    public enum j {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");


        /* renamed from: l, reason: collision with root package name */
        public String f16394l;

        j(String str) {
            this.f16394l = str;
        }

        public static j d(String str) throws NoSuchFieldException {
            for (j jVar : values()) {
                if (jVar.f16394l.equals(str)) {
                    return jVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    /* renamed from: g5.k$k, reason: collision with other inner class name */
    public enum EnumC0181k {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");


        /* renamed from: l, reason: collision with root package name */
        public String f16398l;

        EnumC0181k(String str) {
            this.f16398l = str;
        }

        public static EnumC0181k d(String str) throws NoSuchFieldException {
            for (EnumC0181k enumC0181k : values()) {
                if (enumC0181k.f16398l.equals(str)) {
                    return enumC0181k;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public k(X4.a aVar) {
        a aVar2 = new a();
        this.f16350c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/platform", h5.f.f16894a);
        this.f16348a = jVar;
        jVar.e(aVar2);
    }

    public final b g(JSONObject jSONObject) throws JSONException {
        int i7 = jSONObject.getInt("primaryColor");
        if (i7 != 0) {
            i7 |= -16777216;
        }
        return new b(i7, jSONObject.getString("label"));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(org.json.JSONArray r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r8.length()
            r5 = 2
            r6 = 1
            if (r1 >= r4) goto L33
            java.lang.String r4 = r8.getString(r1)
            g5.k$e r4 = g5.k.e.d(r4)
            int r4 = r4.ordinal()
            if (r4 == 0) goto L2b
            if (r4 == r6) goto L28
            if (r4 == r5) goto L25
            r5 = 3
            if (r4 == r5) goto L22
            goto L2d
        L22:
            r2 = r2 | 8
            goto L2d
        L25:
            r2 = r2 | 2
            goto L2d
        L28:
            r2 = r2 | 4
            goto L2d
        L2b:
            r2 = r2 | 1
        L2d:
            if (r3 != 0) goto L30
            r3 = r2
        L30:
            int r1 = r1 + 1
            goto L4
        L33:
            if (r2 == 0) goto L53
            r8 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L52;
                case 3: goto L48;
                case 4: goto L47;
                case 5: goto L45;
                case 6: goto L48;
                case 7: goto L48;
                case 8: goto L44;
                case 9: goto L48;
                case 10: goto L41;
                case 11: goto L40;
                case 12: goto L48;
                case 13: goto L48;
                case 14: goto L48;
                case 15: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L4f
        L3d:
            r8 = 13
            return r8
        L40:
            return r5
        L41:
            r8 = 11
            return r8
        L44:
            return r1
        L45:
            r8 = 12
        L47:
            return r8
        L48:
            if (r3 == r5) goto L52
            r0 = 4
            if (r3 == r0) goto L51
            if (r3 == r1) goto L50
        L4f:
            return r6
        L50:
            return r1
        L51:
            return r8
        L52:
            return r0
        L53:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.k.h(org.json.JSONArray):int");
    }

    public final i i(JSONObject jSONObject) {
        return new i(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? c.d(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? c.d(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    public final j j(String str) {
        int iOrdinal = j.d(str).ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? j.EDGE_TO_EDGE : j.EDGE_TO_EDGE : j.IMMERSIVE_STICKY : j.IMMERSIVE : j.LEAN_BACK;
    }

    public final List k(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            int iOrdinal = EnumC0181k.d(jSONArray.getString(i7)).ordinal();
            if (iOrdinal == 0) {
                arrayList.add(EnumC0181k.TOP_OVERLAYS);
            } else if (iOrdinal == 1) {
                arrayList.add(EnumC0181k.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    public void l(g gVar) {
        this.f16349b = gVar;
    }

    public void m(boolean z7) {
        U4.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f16348a.c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z7)));
    }
}
