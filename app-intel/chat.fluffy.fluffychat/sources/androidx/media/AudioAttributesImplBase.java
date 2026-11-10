package androidx.media;

import androidx.media.AudioAttributesImpl;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f12474a;

    /* renamed from: b, reason: collision with root package name */
    public int f12475b;

    /* renamed from: c, reason: collision with root package name */
    public int f12476c;

    /* renamed from: d, reason: collision with root package name */
    public int f12477d;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        public int f12478a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f12479b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f12480c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f12481d = -1;

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f12479b, this.f12480c, this.f12478a, this.f12481d);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b(int i7) {
            if (i7 == 0 || i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4) {
                this.f12479b = i7;
                return this;
            }
            this.f12479b = 0;
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a(int i7) {
            this.f12480c = (i7 & 1023) | this.f12480c;
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a c(int i7) {
            switch (i7) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case StdKeyDeserializer.TYPE_URL /* 14 */:
                case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                    this.f12478a = i7;
                    break;
                case 16:
                    this.f12478a = 12;
                    break;
                default:
                    this.f12478a = 0;
                    break;
            }
            return this;
        }
    }

    public AudioAttributesImplBase() {
        this.f12474a = 0;
        this.f12475b = 0;
        this.f12476c = 0;
        this.f12477d = -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int a() {
        int i7 = this.f12477d;
        return i7 != -1 ? i7 : AudioAttributesCompat.c(false, this.f12476c, this.f12474a);
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object b() {
        return null;
    }

    public int c() {
        return this.f12475b;
    }

    public int d() {
        int i7 = this.f12476c;
        int iA = a();
        if (iA == 6) {
            i7 |= 4;
        } else if (iA == 7) {
            i7 |= 1;
        }
        return i7 & 273;
    }

    public int e() {
        return this.f12474a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f12475b == audioAttributesImplBase.c() && this.f12476c == audioAttributesImplBase.d() && this.f12474a == audioAttributesImplBase.e() && this.f12477d == audioAttributesImplBase.f12477d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12475b), Integer.valueOf(this.f12476c), Integer.valueOf(this.f12474a), Integer.valueOf(this.f12477d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f12477d != -1) {
            sb.append(" stream=");
            sb.append(this.f12477d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.e(this.f12474a));
        sb.append(" content=");
        sb.append(this.f12475b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f12476c).toUpperCase());
        return sb.toString();
    }

    public AudioAttributesImplBase(int i7, int i8, int i9, int i10) {
        this.f12475b = i7;
        this.f12476c = i8;
        this.f12474a = i9;
        this.f12477d = i10;
    }
}
