package io.flutter.view;

import android.R;
import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import g5.C1113a;
import io.flutter.plugin.platform.InterfaceC1185q;
import io.flutter.view.k;
import io.flutter.view.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

/* loaded from: classes.dex */
public class k extends AccessibilityNodeProvider {

    /* renamed from: C, reason: collision with root package name */
    public static final int f17941C = ((g.SCROLL_RIGHT.f18022l | g.SCROLL_LEFT.f18022l) | g.SCROLL_UP.f18022l) | g.SCROLL_DOWN.f18022l;

    /* renamed from: D, reason: collision with root package name */
    public static final int f17942D = ((((((((((EnumC0202k.HAS_CHECKED_STATE.f18061l | EnumC0202k.IS_CHECKED.f18061l) | EnumC0202k.IS_SELECTED.f18061l) | EnumC0202k.IS_TEXT_FIELD.f18061l) | EnumC0202k.IS_FOCUSED.f18061l) | EnumC0202k.HAS_ENABLED_STATE.f18061l) | EnumC0202k.IS_ENABLED.f18061l) | EnumC0202k.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f18061l) | EnumC0202k.HAS_TOGGLED_STATE.f18061l) | EnumC0202k.IS_TOGGLED.f18061l) | EnumC0202k.IS_FOCUSABLE.f18061l) | EnumC0202k.IS_SLIDER.f18061l;

    /* renamed from: E, reason: collision with root package name */
    public static final n[] f17943E = n.values();

    /* renamed from: F, reason: collision with root package name */
    public static int f17944F = 267386881;

    /* renamed from: G, reason: collision with root package name */
    public static int f17945G = -1;

    /* renamed from: H, reason: collision with root package name */
    public static int f17946H = (g.DID_GAIN_ACCESSIBILITY_FOCUS.f18022l & g.DID_LOSE_ACCESSIBILITY_FOCUS.f18022l) & g.SHOW_ON_SCREEN.f18022l;

    /* renamed from: A, reason: collision with root package name */
    public final f f17947A;

    /* renamed from: B, reason: collision with root package name */
    public final f f17948B;

    /* renamed from: a, reason: collision with root package name */
    public final View f17949a;

    /* renamed from: b, reason: collision with root package name */
    public final C1113a f17950b;

    /* renamed from: c, reason: collision with root package name */
    public final AccessibilityManager f17951c;

    /* renamed from: d, reason: collision with root package name */
    public final AccessibilityViewEmbedder f17952d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1185q f17953e;

    /* renamed from: f, reason: collision with root package name */
    public final ContentResolver f17954f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f17955g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f17956h;

    /* renamed from: i, reason: collision with root package name */
    public p f17957i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f17958j;

    /* renamed from: k, reason: collision with root package name */
    public Integer f17959k;

    /* renamed from: l, reason: collision with root package name */
    public int f17960l;

    /* renamed from: m, reason: collision with root package name */
    public String f17961m;

    /* renamed from: n, reason: collision with root package name */
    public p f17962n;

    /* renamed from: o, reason: collision with root package name */
    public p f17963o;

    /* renamed from: p, reason: collision with root package name */
    public p f17964p;

    /* renamed from: q, reason: collision with root package name */
    public final List f17965q;

    /* renamed from: r, reason: collision with root package name */
    public int f17966r;

    /* renamed from: s, reason: collision with root package name */
    public Integer f17967s;

    /* renamed from: t, reason: collision with root package name */
    public m f17968t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f17969u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f17970v;

    /* renamed from: w, reason: collision with root package name */
    public final C1113a.b f17971w;

    /* renamed from: x, reason: collision with root package name */
    public final AccessibilityManager.AccessibilityStateChangeListener f17972x;

    /* renamed from: y, reason: collision with root package name */
    public final AccessibilityManager.TouchExplorationStateChangeListener f17973y;

    /* renamed from: z, reason: collision with root package name */
    public final i f17974z;

    public class a implements C1113a.b {
        public a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            k.this.k0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            k.this.j0(byteBuffer, strArr);
        }

