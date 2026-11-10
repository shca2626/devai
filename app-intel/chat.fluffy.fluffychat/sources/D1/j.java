package D1;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class j extends H0.h implements l {

    /* renamed from: o, reason: collision with root package name */
    public final String f1618o;

    public class a extends q {
        public a() {
        }

        @Override // H0.g
        public void r() {
            j.this.t(this);
        }
    }

    public j(String str) {
        super(new p[2], new q[2]);
        this.f1618o = str;
        w(1024);
    }

    @Override // H0.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final m k(Throwable th) {
        return new m("Unexpected decode error", th);
    }

    public abstract k B(byte[] bArr, int i7, boolean z7);

    @Override // H0.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final m l(p pVar, q qVar, boolean z7) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) j3.o.q(pVar.f3330o);
            qVar.s(pVar.f3332q, B(byteBuffer.array(), byteBuffer.limit(), z7), pVar.f1634u);
            qVar.f3340o = false;
            return null;
        } catch (m e7) {
            return e7;
        }
    }

    @Override // H0.h
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final p i() {
        return new p();
    }

    @Override // H0.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final q j() {
        return new a();
    }

    @Override // D1.l
    public void c(long j7) {
    }
}
