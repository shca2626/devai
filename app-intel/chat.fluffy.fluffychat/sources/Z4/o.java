package Z4;

import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class o {
    public static MediaExtractor a(byte[] bArr) throws IOException {
        a aVar = new a(bArr);
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(aVar);
        return mediaExtractor;
    }

    public static void b(byte[] bArr, p pVar) {
        try {
            c(bArr, pVar, a(bArr));
        } catch (Exception e7) {
            U4.b.c("MediaMetadataReader", "Failed to decode HEIF image using MediaExtractor", e7);
        }
    }

    public static void c(byte[] bArr, p pVar, MediaExtractor mediaExtractor) {
        try {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i7 = 0; i7 < trackCount; i7++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i7);
                String string = trackFormat.getString("mime");
                if (string != null && string.startsWith("image/")) {
                    int integer = trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0;
                    int i8 = pVar.f10354g;
                    int i9 = pVar.f10353f;
                    if (integer != 90 && integer != 270) {
                        i9 = i8;
                        i8 = i9;
                    }
                    pVar.f10349b = i8;
                    pVar.f10348a = i9;
                    pVar.f10350c = integer;
                    return;
                }
            }
        } catch (Exception e7) {
            U4.b.c("MediaMetadataReader", "Failed to decode HEIF image using MediaExtractor", e7);
        }
    }

    public class a extends MediaDataSource {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ byte[] f10347l;

        public a(byte[] bArr) {
            this.f10347l = bArr;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return this.f10347l.length;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j7, byte[] bArr, int i7, int i8) {
            byte[] bArr2 = this.f10347l;
            if (j7 >= bArr2.length) {
                return -1;
            }
            if (i8 + j7 > bArr2.length) {
                i8 = (int) (bArr2.length - j7);
            }
            System.arraycopy(bArr2, (int) j7, bArr, i7, i8);
            return i8;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
