package d0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import d0.C0973b;

/* renamed from: d0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0972a extends BaseAdapter implements Filterable, C0973b.a {

    /* renamed from: l, reason: collision with root package name */
    public boolean f15093l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15094m;

    /* renamed from: n, reason: collision with root package name */
    public Cursor f15095n;

    /* renamed from: o, reason: collision with root package name */
    public Context f15096o;

    /* renamed from: p, reason: collision with root package name */
    public int f15097p;

    /* renamed from: q, reason: collision with root package name */
    public C0151a f15098q;

    /* renamed from: r, reason: collision with root package name */
    public DataSetObserver f15099r;

    /* renamed from: s, reason: collision with root package name */
    public C0973b f15100s;

    /* renamed from: d0.a$a, reason: collision with other inner class name */
    public class C0151a extends ContentObserver {
        public C0151a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            AbstractC0972a.this.h();
        }
    }

    /* renamed from: d0.a$b */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC0972a abstractC0972a = AbstractC0972a.this;
            abstractC0972a.f15093l = true;
            abstractC0972a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC0972a abstractC0972a = AbstractC0972a.this;
            abstractC0972a.f15093l = false;
            abstractC0972a.notifyDataSetInvalidated();
        }
    }

    public AbstractC0972a(Context context, Cursor cursor, boolean z7) {
        e(context, cursor, z7 ? 1 : 2);
    }

    @Override // d0.C0973b.a
    public void a(Cursor cursor) {
        Cursor cursorI = i(cursor);
        if (cursorI != null) {
            cursorI.close();
        }
    }

    @Override // d0.C0973b.a
    public Cursor b() {
        return this.f15095n;
    }

    @Override // d0.C0973b.a
    public abstract CharSequence convertToString(Cursor cursor);

    public abstract void d(View view, Context context, Cursor cursor);

    public void e(Context context, Cursor cursor, int i7) {
        if ((i7 & 1) == 1) {
            i7 |= 2;
            this.f15094m = true;
        } else {
            this.f15094m = false;
        }
        boolean z7 = cursor != null;
        this.f15095n = cursor;
        this.f15093l = z7;
        this.f15096o = context;
        this.f15097p = z7 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i7 & 2) == 2) {
            this.f15098q = new C0151a();
            this.f15099r = new b();
        } else {
            this.f15098q = null;
            this.f15099r = null;
        }
        if (z7) {
            C0151a c0151a = this.f15098q;
            if (c0151a != null) {
                cursor.registerContentObserver(c0151a);
            }
            DataSetObserver dataSetObserver = this.f15099r;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f15093l || (cursor = this.f15095n) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f15093l) {
            return null;
        }
        this.f15095n.moveToPosition(i7);
        if (view == null) {
            view = f(this.f15096o, this.f15095n, viewGroup);
        }
        d(view, this.f15096o, this.f15095n);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f15100s == null) {
            this.f15100s = new C0973b(this);
        }
        return this.f15100s;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        Cursor cursor;
        if (!this.f15093l || (cursor = this.f15095n) == null) {
            return null;
        }
        cursor.moveToPosition(i7);
        return this.f15095n;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        Cursor cursor;
        if (this.f15093l && (cursor = this.f15095n) != null && cursor.moveToPosition(i7)) {
            return this.f15095n.getLong(this.f15097p);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f15093l) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f15095n.moveToPosition(i7)) {
            if (view == null) {
                view = g(this.f15096o, this.f15095n, viewGroup);
            }
            d(view, this.f15096o, this.f15095n);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i7);
    }

    public void h() {
        Cursor cursor;
        if (!this.f15094m || (cursor = this.f15095n) == null || cursor.isClosed()) {
            return;
        }
        this.f15093l = this.f15095n.requery();
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f15095n;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0151a c0151a = this.f15098q;
            if (c0151a != null) {
                cursor2.unregisterContentObserver(c0151a);
            }
            DataSetObserver dataSetObserver = this.f15099r;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f15095n = cursor;
        if (cursor == null) {
            this.f15097p = -1;
            this.f15093l = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        C0151a c0151a2 = this.f15098q;
        if (c0151a2 != null) {
            cursor.registerContentObserver(c0151a2);
        }
        DataSetObserver dataSetObserver2 = this.f15099r;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.f15097p = cursor.getColumnIndexOrThrow("_id");
        this.f15093l = true;
        notifyDataSetChanged();
        return cursor2;
    }
}
