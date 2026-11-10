package androidx.media;

import android.media.AudioAttributes;
import b2.AbstractC0839a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0839a abstractC0839a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f12471a = (AudioAttributes) abstractC0839a.r(audioAttributesImplApi21.f12471a, 1);
        audioAttributesImplApi21.f12472b = abstractC0839a.p(audioAttributesImplApi21.f12472b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0839a abstractC0839a) {
        abstractC0839a.x(false, false);
        abstractC0839a.H(audioAttributesImplApi21.f12471a, 1);
        abstractC0839a.F(audioAttributesImplApi21.f12472b, 2);
    }
}
