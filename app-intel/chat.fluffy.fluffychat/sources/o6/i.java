package o6;

import java.net.Proxy;
import k6.s;
import k6.y;

/* loaded from: classes3.dex */
public abstract class i {
    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.g());
        sb.append(' ');
        if (b(yVar, type)) {
            sb.append(yVar.i());
        } else {
            sb.append(c(yVar.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static boolean b(y yVar, Proxy.Type type) {
        return !yVar.f() && type == Proxy.Type.HTTP;
    }

    public static String c(s sVar) {
        String strG = sVar.g();
        String strI = sVar.i();
        if (strI == null) {
            return strG;
        }
        return strG + '?' + strI;
    }
}
