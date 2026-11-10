package com.google.android.libraries.places.internal;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public final class zzej {
    public static int zza(int i12, int i13, int i14) {
        return zzb(i12, i13, i14) ? i14 : i13;
    }

    public static boolean zzb(int i12, int i13, int i14) {
        double dZza = zza(i12);
        double dZza2 = zza(zza(i13), dZza);
        return dZza2 <= 3.0d && dZza2 <= zza(zza(i14), dZza);
    }

    public static void zza(ImageView imageView, int i12) {
        Drawable drawable = imageView.getDrawable();
        int iRgb = Color.rgb(Color.red(i12), Color.green(i12), Color.blue(i12));
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setColorFilter(iRgb, PorterDuff.Mode.SRC_ATOP);
        drawableMutate.setAlpha(Color.alpha(i12));
    }

    private static double zza(double d12, double d13) {
        return Math.round(((Math.max(d12, d13) + 0.05d) / (Math.min(d12, d13) + 0.05d)) * 100.0d) / 100.0d;
    }

    private static double zza(int i12) {
        return (zza(Color.red(i12) / 255.0d) * 0.2126d) + (zza(Color.green(i12) / 255.0d) * 0.7152d) + (zza(Color.blue(i12) / 255.0d) * 0.0722d);
    }

    private static double zza(double d12) {
        return d12 <= 0.03928d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
    }
}
