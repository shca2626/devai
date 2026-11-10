package com.hiennv.flutter_callkit_incoming;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class AppUtils {
    public static final AppUtils INSTANCE = new AppUtils();

    private AppUtils() {
    }

    public static /* synthetic */ Intent getAppIntent$default(AppUtils appUtils, Context context, String str, Bundle bundle, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str = null;
        }
        if ((i7 & 4) != 0) {
            bundle = null;
        }
        return appUtils.getAppIntent(context, str, bundle);
    }

    public final GradientDrawable createCircleDrawable(int i7) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i7);
        return gradientDrawable;
    }

    public final Intent getAppIntent(Context context, String str, Bundle bundle) {
        M5.m.e(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        Intent intentCloneFilter = launchIntentForPackage != null ? launchIntentForPackage.cloneFilter() : null;
        if (intentCloneFilter != null) {
            intentCloneFilter.addFlags(604110848);
        }
        if (intentCloneFilter != null) {
            intentCloneFilter.putExtra(FlutterCallkitIncomingPlugin.EXTRA_CALLKIT_CALL_DATA, bundle);
        }
        if (intentCloneFilter != null) {
            intentCloneFilter.setAction(str);
        }
        return intentCloneFilter;
    }
}
