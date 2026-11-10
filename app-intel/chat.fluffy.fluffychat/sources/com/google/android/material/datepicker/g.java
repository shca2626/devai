package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class g extends BaseAdapter {

    /* renamed from: o, reason: collision with root package name */
    public static final int f14480o;

    /* renamed from: l, reason: collision with root package name */
    public final Calendar f14481l;

    /* renamed from: m, reason: collision with root package name */
    public final int f14482m;

    /* renamed from: n, reason: collision with root package name */
    public final int f14483n;

    static {
        f14480o = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar calendarI = r.i();
        this.f14481l = calendarI;
        this.f14482m = calendarI.getMaximum(7);
        this.f14483n = calendarI.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i7) {
        if (i7 >= this.f14482m) {
            return null;
        }
        return Integer.valueOf(b(i7));
    }

    public final int b(int i7) {
        int i8 = i7 + this.f14483n;
        int i9 = this.f14482m;
        return i8 > i9 ? i8 - i9 : i8;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14482m;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(O2.g.f6875l, viewGroup, false);
        }
        this.f14481l.set(7, b(i7));
        textView.setText(this.f14481l.getDisplayName(7, f14480o, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(O2.h.f6894m), this.f14481l.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public g(int i7) {
        Calendar calendarI = r.i();
        this.f14481l = calendarI;
        this.f14482m = calendarI.getMaximum(7);
        this.f14483n = i7;
    }
}
