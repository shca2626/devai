package Z4;

import Z4.c;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Size;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c.a f10346a;

    public k(c.a aVar) {
        this.f10346a = aVar;
    }

    public static /* synthetic */ void b(k kVar, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        kVar.getClass();
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        if (kVar.f10346a != null) {
            Size size = imageInfo.getSize();
            kVar.f10346a.a(size.getWidth(), size.getHeight());
        }
    }

    @Override // Z4.d
    public Bitmap a(ByteBuffer byteBuffer, p pVar) {
        try {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: Z4.j
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    k.b(this.f10345a, imageDecoder, imageInfo, source);
                }
            });
        } catch (IOException e7) {
            U4.b.c("FlutterImageDecoderImplDefault", "Failed to decode image", e7);
            return null;
        }
    }
}
