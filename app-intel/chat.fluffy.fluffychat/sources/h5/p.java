package h5;

import h5.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class p implements k {

    /* renamed from: b, reason: collision with root package name */
    public static final p f16910b = new p(o.f16907a);

    /* renamed from: a, reason: collision with root package name */
    public final o f16911a;

    public p(o oVar) {
        this.f16911a = oVar;
    }

    @Override // h5.k
    public ByteBuffer a(i iVar) {
        o.a aVar = new o.a();
        this.f16911a.p(aVar, iVar.f16895a);
        this.f16911a.p(aVar, iVar.f16896b);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // h5.k
    public i b(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object objF = this.f16911a.f(byteBuffer);
        Object objF2 = this.f16911a.f(byteBuffer);
        if (!(objF instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new i((String) objF, objF2);
    }

    @Override // h5.k
    public ByteBuffer c(Object obj) throws IOException {
        o.a aVar = new o.a();
        aVar.write(0);
        this.f16911a.p(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // h5.k
    public ByteBuffer d(String str, String str2, Object obj, String str3) throws IOException {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f16911a.p(aVar, str);
        this.f16911a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f16911a.p(aVar, U4.b.d((Throwable) obj));
        } else {
            this.f16911a.p(aVar, obj);
        }
        this.f16911a.p(aVar, str3);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // h5.k
    public ByteBuffer e(String str, String str2, Object obj) throws IOException {
        o.a aVar = new o.a();
        aVar.write(1);
        this.f16911a.p(aVar, str);
        this.f16911a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f16911a.p(aVar, U4.b.d((Throwable) obj));
        } else {
            this.f16911a.p(aVar, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // h5.k
    public Object f(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b7 = byteBuffer.get();
        if (b7 != 0) {
            if (b7 == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object objF = this.f16911a.f(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return objF;
        }
        Object objF2 = this.f16911a.f(byteBuffer);
        Object objF3 = this.f16911a.f(byteBuffer);
        Object objF4 = this.f16911a.f(byteBuffer);
        if ((objF2 instanceof String) && ((objF3 == null || (objF3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new d((String) objF2, (String) objF3, objF4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }
}
