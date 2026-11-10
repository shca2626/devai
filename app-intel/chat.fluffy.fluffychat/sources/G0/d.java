package G0;

import E0.U;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: e, reason: collision with root package name */
    public final ContentResolver f3126e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f3127f;

    /* renamed from: g, reason: collision with root package name */
    public AssetFileDescriptor f3128g;

    /* renamed from: h, reason: collision with root package name */
    public FileInputStream f3129h;

    /* renamed from: i, reason: collision with root package name */
    public long f3130i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3131j;

    public static class a extends g {
        public a(IOException iOException, int i7) {
            super(iOException, i7);
        }
    }

    public d(Context context) {
        super(false);
        this.f3126e = context.getContentResolver();
    }

    @Override // G0.f
    public void close() {
        this.f3127f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f3129h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f3129h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f3128g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e7) {
                        throw new a(e7, 2000);
                    }
                } finally {
                    this.f3128g = null;
                    if (this.f3131j) {
                        this.f3131j = false;
                        v();
                    }
                }
            } catch (IOException e8) {
                throw new a(e8, 2000);
            }
        } catch (Throwable th) {
            this.f3129h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f3128g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f3128g = null;
                    if (this.f3131j) {
                        this.f3131j = false;
                        v();
                    }
                    throw th;
                } catch (IOException e9) {
                    throw new a(e9, 2000);
                }
            } finally {
                this.f3128g = null;
                if (this.f3131j) {
                    this.f3131j = false;
                    v();
                }
            }
        }
    }

    @Override // G0.f
    public Uri r() {
        return this.f3127f;
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        if (i8 == 0) {
            return 0;
        }
        long j7 = this.f3130i;
        if (j7 == 0) {
            return -1;
        }
        if (j7 != -1) {
            try {
                i8 = (int) Math.min(j7, i8);
            } catch (IOException e7) {
                throw new a(e7, 2000);
            }
        }
        int i9 = ((FileInputStream) U.i(this.f3129h)).read(bArr, i7, i8);
        if (i9 == -1) {
            return -1;
        }
        long j8 = this.f3130i;
        if (j8 != -1) {
            this.f3130i = j8 - i9;
        }
        u(i9);
        return i9;
    }

    @Override // G0.f
    public long s(j jVar) throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uriNormalizeScheme = jVar.f3143a.normalizeScheme();
            this.f3127f = uriNormalizeScheme;
            w(jVar);
            if (Objects.equals(uriNormalizeScheme.getScheme(), "content")) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptorOpenAssetFileDescriptor = this.f3126e.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f3126e.openAssetFileDescriptor(uriNormalizeScheme, "r");
            }
            this.f3128g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new a(new IOException("Could not open file descriptor for: " + uriNormalizeScheme), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f3129h = fileInputStream;
            if (length != -1 && jVar.f3149g > length) {
                throw new a(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(jVar.f3149g + startOffset) - startOffset;
            if (jSkip != jVar.f3149g) {
                throw new a(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f3130i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f3130i = jPosition;
                    if (jPosition < 0) {
                        throw new a(null, 2008);
                    }
                }
            } else {
                long j7 = length - jSkip;
                this.f3130i = j7;
                if (j7 < 0) {
                    throw new a(null, 2008);
                }
            }
            long jMin = jVar.f3150h;
            if (jMin != -1) {
                long j8 = this.f3130i;
                if (j8 != -1) {
                    jMin = Math.min(j8, jMin);
                }
                this.f3130i = jMin;
            }
            this.f3131j = true;
            x(jVar);
            long j9 = jVar.f3150h;
            return j9 != -1 ? j9 : this.f3130i;
        } catch (a e7) {
            throw e7;
        } catch (IOException e8) {
            throw new a(e8, e8 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }
}
