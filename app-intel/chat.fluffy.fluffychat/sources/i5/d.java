package i5;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import g5.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final h f17553a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f17554b;

    /* renamed from: c, reason: collision with root package name */
    public final h.b f17555c;

    public class a implements h.b {
        public a() {
        }

        @Override // g5.h.b
        public String a(String str, String str2) {
            Context contextCreateConfigurationContext = d.this.f17554b;
            if (str2 != null) {
                Locale localeB = d.b(str2);
                Configuration configuration = new Configuration(d.this.f17554b.getResources().getConfiguration());
                configuration.setLocale(localeB);
                contextCreateConfigurationContext = d.this.f17554b.createConfigurationContext(configuration);
            }
            int identifier = contextCreateConfigurationContext.getResources().getIdentifier(str, "string", d.this.f17554b.getPackageName());
            if (identifier != 0) {
                return contextCreateConfigurationContext.getResources().getString(identifier);
            }
            return null;
        }
    }

    public d(Context context, h hVar) {
        a aVar = new a();
        this.f17555c = aVar;
        this.f17554b = context;
        this.f17553a = hVar;
        hVar.c(aVar);
    }

    public static Locale b(String str) {
        Locale.Builder builder = new Locale.Builder();
        String[] strArrSplit = str.replace('_', '-').split("-");
        builder.setLanguage(strArrSplit[0]);
        int i7 = 1;
        if (strArrSplit.length > 1 && strArrSplit[1].length() == 4) {
            builder.setScript(strArrSplit[1]);
            i7 = 2;
        }
        if (strArrSplit.length > i7 && strArrSplit[i7].length() >= 2 && strArrSplit[i7].length() <= 3) {
            builder.setRegion(strArrSplit[i7]);
        }
        return builder.build();
    }

    public Locale c(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            LocaleList locales = this.f17554b.getResources().getConfiguration().getLocales();
            int size = locales.size();
            for (int i7 = 0; i7 < size; i7++) {
                Locale locale = locales.get(i7);
                String language = locale.getLanguage();
                if (!locale.getScript().isEmpty()) {
                    language = language + "-" + locale.getScript();
                }
                if (!locale.getCountry().isEmpty()) {
                    language = language + "-" + locale.getCountry();
                }
                arrayList.add(b.a(language));
                c.a();
                arrayList.add(b.a(locale.getLanguage()));
                c.a();
                arrayList.add(b.a(locale.getLanguage() + "-*"));
            }
            Locale localeLookup = Locale.lookup(arrayList, list);
            if (localeLookup != null) {
                return localeLookup;
            }
        } else {
            LocaleList locales2 = this.f17554b.getResources().getConfiguration().getLocales();
            for (int i8 = 0; i8 < locales2.size(); i8++) {
                Locale locale2 = locales2.get(i8);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Locale locale3 = (Locale) it.next();
                    if (locale2.equals(locale3)) {
                        return locale3;
                    }
                }
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Locale locale4 = (Locale) it2.next();
                    if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                        return locale4;
                    }
                }
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    Locale locale5 = (Locale) it3.next();
                    if (locale2.getLanguage().equals(locale5.getLanguage())) {
                        return locale5;
                    }
                }
            }
        }
        return (Locale) list.get(0);
    }

    public void d(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(locales.get(i7));
        }
        this.f17553a.b(arrayList);
    }
}
