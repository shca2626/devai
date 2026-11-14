package androidx.media;

import b2.AbstractC0840a;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0840a abstractC0840a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f12474a = abstractC0840a.p(audioAttributesImplBase.f12474a, 1);
        audioAttributesImplBase.f12475b = abstractC0840a.p(audioAttributesImplBase.f12475b, 2);
        audioAttributesImplBase.f12476c = abstractC0840a.p(audioAttributesImplBase.f12476c, 3);
        audioAttributesImplBase.f12477d = abstractC0840a.p(audioAttributesImplBase.f12477d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0840a abstractC0840a) {
        abstractC0840a.x(false, false);
        abstractC0840a.F(audioAttributesImplBase.f12474a, 1);
        abstractC0840a.F(audioAttributesImplBase.f12475b, 2);
        abstractC0840a.F(audioAttributesImplBase.f12476c, 3);
        abstractC0840a.F(audioAttributesImplBase.f12477d, 4);
    }
}
