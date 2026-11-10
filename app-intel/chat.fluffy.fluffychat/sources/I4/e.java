package I4;

import C0.h;
import M5.m;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* loaded from: classes.dex */
public final class e {
    public final AudioFocusRequest a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i7, int i8, int i9) {
        m.e(onAudioFocusChangeListener, "audioFocusChangeListener");
        AudioFocusRequest audioFocusRequestBuild = h.a(i7).setAudioAttributes(new AudioAttributes.Builder().setUsage(i8).setContentType(i9).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(onAudioFocusChangeListener).build();
        m.d(audioFocusRequestBuild, "build(...)");
        return audioFocusRequestBuild;
    }
}
