package com.cloudwebrtc.webrtc.video.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.Display;
import android.view.WindowManager;
import g5.k;

/* loaded from: classes.dex */
public class DeviceOrientationManager {
    private static final IntentFilter orientationIntentFilter = new IntentFilter("android.intent.action.CONFIGURATION_CHANGED");
    private final Activity activity;
    private BroadcastReceiver broadcastReceiver;
    private k.e lastOrientation;
    private final int sensorOrientation;

    public DeviceOrientationManager(Activity activity, int i7) {
        this.activity = activity;
        this.sensorOrientation = i7;
    }

    public static DeviceOrientationManager create(Activity activity, int i7) {
        return new DeviceOrientationManager(activity, i7);
    }

    public k.e calculateSensorOrientation(int i7) {
        int i8 = i7 + 45;
        if (getDeviceDefaultOrientation() == 2) {
            i8 = i7 + 135;
        }
        return new k.e[]{k.e.PORTRAIT_UP, k.e.LANDSCAPE_LEFT, k.e.PORTRAIT_DOWN, k.e.LANDSCAPE_RIGHT}[(i8 % 360) / 90];
    }

    public int getDeviceDefaultOrientation() {
        Configuration configuration = this.activity.getResources().getConfiguration();
        int rotation = getDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    public Display getDisplay() {
        return ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay();
    }

    public k.e getLastUIOrientation() {
        k.e eVar = this.lastOrientation;
        return eVar != null ? eVar : this.activity == null ? k.e.PORTRAIT_UP : getUIOrientation();
    }

    public k.e getUIOrientation() {
        int rotation = getDisplay().getRotation();
        int i7 = this.activity.getResources().getConfiguration().orientation;
        return i7 != 1 ? i7 != 2 ? k.e.PORTRAIT_UP : (rotation == 0 || rotation == 1) ? k.e.LANDSCAPE_LEFT : k.e.LANDSCAPE_RIGHT : (rotation == 0 || rotation == 1) ? k.e.PORTRAIT_UP : k.e.PORTRAIT_DOWN;
    }

    public void handleUIOrientationChange() {
        k.e uIOrientation = getUIOrientation();
        handleOrientationChange(uIOrientation, this.lastOrientation);
        this.lastOrientation = uIOrientation;
    }

    public void start() {
        if (this.broadcastReceiver != null) {
            return;
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.cloudwebrtc.webrtc.video.camera.DeviceOrientationManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                DeviceOrientationManager.this.handleUIOrientationChange();
            }
        };
        this.broadcastReceiver = broadcastReceiver;
        this.activity.registerReceiver(broadcastReceiver, orientationIntentFilter);
        this.broadcastReceiver.onReceive(this.activity, null);
    }

    public void stop() {
        BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
        if (broadcastReceiver == null) {
            return;
        }
        this.activity.unregisterReceiver(broadcastReceiver);
        this.broadcastReceiver = null;
    }

    public static void handleOrientationChange(k.e eVar, k.e eVar2) {
    }
}
