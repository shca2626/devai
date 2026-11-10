package e1;

import F0.i;
import com.fasterxml.jackson.core.JsonLocation;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: e1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1015a {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f15367a = ByteBuffer.allocateDirect(JsonLocation.MAX_CONTENT_SNIPPET);

    /* renamed from: b, reason: collision with root package name */
    public i.e f15368b;

    public final boolean a(i.d dVar, boolean z7) {
        i.e eVar;
        i.b bVarB;
        int i7 = dVar.f2562a;
        if (i7 == 2 || i7 == 15) {
            return true;
        }
        if (i7 != 3 || z7) {
            return ((i7 != 6 && i7 != 3) || (eVar = this.f15368b) == null || (bVarB = i.b.b(eVar, dVar)) == null || bVarB.a()) ? false : true;
        }
        return false;
    }

    public final void b() {
        ByteBuffer byteBuffer = this.f15367a;
        byteBuffer.position(byteBuffer.limit());
    }

    public void c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, iPosition + JsonLocation.MAX_CONTENT_SNIPPET));
        this.f15367a.clear();
        this.f15367a.put(byteBuffer);
        this.f15367a.flip();
        byteBuffer.position(iPosition);
        byteBuffer.limit(iLimit);
    }

    public void d() {
        this.f15368b = null;
        b();
    }

    public int e(ByteBuffer byteBuffer, boolean z7) {
        if (this.f15367a.hasRemaining()) {
            f(F0.i.e(this.f15367a));
            b();
        }
        List listE = F0.i.e(byteBuffer);
        f(listE);
        int size = listE.size() - 1;
        int i7 = 0;
        while (size >= 0 && a((i.d) listE.get(size), z7)) {
            if (((i.d) listE.get(size)).f2562a == 6 || ((i.d) listE.get(size)).f2562a == 3) {
                i7++;
            }
            size--;
        }
        return (i7 > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((i.d) listE.get(size)).f2563b.limit() : byteBuffer.position();
    }

    public final void f(List list) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (((i.d) list.get(i7)).f2562a == 1) {
                this.f15368b = i.e.a((i.d) list.get(i7));
            }
        }
    }
}
