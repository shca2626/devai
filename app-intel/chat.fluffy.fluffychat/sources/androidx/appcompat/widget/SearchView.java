package androidx.appcompat.widget;

import Z.W;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import d0.AbstractC0972a;
import e0.AbstractC1008a;
import i.AbstractC1145a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import o.InterfaceC1380c;
import q.C1466c;
import q.Y;
import q.d0;
import q.h0;
import q.n0;

/* loaded from: classes.dex */
public class SearchView extends androidx.appcompat.widget.b implements InterfaceC1380c {

    /* renamed from: y0, reason: collision with root package name */
    public static final o f11365y0;

    /* renamed from: A, reason: collision with root package name */
    public final SearchAutoComplete f11366A;

    /* renamed from: B, reason: collision with root package name */
    public final View f11367B;

    /* renamed from: C, reason: collision with root package name */
    public final View f11368C;

    /* renamed from: D, reason: collision with root package name */
    public final View f11369D;

    /* renamed from: E, reason: collision with root package name */
    public final ImageView f11370E;

    /* renamed from: F, reason: collision with root package name */
    public final ImageView f11371F;

    /* renamed from: G, reason: collision with root package name */
    public final ImageView f11372G;

    /* renamed from: H, reason: collision with root package name */
    public final ImageView f11373H;

    /* renamed from: I, reason: collision with root package name */
    public final View f11374I;

    /* renamed from: J, reason: collision with root package name */
    public q f11375J;

    /* renamed from: K, reason: collision with root package name */
    public Rect f11376K;

    /* renamed from: L, reason: collision with root package name */
    public Rect f11377L;

    /* renamed from: M, reason: collision with root package name */
    public int[] f11378M;

    /* renamed from: N, reason: collision with root package name */
    public int[] f11379N;

    /* renamed from: O, reason: collision with root package name */
    public final ImageView f11380O;

    /* renamed from: P, reason: collision with root package name */
    public final Drawable f11381P;

    /* renamed from: Q, reason: collision with root package name */
    public final int f11382Q;

    /* renamed from: R, reason: collision with root package name */
    public final int f11383R;

    /* renamed from: S, reason: collision with root package name */
    public final Intent f11384S;

    /* renamed from: T, reason: collision with root package name */
    public final Intent f11385T;

    /* renamed from: U, reason: collision with root package name */
    public final CharSequence f11386U;

    /* renamed from: V, reason: collision with root package name */
    public View.OnFocusChangeListener f11387V;

    /* renamed from: W, reason: collision with root package name */
    public View.OnClickListener f11388W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f11389a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f11390b0;

    /* renamed from: c0, reason: collision with root package name */
    public AbstractC0972a f11391c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f11392d0;

    /* renamed from: e0, reason: collision with root package name */
    public CharSequence f11393e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f11394f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f11395g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f11396h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f11397i0;

    /* renamed from: j0, reason: collision with root package name */
    public CharSequence f11398j0;

    /* renamed from: k0, reason: collision with root package name */
    public CharSequence f11399k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f11400l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f11401m0;

    /* renamed from: n0, reason: collision with root package name */
    public SearchableInfo f11402n0;

    /* renamed from: o0, reason: collision with root package name */
    public Bundle f11403o0;

    /* renamed from: p0, reason: collision with root package name */
    public final Runnable f11404p0;

    /* renamed from: q0, reason: collision with root package name */
    public Runnable f11405q0;

    /* renamed from: r0, reason: collision with root package name */
    public final WeakHashMap f11406r0;

    /* renamed from: s0, reason: collision with root package name */
    public final View.OnClickListener f11407s0;

    /* renamed from: t0, reason: collision with root package name */
    public View.OnKeyListener f11408t0;

    /* renamed from: u0, reason: collision with root package name */
    public final TextView.OnEditorActionListener f11409u0;

    /* renamed from: v0, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f11410v0;

    /* renamed from: w0, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f11411w0;

    /* renamed from: x0, reason: collision with root package name */
    public TextWatcher f11412x0;

    public static class SearchAutoComplete extends C1466c {

        /* renamed from: p, reason: collision with root package name */
        public int f11413p;

