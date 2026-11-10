package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes8.dex */
public final class ViewGroupUtil {
    private ViewGroupUtil() {
    }

    public static int findChildIndex(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            if (viewGroup.getChildAt(i12) == view) {
                return i12;
            }
        }
        return -1;
    }
}
