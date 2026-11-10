package androidx.preference;

import N.k;
import R1.c;
import R1.e;
import R1.g;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: A, reason: collision with root package name */
    public boolean f12897A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f12898B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f12899C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f12900D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f12901E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f12902F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f12903G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f12904H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f12905I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f12906J;

    /* renamed from: K, reason: collision with root package name */
    public int f12907K;

    /* renamed from: L, reason: collision with root package name */
    public int f12908L;

    /* renamed from: M, reason: collision with root package name */
    public List f12909M;

    /* renamed from: N, reason: collision with root package name */
    public b f12910N;

    /* renamed from: O, reason: collision with root package name */
    public final View.OnClickListener f12911O;

    /* renamed from: l, reason: collision with root package name */
    public final Context f12912l;

    /* renamed from: m, reason: collision with root package name */
    public R1.a f12913m;

    /* renamed from: n, reason: collision with root package name */
    public int f12914n;

    /* renamed from: o, reason: collision with root package name */
    public int f12915o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f12916p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f12917q;

    /* renamed from: r, reason: collision with root package name */
    public int f12918r;

    /* renamed from: s, reason: collision with root package name */
    public String f12919s;

    /* renamed from: t, reason: collision with root package name */
    public Intent f12920t;

    /* renamed from: u, reason: collision with root package name */
    public String f12921u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12922v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12923w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12924x;

    /* renamed from: y, reason: collision with root package name */
    public String f12925y;

    /* renamed from: z, reason: collision with root package name */
    public Object f12926z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.B(view);
        }
    }

    public interface b {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f12914n = Integer.MAX_VALUE;
        this.f12915o = 0;
        this.f12922v = true;
        this.f12923w = true;
        this.f12924x = true;
        this.f12897A = true;
        this.f12898B = true;
        this.f12899C = true;
        this.f12900D = true;
        this.f12901E = true;
        this.f12903G = true;
        this.f12906J = true;
        this.f12907K = e.f7885a;
        this.f12911O = new a();
        this.f12912l = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7903I, i7, i8);
        this.f12918r = k.l(typedArrayObtainStyledAttributes, g.f7957g0, g.f7905J, 0);
        this.f12919s = k.m(typedArrayObtainStyledAttributes, g.f7963j0, g.f7917P);
        this.f12916p = k.n(typedArrayObtainStyledAttributes, g.f7979r0, g.f7913N);
        this.f12917q = k.n(typedArrayObtainStyledAttributes, g.f7977q0, g.f7919Q);
        this.f12914n = k.d(typedArrayObtainStyledAttributes, g.f7967l0, g.f7921R, Integer.MAX_VALUE);
        this.f12921u = k.m(typedArrayObtainStyledAttributes, g.f7955f0, g.f7931W);
        this.f12907K = k.l(typedArrayObtainStyledAttributes, g.f7965k0, g.f7911M, e.f7885a);
        this.f12908L = k.l(typedArrayObtainStyledAttributes, g.f7981s0, g.f7923S, 0);
        this.f12922v = k.b(typedArrayObtainStyledAttributes, g.f7952e0, g.f7909L, true);
        this.f12923w = k.b(typedArrayObtainStyledAttributes, g.f7971n0, g.f7915O, true);
        this.f12924x = k.b(typedArrayObtainStyledAttributes, g.f7969m0, g.f7907K, true);
        this.f12925y = k.m(typedArrayObtainStyledAttributes, g.f7946c0, g.f7925T);
        int i9 = g.f7937Z;
        this.f12900D = k.b(typedArrayObtainStyledAttributes, i9, i9, this.f12923w);
        int i10 = g.f7940a0;
        this.f12901E = k.b(typedArrayObtainStyledAttributes, i10, i10, this.f12923w);
        if (typedArrayObtainStyledAttributes.hasValue(g.f7943b0)) {
            this.f12926z = y(typedArrayObtainStyledAttributes, g.f7943b0);
        } else if (typedArrayObtainStyledAttributes.hasValue(g.f7927U)) {
            this.f12926z = y(typedArrayObtainStyledAttributes, g.f7927U);
        }
        this.f12906J = k.b(typedArrayObtainStyledAttributes, g.f7973o0, g.f7929V, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(g.f7975p0);
        this.f12902F = zHasValue;
        if (zHasValue) {
            this.f12903G = k.b(typedArrayObtainStyledAttributes, g.f7975p0, g.f7933X, true);
        }
        this.f12904H = k.b(typedArrayObtainStyledAttributes, g.f7959h0, g.f7935Y, false);
        int i11 = g.f7961i0;
        this.f12899C = k.b(typedArrayObtainStyledAttributes, i11, i11, true);
        int i12 = g.f7949d0;
        this.f12905I = k.b(typedArrayObtainStyledAttributes, i12, i12, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void A() {
        if (s() && t()) {
            w();
            n();
            if (this.f12920t != null) {
                e().startActivity(this.f12920t);
            }
        }
    }

    public void B(View view) {
        A();
    }

    public boolean C(boolean z7) {
        if (!H()) {
            return false;
        }
        if (z7 == j(!z7)) {
            return true;
        }
        R1.a aVarM = m();
        aVarM.getClass();
        aVarM.d(this.f12919s, z7);
        return true;
    }

    public boolean D(int i7) {
        if (!H()) {
            return false;
        }
        if (i7 == k(~i7)) {
            return true;
        }
        R1.a aVarM = m();
        aVarM.getClass();
        aVarM.e(this.f12919s, i7);
        return true;
    }

    public boolean E(String str) {
        if (!H()) {
            return false;
        }
        if (TextUtils.equals(str, l(null))) {
            return true;
        }
        R1.a aVarM = m();
        aVarM.getClass();
        aVarM.f(this.f12919s, str);
        return true;
    }

    public final void F(b bVar) {
        this.f12910N = bVar;
        u();
    }

    public boolean G() {
        return !s();
    }

    public boolean H() {
        return false;
    }

    public boolean a(Object obj) {
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i7 = this.f12914n;
        int i8 = preference.f12914n;
        if (i7 != i8) {
            return i7 - i8;
        }
        CharSequence charSequence = this.f12916p;
        CharSequence charSequence2 = preference.f12916p;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f12916p.toString());
    }

    public Context e() {
        return this.f12912l;
    }

    public StringBuilder f() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceQ = q();
        if (!TextUtils.isEmpty(charSequenceQ)) {
            sb.append(charSequenceQ);
            sb.append(' ');
        }
        CharSequence charSequenceO = o();
        if (!TextUtils.isEmpty(charSequenceO)) {
            sb.append(charSequenceO);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String h() {
        return this.f12921u;
    }

    public Intent i() {
        return this.f12920t;
    }

    public boolean j(boolean z7) {
        if (!H()) {
            return z7;
        }
        R1.a aVarM = m();
        aVarM.getClass();
        return aVarM.a(this.f12919s, z7);
    }

    public int k(int i7) {
        if (!H()) {
            return i7;
        }
        R1.a aVarM = m();
        aVarM.getClass();
        return aVarM.b(this.f12919s, i7);
    }

    public String l(String str) {
        if (!H()) {
            return str;
        }
        R1.a aVarM = m();
        aVarM.getClass();
        return aVarM.c(this.f12919s, str);
    }

    public R1.a m() {
        R1.a aVar = this.f12913m;
        if (aVar != null) {
            return aVar;
        }
        return null;
    }

    public R1.b n() {
        return null;
    }

    public CharSequence o() {
        return p() != null ? p().a(this) : this.f12917q;
    }

    public final b p() {
        return this.f12910N;
    }

    public CharSequence q() {
        return this.f12916p;
    }

    public boolean r() {
        return !TextUtils.isEmpty(this.f12919s);
    }

    public boolean s() {
        return this.f12922v && this.f12897A && this.f12898B;
    }

    public boolean t() {
        return this.f12923w;
    }

    public String toString() {
        return f().toString();
    }

    public void u() {
    }

    public void v(boolean z7) {
        List list = this.f12909M;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((Preference) list.get(i7)).x(this, z7);
        }
    }

    public void w() {
    }

    public void x(Preference preference, boolean z7) {
        if (this.f12897A == z7) {
            this.f12897A = !z7;
            v(G());
            u();
        }
    }

    public Object y(TypedArray typedArray, int i7) {
        return null;
    }

    public void z(Preference preference, boolean z7) {
        if (this.f12898B == z7) {
            this.f12898B = !z7;
            v(G());
            u();
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7880g, R.attr.preferenceStyle));
    }
}
