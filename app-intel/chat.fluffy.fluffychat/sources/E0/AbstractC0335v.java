package E0;

import B0.C0308j;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: E0.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0335v {
    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, C0308j c0308j) {
        if (c0308j != null) {
            d(mediaFormat, "color-transfer", c0308j.f653c);
            d(mediaFormat, "color-standard", c0308j.f651a);
            d(mediaFormat, "color-range", c0308j.f652b);
            a(mediaFormat, "hdr-static-info", c0308j.f654d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f7) {
        if (f7 != -1.0f) {
            mediaFormat.setFloat(str, f7);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i7) {
        if (i7 != -1) {
            mediaFormat.setInteger(str, i7);
        }
    }

    public static void e(MediaFormat mediaFormat, List list) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            mediaFormat.setByteBuffer("csd-" + i7, ByteBuffer.wrap((byte[]) list.get(i7)));
        }
    }
}
