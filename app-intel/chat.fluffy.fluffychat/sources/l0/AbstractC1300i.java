package l0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import m0.C1320b;

/* renamed from: l0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1300i {

    /* renamed from: l0.i$a */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f19529a;

        public a(ByteBuffer byteBuffer) {
            this.f19529a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // l0.AbstractC1300i.c
        public void a(int i7) {
            ByteBuffer byteBuffer = this.f19529a;
            byteBuffer.position(byteBuffer.position() + i7);
        }

        @Override // l0.AbstractC1300i.c
        public int b() {
            return this.f19529a.getInt();
        }

        @Override // l0.AbstractC1300i.c
        public long c() {
            return AbstractC1300i.c(this.f19529a.getInt());
        }

        @Override // l0.AbstractC1300i.c
        public long getPosition() {
            return this.f19529a.position();
        }

        @Override // l0.AbstractC1300i.c
        public int readUnsignedShort() {
            return AbstractC1300i.d(this.f19529a.getShort());
        }
    }

    /* renamed from: l0.i$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f19530a;

        /* renamed from: b, reason: collision with root package name */
        public final long f19531b;

        public b(long j7, long j8) {
            this.f19530a = j7;
            this.f19531b = j8;
        }

        public long a() {
            return this.f19530a;
        }
    }

    /* renamed from: l0.i$c */
    public interface c {
        void a(int i7);

        int b();

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    public static b a(c cVar) throws IOException {
        long jC;
        cVar.a(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.a(6);
        int i7 = 0;
        while (true) {
            if (i7 >= unsignedShort) {
                jC = -1;
                break;
            }
            int iB = cVar.b();
            cVar.a(4);
            jC = cVar.c();
            cVar.a(4);
            if (1835365473 == iB) {
                break;
            }
            i7++;
        }
        if (jC != -1) {
            cVar.a((int) (jC - cVar.getPosition()));
            cVar.a(12);
            long jC2 = cVar.c();
            for (int i8 = 0; i8 < jC2; i8++) {
                int iB2 = cVar.b();
                long jC3 = cVar.c();
                long jC4 = cVar.c();
                if (1164798569 == iB2 || 1701669481 == iB2) {
                    return new b(jC3 + jC, jC4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static C1320b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return C1320b.h(byteBufferDuplicate);
    }

    public static long c(int i7) {
        return i7 & 4294967295L;
    }

    public static int d(short s7) {
        return s7 & 65535;
    }
}