        /* renamed from: q, reason: collision with root package name */
        public SearchView f11414q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f11415r;

        /* renamed from: s, reason: collision with root package name */
        public final Runnable f11416s;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, AbstractC1145a.f16942m);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i7 = configuration.screenWidthDp;
            int i8 = configuration.screenHeightDp;
            if (i7 >= 960 && i8 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i7 < 600) {
                return (i7 < 640 || i8 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f11365y0.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void d() {
            if (this.f11415r) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f11415r = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f11413p <= 0 || super.enoughToFilter();
        }

        @Override // q.C1466c, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f11415r) {
                removeCallbacks(this.f11416s);
                post(this.f11416s);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z7, int i7, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z7, i7, rect);
            this.f11414q.X();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i7, KeyEvent keyEvent) {
            if (i7 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f11414q.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i7, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z7);
            if (z7 && this.f11414q.hasFocus() && getVisibility() == 0) {
                this.f11415r = true;
                if (SearchView.K(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z7) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z7) {
                this.f11415r = false;
                removeCallbacks(this.f11416s);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f11415r = true;
                    return;
                }
                this.f11415r = false;
                removeCallbacks(this.f11416s);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f11414q = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i7) {
            super.setThreshold(i7);
            this.f11413p = i7;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i7) {
            super(context, attributeSet, i7);
            this.f11416s = new a();
            this.f11413p = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            SearchView.this.W(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.d0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0972a abstractC0972a = SearchView.this.f11391c0;
            if (abstractC0972a instanceof Y) {
                abstractC0972a.a(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z7) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f11387V;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z7);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            SearchView.this.z();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SearchView searchView = SearchView.this;
            if (view == searchView.f11370E) {
                searchView.T();
                return;
            }
            if (view == searchView.f11372G) {
                searchView.P();
                return;
            }
            if (view == searchView.f11371F) {
                searchView.U();
            } else if (view == searchView.f11373H) {
                searchView.Y();
            } else if (view == searchView.f11366A) {
                searchView.F();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i7, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f11402n0 == null) {
                return false;
            }
            if (searchView.f11366A.isPopupShowing() && SearchView.this.f11366A.getListSelection() != -1) {
                return SearchView.this.V(view, i7, keyEvent);
            }
            if (SearchView.this.f11366A.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i7 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.N(0, null, searchView2.f11366A.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            SearchView.this.U();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
            SearchView.this.Q(i7, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i7, long j7) {
            SearchView.this.R(i7);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static class k {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i7) {
            searchAutoComplete.setInputMethodMode(i7);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public Method f11428a;

        /* renamed from: b, reason: collision with root package name */
        public Method f11429b;

        /* renamed from: c, reason: collision with root package name */
        public Method f11430c;

        public o() throws NoSuchMethodException, SecurityException {
            this.f11428a = null;
            this.f11429b = null;
            this.f11430c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.f11428a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.f11429b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f11430c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.f11429b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.f11428a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.f11430c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class p extends AbstractC1008a {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public boolean f11431n;

        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public p[] newArray(int i7) {
                return new p[i7];
            }
        }

        public p(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f11431n + "}";
        }

        @Override // e0.AbstractC1008a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeValue(Boolean.valueOf(this.f11431n));
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11431n = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class q extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final View f11432a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f11433b;

        /* renamed from: c, reason: collision with root package name */
        public final Rect f11434c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f11435d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11436e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11437f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f11436e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f11433b = new Rect();
            this.f11435d = new Rect();
            this.f11434c = new Rect();
            a(rect, rect2);
            this.f11432a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f11433b.set(rect);
            this.f11435d.set(rect);
            Rect rect3 = this.f11435d;
            int i7 = this.f11436e;
            rect3.inset(-i7, -i7);
            this.f11434c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z7;
            boolean z8;
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z9 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z8 = this.f11437f;
                    if (z8 && !this.f11435d.contains(x7, y7)) {
                        z9 = z8;
                        z7 = false;
                    }
                } else {
                    if (action == 3) {
                        z8 = this.f11437f;
                        this.f11437f = false;
                    }
                    z7 = true;
                    z9 = false;
                }
                z9 = z8;
                z7 = true;
            } else if (this.f11433b.contains(x7, y7)) {
                this.f11437f = true;
                z7 = true;
            } else {
                z7 = true;
                z9 = false;
            }
            if (!z9) {
                return false;
            }
            if (!z7 || this.f11434c.contains(x7, y7)) {
                Rect rect = this.f11434c;
                motionEvent.setLocation(x7 - rect.left, y7 - rect.top);
            } else {
                motionEvent.setLocation(this.f11432a.getWidth() / 2, this.f11432a.getHeight() / 2);
            }
            return this.f11432a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f11365y0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public static boolean K(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(i.d.f16969e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(i.d.f16970f);
    }

    private void setQuery(CharSequence charSequence) {
        this.f11366A.setText(charSequence);
        this.f11366A.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final Intent A(String str, Uri uri, String str2, String str3, int i7, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f11399k0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f11403o0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i7 != 0) {
            intent.putExtra("action_key", i7);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f11402n0.getSearchActivity());
        return intent;
    }

    public final Intent B(Cursor cursor, int i7, String str) {
        int position;
        String strN;
        try {
            String strN2 = Y.n(cursor, "suggest_intent_action");
            if (strN2 == null) {
                strN2 = this.f11402n0.getSuggestIntentAction();
            }
            if (strN2 == null) {
                strN2 = "android.intent.action.SEARCH";
            }
            String str2 = strN2;
            String strN3 = Y.n(cursor, "suggest_intent_data");
            if (strN3 == null) {
                strN3 = this.f11402n0.getSuggestIntentData();
            }
            if (strN3 != null && (strN = Y.n(cursor, "suggest_intent_data_id")) != null) {
                strN3 = strN3 + "/" + Uri.encode(strN);
            }
            return A(str2, strN3 == null ? null : Uri.parse(strN3), Y.n(cursor, "suggest_intent_extra_data"), Y.n(cursor, "suggest_intent_query"), i7, str);
        } catch (RuntimeException e7) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e7);
            return null;
        }
    }

    public final Intent C(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f11403o0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final Intent D(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void E() {
        this.f11366A.dismissDropDown();
    }

    public void F() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f11366A);
            return;
        }
        o oVar = f11365y0;
        oVar.b(this.f11366A);
        oVar.a(this.f11366A);
    }

    public final void G(View view, Rect rect) {
        view.getLocationInWindow(this.f11378M);
        getLocationInWindow(this.f11379N);
        int[] iArr = this.f11378M;
        int i7 = iArr[1];
        int[] iArr2 = this.f11379N;
        int i8 = i7 - iArr2[1];
        int i9 = iArr[0] - iArr2[0];
        rect.set(i9, i8, view.getWidth() + i9, view.getHeight() + i8);
    }

    public final CharSequence H(CharSequence charSequence) {
        if (!this.f11389a0 || this.f11381P == null) {
            return charSequence;
        }
        int textSize = (int) (this.f11366A.getTextSize() * 1.25d);
        this.f11381P.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f11381P), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean I() {
        SearchableInfo searchableInfo = this.f11402n0;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = this.f11402n0.getVoiceSearchLaunchWebSearch() ? this.f11384S : this.f11402n0.getVoiceSearchLaunchRecognizer() ? this.f11385T : null;
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean J() {
        return this.f11390b0;
    }

    public final boolean L() {
        return (this.f11392d0 || this.f11397i0) && !J();
    }

    public final void M(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e7) {
            Log.e("SearchView", "Failed launch activity: " + intent, e7);
        }
    }

    public void N(int i7, String str, String str2) {
        getContext().startActivity(A("android.intent.action.SEARCH", null, null, str2, i7, str));
    }

    public final boolean O(int i7, int i8, String str) {
        Cursor cursorB = this.f11391c0.b();
        if (cursorB == null || !cursorB.moveToPosition(i7)) {
            return false;
        }
        M(B(cursorB, i8, str));
        return true;
    }

    public void P() {
        if (!TextUtils.isEmpty(this.f11366A.getText())) {
            this.f11366A.setText("");
            this.f11366A.requestFocus();
            this.f11366A.setImeVisibility(true);
        } else if (this.f11389a0) {
            clearFocus();
            i0(true);
        }
    }

    public boolean Q(int i7, int i8, String str) {
        O(i7, 0, null);
        this.f11366A.setImeVisibility(false);
        E();
        return true;
    }

    public boolean R(int i7) {
        a0(i7);
        return true;
    }

    public void S(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void T() {
        i0(false);
        this.f11366A.requestFocus();
        this.f11366A.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f11388W;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void U() {
        Editable text = this.f11366A.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f11402n0 != null) {
            N(0, null, text.toString());
        }
        this.f11366A.setImeVisibility(false);
        E();
    }

    public boolean V(View view, int i7, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f11402n0 != null && this.f11391c0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i7 == 66 || i7 == 84 || i7 == 61) {
                return Q(this.f11366A.getListSelection(), 0, null);
            }
            if (i7 == 21 || i7 == 22) {
                this.f11366A.setSelection(i7 == 21 ? 0 : this.f11366A.length());
                this.f11366A.setListSelection(0);
                this.f11366A.clearListSelection();
                this.f11366A.b();
                return true;
            }
            if (i7 == 19) {
                this.f11366A.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void W(CharSequence charSequence) {
        Editable text = this.f11366A.getText();
        this.f11399k0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        h0(!zIsEmpty);
        j0(zIsEmpty);
        c0();
        g0();
        this.f11398j0 = charSequence.toString();
    }

    public void X() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i0(J());
        Z();
        if (this.f11366A.hasFocus()) {
            F();
        }
    }

    public void Y() {
        SearchableInfo searchableInfo = this.f11402n0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(D(this.f11384S, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(C(this.f11385T, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public final void Z() {
        post(this.f11404p0);
    }

    public final void a0(int i7) {
        Editable text = this.f11366A.getText();
        Cursor cursorB = this.f11391c0.b();
        if (cursorB == null) {
            return;
        }
        if (!cursorB.moveToPosition(i7)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceConvertToString = this.f11391c0.convertToString(cursorB);
        if (charSequenceConvertToString != null) {
            setQuery(charSequenceConvertToString);
        } else {
            setQuery(text);
        }
    }

    public void b0(CharSequence charSequence, boolean z7) {
        this.f11366A.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f11366A;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f11399k0 = charSequence;
        }
        if (!z7 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        U();
    }

    public final void c0() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f11366A.getText());
        this.f11372G.setVisibility(!zIsEmpty || (this.f11389a0 && !this.f11400l0) ? 0 : 8);
        Drawable drawable = this.f11372G.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f11395g0 = true;
        super.clearFocus();
        this.f11366A.clearFocus();
        this.f11366A.setImeVisibility(false);
        this.f11395g0 = false;
    }

    public void d0() {
        int[] iArr = this.f11366A.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f11368C.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f11369D.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void e0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f11366A;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(H(queryHint));
    }

    public final void f0() {
        this.f11366A.setThreshold(this.f11402n0.getSuggestThreshold());
        this.f11366A.setImeOptions(this.f11402n0.getImeOptions());
        int inputType = this.f11402n0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f11402n0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f11366A.setInputType(inputType);
        AbstractC0972a abstractC0972a = this.f11391c0;
        if (abstractC0972a != null) {
            abstractC0972a.a(null);
        }
        if (this.f11402n0.getSuggestAuthority() != null) {
            Y y7 = new Y(getContext(), this, this.f11402n0, this.f11406r0);
            this.f11391c0 = y7;
            this.f11366A.setAdapter(y7);
            ((Y) this.f11391c0).w(this.f11394f0 ? 2 : 1);
        }
    }

    public final void g0() {
        this.f11369D.setVisibility((L() && (this.f11371F.getVisibility() == 0 || this.f11373H.getVisibility() == 0)) ? 0 : 8);
    }

    public int getImeOptions() {
        return this.f11366A.getImeOptions();
    }

    public int getInputType() {
        return this.f11366A.getInputType();
    }

    public int getMaxWidth() {
        return this.f11396h0;
    }

    public CharSequence getQuery() {
        return this.f11366A.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f11393e0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f11402n0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f11386U : getContext().getText(this.f11402n0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f11383R;
    }

    public int getSuggestionRowLayout() {
        return this.f11382Q;
    }

    public AbstractC0972a getSuggestionsAdapter() {
        return this.f11391c0;
    }

    public final void h0(boolean z7) {
        this.f11371F.setVisibility((this.f11392d0 && L() && hasFocus() && (z7 || !this.f11397i0)) ? 0 : 8);
    }

    public final void i0(boolean z7) {
        this.f11390b0 = z7;
        int i7 = 8;
        int i8 = z7 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f11366A.getText());
        this.f11370E.setVisibility(i8);
        h0(!zIsEmpty);
        this.f11367B.setVisibility(z7 ? 8 : 0);
        if (this.f11380O.getDrawable() != null && !this.f11389a0) {
            i7 = 0;
        }
        this.f11380O.setVisibility(i7);
        c0();
        j0(zIsEmpty);
        g0();
    }

    public final void j0(boolean z7) {
        int i7 = 8;
        if (this.f11397i0 && !J() && z7) {
            this.f11371F.setVisibility(8);
            i7 = 0;
        }
        this.f11373H.setVisibility(i7);
    }

    @Override // o.InterfaceC1380c
    public void onActionViewCollapsed() {
        b0("", false);
        clearFocus();
        i0(true);
        this.f11366A.setImeOptions(this.f11401m0);
        this.f11400l0 = false;
    }

    @Override // o.InterfaceC1380c
    public void onActionViewExpanded() {
        if (this.f11400l0) {
            return;
        }
        this.f11400l0 = true;
        int imeOptions = this.f11366A.getImeOptions();
        this.f11401m0 = imeOptions;
        this.f11366A.setImeOptions(imeOptions | 33554432);
        this.f11366A.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f11404p0);
        post(this.f11405q0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        if (z7) {
            G(this.f11366A, this.f11376K);
            Rect rect = this.f11377L;
            Rect rect2 = this.f11376K;
            rect.set(rect2.left, 0, rect2.right, i10 - i8);
            q qVar = this.f11375J;
            if (qVar != null) {
                qVar.a(this.f11377L, this.f11376K);
                return;
            }
            q qVar2 = new q(this.f11377L, this.f11376K, this.f11366A);
            this.f11375J = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public void onMeasure(int i7, int i8) {
        int i9;
        if (J()) {
            super.onMeasure(i7, i8);
            return;
        }
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        if (mode == Integer.MIN_VALUE) {
            int i10 = this.f11396h0;
            size = i10 > 0 ? Math.min(i10, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f11396h0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i9 = this.f11396h0) > 0) {
            size = Math.min(i9, size);
        }
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.b());
        i0(pVar.f11431n);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.f11431n = J();
        return pVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        Z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i7, Rect rect) {
        if (this.f11395g0 || !isFocusable()) {
            return false;
        }
        if (J()) {
            return super.requestFocus(i7, rect);
        }
        boolean zRequestFocus = this.f11366A.requestFocus(i7, rect);
        if (zRequestFocus) {
            i0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f11403o0 = bundle;
    }

    public void setIconified(boolean z7) {
        if (z7) {
            P();
        } else {
            T();
        }
    }

    public void setIconifiedByDefault(boolean z7) {
        if (this.f11389a0 == z7) {
            return;
        }
        this.f11389a0 = z7;
        i0(z7);
        e0();
    }

    public void setImeOptions(int i7) {
        this.f11366A.setImeOptions(i7);
    }

    public void setInputType(int i7) {
        this.f11366A.setInputType(i7);
    }

    public void setMaxWidth(int i7) {
        this.f11396h0 = i7;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f11387V = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f11388W = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f11393e0 = charSequence;
        e0();
    }

    public void setQueryRefinementEnabled(boolean z7) {
        this.f11394f0 = z7;
        AbstractC0972a abstractC0972a = this.f11391c0;
        if (abstractC0972a instanceof Y) {
            ((Y) abstractC0972a).w(z7 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f11402n0 = searchableInfo;
        if (searchableInfo != null) {
            f0();
            e0();
        }
        boolean zI = I();
        this.f11397i0 = zI;
        if (zI) {
            this.f11366A.setPrivateImeOptions("nm");
        }
        i0(J());
    }

    public void setSubmitButtonEnabled(boolean z7) {
        this.f11392d0 = z7;
        i0(J());
    }

    public void setSuggestionsAdapter(AbstractC0972a abstractC0972a) {
        this.f11391c0 = abstractC0972a;
        this.f11366A.setAdapter(abstractC0972a);
    }

    public void z() {
        if (this.f11374I.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f11368C.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = n0.b(this);
            int dimensionPixelSize = this.f11389a0 ? resources.getDimensionPixelSize(i.d.f16967c) + resources.getDimensionPixelSize(i.d.f16968d) : 0;
            this.f11366A.getDropDownBackground().getPadding(rect);
            this.f11366A.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f11366A.setDropDownWidth((((this.f11374I.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16923F);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f11376K = new Rect();
        this.f11377L = new Rect();
        this.f11378M = new int[2];
        this.f11379N = new int[2];
        this.f11404p0 = new b();
        this.f11405q0 = new c();
        this.f11406r0 = new WeakHashMap();
        f fVar = new f();
        this.f11407s0 = fVar;
        this.f11408t0 = new g();
        h hVar = new h();
        this.f11409u0 = hVar;
        i iVar = new i();
        this.f11410v0 = iVar;
        j jVar = new j();
        this.f11411w0 = jVar;
        this.f11412x0 = new a();
        d0 d0VarV = d0.v(context, attributeSet, i.j.f17253f2, i7, 0);
        W.j0(this, context, i.j.f17253f2, attributeSet, d0VarV.r(), i7, 0);
        LayoutInflater.from(context).inflate(d0VarV.n(i.j.f17303p2, i.g.f17082r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(i.f.f17026D);
        this.f11366A = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f11367B = findViewById(i.f.f17064z);
        View viewFindViewById = findViewById(i.f.f17025C);
        this.f11368C = viewFindViewById;
        View viewFindViewById2 = findViewById(i.f.f17032J);
        this.f11369D = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(i.f.f17062x);
        this.f11370E = imageView;
        ImageView imageView2 = (ImageView) findViewById(i.f.f17023A);
        this.f11371F = imageView2;
        ImageView imageView3 = (ImageView) findViewById(i.f.f17063y);
        this.f11372G = imageView3;
        ImageView imageView4 = (ImageView) findViewById(i.f.f17027E);
        this.f11373H = imageView4;
        ImageView imageView5 = (ImageView) findViewById(i.f.f17024B);
        this.f11380O = imageView5;
        W.p0(viewFindViewById, d0VarV.g(i.j.f17308q2));
        W.p0(viewFindViewById2, d0VarV.g(i.j.f17328u2));
        imageView.setImageDrawable(d0VarV.g(i.j.f17323t2));
        imageView2.setImageDrawable(d0VarV.g(i.j.f17293n2));
        imageView3.setImageDrawable(d0VarV.g(i.j.f17278k2));
        imageView4.setImageDrawable(d0VarV.g(i.j.f17338w2));
        imageView5.setImageDrawable(d0VarV.g(i.j.f17323t2));
        this.f11381P = d0VarV.g(i.j.f17318s2);
        h0.a(imageView, getResources().getString(i.h.f17098n));
        this.f11382Q = d0VarV.n(i.j.f17333v2, i.g.f17081q);
        this.f11383R = d0VarV.n(i.j.f17283l2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f11412x0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f11408t0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(d0VarV.a(i.j.f17298o2, true));
        int iF = d0VarV.f(i.j.f17263h2, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.f11386U = d0VarV.p(i.j.f17288m2);
        this.f11393e0 = d0VarV.p(i.j.f17313r2);
        int iK = d0VarV.k(i.j.f17273j2, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = d0VarV.k(i.j.f17268i2, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(d0VarV.a(i.j.f17258g2, true));
        d0VarV.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f11384S = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f11385T = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f11374I = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        i0(this.f11389a0);
        e0();
    }
}
