package androidx.media;

import android.media.AudioAttributes;
import b2.AbstractC0840a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0840a abstractC0840a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f12471a = (AudioAttributes) abstractC0840a.r(audioAttributesImplApi21.f12471a, 1);
        audioAttributesImplApi21.f12472b = abstractC0840a.p(audioAttributesImplApi21.f12472b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0840a abstractC0840a) {
        abstractC0840a.x(false, false);
        abstractC0840a.H(audioAttributesImplApi21.f12471a, 1);
        abstractC0840a.F(audioAttributesImplApi21.f12472b, 2);
    }
}
