package w6;

import M5.m;
import java.io.EOFException;
import v6.C;
import v6.e;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f23418a = C.a("0123456789abcdef");

    public static final byte[] a() {
        return f23418a;
    }

    public static final String b(e eVar, long j7) throws EOFException {
        m.e(eVar, "<this>");
        if (j7 > 0) {
            long j8 = j7 - 1;
            if (eVar.u(j8) == 13) {
                String strH = eVar.H(j8);
                eVar.skip(2L);
                return strH;
            }
        }
        String strH2 = eVar.H(j7);
        eVar.skip(1L);
        return strH2;
    }
}
