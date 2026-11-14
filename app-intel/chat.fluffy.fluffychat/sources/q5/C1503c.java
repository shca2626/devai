package q5;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: q5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1503c extends h5.o {
    @Override // h5.o
    public Object g(byte b7, ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "buffer");
        if (b7 == -127) {
            Object objF = f(byteBuffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return o.f21467d.a(list);
            }
            return null;
        }
        if (b7 != -126) {
            return super.g(b7, byteBuffer);
        }
        Object objF2 = f(byteBuffer);
        List list2 = objF2 instanceof List ? (List) objF2 : null;
        if (list2 != null) {
            return C1501a.f21448b.a(list2);
        }
        return null;
    }

    @Override // h5.o
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        M5.m.e(byteArrayOutputStream, "stream");
        if (obj instanceof o) {
            byteArrayOutputStream.write(129);
            p(byteArrayOutputStream, ((o) obj).d());
        } else if (!(obj instanceof C1501a)) {
            super.p(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(130);
            p(byteArrayOutputStream, ((C1501a) obj).b());
        }
    }
}
