package p5;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: p5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1449c extends h5.o {
    @Override // h5.o
    public Object g(byte b7, ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "buffer");
        if (b7 == -127) {
            Long l7 = (Long) f(byteBuffer);
            if (l7 != null) {
                return N.f20976m.a((int) l7.longValue());
            }
            return null;
        }
        if (b7 == -126) {
            Object objF = f(byteBuffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return K.f20800c.a(list);
            }
            return null;
        }
        if (b7 != -125) {
            return super.g(b7, byteBuffer);
        }
        Object objF2 = f(byteBuffer);
        List list2 = objF2 instanceof List ? (List) objF2 : null;
        if (list2 != null) {
            return P.f20983c.a(list2);
        }
        return null;
    }

    @Override // h5.o
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        M5.m.e(byteArrayOutputStream, "stream");
        if (obj instanceof N) {
            byteArrayOutputStream.write(129);
            p(byteArrayOutputStream, Long.valueOf(((N) obj).d()));
        } else if (obj instanceof K) {
            byteArrayOutputStream.write(130);
            p(byteArrayOutputStream, ((K) obj).b());
        } else if (!(obj instanceof P)) {
            super.p(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(131);
            p(byteArrayOutputStream, ((P) obj).a());
        }
    }
}
