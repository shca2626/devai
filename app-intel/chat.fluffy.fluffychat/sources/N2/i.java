package N2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class i implements Closeable {

    /* renamed from: l, reason: collision with root package name */
    public final int f6370l = 1179403647;

    /* renamed from: m, reason: collision with root package name */
    public final FileChannel f6371m;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f6371m = new FileInputStream(file).getChannel();
    }

    public final long a(d dVar, long j7, long j8) {
        for (long j9 = 0; j9 < j7; j9++) {
            e eVarB = dVar.b(j9);
            if (eVarB.f6363a == 1) {
                long j10 = eVarB.f6365c;
                if (j10 <= j8 && j8 <= eVarB.f6366d + j10) {
                    return (j8 - j10) + eVarB.f6364b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6371m.close();
    }

    public d d() throws IOException {
        this.f6371m.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (r(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sI = i(byteBufferAllocate, 4L);
        boolean z7 = i(byteBufferAllocate, 5L) == 2;
        if (sI == 1) {
            return new g(z7, this);
        }
        if (sI == 2) {
            return new h(z7, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List e() throws IOException {
        long j7;
        this.f6371m.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarD = d();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarD.f6354a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = dVarD.f6359f;
        if (j8 == 65535) {
            j8 = dVarD.c(0).f6367a;
        }
        long j9 = 0;
        while (true) {
            if (j9 >= j8) {
                j7 = 0;
                break;
            }
            e eVarB = dVarD.b(j9);
            if (eVarB.f6363a == 2) {
                j7 = eVarB.f6364b;
                break;
            }
            j9++;
        }
        if (j7 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j10 = 0;
        int i7 = 0;
        while (true) {
            c cVarA = dVarD.a(j7, i7);
            long j11 = j7;
            long j12 = cVarA.f6352a;
            if (j12 == 1) {
                arrayList2.add(Long.valueOf(cVarA.f6353b));
            } else if (j12 == 5) {
                j10 = cVarA.f6353b;
            }
            i7++;
            if (cVarA.f6352a == 0) {
                break;
            }
            j7 = j11;
            j8 = j8;
        }
        if (j10 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(dVarD, j8, j10);
        int size = arrayList2.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList2.get(i8);
            i8++;
            arrayList.add(o(byteBufferAllocate, ((Long) obj).longValue() + jA));
        }
        return arrayList;
    }

    public void f(ByteBuffer byteBuffer, long j7, int i7) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i7);
        long j8 = 0;
        while (j8 < i7) {
            int i8 = this.f6371m.read(byteBuffer, j7 + j8);
            if (i8 == -1) {
                throw new EOFException();
            }
            j8 += i8;
        }
        byteBuffer.position(0);
    }

    public short i(ByteBuffer byteBuffer, long j7) throws IOException {
        f(byteBuffer, j7, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int j(ByteBuffer byteBuffer, long j7) throws IOException {
        f(byteBuffer, j7, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long n(ByteBuffer byteBuffer, long j7) throws IOException {
        f(byteBuffer, j7, 8);
        return byteBuffer.getLong();
    }

    public String o(ByteBuffer byteBuffer, long j7) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j8 = 1 + j7;
            short sI = i(byteBuffer, j7);
            if (sI == 0) {
                return sb.toString();
            }
            sb.append((char) sI);
            j7 = j8;
        }
    }

    public long r(ByteBuffer byteBuffer, long j7) throws IOException {
        f(byteBuffer, j7, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
