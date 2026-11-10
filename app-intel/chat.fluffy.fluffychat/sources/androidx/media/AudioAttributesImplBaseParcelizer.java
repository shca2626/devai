package androidx.media;

import b2.AbstractC0839a;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0839a abstractC0839a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f12474a = abstractC0839a.p(audioAttributesImplBase.f12474a, 1);
        audioAttributesImplBase.f12475b = abstractC0839a.p(audioAttributesImplBase.f12475b, 2);
        audioAttributesImplBase.f12476c = abstractC0839a.p(audioAttributesImplBase.f12476c, 3);
        audioAttributesImplBase.f12477d = abstractC0839a.p(audioAttributesImplBase.f12477d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0839a abstractC0839a) {
        abstractC0839a.x(false, false);
        abstractC0839a.F(audioAttributesImplBase.f12474a, 1);
        abstractC0839a.F(audioAttributesImplBase.f12475b, 2);
        abstractC0839a.F(audioAttributesImplBase.f12476c, 3);
        abstractC0839a.F(audioAttributesImplBase.f12477d, 4);
    }
}
