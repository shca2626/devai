package androidx.media;

import b2.AbstractC0839a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0839a abstractC0839a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f12469a = (AudioAttributesImpl) abstractC0839a.v(audioAttributesCompat.f12469a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0839a abstractC0839a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0839a.x(false, false);
        abstractC0839a.M(audioAttributesCompat.f12469a, 1);
    }
}
