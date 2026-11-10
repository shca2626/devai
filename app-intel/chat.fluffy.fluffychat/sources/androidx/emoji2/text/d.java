package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.c;
import androidx.emoji2.text.f;
import java.util.Arrays;
import l0.AbstractC1297f;
import l0.C1296e;
import l0.C1301j;
import l0.l;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final c.i f12313a;

    /* renamed from: b, reason: collision with root package name */
    public final f f12314b;

    /* renamed from: c, reason: collision with root package name */
    public c.d f12315c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12316d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f12317e;

    public static final class a {
        public static int a(CharSequence charSequence, int i7, int i8) {
            int length = charSequence.length();
            if (i7 < 0 || length < i7 || i8 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i8 != 0) {
                    i7--;
                    if (i7 < 0) {
                        return z7 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (z7) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i8--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z7 = true;
                    }
                }
                return i7;
            }
        }

        public static int b(CharSequence charSequence, int i7, int i8) {
            int length = charSequence.length();
            if (i7 < 0 || length < i7 || i8 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i8 != 0) {
                    if (i7 >= length) {
                        if (z7) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (z7) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8--;
                        i7++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i8--;
                        i7++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i7++;
                        z7 = true;
                    }
                }
                return i7;
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f12318a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final f.a f12319b;

        /* renamed from: c, reason: collision with root package name */
        public f.a f12320c;

        /* renamed from: d, reason: collision with root package name */
        public f.a f12321d;

        /* renamed from: e, reason: collision with root package name */
        public int f12322e;

        /* renamed from: f, reason: collision with root package name */
        public int f12323f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f12324g;

        /* renamed from: h, reason: collision with root package name */
        public final int[] f12325h;

        public b(f.a aVar, boolean z7, int[] iArr) {
            this.f12319b = aVar;
            this.f12320c = aVar;
            this.f12324g = z7;
            this.f12325h = iArr;
        }

        public static boolean d(int i7) {
            return i7 == 65039;
        }

        public static boolean f(int i7) {
            return i7 == 65038;
        }

        public int a(int i7) {
            f.a aVarA = this.f12320c.a(i7);
            int iG = 2;
            if (this.f12318a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f12318a = 2;
                    this.f12320c = aVarA;
                    this.f12323f = 1;
                }
            } else if (aVarA != null) {
                this.f12320c = aVarA;
                this.f12323f++;
            } else if (f(i7)) {
                iG = g();
            } else if (!d(i7)) {
                if (this.f12320c.b() != null) {
                    iG = 3;
                    if (this.f12323f != 1 || h()) {
                        this.f12321d = this.f12320c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f12322e = i7;
            return iG;
        }

        public C1296e b() {
            return this.f12320c.b();
        }

        public C1296e c() {
            return this.f12321d.b();
        }

        public boolean e() {
            if (this.f12318a != 2 || this.f12320c.b() == null) {
                return false;
            }
            return this.f12323f > 1 || h();
        }

        public final int g() {
            this.f12318a = 1;
            this.f12320c = this.f12319b;
            this.f12323f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f12320c.b().j() || d(this.f12322e)) {
                return true;
            }
            if (this.f12324g) {
                if (this.f12325h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f12325h, this.f12320c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(f fVar, c.i iVar, c.d dVar, boolean z7, int[] iArr) {
        this.f12313a = iVar;
        this.f12314b = fVar;
        this.f12315c = dVar;
        this.f12316d = z7;
        this.f12317e = iArr;
    }

    public static boolean b(Editable editable, KeyEvent keyEvent, boolean z7) {
        AbstractC1297f[] abstractC1297fArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (abstractC1297fArr = (AbstractC1297f[]) editable.getSpans(selectionStart, selectionEnd, AbstractC1297f.class)) != null && abstractC1297fArr.length > 0) {
            for (AbstractC1297f abstractC1297f : abstractC1297fArr) {
                int spanStart = editable.getSpanStart(abstractC1297f);
                int spanEnd = editable.getSpanEnd(abstractC1297f);
                if ((z7 && spanStart == selectionStart) || ((!z7 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(InputConnection inputConnection, Editable editable, int i7, int i8, boolean z7) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i7 >= 0 && i8 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z7) {
                iMax = a.a(editable, selectionStart, Math.max(i7, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i8, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i7, 0);
                iMin = Math.min(selectionEnd + i8, editable.length());
            }
            AbstractC1297f[] abstractC1297fArr = (AbstractC1297f[]) editable.getSpans(iMax, iMin, AbstractC1297f.class);
            if (abstractC1297fArr != null && abstractC1297fArr.length > 0) {
                for (AbstractC1297f abstractC1297f : abstractC1297fArr) {
                    int spanStart = editable.getSpanStart(abstractC1297f);
                    int spanEnd = editable.getSpanEnd(abstractC1297f);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean d(Editable editable, int i7, KeyEvent keyEvent) {
        if (!(i7 != 67 ? i7 != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean f(int i7, int i8) {
        return i7 == -1 || i8 == -1 || i7 != i8;
    }

    public static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final void a(Spannable spannable, C1296e c1296e, int i7, int i8) {
        spannable.setSpan(this.f12313a.a(c1296e), i7, i8, 33);
    }

    public final boolean e(CharSequence charSequence, int i7, int i8, C1296e c1296e) {
        if (c1296e.d() == 0) {
            c1296e.k(this.f12315c.a(charSequence, i7, i8, c1296e.h()));
        }
        return c1296e.d() == 2;
    }

    public CharSequence h(CharSequence charSequence, int i7, int i8, int i9, boolean z7) {
        l lVar;
        int iCharCount;
        AbstractC1297f[] abstractC1297fArr;
        boolean z8 = charSequence instanceof C1301j;
        if (z8) {
            ((C1301j) charSequence).a();
        }
        if (!z8) {
            try {
                lVar = charSequence instanceof Spannable ? new l((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i7 + (-1), i8 + 1, AbstractC1297f.class) > i8) ? null : new l(charSequence);
            } catch (Throwable th) {
                if (z8) {
                    ((C1301j) charSequence).d();
                }
                throw th;
            }
        }
        if (lVar != null && (abstractC1297fArr = (AbstractC1297f[]) lVar.getSpans(i7, i8, AbstractC1297f.class)) != null && abstractC1297fArr.length > 0) {
            for (AbstractC1297f abstractC1297f : abstractC1297fArr) {
                int spanStart = lVar.getSpanStart(abstractC1297f);
                int spanEnd = lVar.getSpanEnd(abstractC1297f);
                if (spanStart != i8) {
                    lVar.removeSpan(abstractC1297f);
                }
                i7 = Math.min(spanStart, i7);
                i8 = Math.max(spanEnd, i8);
            }
        }
        if (i7 != i8 && i7 < charSequence.length()) {
            if (i9 != Integer.MAX_VALUE && lVar != null) {
                i9 -= ((AbstractC1297f[]) lVar.getSpans(0, lVar.length(), AbstractC1297f.class)).length;
            }
            b bVar = new b(this.f12314b.f(), this.f12316d, this.f12317e);
            int iCodePointAt = Character.codePointAt(charSequence, i7);
            int i10 = 0;
            l lVar2 = lVar;
            loop1: while (true) {
                iCharCount = i7;
                while (i7 < i8 && i10 < i9) {
                    int iA = bVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i8) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i7 = iCharCount;
                    } else if (iA == 2) {
                        i7 += Character.charCount(iCodePointAt);
                        if (i7 < i8) {
                            iCodePointAt = Character.codePointAt(charSequence, i7);
                        }
                    } else if (iA == 3) {
                        if (z7 || !e(charSequence, iCharCount, i7, bVar.c())) {
                            if (lVar2 == null) {
                                lVar2 = new l((Spannable) new SpannableString(charSequence));
                            }
                            a(lVar2, bVar.c(), iCharCount, i7);
                            i10++;
                        }
                    }
                }
                break loop1;
            }
            if (bVar.e() && i10 < i9 && (z7 || !e(charSequence, iCharCount, i7, bVar.b()))) {
                if (lVar2 == null) {
                    lVar2 = new l(charSequence);
                }
                a(lVar2, bVar.b(), iCharCount, i7);
            }
            if (lVar2 == null) {
                if (z8) {
                }
                return charSequence;
            }
            Spannable spannableB = lVar2.b();
            if (z8) {
                ((C1301j) charSequence).d();
            }
            return spannableB;
        }
        if (!z8) {
            return charSequence;
        }
        ((C1301j) charSequence).d();
        return charSequence;
    }
}
