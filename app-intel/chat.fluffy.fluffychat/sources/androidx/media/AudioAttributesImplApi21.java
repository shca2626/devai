package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f12471a;

    /* renamed from: b, reason: collision with root package name */
    public int f12472b;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes.Builder f12473a = new AudioAttributes.Builder();

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f12473a.build());
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b(int i7) {
            this.f12473a.setContentType(i7);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a(int i7) {
            this.f12473a.setFlags(i7);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a c(int i7) {
            if (i7 == 16) {
                i7 = 12;
            }
            this.f12473a.setUsage(i7);
            return this;
        }
    }

    public AudioAttributesImplApi21() {
        this.f12472b = -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        int i7 = this.f12472b;
        return i7 != -1 ? i7 : AudioAttributesCompat.c(false, c(), d());
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object b() {
        return this.f12471a;
    }

    public int c() {
        return this.f12471a.getFlags();
    }

    public int d() {
        return this.f12471a.getUsage();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f12471a.equals(((AudioAttributesImplApi21) obj).f12471a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12471a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f12471a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i7) {
        this.f12471a = audioAttributes;
        this.f12472b = i7;
    }
}
