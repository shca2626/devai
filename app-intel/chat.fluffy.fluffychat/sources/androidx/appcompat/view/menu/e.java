package androidx.appcompat.view.menu;

import Z.AbstractC0685b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class e implements R.a {

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f11172A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f11173a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f11174b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11175c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11176d;

    /* renamed from: e, reason: collision with root package name */
    public a f11177e;

    /* renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f11185m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f11186n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f11187o;

    /* renamed from: p, reason: collision with root package name */
    public View f11188p;

    /* renamed from: x, reason: collision with root package name */
    public g f11196x;

    /* renamed from: z, reason: collision with root package name */
    public boolean f11198z;

    /* renamed from: l, reason: collision with root package name */
    public int f11184l = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11189q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11190r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11191s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f11192t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11193u = false;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f11194v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList f11195w = new CopyOnWriteArrayList();

    /* renamed from: y, reason: collision with root package name */
    public boolean f11197y = false;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f11178f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f11179g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public boolean f11180h = true;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f11181i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f11182j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public boolean f11183k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f11173a = context;
        this.f11174b = context.getResources();
        b0(true);
    }

    public static int B(int i7) {
        int i8 = ((-65536) & i7) >> 16;
        if (i8 >= 0) {
            int[] iArr = f11172A;
            if (i8 < iArr.length) {
                return (i7 & 65535) | (iArr[i8] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static int n(ArrayList arrayList, int i7) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i7) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean A() {
        return this.f11192t;
    }

    public Resources C() {
        return this.f11174b;
    }

    public e D() {
        return this;
    }

    public ArrayList E() {
        if (!this.f11180h) {
            return this.f11179g;
        }
        this.f11179g.clear();
        int size = this.f11178f.size();
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) this.f11178f.get(i7);
            if (gVar.isVisible()) {
                this.f11179g.add(gVar);
            }
        }
        this.f11180h = false;
        this.f11183k = true;
        return this.f11179g;
    }

    public boolean F() {
        return this.f11197y;
    }

    public boolean G() {
        return this.f11175c;
    }

    public boolean H() {
        return this.f11176d;
    }

    public void I(g gVar) {
        this.f11183k = true;
        K(true);
    }

    public void J(g gVar) {
        this.f11180h = true;
        K(true);
    }

    public void K(boolean z7) {
        if (this.f11189q) {
            this.f11190r = true;
            if (z7) {
                this.f11191s = true;
                return;
            }
            return;
        }
        if (z7) {
            this.f11180h = true;
            this.f11183k = true;
        }
        i(z7);
    }

    public boolean L(MenuItem menuItem, int i7) {
        return M(menuItem, null, i7);
    }

    public boolean M(MenuItem menuItem, i iVar, int i7) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        AbstractC0685b abstractC0685bB = gVar.b();
        boolean z7 = abstractC0685bB != null && abstractC0685bB.a();
        if (gVar.j()) {
            boolean zExpandActionView = gVar.expandActionView() | zK;
            if (zExpandActionView) {
                e(true);
            }
            return zExpandActionView;
        }
        if (!gVar.hasSubMenu() && !z7) {
            if ((i7 & 1) == 0) {
                e(true);
            }
            return zK;
        }
        if ((i7 & 4) == 0) {
            e(false);
        }
        if (!gVar.hasSubMenu()) {
            gVar.x(new l(u(), this, gVar));
        }
        l lVar = (l) gVar.getSubMenu();
        if (z7) {
            abstractC0685bB.e(lVar);
        }
        boolean zJ = j(lVar, iVar) | zK;
        if (!zJ) {
            e(true);
        }
        return zJ;
    }

    public final void N(int i7, boolean z7) {
        if (i7 < 0 || i7 >= this.f11178f.size()) {
            return;
        }
        this.f11178f.remove(i7);
        if (z7) {
            K(true);
        }
    }

    public void O(i iVar) {
        Iterator it = this.f11195w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar2 = (i) weakReference.get();
            if (iVar2 == null || iVar2 == iVar) {
                this.f11195w.remove(weakReference);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = getItem(i7);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).P(bundle);
            }
        }
        int i8 = bundle.getInt("android:menu:expandedactionview");
        if (i8 <= 0 || (menuItemFindItem = findItem(i8)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = getItem(i7);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f11177e = aVar;
    }

    public e S(int i7) {
        this.f11184l = i7;
        return this;
    }

    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f11178f.size();
        d0();
        for (int i7 = 0; i7 < size; i7++) {
            g gVar = (g) this.f11178f.get(i7);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    public e U(int i7) {
        W(0, null, i7, null, null);
        return this;
    }

    public e V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    public final void W(int i7, CharSequence charSequence, int i8, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f11188p = view;
            this.f11186n = null;
            this.f11187o = null;
        } else {
            if (i7 > 0) {
                this.f11186n = resourcesC.getText(i7);
            } else if (charSequence != null) {
                this.f11186n = charSequence;
            }
            if (i8 > 0) {
                this.f11187o = L.b.d(u(), i8);
            } else if (drawable != null) {
                this.f11187o = drawable;
            }
            this.f11188p = null;
        }
        K(false);
    }

    public e X(int i7) {
        W(i7, null, 0, null, null);
        return this;
    }

    public e Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    public e Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    public MenuItem a(int i7, int i8, int i9, CharSequence charSequence) {
        int iB = B(i9);
        g gVarG = g(i7, i8, i9, iB, charSequence, this.f11184l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f11185m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f11178f;
        arrayList.add(n(arrayList, iB), gVarG);
        K(true);
        return gVarG;
    }

    public void a0(boolean z7) {
        this.f11198z = z7;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i7, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        int i11;
        PackageManager packageManager = this.f11173a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i10 & 1) == 0) {
            removeGroup(i7);
        }
        for (int i12 = 0; i12 < size; i12++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i12);
            int i13 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i13 < 0 ? intent : intentArr[i13]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i7, i8, i9, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i11 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i11] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(i iVar) {
        c(iVar, this.f11173a);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f11174b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f11173a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f11173a
            boolean r3 = Z.Z.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f11176d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.b0(boolean):void");
    }

    public void c(i iVar, Context context) {
        this.f11195w.add(new WeakReference(iVar));
        iVar.i(context, this);
        this.f11183k = true;
    }

    public void c0() {
        this.f11189q = false;
        if (this.f11190r) {
            this.f11190r = false;
            K(this.f11191s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f11196x;
        if (gVar != null) {
            f(gVar);
        }
        this.f11178f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f11187o = null;
        this.f11186n = null;
        this.f11188p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f11177e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.f11189q) {
            return;
        }
        this.f11189q = true;
        this.f11190r = false;
        this.f11191s = false;
    }

    public final void e(boolean z7) {
        if (this.f11193u) {
            return;
        }
        this.f11193u = true;
        Iterator it = this.f11195w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar = (i) weakReference.get();
            if (iVar == null) {
                this.f11195w.remove(weakReference);
            } else {
                iVar.c(this, z7);
            }
        }
        this.f11193u = false;
    }

    public boolean f(g gVar) {
        boolean zF = false;
        if (!this.f11195w.isEmpty() && this.f11196x == gVar) {
            d0();
            Iterator it = this.f11195w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                i iVar = (i) weakReference.get();
                if (iVar == null) {
                    this.f11195w.remove(weakReference);
                } else {
                    zF = iVar.f(this, gVar);
                    if (zF) {
                        break;
                    }
                }
            }
            c0();
            if (zF) {
                this.f11196x = null;
            }
        }
        return zF;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i7) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            g gVar = (g) this.f11178f.get(i8);
            if (gVar.getItemId() == i7) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i7)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final g g(int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        return new g(this, i7, i8, i9, i10, charSequence, i11);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i7) {
        return (MenuItem) this.f11178f.get(i7);
    }

    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f11177e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f11198z) {
            return true;
        }
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (((g) this.f11178f.get(i7)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i(boolean z7) {
        if (this.f11195w.isEmpty()) {
            return;
        }
        d0();
        Iterator it = this.f11195w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar = (i) weakReference.get();
            if (iVar == null) {
                this.f11195w.remove(weakReference);
            } else {
                iVar.d(z7);
            }
        }
        c0();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i7, KeyEvent keyEvent) {
        return p(i7, keyEvent) != null;
    }

    public final boolean j(l lVar, i iVar) {
        if (this.f11195w.isEmpty()) {
            return false;
        }
        boolean zK = iVar != null ? iVar.k(lVar) : false;
        Iterator it = this.f11195w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar2 = (i) weakReference.get();
            if (iVar2 == null) {
                this.f11195w.remove(weakReference);
            } else if (!zK) {
                zK = iVar2.k(lVar);
            }
        }
        return zK;
    }

    public boolean k(g gVar) {
        boolean zG = false;
        if (this.f11195w.isEmpty()) {
            return false;
        }
        d0();
        Iterator it = this.f11195w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            i iVar = (i) weakReference.get();
            if (iVar == null) {
                this.f11195w.remove(weakReference);
            } else {
                zG = iVar.g(this, gVar);
                if (zG) {
                    break;
                }
            }
        }
        c0();
        if (zG) {
            this.f11196x = gVar;
        }
        return zG;
    }

    public int l(int i7) {
        return m(i7, 0);
    }

    public int m(int i7, int i8) {
        int size = size();
        if (i8 < 0) {
            i8 = 0;
        }
        while (i8 < size) {
            if (((g) this.f11178f.get(i8)).getGroupId() == i7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public int o(int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((g) this.f11178f.get(i8)).getItemId() == i7) {
                return i8;
            }
        }
        return -1;
    }

    public g p(int i7, KeyEvent keyEvent) {
        ArrayList arrayList = this.f11194v;
        arrayList.clear();
        q(arrayList, i7, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean zG = G();
        for (int i8 = 0; i8 < size; i8++) {
            g gVar = (g) arrayList.get(i8);
            char alphabeticShortcut = zG ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zG && alphabeticShortcut == '\b' && i7 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i7, int i8) {
        return L(findItem(i7), i8);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i7, KeyEvent keyEvent, int i8) {
        g gVarP = p(i7, keyEvent);
        boolean zL = gVarP != null ? L(gVarP, i8) : false;
        if ((i8 & 2) != 0) {
            e(true);
        }
        return zL;
    }

    public void q(List list, int i7, KeyEvent keyEvent) {
        boolean zG = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i7 == 67) {
            int size = this.f11178f.size();
            for (int i8 = 0; i8 < size; i8++) {
                g gVar = (g) this.f11178f.get(i8);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i7, keyEvent);
                }
                char alphabeticShortcut = zG ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zG ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zG && alphabeticShortcut == '\b' && i7 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList arrayListE = E();
        if (this.f11183k) {
            Iterator it = this.f11195w.iterator();
            boolean zE = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                i iVar = (i) weakReference.get();
                if (iVar == null) {
                    this.f11195w.remove(weakReference);
                } else {
                    zE |= iVar.e();
                }
            }
            if (zE) {
                this.f11181i.clear();
                this.f11182j.clear();
                int size = arrayListE.size();
                for (int i7 = 0; i7 < size; i7++) {
                    g gVar = (g) arrayListE.get(i7);
                    if (gVar.l()) {
                        this.f11181i.add(gVar);
                    } else {
                        this.f11182j.add(gVar);
                    }
                }
            } else {
                this.f11181i.clear();
                this.f11182j.clear();
                this.f11182j.addAll(E());
            }
            this.f11183k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i7) {
        int iL = l(i7);
        if (iL >= 0) {
            int size = this.f11178f.size() - iL;
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (i8 >= size || ((g) this.f11178f.get(iL)).getGroupId() != i7) {
                    break;
                }
                N(iL, false);
                i8 = i9;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i7) {
        N(o(i7), true);
    }

    public ArrayList s() {
        r();
        return this.f11181i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i7, boolean z7, boolean z8) {
        int size = this.f11178f.size();
        for (int i8 = 0; i8 < size; i8++) {
            g gVar = (g) this.f11178f.get(i8);
            if (gVar.getGroupId() == i7) {
                gVar.t(z8);
                gVar.setCheckable(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f11197y = z7;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i7, boolean z7) {
        int size = this.f11178f.size();
        for (int i8 = 0; i8 < size; i8++) {
            g gVar = (g) this.f11178f.get(i8);
            if (gVar.getGroupId() == i7) {
                gVar.setEnabled(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i7, boolean z7) {
        int size = this.f11178f.size();
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            g gVar = (g) this.f11178f.get(i8);
            if (gVar.getGroupId() == i7 && gVar.y(z7)) {
                z8 = true;
            }
        }
        if (z8) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f11175c = z7;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f11178f.size();
    }

    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f11173a;
    }

    public g v() {
        return this.f11196x;
    }

    public Drawable w() {
        return this.f11187o;
    }

    public CharSequence x() {
        return this.f11186n;
    }

    public View y() {
        return this.f11188p;
    }

    public ArrayList z() {
        r();
        return this.f11182j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i7) {
        return a(0, 0, 0, this.f11174b.getString(i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7) {
        return addSubMenu(0, 0, 0, this.f11174b.getString(i7));
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, CharSequence charSequence) {
        return a(i7, i8, i9, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        g gVar = (g) a(i7, i8, i9, charSequence);
        l lVar = new l(this.f11173a, this, gVar);
        gVar.x(lVar);
        return lVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, int i10) {
        return a(i7, i8, i9, this.f11174b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, int i10) {
        return addSubMenu(i7, i8, i9, this.f11174b.getString(i10));
    }
}
