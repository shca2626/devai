package android.support.v4.media;

import androidx.media.AudioAttributesCompat;
import b2.AbstractC0839a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0839a abstractC0839a) {
        return androidx.media.AudioAttributesCompatParcelizer.read(abstractC0839a);
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0839a abstractC0839a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat, abstractC0839a);
    }
}
