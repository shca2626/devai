package q;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import d0.AbstractC0974c;
import i.AbstractC1145a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class Y extends AbstractC0974c implements View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public final int f21191A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f21192B;

    /* renamed from: C, reason: collision with root package name */
    public int f21193C;

    /* renamed from: D, reason: collision with root package name */
    public ColorStateList f21194D;

    /* renamed from: E, reason: collision with root package name */
    public int f21195E;

    /* renamed from: F, reason: collision with root package name */
    public int f21196F;

    /* renamed from: G, reason: collision with root package name */
    public int f21197G;

    /* renamed from: H, reason: collision with root package name */
    public int f21198H;

    /* renamed from: I, reason: collision with root package name */
    public int f21199I;

    /* renamed from: J, reason: collision with root package name */
    public int f21200J;

    /* renamed from: w, reason: collision with root package name */
    public final SearchView f21201w;

    /* renamed from: x, reason: collision with root package name */
    public final SearchableInfo f21202x;

    /* renamed from: y, reason: collision with root package name */
    public final Context f21203y;

    /* renamed from: z, reason: collision with root package name */
    public final WeakHashMap f21204z;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f21205a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f21206b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f21207c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f21208d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f21209e;

        public a(View view) {
            this.f21205a = (TextView) view.findViewById(R.id.text1);
            this.f21206b = (TextView) view.findViewById(R.id.text2);
            this.f21207c = (ImageView) view.findViewById(R.id.icon1);
            this.f21208d = (ImageView) view.findViewById(R.id.icon2);
            this.f21209e = (ImageView) view.findViewById(i.f.f17055q);
        }
    }

    public Y(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f21192B = false;
        this.f21193C = 1;
        this.f21195E = -1;
        this.f21196F = -1;
        this.f21197G = -1;
        this.f21198H = -1;
        this.f21199I = -1;
        this.f21200J = -1;
        this.f21201w = searchView;
        this.f21202x = searchableInfo;
        this.f21191A = searchView.getSuggestionCommitIconResId();
        this.f21203y = context;
        this.f21204z = weakHashMap;
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    public static String v(Cursor cursor, int i7) {
        if (i7 == -1) {
            return null;
        }
        try {
            return cursor.getString(i7);
        } catch (Exception e7) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e7);
            return null;
        }
    }

    public final void A(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // d0.AbstractC0972a, d0.C0973b.a
    public void a(Cursor cursor) {
        if (this.f21192B) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f21195E = cursor.getColumnIndex("suggest_text_1");
                this.f21196F = cursor.getColumnIndex("suggest_text_2");
                this.f21197G = cursor.getColumnIndex("suggest_text_2_url");
                this.f21198H = cursor.getColumnIndex("suggest_icon_1");
                this.f21199I = cursor.getColumnIndex("suggest_icon_2");
                this.f21200J = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e7) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e7);
        }
    }

    @Override // d0.C0973b.a
    public Cursor c(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f21201w.getVisibility() == 0 && this.f21201w.getWindowVisibility() == 0) {
            try {
                Cursor cursorU = u(this.f21202x, string, 50);
                if (cursorU != null) {
                    cursorU.getCount();
                    return cursorU;
                }
            } catch (RuntimeException e7) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e7);
            }
        }
        return null;
    }

    @Override // d0.AbstractC0972a, d0.C0973b.a
    public CharSequence convertToString(Cursor cursor) {
        String strN;
        String strN2;
        if (cursor == null) {
            return null;
        }
        String strN3 = n(cursor, "suggest_intent_query");
        if (strN3 != null) {
            return strN3;
        }
        if (this.f21202x.shouldRewriteQueryFromData() && (strN2 = n(cursor, "suggest_intent_data")) != null) {
            return strN2;
        }
        if (!this.f21202x.shouldRewriteQueryFromText() || (strN = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strN;
    }

    @Override // d0.AbstractC0972a
    public void d(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i7 = this.f21200J;
        int i8 = i7 != -1 ? cursor.getInt(i7) : 0;
        if (aVar.f21205a != null) {
            y(aVar.f21205a, v(cursor, this.f21195E));
        }
        if (aVar.f21206b != null) {
            String strV = v(cursor, this.f21197G);
            CharSequence charSequenceK = strV != null ? k(strV) : v(cursor, this.f21196F);
            if (TextUtils.isEmpty(charSequenceK)) {
                TextView textView = aVar.f21205a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f21205a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f21205a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f21205a.setMaxLines(1);
                }
            }
            y(aVar.f21206b, charSequenceK);
        }
        ImageView imageView = aVar.f21207c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = aVar.f21208d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i9 = this.f21193C;
        if (i9 != 2 && (i9 != 1 || (i8 & 1) == 0)) {
            aVar.f21209e.setVisibility(8);
            return;
        }
        aVar.f21209e.setVisibility(0);
        aVar.f21209e.setTag(aVar.f21205a.getText());
        aVar.f21209e.setOnClickListener(this);
    }

    @Override // d0.AbstractC0974c, d0.AbstractC0972a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewG = super.g(context, cursor, viewGroup);
        viewG.setTag(new a(viewG));
        ((ImageView) viewG.findViewById(i.f.f17055q)).setImageResource(this.f21191A);
        return viewG;
    }

    @Override // d0.AbstractC0972a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i7, view, viewGroup);
        } catch (RuntimeException e7) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e7);
            View viewF = f(this.f21203y, b(), viewGroup);
            if (viewF != null) {
                ((a) viewF.getTag()).f21205a.setText(e7.toString());
            }
            return viewF;
        }
    }

    @Override // d0.AbstractC0972a, android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i7, view, viewGroup);
        } catch (RuntimeException e7) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e7);
            View viewG = g(this.f21203y, b(), viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f21205a.setText(e7.toString());
            }
            return viewG;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable j(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f21204z.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence k(CharSequence charSequence) {
        if (this.f21194D == null) {
            TypedValue typedValue = new TypedValue();
            this.f21203y.getTheme().resolveAttribute(AbstractC1145a.f16927J, typedValue, true);
            this.f21194D = this.f21203y.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f21194D, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable l(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f21203y.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e7) {
            Log.w("SuggestionsAdapter", e7.toString());
            return null;
        }
    }

    public final Drawable m(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f21204z.containsKey(strFlattenToShortString)) {
            Drawable drawableL = l(componentName);
            this.f21204z.put(strFlattenToShortString, drawableL != null ? drawableL.getConstantState() : null);
            return drawableL;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f21204z.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f21203y.getResources());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(b());
    }

    public final Drawable o() throws PackageManager.NameNotFoundException {
        Drawable drawableM = m(this.f21202x.getSearchActivity());
        return drawableM != null ? drawableM : this.f21203y.getPackageManager().getDefaultActivityIcon();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f21201w.S((CharSequence) tag);
        }
    }

    public final Drawable p(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return q(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f21203y.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    return drawableCreateFromStream;
                } catch (IOException e7) {
                    return drawableCreateFromStream;
                }
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e72) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e72);
                }
            }
        } catch (FileNotFoundException e8) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e8.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e8.getMessage());
        return null;
    }

    public Drawable q(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f21203y.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable r(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i7 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f21203y.getPackageName() + "/" + i7;
            Drawable drawableJ = j(str2);
            if (drawableJ != null) {
                return drawableJ;
            }
            Drawable drawableD = L.b.d(this.f21203y, i7);
            z(str2, drawableD);
            return drawableD;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableJ2 = j(str);
            if (drawableJ2 != null) {
                return drawableJ2;
            }
            Drawable drawableP = p(Uri.parse(str));
            z(str, drawableP);
            return drawableP;
        }
    }

    public final Drawable s(Cursor cursor) throws NumberFormatException, IOException {
        int i7 = this.f21198H;
        if (i7 == -1) {
            return null;
        }
        Drawable drawableR = r(cursor.getString(i7));
        return drawableR != null ? drawableR : o();
    }

    public final Drawable t(Cursor cursor) {
        int i7 = this.f21199I;
        if (i7 == -1) {
            return null;
        }
        return r(cursor.getString(i7));
    }

    public Cursor u(SearchableInfo searchableInfo, String str, int i7) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i7 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i7));
        }
        return this.f21203y.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void w(int i7) {
        this.f21193C = i7;
    }

    public final void x(ImageView imageView, Drawable drawable, int i7) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i7);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f21204z.put(str, drawable.getConstantState());
        }
    }
}
