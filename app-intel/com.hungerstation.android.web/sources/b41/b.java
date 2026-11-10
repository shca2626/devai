package b41;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f12919a;

    /* renamed from: b, reason: collision with root package name */
    private String f12920b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f12921c;

    /* renamed from: d, reason: collision with root package name */
    private String f12922d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f12923e;

    /* renamed from: f, reason: collision with root package name */
    private b f12924f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12926h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12927i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f12928j;

    /* renamed from: k, reason: collision with root package name */
    private Uri f12929k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f12930l;

    /* renamed from: m, reason: collision with root package name */
    private Rect f12931m;

    /* renamed from: n, reason: collision with root package name */
    private View f12932n;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f12925g = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    private int f12933o = 1;

    public View A() {
        return this.f12932n;
    }

    public Rect B() {
        return this.f12931m;
    }

    public boolean C() {
        return this.f12926h;
    }

    public boolean D() {
        return this.f12927i;
    }

    public void E() {
        this.f12928j = null;
    }

    public JSONObject a() {
        return this.f12921c;
    }

    public void b(int i12) {
        this.f12933o = i12;
    }

    public void c(Bitmap bitmap) {
        this.f12928j = bitmap;
    }

    public void d(Rect rect) {
        this.f12930l = rect;
    }

    public void e(Uri uri) {
        this.f12929k = uri;
    }

    public void f(View view) {
        this.f12932n = view;
    }

    public void g(b bVar) {
        this.f12925g.add(bVar);
    }

    public void h(String str) {
        this.f12920b = str;
    }

    public void i(JSONObject jSONObject) {
        this.f12921c = jSONObject;
    }

    public void j(boolean z12) {
        this.f12926h = z12;
    }

    public String k() {
        return this.f12920b;
    }

    public void l(Rect rect) {
        this.f12931m = rect;
    }

    public void m(b bVar) {
        this.f12924f = bVar;
    }

    public void n(String str) {
        this.f12919a = str;
    }

    public void o(JSONObject jSONObject) {
        this.f12923e = jSONObject;
    }

    public void p(boolean z12) {
        this.f12927i = z12;
    }

    public String q() {
        return this.f12919a;
    }

    public void r(String str) {
        this.f12922d = str;
    }

    public Bitmap s() {
        return this.f12928j;
    }

    public Uri t() {
        return this.f12929k;
    }

    public ArrayList u() {
        return this.f12925g;
    }

    public Rect v() {
        return this.f12930l;
    }

    public b w() {
        return this.f12924f;
    }

    public JSONObject x() {
        return this.f12923e;
    }

    public int y() {
        return this.f12933o;
    }

    public String z() {
        return this.f12922d;
    }
}
