package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes8.dex */
public interface HighlightableDescriptor<E> {
    Object getElementToHighlightAtPosition(E e12, int i12, int i13, Rect rect);

    View getViewAndBoundsForHighlighting(E e12, Rect rect);
}
