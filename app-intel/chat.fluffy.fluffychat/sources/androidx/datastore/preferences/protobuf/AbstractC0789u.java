package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0789u {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f12245a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f12246b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f12247c = Charset.forName("ISO-8859-1");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f12248d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f12249e;

    /* renamed from: f, reason: collision with root package name */
    public static final AbstractC0776g f12250f;

    /* renamed from: androidx.datastore.preferences.protobuf.u$a */
    public interface a {
        boolean a(int i7);
    }

    /* renamed from: androidx.datastore.preferences.protobuf.u$b */
    public interface b extends List, RandomAccess {
        void a();

        b c(int i7);

        boolean e();
    }

    static {
        byte[] bArr = new byte[0];
        f12248d = bArr;
        f12249e = ByteBuffer.wrap(bArr);
        f12250f = AbstractC0776g.i(bArr);
    }

    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z7) {
        return z7 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i7, int i8) {
        int iG = g(i8, bArr, i7, i8);
        if (iG == 0) {
            return 1;
        }
        return iG;
    }

    public static int f(long j7) {
        return (int) (j7 ^ (j7 >>> 32));
    }

    public static int g(int i7, byte[] bArr, int i8, int i9) {
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            i7 = (i7 * 31) + bArr[i10];
        }
        return i7;
    }
}
