package com.google.android.material.internal;

import android.widget.Checkable;
import com.google.android.material.internal.k;

/* loaded from: classes8.dex */
public interface k<T extends k<T>> extends Checkable {

    public interface a<C> {
        void a(C c12, boolean z12);
    }

    int getId();

    void setInternalOnCheckedChangeListener(a<T> aVar);
}
