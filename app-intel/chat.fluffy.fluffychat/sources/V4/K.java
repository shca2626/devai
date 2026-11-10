package V4;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class K {

    /* renamed from: a, reason: collision with root package name */
    public long f8677a;

    /* renamed from: b, reason: collision with root package name */
    public b f8678b;

    /* renamed from: c, reason: collision with root package name */
    public long f8679c;

    /* renamed from: d, reason: collision with root package name */
    public long f8680d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8681e;

    /* renamed from: f, reason: collision with root package name */
    public a f8682f;

    /* renamed from: g, reason: collision with root package name */
    public String f8683g;

    public enum a {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);


        /* renamed from: l, reason: collision with root package name */
        public final long f8690l;

        a(long j7) {
            this.f8690l = j7;
        }

        public long d() {
            return this.f8690l;
        }
    }

    public enum b {
        kDown(0),
        kUp(1),
        kRepeat(2);


        /* renamed from: l, reason: collision with root package name */
        public long f8695l;

        b(long j7) {
            this.f8695l = j7;
        }

        public long d() {
            return this.f8695l;
        }
    }

    public ByteBuffer a() {
        try {
            String str = this.f8683g;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(length + 56);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocateDirect.putLong(length);
            byteBufferAllocateDirect.putLong(this.f8677a);
            byteBufferAllocateDirect.putLong(this.f8678b.d());
            byteBufferAllocateDirect.putLong(this.f8679c);
            byteBufferAllocateDirect.putLong(this.f8680d);
            byteBufferAllocateDirect.putLong(this.f8681e ? 1L : 0L);
            byteBufferAllocateDirect.putLong(this.f8682f.d());
            if (bytes != null) {
                byteBufferAllocateDirect.put(bytes);
            }
            return byteBufferAllocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
