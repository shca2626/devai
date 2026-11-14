package android.support.v4.media;

import androidx.media.AudioAttributesCompat;
import b2.AbstractC0840a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0840a abstractC0840a) {
        return androidx.media.AudioAttributesCompatParcelizer.read(abstractC0840a);
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0840a abstractC0840a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat, abstractC0840a);
    }
}
