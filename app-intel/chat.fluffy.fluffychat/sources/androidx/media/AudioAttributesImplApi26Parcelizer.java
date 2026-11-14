package androidx.media;

import android.media.AudioAttributes;
import b2.AbstractC0840a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC0840a abstractC0840a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f12471a = (AudioAttributes) abstractC0840a.r(audioAttributesImplApi26.f12471a, 1);
        audioAttributesImplApi26.f12472b = abstractC0840a.p(audioAttributesImplApi26.f12472b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC0840a abstractC0840a) {
        abstractC0840a.x(false, false);
        abstractC0840a.H(audioAttributesImplApi26.f12471a, 1);
        abstractC0840a.F(audioAttributesImplApi26.f12472b, 2);
    }
}
