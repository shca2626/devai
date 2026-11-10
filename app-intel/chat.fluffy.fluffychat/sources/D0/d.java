package D0;

import E0.U;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import j3.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1594a = U.A0(0);

    /* renamed from: b, reason: collision with root package name */
    public static final String f1595b = U.A0(1);

    /* renamed from: c, reason: collision with root package name */
    public static final String f1596c = U.A0(2);

    /* renamed from: d, reason: collision with root package name */
    public static final String f1597d = U.A0(3);

    /* renamed from: e, reason: collision with root package name */
    public static final String f1598e = U.A0(4);

    public static ArrayList a(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (f fVar : (f[]) spanned.getSpans(0, spanned.length(), f.class)) {
            arrayList.add(b(spanned, fVar, 1, fVar.b()));
        }
        for (h hVar : (h[]) spanned.getSpans(0, spanned.length(), h.class)) {
            arrayList.add(b(spanned, hVar, 2, hVar.b()));
        }
        for (e eVar : (e[]) spanned.getSpans(0, spanned.length(), e.class)) {
            arrayList.add(b(spanned, eVar, 3, null));
        }
        for (i iVar : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
            arrayList.add(b(spanned, iVar, 4, iVar.b()));
        }
        return arrayList;
    }

    public static Bundle b(Spanned spanned, Object obj, int i7, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f1594a, spanned.getSpanStart(obj));
        bundle2.putInt(f1595b, spanned.getSpanEnd(obj));
        bundle2.putInt(f1596c, spanned.getSpanFlags(obj));
        bundle2.putInt(f1597d, i7);
        if (bundle != null) {
            bundle2.putBundle(f1598e, bundle);
        }
        return bundle2;
    }

    public static void c(Bundle bundle, Spannable spannable) {
        int i7 = bundle.getInt(f1594a);
        int i8 = bundle.getInt(f1595b);
        int i9 = bundle.getInt(f1596c);
        int i10 = bundle.getInt(f1597d, -1);
        Bundle bundle2 = bundle.getBundle(f1598e);
        if (i10 == 1) {
            spannable.setSpan(f.a((Bundle) o.q(bundle2)), i7, i8, i9);
            return;
        }
        if (i10 == 2) {
            spannable.setSpan(h.a((Bundle) o.q(bundle2)), i7, i8, i9);
        } else if (i10 == 3) {
            spannable.setSpan(new e(), i7, i8, i9);
        } else {
            if (i10 != 4) {
                return;
            }
            spannable.setSpan(i.a((Bundle) o.q(bundle2)), i7, i8, i9);
        }
    }
}
