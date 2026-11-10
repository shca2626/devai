package a0;

import a0.InterfaceC0743A;
import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

/* loaded from: classes.dex */
public class x {

    /* renamed from: d, reason: collision with root package name */
    public static int f10483d;

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f10484a;

    /* renamed from: b, reason: collision with root package name */
    public int f10485b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f10486c = -1;

    public static class a {

        /* renamed from: G, reason: collision with root package name */
        public static final a f10493G;

        /* renamed from: H, reason: collision with root package name */
        public static final a f10494H;

        /* renamed from: I, reason: collision with root package name */
        public static final a f10495I;

        /* renamed from: J, reason: collision with root package name */
        public static final a f10496J;

        /* renamed from: K, reason: collision with root package name */
        public static final a f10497K;

        /* renamed from: L, reason: collision with root package name */
        public static final a f10498L;

        /* renamed from: M, reason: collision with root package name */
        public static final a f10499M;

        /* renamed from: N, reason: collision with root package name */
        public static final a f10500N;

        /* renamed from: O, reason: collision with root package name */
        public static final a f10501O;

        /* renamed from: P, reason: collision with root package name */
        public static final a f10502P;

        /* renamed from: Q, reason: collision with root package name */
        public static final a f10503Q;

        /* renamed from: R, reason: collision with root package name */
        public static final a f10504R;

        /* renamed from: S, reason: collision with root package name */
        public static final a f10505S;

        /* renamed from: T, reason: collision with root package name */
        public static final a f10506T;

        /* renamed from: U, reason: collision with root package name */
        public static final a f10507U;

        /* renamed from: V, reason: collision with root package name */
        public static final a f10508V;

        /* renamed from: W, reason: collision with root package name */
        public static final a f10509W;

