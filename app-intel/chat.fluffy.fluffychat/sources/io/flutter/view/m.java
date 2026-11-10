package io.flutter.view;

import android.text.SpannableString;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f18170a;

    /* renamed from: b, reason: collision with root package name */
    public List f18171b;

    /* renamed from: c, reason: collision with root package name */
    public String f18172c;

    /* renamed from: d, reason: collision with root package name */
    public String f18173d;

    public static class a extends c {

        /* renamed from: d, reason: collision with root package name */
        public String f18174d;
    }

    public static class b extends c {
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f18175a;

        /* renamed from: b, reason: collision with root package name */
        public int f18176b;

        /* renamed from: c, reason: collision with root package name */
        public d f18177c;
    }

    public enum d {
        SPELLOUT,
        LOCALE
    }

    public m a(List list) {
        this.f18171b = list;
        return this;
    }

    public m b(String str) {
        this.f18172c = str;
        return this;
    }

    public m c(String str) {
        this.f18170a = str;
        return this;
    }

    public m d(String str) {
        this.f18173d = str;
        return this;
    }

    public CharSequence e() {
        if (this.f18170a == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(this.f18170a);
        List<c> list = this.f18171b;
        if (list != null) {
            for (c cVar : list) {
                int iOrdinal = cVar.f18177c.ordinal();
                if (iOrdinal == 0) {
                    spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), cVar.f18175a, cVar.f18176b, 0);
                } else if (iOrdinal == 1) {
                    spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((a) cVar).f18174d)), cVar.f18175a, cVar.f18176b, 0);
                }
            }
        }
        String str = this.f18173d;
        if (str != null && !str.isEmpty()) {
            spannableString.setSpan(new URLSpan(this.f18173d), 0, this.f18170a.length(), 0);
        }
        String str2 = this.f18172c;
        if (str2 != null && !str2.isEmpty()) {
            spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(this.f18172c)), 0, this.f18170a.length(), 0);
        }
        return spannableString;
    }
}
