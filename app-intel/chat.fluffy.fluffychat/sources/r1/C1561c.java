package r1;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: r1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1561c {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f22109a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f22110b;

    public C1561c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f22109a = byteArrayOutputStream;
        this.f22110b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(C1559a c1559a) throws IOException {
        this.f22109a.reset();
        try {
            b(this.f22110b, c1559a.f22103a);
            String str = c1559a.f22104b;
            if (str == null) {
                str = "";
            }
            b(this.f22110b, str);
            this.f22110b.writeLong(c1559a.f22105c);
            this.f22110b.writeLong(c1559a.f22106d);
            this.f22110b.write(c1559a.f22107e);
            this.f22110b.flush();
            return this.f22109a.toByteArray();
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }
}