        @Override // g5.C1113a.b
        public void c(int i7) {
            k.this.V(i7, 1);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void d() {
            k.this.U();
        }

        @Override // g5.C1113a.b
        public void e(String str) {
            if (Build.VERSION.SDK_INT >= 36) {
                U4.b.g("AccessibilityBridge", "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
            }
            k.this.f17949a.announceForAccessibility(str);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void f(String str) {
            k.this.d0(str);
        }

        @Override // g5.C1113a.b
        public void g(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent accessibilityEventI = k.this.I(0, 32);
            accessibilityEventI.getText().add(str);
            k.this.W(accessibilityEventI);
        }

        @Override // g5.C1113a.b
        public void h(int i7) {
            k.this.V(i7, 8);
        }

        @Override // g5.C1113a.b
        public void i(int i7) {
            k.this.V(i7, 2);
        }
    }

    public class b implements AccessibilityManager.AccessibilityStateChangeListener {
        public b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z7) {
            if (k.this.f17970v) {
                return;
            }
            if (z7) {
                k.this.f17950b.e();
            } else {
                k.this.a0(false);
                k.this.f17950b.d();
            }
            if (k.this.f17968t != null) {
                k.this.f17968t.a(z7, k.this.f17951c.isTouchExplorationEnabled());
            }
        }
    }

    public class c implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityManager f17977a;

        public c(AccessibilityManager accessibilityManager) {
            this.f17977a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z7) {
            if (k.this.f17970v) {
                return;
            }
            if (!z7) {
                k.this.a0(false);
                k.this.N();
            }
            if (k.this.f17968t != null) {
                k.this.f17968t.a(this.f17977a.isEnabled(), z7);
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17979a;

        static {
            int[] iArr = new int[m.d.values().length];
            f17979a = iArr;
            try {
                iArr[m.d.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17979a[m.d.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum e {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64),
        NO_ANNOUNCE(128),
        NO_AUTO_PLAY_ANIMATED_IMAGES(256),
        NO_AUTO_PLAY_VIDEOS(512),
        DETERMINISTIC_CURSOR(1024);


        /* renamed from: l, reason: collision with root package name */
        public final int f17992l;

        e(int i7) {
            this.f17992l = i7;
        }
    }

    public abstract class f extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final e f17993a;

        public f(e eVar) {
            super(new Handler());
            this.f17993a = eVar;
        }

        public void a() {
            k.this.i0(this.f17993a, b());
        }

        public abstract boolean b();

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            onChange(z7, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7, Uri uri) {
            if (k.this.f17970v) {
                return;
            }
            k.this.i0(this.f17993a, b());
        }
    }

    public enum g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152),
        FOCUS(4194304),
        SCROLL_TO_OFFSET(8388608),
        EXPAND(16777216),
        COLLAPSE(33554432);


        /* renamed from: l, reason: collision with root package name */
        public final int f18022l;

        g(int i7) {
            this.f18022l = i7;
        }
    }

    public static class h {
        public static boolean a(Configuration configuration) {
            int i7 = configuration.fontWeightAdjustment;
            return i7 != Integer.MAX_VALUE && i7 >= 300;
        }
    }

    public interface i {
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public int f18023a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f18024b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f18025c = -1;

        /* renamed from: d, reason: collision with root package name */
        public String f18026d;

        /* renamed from: e, reason: collision with root package name */
        public String f18027e;
    }

    /* renamed from: io.flutter.view.k$k, reason: collision with other inner class name */
    public enum EnumC0202k {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728),
        HAS_SELECTED_STATE(268435456),
        HAS_REQUIRED_STATE(536870912),
        IS_REQUIRED(1073741824),
        IS_ACCESSIBILITY_FOCUS_BLOCKED(Integer.MIN_VALUE);


        /* renamed from: l, reason: collision with root package name */
        public final int f18061l;

        EnumC0202k(int i7) {
            this.f18061l = i7;
        }
    }

    public class l extends f {

        /* renamed from: c, reason: collision with root package name */
        public final String f18062c;

        /* renamed from: d, reason: collision with root package name */
        public final float f18063d;

        /* renamed from: e, reason: collision with root package name */
        public final float f18064e;

        public l(e eVar, String str, float f7, float f8) {
            super(eVar);
            this.f18062c = str;
            this.f18063d = f7;
            this.f18064e = f8;
        }

        @Override // io.flutter.view.k.f
        public boolean b() {
            return Settings.Global.getFloat(k.this.f17954f, this.f18062c, this.f18064e) == this.f18063d;
        }
    }

    public interface m {
        void a(boolean z7, boolean z8);
    }

    public enum n {
        NONE(0),
        TAB(1),
        TAB_BAR(2),
        TAB_PANEL(3),
        DIALOG(4),
        ALERT_DIALOG(5),
        TABLE(6),
        CELL(7),
        ROW(8),
        COLUMN_HEADER(9),
        DRAG_HANDLE(10),
        SPIN_BUTTON(11),
        COMBO_BOX(12),
        MENU_BAR(13),
        MENU(14),
        MENU_ITEM(15),
        MENU_ITEM_CHECKBOX(16),
        MENU_ITEM_RADIO(17),
        LIST(18),
        LIST_ITEM(19),
        FORM(20),
        TOOLTIP(21),
        LOADING_SPINNER(22),
        PROGRESS_BAR(23),
        HOTKEY(24),
        RADIO_GROUP(25),
        STATUS(26),
        ALERT(27),
        COMPLEMENTARY(28),
        CONTENT_INFO(29),
        MAIN(30),
        NAVIGATION(31),
        REGION(32);


        /* renamed from: l, reason: collision with root package name */
        public final int f18100l;

        n(int i7) {
            this.f18100l = i7;
        }
    }

    public class o extends f {

        /* renamed from: c, reason: collision with root package name */
        public final String f18101c;

        /* renamed from: d, reason: collision with root package name */
        public final int f18102d;

        public o(k kVar, e eVar, String str) {
            this(eVar, str, 0);
        }

        @Override // io.flutter.view.k.f
        public boolean b() {
            try {
                return Settings.Secure.getInt(k.this.f17954f, this.f18101c) == 1;
            } catch (Settings.SettingNotFoundException unused) {
                U4.b.a("AccessibilityBridge", "Setting not found: " + this.f18101c + ", using default: " + this.f18102d);
                return this.f18102d == 1;
            }
        }

        public o(e eVar, String str, int i7) {
            super(eVar);
            this.f18101c = str;
            this.f18102d = i7;
        }
    }

    public static class p {

        /* renamed from: A, reason: collision with root package name */
        public String f18104A;

        /* renamed from: B, reason: collision with root package name */
        public String f18105B;

        /* renamed from: C, reason: collision with root package name */
        public String f18106C;

        /* renamed from: D, reason: collision with root package name */
        public String f18107D;

        /* renamed from: E, reason: collision with root package name */
        public String f18108E;

        /* renamed from: F, reason: collision with root package name */
        public int f18109F;

        /* renamed from: G, reason: collision with root package name */
        public int f18110G;

        /* renamed from: I, reason: collision with root package name */
        public q f18112I;

        /* renamed from: K, reason: collision with root package name */
        public long f18114K;

        /* renamed from: L, reason: collision with root package name */
        public int f18115L;

        /* renamed from: M, reason: collision with root package name */
        public int f18116M;

        /* renamed from: N, reason: collision with root package name */
        public int f18117N;

        /* renamed from: O, reason: collision with root package name */
        public float f18118O;

        /* renamed from: P, reason: collision with root package name */
        public float f18119P;

        /* renamed from: Q, reason: collision with root package name */
        public float f18120Q;

        /* renamed from: R, reason: collision with root package name */
        public String f18121R;

        /* renamed from: S, reason: collision with root package name */
        public String f18122S;

        /* renamed from: T, reason: collision with root package name */
        public float f18123T;

        /* renamed from: U, reason: collision with root package name */
        public float f18124U;

        /* renamed from: V, reason: collision with root package name */
        public float f18125V;

        /* renamed from: W, reason: collision with root package name */
        public float f18126W;

        /* renamed from: X, reason: collision with root package name */
        public float[] f18127X;

        /* renamed from: Y, reason: collision with root package name */
        public float[] f18128Y;

        /* renamed from: Z, reason: collision with root package name */
        public p f18129Z;

        /* renamed from: a, reason: collision with root package name */
        public final k f18130a;

        /* renamed from: c, reason: collision with root package name */
        public long f18134c;

        /* renamed from: c0, reason: collision with root package name */
        public List f18135c0;

        /* renamed from: d, reason: collision with root package name */
        public int f18136d;

        /* renamed from: d0, reason: collision with root package name */
        public j f18137d0;

        /* renamed from: e, reason: collision with root package name */
        public int f18138e;

        /* renamed from: e0, reason: collision with root package name */
        public j f18139e0;

        /* renamed from: f, reason: collision with root package name */
        public int f18140f;

        /* renamed from: g, reason: collision with root package name */
        public int f18142g;

        /* renamed from: g0, reason: collision with root package name */
        public float[] f18143g0;

        /* renamed from: h, reason: collision with root package name */
        public int f18144h;

        /* renamed from: i, reason: collision with root package name */
        public int f18146i;

        /* renamed from: i0, reason: collision with root package name */
        public float[] f18147i0;

        /* renamed from: j, reason: collision with root package name */
        public int f18148j;

        /* renamed from: j0, reason: collision with root package name */
        public Rect f18149j0;

        /* renamed from: k, reason: collision with root package name */
        public int f18150k;

        /* renamed from: l, reason: collision with root package name */
        public int f18151l;

        /* renamed from: m, reason: collision with root package name */
        public float f18152m;

        /* renamed from: n, reason: collision with root package name */
        public float f18153n;

        /* renamed from: o, reason: collision with root package name */
        public float f18154o;

        /* renamed from: p, reason: collision with root package name */
        public String f18155p;

        /* renamed from: q, reason: collision with root package name */
        public String f18156q;

        /* renamed from: r, reason: collision with root package name */
        public List f18157r;

        /* renamed from: s, reason: collision with root package name */
        public String f18158s;

        /* renamed from: t, reason: collision with root package name */
        public List f18159t;

        /* renamed from: u, reason: collision with root package name */
        public String f18160u;

        /* renamed from: v, reason: collision with root package name */
        public List f18161v;

        /* renamed from: w, reason: collision with root package name */
        public String f18162w;

        /* renamed from: x, reason: collision with root package name */
        public List f18163x;

        /* renamed from: y, reason: collision with root package name */
        public String f18164y;

        /* renamed from: z, reason: collision with root package name */
        public List f18165z;

        /* renamed from: b, reason: collision with root package name */
        public int f18132b = -1;

        /* renamed from: H, reason: collision with root package name */
        public int f18111H = -1;

        /* renamed from: J, reason: collision with root package name */
        public boolean f18113J = false;

        /* renamed from: a0, reason: collision with root package name */
        public List f18131a0 = new ArrayList();

        /* renamed from: b0, reason: collision with root package name */
        public List f18133b0 = new ArrayList();

        /* renamed from: f0, reason: collision with root package name */
        public boolean f18141f0 = true;

        /* renamed from: h0, reason: collision with root package name */
        public boolean f18145h0 = true;

        public p(k kVar) {
            this.f18130a = kVar;
        }

        public static boolean f0(p pVar, Predicate predicate) {
            return (pVar == null || pVar.N(predicate) == null) ? false : true;
        }

        public final void H(List list) {
            if (a0(EnumC0202k.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator it = this.f18131a0.iterator();
            while (it.hasNext()) {
                ((p) it.next()).H(list);
            }
        }

        public final boolean I() {
            if (!this.f18113J) {
                return false;
            }
            EnumC0202k enumC0202k = EnumC0202k.IS_CHECKED;
            if (a0(enumC0202k) != Y(enumC0202k)) {
                return true;
            }
            EnumC0202k enumC0202k2 = EnumC0202k.IS_CHECK_STATE_MIXED;
            if (a0(enumC0202k2) != Y(enumC0202k2)) {
                return true;
            }
            EnumC0202k enumC0202k3 = EnumC0202k.IS_TOGGLED;
            return a0(enumC0202k3) != Y(enumC0202k3);
        }

        public final boolean J() {
            if (!this.f18113J) {
                return false;
            }
            EnumC0202k enumC0202k = EnumC0202k.IS_EXPANDED;
            if (a0(enumC0202k) != Y(enumC0202k)) {
                return true;
            }
            EnumC0202k enumC0202k2 = EnumC0202k.HAS_EXPANDED_STATE;
            return a0(enumC0202k2) != Y(enumC0202k2);
        }

        public final boolean K() {
            String str = this.f18156q;
            if (str == null && this.f18122S == null) {
                return false;
            }
            return str == null || !str.equals(this.f18122S);
        }

        public final boolean L() {
            return (Float.isNaN(this.f18152m) || Float.isNaN(this.f18118O) || this.f18118O == this.f18152m) ? false : true;
        }

        public final void M() {
            if (this.f18141f0) {
                this.f18141f0 = false;
                if (this.f18143g0 == null) {
                    this.f18143g0 = new float[16];
                }
                if (this.f18128Y == null) {
                    float[] fArr = new float[16];
                    this.f18128Y = fArr;
                    Matrix.setIdentityM(fArr, 0);
                }
                if (Matrix.invertM(this.f18143g0, 0, this.f18128Y, 0)) {
                    return;
                }
                Arrays.fill(this.f18143g0, 0.0f);
            }
        }

        public final p N(Predicate predicate) {
            for (p pVar = this.f18129Z; pVar != null; pVar = pVar.f18129Z) {
                if (predicate.test(pVar)) {
                    return pVar;
                }
            }
            return null;
        }

        public final String O() {
            String str = this.f18106C;
            return (str == null || str.isEmpty()) ? this.f18130a.f17961m : this.f18106C;
        }

        public final Rect P() {
            return this.f18149j0;
        }

        public final CharSequence Q() {
            return new io.flutter.view.m().c(this.f18164y).a(this.f18165z).b(O()).e();
        }

        public final CharSequence R() {
            return new io.flutter.view.m().c(this.f18156q).a(this.f18157r).d(this.f18105B).b(O()).e();
        }

        public final String S() {
            String str;
            if (a0(EnumC0202k.NAMES_ROUTE) && (str = this.f18156q) != null && !str.isEmpty()) {
                return this.f18156q;
            }
            Iterator it = this.f18131a0.iterator();
            while (it.hasNext()) {
                String strS = ((p) it.next()).S();
                if (strS != null && !strS.isEmpty()) {
                    return strS;
                }
            }
            return null;
        }

        public final List T(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i7 = byteBuffer.getInt();
            if (i7 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = byteBuffer.getInt();
                int i10 = byteBuffer.getInt();
                m.d dVar = m.d.values()[byteBuffer.getInt()];
                int i11 = d.f17979a[dVar.ordinal()];
                if (i11 == 1) {
                    byteBuffer.getInt();
                    m.b bVar = new m.b();
                    bVar.f18175a = i9;
                    bVar.f18176b = i10;
                    bVar.f18177c = dVar;
                    arrayList.add(bVar);
                } else if (i11 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    m.a aVar = new m.a();
                    aVar.f18175a = i9;
                    aVar.f18176b = i10;
                    aVar.f18177c = dVar;
                    aVar.f18174d = StandardCharsets.UTF_8.decode(byteBuffer2).toString();
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }

        public CharSequence U() {
            CharSequence[] charSequenceArr = {R(), Q()};
            CharSequence charSequenceConcat = null;
            for (int i7 = 0; i7 < 2; i7++) {
                CharSequence charSequence = charSequenceArr[i7];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        public CharSequence V() {
            return new io.flutter.view.m().c(this.f18158s).a(this.f18159t).b(O()).e();
        }

        public CharSequence W() {
            CharSequence[] charSequenceArr = {V(), R(), Q()};
            CharSequence charSequenceConcat = null;
            for (int i7 = 0; i7 < 3; i7++) {
                CharSequence charSequence = charSequenceArr[i7];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        public final boolean X(g gVar) {
            return (gVar.f18022l & this.f18115L) != 0;
        }

        public final boolean Y(EnumC0202k enumC0202k) {
            return (this.f18114K & ((long) enumC0202k.f18061l)) != 0;
        }

        public boolean Z(g gVar) {
            return (gVar.f18022l & this.f18136d) != 0;
        }

        public boolean a0(EnumC0202k enumC0202k) {
            return (this.f18134c & ((long) enumC0202k.f18061l)) != 0;
        }

        public final p b0(float[] fArr, boolean z7) {
            float f7 = fArr[3];
            boolean z8 = false;
            float f8 = fArr[0] / f7;
            float f9 = fArr[1] / f7;
            if (f8 < this.f18123T || f8 >= this.f18125V || f9 < this.f18124U || f9 >= this.f18126W) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (p pVar : this.f18133b0) {
                if (!pVar.a0(EnumC0202k.IS_HIDDEN)) {
                    pVar.M();
                    float[] fArr3 = fArr;
                    Matrix.multiplyMV(fArr2, 0, pVar.f18143g0, 0, fArr3, 0);
                    p pVarB0 = pVar.b0(fArr2, z7);
                    if (pVarB0 != null) {
                        return pVarB0;
                    }
                    fArr = fArr3;
                }
            }
            if (z7 && this.f18146i != -1) {
                z8 = true;
            }
            if (c0() || z8) {
                return this;
            }
            return null;
        }

        public boolean c0() {
            String str;
            String str2;
            String str3;
            if (a0(EnumC0202k.SCOPES_ROUTE)) {
                return false;
            }
            if (a0(EnumC0202k.IS_FOCUSABLE)) {
                return true;
            }
            if (a0(EnumC0202k.IS_ACCESSIBILITY_FOCUS_BLOCKED)) {
                return false;
            }
            return ((this.f18136d & (~k.f17941C)) == 0 && (this.f18134c & ((long) k.f17942D)) == 0 && ((str = this.f18156q) == null || str.isEmpty()) && (((str2 = this.f18158s) == null || str2.isEmpty()) && ((str3 = this.f18164y) == null || str3.isEmpty()))) ? false : true;
        }

        public final float d0(float f7, float f8, float f9, float f10) {
            return Math.max(f7, Math.max(f8, Math.max(f9, f10)));
        }

        public final float e0(float f7, float f8, float f9, float f10) {
            return Math.min(f7, Math.min(f8, Math.min(f9, f10)));
        }

        public boolean g0() {
            if (a0(EnumC0202k.IS_BUTTON)) {
                return true;
            }
            String str = this.f18105B;
            if (str == null || str.isEmpty()) {
                return a0(EnumC0202k.IS_LINK);
            }
            return false;
        }

        public final void h0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f7 = fArr[3];
            fArr[0] = fArr[0] / f7;
            fArr[1] = fArr[1] / f7;
            fArr[2] = fArr[2] / f7;
            fArr[3] = 0.0f;
        }

        public final void i0(float[] fArr, Set set, boolean z7, boolean z8) {
            float[] fArr2;
            set.add(this);
            if (this.f18145h0) {
                z7 = true;
            }
            if (z7) {
                if (this.f18147i0 == null) {
                    this.f18147i0 = new float[16];
                }
                if (z8) {
                    if (this.f18128Y == null) {
                        float[] fArr3 = new float[16];
                        this.f18128Y = fArr3;
                        Matrix.setIdentityM(fArr3, 0);
                    }
                    fArr2 = this.f18128Y;
                } else {
                    if (this.f18127X == null) {
                        float[] fArr4 = new float[16];
                        this.f18127X = fArr4;
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    fArr2 = this.f18127X;
                }
                Matrix.multiplyMM(this.f18147i0, 0, fArr, 0, fArr2, 0);
                float[] fArr5 = {this.f18123T, this.f18124U, 0.0f, 1.0f};
                float[] fArr6 = new float[4];
                float[] fArr7 = new float[4];
                float[] fArr8 = new float[4];
                float[] fArr9 = new float[4];
                h0(fArr6, this.f18147i0, fArr5);
                fArr5[0] = this.f18125V;
                fArr5[1] = this.f18124U;
                h0(fArr7, this.f18147i0, fArr5);
                fArr5[0] = this.f18125V;
                fArr5[1] = this.f18126W;
                h0(fArr8, this.f18147i0, fArr5);
                fArr5[0] = this.f18123T;
                fArr5[1] = this.f18126W;
                h0(fArr9, this.f18147i0, fArr5);
                if (this.f18149j0 == null) {
                    this.f18149j0 = new Rect();
                }
                this.f18149j0.set(Math.round(e0(fArr6[0], fArr7[0], fArr8[0], fArr9[0])), Math.round(e0(fArr6[1], fArr7[1], fArr8[1], fArr9[1])), Math.round(d0(fArr6[0], fArr7[0], fArr8[0], fArr9[0])), Math.round(d0(fArr6[1], fArr7[1], fArr8[1], fArr9[1])));
                this.f18145h0 = false;
            }
            int i7 = -1;
            for (p pVar : this.f18131a0) {
                pVar.f18111H = i7;
                i7 = pVar.f18132b;
                pVar.i0(this.f18147i0, set, z7, false);
            }
            for (p pVar2 : this.f18133b0) {
                if (!set.contains(pVar2)) {
                    pVar2.i0(this.f18147i0, set, z7, true);
                }
            }
        }

        public final void j0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.f18113J = true;
            this.f18121R = this.f18158s;
            this.f18122S = this.f18156q;
            this.f18114K = this.f18134c;
            this.f18115L = this.f18136d;
            this.f18116M = this.f18142g;
            this.f18117N = this.f18144h;
            this.f18118O = this.f18152m;
            this.f18119P = this.f18153n;
            this.f18120Q = this.f18154o;
            this.f18134c = byteBuffer.getLong();
            this.f18136d = byteBuffer.getInt();
            this.f18138e = byteBuffer.getInt();
            this.f18140f = byteBuffer.getInt();
            this.f18142g = byteBuffer.getInt();
            this.f18144h = byteBuffer.getInt();
            this.f18146i = byteBuffer.getInt();
            this.f18148j = byteBuffer.getInt();
            this.f18150k = byteBuffer.getInt();
            this.f18151l = byteBuffer.getInt();
            this.f18152m = byteBuffer.getFloat();
            this.f18153n = byteBuffer.getFloat();
            this.f18154o = byteBuffer.getFloat();
            this.f18109F = byteBuffer.getInt();
            this.f18155p = k.C(byteBuffer, strArr);
            this.f18156q = k.C(byteBuffer, strArr);
            this.f18157r = T(byteBuffer, byteBufferArr);
            this.f18158s = k.C(byteBuffer, strArr);
            this.f18159t = T(byteBuffer, byteBufferArr);
            this.f18160u = k.C(byteBuffer, strArr);
            this.f18161v = T(byteBuffer, byteBufferArr);
            this.f18162w = k.C(byteBuffer, strArr);
            this.f18163x = T(byteBuffer, byteBufferArr);
            this.f18164y = k.C(byteBuffer, strArr);
            this.f18165z = T(byteBuffer, byteBufferArr);
            this.f18104A = k.C(byteBuffer, strArr);
            this.f18105B = k.C(byteBuffer, strArr);
            this.f18106C = k.C(byteBuffer, strArr);
            this.f18107D = k.C(byteBuffer, strArr);
            this.f18108E = k.C(byteBuffer, strArr);
            this.f18110G = byteBuffer.getInt();
            this.f18112I = q.d(byteBuffer.getInt());
            this.f18123T = byteBuffer.getFloat();
            this.f18124U = byteBuffer.getFloat();
            this.f18125V = byteBuffer.getFloat();
            this.f18126W = byteBuffer.getFloat();
            this.f18127X = k.y(byteBuffer, this.f18127X);
            this.f18128Y = k.y(byteBuffer, this.f18128Y);
            this.f18141f0 = true;
            this.f18145h0 = true;
            int i7 = byteBuffer.getInt();
            this.f18131a0.clear();
            for (int i8 = 0; i8 < i7; i8++) {
                p pVarA = this.f18130a.A(byteBuffer.getInt());
                pVarA.f18129Z = this;
                this.f18131a0.add(pVarA);
            }
            int i9 = byteBuffer.getInt();
            this.f18133b0.clear();
            for (int i10 = 0; i10 < i9; i10++) {
                p pVarA2 = this.f18130a.A(byteBuffer.getInt());
                pVarA2.f18129Z = this;
                this.f18133b0.add(pVarA2);
            }
            int i11 = byteBuffer.getInt();
            if (i11 == 0) {
                this.f18135c0 = null;
                return;
            }
            List list = this.f18135c0;
            if (list == null) {
                this.f18135c0 = new ArrayList(i11);
            } else {
                list.clear();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                j jVarZ = this.f18130a.z(byteBuffer.getInt());
                int i13 = jVarZ.f18025c;
                if (i13 == g.TAP.f18022l) {
                    this.f18137d0 = jVarZ;
                } else if (i13 == g.LONG_PRESS.f18022l) {
                    this.f18139e0 = jVarZ;
                } else {
                    this.f18135c0.add(jVarZ);
                }
                this.f18135c0.add(jVarZ);
            }
        }
    }

    public enum q {
        UNKNOWN,
        LTR,
        RTL;

        public static q d(int i7) {
            return i7 != 1 ? i7 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public k(View view, C1113a c1113a, AccessibilityManager accessibilityManager, ContentResolver contentResolver, InterfaceC1185q interfaceC1185q) {
        this(view, c1113a, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), interfaceC1185q);
    }

    public static String C(ByteBuffer byteBuffer, String[] strArr) {
        int i7 = byteBuffer.getInt();
        if (i7 == f17945G) {
            return null;
        }
        return strArr[i7];
    }

    public static /* synthetic */ boolean b(p pVar, p pVar2) {
        return pVar2 == pVar;
    }

    public static float[] y(ByteBuffer byteBuffer, float[] fArr) {
        if (fArr == null) {
            fArr = new float[16];
        }
        for (int i7 = 0; i7 < 16; i7++) {
            fArr[i7] = byteBuffer.getFloat();
        }
        return fArr;
    }

    public final p A(int i7) {
        p pVar = (p) this.f17955g.get(Integer.valueOf(i7));
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this);
        pVar2.f18132b = i7;
        this.f17955g.put(Integer.valueOf(i7), pVar2);
        return pVar2;
    }

    public final p B() {
        return (p) this.f17955g.get(0);
    }

    public final void D(float f7, float f8, boolean z7) {
        p pVarB0;
        if (this.f17955g.isEmpty() || (pVarB0 = B().b0(new float[]{f7, f8, 0.0f, 1.0f}, z7)) == this.f17964p) {
            return;
        }
        if (pVarB0 != null) {
            V(pVarB0.f18132b, 128);
        }
        p pVar = this.f17964p;
        if (pVar != null) {
            V(pVar.f18132b, 256);
        }
        this.f17964p = pVarB0;
    }

    public boolean E() {
        return this.f17951c.isEnabled();
    }

    public final boolean F(p pVar) {
        if (pVar.a0(EnumC0202k.SCOPES_ROUTE)) {
            return false;
        }
        return (pVar.W() == null && (pVar.f18136d & (~f17946H)) == 0) ? false : true;
    }

    public boolean G() {
        return this.f17951c.isTouchExplorationEnabled();
    }

    public AccessibilityEvent H(int i7) {
        return AccessibilityEvent.obtain(i7);
    }

    public final AccessibilityEvent I(int i7, int i8) {
        AccessibilityEvent accessibilityEventH = H(i8);
        accessibilityEventH.setPackageName(this.f17949a.getContext().getPackageName());
        accessibilityEventH.setSource(this.f17949a, i7);
        return accessibilityEventH;
    }

    public AccessibilityNodeInfo J(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public AccessibilityNodeInfo K(View view, int i7) {
        return AccessibilityNodeInfo.obtain(view, i7);
    }

    public boolean L(MotionEvent motionEvent) {
        return M(motionEvent, false);
    }

    public boolean M(MotionEvent motionEvent, boolean z7) {
        if (!this.f17951c.isTouchExplorationEnabled() || this.f17955g.isEmpty()) {
            return false;
        }
        p pVarB0 = B().b0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z7);
        if (pVarB0 != null && pVarB0.f18146i != -1) {
            if (z7) {
                return false;
            }
            return this.f17952d.onAccessibilityHoverEvent(pVarB0.f18132b, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            D(motionEvent.getX(), motionEvent.getY(), z7);
        } else {
            if (motionEvent.getAction() != 10) {
                U4.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            N();
        }
        return true;
    }

    public final void N() {
        p pVar = this.f17964p;
        if (pVar != null) {
            V(pVar.f18132b, 256);
            this.f17964p = null;
        }
    }

    public final void O(p pVar) {
        String strS = pVar.S();
        if (strS == null) {
            strS = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Z(strS);
            return;
        }
        AccessibilityEvent accessibilityEventI = I(pVar.f18132b, 32);
        accessibilityEventI.getText().add(strS);
        W(accessibilityEventI);
    }

    public final boolean P(p pVar, int i7, Bundle bundle, boolean z7) {
        int i8 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z8 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i9 = pVar.f18142g;
        int i10 = pVar.f18144h;
        R(pVar, i8, z7, z8);
        if (i9 != pVar.f18142g || i10 != pVar.f18144h) {
            String str = pVar.f18158s;
            if (str == null) {
                str = "";
            }
            AccessibilityEvent accessibilityEventI = I(pVar.f18132b, 8192);
            accessibilityEventI.getText().add(str);
            accessibilityEventI.setFromIndex(pVar.f18142g);
            accessibilityEventI.setToIndex(pVar.f18144h);
            accessibilityEventI.setItemCount(str.length());
            W(accessibilityEventI);
        }
        if (i8 == 1) {
            if (z7) {
                g gVar = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (pVar.Z(gVar)) {
                    this.f17950b.c(i7, gVar, Boolean.valueOf(z8));
                    return true;
                }
            }
            if (z7) {
                return false;
            }
            g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!pVar.Z(gVar2)) {
                return false;
            }
            this.f17950b.c(i7, gVar2, Boolean.valueOf(z8));
            return true;
        }
        if (i8 != 2) {
            return i8 == 4 || i8 == 8 || i8 == 16;
        }
        if (z7) {
            g gVar3 = g.MOVE_CURSOR_FORWARD_BY_WORD;
            if (pVar.Z(gVar3)) {
                this.f17950b.c(i7, gVar3, Boolean.valueOf(z8));
                return true;
            }
        }
        if (z7) {
            return false;
        }
        g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
        if (!pVar.Z(gVar4)) {
            return false;
        }
        this.f17950b.c(i7, gVar4, Boolean.valueOf(z8));
        return true;
    }

    public final boolean Q(p pVar, int i7, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f17950b.c(i7, g.SET_TEXT, string);
        pVar.f18158s = string;
        pVar.f18159t = null;
        return true;
    }

    public final void R(p pVar, int i7, boolean z7, boolean z8) {
        int i8;
        int i9 = pVar.f18144h;
        if (i9 < 0 || pVar.f18142g < 0) {
            return;
        }
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 != 4) {
                    if (i7 == 8 || i7 == 16) {
                        if (z7) {
                            pVar.f18144h = pVar.f18158s.length();
                        } else {
                            pVar.f18144h = 0;
                        }
                    }
                } else if (z7 && i9 < pVar.f18158s.length()) {
                    Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(pVar.f18158s.substring(pVar.f18144h));
                    if (matcher.find()) {
                        pVar.f18144h += matcher.start(1);
                    } else {
                        pVar.f18144h = pVar.f18158s.length();
                    }
                } else if (!z7 && pVar.f18144h > 0) {
                    Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(pVar.f18158s.substring(0, pVar.f18144h));
                    if (matcher2.find()) {
                        pVar.f18144h = matcher2.start(1);
                    } else {
                        pVar.f18144h = 0;
                    }
                }
            } else if (z7 && i9 < pVar.f18158s.length()) {
                Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(pVar.f18158s.substring(pVar.f18144h));
                matcher3.find();
                if (matcher3.find()) {
                    pVar.f18144h += matcher3.start(1);
                } else {
                    pVar.f18144h = pVar.f18158s.length();
                }
            } else if (!z7 && pVar.f18144h > 0) {
                Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(pVar.f18158s.substring(0, pVar.f18144h));
                if (matcher4.find()) {
                    pVar.f18144h = matcher4.start(1);
                }
            }
        } else if (z7 && i9 < pVar.f18158s.length()) {
            pVar.f18144h++;
        } else if (!z7 && (i8 = pVar.f18144h) > 0) {
            pVar.f18144h = i8 - 1;
        }
        if (z8) {
            return;
        }
        pVar.f18142g = pVar.f18144h;
    }

    public final void S(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager != null) {
            uiModeManager.addContrastChangeListener(context.getMainExecutor(), AbstractC1194a.a(this.f17974z));
        }
    }

    public void T() {
        this.f17970v = true;
        this.f17953e.n();
        e0(null);
        this.f17951c.removeAccessibilityStateChangeListener(this.f17972x);
        this.f17951c.removeTouchExplorationStateChangeListener(this.f17973y);
        this.f17954f.unregisterContentObserver(this.f17948B);
        this.f17954f.unregisterContentObserver(this.f17947A);
        if (Build.VERSION.SDK_INT >= 34) {
            h0(this.f17949a.getContext());
        }
        this.f17950b.g(null);
    }

    public void U() {
        this.f17955g.clear();
        p pVar = this.f17957i;
        if (pVar != null) {
            V(pVar.f18132b, 65536);
        }
        this.f17957i = null;
        this.f17964p = null;
        Y(0, 1);
    }

    public void V(int i7, int i8) {
        if (this.f17951c.isEnabled()) {
            W(I(i7, i8));
        }
    }

    public final void W(AccessibilityEvent accessibilityEvent) {
        if (this.f17951c.isEnabled()) {
            this.f17949a.getParent().requestSendAccessibilityEvent(this.f17949a, accessibilityEvent);
        }
    }

    public final void X() {
        this.f17950b.f(this.f17960l);
    }

    public final void Y(int i7, int i8) {
        AccessibilityEvent accessibilityEventI = I(i7, 2048);
        accessibilityEventI.setContentChangeTypes(i8);
        W(accessibilityEventI);
    }

    public final void Z(String str) {
        this.f17949a.setAccessibilityPaneTitle(str);
    }

    public final void a0(boolean z7) {
        if (this.f17969u == z7) {
            return;
        }
        this.f17969u = z7;
        i0(e.ACCESSIBLE_NAVIGATION, z7);
    }

    public final void b0() {
        if (this.f17949a.getResources() == null) {
            return;
        }
        i0(e.BOLD_TEXT, h.a(this.f17949a.getResources().getConfiguration()));
    }

    public final void c0() {
        UiModeManager uiModeManager = (UiModeManager) this.f17949a.getContext().getSystemService("uimode");
        if (uiModeManager == null) {
            i0(e.HIGH_CONTRAST, false);
        } else {
            i0(e.HIGH_CONTRAST, uiModeManager.getContrast() > 0.0f);
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i7) {
        boolean z7 = true;
        a0(true);
        if (i7 >= 65536) {
            return this.f17952d.createAccessibilityNodeInfo(i7);
        }
        if (i7 == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = J(this.f17949a);
            this.f17949a.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoJ);
            if (this.f17955g.containsKey(0)) {
                accessibilityNodeInfoJ.addChild(this.f17949a, 0);
            }
            accessibilityNodeInfoJ.setImportantForAccessibility(false);
            return accessibilityNodeInfoJ;
        }
        p pVar = (p) this.f17955g.get(Integer.valueOf(i7));
        if (pVar == null) {
            return null;
        }
        if (pVar.f18146i != -1 && this.f17953e.l(pVar.f18146i)) {
            View viewG = this.f17953e.g(pVar.f18146i);
            if (viewG == null) {
                return null;
            }
            return this.f17952d.getRootNode(viewG, pVar.f18132b, pVar.P());
        }
        AccessibilityNodeInfo accessibilityNodeInfoK = K(this.f17949a, i7);
        accessibilityNodeInfoK.setImportantForAccessibility(F(pVar));
        accessibilityNodeInfoK.setViewIdResourceName("");
        if (pVar.f18155p != null) {
            accessibilityNodeInfoK.setViewIdResourceName(pVar.f18155p);
        }
        accessibilityNodeInfoK.setPackageName(this.f17949a.getContext().getPackageName());
        accessibilityNodeInfoK.setClassName("android.view.View");
        accessibilityNodeInfoK.setSource(this.f17949a, i7);
        C.a(f17943E[pVar.f18109F]).a(accessibilityNodeInfoK, pVar);
        p pVar2 = pVar.f18129Z;
        if (pVar2 != null) {
            accessibilityNodeInfoK.setParent(this.f17949a, pVar2.f18132b);
        } else {
            accessibilityNodeInfoK.setParent(this.f17949a);
        }
        if (pVar.f18111H != -1) {
            accessibilityNodeInfoK.setTraversalAfter(this.f17949a, pVar.f18111H);
        }
        Rect rectP = pVar.P();
        p pVar3 = pVar.f18129Z;
        if (pVar3 != null) {
            Rect rectP2 = pVar3.P();
            Rect rect = new Rect(rectP);
            rect.offset(-rectP2.left, -rectP2.top);
            accessibilityNodeInfoK.setBoundsInParent(rect);
        } else {
            accessibilityNodeInfoK.setBoundsInParent(rectP);
        }
        accessibilityNodeInfoK.setBoundsInScreen(x(rectP));
        accessibilityNodeInfoK.setVisibleToUser(true);
        if (pVar.a0(EnumC0202k.HAS_ENABLED_STATE) && !pVar.a0(EnumC0202k.IS_ENABLED)) {
            z7 = false;
        }
        accessibilityNodeInfoK.setEnabled(z7);
        for (p pVar4 : pVar.f18131a0) {
            if (!pVar4.a0(EnumC0202k.IS_HIDDEN)) {
                if (pVar4.f18146i != -1) {
                    View viewG2 = this.f17953e.g(pVar4.f18146i);
                    if (!this.f17953e.l(pVar4.f18146i) && viewG2 != null) {
                        viewG2.setImportantForAccessibility(0);
                        accessibilityNodeInfoK.addChild(viewG2);
                    }
                }
                accessibilityNodeInfoK.addChild(this.f17949a, pVar4.f18132b);
            }
        }
        return accessibilityNodeInfoK;
    }

    public void d0(String str) {
        this.f17961m = str;
    }

    public void e0(m mVar) {
        this.f17968t = mVar;
    }

    public boolean f0(final p pVar) {
        if (pVar.f18148j > 1) {
            return p.f0(this.f17957i, new Predicate() { // from class: io.flutter.view.i
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return k.b(pVar, (k.p) obj);
                }
            }) || !p.f0(this.f17957i, new Predicate() { // from class: io.flutter.view.j
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((k.p) obj).a0(k.EnumC0202k.HAS_IMPLICIT_SCROLLING);
                }
            });
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i7) {
        if (i7 == 1) {
            p pVar = this.f17962n;
            if (pVar != null) {
                return createAccessibilityNodeInfo(pVar.f18132b);
            }
            Integer num = this.f17959k;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i7 != 2) {
            return null;
        }
        p pVar2 = this.f17957i;
        if (pVar2 != null) {
            return createAccessibilityNodeInfo(pVar2.f18132b);
        }
        Integer num2 = this.f17958j;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public boolean g0(p pVar) {
        p pVar2 = pVar.f18129Z;
        return pVar2 != null && f0(pVar2) && pVar.f18129Z.a0(EnumC0202k.HAS_IMPLICIT_SCROLLING);
    }

    public final void h0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager != null) {
            uiModeManager.removeContrastChangeListener(AbstractC1194a.a(this.f17974z));
        }
    }

    public final void i0(e eVar, boolean z7) {
        if (z7) {
            this.f17960l = eVar.f17992l | this.f17960l;
        } else {
            this.f17960l = (~eVar.f17992l) & this.f17960l;
        }
        X();
    }

    public void j0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            j jVarZ = z(byteBuffer.getInt());
            jVarZ.f18025c = byteBuffer.getInt();
            jVarZ.f18026d = C(byteBuffer, strArr);
            jVarZ.f18027e = C(byteBuffer, strArr);
        }
    }

    public void k0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        p pVar;
        int i7;
        int i8;
        p pVar2;
        float f7;
        float f8;
        View viewG;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            p pVarA = A(byteBuffer.getInt());
            pVarA.j0(byteBuffer, strArr, byteBufferArr);
            if (!pVarA.a0(EnumC0202k.IS_HIDDEN)) {
                if (pVarA.a0(EnumC0202k.IS_FOCUSED)) {
                    this.f17962n = pVarA;
                }
                if (pVarA.f18113J) {
                    arrayList.add(pVarA);
                }
                if (pVarA.f18146i != -1 && !this.f17953e.l(pVarA.f18146i) && (viewG = this.f17953e.g(pVarA.f18146i)) != null) {
                    viewG.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        p pVarB = B();
        ArrayList arrayList2 = new ArrayList();
        if (pVarB != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            pVarB.i0(fArr, hashSet, false, false);
            pVarB.H(arrayList2);
        }
        int size = arrayList2.size();
        p pVar3 = null;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList2.get(i9);
            i9++;
            p pVar4 = (p) obj;
            if (!this.f17965q.contains(Integer.valueOf(pVar4.f18132b))) {
                pVar3 = pVar4;
            }
        }
        if (pVar3 == null && !arrayList2.isEmpty()) {
            pVar3 = (p) arrayList2.get(arrayList2.size() - 1);
        }
        if (pVar3 != null && (pVar3.f18132b != this.f17966r || arrayList2.size() != this.f17965q.size())) {
            this.f17966r = pVar3.f18132b;
            O(pVar3);
        }
        this.f17965q.clear();
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList2.get(i10);
            i10++;
            this.f17965q.add(Integer.valueOf(((p) obj2).f18132b));
        }
        Iterator it = this.f17955g.entrySet().iterator();
        while (it.hasNext()) {
            p pVar5 = (p) ((Map.Entry) it.next()).getValue();
            if (!hashSet.contains(pVar5)) {
                l0(pVar5);
                it.remove();
            }
        }
        Y(0, 1);
        int size3 = arrayList.size();
        int i11 = 0;
        while (i11 < size3) {
            Object obj3 = arrayList.get(i11);
            i11++;
            p pVar6 = (p) obj3;
            if (pVar6.L()) {
                AccessibilityEvent accessibilityEventI = I(pVar6.f18132b, 4096);
                float f9 = pVar6.f18152m;
                float f10 = pVar6.f18153n;
                if (Float.isInfinite(pVar6.f18153n)) {
                    if (f9 > 70000.0f) {
                        f9 = 70000.0f;
                    }
                    f10 = 100000.0f;
                }
                if (Float.isInfinite(pVar6.f18154o)) {
                    f7 = f10 + 100000.0f;
                    if (f9 < -70000.0f) {
                        f9 = -70000.0f;
                    }
                    f8 = f9 + 100000.0f;
                } else {
                    f7 = f10 - pVar6.f18154o;
                    f8 = f9 - pVar6.f18154o;
                }
                if (pVar6.X(g.SCROLL_UP) || pVar6.X(g.SCROLL_DOWN)) {
                    accessibilityEventI.setScrollY((int) f8);
                    accessibilityEventI.setMaxScrollY((int) f7);
                } else if (pVar6.X(g.SCROLL_LEFT) || pVar6.X(g.SCROLL_RIGHT)) {
                    accessibilityEventI.setScrollX((int) f8);
                    accessibilityEventI.setMaxScrollX((int) f7);
                }
                int i12 = pVar6.f18148j;
                if (i12 > 0) {
                    accessibilityEventI.setItemCount(i12);
                    accessibilityEventI.setFromIndex(pVar6.f18150k);
                    Iterator it2 = pVar6.f18133b0.iterator();
                    int i13 = 0;
                    while (it2.hasNext()) {
                        if (!((p) it2.next()).a0(EnumC0202k.IS_HIDDEN)) {
                            i13++;
                        }
                    }
                    accessibilityEventI.setToIndex((pVar6.f18150k + i13) - 1);
                }
                W(accessibilityEventI);
            }
            if (pVar6.a0(EnumC0202k.IS_LIVE_REGION) && pVar6.K()) {
                Y(pVar6.f18132b, 1);
            }
            if (Build.VERSION.SDK_INT >= 36) {
                if (pVar6.I()) {
                    Y(pVar6.f18132b, 8192);
                }
                if (pVar6.J()) {
                    Y(pVar6.f18132b, 16384);
                }
            }
            p pVar7 = this.f17957i;
            if (pVar7 != null && pVar7.f18132b == pVar6.f18132b) {
                EnumC0202k enumC0202k = EnumC0202k.IS_SELECTED;
                if (!pVar6.Y(enumC0202k) && pVar6.a0(enumC0202k)) {
                    AccessibilityEvent accessibilityEventI2 = I(pVar6.f18132b, 4);
                    accessibilityEventI2.getText().add(pVar6.f18156q);
                    W(accessibilityEventI2);
                }
            }
            p pVar8 = this.f17962n;
            if (pVar8 != null && (i7 = pVar8.f18132b) == (i8 = pVar6.f18132b) && ((pVar2 = this.f17963o) == null || pVar2.f18132b != i7)) {
                this.f17963o = pVar8;
                W(I(i8, 8));
            } else if (pVar8 == null) {
                this.f17963o = null;
            }
            p pVar9 = this.f17962n;
            if (pVar9 != null && pVar9.f18132b == pVar6.f18132b) {
                EnumC0202k enumC0202k2 = EnumC0202k.IS_TEXT_FIELD;
                if (pVar6.Y(enumC0202k2) && pVar6.a0(enumC0202k2) && ((pVar = this.f17957i) == null || pVar.f18132b == this.f17962n.f18132b)) {
                    String str = pVar6.f18121R != null ? pVar6.f18121R : "";
                    String str2 = pVar6.f18158s;
                    String str3 = str2 != null ? str2 : "";
                    AccessibilityEvent accessibilityEventV = v(pVar6.f18132b, str, str3);
                    if (accessibilityEventV != null) {
                        W(accessibilityEventV);
                    }
                    if (pVar6.f18116M != pVar6.f18142g || pVar6.f18117N != pVar6.f18144h) {
                        AccessibilityEvent accessibilityEventI3 = I(pVar6.f18132b, 8192);
                        accessibilityEventI3.getText().add(str3);
                        accessibilityEventI3.setFromIndex(pVar6.f18142g);
                        accessibilityEventI3.setToIndex(pVar6.f18144h);
                        accessibilityEventI3.setItemCount(str3.length());
                        W(accessibilityEventI3);
                    }
                }
            }
        }
    }

    public final void l0(p pVar) {
        View viewG;
        Integer num;
        pVar.f18129Z = null;
        if (pVar.f18146i != -1 && (num = this.f17958j) != null && this.f17952d.platformViewOfNode(num.intValue()) == this.f17953e.g(pVar.f18146i)) {
            V(this.f17958j.intValue(), 65536);
            this.f17958j = null;
        }
        if (pVar.f18146i != -1 && (viewG = this.f17953e.g(pVar.f18146i)) != null) {
            viewG.setImportantForAccessibility(4);
        }
        p pVar2 = this.f17957i;
        if (pVar2 == pVar) {
            V(pVar2.f18132b, 65536);
            this.f17957i = null;
        }
        if (this.f17962n == pVar) {
            this.f17962n = null;
        }
        if (this.f17964p == pVar) {
            this.f17964p = null;
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i7, int i8, Bundle bundle) {
        if (i7 >= 65536) {
            boolean zPerformAction = this.f17952d.performAction(i7, i8, bundle);
            if (zPerformAction && i8 == 128) {
                this.f17958j = null;
            }
            return zPerformAction;
        }
        p pVar = (p) this.f17955g.get(Integer.valueOf(i7));
        if (pVar == null) {
            return false;
        }
        switch (i8) {
            case 16:
                this.f17950b.b(i7, g.TAP);
                return true;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                this.f17950b.b(i7, g.LONG_PRESS);
                return true;
            case 64:
                if (this.f17957i == null) {
                    this.f17949a.invalidate();
                }
                this.f17957i = pVar;
                this.f17950b.b(i7, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap map = new HashMap();
                map.put("type", "didGainFocus");
                map.put("nodeId", Integer.valueOf(pVar.f18132b));
                this.f17950b.f16306a.c(map);
                V(i7, PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS);
                if (pVar.Z(g.INCREASE) || pVar.Z(g.DECREASE)) {
                    V(i7, 4);
                }
                return true;
            case 128:
                p pVar2 = this.f17957i;
                if (pVar2 != null && pVar2.f18132b == i7) {
                    this.f17957i = null;
                }
                Integer num = this.f17958j;
                if (num != null && num.intValue() == i7) {
                    this.f17958j = null;
                }
                this.f17950b.b(i7, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                V(i7, 65536);
                return true;
            case 256:
                return P(pVar, i7, bundle, true);
            case 512:
                return P(pVar, i7, bundle, false);
            case 4096:
                g gVar = g.SCROLL_UP;
                if (pVar.Z(gVar)) {
                    this.f17950b.b(i7, gVar);
                } else {
                    g gVar2 = g.SCROLL_LEFT;
                    if (pVar.Z(gVar2)) {
                        this.f17950b.b(i7, gVar2);
                    } else {
                        g gVar3 = g.INCREASE;
                        if (!pVar.Z(gVar3)) {
                            return false;
                        }
                        pVar.f18158s = pVar.f18160u;
                        pVar.f18159t = pVar.f18161v;
                        V(i7, 4);
                        this.f17950b.b(i7, gVar3);
                    }
                }
                return true;
            case 8192:
                g gVar4 = g.SCROLL_DOWN;
                if (pVar.Z(gVar4)) {
                    this.f17950b.b(i7, gVar4);
                } else {
                    g gVar5 = g.SCROLL_RIGHT;
                    if (pVar.Z(gVar5)) {
                        this.f17950b.b(i7, gVar5);
                    } else {
                        g gVar6 = g.DECREASE;
                        if (!pVar.Z(gVar6)) {
                            return false;
                        }
                        pVar.f18158s = pVar.f18162w;
                        pVar.f18159t = pVar.f18163x;
                        V(i7, 4);
                        this.f17950b.b(i7, gVar6);
                    }
                }
                return true;
            case 16384:
                this.f17950b.b(i7, g.COPY);
                return true;
            case PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS /* 32768 */:
                this.f17950b.b(i7, g.PASTE);
                return true;
            case 65536:
                this.f17950b.b(i7, g.CUT);
                return true;
            case 131072:
                HashMap map2 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    map2.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    map2.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                } else {
                    map2.put("base", Integer.valueOf(pVar.f18144h));
                    map2.put("extent", Integer.valueOf(pVar.f18144h));
                }
                this.f17950b.c(i7, g.SET_SELECTION, map2);
                p pVar3 = (p) this.f17955g.get(Integer.valueOf(i7));
                pVar3.f18142g = ((Integer) map2.get("base")).intValue();
                pVar3.f18144h = ((Integer) map2.get("extent")).intValue();
                return true;
            case 262144:
                this.f17950b.b(i7, g.EXPAND);
                return true;
            case 524288:
                this.f17950b.b(i7, g.COLLAPSE);
                return true;
            case 1048576:
                this.f17950b.b(i7, g.DISMISS);
                return true;
            case 2097152:
                return Q(pVar, i7, bundle);
            case R.id.accessibilityActionShowOnScreen:
                this.f17950b.b(i7, g.SHOW_ON_SCREEN);
                return true;
            default:
                j jVar = (j) this.f17956h.get(Integer.valueOf(i8 - f17944F));
                if (jVar == null) {
                    return false;
                }
                this.f17950b.c(i7, g.CUSTOM_ACTION, Integer.valueOf(jVar.f18024b));
                return true;
        }
    }

    public final AccessibilityEvent v(int i7, String str, String str2) {
        AccessibilityEvent accessibilityEventI = I(i7, 16);
        accessibilityEventI.setBeforeText(str);
        accessibilityEventI.getText().add(str2);
        int i8 = 0;
        while (i8 < str.length() && i8 < str2.length() && str.charAt(i8) == str2.charAt(i8)) {
            i8++;
        }
        if (i8 >= str.length() && i8 >= str2.length()) {
            return null;
        }
        accessibilityEventI.setFromIndex(i8);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i8 && length2 >= i8 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        accessibilityEventI.setRemovedCount((length - i8) + 1);
        accessibilityEventI.setAddedCount((length2 - i8) + 1);
        return accessibilityEventI;
    }

    public boolean w(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.f17952d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.f17952d.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f17959k = recordFlutterId;
            this.f17962n = null;
            return true;
        }
        if (eventType == 128) {
            this.f17964p = null;
            return true;
        }
        if (eventType == 32768) {
            this.f17958j = recordFlutterId;
            this.f17957i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f17959k = null;
        this.f17958j = null;
        return true;
    }

    public final Rect x(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f17949a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    public final j z(int i7) {
        j jVar = (j) this.f17956h.get(Integer.valueOf(i7));
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.f18024b = i7;
        jVar2.f18023a = f17944F + i7;
        this.f17956h.put(Integer.valueOf(i7), jVar2);
        return jVar2;
    }

    public k(View view, C1113a c1113a, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, InterfaceC1185q interfaceC1185q) {
        this.f17955g = new HashMap();
        this.f17956h = new HashMap();
        this.f17960l = 0;
        this.f17965q = new ArrayList();
        this.f17966r = 0;
        this.f17967s = 0;
        this.f17969u = false;
        this.f17970v = false;
        a aVar = new a();
        this.f17971w = aVar;
        b bVar = new b();
        this.f17972x = bVar;
        int i7 = Build.VERSION.SDK_INT;
        this.f17974z = i7 >= 34 ? new io.flutter.view.g(this) : new i() { // from class: io.flutter.view.h
        };
        this.f17949a = view;
        this.f17950b = c1113a;
        this.f17951c = accessibilityManager;
        this.f17954f = contentResolver;
        this.f17952d = accessibilityViewEmbedder;
        this.f17953e = interfaceC1185q;
        c1113a.g(aVar);
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        c cVar = new c(accessibilityManager);
        this.f17973y = cVar;
        cVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(cVar);
        this.f17960l |= e.NO_ANNOUNCE.f17992l;
        l lVar = new l(e.DISABLE_ANIMATIONS, "transition_animation_scale", 0.0f, 1.0f);
        this.f17948B = lVar;
        lVar.a();
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, lVar);
        if (i7 >= 31) {
            b0();
        }
        o oVar = new o(this, e.INVERT_COLORS, "accessibility_display_inversion_enabled");
        this.f17947A = oVar;
        oVar.a();
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, oVar);
        if (i7 >= 34) {
            c0();
            S(view.getContext());
        }
        interfaceC1185q.f(this);
    }
}
