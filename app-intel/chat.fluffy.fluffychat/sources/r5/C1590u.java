package r5;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: r5.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1590u extends h5.o {
    @Override // h5.o
    public Object g(byte b7, ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "buffer");
        if (b7 == -127) {
            Long l7 = (Long) f(byteBuffer);
            if (l7 != null) {
                return D.f22179m.a((int) l7.longValue());
            }
            return null;
        }
        if (b7 == -126) {
            Long l8 = (Long) f(byteBuffer);
            if (l8 != null) {
                return B.f22170m.a((int) l8.longValue());
            }
            return null;
        }
        if (b7 == -125) {
            Object objF = f(byteBuffer);
            List list = objF instanceof List ? (List) objF : null;
            if (list != null) {
                return C1587q.f22321e.a(list);
            }
            return null;
        }
        if (b7 == -124) {
            Object objF2 = f(byteBuffer);
            List list2 = objF2 instanceof List ? (List) objF2 : null;
            if (list2 != null) {
                return G.f22191b.a(list2);
            }
            return null;
        }
        if (b7 == -123) {
            Object objF3 = f(byteBuffer);
            List list3 = objF3 instanceof List ? (List) objF3 : null;
            if (list3 != null) {
                return r.f22326b.a(list3);
            }
            return null;
        }
        if (b7 == -122) {
            Object objF4 = f(byteBuffer);
            List list4 = objF4 instanceof List ? (List) objF4 : null;
            if (list4 != null) {
                return C1579i.f22251b.a(list4);
            }
            return null;
        }
        if (b7 == -121) {
            Object objF5 = f(byteBuffer);
            List list5 = objF5 instanceof List ? (List) objF5 : null;
            if (list5 != null) {
                return m0.f22293b.a(list5);
            }
            return null;
        }
        if (b7 == -120) {
            Object objF6 = f(byteBuffer);
            List list6 = objF6 instanceof List ? (List) objF6 : null;
            if (list6 != null) {
                return E.f22186b.a(list6);
            }
            return null;
        }
        if (b7 == -119) {
            Object objF7 = f(byteBuffer);
            List list7 = objF7 instanceof List ? (List) objF7 : null;
            if (list7 != null) {
                return C1581k.f22264f.a(list7);
            }
            return null;
        }
        if (b7 == -118) {
            Object objF8 = f(byteBuffer);
            List list8 = objF8 instanceof List ? (List) objF8 : null;
            if (list8 != null) {
                return J.f22199c.a(list8);
            }
            return null;
        }
        if (b7 == -117) {
            Object objF9 = f(byteBuffer);
            List list9 = objF9 instanceof List ? (List) objF9 : null;
            if (list9 != null) {
                return F.f22188c.a(list9);
            }
            return null;
        }
        if (b7 == -116) {
            Object objF10 = f(byteBuffer);
            List list10 = objF10 instanceof List ? (List) objF10 : null;
            if (list10 != null) {
                return C1580j.f22254i.a(list10);
            }
            return null;
        }
        if (b7 == -115) {
            Object objF11 = f(byteBuffer);
            List list11 = objF11 instanceof List ? (List) objF11 : null;
            if (list11 != null) {
                return C1582l.f22272j.a(list11);
            }
            return null;
        }
        if (b7 == -114) {
            Object objF12 = f(byteBuffer);
            List list12 = objF12 instanceof List ? (List) objF12 : null;
            if (list12 != null) {
                return C1594y.f22332b.a(list12);
            }
            return null;
        }
        if (b7 == -113) {
            Object objF13 = f(byteBuffer);
            List list13 = objF13 instanceof List ? (List) objF13 : null;
            if (list13 != null) {
                return C1585o.f22307j.a(list13);
            }
            return null;
        }
        if (b7 != -112) {
            return super.g(b7, byteBuffer);
        }
        Object objF14 = f(byteBuffer);
        List list14 = objF14 instanceof List ? (List) objF14 : null;
        if (list14 != null) {
            return C1595z.f22334b.a(list14);
        }
        return null;
    }

    @Override // h5.o
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        M5.m.e(byteArrayOutputStream, "stream");
        if (obj instanceof D) {
            byteArrayOutputStream.write(129);
            p(byteArrayOutputStream, Long.valueOf(((D) obj).d()));
            return;
        }
        if (obj instanceof B) {
            byteArrayOutputStream.write(130);
            p(byteArrayOutputStream, Long.valueOf(((B) obj).d()));
            return;
        }
        if (obj instanceof C1587q) {
            byteArrayOutputStream.write(131);
            p(byteArrayOutputStream, ((C1587q) obj).a());
            return;
        }
        if (obj instanceof G) {
            byteArrayOutputStream.write(132);
            p(byteArrayOutputStream, ((G) obj).a());
            return;
        }
        if (obj instanceof r) {
            byteArrayOutputStream.write(133);
            p(byteArrayOutputStream, ((r) obj).a());
            return;
        }
        if (obj instanceof C1579i) {
            byteArrayOutputStream.write(134);
            p(byteArrayOutputStream, ((C1579i) obj).a());
            return;
        }
        if (obj instanceof m0) {
            byteArrayOutputStream.write(135);
            p(byteArrayOutputStream, ((m0) obj).a());
            return;
        }
        if (obj instanceof E) {
            byteArrayOutputStream.write(136);
            p(byteArrayOutputStream, ((E) obj).b());
            return;
        }
        if (obj instanceof C1581k) {
            byteArrayOutputStream.write(137);
            p(byteArrayOutputStream, ((C1581k) obj).f());
            return;
        }
        if (obj instanceof J) {
            byteArrayOutputStream.write(138);
            p(byteArrayOutputStream, ((J) obj).a());
            return;
        }
        if (obj instanceof F) {
            byteArrayOutputStream.write(139);
            p(byteArrayOutputStream, ((F) obj).a());
            return;
        }
        if (obj instanceof C1580j) {
            byteArrayOutputStream.write(140);
            p(byteArrayOutputStream, ((C1580j) obj).a());
            return;
        }
        if (obj instanceof C1582l) {
            byteArrayOutputStream.write(141);
            p(byteArrayOutputStream, ((C1582l) obj).a());
            return;
        }
        if (obj instanceof C1594y) {
            byteArrayOutputStream.write(142);
            p(byteArrayOutputStream, ((C1594y) obj).a());
        } else if (obj instanceof C1585o) {
            byteArrayOutputStream.write(143);
            p(byteArrayOutputStream, ((C1585o) obj).a());
        } else if (!(obj instanceof C1595z)) {
            super.p(byteArrayOutputStream, obj);
        } else {
            byteArrayOutputStream.write(144);
            p(byteArrayOutputStream, ((C1595z) obj).a());
        }
    }
}
