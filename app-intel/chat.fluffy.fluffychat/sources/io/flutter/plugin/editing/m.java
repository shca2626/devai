package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import g5.x;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends SpannableStringBuilder {

    /* renamed from: l, reason: collision with root package name */
    public int f17734l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f17735m = 0;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f17736n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f17737o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f17738p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public String f17739q;

    /* renamed from: r, reason: collision with root package name */
    public String f17740r;

    /* renamed from: s, reason: collision with root package name */
    public int f17741s;

    /* renamed from: t, reason: collision with root package name */
    public int f17742t;

    /* renamed from: u, reason: collision with root package name */
    public int f17743u;

    /* renamed from: v, reason: collision with root package name */
    public int f17744v;

    /* renamed from: w, reason: collision with root package name */
    public BaseInputConnection f17745w;

    public class a extends BaseInputConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Editable f17746a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, boolean z7, Editable editable) {
            super(view, z7);
            this.f17746a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f17746a;
        }
    }

    public interface b {
        void a(boolean z7, boolean z8, boolean z9);
    }

    public m(x.e eVar, View view) {
        this.f17745w = new a(view, true, this);
        if (eVar != null) {
            n(eVar);
        }
    }

    public void a(b bVar) {
        if (this.f17735m > 0) {
            U4.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f17734l <= 0) {
            this.f17736n.add(bVar);
        } else {
            U4.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.f17737o.add(bVar);
        }
    }

    public void b() {
        this.f17734l++;
        if (this.f17735m > 0) {
            U4.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f17734l != 1 || this.f17736n.isEmpty()) {
            return;
        }
        this.f17740r = toString();
        this.f17741s = i();
        this.f17742t = h();
        this.f17743u = g();
        this.f17744v = f();
    }

    public void c() {
        this.f17738p.clear();
    }

    public void d() {
        int i7 = this.f17734l;
        if (i7 == 0) {
            U4.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i7 == 1) {
            ArrayList arrayList = this.f17737o;
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                j((b) obj, true, true, true);
            }
            if (!this.f17736n.isEmpty()) {
                U4.b.f("ListenableEditingState", "didFinishBatchEdit with " + this.f17736n.size() + " listener(s)");
                k(!toString().equals(this.f17740r), (this.f17741s == i() && this.f17742t == h()) ? false : true, (this.f17743u == g() && this.f17744v == f()) ? false : true);
            }
        }
        this.f17736n.addAll(this.f17737o);
        this.f17737o.clear();
        this.f17734l--;
    }

    public ArrayList e() {
        ArrayList arrayList = new ArrayList(this.f17738p);
        this.f17738p.clear();
        return arrayList;
    }

    public final int f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int h() {
        return Selection.getSelectionEnd(this);
    }

    public final int i() {
        return Selection.getSelectionStart(this);
    }

    public final void j(b bVar, boolean z7, boolean z8, boolean z9) {
        this.f17735m++;
        bVar.a(z7, z8, z9);
        this.f17735m--;
    }

    public final void k(boolean z7, boolean z8, boolean z9) {
        if (z7 || z8 || z9) {
            ArrayList arrayList = this.f17736n;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                j((b) obj, z7, z8, z9);
            }
        }
    }

    public void l(b bVar) {
        if (this.f17735m > 0) {
            U4.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f17736n.remove(bVar);
        if (this.f17734l > 0) {
            this.f17737o.remove(bVar);
        }
    }

    public void m(int i7, int i8) {
        if (i7 < 0 || i7 >= i8) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f17745w.setComposingRegion(i7, i8);
        }
    }

    public void n(x.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f16517a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f16518b, eVar.f16519c);
        } else {
            Selection.removeSelection(this);
        }
        m(eVar.f16520d, eVar.f16521e);
        c();
        d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        super.setSpan(obj, i7, i8, i9);
        this.f17738p.add(new s(toString(), i(), h(), g(), f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f17739q;
        if (str != null) {
            return str;
        }
        String string = super.toString();
        this.f17739q = string;
        return string;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence, int i9, int i10) {
        if (this.f17735m > 0) {
            U4.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String string = toString();
        int i11 = i8 - i7;
        boolean z7 = i11 != i10 - i9;
        for (int i12 = 0; i12 < i11 && !z7; i12++) {
            z7 |= charAt(i7 + i12) != charSequence.charAt(i9 + i12);
        }
        if (z7) {
            this.f17739q = null;
        }
        int i13 = i();
        int iH = h();
        int iG = g();
        int iF = f();
        SpannableStringBuilder spannableStringBuilderReplace = super.replace(i7, i8, charSequence, i9, i10);
        this.f17738p.add(new s(string, i7, i8, charSequence, i(), h(), g(), f()));
        if (this.f17734l > 0) {
            return spannableStringBuilderReplace;
        }
        k(z7, (i() == i13 && h() == iH) ? false : true, (g() == iG && f() == iF) ? false : true);
        return spannableStringBuilderReplace;
    }
}
