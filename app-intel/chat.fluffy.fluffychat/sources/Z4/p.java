package Z4;

import Z4.c;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public int f10348a;

    /* renamed from: b, reason: collision with root package name */
    public int f10349b;

    /* renamed from: c, reason: collision with root package name */
    public int f10350c;

    /* renamed from: d, reason: collision with root package name */
    public String f10351d;

    /* renamed from: e, reason: collision with root package name */
    public int f10352e;

    /* renamed from: f, reason: collision with root package name */
    public int f10353f;

    /* renamed from: g, reason: collision with root package name */
    public int f10354g;

    public static p a(ByteBuffer byteBuffer, c.a aVar) {
        p pVar = new p();
        byte[] bArrB = n.b(byteBuffer);
        a.a(bArrB, pVar);
        if (pVar.b()) {
            o.b(bArrB, pVar);
            aVar.a(pVar.f10348a, pVar.f10349b);
            b.a(bArrB, pVar);
        }
        return pVar;
    }

    public boolean b() {
        return "image/heif".equals(this.f10351d);
    }
}
