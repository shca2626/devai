package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes8.dex */
public class u extends ImageButton {

    /* renamed from: b, reason: collision with root package name */
    private int f22978b;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b(int i12, boolean z12) {
        super.setVisibility(i12);
        if (z12) {
            this.f22978b = i12;
        }
    }

    public final int getUserSetVisibility() {
        return this.f22978b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i12) {
        b(i12, true);
    }

    public u(Context context, AttributeSet attributeSet, int i12) {
        super(context, attributeSet, i12);
        this.f22978b = getVisibility();
    }
}
