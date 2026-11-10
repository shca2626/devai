package N4;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class r extends h5.o {
    @Override // h5.o
    public Object g(byte b7, ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "buffer");
        if (b7 == -127) {
            Long l7 = (Long) f(byteBuffer);
            if (l7 != null) {
                return n.f6435m.a((int) l7.longValue());
            }
            return null;
        }
        if (b7 == -126) {
            Object objF = f(byteBuffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return o.f6443c.a(list);
            }
            return null;
        }
        if (b7 == -125) {
            Object objF2 = f(byteBuffer);
            List list2 = objF2 instanceof List ? (List) objF2 : null;
            if (list2 != null) {
                return a.f6405g.a(list2);
            }
            return null;
        }
        if (b7 != -124) {
            return super.g(b7, byteBuffer);
        }
        Object objF3 = f(byteBuffer);
        List list3 = objF3 instanceof List ? (List) objF3 : null;
        if (list3 != null) {
            return p.f6446c.a(list3);
        }
        return null;
    }

    @Override // h5.o
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        M5.m.e(byteArrayOutputStream, "stream");
        if (obj instanceof n) {
            byteArrayOutputStream.write(129);
            p(byteArrayOutputStream, Long.valueOf(((n) obj).d()));
            return;
        }
        if (obj instanceof o) {
            byteArrayOutputStream.write(130);
            p(byteArrayOutputStream, ((o) obj).a());
        } else if (obj instanceof a) {
            byteArrayOutputStream.write(131);
            p(byteArrayOutputStream, ((a) obj).a());
        } else if (!(obj instanceof p)) {
            super.p(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(132);
            p(byteArrayOutputStream, ((p) obj).c());
        }
    }
}
