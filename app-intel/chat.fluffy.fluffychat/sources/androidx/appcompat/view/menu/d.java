package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: l, reason: collision with root package name */
    public e f11166l;

    /* renamed from: m, reason: collision with root package name */
    public int f11167m = -1;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11168n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f11169o;

    /* renamed from: p, reason: collision with root package name */
    public final LayoutInflater f11170p;

    /* renamed from: q, reason: collision with root package name */
    public final int f11171q;

    public d(e eVar, LayoutInflater layoutInflater, boolean z7, int i7) {
        this.f11169o = z7;
        this.f11170p = layoutInflater;
        this.f11166l = eVar;
        this.f11171q = i7;
        a();
    }

    public void a() {
        g gVarV = this.f11166l.v();
        if (gVarV != null) {
            ArrayList arrayListZ = this.f11166l.z();
            int size = arrayListZ.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (((g) arrayListZ.get(i7)) == gVarV) {
                    this.f11167m = i7;
                    return;
                }
            }
        }
        this.f11167m = -1;
    }

    public e b() {
        return this.f11166l;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i7) {
        ArrayList arrayListZ = this.f11169o ? this.f11166l.z() : this.f11166l.E();
        int i8 = this.f11167m;
        if (i8 >= 0 && i7 >= i8) {
            i7++;
        }
        return (g) arrayListZ.get(i7);
    }

    public void d(boolean z7) {
        this.f11168n = z7;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11167m < 0 ? (this.f11169o ? this.f11166l.z() : this.f11166l.E()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11170p.inflate(this.f11171q, viewGroup, false);
        }
        int groupId = getItem(i7).getGroupId();
        int i8 = i7 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f11166l.F() && groupId != (i8 >= 0 ? getItem(i8).getGroupId() : groupId));
        j.a aVar = (j.a) view;
        if (this.f11168n) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i7), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
