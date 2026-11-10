package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import g5.v;
import h5.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class r implements v.b, SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a, reason: collision with root package name */
    public final g5.v f17751a;

    /* renamed from: b, reason: collision with root package name */
    public final TextServicesManager f17752b;

    /* renamed from: c, reason: collision with root package name */
    public SpellCheckerSession f17753c;

    /* renamed from: d, reason: collision with root package name */
    public j.d f17754d;

    public r(TextServicesManager textServicesManager, g5.v vVar) {
        this.f17752b = textServicesManager;
        this.f17751a = vVar;
        vVar.b(this);
    }

    @Override // g5.v.b
    public void a(String str, String str2, j.d dVar) {
        if (this.f17754d != null) {
            dVar.error("error", "Previous spell check request still pending.", null);
        } else {
            this.f17754d = dVar;
            c(str, str2);
        }
    }

    public void b() {
        this.f17751a.b(null);
        SpellCheckerSession spellCheckerSession = this.f17753c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void c(String str, String str2) {
        Locale localeB = i5.d.b(str);
        if (this.f17753c == null) {
            this.f17753c = this.f17752b.newSpellCheckerSession(null, localeB, this, true);
        }
        this.f17753c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        if (sentenceSuggestionsInfoArr.length == 0) {
            this.f17754d.success(new ArrayList());
            this.f17754d = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
        if (sentenceSuggestionsInfo == null) {
            this.f17754d.success(new ArrayList());
            this.f17754d = null;
            return;
        }
        for (int i7 = 0; i7 < sentenceSuggestionsInfo.getSuggestionsCount(); i7++) {
            SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i7);
            int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
            if (suggestionsCount > 0) {
                HashMap map = new HashMap();
                int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i7);
                int lengthAt = sentenceSuggestionsInfo.getLengthAt(i7) + offsetAt;
                map.put("startIndex", Integer.valueOf(offsetAt));
                map.put("endIndex", Integer.valueOf(lengthAt));
                ArrayList arrayList2 = new ArrayList();
                boolean z7 = false;
                for (int i8 = 0; i8 < suggestionsCount; i8++) {
                    String suggestionAt = suggestionsInfoAt.getSuggestionAt(i8);
                    if (!suggestionAt.isEmpty()) {
                        arrayList2.add(suggestionAt);
                        z7 = true;
                    }
                }
                if (z7) {
                    map.put("suggestions", arrayList2);
                    arrayList.add(map);
                }
            }
        }
        this.f17754d.success(arrayList);
        this.f17754d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
