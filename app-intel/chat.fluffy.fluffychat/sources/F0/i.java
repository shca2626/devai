package F0;

import E0.D;
import j3.o;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i {

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2561a;

        public b(e eVar, d dVar) throws c {
            int i7 = dVar.f2562a;
            o.d(i7 == 6 || i7 == 3);
            byte[] bArr = new byte[Math.min(4, dVar.f2563b.remaining())];
            dVar.f2563b.asReadOnlyBuffer().get(bArr);
            D d7 = new D(bArr);
            i.f(eVar.f2564a);
            if (d7.g()) {
                this.f2561a = false;
                return;
            }
            int iH = d7.h(2);
            boolean zG = d7.g();
            i.f(eVar.f2565b);
            if (!zG) {
                this.f2561a = true;
                return;
            }
            boolean zG2 = (iH == 3 || iH == 0) ? true : d7.g();
            d7.q();
            i.f(!eVar.f2567d);
            if (d7.g()) {
                i.f(!eVar.f2568e);
                d7.q();
            }
            i.f(eVar.f2566c);
            if (iH != 3) {
                d7.q();
            }
            d7.r(eVar.f2569f);
            if (iH != 2 && iH != 0 && !zG2) {
                d7.r(3);
            }
            this.f2561a = ((iH == 3 || iH == 0) ? 255 : d7.h(8)) != 0;
        }

        public static b b(e eVar, d dVar) {
            try {
                return new b(eVar, dVar);
            } catch (c unused) {
                return null;
            }
        }

        public boolean a() {
            return this.f2561a;
        }
    }

    public static class c extends Exception {
        public c() {
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f2562a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteBuffer f2563b;

        public d(int i7, ByteBuffer byteBuffer) {
            this.f2562a = i7;
            this.f2563b = byteBuffer;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2564a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f2565b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f2566c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2567d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f2568e;

        /* renamed from: f, reason: collision with root package name */
        public final int f2569f;

        /* renamed from: g, reason: collision with root package name */
        public final int f2570g;

        /* renamed from: h, reason: collision with root package name */
        public final int f2571h;

        /* renamed from: i, reason: collision with root package name */
        public final int f2572i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f2573j;

        /* renamed from: k, reason: collision with root package name */
        public final int f2574k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f2575l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f2576m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f2577n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f2578o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f2579p;

        /* renamed from: q, reason: collision with root package name */
        public final int f2580q;

        /* renamed from: r, reason: collision with root package name */
        public final byte f2581r;

        /* renamed from: s, reason: collision with root package name */
        public final byte f2582s;

        /* renamed from: t, reason: collision with root package name */
        public final byte f2583t;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v4, types: [int] */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6 */
        public e(d dVar) {
            int iH;
            int iH2;
            boolean zG;
            ?? r8;
            o.d(dVar.f2562a == 1);
            byte[] bArr = new byte[dVar.f2563b.remaining()];
            dVar.f2563b.asReadOnlyBuffer().get(bArr);
            D d7 = new D(bArr);
            this.f2570g = d7.h(3);
            d7.q();
            boolean zG2 = d7.g();
            this.f2564a = zG2;
            if (zG2) {
                iH2 = d7.h(5);
                this.f2565b = false;
                this.f2573j = false;
                r8 = 0;
                iH = 0;
            } else {
                if (d7.g()) {
                    b(d7);
                    boolean zG3 = d7.g();
                    this.f2565b = zG3;
                    if (zG3) {
                        d7.r(47);
                    }
                } else {
                    this.f2565b = false;
                }
                this.f2573j = d7.g();
                int iH3 = d7.h(5);
                int iH4 = 0;
                int i7 = 0;
                boolean z7 = false;
                iH = 0;
                while (i7 <= iH3) {
                    d7.r(12);
                    if (i7 == 0) {
                        iH4 = d7.h(5);
                        zG = z7;
                        if (iH4 > 7) {
                            zG = d7.g();
                        }
                    } else {
                        zG = z7;
                        if (d7.h(5) > 7) {
                            d7.q();
                            zG = z7;
                        }
                    }
                    if (this.f2565b) {
                        d7.q();
                    }
                    if (this.f2573j && d7.g()) {
                        if (i7 == 0) {
                            iH = d7.h(4);
                        } else {
                            d7.r(4);
                        }
                    }
                    i7++;
                    z7 = zG;
                }
                iH2 = iH4;
                r8 = z7;
            }
            int iH5 = d7.h(4);
            int iH6 = d7.h(4);
            d7.r(iH5 + 1);
            d7.r(iH6 + 1);
            if (this.f2564a) {
                this.f2566c = false;
            } else {
                this.f2566c = d7.g();
            }
            if (this.f2566c) {
                d7.r(4);
                d7.r(3);
            }
            d7.r(3);
            if (this.f2564a) {
                this.f2568e = true;
                this.f2567d = true;
                this.f2569f = 0;
            } else {
                d7.r(4);
                boolean zG4 = d7.g();
                if (zG4) {
                    d7.r(2);
                }
                if (d7.g()) {
                    this.f2567d = true;
                } else {
                    this.f2567d = d7.g();
                }
                if (!this.f2567d || d7.g()) {
                    this.f2568e = true;
                } else {
                    this.f2568e = d7.g();
                }
                if (zG4) {
                    this.f2569f = d7.h(3) + 1;
                } else {
                    this.f2569f = 0;
                }
            }
            this.f2571h = iH2;
            this.f2572i = r8;
            this.f2574k = iH;
            d7.r(3);
            boolean zG5 = d7.g();
            this.f2575l = zG5;
            if (this.f2570g == 2 && zG5) {
                this.f2576m = d7.g();
            } else {
                this.f2576m = false;
            }
            if (this.f2570g != 1) {
                this.f2577n = d7.g();
            } else {
                this.f2577n = false;
            }
            if (d7.g()) {
                this.f2581r = (byte) d7.h(8);
                this.f2582s = (byte) d7.h(8);
                this.f2583t = (byte) d7.h(8);
            } else {
                this.f2581r = (byte) 0;
                this.f2582s = (byte) 0;
                this.f2583t = (byte) 0;
            }
            if (this.f2577n) {
                d7.q();
                this.f2578o = false;
                this.f2579p = false;
                this.f2580q = 0;
            } else if (this.f2581r == 1 && this.f2582s == 13 && this.f2583t == 0) {
                this.f2578o = false;
                this.f2579p = false;
                this.f2580q = 0;
            } else {
                d7.q();
                int i8 = this.f2570g;
                if (i8 == 0) {
                    this.f2578o = true;
                    this.f2579p = true;
                } else if (i8 == 1) {
                    this.f2578o = false;
                    this.f2579p = false;
                } else if (this.f2576m) {
                    boolean zG6 = d7.g();
                    this.f2578o = zG6;
                    if (zG6) {
                        this.f2579p = d7.g();
                    } else {
                        this.f2579p = false;
                    }
                } else {
                    this.f2578o = true;
                    this.f2579p = false;
                }
                if (this.f2578o && this.f2579p) {
                    this.f2580q = d7.h(2);
                } else {
                    this.f2580q = 0;
                }
            }
            d7.q();
        }

        public static e a(d dVar) {
            try {
                return new e(dVar);
            } catch (c unused) {
                return null;
            }
        }

        public static void b(D d7) {
            d7.r(64);
            if (d7.g()) {
                i.d(d7);
            }
        }
    }

    public static int c(ByteBuffer byteBuffer) {
        int i7 = 0;
        for (int i8 = 0; i8 < 8; i8++) {
            byte b7 = byteBuffer.get();
            i7 |= (b7 & Byte.MAX_VALUE) << (i8 * 7);
            if ((b7 & 128) == 0) {
                return i7;
            }
        }
        return i7;
    }

    public static void d(D d7) {
        int i7 = 0;
        while (!d7.g()) {
            i7++;
        }
        if (i7 < 32) {
            d7.r(i7);
        }
    }

    public static List e(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (byteBufferAsReadOnlyBuffer.hasRemaining()) {
            try {
                byte b7 = byteBufferAsReadOnlyBuffer.get();
                int i7 = (b7 >> 3) & 15;
                if (((b7 >> 2) & 1) != 0) {
                    byteBufferAsReadOnlyBuffer.get();
                }
                int iC = ((b7 >> 1) & 1) != 0 ? c(byteBufferAsReadOnlyBuffer) : byteBufferAsReadOnlyBuffer.remaining();
                if (byteBufferAsReadOnlyBuffer.position() + iC > byteBufferAsReadOnlyBuffer.limit()) {
                    break;
                }
                ByteBuffer byteBufferDuplicate = byteBufferAsReadOnlyBuffer.duplicate();
                byteBufferDuplicate.limit(byteBufferAsReadOnlyBuffer.position() + iC);
                arrayList.add(new d(i7, byteBufferDuplicate));
                byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.position() + iC);
            } catch (BufferUnderflowException unused) {
            }
        }
        return arrayList;
    }

    public static void f(boolean z7) throws c {
        if (z7) {
            throw new c();
        }
    }
}
