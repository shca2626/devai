package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f17755a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f17756b;

    /* renamed from: c, reason: collision with root package name */
    public int f17757c;

    /* renamed from: d, reason: collision with root package name */
    public int f17758d;

    /* renamed from: e, reason: collision with root package name */
    public int f17759e;

    /* renamed from: f, reason: collision with root package name */
    public int f17760f;

    /* renamed from: g, reason: collision with root package name */
    public int f17761g;

    /* renamed from: h, reason: collision with root package name */
    public int f17762h;

    public s(CharSequence charSequence, int i7, int i8, CharSequence charSequence2, int i9, int i10, int i11, int i12) {
        this.f17759e = i9;
        this.f17760f = i10;
        this.f17761g = i11;
        this.f17762h = i12;
        a(charSequence, charSequence2.toString(), i7, i8);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2, int i7, int i8) {
        this.f17755a = charSequence;
        this.f17756b = charSequence2;
        this.f17757c = i7;
        this.f17758d = i8;
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f17755a.toString());
            jSONObject.put("deltaText", this.f17756b.toString());
            jSONObject.put("deltaStart", this.f17757c);
            jSONObject.put("deltaEnd", this.f17758d);
            jSONObject.put("selectionBase", this.f17759e);
            jSONObject.put("selectionExtent", this.f17760f);
            jSONObject.put("composingBase", this.f17761g);
            jSONObject.put("composingExtent", this.f17762h);
            return jSONObject;
        } catch (JSONException e7) {
            U4.b.b("TextEditingDelta", "unable to create JSONObject: " + e7);
            return jSONObject;
        }
    }

    public s(CharSequence charSequence, int i7, int i8, int i9, int i10) {
        this.f17759e = i7;
        this.f17760f = i8;
        this.f17761g = i9;
        this.f17762h = i10;
        a(charSequence, "", -1, -1);
    }
}
