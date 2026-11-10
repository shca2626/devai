package androidx.preference;

import R1.c;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: a0, reason: collision with root package name */
    public final Context f12881a0;

    /* renamed from: b0, reason: collision with root package name */
    public final ArrayAdapter f12882b0;

    /* renamed from: c0, reason: collision with root package name */
    public Spinner f12883c0;

    /* renamed from: d0, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f12884d0;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i7, long j7) {
            if (i7 >= 0) {
                String string = DropDownPreference.this.L()[i7].toString();
                if (string.equals(DropDownPreference.this.M()) || !DropDownPreference.this.a(string)) {
                    return;
                }
                DropDownPreference.this.O(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f7876c);
    }

    public ArrayAdapter P() {
        return new ArrayAdapter(this.f12881a0, R.layout.simple_spinner_dropdown_item);
    }

    public final void Q() {
        this.f12882b0.clear();
        if (J() != null) {
            for (CharSequence charSequence : J()) {
                this.f12882b0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public void u() {
        super.u();
        ArrayAdapter arrayAdapter = this.f12882b0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void w() {
        this.f12883c0.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12884d0 = new a();
        this.f12881a0 = context;
        this.f12882b0 = P();
        Q();
    }
}
