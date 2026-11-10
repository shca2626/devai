package com.hiennv.flutter_callkit_incoming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class CallkitSoundPlayerManager {
    private AudioManager audioManager;
    private final Context context;
    private boolean isPlaying;
    private boolean keepRingingForFullScreenIntent;
    private Timer ringingTimer;
    private Ringtone ringtone;
    private ScreenOffCallkitIncomingBroadcastReceiver screenOffCallkitIncomingBroadcastReceiver;
    private Vibrator vibrator;

    public final class ScreenOffCallkitIncomingBroadcastReceiver extends BroadcastReceiver {
        public ScreenOffCallkitIncomingBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            M5.m.e(context, "context");
            M5.m.e(intent, "intent");
            if (!CallkitSoundPlayerManager.this.isPlaying() || CallkitSoundPlayerManager.this.keepRingingForFullScreenIntent) {
                return;
            }
            CallkitSoundPlayerManager.this.stop();
        }
    }

    public CallkitSoundPlayerManager(Context context) {
        M5.m.e(context, "context");
        this.context = context;
        this.screenOffCallkitIncomingBroadcastReceiver = new ScreenOffCallkitIncomingBroadcastReceiver();
    }

    private final Uri getDefaultRingtoneUri(boolean z7) {
        if (!z7) {
            try {
                int identifier = this.context.getResources().getIdentifier("ringtone_default", "raw", this.context.getPackageName());
                if (identifier != 0) {
                    return Uri.parse("android.resource://" + this.context.getPackageName() + JsonPointer.SEPARATOR + identifier);
                }
            } catch (Exception unused) {
                return getSafeSystemRingtoneUri();
            }
        }
        return RingtoneManager.getActualDefaultRingtoneUri(this.context, 1);
    }

    public static /* synthetic */ Uri getDefaultRingtoneUri$default(CallkitSoundPlayerManager callkitSoundPlayerManager, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return callkitSoundPlayerManager.getDefaultRingtoneUri(z7);
    }

    private final Uri getRingtoneUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return getDefaultRingtoneUri$default(this, false, 1, null);
        }
        if (V5.w.t(str, "system_ringtone_default", true)) {
            return getDefaultRingtoneUri(true);
        }
        try {
            int identifier = this.context.getResources().getIdentifier(str, "raw", this.context.getPackageName());
            if (identifier == 0) {
                return getDefaultRingtoneUri$default(this, false, 1, null);
            }
            return Uri.parse("android.resource://" + this.context.getPackageName() + JsonPointer.SEPARATOR + identifier);
        } catch (Exception unused) {
            return getDefaultRingtoneUri$default(this, false, 1, null);
        }
    }

    private final Uri getSafeSystemRingtoneUri() {
        try {
            Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.context, 1);
            RingtoneManager ringtoneManager = new RingtoneManager(this.context);
            ringtoneManager.setType(1);
            Cursor cursor = ringtoneManager.getCursor();
            if (actualDefaultRingtoneUri != null && cursor != null) {
                while (cursor.moveToNext()) {
                    if (M5.m.a(ringtoneManager.getRingtoneUri(cursor.getPosition()), actualDefaultRingtoneUri)) {
                        cursor.close();
                        return actualDefaultRingtoneUri;
                    }
                }
            }
            if (cursor == null || !cursor.moveToFirst()) {
                return null;
            }
            Uri ringtoneUri = ringtoneManager.getRingtoneUri(cursor.getPosition());
            cursor.close();
            return ringtoneUri;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    private final void playSound(Bundle bundle) throws IllegalArgumentException {
        Ringtone ringtone;
        String string = bundle != null ? bundle.getString(CallkitConstants.EXTRA_CALLKIT_RINGTONE_PATH, "") : null;
        Uri ringtoneUri = string != null ? getRingtoneUri(string) : null;
        if (ringtoneUri == null) {
            return;
        }
        try {
            this.ringtone = RingtoneManager.getRingtone(this.context, ringtoneUri);
            int i7 = Build.VERSION.SDK_INT;
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(4).setUsage(6).setLegacyStreamType(2).build();
            Ringtone ringtone2 = this.ringtone;
            if (ringtone2 != null) {
                ringtone2.setAudioAttributes(audioAttributesBuild);
            }
            if (i7 >= 28 && (ringtone = this.ringtone) != null) {
                ringtone.setLooping(true);
            }
            Ringtone ringtone3 = this.ringtone;
            if (ringtone3 != null) {
                ringtone3.play();
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private final void playVibrator() {
        Vibrator defaultVibrator;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            Object systemService = this.context.getSystemService("vibrator_manager");
            M5.m.c(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
            defaultVibrator = w.a(systemService).getDefaultVibrator();
        } else {
            Object systemService2 = this.context.getSystemService("vibrator");
            M5.m.c(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
            defaultVibrator = (Vibrator) systemService2;
        }
        this.vibrator = defaultVibrator;
        Object systemService3 = this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        M5.m.c(systemService3, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService3;
        this.audioManager = audioManager;
        if (audioManager == null || audioManager.getRingerMode() != 0) {
            long[] jArr = {0, 1000, 1000};
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(4).setUsage(6).setLegacyStreamType(2).build();
            if (i7 >= 26) {
                Vibrator vibrator = this.vibrator;
                if (vibrator != null) {
                    vibrator.vibrate(VibrationEffect.createWaveform(jArr, 0), audioAttributesBuild);
                    return;
                }
                return;
            }
            Vibrator vibrator2 = this.vibrator;
            if (vibrator2 != null) {
                vibrator2.vibrate(jArr, 0, audioAttributesBuild);
            }
        }
    }

    private final void prepare() {
        Ringtone ringtone = this.ringtone;
        if (ringtone != null) {
            ringtone.stop();
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    public final void destroy() {
        this.isPlaying = false;
        Ringtone ringtone = this.ringtone;
        if (ringtone != null) {
            ringtone.stop();
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
        this.ringtone = null;
        this.vibrator = null;
        try {
            this.context.unregisterReceiver(this.screenOffCallkitIncomingBroadcastReceiver);
        } catch (Exception unused) {
        }
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final void keepRingingOnFullScreen() {
        this.keepRingingForFullScreenIntent = true;
        Timer timer = this.ringingTimer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() { // from class: com.hiennv.flutter_callkit_incoming.CallkitSoundPlayerManager$keepRingingOnFullScreen$1$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.keepRingingForFullScreenIntent = false;
            }
        }, 500L);
        this.ringingTimer = timer2;
    }

    public final void play(Bundle bundle) throws IllegalArgumentException {
        M5.m.e(bundle, "data");
        this.isPlaying = true;
        prepare();
        Object systemService = this.context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getRingerMode()) : null;
        if (numValueOf == null || numValueOf.intValue() != 0) {
            if (numValueOf == null || numValueOf.intValue() != 1) {
                playSound(bundle);
            }
            playVibrator();
        }
        this.context.registerReceiver(this.screenOffCallkitIncomingBroadcastReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    public final void stop() {
        this.isPlaying = false;
        Ringtone ringtone = this.ringtone;
        if (ringtone != null) {
            ringtone.stop();
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
        this.ringtone = null;
        this.vibrator = null;
        try {
            this.context.unregisterReceiver(this.screenOffCallkitIncomingBroadcastReceiver);
        } catch (Exception unused) {
        }
    }
}
