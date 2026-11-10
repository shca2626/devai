package g5;

import h5.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16337a;

    /* renamed from: b, reason: collision with root package name */
    public b f16338b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16339c;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (h.this.f16338b == null) {
                return;
            }
            String str = iVar.f16895a;
            str.getClass();
            if (!str.equals("Localization.getStringResource")) {
                dVar.notImplemented();
                return;
            }
            JSONObject jSONObject = (JSONObject) iVar.b();
            try {
                dVar.success(h.this.f16338b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e7) {
                dVar.error("error", e7.getMessage(), null);
            }
        }
    }

    public interface b {
        String a(String str, String str2);
    }

    public h(X4.a aVar) {
        a aVar2 = new a();
        this.f16339c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/localization", h5.f.f16894a);
        this.f16337a = jVar;
        jVar.e(aVar2);
    }

    public void b(List list) {
        U4.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Locale locale = (Locale) it.next();
            U4.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(locale.getScript());
            arrayList.add(locale.getVariant());
        }
        this.f16337a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f16338b = bVar;
    }
}
