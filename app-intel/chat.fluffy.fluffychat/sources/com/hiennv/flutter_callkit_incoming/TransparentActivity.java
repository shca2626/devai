package com.hiennv.flutter_callkit_incoming;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class TransparentActivity extends Activity {
    public static final Companion Companion = new Companion(null);
    private static boolean isVisible;

    public static final class Companion {
        public /* synthetic */ Companion(M5.g gVar) {
            this();
        }

        public final Intent getIntent(Context context, String str, Bundle bundle) {
            M5.m.e(context, "context");
            M5.m.e(str, "action");
            Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
            intent.setAction(str);
            intent.putExtra("data", bundle);
            intent.addFlags(65536);
            intent.addFlags(1073741824);
            intent.addFlags(131072);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            return intent;
        }

        public final boolean isVisible() {
            return TransparentActivity.isVisible;
        }

        public final void setVisible(boolean z7) {
            TransparentActivity.isVisible = z7;
        }

        private Companion() {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (action == null) {
            Log.w("TransparentActivity", "Intent action is null, finishing activity");
            finish();
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        Intent intent = CallkitIncomingBroadcastReceiver.Companion.getIntent(this, action, bundleExtra);
        intent.addFlags(268435456);
        sendBroadcast(intent);
        startActivity(AppUtils.INSTANCE.getAppIntent(this, action, bundleExtra));
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        setVisible(false);
    }
}
