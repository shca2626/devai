package androidx.appcompat.app;

import Z.W;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.b;
import androidx.core.widget.NestedScrollView;
import i.AbstractC1146a;
import i.f;
import i.j;
import j.p;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: A, reason: collision with root package name */
    public NestedScrollView f10971A;

    /* renamed from: C, reason: collision with root package name */
    public Drawable f10973C;

    /* renamed from: D, reason: collision with root package name */
    public ImageView f10974D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f10975E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f10976F;

    /* renamed from: G, reason: collision with root package name */
    public View f10977G;

    /* renamed from: H, reason: collision with root package name */
    public ListAdapter f10978H;

    /* renamed from: J, reason: collision with root package name */
    public int f10980J;

    /* renamed from: K, reason: collision with root package name */
    public int f10981K;

    /* renamed from: L, reason: collision with root package name */
    public int f10982L;

    /* renamed from: M, reason: collision with root package name */
    public int f10983M;

    /* renamed from: N, reason: collision with root package name */
    public int f10984N;

    /* renamed from: O, reason: collision with root package name */
    public int f10985O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f10986P;

    /* renamed from: R, reason: collision with root package name */
    public Handler f10988R;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10990a;

    /* renamed from: b, reason: collision with root package name */
    public final p f10991b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f10992c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10993d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f10994e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f10995f;

    /* renamed from: g, reason: collision with root package name */
    public ListView f10996g;

    /* renamed from: h, reason: collision with root package name */
    public View f10997h;

    /* renamed from: i, reason: collision with root package name */
    public int f10998i;

    /* renamed from: j, reason: collision with root package name */
    public int f10999j;

    /* renamed from: k, reason: collision with root package name */
    public int f11000k;

    /* renamed from: l, reason: collision with root package name */
    public int f11001l;

    /* renamed from: m, reason: collision with root package name */
    public int f11002m;

    /* renamed from: o, reason: collision with root package name */
    public Button f11004o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f11005p;

    /* renamed from: q, reason: collision with root package name */
    public Message f11006q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f11007r;

    /* renamed from: s, reason: collision with root package name */
    public Button f11008s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f11009t;

    /* renamed from: u, reason: collision with root package name */
    public Message f11010u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f11011v;

    /* renamed from: w, reason: collision with root package name */
    public Button f11012w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f11013x;

    /* renamed from: y, reason: collision with root package name */
    public Message f11014y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f11015z;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11003n = false;

    /* renamed from: B, reason: collision with root package name */
    public int f10972B = 0;

    /* renamed from: I, reason: collision with root package name */
    public int f10979I = -1;

    /* renamed from: Q, reason: collision with root package name */
    public int f10987Q = 0;

    /* renamed from: S, reason: collision with root package name */
    public final View.OnClickListener f10989S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: l, reason: collision with root package name */
        public final int f11016l;

        /* renamed from: m, reason: collision with root package name */
        public final int f11017m;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f17238c2);
            this.f11017m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(j.f17243d2, -1);
            this.f11016l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(j.f17248e2, -1);
        }

        public void a(boolean z7, boolean z8) {
            if (z8 && z7) {
                return;
            }
            setPadding(getPaddingLeft(), z7 ? getPaddingTop() : this.f11016l, getPaddingRight(), z8 ? getPaddingBottom() : this.f11017m);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f11004o || (message3 = alertController.f11006q) == null) ? (view != alertController.f11008s || (message2 = alertController.f11010u) == null) ? (view != alertController.f11012w || (message = alertController.f11014y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f10988R.obtainMessage(1, alertController2.f10991b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: A, reason: collision with root package name */
        public int f11019A;

        /* renamed from: B, reason: collision with root package name */
        public int f11020B;

        /* renamed from: C, reason: collision with root package name */
        public int f11021C;

        /* renamed from: D, reason: collision with root package name */
        public int f11022D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f11024F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f11025G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f11026H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f11028J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f11029K;

        /* renamed from: L, reason: collision with root package name */
        public String f11030L;

        /* renamed from: M, reason: collision with root package name */
        public String f11031M;

        /* renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f11032N;

        /* renamed from: a, reason: collision with root package name */
        public final Context f11034a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f11035b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f11037d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f11039f;

        /* renamed from: g, reason: collision with root package name */
        public View f11040g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f11041h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f11042i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f11043j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f11044k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f11045l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f11046m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f11047n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f11048o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f11049p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f11050q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f11052s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f11053t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f11054u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f11055v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f11056w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f11057x;

        /* renamed from: y, reason: collision with root package name */
        public int f11058y;

        /* renamed from: z, reason: collision with root package name */
        public View f11059z;

        /* renamed from: c, reason: collision with root package name */
        public int f11036c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f11038e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f11023E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f11027I = -1;

        /* renamed from: O, reason: collision with root package name */
        public boolean f11033O = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f11051r = true;

        public class a extends ArrayAdapter {

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f11060l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i7, int i8, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i7, i8, charSequenceArr);
                this.f11060l = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i7, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i7, view, viewGroup);
                boolean[] zArr = b.this.f11024F;
                if (zArr != null && zArr[i7]) {
                    this.f11060l.setItemChecked(i7, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        public class C0095b extends CursorAdapter {

            /* renamed from: l, reason: collision with root package name */
            public final int f11062l;

            /* renamed from: m, reason: collision with root package name */
            public final int f11063m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f11064n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ AlertController f11065o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0095b(Context context, Cursor cursor, boolean z7, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z7);
                this.f11064n = recycleListView;
                this.f11065o = alertController;
                Cursor cursor2 = getCursor();
                this.f11062l = cursor2.getColumnIndexOrThrow(b.this.f11030L);
                this.f11063m = cursor2.getColumnIndexOrThrow(b.this.f11031M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f11062l));
                this.f11064n.setItemChecked(cursor.getPosition(), cursor.getInt(this.f11063m) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f11035b.inflate(this.f11065o.f10983M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ AlertController f11067l;

            public c(AlertController alertController) {
                this.f11067l = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
                b.this.f11057x.onClick(this.f11067l.f10991b, i7);
                if (b.this.f11026H) {
                    return;
                }
                this.f11067l.f10991b.dismiss();
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f11069l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AlertController f11070m;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f11069l = recycleListView;
                this.f11070m = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
                boolean[] zArr = b.this.f11024F;
                if (zArr != null) {
                    zArr[i7] = this.f11069l.isItemChecked(i7);
                }
                b.this.f11028J.onClick(this.f11070m.f10991b, i7, this.f11069l.isItemChecked(i7));
            }
        }

        public b(Context context) {
            this.f11034a = context;
            this.f11035b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            AlertController alertController2;
            View view = this.f11040g;
            if (view != null) {
                alertController.k(view);
            } else {
                CharSequence charSequence = this.f11039f;
                if (charSequence != null) {
                    alertController.p(charSequence);
                }
                Drawable drawable = this.f11037d;
                if (drawable != null) {
                    alertController.m(drawable);
                }
                int i7 = this.f11036c;
                if (i7 != 0) {
                    alertController.l(i7);
                }
                int i8 = this.f11038e;
                if (i8 != 0) {
                    alertController.l(alertController.c(i8));
                }
            }
            CharSequence charSequence2 = this.f11041h;
            if (charSequence2 != null) {
                alertController.n(charSequence2);
            }
            CharSequence charSequence3 = this.f11042i;
            if (charSequence3 == null && this.f11043j == null) {
                alertController2 = alertController;
            } else {
                alertController.j(-1, charSequence3, this.f11044k, null, this.f11043j);
                alertController2 = alertController;
            }
            CharSequence charSequence4 = this.f11045l;
            if (charSequence4 != null || this.f11046m != null) {
                alertController2.j(-2, charSequence4, this.f11047n, null, this.f11046m);
            }
            CharSequence charSequence5 = this.f11048o;
            if (charSequence5 != null || this.f11049p != null) {
                alertController2.j(-3, charSequence5, this.f11050q, null, this.f11049p);
            }
            if (this.f11055v != null || this.f11029K != null || this.f11056w != null) {
                b(alertController2);
            }
            View view2 = this.f11059z;
            if (view2 != null) {
                if (this.f11023E) {
                    alertController2.s(view2, this.f11019A, this.f11020B, this.f11021C, this.f11022D);
                    return;
                } else {
                    alertController2.r(view2);
                    return;
                }
            }
            int i9 = this.f11058y;
            if (i9 != 0) {
                alertController2.q(i9);
            }
        }

        public final void b(AlertController alertController) {
            b bVar;
            AlertController alertController2;
            ListAdapter dVar;
            RecycleListView recycleListView = (RecycleListView) this.f11035b.inflate(alertController.f10982L, (ViewGroup) null);
            if (!this.f11025G) {
                bVar = this;
                alertController2 = alertController;
                int i7 = bVar.f11026H ? alertController2.f10984N : alertController2.f10985O;
                if (bVar.f11029K != null) {
                    dVar = new SimpleCursorAdapter(bVar.f11034a, i7, bVar.f11029K, new String[]{bVar.f11030L}, new int[]{R.id.text1});
                } else {
                    dVar = bVar.f11056w;
                    if (dVar == null) {
                        dVar = new d(bVar.f11034a, i7, R.id.text1, bVar.f11055v);
                    }
                }
            } else if (this.f11029K == null) {
                bVar = this;
                dVar = bVar.new a(this.f11034a, alertController.f10983M, R.id.text1, this.f11055v, recycleListView);
                recycleListView = recycleListView;
                alertController2 = alertController;
            } else {
                bVar = this;
                alertController2 = alertController;
                dVar = bVar.new C0095b(bVar.f11034a, bVar.f11029K, false, recycleListView, alertController2);
            }
            alertController2.f10978H = dVar;
            alertController2.f10979I = bVar.f11027I;
            if (bVar.f11057x != null) {
                recycleListView.setOnItemClickListener(new c(alertController2));
            } else if (bVar.f11028J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = bVar.f11032N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (bVar.f11026H) {
                recycleListView.setChoiceMode(1);
            } else if (bVar.f11025G) {
                recycleListView.setChoiceMode(2);
            }
            alertController2.f10996g = recycleListView;
        }
    }

    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f11072a;

        public c(DialogInterface dialogInterface) {
            this.f11072a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == -3 || i7 == -2 || i7 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f11072a.get(), message.what);
            } else {
                if (i7 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class d extends ArrayAdapter {
        public d(Context context, int i7, int i8, CharSequence[] charSequenceArr) {
            super(context, i7, i8, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, p pVar, Window window) {
        this.f10990a = context;
        this.f10991b = pVar;
        this.f10992c = window;
        this.f10988R = new c(pVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, j.f17128F, AbstractC1146a.f16940k, 0);
        this.f10980J = typedArrayObtainStyledAttributes.getResourceId(j.f17133G, 0);
        this.f10981K = typedArrayObtainStyledAttributes.getResourceId(j.f17143I, 0);
        this.f10982L = typedArrayObtainStyledAttributes.getResourceId(j.f17153K, 0);
        this.f10983M = typedArrayObtainStyledAttributes.getResourceId(j.f17158L, 0);
        this.f10984N = typedArrayObtainStyledAttributes.getResourceId(j.f17168N, 0);
        this.f10985O = typedArrayObtainStyledAttributes.getResourceId(j.f17148J, 0);
        this.f10986P = typedArrayObtainStyledAttributes.getBoolean(j.f17163M, true);
        this.f10993d = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f17138H, 0);
        typedArrayObtainStyledAttributes.recycle();
        pVar.p(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static boolean y(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC1146a.f16939j, typedValue, true);
        return typedValue.data != 0;
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public int c(int i7) {
        TypedValue typedValue = new TypedValue();
        this.f10990a.getTheme().resolveAttribute(i7, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f10996g;
    }

    public void e() {
        this.f10991b.setContentView(i());
        x();
    }

    public boolean f(int i7, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f10971A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean g(int i7, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f10971A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public final ViewGroup h(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int i() {
        int i7 = this.f10981K;
        return i7 == 0 ? this.f10980J : this.f10987Q == 1 ? i7 : this.f10980J;
    }

    public void j(int i7, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f10988R.obtainMessage(i7, onClickListener);
        }
        if (i7 == -3) {
            this.f11013x = charSequence;
            this.f11014y = message;
            this.f11015z = drawable;
        } else if (i7 == -2) {
            this.f11009t = charSequence;
            this.f11010u = message;
            this.f11011v = drawable;
        } else {
            if (i7 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f11005p = charSequence;
            this.f11006q = message;
            this.f11007r = drawable;
        }
    }

    public void k(View view) {
        this.f10977G = view;
    }

    public void l(int i7) {
        this.f10973C = null;
        this.f10972B = i7;
        ImageView imageView = this.f10974D;
        if (imageView != null) {
            if (i7 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f10974D.setImageResource(this.f10972B);
            }
        }
    }

    public void m(Drawable drawable) {
        this.f10973C = drawable;
        this.f10972B = 0;
        ImageView imageView = this.f10974D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f10974D.setImageDrawable(drawable);
            }
        }
    }

    public void n(CharSequence charSequence) {
        this.f10995f = charSequence;
        TextView textView = this.f10976F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void o(ViewGroup viewGroup, View view, int i7, int i8) {
        View viewFindViewById = this.f10992c.findViewById(f.f17060v);
        View viewFindViewById2 = this.f10992c.findViewById(f.f17059u);
        W.C0(view, i7, i8);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    public void p(CharSequence charSequence) {
        this.f10994e = charSequence;
        TextView textView = this.f10975E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(int i7) {
        this.f10997h = null;
        this.f10998i = i7;
        this.f11003n = false;
    }

    public void r(View view) {
        this.f10997h = view;
        this.f10998i = 0;
        this.f11003n = false;
    }

    public void s(View view, int i7, int i8, int i9, int i10) {
        this.f10997h = view;
        this.f10998i = 0;
        this.f11003n = true;
        this.f10999j = i7;
        this.f11000k = i8;
        this.f11001l = i9;
        this.f11002m = i10;
    }

    public final void t(ViewGroup viewGroup) {
        int i7;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f11004o = button;
        button.setOnClickListener(this.f10989S);
        if (TextUtils.isEmpty(this.f11005p) && this.f11007r == null) {
            this.f11004o.setVisibility(8);
            i7 = 0;
        } else {
            this.f11004o.setText(this.f11005p);
            Drawable drawable = this.f11007r;
            if (drawable != null) {
                int i8 = this.f10993d;
                drawable.setBounds(0, 0, i8, i8);
                this.f11004o.setCompoundDrawables(this.f11007r, null, null, null);
            }
            this.f11004o.setVisibility(0);
            i7 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f11008s = button2;
        button2.setOnClickListener(this.f10989S);
        if (TextUtils.isEmpty(this.f11009t) && this.f11011v == null) {
            this.f11008s.setVisibility(8);
        } else {
            this.f11008s.setText(this.f11009t);
            Drawable drawable2 = this.f11011v;
            if (drawable2 != null) {
                int i9 = this.f10993d;
                drawable2.setBounds(0, 0, i9, i9);
                this.f11008s.setCompoundDrawables(this.f11011v, null, null, null);
            }
            this.f11008s.setVisibility(0);
            i7 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f11012w = button3;
        button3.setOnClickListener(this.f10989S);
        if (TextUtils.isEmpty(this.f11013x) && this.f11015z == null) {
            this.f11012w.setVisibility(8);
        } else {
            this.f11012w.setText(this.f11013x);
            Drawable drawable3 = this.f11015z;
            if (drawable3 != null) {
                int i10 = this.f10993d;
                drawable3.setBounds(0, 0, i10, i10);
                this.f11012w.setCompoundDrawables(this.f11015z, null, null, null);
            }
            this.f11012w.setVisibility(0);
            i7 |= 4;
        }
        if (y(this.f10990a)) {
            if (i7 == 1) {
                b(this.f11004o);
            } else if (i7 == 2) {
                b(this.f11008s);
            } else if (i7 == 4) {
                b(this.f11012w);
            }
        }
        if (i7 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void u(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f10992c.findViewById(f.f17061w);
        this.f10971A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f10971A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f10976F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f10995f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f10971A.removeView(this.f10976F);
        if (this.f10996g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f10971A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f10971A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f10996g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void v(ViewGroup viewGroup) {
        View viewInflate = this.f10997h;
        if (viewInflate == null) {
            viewInflate = this.f10998i != 0 ? LayoutInflater.from(this.f10990a).inflate(this.f10998i, viewGroup, false) : null;
        }
        boolean z7 = viewInflate != null;
        if (!z7 || !a(viewInflate)) {
            this.f10992c.setFlags(131072, 131072);
        }
        if (!z7) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f10992c.findViewById(f.f17052n);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f11003n) {
            frameLayout.setPadding(this.f10999j, this.f11000k, this.f11001l, this.f11002m);
        }
        if (this.f10996g != null) {
            ((LinearLayout.LayoutParams) ((b.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    public final void w(ViewGroup viewGroup) {
        if (this.f10977G != null) {
            viewGroup.addView(this.f10977G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f10992c.findViewById(f.f17037O).setVisibility(8);
            return;
        }
        this.f10974D = (ImageView) this.f10992c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f10994e) || !this.f10986P) {
            this.f10992c.findViewById(f.f17037O).setVisibility(8);
            this.f10974D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f10992c.findViewById(f.f17048j);
        this.f10975E = textView;
        textView.setText(this.f10994e);
        int i7 = this.f10972B;
        if (i7 != 0) {
            this.f10974D.setImageResource(i7);
            return;
        }
        Drawable drawable = this.f10973C;
        if (drawable != null) {
            this.f10974D.setImageDrawable(drawable);
        } else {
            this.f10975E.setPadding(this.f10974D.getPaddingLeft(), this.f10974D.getPaddingTop(), this.f10974D.getPaddingRight(), this.f10974D.getPaddingBottom());
            this.f10974D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f10992c.findViewById(f.f17058t);
        View viewFindViewById4 = viewFindViewById3.findViewById(f.f17038P);
        View viewFindViewById5 = viewFindViewById3.findViewById(f.f17051m);
        View viewFindViewById6 = viewFindViewById3.findViewById(f.f17049k);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(f.f17053o);
        v(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(f.f17038P);
        View viewFindViewById8 = viewGroup.findViewById(f.f17051m);
        View viewFindViewById9 = viewGroup.findViewById(f.f17049k);
        ViewGroup viewGroupH = h(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupH2 = h(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupH3 = h(viewFindViewById9, viewFindViewById6);
        u(viewGroupH2);
        t(viewGroupH3);
        w(viewGroupH);
        boolean z7 = viewGroup.getVisibility() != 8;
        boolean z8 = (viewGroupH == null || viewGroupH.getVisibility() == 8) ? 0 : 1;
        boolean z9 = (viewGroupH3 == null || viewGroupH3.getVisibility() == 8) ? false : true;
        if (!z9 && viewGroupH2 != null && (viewFindViewById2 = viewGroupH2.findViewById(f.f17033K)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z8 != 0) {
            NestedScrollView nestedScrollView = this.f10971A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f10995f == null && this.f10996g == null) ? null : viewGroupH.findViewById(f.f17036N);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupH2 != null && (viewFindViewById = viewGroupH2.findViewById(f.f17034L)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f10996g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z8, z9);
        }
        if (!z7) {
            View view = this.f10996g;
            if (view == null) {
                view = this.f10971A;
            }
            if (view != null) {
                o(viewGroupH2, view, z8 | (z9 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f10996g;
        if (listView2 == null || (listAdapter = this.f10978H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i7 = this.f10979I;
        if (i7 > -1) {
            listView2.setItemChecked(i7, true);
            listView2.setSelection(i7);
        }
    }
}