        /* renamed from: a, reason: collision with root package name */
        public final Object f10532a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10533b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f10534c;

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC0743A f10535d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f10510e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f10511f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f10512g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f10513h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f10514i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f10515j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f10516k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f10517l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f10518m = new a(256, (CharSequence) null, InterfaceC0743A.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f10519n = new a(512, (CharSequence) null, InterfaceC0743A.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f10520o = new a(1024, (CharSequence) null, InterfaceC0743A.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f10521p = new a(2048, (CharSequence) null, InterfaceC0743A.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f10522q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f10523r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f10524s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f10525t = new a(PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f10526u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f10527v = new a(131072, (CharSequence) null, InterfaceC0743A.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f10528w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f10529x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f10530y = new a(1048576, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f10531z = new a(2097152, (CharSequence) null, InterfaceC0743A.h.class);

        /* renamed from: A, reason: collision with root package name */
        public static final a f10487A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);

        /* renamed from: B, reason: collision with root package name */
        public static final a f10488B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, InterfaceC0743A.e.class);

        /* renamed from: C, reason: collision with root package name */
        public static final a f10489C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);

        /* renamed from: D, reason: collision with root package name */
        public static final a f10490D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);

        /* renamed from: E, reason: collision with root package name */
        public static final a f10491E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);

        /* renamed from: F, reason: collision with root package name */
        public static final a f10492F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);

        static {
            int i7 = Build.VERSION.SDK_INT;
            f10493G = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f10494H = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f10495I = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f10496J = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f10497K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f10498L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, InterfaceC0743A.f.class);
            f10499M = new a(i7 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, InterfaceC0743A.d.class);
            f10500N = new a(i7 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f10501O = new a(i7 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f10502P = new a(i7 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f10503Q = new a(i7 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f10504R = new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f10505S = new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f10506T = new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f10507U = new a(i7 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f10508V = new a(i7 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
            f10509W = new a(V.c.a() ? f.a() : null, R.id.ALT, null, null, null);
        }

        public a(int i7, CharSequence charSequence) {
            this(null, i7, charSequence, null, null);
        }

        public a a(CharSequence charSequence, InterfaceC0743A interfaceC0743A) {
            return new a(null, this.f10533b, charSequence, interfaceC0743A, this.f10534c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f10532a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f10532a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            InterfaceC0743A.a aVar;
            if (this.f10535d == null) {
                return false;
            }
            Class cls = this.f10534c;
            InterfaceC0743A.a aVar2 = null;
            if (cls != null) {
                try {
                    aVar = (InterfaceC0743A.a) cls.getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e7) {
                    e = e7;
                }
                try {
                    aVar.a(bundle);
                    aVar2 = aVar;
                } catch (Exception e8) {
                    e = e8;
                    aVar2 = aVar;
                    Class cls2 = this.f10534c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    return this.f10535d.a(view, aVar2);
                }
            }
            return this.f10535d.a(view, aVar2);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f10532a;
            return obj2 == null ? aVar.f10532a == null : obj2.equals(aVar.f10532a);
        }

        public int hashCode() {
            Object obj = this.f10532a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strI = x.i(this.f10533b);
            if (strI.equals("ACTION_UNKNOWN") && c() != null) {
                strI = c().toString();
            }
            sb.append(strI);
            return sb.toString();
        }

        public a(int i7, CharSequence charSequence, InterfaceC0743A interfaceC0743A) {
            this(null, i7, charSequence, interfaceC0743A, null);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i7, CharSequence charSequence, Class cls) {
            this(null, i7, charSequence, null, cls);
        }

        public a(Object obj, int i7, CharSequence charSequence, InterfaceC0743A interfaceC0743A, Class cls) {
            this.f10533b = i7;
            this.f10535d = interfaceC0743A;
            if (obj == null) {
                this.f10532a = new AccessibilityNodeInfo.AccessibilityAction(i7, charSequence);
            } else {
                this.f10532a = obj;
            }
            this.f10534c = cls;
        }
    }

    public static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    public static class c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    public static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    public static class e {
        public static int b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getChecked();
        }

        public static int c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExpandedState();
        }

        public static CharSequence d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getSupplementalDescription();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isFieldRequired();
        }
    }

    public static class f {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_EXTENDED_SELECTION;
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final Object f10536a;

        public g(Object obj) {
            this.f10536a = obj;
        }

        public static g a(int i7, int i8, boolean z7, int i9) {
            return new g(AccessibilityNodeInfo.CollectionInfo.obtain(i7, i8, z7, i9));
        }
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public final Object f10537a;

        public h(Object obj) {
            this.f10537a = obj;
        }

        public static h a(int i7, int i8, int i9, int i10, boolean z7, boolean z8) {
            return new h(AccessibilityNodeInfo.CollectionItemInfo.obtain(i7, i8, i9, i10, z7, z8));
        }
    }

    public x(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f10484a = accessibilityNodeInfo;
    }

    public static x P0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new x(accessibilityNodeInfo);
    }

    public static x d0() {
        return P0(AccessibilityNodeInfo.obtain());
    }

    public static x e0(x xVar) {
        return P0(AccessibilityNodeInfo.obtain(xVar.f10484a));
    }

    public static x f0(View view) {
        return P0(AccessibilityNodeInfo.obtain(view));
    }

    public static String i(int i7) {
        if (i7 == 1) {
            return "ACTION_FOCUS";
        }
        if (i7 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i7) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS /* 32768 */:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i7) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i7) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i7) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        switch (i7) {
                                            case R.id.accessibilityActionScrollInDirection:
                                                return "ACTION_SCROLL_IN_DIRECTION";
                                            case R.id.ALT:
                                                return "ACTION_SET_EXTENDED_SELECTION";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] s(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static String x(int i7) {
        return i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? "UNKNOWN" : "FULL" : "PARTIAL" : "COLLAPSED" : "UNDEFINED";
    }

    public final SparseArray A(View view) {
        SparseArray sparseArrayC = C(view);
        if (sparseArrayC != null) {
            return sparseArrayC;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(J.e.f4310I, sparseArray);
        return sparseArray;
    }

    public void A0(View view) {
        this.f10484a.setLabelFor(view);
    }

    public CharSequence B() {
        return this.f10484a.getPackageName();
    }

    public void B0(int i7) {
        this.f10484a.setMaxTextLength(i7);
    }

    public final SparseArray C(View view) {
        return (SparseArray) view.getTag(J.e.f4310I);
    }

    public void C0(CharSequence charSequence) {
        this.f10484a.setPackageName(charSequence);
    }

    public CharSequence D() {
        return Build.VERSION.SDK_INT >= 30 ? b.a(this.f10484a) : this.f10484a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void D0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f10484a.setPaneTitle(charSequence);
        } else {
            this.f10484a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public CharSequence E() {
        return Build.VERSION.SDK_INT >= 36 ? e.d(this.f10484a) : this.f10484a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY");
    }

    public void E0(View view) {
        this.f10485b = -1;
        this.f10484a.setParent(view);
    }

    public CharSequence F() {
        if (!J()) {
            return this.f10484a.getText();
        }
        List listG = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listG2 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listG3 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listG4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f10484a.getText(), 0, this.f10484a.getText().length()));
        for (int i7 = 0; i7 < listG.size(); i7++) {
            spannableString.setSpan(new C0744a(((Integer) listG4.get(i7)).intValue(), this, y().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listG.get(i7)).intValue(), ((Integer) listG2.get(i7)).intValue(), ((Integer) listG3.get(i7)).intValue());
        }
        return spannableString;
    }

    public void F0(View view, int i7) {
        this.f10485b = i7;
        this.f10484a.setParent(view, i7);
    }

    public CharSequence G() {
        return Build.VERSION.SDK_INT >= 28 ? this.f10484a.getTooltipText() : this.f10484a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void G0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f10484a.setScreenReaderFocusable(z7);
        } else {
            k0(1, z7);
        }
    }

