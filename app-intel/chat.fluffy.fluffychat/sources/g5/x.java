package g5;

import android.os.Bundle;
import h5.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16487a;

    /* renamed from: b, reason: collision with root package name */
    public f f16488b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16489c;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) throws JSONException {
            Object obj;
            int i7;
            Bundle bundle;
            if (x.this.f16488b == null) {
                return;
            }
            String str = iVar.f16895a;
            obj = iVar.f16896b;
            U4.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.getClass();
            switch (str) {
                case "TextInput.setPlatformViewClient":
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        x.this.f16488b.d(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.success(null);
                        break;
                    } catch (JSONException e7) {
                        dVar.error("error", e7.getMessage(), null);
                        return;
                    }
                case "TextInput.setEditingState":
                    try {
                        x.this.f16488b.i(e.a((JSONObject) obj));
                        dVar.success(null);
                        break;
                    } catch (JSONException e8) {
                        dVar.error("error", e8.getMessage(), null);
                        return;
                    }
                case "TextInput.setClient":
                    try {
                        JSONArray jSONArray = (JSONArray) obj;
                        x.this.f16488b.j(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                        dVar.success(null);
                        break;
                    } catch (NoSuchFieldException | JSONException e9) {
                        dVar.error("error", e9.getMessage(), null);
                        return;
                    }
                case "TextInput.hide":
                    x.this.f16488b.k();
                    dVar.success(null);
                    break;
                case "TextInput.show":
                    x.this.f16488b.b();
                    dVar.success(null);
                    break;
                case "TextInput.sendAppPrivateCommand":
                    try {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        x.this.f16488b.c(string, bundle);
                        dVar.success(null);
                        break;
                    } catch (JSONException e10) {
                        dVar.error("error", e10.getMessage(), null);
                        return;
                    }
                    break;
                case "TextInput.setEditableSizeAndTransform":
                    try {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d7 = jSONObject3.getDouble("width");
                        double d8 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (i7 = 0; i7 < 16; i7++) {
                            dArr[i7] = jSONArray2.getDouble(i7);
                        }
                        x.this.f16488b.e(d7, d8, dArr);
                        dVar.success(null);
                        break;
                    } catch (JSONException e11) {
                        dVar.error("error", e11.getMessage(), null);
                        return;
                    }
                case "TextInput.finishAutofillContext":
                    x.this.f16488b.g(((Boolean) obj).booleanValue());
                    dVar.success(null);
                    break;
                case "TextInput.clearClient":
                    x.this.f16488b.h();
                    dVar.success(null);
                    break;
                case "TextInput.requestAutofill":
                    x.this.f16488b.f();
                    dVar.success(null);
                    break;
                default:
                    dVar.notImplemented();
                    break;
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f16491a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16492b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16493c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f16494d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f16495e;

        /* renamed from: f, reason: collision with root package name */
        public final d f16496f;

        /* renamed from: g, reason: collision with root package name */
        public final c f16497g;

        /* renamed from: h, reason: collision with root package name */
        public final Integer f16498h;

        /* renamed from: i, reason: collision with root package name */
        public final String f16499i;

        /* renamed from: j, reason: collision with root package name */
        public final a f16500j;

        /* renamed from: k, reason: collision with root package name */
        public final String[] f16501k;

        /* renamed from: l, reason: collision with root package name */
        public final b[] f16502l;

        /* renamed from: m, reason: collision with root package name */
        public final Locale[] f16503m;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final String f16504a;

            /* renamed from: b, reason: collision with root package name */
            public final String[] f16505b;

            /* renamed from: c, reason: collision with root package name */
            public final e f16506c;

            /* renamed from: d, reason: collision with root package name */
            public final String f16507d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f16504a = str;
                this.f16505b = strArr;
                this.f16507d = str2;
                this.f16506c = eVar;
            }

            public static a a(JSONObject jSONObject) throws JSONException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    strArr[i7] = b(jSONArray.getString(i7));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public static java.lang.String b(java.lang.String r17) {
                /*
                    Method dump skipped, instructions count: 806
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: g5.x.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr, Locale[] localeArr) {
            this.f16491a = z7;
            this.f16492b = z8;
            this.f16493c = z9;
            this.f16494d = z10;
            this.f16495e = z11;
            this.f16496f = dVar;
            this.f16497g = cVar;
            this.f16498h = num;
            this.f16499i = str;
            this.f16500j = aVar;
            this.f16501k = strArr;
            this.f16502l = bVarArr;
            this.f16503m = localeArr;
        }

        public static b a(JSONObject jSONObject) throws JSONException {
            b[] bVarArr;
            Locale[] localeArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i7 = 0; i7 < length; i7++) {
                    bVarArr2[i7] = a(jSONArray.getJSONObject(i7));
                }
                bVarArr = bVarArr2;
            }
            Integer numB = b(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                    arrayList.add(jSONArray2.optString(i8));
                }
            }
            if (jSONObject.isNull("hintLocales")) {
                localeArr = null;
            } else {
                JSONArray jSONArray3 = jSONObject.getJSONArray("hintLocales");
                Locale[] localeArr2 = new Locale[jSONArray3.length()];
                for (int i9 = 0; i9 < jSONArray3.length(); i9++) {
                    localeArr2[i9] = Locale.forLanguageTag(jSONArray3.optString(i9));
                }
                localeArr = localeArr2;
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.d(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), numB, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr, localeArr);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Integer b(java.lang.String r11) {
            /*
                r0 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r11.getClass()
                int r2 = r11.hashCode()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 1
                r10 = -1
                switch(r2) {
                    case -810971940: goto L74;
                    case -737377923: goto L69;
                    case -737089298: goto L5e;
                    case -737080013: goto L53;
                    case -736940669: goto L48;
                    case 469250275: goto L3d;
                    case 1241689507: goto L32;
                    case 1539450297: goto L27;
                    case 2110497650: goto L1a;
                    default: goto L17;
                }
            L17:
                r0 = r10
                goto L7d
            L1a:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L23
                goto L17
            L23:
                r0 = 8
                goto L7d
            L27:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L30
                goto L17
            L30:
                r0 = r3
                goto L7d
            L32:
                java.lang.String r0 = "TextInputAction.go"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L3b
                goto L17
            L3b:
                r0 = r4
                goto L7d
            L3d:
                java.lang.String r0 = "TextInputAction.search"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L46
                goto L17
            L46:
                r0 = r5
                goto L7d
            L48:
                java.lang.String r0 = "TextInputAction.send"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L51
                goto L17
            L51:
                r0 = r6
                goto L7d
            L53:
                java.lang.String r0 = "TextInputAction.none"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L5c
                goto L17
            L5c:
                r0 = r7
                goto L7d
            L5e:
                java.lang.String r0 = "TextInputAction.next"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L67
                goto L17
            L67:
                r0 = r8
                goto L7d
            L69:
                java.lang.String r0 = "TextInputAction.done"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L72
                goto L17
            L72:
                r0 = r9
                goto L7d
            L74:
                java.lang.String r2 = "TextInputAction.unspecified"
                boolean r11 = r11.equals(r2)
                if (r11 != 0) goto L7d
                goto L17
            L7d:
                switch(r0) {
                    case 0: goto La4;
                    case 1: goto L9f;
                    case 2: goto L9a;
                    case 3: goto L95;
                    case 4: goto L90;
                    case 5: goto L8b;
                    case 6: goto L86;
                    case 7: goto L95;
                    case 8: goto L81;
                    default: goto L80;
                }
            L80:
                return r1
            L81:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
                return r11
            L86:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
                return r11
            L8b:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
                return r11
            L90:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
                return r11
            L95:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
                return r11
            L9a:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
                return r11
            L9f:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
                return r11
            La4:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: g5.x.b.b(java.lang.String):java.lang.Integer");
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final g f16508a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16509b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16510c;

        public c(g gVar, boolean z7, boolean z8) {
            this.f16508a = gVar;
            this.f16509b = z7;
            this.f16510c = z8;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.d(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* renamed from: l, reason: collision with root package name */
        public final String f16516l;

        d(String str) {
            this.f16516l = str;
        }

        public static d d(String str) throws NoSuchFieldException {
            for (d dVar : values()) {
                if (dVar.f16516l.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f16517a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16518b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16519c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16520d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16521e;

        public e(String str, int i7, int i8, int i9, int i10) {
            if (!(i7 == -1 && i8 == -1) && (i7 < 0 || i8 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + i7 + ", " + i8 + ")");
            }
            if (!(i9 == -1 && i10 == -1) && (i9 < 0 || i9 > i10)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + i9 + ", " + i10 + ")");
            }
            if (i10 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + i9);
            }
            if (i7 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + i7);
            }
            if (i8 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + i8);
            }
            this.f16517a = str;
            this.f16518b = i7;
            this.f16519c = i8;
            this.f16520d = i9;
            this.f16521e = i10;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i7 = this.f16520d;
            return i7 >= 0 && this.f16521e > i7;
        }

        public boolean c() {
            return this.f16518b >= 0;
        }
    }

    public interface f {
        void b();

        void c(String str, Bundle bundle);

        void d(int i7, boolean z7);

        void e(double d7, double d8, double[] dArr);

        void f();

        void g(boolean z7);

        void h();

        void i(e eVar);

        void j(int i7, b bVar);

        void k();
    }

    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none"),
        WEB_SEARCH("TextInputType.webSearch"),
        TWITTER("TextInputType.twitter");


        /* renamed from: l, reason: collision with root package name */
        public final String f16536l;

        g(String str) {
            this.f16536l = str;
        }

        public static g d(String str) throws NoSuchFieldException {
            for (g gVar : values()) {
                if (gVar.f16536l.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public x(X4.a aVar) {
        a aVar2 = new a();
        this.f16489c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/textinput", h5.f.f16894a);
        this.f16487a = jVar;
        jVar.e(aVar2);
    }

    public static HashMap c(ArrayList arrayList) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            jSONArray.put(((io.flutter.plugin.editing.s) obj).b());
        }
        map.put("deltas", jSONArray);
        return map;
    }

    public static HashMap d(String str, int i7, int i8, int i9, int i10) {
        HashMap map = new HashMap();
        map.put("text", str);
        map.put("selectionBase", Integer.valueOf(i7));
        map.put("selectionExtent", Integer.valueOf(i8));
        map.put("composingBase", Integer.valueOf(i9));
        map.put("composingExtent", Integer.valueOf(i10));
        return map;
    }

    public void b(int i7, Map map) {
        U4.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.commitContent", map));
    }

    public void e(int i7) {
        U4.b.f("TextInputChannel", "Sending 'done' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.done"));
    }

    public void f(int i7) {
        U4.b.f("TextInputChannel", "Sending 'go' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.go"));
    }

    public void g(int i7) {
        U4.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.newline"));
    }

    public void h(int i7) {
        U4.b.f("TextInputChannel", "Sending 'next' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.next"));
    }

    public void i(int i7, String str, Bundle bundle) {
        HashMap map = new HashMap();
        map.put("action", str);
        if (bundle != null) {
            HashMap map2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    map2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    map2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    map2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    map2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    map2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    map2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    map2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    map2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            map.put("data", map2);
        }
        this.f16487a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i7), map));
    }

    public void j(int i7) {
        U4.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.previous"));
    }

    public void k() {
        this.f16487a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i7) {
        U4.b.f("TextInputChannel", "Sending 'search' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.search"));
    }

    public void m(int i7) {
        U4.b.f("TextInputChannel", "Sending 'send' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f16488b = fVar;
    }

    public void o(int i7) {
        U4.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f16487a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.unspecified"));
    }

    public void p(int i7, String str, int i8, int i9, int i10, int i11) {
        U4.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i8 + "\nSelection end: " + i9 + "\nComposing start: " + i10 + "\nComposing end: " + i11);
        this.f16487a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i7), d(str, i8, i9, i10, i11)));
    }

    public void q(int i7, ArrayList arrayList) {
        U4.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f16487a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i7), c(arrayList)));
    }

    public void r(int i7, HashMap map) {
        U4.b.f("TextInputChannel", "Sending message to update editing state for " + map.size() + " field(s).");
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            e eVar = (e) entry.getValue();
            map2.put((String) entry.getKey(), d(eVar.f16517a, eVar.f16518b, eVar.f16519c, -1, -1));
        }
        this.f16487a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i7), map2));
    }
}
