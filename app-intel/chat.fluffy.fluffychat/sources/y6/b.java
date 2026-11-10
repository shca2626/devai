package y6;

import L.c;
import M5.m;
import V5.w;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import c5.InterfaceC0910a;
import h5.i;
import h5.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import y5.C1824s;

/* loaded from: classes3.dex */
public final class b implements InterfaceC0910a, j.c {

    /* renamed from: l, reason: collision with root package name */
    public Context f24021l;

    /* renamed from: m, reason: collision with root package name */
    public j f24022m;

    /* renamed from: n, reason: collision with root package name */
    public final ExecutorService f24023n = Executors.newSingleThreadExecutor();

    public static final void b(byte[] bArr, File file, b bVar, ContentResolver contentResolver, ClipboardManager clipboardManager, j.d dVar) {
        try {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapDecodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byteArrayOutputStream.writeTo(fileOutputStream);
                C1824s c1824s = C1824s.f24014a;
                J5.b.a(fileOutputStream, null);
                Context context = bVar.f24021l;
                if (context == null) {
                    m.o("context");
                    context = null;
                }
                StringBuilder sb = new StringBuilder();
                Context context2 = bVar.f24021l;
                if (context2 == null) {
                    m.o("context");
                    context2 = null;
                }
                sb.append(context2.getPackageName());
                sb.append(".provider");
                clipboardManager.setPrimaryClip(ClipData.newUri(contentResolver, "image.png", c.h(context, sb.toString(), file)));
                dVar.success(null);
            } finally {
            }
        } catch (Exception e7) {
            dVar.error("Error", "Failed to write image", e7.getMessage());
        }
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
        j jVar = new j(bVar.b(), "pasteboard");
        this.f24022m = jVar;
        jVar.e(this);
        Context contextA = bVar.a();
        m.d(contextA, "getApplicationContext(...)");
        this.f24021l = contextA;
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "binding");
        j jVar = this.f24022m;
        if (jVar == null) {
            m.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // h5.j.c
    public void onMethodCall(i iVar, final j.d dVar) throws FileNotFoundException {
        Uri uri;
        Object objC;
        m.e(iVar, "call");
        m.e(dVar, "result");
        Context context = this.f24021l;
        Context context2 = null;
        if (context == null) {
            m.o("context");
            context = null;
        }
        Object systemService = context.getSystemService("clipboard");
        m.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        final ClipboardManager clipboardManager = (ClipboardManager) systemService;
        Context context3 = this.f24021l;
        if (context3 == null) {
            m.o("context");
            context3 = null;
        }
        final ContentResolver contentResolver = context3.getContentResolver();
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        ClipData.Item itemAt = primaryClip != null ? primaryClip.getItemAt(0) : null;
        String str = iVar.f16895a;
        if (str != null) {
            switch (str.hashCode()) {
                case -659520040:
                    if (str.equals("writeFiles")) {
                        List list = (List) iVar.b();
                        if (list == null) {
                            dVar.error("NoArgs", "Missing Arguments", null);
                            return;
                        }
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ClipData.newUri(contentResolver, "files", Uri.parse((String) it.next()));
                        }
                        dVar.success(null);
                        return;
                    }
                    break;
                case -656640836:
                    if (str.equals("writeImage")) {
                        final byte[] bArr = (byte[]) iVar.b();
                        if (bArr == null) {
                            dVar.error("NoArgs", "Missing Arguments", null);
                            return;
                        }
                        String str2 = UUID.randomUUID().toString() + ".png";
                        Context context4 = this.f24021l;
                        if (context4 == null) {
                            m.o("context");
                        } else {
                            context2 = context4;
                        }
                        final File file = new File(context2.getCacheDir(), str2);
                        this.f24023n.execute(new Runnable() { // from class: y6.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.b(bArr, file, this, contentResolver, clipboardManager, dVar);
                            }
                        });
                        return;
                    }
                    break;
                case 3213227:
                    if (str.equals("html")) {
                        dVar.success(itemAt != null ? itemAt.getHtmlText() : null);
                        return;
                    }
                    break;
                case 97434231:
                    if (str.equals("files")) {
                        ClipData primaryClip2 = clipboardManager.getPrimaryClip();
                        if (primaryClip2 != null) {
                            if (primaryClip2.getItemCount() == 0) {
                                dVar.success(null);
                            }
                            ArrayList arrayList = new ArrayList();
                            int itemCount = primaryClip2.getItemCount();
                            for (int i7 = 0; i7 < itemCount; i7++) {
                                Uri uri2 = primaryClip2.getItemAt(i7).getUri();
                                if (uri2 != null) {
                                    String string = uri2.toString();
                                    m.d(string, "toString(...)");
                                    arrayList.add(string);
                                }
                            }
                            dVar.success(arrayList);
                            return;
                        }
                        return;
                    }
                    break;
                case 100313435:
                    if (str.equals("image")) {
                        if (itemAt == null || (uri = itemAt.getUri()) == null) {
                            dVar.success(null);
                            return;
                        }
                        String type = contentResolver.getType(uri);
                        if (type == null || !w.y(type, "image", false, 2, null)) {
                            dVar.success(null);
                            return;
                        }
                        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                        if (inputStreamOpenInputStream == null || (objC = J5.a.c(inputStreamOpenInputStream)) == null) {
                            dVar.success(null);
                            return;
                        } else {
                            dVar.success(objC);
                            return;
                        }
                    }
                    break;
            }
        }
        dVar.notImplemented();
    }
}
