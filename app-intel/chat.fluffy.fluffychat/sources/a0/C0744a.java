package a0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: a0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0744a extends ClickableSpan {

    /* renamed from: l, reason: collision with root package name */
    public final int f10479l;

    /* renamed from: m, reason: collision with root package name */
    public final x f10480m;

    /* renamed from: n, reason: collision with root package name */
    public final int f10481n;

    public C0744a(int i7, x xVar, int i8) {
        this.f10479l = i7;
        this.f10480m = xVar;
        this.f10481n = i8;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f10479l);
        this.f10480m.g0(this.f10481n, bundle);
    }
}
