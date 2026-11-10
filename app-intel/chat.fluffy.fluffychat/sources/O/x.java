package O;

import N.e;
import W.i;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class x extends z {
    public static int n(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // O.z
    public Typeface a(Context context, e.b bVar, Resources resources, int i7) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (e.c cVar : bVar.a()) {
                try {
                    Font fontBuild = new Font.Builder(resources, cVar.b()).setWeight(cVar.e()).setSlant(cVar.f() ? 1 : 0).setTtcIndex(cVar.c()).setFontVariationSettings(cVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(i(fontFamilyBuild, i7).getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // O.z
    public Typeface b(Context context, CancellationSignal cancellationSignal, i.b[] bVarArr, int i7) {
        try {
            FontFamily fontFamilyK = k(cancellationSignal, bVarArr, context.getContentResolver());
            if (fontFamilyK == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyK).setStyle(i(fontFamilyK, i7).getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // O.z
    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i7) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyK = k(cancellationSignal, (i.b[]) list.get(0), contentResolver);
            if (fontFamilyK == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyK);
            for (int i8 = 1; i8 < list.size(); i8++) {
                FontFamily fontFamilyK2 = k(cancellationSignal, (i.b[]) list.get(i8), contentResolver);
                if (fontFamilyK2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyK2);
                }
            }
            return customFallbackBuilder.setStyle(i(fontFamilyK, i7).getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // O.z
    public Typeface e(Context context, Resources resources, int i7, String str, int i8) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i7).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    public final Font i(FontFamily fontFamily, int i7) {
        FontStyle fontStyle = new FontStyle((i7 & 1) != 0 ? 700 : 400, (i7 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iN = n(fontStyle, font.getStyle());
        for (int i8 = 1; i8 < fontFamily.getSize(); i8++) {
            Font font2 = fontFamily.getFont(i8);
            int iN2 = n(fontStyle, font2.getStyle());
            if (iN2 < iN) {
                font = font2;
                iN = iN2;
            }
        }
        return font;
    }

    public final Font j(CancellationSignal cancellationSignal, i.b bVar, ContentResolver contentResolver) {
        return bVar.h() ? m(bVar) : l(cancellationSignal, bVar, contentResolver);
    }

    public FontFamily k(CancellationSignal cancellationSignal, i.b[] bVarArr, ContentResolver contentResolver) {
        FontFamily.Builder builder = null;
        for (i.b bVar : bVarArr) {
            Font fontJ = j(cancellationSignal, bVar, contentResolver);
            if (fontJ != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontJ);
                } else {
                    builder.addFont(fontJ);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public final Font l(CancellationSignal cancellationSignal, i.b bVar, ContentResolver contentResolver) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    return null;
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            try {
                Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.f()).setSlant(bVar.g() ? 1 : 0).setTtcIndex(bVar.c());
                if (!TextUtils.isEmpty(bVar.e())) {
                    ttcIndex.setFontVariationSettings(bVar.e());
                }
                Font fontBuild = ttcIndex.build();
                parcelFileDescriptorOpenFileDescriptor.close();
                return fontBuild;
            } finally {
            }
        } catch (IOException e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    public Font m(i.b bVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }
}
