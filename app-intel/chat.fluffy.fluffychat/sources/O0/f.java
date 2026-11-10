package O0;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6499a;

    public class a extends LinkedHashMap {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f6500l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i7, float f7, boolean z7, int i8) {
            super(i7, f7, z7);
            this.f6500l = i8;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.f6500l;
        }
    }

    public f(int i7) {
        this.f6499a = new a(i7 + 1, 1.0f, false, i7);
    }

    public byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (byte[]) this.f6499a.get(uri);
    }

    public byte[] b(Uri uri, byte[] bArr) {
        return (byte[]) this.f6499a.put((Uri) j3.o.q(uri), (byte[]) j3.o.q(bArr));
    }

    public byte[] c(Uri uri) {
        return (byte[]) this.f6499a.remove(j3.o.q(uri));
    }
}
