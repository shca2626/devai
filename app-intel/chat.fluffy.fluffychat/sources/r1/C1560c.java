package r1;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: r1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1560c {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f22115a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f22116b;

    public C1560c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f22115a = byteArrayOutputStream;
        this.f22116b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(C1558a c1558a) throws IOException {
        this.f22115a.reset();
        try {
            b(this.f22116b, c1558a.f22109a);
            String str = c1558a.f22110b;
            if (str == null) {
                str = "";
            }
            b(this.f22116b, str);
            this.f22116b.writeLong(c1558a.f22111c);
            this.f22116b.writeLong(c1558a.f22112d);
            this.f22116b.write(c1558a.f22113e);
            this.f22116b.flush();
            return this.f22115a.toByteArray();
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }
}