    public String H() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this.f10484a) : this.f10484a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void H0(boolean z7) {
        this.f10484a.setScrollable(z7);
    }

    public String I() {
        return this.f10484a.getViewIdResourceName();
    }

    public void I0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10484a.setShowingHintText(z7);
        } else {
            k0(4, z7);
        }
    }

    public final boolean J() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void J0(View view, int i7) {
        this.f10486c = i7;
        this.f10484a.setSource(view, i7);
    }

    public final int K(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i7)).get())) {
                    return sparseArray.keyAt(i7);
                }
            }
        }
        int i8 = f10483d;
        f10483d = i8 + 1;
        return i8;
    }

    public void K0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.b(this.f10484a, charSequence);
        } else {
            this.f10484a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean L() {
        return Build.VERSION.SDK_INT >= 34 ? d.d(this.f10484a) : k(64);
    }

    public void L0(CharSequence charSequence) {
        this.f10484a.setText(charSequence);
    }

    public boolean M() {
        return this.f10484a.isCheckable();
    }

    public void M0(View view) {
        this.f10484a.setTraversalAfter(view);
    }

    public boolean N() {
        return this.f10484a.isChecked();
    }

    public void N0(boolean z7) {
        this.f10484a.setVisibleToUser(z7);
    }

    public boolean O() {
        return this.f10484a.isClickable();
    }

    public AccessibilityNodeInfo O0() {
        return this.f10484a;
    }

    public boolean P() {
        return this.f10484a.isContextClickable();
    }

    public boolean Q() {
        return this.f10484a.isEnabled();
    }

    public boolean R() {
        return Build.VERSION.SDK_INT >= 36 ? e.e(this.f10484a) : this.f10484a.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY");
    }

    public boolean S() {
        return this.f10484a.isFocusable();
    }

    public boolean T() {
        return this.f10484a.isFocused();
    }

    public boolean U() {
        return k(67108864);
    }

    public boolean V() {
        return this.f10484a.isImportantForAccessibility();
    }

    public boolean W() {
        return this.f10484a.isLongClickable();
    }

    public boolean X() {
        return this.f10484a.isPassword();
    }

    public boolean Y() {
        return this.f10484a.isScrollable();
    }

    public boolean Z() {
        return this.f10484a.isSelected();
    }

    public void a(int i7) {
        this.f10484a.addAction(i7);
    }

    public boolean a0() {
        return Build.VERSION.SDK_INT >= 26 ? this.f10484a.isShowingHintText() : k(4);
    }

    public void b(a aVar) {
        this.f10484a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f10532a);
    }

    public boolean b0() {
        return Build.VERSION.SDK_INT >= 33 ? c.b(this.f10484a) : k(8388608);
    }

    public void c(View view, int i7) {
        this.f10484a.addChild(view, i7);
    }

    public boolean c0() {
        return this.f10484a.isVisibleToUser();
    }

    public final void d(ClickableSpan clickableSpan, Spanned spanned, int i7) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i7));
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            i0(view);
            ClickableSpan[] clickableSpanArrS = s(charSequence);
            if (clickableSpanArrS == null || clickableSpanArrS.length <= 0) {
                return;
            }
            y().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", J.e.f4322a);
            SparseArray sparseArrayA = A(view);
            for (int i7 = 0; i7 < clickableSpanArrS.length; i7++) {
                int iK = K(clickableSpanArrS[i7], sparseArrayA);
                sparseArrayA.put(iK, new WeakReference(clickableSpanArrS[i7]));
                d(clickableSpanArrS[i7], (Spanned) charSequence, iK);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10484a;
        if (accessibilityNodeInfo == null) {
            if (xVar.f10484a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(xVar.f10484a)) {
            return false;
        }
        return this.f10486c == xVar.f10486c && this.f10485b == xVar.f10485b;
    }

    public final void f() {
        this.f10484a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f10484a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f10484a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f10484a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public final List g(String str) {
        ArrayList<Integer> integerArrayList = this.f10484a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f10484a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public boolean g0(int i7, Bundle bundle) {
        return this.f10484a.performAction(i7, bundle);
    }

    public List h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f10484a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(new a(actionList.get(i7)));
        }
        return arrayList;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10484a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void i0(View view) {
        SparseArray sparseArrayC = C(view);
        if (sparseArrayC != null) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < sparseArrayC.size(); i7++) {
                if (((WeakReference) sparseArrayC.valueAt(i7)).get() == null) {
                    arrayList.add(Integer.valueOf(i7));
                }
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                sparseArrayC.remove(((Integer) arrayList.get(i8)).intValue());
            }
        }
    }

    public int j() {
        return this.f10484a.getActions();
    }

    public void j0(boolean z7) {
        this.f10484a.setAccessibilityFocused(z7);
    }

    public final boolean k(int i7) {
        Bundle bundleY = y();
        return bundleY != null && (bundleY.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i7) == i7;
    }

    public final void k0(int i7, boolean z7) {
        Bundle bundleY = y();
        if (bundleY != null) {
            int i8 = bundleY.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i7);
            if (!z7) {
                i7 = 0;
            }
            bundleY.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i7 | i8);
        }
    }

    public void l(Rect rect) {
        this.f10484a.getBoundsInParent(rect);
    }

    public void l0(Rect rect) {
        this.f10484a.setBoundsInParent(rect);
    }

    public void m(Rect rect) {
        this.f10484a.getBoundsInScreen(rect);
    }

    public void m0(Rect rect) {
        this.f10484a.setBoundsInScreen(rect);
    }

    public void n(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f10484a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f10484a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void n0(boolean z7) {
        this.f10484a.setCheckable(z7);
    }

    public int o() {
        return Build.VERSION.SDK_INT >= 36 ? e.b(this.f10484a) : this.f10484a.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY", this.f10484a.isChecked() ? 1 : 0);
    }

    public void o0(boolean z7) {
        this.f10484a.setChecked(z7);
    }

    public final String p() {
        int iO = o();
        return iO == 1 ? "TRUE" : iO == 2 ? "PARTIAL" : "FALSE";
    }

    public void p0(CharSequence charSequence) {
        this.f10484a.setClassName(charSequence);
    }

    public int q() {
        return this.f10484a.getChildCount();
    }

    public void q0(boolean z7) {
        this.f10484a.setClickable(z7);
    }

    public CharSequence r() {
        return this.f10484a.getClassName();
    }

    public void r0(Object obj) {
        this.f10484a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((g) obj).f10536a);
    }

    public void s0(Object obj) {
        this.f10484a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((h) obj).f10537a);
    }

    public CharSequence t() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f10484a) : this.f10484a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void t0(CharSequence charSequence) {
        this.f10484a.setContentDescription(charSequence);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        n(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(B());
        sb.append("; className: ");
        sb.append(r());
        sb.append("; text: ");
        sb.append(F());
        sb.append("; error: ");
        sb.append(v());
        sb.append("; maxTextLength: ");
        sb.append(z());
        sb.append("; stateDescription: ");
        sb.append(D());
        sb.append("; contentDescription: ");
        sb.append(u());
        sb.append("; supplementalDescription: ");
        sb.append(E());
        sb.append("; tooltipText: ");
        sb.append(G());
        sb.append("; viewIdResName: ");
        sb.append(I());
        sb.append("; uniqueId: ");
        sb.append(H());
        sb.append("; checkable: ");
        sb.append(M());
        sb.append("; checked: ");
        sb.append(p());
        sb.append("; fieldRequired: ");
        sb.append(R());
        sb.append("; focusable: ");
        sb.append(S());
        sb.append("; focused: ");
        sb.append(T());
        sb.append("; selected: ");
        sb.append(Z());
        sb.append("; clickable: ");
        sb.append(O());
        sb.append("; longClickable: ");
        sb.append(W());
        sb.append("; contextClickable: ");
        sb.append(P());
        sb.append("; expandedState: ");
        sb.append(x(w()));
        sb.append("; enabled: ");
        sb.append(Q());
        sb.append("; password: ");
        sb.append(X());
        sb.append("; scrollable: " + Y());
        sb.append("; containerTitle: ");
        sb.append(t());
        sb.append("; granularScrollingSupported: ");
        sb.append(U());
        sb.append("; importantForAccessibility: ");
        sb.append(V());
        sb.append("; visible: ");
        sb.append(c0());
        sb.append("; isTextSelectable: ");
        sb.append(b0());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(L());
        sb.append("; [");
        List listH = h();
        for (int i7 = 0; i7 < listH.size(); i7++) {
            a aVar = (a) listH.get(i7);
            String strI = i(aVar.b());
            if (strI.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strI = aVar.c().toString();
            }
            sb.append(strI);
            if (i7 != listH.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f10484a.getContentDescription();
    }

    public void u0(boolean z7) {
        this.f10484a.setEnabled(z7);
    }

    public CharSequence v() {
        return this.f10484a.getError();
    }

    public void v0(CharSequence charSequence) {
        this.f10484a.setError(charSequence);
    }

    public int w() {
        return Build.VERSION.SDK_INT >= 36 ? e.c(this.f10484a) : this.f10484a.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY", 0);
    }

    public void w0(boolean z7) {
        this.f10484a.setFocusable(z7);
    }

    public void x0(boolean z7) {
        this.f10484a.setFocused(z7);
    }

    public Bundle y() {
        return this.f10484a.getExtras();
    }

    public void y0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f10484a.setHeading(z7);
        } else {
            k0(2, z7);
        }
    }

    public int z() {
        return this.f10484a.getMaxTextLength();
    }

    public void z0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10484a.setHintText(charSequence);
        } else {
            this.f10484a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void h0() {
    }
}
