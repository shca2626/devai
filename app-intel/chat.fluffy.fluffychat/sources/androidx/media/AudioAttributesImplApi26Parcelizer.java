package androidx.media;

import android.media.AudioAttributes;
import b2.AbstractC0839a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC0839a abstractC0839a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f12471a = (AudioAttributes) abstractC0839a.r(audioAttributesImplApi26.f12471a, 1);
        audioAttributesImplApi26.f12472b = abstractC0839a.p(audioAttributesImplApi26.f12472b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC0839a abstractC0839a) {
        abstractC0839a.x(false, false);
        abstractC0839a.H(audioAttributesImplApi26.f12471a, 1);
        abstractC0839a.F(audioAttributesImplApi26.f12472b, 2);
    }
}
