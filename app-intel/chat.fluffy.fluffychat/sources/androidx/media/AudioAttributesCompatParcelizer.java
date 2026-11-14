package androidx.media;

import b2.AbstractC0840a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0840a abstractC0840a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f12469a = (AudioAttributesImpl) abstractC0840a.v(audioAttributesCompat.f12469a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0840a abstractC0840a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0840a.x(false, false);
        abstractC0840a.M(audioAttributesCompat.f12469a, 1);
    }
}
