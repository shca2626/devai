package q1;

import B0.y;
import E0.D;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import p1.d;

/* renamed from: q1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1493b extends d {
    public static y c(D d7) {
        d7.r(12);
        int iD = (d7.d() + d7.h(12)) - 4;
        d7.r(44);
        d7.s(d7.h(12));
        d7.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (d7.d() >= iD) {
                break;
            }
            d7.r(48);
            int iH = d7.h(8);
            d7.r(4);
            int iD2 = d7.d() + d7.h(12);
            String strL2 = null;
            while (d7.d() < iD2) {
                int iH2 = d7.h(8);
                int iH3 = d7.h(8);
                int iD3 = d7.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = d7.h(16);
                    d7.r(8);
                    if (iH4 == 3) {
                        while (d7.d() < iD3) {
                            strL = d7.l(d7.h(8), StandardCharsets.US_ASCII);
                            int iH5 = d7.h(8);
                            for (int i7 = 0; i7 < iH5; i7++) {
                                d7.s(d7.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = d7.l(iH3, StandardCharsets.US_ASCII);
                }
                d7.p(iD3 * 8);
            }
            d7.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new C1492a(iH, strL + strL2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new y(arrayList);
    }

    @Override // p1.d
    public y b(p1.b bVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new D(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
