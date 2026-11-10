package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import q.d0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, j, AdapterView.OnItemClickListener {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f11088n = {R.attr.background, R.attr.divider};

    /* renamed from: l, reason: collision with root package name */
    public e f11089l;

    /* renamed from: m, reason: collision with root package name */
    public int f11090m;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.f11089l.L(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar) {
        this.f11089l = eVar;
    }

    public int getWindowAnimations() {
        return this.f11090m;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
        a((g) getAdapter().getItem(i7));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        d0 d0VarV = d0.v(context, attributeSet, f11088n, i7, 0);
        if (d0VarV.s(0)) {
            setBackgroundDrawable(d0VarV.g(0));
        }
        if (d0VarV.s(1)) {
            setDivider(d0VarV.g(1));
        }
        d0VarV.w();
    }
}
