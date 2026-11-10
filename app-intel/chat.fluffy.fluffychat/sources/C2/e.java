package C2;

import V5.y;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import k6.e;
import k6.r;
import o2.AbstractC1399a;
import v2.v;
import v2.x;
import x2.j;
import y5.C1810e;
import y5.InterfaceC1809d;
import z5.C1889w;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final r f1322a = new r.a().d();

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1323a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1324b;

        static {
            int[] iArr = new int[r2.e.values().length];
            iArr[r2.e.MEMORY_CACHE.ordinal()] = 1;
            iArr[r2.e.MEMORY.ordinal()] = 2;
            iArr[r2.e.DISK.ordinal()] = 3;
            iArr[r2.e.NETWORK.ordinal()] = 4;
            f1323a = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            f1324b = iArr2;
        }
    }

    public static final void b(Closeable closeable) throws IOException {
        M5.m.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e7) {
            throw e7;
        } catch (Exception unused) {
        }
    }

    public static final String c(Uri uri) {
        M5.m.e(uri, "<this>");
        List<String> pathSegments = uri.getPathSegments();
        M5.m.d(pathSegments, "pathSegments");
        return (String) C1889w.G(pathSegments);
    }

    public static final int d(Drawable drawable) {
        Bitmap bitmap;
        M5.m.e(drawable, "<this>");
        Integer numValueOf = null;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
            numValueOf = Integer.valueOf(bitmap.getHeight());
        }
        return numValueOf == null ? drawable.getIntrinsicHeight() : numValueOf.intValue();
    }

    public static final String e(MimeTypeMap mimeTypeMap, String str) {
        M5.m.e(mimeTypeMap, "<this>");
        if (str == null || y.L(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(y.j0(y.k0(y.q0(y.q0(str, '#', null, 2, null), '?', null, 2, null), JsonPointer.SEPARATOR, null, 2, null), '.', ""));
    }

    public static final int f(Configuration configuration) {
        M5.m.e(configuration, "<this>");
        return configuration.uiMode & 48;
    }

    public static final x g(View view) {
        x xVar;
        M5.m.e(view, "<this>");
        Object tag = view.getTag(AbstractC1399a.f20371a);
        x xVar2 = tag instanceof x ? (x) tag : null;
        if (xVar2 != null) {
            return xVar2;
        }
        synchronized (view) {
            try {
                Object tag2 = view.getTag(AbstractC1399a.f20371a);
                xVar = tag2 instanceof x ? (x) tag2 : null;
                if (xVar == null) {
                    xVar = new x();
                    view.addOnAttachStateChangeListener(xVar);
                    view.setTag(AbstractC1399a.f20371a, xVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public static final y2.g h(ImageView imageView) {
        M5.m.e(imageView, "<this>");
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i7 = scaleType == null ? -1 : a.f1324b[scaleType.ordinal()];
        return (i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4) ? y2.g.FIT : y2.g.FILL;
    }

    public static final int i(Drawable drawable) {
        Bitmap bitmap;
        M5.m.e(drawable, "<this>");
        Integer numValueOf = null;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
            numValueOf = Integer.valueOf(bitmap.getWidth());
        }
        return numValueOf == null ? drawable.getIntrinsicWidth() : numValueOf.intValue();
    }

    public static final boolean j() {
        return M5.m.a(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean k(Drawable drawable) {
        M5.m.e(drawable, "<this>");
        return (drawable instanceof a2.f) || (drawable instanceof VectorDrawable);
    }

    public static final e.a l(L5.a aVar) {
        M5.m.e(aVar, "initializer");
        final InterfaceC1809d interfaceC1809dA = C1810e.a(aVar);
        return new e.a() { // from class: C2.d
            @Override // k6.e.a
            public final k6.e a(k6.y yVar) {
                return e.m(interfaceC1809dA, yVar);
            }
        };
    }

    public static final k6.e m(InterfaceC1809d interfaceC1809d, k6.y yVar) {
        M5.m.e(interfaceC1809d, "$lazy");
        return ((e.a) interfaceC1809d.getValue()).a(yVar);
    }

    public static final r n(r rVar) {
        return rVar == null ? f1322a : rVar;
    }

    public static final x2.m o(x2.m mVar) {
        return mVar == null ? x2.m.f23567n : mVar;
    }

    public static final void p(v vVar, j.a aVar) {
        M5.m.e(vVar, "<this>");
        z2.c cVarD = vVar.d();
        z2.d dVar = cVarD instanceof z2.d ? (z2.d) cVarD : null;
        View viewA = dVar != null ? dVar.a() : null;
        if (viewA == null) {
            return;
        }
        g(viewA).e(aVar);
    }
}
