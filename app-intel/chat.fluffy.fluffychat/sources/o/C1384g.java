package o;

import Z.AbstractC0684b;
import Z.B;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import i.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q.N;
import q.d0;

/* renamed from: o.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1384g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f20262e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f20263f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f20264a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f20265b;

    /* renamed from: c, reason: collision with root package name */
    public Context f20266c;

    /* renamed from: d, reason: collision with root package name */
    public Object f20267d;

    /* renamed from: o.g$a */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class[] f20268c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f20269a;

        /* renamed from: b, reason: collision with root package name */
        public Method f20270b;

        public a(Object obj, String str) {
            this.f20269a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f20270b = cls.getMethod(str, f20268c);
            } catch (Exception e7) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e7);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f20270b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f20270b.invoke(this.f20269a, menuItem)).booleanValue();
                }
                this.f20270b.invoke(this.f20269a, menuItem);
                return true;
            } catch (Exception e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    /* renamed from: o.g$b */
    public class b {

        /* renamed from: A, reason: collision with root package name */
        public AbstractC0684b f20271A;

        /* renamed from: B, reason: collision with root package name */
        public CharSequence f20272B;

        /* renamed from: C, reason: collision with root package name */
        public CharSequence f20273C;

        /* renamed from: D, reason: collision with root package name */
        public ColorStateList f20274D = null;

        /* renamed from: E, reason: collision with root package name */
        public PorterDuff.Mode f20275E = null;

        /* renamed from: a, reason: collision with root package name */
        public Menu f20277a;

        /* renamed from: b, reason: collision with root package name */
        public int f20278b;

        /* renamed from: c, reason: collision with root package name */
        public int f20279c;

        /* renamed from: d, reason: collision with root package name */
        public int f20280d;

        /* renamed from: e, reason: collision with root package name */
        public int f20281e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f20282f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f20283g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20284h;

        /* renamed from: i, reason: collision with root package name */
        public int f20285i;

        /* renamed from: j, reason: collision with root package name */
        public int f20286j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f20287k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f20288l;

        /* renamed from: m, reason: collision with root package name */
        public int f20289m;

        /* renamed from: n, reason: collision with root package name */
        public char f20290n;

        /* renamed from: o, reason: collision with root package name */
        public int f20291o;

        /* renamed from: p, reason: collision with root package name */
        public char f20292p;

        /* renamed from: q, reason: collision with root package name */
        public int f20293q;

        /* renamed from: r, reason: collision with root package name */
        public int f20294r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f20295s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f20296t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f20297u;

        /* renamed from: v, reason: collision with root package name */
        public int f20298v;

        /* renamed from: w, reason: collision with root package name */
        public int f20299w;

        /* renamed from: x, reason: collision with root package name */
        public String f20300x;

        /* renamed from: y, reason: collision with root package name */
        public String f20301y;

        /* renamed from: z, reason: collision with root package name */
        public String f20302z;

        public b(Menu menu) {
            this.f20277a = menu;
            h();
        }

        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f20284h = true;
            i(this.f20277a.add(this.f20278b, this.f20285i, this.f20286j, this.f20287k));
        }

        public SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f20284h = true;
            SubMenu subMenuAddSubMenu = this.f20277a.addSubMenu(this.f20278b, this.f20285i, this.f20286j, this.f20287k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f20284h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, C1384g.this.f20266c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e7) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e7);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C1384g.this.f20266c.obtainStyledAttributes(attributeSet, j.f17297o1);
            this.f20278b = typedArrayObtainStyledAttributes.getResourceId(j.f17307q1, 0);
            this.f20279c = typedArrayObtainStyledAttributes.getInt(j.f17317s1, 0);
            this.f20280d = typedArrayObtainStyledAttributes.getInt(j.f17322t1, 0);
            this.f20281e = typedArrayObtainStyledAttributes.getInt(j.f17327u1, 0);
            this.f20282f = typedArrayObtainStyledAttributes.getBoolean(j.f17312r1, true);
            this.f20283g = typedArrayObtainStyledAttributes.getBoolean(j.f17302p1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            d0 d0VarU = d0.u(C1384g.this.f20266c, attributeSet, j.f17332v1);
            this.f20285i = d0VarU.n(j.f17347y1, 0);
            this.f20286j = (d0VarU.k(j.f17110B1, this.f20279c) & (-65536)) | (d0VarU.k(j.f17115C1, this.f20280d) & 65535);
            this.f20287k = d0VarU.p(j.f17120D1);
            this.f20288l = d0VarU.p(j.f17125E1);
            this.f20289m = d0VarU.n(j.f17337w1, 0);
            this.f20290n = c(d0VarU.o(j.f17130F1));
            this.f20291o = d0VarU.k(j.f17165M1, 4096);
            this.f20292p = c(d0VarU.o(j.f17135G1));
            this.f20293q = d0VarU.k(j.f17185Q1, 4096);
            if (d0VarU.s(j.f17140H1)) {
                this.f20294r = d0VarU.a(j.f17140H1, false) ? 1 : 0;
            } else {
                this.f20294r = this.f20281e;
            }
            this.f20295s = d0VarU.a(j.f17352z1, false);
            this.f20296t = d0VarU.a(j.f17105A1, this.f20282f);
            this.f20297u = d0VarU.a(j.f17342x1, this.f20283g);
            this.f20298v = d0VarU.k(j.f17190R1, -1);
            this.f20302z = d0VarU.o(j.f17145I1);
            this.f20299w = d0VarU.n(j.f17150J1, 0);
            this.f20300x = d0VarU.o(j.f17160L1);
            String strO = d0VarU.o(j.f17155K1);
            this.f20301y = strO;
            boolean z7 = strO != null;
            if (z7 && this.f20299w == 0 && this.f20300x == null) {
                this.f20271A = (AbstractC0684b) e(strO, C1384g.f20263f, C1384g.this.f20265b);
            } else {
                if (z7) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f20271A = null;
            }
            this.f20272B = d0VarU.p(j.f17170N1);
            this.f20273C = d0VarU.p(j.f17195S1);
            if (d0VarU.s(j.f17180P1)) {
                this.f20275E = N.e(d0VarU.k(j.f17180P1, -1), this.f20275E);
            } else {
                this.f20275E = null;
            }
            if (d0VarU.s(j.f17175O1)) {
                this.f20274D = d0VarU.c(j.f17175O1);
            } else {
                this.f20274D = null;
            }
            d0VarU.w();
            this.f20284h = false;
        }

        public void h() {
            this.f20278b = 0;
            this.f20279c = 0;
            this.f20280d = 0;
            this.f20281e = 0;
            this.f20282f = true;
            this.f20283g = true;
        }

        public final void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z7 = false;
            menuItem.setChecked(this.f20295s).setVisible(this.f20296t).setEnabled(this.f20297u).setCheckable(this.f20294r >= 1).setTitleCondensed(this.f20288l).setIcon(this.f20289m);
            int i7 = this.f20298v;
            if (i7 >= 0) {
                menuItem.setShowAsAction(i7);
            }
            if (this.f20302z != null) {
                if (C1384g.this.f20266c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(C1384g.this.b(), this.f20302z));
            }
            if (this.f20294r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof p.c) {
                    ((p.c) menuItem).h(true);
                }
            }
            String str = this.f20300x;
            if (str != null) {
                menuItem.setActionView((View) e(str, C1384g.f20262e, C1384g.this.f20264a));
                z7 = true;
            }
            int i8 = this.f20299w;
            if (i8 > 0) {
                if (z7) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i8);
                }
            }
            AbstractC0684b abstractC0684b = this.f20271A;
            if (abstractC0684b != null) {
                B.a(menuItem, abstractC0684b);
            }
            B.c(menuItem, this.f20272B);
            B.g(menuItem, this.f20273C);
            B.b(menuItem, this.f20290n, this.f20291o);
            B.f(menuItem, this.f20292p, this.f20293q);
            PorterDuff.Mode mode = this.f20275E;
            if (mode != null) {
                B.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f20274D;
            if (colorStateList != null) {
                B.d(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f20262e = clsArr;
        f20263f = clsArr;
    }

    public C1384g(Context context) {
        super(context);
        this.f20266c = context;
        Object[] objArr = {context};
        this.f20264a = objArr;
        this.f20265b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f20267d == null) {
            this.f20267d = a(this.f20266c);
        }
        return this.f20267d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z7 = false;
        boolean z8 = false;
        String str = null;
        while (!z7) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z8 && name2.equals(str)) {
                        z8 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            AbstractC0684b abstractC0684b = bVar.f20271A;
                            if (abstractC0684b == null || !abstractC0684b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z7 = true;
                    }
                }
            } else if (!z8) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z8 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i7, Menu menu) {
        if (!(menu instanceof R.a)) {
            super.inflate(i7, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f20266c.getResources().getLayout(i7);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e7) {
                    throw new InflateException("Error inflating menu XML", e7);
                }
            } catch (XmlPullParserException e8) {
                throw new InflateException("Error inflating menu XML", e8);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
