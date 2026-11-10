package S4;

import M5.m;
import h5.o;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class h extends o {
    @Override // h5.o
    public Object g(byte b7, ByteBuffer byteBuffer) {
        m.e(byteBuffer, "buffer");
        if (b7 == -127) {
            Object objF = f(byteBuffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return b.f8193b.a(list);
            }
            return null;
        }
        if (b7 != -126) {
            return super.g(b7, byteBuffer);
        }
        Object objF2 = f(byteBuffer);
        List list2 = objF2 instanceof List ? (List) objF2 : null;
        if (list2 != null) {
            return a.f8191b.a(list2);
        }
        return null;
    }

    @Override // h5.o
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        m.e(byteArrayOutputStream, "stream");
        if (obj instanceof b) {
            byteArrayOutputStream.write(129);
            p(byteArrayOutputStream, ((b) obj).b());
        } else if (!(obj instanceof a)) {
            super.p(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(130);
            p(byteArrayOutputStream, ((a) obj).a());
        }
    }
}
