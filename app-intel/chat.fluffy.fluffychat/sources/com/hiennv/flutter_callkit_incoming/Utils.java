package com.hiennv.flutter_callkit_incoming;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiennv.flutter_callkit_incoming.Utils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import org.webrtc.PeerConnection;
import z5.C1889t;

/* loaded from: classes.dex */
public final class Utils {
    public static final Companion Companion = new Companion(null);
    private static ObjectMapper mapper;

    public static final class Companion {
        public /* synthetic */ Companion(M5.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean reapCollection$lambda$0(WeakReference weakReference) {
            M5.m.e(weakReference, "it");
            return weakReference.get() == null;
        }

        public final void backToForeground(Context context) {
            M5.m.e(context, "context");
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            Intent intentCloneFilter = launchIntentForPackage != null ? launchIntentForPackage.cloneFilter() : null;
            if (intentCloneFilter != null) {
                intentCloneFilter.addFlags(131072);
            }
            if (intentCloneFilter != null) {
                intentCloneFilter.addFlags(268435456);
            }
            if (intentCloneFilter != null) {
                intentCloneFilter.addFlags(PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS);
            }
            context.startActivity(intentCloneFilter);
        }

        public final float dpToPx(float f7) {
            return f7 * Resources.getSystem().getDisplayMetrics().density;
        }

        public final ObjectMapper getGsonInstance() {
            if (Utils.mapper == null) {
                Utils.mapper = new ObjectMapper();
            }
            ObjectMapper objectMapper = Utils.mapper;
            M5.m.b(objectMapper);
            return objectMapper;
        }

        public final int getNavigationBarHeight(Context context) {
            M5.m.e(context, "context");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public final int getScreenHeight() {
            return Resources.getSystem().getDisplayMetrics().heightPixels;
        }

        public final int getScreenWidth() {
            return Resources.getSystem().getDisplayMetrics().widthPixels;
        }

        public final int getStatusBarHeight(Context context) {
            M5.m.e(context, "context");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public final boolean isTablet(Context context) {
            M5.m.e(context, "context");
            return context.getResources().getBoolean(R.bool.isTablet);
        }

        public final float pxToDp(float f7) {
            return f7 / Resources.getSystem().getDisplayMetrics().density;
        }

        public final <T, C extends Collection<WeakReference<T>>> C reapCollection(C c7) {
            M5.m.e(c7, "<this>");
            C1889t.v(c7, new L5.l() { // from class: com.hiennv.flutter_callkit_incoming.F
                @Override // L5.l
                public final Object a(Object obj) {
                    return Boolean.valueOf(Utils.Companion.reapCollection$lambda$0((WeakReference) obj));
                }
            });
            return c7;
        }

        private Companion() {
        }
    }

    public static final float dpToPx(float f7) {
        return Companion.dpToPx(f7);
    }

    public static final int getScreenHeight() {
        return Companion.getScreenHeight();
    }

    public static final int getScreenWidth() {
        return Companion.getScreenWidth();
    }

    public static final float pxToDp(float f7) {
        return Companion.pxToDp(f7);
    }
}
