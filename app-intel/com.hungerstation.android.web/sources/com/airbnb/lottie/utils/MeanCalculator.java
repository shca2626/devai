package com.airbnb.lottie.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes7.dex */
public class MeanCalculator {

    /* renamed from: n, reason: collision with root package name */
    private int f18157n;
    private float sum;

    public void add(float f12) {
        float f13 = this.sum + f12;
        this.sum = f13;
        int i12 = this.f18157n + 1;
        this.f18157n = i12;
        if (i12 == Integer.MAX_VALUE) {
            this.sum = f13 / 2.0f;
            this.f18157n = i12 / 2;
        }
    }

    public float getMean() {
        int i12 = this.f18157n;
        return i12 == 0 ? BitmapDescriptorFactory.HUE_RED : this.sum / i12;
    }
}
