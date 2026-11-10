package org.webrtc.audio;

import android.media.AudioTrack;
import android.util.Log;
import com.cloudwebrtc.webrtc.record.AudioTrackInterceptor;
import java.lang.reflect.Field;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public abstract class WebRtcAudioTrackUtils {
    private static final String TAG = "WebRtcAudioTrackUtils";

    public static void attachOutputCallback(JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, JavaAudioDeviceModule javaAudioDeviceModule) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = javaAudioDeviceModule.getClass().getDeclaredField("audioOutput");
        declaredField.setAccessible(true);
        WebRtcAudioTrack webRtcAudioTrack = (WebRtcAudioTrack) declaredField.get(javaAudioDeviceModule);
        Log.w(TAG, "Here is a little hedgehog 🦔");
        Field declaredField2 = webRtcAudioTrack.getClass().getDeclaredField("audioTrack");
        declaredField2.setAccessible(true);
        AudioTrack audioTrack = (AudioTrack) declaredField2.get(webRtcAudioTrack);
        Log.w(TAG, "He is hiding in a forest 🌲🦔🌲");
        declaredField2.set(webRtcAudioTrack, new AudioTrackInterceptor(audioTrack, samplesReadyCallback));
        Log.w(TAG, "Little hedgie in the forest 🌲🌲🌲 but you can't see him");
    }

    public static void detachOutputCallback(JavaAudioDeviceModule javaAudioDeviceModule) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Log.w(TAG, "Where did the hedgie gone? Let's find him");
            Field declaredField = javaAudioDeviceModule.getClass().getDeclaredField("audioOutput");
            declaredField.setAccessible(true);
            WebRtcAudioTrack webRtcAudioTrack = (WebRtcAudioTrack) declaredField.get(javaAudioDeviceModule);
            Field declaredField2 = webRtcAudioTrack.getClass().getDeclaredField("audioTrack");
            declaredField2.setAccessible(true);
            AudioTrack audioTrack = (AudioTrack) declaredField2.get(webRtcAudioTrack);
            if (!(audioTrack instanceof AudioTrackInterceptor)) {
                Log.w(TAG, "Hedgie is lost 😢");
            } else {
                declaredField2.set(webRtcAudioTrack, ((AudioTrackInterceptor) audioTrack).originalTrack);
                Log.w(TAG, "Here he is 🦔");
            }
        } catch (Exception e7) {
            Log.w(TAG, "Failed to detach callback", e7);
        }
    }
}
