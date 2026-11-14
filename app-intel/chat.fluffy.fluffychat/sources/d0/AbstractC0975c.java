package d0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: d0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0975c extends AbstractC0973a {

    /* renamed from: t, reason: collision with root package name */
    public int f15104t;

    /* renamed from: u, reason: collision with root package name */
    public int f15105u;

    /* renamed from: v, reason: collision with root package name */
    public LayoutInflater f15106v;

    public AbstractC0975c(Context context, int i7, Cursor cursor, boolean z7) {
        super(context, cursor, z7);
        this.f15105u = i7;
        this.f15104t = i7;
        this.f15106v = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // d0.AbstractC0973a
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15106v.inflate(this.f15105u, viewGroup, false);
    }

    @Override // d0.AbstractC0973a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15106v.inflate(this.f15104t, viewGroup, false);
    }
}
