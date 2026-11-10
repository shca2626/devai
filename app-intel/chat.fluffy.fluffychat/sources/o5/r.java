package o5;

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
                return d.f20431m.a((int) l7.longValue());
            }
            return null;
        }
        if (b7 == -126) {
            Long l8 = (Long) f(byteBuffer);
            if (l8 != null) {
                return EnumC1407a.f20412m.a((int) l8.longValue());
            }
            return null;
        }
        if (b7 == -125) {
            Object objF = f(byteBuffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return e.f20446e.a(list);
            }
            return null;
        }
        if (b7 == -124) {
            Object objF2 = f(byteBuffer);
            List list2 = objF2 instanceof List ? (List) objF2 : null;
            if (list2 != null) {
                return c.f20422c.a(list2);
            }
            return null;
        }
        if (b7 != -123) {
            return super.g(b7, byteBuffer);
        }
        Object objF3 = f(byteBuffer);
        List list3 = objF3 instanceof List ? (List) objF3 : null;
        if (list3 != null) {
            return C1408b.f20418d.a(list3);
        }
        return null;
    }

    @Override // h5.o
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        M5.m.e(byteArrayOutputStream, "stream");
        if (obj instanceof d) {
            byteArrayOutputStream.write(129);
            p(byteArrayOutputStream, Long.valueOf(((d) obj).d()));
            return;
        }
        if (obj instanceof EnumC1407a) {
            byteArrayOutputStream.write(130);
            p(byteArrayOutputStream, Long.valueOf(((EnumC1407a) obj).d()));
            return;
        }
        if (obj instanceof e) {
            byteArrayOutputStream.write(131);
            p(byteArrayOutputStream, ((e) obj).e());
        } else if (obj instanceof c) {
            byteArrayOutputStream.write(132);
            p(byteArrayOutputStream, ((c) obj).a());
        } else if (!(obj instanceof C1408b)) {
            super.p(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(133);
            p(byteArrayOutputStream, ((C1408b) obj).d());
        }
    }
}
