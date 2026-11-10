package com.airbnb.lottie.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes7.dex */
public class GammaEvaluator {
    private static float EOCF_sRGB(float f12) {
        return f12 <= 0.04045f ? f12 / 12.92f : (float) Math.pow((f12 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f12) {
        return f12 <= 0.0031308f ? f12 * 12.92f : (float) ((Math.pow(f12, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f12, int i12, int i13) {
        if (i12 == i13 || f12 <= BitmapDescriptorFactory.HUE_RED) {
            return i12;
        }
        if (f12 >= 1.0f) {
            return i13;
        }
        float f13 = ((i12 >> 24) & 255) / 255.0f;
        float fEOCF_sRGB = EOCF_sRGB(((i12 >> 16) & 255) / 255.0f);
        float fEOCF_sRGB2 = EOCF_sRGB(((i12 >> 8) & 255) / 255.0f);
        float fEOCF_sRGB3 = EOCF_sRGB((i12 & 255) / 255.0f);
        float fEOCF_sRGB4 = EOCF_sRGB(((i13 >> 16) & 255) / 255.0f);
        float f14 = f13 + (((((i13 >> 24) & 255) / 255.0f) - f13) * f12);
        float fEOCF_sRGB5 = fEOCF_sRGB2 + ((EOCF_sRGB(((i13 >> 8) & 255) / 255.0f) - fEOCF_sRGB2) * f12);
        float fEOCF_sRGB6 = fEOCF_sRGB3 + (f12 * (EOCF_sRGB((i13 & 255) / 255.0f) - fEOCF_sRGB3));
        return (Math.round(OECF_sRGB(fEOCF_sRGB + ((fEOCF_sRGB4 - fEOCF_sRGB) * f12)) * 255.0f) << 16) | (Math.round(f14 * 255.0f) << 24) | (Math.round(OECF_sRGB(fEOCF_sRGB5) * 255.0f) << 8) | Math.round(OECF_sRGB(fEOCF_sRGB6) * 255.0f);
    }
}
