package p0;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.fasterxml.jackson.core.JsonPointer;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import p0.AbstractC1437b;

/* renamed from: p0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1436a {

    /* renamed from: V, reason: collision with root package name */
    public static final SimpleDateFormat f20678V;

    /* renamed from: W, reason: collision with root package name */
    public static final SimpleDateFormat f20679W;

    /* renamed from: a0, reason: collision with root package name */
    public static final e[] f20683a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final e[] f20684b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final e[] f20685c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final e[] f20686d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final e[] f20687e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final e f20688f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final e[] f20689g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final e[] f20690h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final e[] f20691i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final e[] f20692j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final e[][] f20693k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final e[] f20694l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final HashMap[] f20695m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final HashMap[] f20696n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final Set f20697o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final HashMap f20698p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final Charset f20699q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final byte[] f20700r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final byte[] f20701s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final Pattern f20702t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final Pattern f20703u0;

    /* renamed from: v0, reason: collision with root package name */
    public static final Pattern f20704v0;

    /* renamed from: w0, reason: collision with root package name */
    public static final Pattern f20706w0;

    /* renamed from: a, reason: collision with root package name */
    public String f20710a;

    /* renamed from: b, reason: collision with root package name */
    public FileDescriptor f20711b;

    /* renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f20712c;

    /* renamed from: d, reason: collision with root package name */
    public int f20713d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20714e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap[] f20715f;

    /* renamed from: g, reason: collision with root package name */
    public Set f20716g;

    /* renamed from: h, reason: collision with root package name */
    public ByteOrder f20717h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20718i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20719j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20720k;

    /* renamed from: l, reason: collision with root package name */
    public int f20721l;

    /* renamed from: m, reason: collision with root package name */
    public int f20722m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f20723n;

    /* renamed from: o, reason: collision with root package name */
    public int f20724o;

    /* renamed from: p, reason: collision with root package name */
    public int f20725p;

    /* renamed from: q, reason: collision with root package name */
    public int f20726q;

    /* renamed from: r, reason: collision with root package name */
    public int f20727r;

    /* renamed from: s, reason: collision with root package name */
    public int f20728s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20729t;

    /* renamed from: u, reason: collision with root package name */
    public d f20730u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f20731v;

    /* renamed from: w, reason: collision with root package name */
    public static final boolean f20705w = Log.isLoggable("ExifInterface", 3);

    /* renamed from: x, reason: collision with root package name */
    public static final List f20707x = Arrays.asList(1, 6, 3, 8);

    /* renamed from: y, reason: collision with root package name */
    public static final List f20708y = Arrays.asList(2, 7, 4, 5);

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f20709z = {8, 8, 8};

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f20657A = {4};

    /* renamed from: B, reason: collision with root package name */
    public static final int[] f20658B = {8};

    /* renamed from: C, reason: collision with root package name */
    public static final byte[] f20659C = {-1, -40, -1};

    /* renamed from: D, reason: collision with root package name */
    public static final byte[] f20660D = {102, 116, 121, 112};

    /* renamed from: E, reason: collision with root package name */
    public static final byte[] f20661E = {109, 105, 102, 49};

    /* renamed from: F, reason: collision with root package name */
    public static final byte[] f20662F = {104, 101, 105, 99};

    /* renamed from: G, reason: collision with root package name */
    public static final byte[] f20663G = {97, 118, 105, 102};

    /* renamed from: H, reason: collision with root package name */
    public static final byte[] f20664H = {97, 118, 105, 115};

    /* renamed from: I, reason: collision with root package name */
    public static final byte[] f20665I = {79, 76, 89, 77, 80, 0};

    /* renamed from: J, reason: collision with root package name */
    public static final byte[] f20666J = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: K, reason: collision with root package name */
    public static final byte[] f20667K = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: L, reason: collision with root package name */
    public static final byte[] f20668L = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);

    /* renamed from: M, reason: collision with root package name */
    public static final byte[] f20669M = {82, 73, 70, 70};

    /* renamed from: N, reason: collision with root package name */
    public static final byte[] f20670N = {87, 69, 66, 80};

    /* renamed from: O, reason: collision with root package name */
    public static final byte[] f20671O = {69, 88, 73, 70};

    /* renamed from: P, reason: collision with root package name */
    public static final byte[] f20672P = {-99, 1, 42};

    /* renamed from: Q, reason: collision with root package name */
    public static final byte[] f20673Q = "VP8X".getBytes(Charset.defaultCharset());

    /* renamed from: R, reason: collision with root package name */
    public static final byte[] f20674R = "VP8L".getBytes(Charset.defaultCharset());

    /* renamed from: S, reason: collision with root package name */
    public static final byte[] f20675S = "VP8 ".getBytes(Charset.defaultCharset());

    /* renamed from: T, reason: collision with root package name */
    public static final byte[] f20676T = "ANIM".getBytes(Charset.defaultCharset());

    /* renamed from: U, reason: collision with root package name */
    public static final byte[] f20677U = "ANMF".getBytes(Charset.defaultCharset());

    /* renamed from: X, reason: collision with root package name */
    public static final String[] f20680X = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: Y, reason: collision with root package name */
    public static final int[] f20681Y = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: Z, reason: collision with root package name */
    public static final byte[] f20682Z = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: p0.a$c */
    public static class c extends FilterOutputStream {

        /* renamed from: l, reason: collision with root package name */
        public final DataOutputStream f20740l;

        /* renamed from: m, reason: collision with root package name */
        public ByteOrder f20741m;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f20740l = new DataOutputStream(outputStream);
            this.f20741m = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f20741m = byteOrder;
        }

        public void d(int i7) throws IOException {
            this.f20740l.write(i7);
        }

        public void e(int i7) throws IOException {
            ByteOrder byteOrder = this.f20741m;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f20740l.write(i7 & 255);
                this.f20740l.write((i7 >>> 8) & 255);
                this.f20740l.write((i7 >>> 16) & 255);
                this.f20740l.write((i7 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f20740l.write((i7 >>> 24) & 255);
                this.f20740l.write((i7 >>> 16) & 255);
                this.f20740l.write((i7 >>> 8) & 255);
                this.f20740l.write(i7 & 255);
            }
        }

        public void f(short s7) throws IOException {
            ByteOrder byteOrder = this.f20741m;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f20740l.write(s7 & 255);
                this.f20740l.write((s7 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f20740l.write((s7 >>> 8) & 255);
                this.f20740l.write(s7 & 255);
            }
        }

        public void i(long j7) throws IOException {
            if (j7 > 4294967295L) {
                throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
            }
            e((int) j7);
        }

        public void j(int i7) throws IOException {
            if (i7 > 65535) {
                throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
            }
            f((short) i7);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f20740l.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) throws IOException {
            this.f20740l.write(bArr, i7, i8);
        }
    }

    /* renamed from: p0.a$d */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f20742a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20743b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20744c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f20745d;

        public d(int i7, int i8, byte[] bArr) {
            this(i7, i8, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(C1436a.f20699q0);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C1436a.f20681Y[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d7 : dArr) {
                byteBufferWrap.putDouble(d7);
            }
            return new d(12, dArr.length, byteBufferWrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C1436a.f20681Y[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i7 : iArr) {
                byteBufferWrap.putInt(i7);
            }
            return new d(9, iArr.length, byteBufferWrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C1436a.f20681Y[10] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.f20750a);
                byteBufferWrap.putInt((int) fVar.f20751b);
            }
            return new d(10, fVarArr.length, byteBufferWrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(C1436a.f20699q0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j7, ByteOrder byteOrder) {
            return g(new long[]{j7}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C1436a.f20681Y[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j7 : jArr) {
                byteBufferWrap.putInt((int) j7);
            }
            return new d(4, jArr.length, byteBufferWrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C1436a.f20681Y[5] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.f20750a);
                byteBufferWrap.putInt((int) fVar.f20751b);
            }
            return new d(5, fVarArr.length, byteBufferWrap.array());
        }

        public static d j(int i7, ByteOrder byteOrder) {
            return k(new int[]{i7}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C1436a.f20681Y[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i7 : iArr) {
                byteBufferWrap.putShort((short) i7);
            }
            return new d(3, iArr.length, byteBufferWrap.array());
        }

        public double l(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objO instanceof String) {
                return Double.parseDouble((String) objO);
            }
            if (objO instanceof long[]) {
                if (((long[]) objO).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof int[]) {
                if (((int[]) objO).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof f[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            f[] fVarArr = (f[]) objO;
            if (fVarArr.length == 1) {
                return fVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int m(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objO instanceof String) {
                return Integer.parseInt((String) objO);
            }
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objO;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String n(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                return null;
            }
            if (objO instanceof String) {
                return (String) objO;
            }
            StringBuilder sb = new StringBuilder();
            int i7 = 0;
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                while (i7 < jArr.length) {
                    sb.append(jArr[i7]);
                    i7++;
                    if (i7 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objO instanceof int[]) {
                int[] iArr = (int[]) objO;
                while (i7 < iArr.length) {
                    sb.append(iArr[i7]);
                    i7++;
                    if (i7 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                while (i7 < dArr.length) {
                    sb.append(dArr[i7]);
                    i7++;
                    if (i7 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objO instanceof f[])) {
                return null;
            }
            f[] fVarArr = (f[]) objO;
            while (i7 < fVarArr.length) {
                sb.append(fVarArr[i7].f20750a);
                sb.append(JsonPointer.SEPARATOR);
                sb.append(fVarArr[i7].f20751b);
                i7++;
                if (i7 != fVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:18:0x0031 */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:124:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r13v21, types: [int[]] */
        /* JADX WARN: Type inference failed for: r13v23, types: [long[]] */
        /* JADX WARN: Type inference failed for: r13v25, types: [p0.a$f[]] */
        /* JADX WARN: Type inference failed for: r13v27, types: [int[]] */
        /* JADX WARN: Type inference failed for: r13v29, types: [int[]] */
        /* JADX WARN: Type inference failed for: r13v31, types: [p0.a$f[]] */
        /* JADX WARN: Type inference failed for: r13v33, types: [double[]] */
        /* JADX WARN: Type inference failed for: r13v36, types: [double[]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object o(java.nio.ByteOrder r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return C1436a.f20681Y[this.f20742a] * this.f20743b;
        }

        public String toString() {
            return "(" + C1436a.f20680X[this.f20742a] + ", data length:" + this.f20745d.length + ")";
        }

        public d(int i7, int i8, long j7, byte[] bArr) {
            this.f20742a = i7;
            this.f20743b = i8;
            this.f20744c = j7;
            this.f20745d = bArr;
        }
    }

    /* renamed from: p0.a$f */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f20750a;

        /* renamed from: b, reason: collision with root package name */
        public final long f20751b;

        public /* synthetic */ f(long j7, long j8, C0239a c0239a) {
            this(j7, j8);
        }

        public static f b(double d7) {
            long j7;
            long j8;
            long j9 = 1;
            if (d7 >= 9.223372036854776E18d || d7 <= -9.223372036854776E18d) {
                return new f(d7 > 0.0d ? Long.MAX_VALUE : Long.MIN_VALUE, 1L);
            }
            double dAbs = Math.abs(d7);
            long j10 = 0;
            long j11 = 1;
            double d8 = dAbs;
            long j12 = 0;
            while (true) {
                double d9 = d8 % 1.0d;
                long j13 = (long) (d8 - d9);
                j7 = j12 + (j13 * j9);
                j8 = (j13 * j10) + j11;
                d8 = 1.0d / d9;
                long j14 = j9;
                if (Math.abs(dAbs - (j7 / j8)) <= 1.0E-8d * dAbs) {
                    break;
                }
                j11 = j10;
                j9 = j7;
                j12 = j14;
                j10 = j8;
            }
            if (d7 < 0.0d) {
                j7 = -j7;
            }
            return new f(j7, j8);
        }

        public double a() {
            return this.f20750a / this.f20751b;
        }

        public String toString() {
            return this.f20750a + "/" + this.f20751b;
        }

        public f(long j7, long j8) {
            if (j8 == 0) {
                this.f20750a = 0L;
                this.f20751b = 1L;
            } else {
                this.f20750a = j7;
                this.f20751b = j8;
            }
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        f20683a0 = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f20684b0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f20685c0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f20686d0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f20687e0 = eVarArr5;
        f20688f0 = new e("StripOffsets", 273, 3);
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f20689g0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f20690h0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f20691i0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f20692j0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f20693k0 = eVarArr10;
        f20694l0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f20695m0 = new HashMap[eVarArr10.length];
        f20696n0 = new HashMap[eVarArr10.length];
        f20697o0 = Collections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        f20698p0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f20699q0 = charsetForName;
        f20700r0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f20701s0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f20678V = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f20679W = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i7 = 0;
        while (true) {
            e[][] eVarArr11 = f20693k0;
            if (i7 >= eVarArr11.length) {
                HashMap map = f20698p0;
                e[] eVarArr12 = f20694l0;
                map.put(Integer.valueOf(eVarArr12[0].f20746a), 5);
                map.put(Integer.valueOf(eVarArr12[1].f20746a), 1);
                map.put(Integer.valueOf(eVarArr12[2].f20746a), 2);
                map.put(Integer.valueOf(eVarArr12[3].f20746a), 3);
                map.put(Integer.valueOf(eVarArr12[4].f20746a), 7);
                map.put(Integer.valueOf(eVarArr12[5].f20746a), 8);
                f20702t0 = Pattern.compile(".*[1-9].*");
                f20703u0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f20704v0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f20706w0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f20695m0[i7] = new HashMap();
            f20696n0[i7] = new HashMap();
            for (e eVar : eVarArr11[i7]) {
                f20695m0[i7].put(Integer.valueOf(eVar.f20746a), eVar);
                f20696n0[i7].put(eVar.f20747b, eVar);
            }
            i7++;
        }
    }

    public C1436a(String str) throws Throwable {
        e[][] eVarArr = f20693k0;
        this.f20715f = new HashMap[eVarArr.length];
        this.f20716g = new HashSet(eVarArr.length);
        this.f20717h = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        B(str);
    }

    public static boolean E(byte[] bArr) {
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f20659C;
            if (i7 >= bArr2.length) {
                return true;
            }
            if (bArr[i7] != bArr2[i7]) {
                return false;
            }
            i7++;
        }
    }

    public static boolean J(FileDescriptor fileDescriptor) throws ErrnoException {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f20705w) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public static boolean L(int i7) {
        return i7 == 4 || i7 == 13 || i7 == 14;
    }

    public static boolean d0(int i7) {
        return (i7 == 4 || i7 == 9 || i7 == 13 || i7 == 14) ? false : true;
    }

    public static void f0(CRC32 crc32, int i7) {
        crc32.update(i7 >>> 24);
        crc32.update(i7 >>> 16);
        crc32.update(i7 >>> 8);
        crc32.update(i7);
    }

    public static int x(int i7) {
        if (i7 != 4) {
            return (i7 == 9 || i7 == 15 || i7 == 12 || i7 == 13) ? 2 : 1;
        }
        return 3;
    }

    public static Pair y(String str) throws NumberFormatException {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairY = y(strArrSplit[0]);
            if (((Integer) pairY.first).intValue() == 2) {
                return pairY;
            }
            for (int i7 = 1; i7 < strArrSplit.length; i7++) {
                Pair pairY2 = y(strArrSplit[i7]);
                int iIntValue = (((Integer) pairY2.first).equals(pairY.first) || ((Integer) pairY2.second).equals(pairY.first)) ? ((Integer) pairY.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairY.second).intValue() == -1 || !(((Integer) pairY2.first).equals(pairY.second) || ((Integer) pairY2.second).equals(pairY.second))) ? -1 : ((Integer) pairY.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairY = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairY = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairY;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j7 = Long.parseLong(str);
                    return (j7 < 0 || j7 > 65535) ? j7 < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j8 = (long) Double.parseDouble(strArrSplit2[0]);
                long j9 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j8 >= 0 && j9 >= 0) {
                    if (j8 <= 2147483647L && j9 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public final void A(b bVar, HashMap map) throws IOException {
        int i7;
        d dVar = (d) map.get("StripOffsets");
        d dVar2 = (d) map.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] jArrC = AbstractC1437b.c(dVar.o(this.f20717h));
        long[] jArrC2 = AbstractC1437b.c(dVar2.o(this.f20717h));
        if (jArrC == null || jArrC.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrC2 == null || jArrC2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrC.length != jArrC2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j7 = 0;
        for (long j8 : jArrC2) {
            j7 += j8;
        }
        int i8 = (int) j7;
        byte[] bArr = new byte[i8];
        int i9 = 1;
        this.f20720k = true;
        this.f20719j = true;
        this.f20718i = true;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < jArrC.length) {
            int i13 = (int) jArrC[i10];
            int i14 = (int) jArrC2[i10];
            if (i10 < jArrC.length - i9) {
                i7 = i10;
                if (i13 + i14 != jArrC[i7 + 1]) {
                    this.f20720k = false;
                }
            } else {
                i7 = i10;
            }
            int i15 = i13 - i11;
            if (i15 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            try {
                bVar.j(i15);
                int i16 = i11 + i15;
                byte[] bArr2 = new byte[i14];
                try {
                    bVar.readFully(bArr2);
                    i11 = i16 + i14;
                    System.arraycopy(bArr2, 0, bArr, i12, i14);
                    i12 += i14;
                    i10 = i7 + 1;
                    i9 = 1;
                } catch (EOFException unused) {
                    Log.d("ExifInterface", "Failed to read " + i14 + " bytes.");
                    return;
                }
            } catch (EOFException unused2) {
                Log.d("ExifInterface", "Failed to skip " + i15 + " bytes.");
                return;
            }
        }
        this.f20723n = bArr;
        if (this.f20720k) {
            this.f20721l = (int) jArrC[0];
            this.f20722m = i8;
        }
    }

    public final void B(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f20712c = null;
        this.f20710a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (J(fileInputStream.getFD())) {
                this.f20711b = fileInputStream.getFD();
            } else {
                this.f20711b = null;
            }
            O(fileInputStream);
            AbstractC1437b.b(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC1437b.b(fileInputStream2);
            throw th;
        }
    }

    public boolean C() {
        int i7 = i("Orientation", 1);
        return i7 == 2 || i7 == 7 || i7 == 4 || i7 == 5;
    }

    public final int D(byte[] bArr) throws Throwable {
        b bVar;
        long length;
        byte[] bArr2;
        long j7;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            length = bVar.readInt();
            bArr2 = new byte[4];
            bVar.readFully(bArr2);
        } catch (Exception e8) {
            e = e8;
            bVar2 = bVar;
            if (f20705w) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, f20660D)) {
            bVar.close();
            return 0;
        }
        if (length == 1) {
            length = bVar.readLong();
            j7 = 16;
            if (length < 16) {
                bVar.close();
                return 0;
            }
        } else {
            j7 = 8;
        }
        if (length > bArr.length) {
            length = bArr.length;
        }
        long j8 = length - j7;
        if (j8 < 8) {
            bVar.close();
            return 0;
        }
        byte[] bArr3 = new byte[4];
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (long j9 = 0; j9 < j8 / 4; j9++) {
            try {
                bVar.readFully(bArr3);
                if (j9 != 1) {
                    if (Arrays.equals(bArr3, f20661E)) {
                        z7 = true;
                    } else if (Arrays.equals(bArr3, f20662F)) {
                        z8 = true;
                    } else if (Arrays.equals(bArr3, f20663G) || Arrays.equals(bArr3, f20664H)) {
                        z9 = true;
                    }
                    if (!z7) {
                        continue;
                    } else {
                        if (z8) {
                            bVar.close();
                            return 12;
                        }
                        if (z9) {
                            bVar.close();
                            return 15;
                        }
                    }
                }
            } catch (EOFException unused) {
                bVar.close();
                return 0;
            }
        }
        bVar.close();
        return 0;
    }

    public final boolean F(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderR = R(bVar2);
                this.f20717h = byteOrderR;
                bVar2.i(byteOrderR);
                short s7 = bVar2.readShort();
                boolean z7 = s7 == 20306 || s7 == 21330;
                bVar2.close();
                return z7;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean G(byte[] bArr) {
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f20667K;
            if (i7 >= bArr2.length) {
                return true;
            }
            if (bArr[i7] != bArr2[i7]) {
                return false;
            }
            i7++;
        }
    }

    public final boolean H(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i7 = 0; i7 < bytes.length; i7++) {
            if (bArr[i7] != bytes[i7]) {
                return false;
            }
        }
        return true;
    }

    public final boolean I(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderR = R(bVar2);
                this.f20717h = byteOrderR;
                bVar2.i(byteOrderR);
                boolean z7 = bVar2.readShort() == 85;
                bVar2.close();
                return z7;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean K(HashMap map) {
        d dVar;
        int iM;
        d dVar2 = (d) map.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.f20717h);
            int[] iArr2 = f20709z;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f20713d == 3 && (dVar = (d) map.get("PhotometricInterpretation")) != null && (((iM = dVar.m(this.f20717h)) == 1 && Arrays.equals(iArr, f20658B)) || (iM == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f20705w) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    public final boolean M(HashMap map) {
        d dVar = (d) map.get("ImageLength");
        d dVar2 = (d) map.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.f20717h) <= 512 && dVar2.m(this.f20717h) <= 512;
    }

    public final boolean N(byte[] bArr) {
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f20669M;
            if (i7 >= bArr2.length) {
                int i8 = 0;
                while (true) {
                    byte[] bArr3 = f20670N;
                    if (i8 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[f20669M.length + i8 + 4] != bArr3[i8]) {
                        return false;
                    }
                    i8++;
                }
            } else {
                if (bArr[i7] != bArr2[i7]) {
                    return false;
                }
                i7++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00af A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #2 {all -> 0x0013, blocks: (B:3:0x0002, B:5:0x0007, B:12:0x001c, B:14:0x0020, B:15:0x002e, B:17:0x0036, B:19:0x003f, B:38:0x0071, B:25:0x0050, B:32:0x005e, B:35:0x0066, B:36:0x006a, B:37:0x006e, B:39:0x007b, B:41:0x0085, B:44:0x008d, B:47:0x0095, B:50:0x009d, B:55:0x00ab, B:57:0x00af), top: B:66:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(java.io.InputStream r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = r0
        L2:
            p0.a$e[][] r2 = p0.C1436a.f20693k0     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            int r2 = r2.length     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            if (r1 >= r2) goto L1c
            java.util.HashMap[] r2 = r4.f20715f     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r3.<init>()     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r2[r1] = r3     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            int r1 = r1 + 1
            goto L2
        L13:
            r5 = move-exception
            goto Lbf
        L16:
            r5 = move-exception
            goto Lab
        L19:
            r5 = move-exception
            goto Lab
        L1c:
            boolean r1 = r4.f20714e     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            if (r1 != 0) goto L2e
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            int r5 = r4.m(r1)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r4.f20713d = r5     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r5 = r1
        L2e:
            int r1 = r4.f20713d     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            boolean r1 = d0(r1)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            if (r1 == 0) goto L7b
            p0.a$g r0 = new p0.a$g     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            boolean r5 = r4.f20714e     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            if (r5 == 0) goto L50
            boolean r5 = r4.t(r0)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            if (r5 != 0) goto L71
            r4.e()
            boolean r5 = p0.C1436a.f20705w
            if (r5 == 0) goto Lbe
            r4.Q()
            return
        L50:
            int r5 = r4.f20713d     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r1 = 12
            if (r5 == r1) goto L6e
            r1 = 15
            if (r5 != r1) goto L5b
            goto L6e
        L5b:
            r1 = 7
            if (r5 != r1) goto L62
            r4.n(r0)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto L71
        L62:
            r1 = 10
            if (r5 != r1) goto L6a
            r4.s(r0)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto L71
        L6a:
            r4.q(r0)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto L71
        L6e:
            r4.k(r0, r5)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
        L71:
            int r5 = r4.f20725p     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r0.n(r1)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r4.c0(r0)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto La0
        L7b:
            p0.a$b r1 = new p0.a$b     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            int r5 = r4.f20713d     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            r2 = 4
            if (r5 != r2) goto L89
            r4.l(r1, r0, r0)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto La0
        L89:
            r0 = 13
            if (r5 != r0) goto L91
            r4.o(r1)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto La0
        L91:
            r0 = 9
            if (r5 != r0) goto L99
            r4.p(r1)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
            goto La0
        L99:
            r0 = 14
            if (r5 != r0) goto La0
            r4.w(r1)     // Catch: java.lang.Throwable -> L13 java.lang.UnsupportedOperationException -> L16 java.io.IOException -> L19
        La0:
            r4.e()
            boolean r5 = p0.C1436a.f20705w
            if (r5 == 0) goto Lbe
            r4.Q()
            return
        Lab:
            boolean r0 = p0.C1436a.f20705w     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Lb6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file (ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch: java.lang.Throwable -> L13
        Lb6:
            r4.e()
            if (r0 == 0) goto Lbe
            r4.Q()
        Lbe:
            return
        Lbf:
            r4.e()
            boolean r0 = p0.C1436a.f20705w
            if (r0 == 0) goto Lc9
            r4.Q()
        Lc9:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.O(java.io.InputStream):void");
    }

    public final void P(b bVar) throws IOException {
        ByteOrder byteOrderR = R(bVar);
        this.f20717h = byteOrderR;
        bVar.i(byteOrderR);
        int unsignedShort = bVar.readUnsignedShort();
        int i7 = this.f20713d;
        if (i7 != 7 && i7 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i8 = bVar.readInt();
        if (i8 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i8);
        }
        int i9 = i8 - 8;
        if (i9 > 0) {
            bVar.j(i9);
        }
    }

    public final void Q() {
        for (int i7 = 0; i7 < this.f20715f.length; i7++) {
            Log.d("ExifInterface", "The size of tag group[" + i7 + "]: " + this.f20715f[i7].size());
            for (Map.Entry entry : this.f20715f[i7].entrySet()) {
                d dVar = (d) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.f20717h) + "'");
            }
        }
    }

    public final ByteOrder R(b bVar) throws IOException {
        short s7 = bVar.readShort();
        if (s7 == 18761) {
            if (f20705w) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s7 == 19789) {
            if (f20705w) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s7));
    }

    public final void S(byte[] bArr, int i7) throws IOException {
        g gVar = new g(bArr);
        P(gVar);
        T(gVar, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0285  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(p0.C1436a.g r26, int r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.T(p0.a$g, int):void");
    }

    public final void U(String str) {
        for (int i7 = 0; i7 < f20693k0.length; i7++) {
            this.f20715f[i7].remove(str);
        }
    }

    public final void V(int i7, String str, String str2) {
        if (this.f20715f[i7].isEmpty() || this.f20715f[i7].get(str) == null) {
            return;
        }
        HashMap map = this.f20715f[i7];
        map.put(str2, (d) map.get(str));
        this.f20715f[i7].remove(str);
    }

    public final void W(g gVar, int i7) throws Throwable {
        d dVar = (d) this.f20715f[i7].get("ImageLength");
        d dVar2 = (d) this.f20715f[i7].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = (d) this.f20715f[i7].get("JPEGInterchangeFormat");
            d dVar4 = (d) this.f20715f[i7].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int iM = dVar3.m(this.f20717h);
            int iM2 = dVar3.m(this.f20717h);
            gVar.n(iM);
            byte[] bArr = new byte[iM2];
            gVar.readFully(bArr);
            l(new b(bArr), iM, i7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00f1 A[Catch: all -> 0x00fa, Exception -> 0x00fd, TryCatch #17 {Exception -> 0x00fd, all -> 0x00fa, blocks: (B:68:0x00ed, B:70:0x00f1, B:77:0x010e, B:76:0x00ff), top: B:125:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ff A[Catch: all -> 0x00fa, Exception -> 0x00fd, TryCatch #17 {Exception -> 0x00fd, all -> 0x00fa, blocks: (B:68:0x00ed, B:70:0x00f1, B:77:0x010e, B:76:0x00ff), top: B:125:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void X() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.X():void");
    }

    public final void Y(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte b7;
        byte[] bArr;
        if (f20705w) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.d(-1);
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.d(-40);
        cVar.d(-1);
        cVar.d(-31);
        this.f20725p = i0(cVar);
        if (this.f20730u != null) {
            cVar.write(-1);
            cVar.d(-31);
            byte[] bArr2 = f20701s0;
            cVar.j(bArr2.length + 2 + this.f20730u.f20745d.length);
            cVar.write(bArr2);
            cVar.write(this.f20730u.f20745d);
            this.f20731v = true;
        }
        byte[] bArr3 = new byte[4096];
        while (bVar.readByte() == -1) {
            do {
                b7 = bVar.readByte();
            } while (b7 == -1);
            if (b7 == -39 || b7 == -38) {
                cVar.d(-1);
                cVar.d(b7);
                AbstractC1437b.d(bVar, cVar);
                return;
            }
            if (b7 != -31) {
                cVar.d(-1);
                cVar.d(b7);
                int unsignedShort = bVar.readUnsignedShort();
                cVar.j(unsignedShort);
                int i7 = unsignedShort - 2;
                if (i7 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i7 > 0) {
                    int i8 = bVar.read(bArr3, 0, Math.min(i7, 4096));
                    if (i8 >= 0) {
                        cVar.write(bArr3, 0, i8);
                        i7 -= i8;
                    }
                }
            } else {
                int unsignedShort2 = bVar.readUnsignedShort();
                int length = unsignedShort2 - 2;
                if (length < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr4 = f20701s0;
                if (length >= bArr4.length) {
                    bArr = new byte[bArr4.length];
                } else {
                    byte[] bArr5 = f20700r0;
                    bArr = length >= bArr5.length ? new byte[bArr5.length] : null;
                }
                if (bArr != null) {
                    bVar.readFully(bArr);
                    if (AbstractC1437b.f(bArr, f20700r0) || AbstractC1437b.f(bArr, bArr4)) {
                        bVar.j(length - bArr.length);
                    }
                }
                cVar.d(-1);
                cVar.d(b7);
                cVar.j(unsignedShort2);
                if (bArr != null) {
                    length -= bArr.length;
                    cVar.write(bArr);
                }
                while (length > 0) {
                    int i9 = bVar.read(bArr3, 0, Math.min(length, 4096));
                    if (i9 >= 0) {
                        cVar.write(bArr3, 0, i9);
                        length -= i9;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005a A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0078 -> B:10:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(java.io.InputStream r9, java.io.OutputStream r10) {
        /*
            r8 = this;
            boolean r0 = p0.C1436a.f20705w
            if (r0 == 0) goto L27
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "savePngAttributes starting with (inputStream: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ", outputStream: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ExifInterface"
            android.util.Log.d(r1, r0)
        L27:
            p0.a$b r0 = new p0.a$b
            r0.<init>(r9)
            p0.a$c r9 = new p0.a$c
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            r9.<init>(r10, r1)
            byte[] r10 = p0.C1436a.f20667K
            int r10 = r10.length
            p0.AbstractC1437b.e(r0, r9, r10)
            p0.a$d r10 = r8.f20730u
            r1 = 1
            r2 = 0
            if (r10 != 0) goto L43
            boolean r10 = r8.f20731v
            if (r10 == 0) goto L78
        L43:
            r10 = r1
        L44:
            if (r1 != 0) goto L4d
            if (r10 == 0) goto L49
            goto L4d
        L49:
            p0.AbstractC1437b.d(r0, r9)
            return
        L4d:
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            r5 = 1229472850(0x49484452, float:820293.1)
            if (r4 != r5) goto L7a
            r9.e(r3)
            r9.e(r4)
            int r3 = r3 + 4
            p0.AbstractC1437b.e(r0, r9, r3)
            int r3 = r8.f20725p
            if (r3 != 0) goto L6d
            r8.j0(r9)
            r1 = r2
        L6d:
            p0.a$d r3 = r8.f20730u
            if (r3 == 0) goto L44
            boolean r3 = r8.f20731v
            if (r3 != 0) goto L44
            r8.k0(r9)
        L78:
            r10 = r2
            goto L44
        L7a:
            r5 = 1700284774(0x65584966, float:6.383657E22)
            if (r4 != r5) goto L8b
            if (r1 == 0) goto L8b
            r8.j0(r9)
            int r3 = r3 + 4
            r0.j(r3)
            r1 = r2
            goto L44
        L8b:
            r5 = 1767135348(0x69545874, float:1.6044374E25)
            if (r4 != r5) goto Lbd
            byte[] r5 = p0.C1436a.f20668L
            int r6 = r5.length
            if (r3 < r6) goto Lbd
            int r6 = r5.length
            byte[] r7 = new byte[r6]
            r0.readFully(r7)
            int r6 = r3 - r6
            int r6 = r6 + 4
            boolean r5 = java.util.Arrays.equals(r7, r5)
            if (r5 == 0) goto Lb0
            p0.a$d r10 = r8.f20730u
            if (r10 == 0) goto Lac
            r8.k0(r9)
        Lac:
            r0.j(r6)
            goto L78
        Lb0:
            r9.e(r3)
            r9.e(r4)
            r9.write(r7)
            p0.AbstractC1437b.e(r0, r9, r6)
            goto L44
        Lbd:
            r9.e(r3)
            r9.e(r4)
            int r3 = r3 + 4
            p0.AbstractC1437b.e(r0, r9, r3)
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.Z(java.io.InputStream, java.io.OutputStream):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0213 A[Catch: all -> 0x007e, Exception -> 0x0082, TryCatch #5 {Exception -> 0x0082, all -> 0x007e, blocks: (B:7:0x004f, B:9:0x005b, B:11:0x006f, B:12:0x0071, B:80:0x01f7, B:82:0x0213, B:83:0x021c, B:19:0x0086, B:21:0x0095, B:23:0x009d, B:25:0x00a1, B:28:0x00b1, B:30:0x00bc, B:31:0x00c1, B:32:0x00c3, B:36:0x00d1, B:37:0x00d6, B:38:0x00da, B:39:0x00e6, B:41:0x00ee, B:45:0x00fc, B:47:0x0104, B:50:0x010b, B:52:0x011a, B:54:0x012a, B:69:0x0186, B:71:0x0192, B:72:0x0199, B:74:0x01d3, B:79:0x01f0, B:76:0x01e1, B:78:0x01e9, B:55:0x013e, B:56:0x0145, B:57:0x0146, B:59:0x0150, B:61:0x0156, B:65:0x016f, B:66:0x0177, B:67:0x017e), top: B:97:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(java.io.InputStream r22, java.io.OutputStream r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.a0(java.io.InputStream, java.io.OutputStream):void");
    }

    public void b0(String str, String str2) throws NumberFormatException {
        e eVar;
        int i7;
        String str3;
        int i8;
        int i9;
        String str4 = str;
        String strReplaceAll = str2;
        if (str4 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str4)) {
            if (f20705w) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str4 = "PhotographicSensitivity";
        }
        int i10 = 2;
        String str5 = "/";
        int i11 = 1;
        if (strReplaceAll != null) {
            if (f20697o0.contains(str4) && !strReplaceAll.contains("/")) {
                try {
                    strReplaceAll = f.b(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + strReplaceAll);
                    return;
                }
            } else if (str4.equals("GPSTimeStamp")) {
                Matcher matcher = f20703u0.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else if ("DateTime".equals(str4) || "DateTimeOriginal".equals(str4) || "DateTimeDigitized".equals(str4)) {
                boolean zFind = f20704v0.matcher(strReplaceAll).find();
                boolean zFind2 = f20706w0.matcher(strReplaceAll).find();
                if (strReplaceAll.length() != 19 || (!zFind && !zFind2)) {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + strReplaceAll);
                    return;
                }
                if (zFind2) {
                    strReplaceAll = strReplaceAll.replaceAll("-", ":");
                }
            }
        }
        int i12 = 0;
        if ("Xmp".equals(str4)) {
            boolean z7 = this.f20715f[0].containsKey("Xmp") || this.f20715f[5].containsKey("Xmp");
            int iX = x(this.f20713d);
            if ((iX == 2 && (this.f20730u != null || !z7)) || (iX == 3 && !z7)) {
                this.f20730u = strReplaceAll != null ? d.a(strReplaceAll) : null;
                return;
            }
        }
        int i13 = 0;
        while (i13 < f20693k0.length) {
            if ((i13 != 4 || this.f20718i) && (eVar = (e) f20696n0[i13].get(str4)) != null) {
                if (strReplaceAll != null) {
                    Pair pairY = y(strReplaceAll);
                    if (eVar.f20748c == ((Integer) pairY.first).intValue() || eVar.f20748c == ((Integer) pairY.second).intValue()) {
                        i7 = eVar.f20748c;
                    } else {
                        int i14 = eVar.f20749d;
                        if (i14 == -1 || !(i14 == ((Integer) pairY.first).intValue() || eVar.f20749d == ((Integer) pairY.second).intValue())) {
                            int i15 = eVar.f20748c;
                            if (i15 == i11 || i15 == 7 || i15 == i10) {
                                i7 = i15;
                            } else if (f20705w) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str4);
                                sb.append(") value didn't match with one of expected formats: ");
                                String[] strArr = f20680X;
                                sb.append(strArr[eVar.f20748c]);
                                sb.append(eVar.f20749d == -1 ? "" : ", " + strArr[eVar.f20749d]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) pairY.first).intValue()]);
                                sb.append(((Integer) pairY.second).intValue() != -1 ? ", " + strArr[((Integer) pairY.second).intValue()] : "");
                                sb.append(")");
                                Log.d("ExifInterface", sb.toString());
                            }
                        } else {
                            i7 = eVar.f20749d;
                        }
                    }
                    switch (i7) {
                        case 1:
                            str3 = str5;
                            i8 = i11;
                            i9 = i12;
                            this.f20715f[i13].put(str4, d.a(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            str3 = str5;
                            i8 = i11;
                            i9 = i12;
                            this.f20715f[i13].put(str4, d.e(strReplaceAll));
                            break;
                        case 3:
                            str3 = str5;
                            i8 = i11;
                            i9 = i12;
                            String[] strArrSplit = strReplaceAll.split(",", -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i16 = i9; i16 < strArrSplit.length; i16++) {
                                iArr[i16] = Integer.parseInt(strArrSplit[i16]);
                            }
                            this.f20715f[i13].put(str4, d.k(iArr, this.f20717h));
                            break;
                        case 4:
                            str3 = str5;
                            i8 = i11;
                            i9 = i12;
                            String[] strArrSplit2 = strReplaceAll.split(",", -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i17 = i9; i17 < strArrSplit2.length; i17++) {
                                jArr[i17] = Long.parseLong(strArrSplit2[i17]);
                            }
                            this.f20715f[i13].put(str4, d.g(jArr, this.f20717h));
                            break;
                        case 5:
                            i8 = i11;
                            i9 = i12;
                            String[] strArrSplit3 = strReplaceAll.split(",", -1);
                            f[] fVarArr = new f[strArrSplit3.length];
                            int i18 = i9;
                            while (i18 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i18].split(str5, -1);
                                fVarArr[i18] = new f((long) Double.parseDouble(strArrSplit4[i9]), (long) Double.parseDouble(strArrSplit4[i8]), null);
                                i18++;
                                str5 = str5;
                            }
                            str3 = str5;
                            this.f20715f[i13].put(str4, d.i(fVarArr, this.f20717h));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (f20705w) {
                                Log.d("ExifInterface", "Data format isn't one of expected formats: " + i7);
                                break;
                            }
                            break;
                        case 9:
                            i8 = i11;
                            i9 = i12;
                            String[] strArrSplit5 = strReplaceAll.split(",", -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i19 = i9; i19 < strArrSplit5.length; i19++) {
                                iArr2[i19] = Integer.parseInt(strArrSplit5[i19]);
                            }
                            this.f20715f[i13].put(str4, d.c(iArr2, this.f20717h));
                            str3 = str5;
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(",", -1);
                            f[] fVarArr2 = new f[strArrSplit6.length];
                            int i20 = i12;
                            while (i20 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i20].split(str5, -1);
                                int i21 = i11;
                                int i22 = i20;
                                fVarArr2[i22] = new f((long) Double.parseDouble(strArrSplit7[i12]), (long) Double.parseDouble(strArrSplit7[i21]), null);
                                i20 = i22 + 1;
                                i11 = i21;
                                strArrSplit6 = strArrSplit6;
                                i12 = i12;
                            }
                            i8 = i11;
                            i9 = i12;
                            this.f20715f[i13].put(str4, d.d(fVarArr2, this.f20717h));
                            str3 = str5;
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(",", -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i23 = i12; i23 < strArrSplit8.length; i23++) {
                                dArr[i23] = Double.parseDouble(strArrSplit8[i23]);
                            }
                            this.f20715f[i13].put(str4, d.b(dArr, this.f20717h));
                            break;
                    }
                } else {
                    this.f20715f[i13].remove(str4);
                }
                str3 = str5;
                i8 = i11;
                i9 = i12;
            } else {
                str3 = str5;
                i8 = i11;
                i9 = i12;
            }
            i13++;
            i11 = i8;
            i12 = i9;
            str5 = str3;
            i10 = 2;
        }
    }

    public final void c0(b bVar) throws Throwable {
        HashMap map = this.f20715f[4];
        d dVar = (d) map.get("Compression");
        if (dVar == null) {
            this.f20724o = 6;
            z(bVar, map);
            return;
        }
        int iM = dVar.m(this.f20717h);
        this.f20724o = iM;
        if (iM != 1) {
            if (iM == 6) {
                z(bVar, map);
                return;
            } else if (iM != 7) {
                return;
            }
        }
        if (K(map)) {
            A(bVar, map);
        }
    }

    public final void e() {
        String strH = h("DateTimeOriginal");
        if (strH != null && h("DateTime") == null) {
            this.f20715f[0].put("DateTime", d.e(strH));
        }
        if (h("ImageWidth") == null) {
            this.f20715f[0].put("ImageWidth", d.f(0L, this.f20717h));
        }
        if (h("ImageLength") == null) {
            this.f20715f[0].put("ImageLength", d.f(0L, this.f20717h));
        }
        if (h("Orientation") == null) {
            this.f20715f[0].put("Orientation", d.f(0L, this.f20717h));
        }
        if (h("LightSource") == null) {
            this.f20715f[1].put("LightSource", d.f(0L, this.f20717h));
        }
    }

    public final void e0(int i7, int i8) throws Throwable {
        if (this.f20715f[i7].isEmpty() || this.f20715f[i8].isEmpty()) {
            if (f20705w) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = (d) this.f20715f[i7].get("ImageLength");
        d dVar2 = (d) this.f20715f[i7].get("ImageWidth");
        d dVar3 = (d) this.f20715f[i8].get("ImageLength");
        d dVar4 = (d) this.f20715f[i8].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (f20705w) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (dVar3 == null || dVar4 == null) {
            if (f20705w) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM = dVar.m(this.f20717h);
        int iM2 = dVar2.m(this.f20717h);
        int iM3 = dVar3.m(this.f20717h);
        int iM4 = dVar4.m(this.f20717h);
        if (iM >= iM3 || iM2 >= iM4) {
            return;
        }
        HashMap[] mapArr = this.f20715f;
        HashMap map = mapArr[i7];
        mapArr[i7] = mapArr[i8];
        mapArr[i8] = map;
    }

    public final void f(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        while (true) {
            byte[] bArr3 = new byte[4];
            bVar.readFully(bArr3);
            g(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public final void g(b bVar, c cVar, byte[] bArr) throws IOException {
        int i7 = bVar.readInt();
        cVar.write(bArr);
        cVar.e(i7);
        if (i7 % 2 == 1) {
            i7++;
        }
        AbstractC1437b.e(bVar, cVar, i7);
    }

    public final void g0(g gVar, int i7) throws Throwable {
        d dVarJ;
        d dVarJ2;
        d dVar = (d) this.f20715f[i7].get("DefaultCropSize");
        d dVar2 = (d) this.f20715f[i7].get("SensorTopBorder");
        d dVar3 = (d) this.f20715f[i7].get("SensorLeftBorder");
        d dVar4 = (d) this.f20715f[i7].get("SensorBottomBorder");
        d dVar5 = (d) this.f20715f[i7].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                W(gVar, i7);
                return;
            }
            int iM = dVar2.m(this.f20717h);
            int iM2 = dVar4.m(this.f20717h);
            int iM3 = dVar5.m(this.f20717h);
            int iM4 = dVar3.m(this.f20717h);
            if (iM2 <= iM || iM3 <= iM4) {
                return;
            }
            d dVarJ3 = d.j(iM2 - iM, this.f20717h);
            d dVarJ4 = d.j(iM3 - iM4, this.f20717h);
            this.f20715f[i7].put("ImageLength", dVarJ3);
            this.f20715f[i7].put("ImageWidth", dVarJ4);
            return;
        }
        if (dVar.f20742a == 5) {
            f[] fVarArr = (f[]) dVar.o(this.f20717h);
            if (fVarArr == null || fVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                return;
            }
            dVarJ = d.h(fVarArr[0], this.f20717h);
            dVarJ2 = d.h(fVarArr[1], this.f20717h);
        } else {
            int[] iArr = (int[]) dVar.o(this.f20717h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            dVarJ = d.j(iArr[0], this.f20717h);
            dVarJ2 = d.j(iArr[1], this.f20717h);
        }
        this.f20715f[i7].put("ImageWidth", dVarJ);
        this.f20715f[i7].put("ImageLength", dVarJ2);
    }

    public String h(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarJ = j(str);
        if (dVarJ == null) {
            return null;
        }
        if (!str.equals("GPSTimeStamp")) {
            if (!f20697o0.contains(str)) {
                return dVarJ.n(this.f20717h);
            }
            try {
                return Double.toString(dVarJ.l(this.f20717h));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        int i7 = dVarJ.f20742a;
        if (i7 != 5 && i7 != 10) {
            Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + dVarJ.f20742a);
            return null;
        }
        f[] fVarArr = (f[]) dVarJ.o(this.f20717h);
        if (fVarArr == null || fVarArr.length != 3) {
            Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
            return null;
        }
        f fVar = fVarArr[0];
        Integer numValueOf = Integer.valueOf((int) (fVar.f20750a / fVar.f20751b));
        f fVar2 = fVarArr[1];
        Integer numValueOf2 = Integer.valueOf((int) (fVar2.f20750a / fVar2.f20751b));
        f fVar3 = fVarArr[2];
        return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (fVar3.f20750a / fVar3.f20751b)));
    }

    public final void h0() throws Throwable {
        e0(0, 5);
        e0(0, 4);
        e0(5, 4);
        d dVar = (d) this.f20715f[1].get("PixelXDimension");
        d dVar2 = (d) this.f20715f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f20715f[0].put("ImageWidth", dVar);
            this.f20715f[0].put("ImageLength", dVar2);
        }
        if (this.f20715f[4].isEmpty() && M(this.f20715f[5])) {
            HashMap[] mapArr = this.f20715f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!M(this.f20715f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        V(0, "ThumbnailOrientation", "Orientation");
        V(0, "ThumbnailImageLength", "ImageLength");
        V(0, "ThumbnailImageWidth", "ImageWidth");
        V(5, "ThumbnailOrientation", "Orientation");
        V(5, "ThumbnailImageLength", "ImageLength");
        V(5, "ThumbnailImageWidth", "ImageWidth");
        V(4, "Orientation", "ThumbnailOrientation");
        V(4, "ImageLength", "ThumbnailImageLength");
        V(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public int i(String str, int i7) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarJ = j(str);
        if (dVarJ != null) {
            try {
                return dVarJ.m(this.f20717h);
            } catch (NumberFormatException unused) {
            }
        }
        return i7;
    }

    public final int i0(c cVar) throws IOException {
        char c7;
        char c8;
        long j7;
        e[][] eVarArr = f20693k0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f20694l0) {
            U(eVar.f20747b);
        }
        if (this.f20718i) {
            if (this.f20719j) {
                U("StripOffsets");
                U("StripByteCounts");
            } else {
                U("JPEGInterchangeFormat");
                U("JPEGInterchangeFormatLength");
            }
        }
        for (int i7 = 0; i7 < f20693k0.length; i7++) {
            Iterator it = this.f20715f[i7].entrySet().iterator();
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    it.remove();
                }
            }
        }
        long j8 = 0;
        if (!this.f20715f[1].isEmpty()) {
            this.f20715f[0].put(f20694l0[1].f20747b, d.f(0L, this.f20717h));
        }
        if (!this.f20715f[2].isEmpty()) {
            this.f20715f[0].put(f20694l0[2].f20747b, d.f(0L, this.f20717h));
        }
        if (this.f20715f[3].isEmpty()) {
            c7 = 2;
        } else {
            c7 = 2;
            this.f20715f[1].put(f20694l0[3].f20747b, d.f(0L, this.f20717h));
        }
        if (!this.f20718i) {
            c8 = 3;
        } else if (this.f20719j) {
            this.f20715f[4].put("StripOffsets", d.j(0, this.f20717h));
            this.f20715f[4].put("StripByteCounts", d.j(this.f20722m, this.f20717h));
            c8 = 3;
        } else {
            this.f20715f[4].put("JPEGInterchangeFormat", d.f(0L, this.f20717h));
            c8 = 3;
            this.f20715f[4].put("JPEGInterchangeFormatLength", d.f(this.f20722m, this.f20717h));
        }
        for (int i8 = 0; i8 < f20693k0.length; i8++) {
            Iterator it2 = this.f20715f[i8].entrySet().iterator();
            int i9 = 0;
            while (it2.hasNext()) {
                int iP = ((d) ((Map.Entry) it2.next()).getValue()).p();
                if (iP > 4) {
                    i9 += iP;
                }
            }
            iArr2[i8] = iArr2[i8] + i9;
        }
        int size = 8;
        for (int i10 = 0; i10 < f20693k0.length; i10++) {
            if (!this.f20715f[i10].isEmpty()) {
                iArr[i10] = size;
                size += (this.f20715f[i10].size() * 12) + 6 + iArr2[i10];
            }
        }
        if (this.f20718i) {
            if (this.f20719j) {
                this.f20715f[4].put("StripOffsets", d.j(size, this.f20717h));
            } else {
                this.f20715f[4].put("JPEGInterchangeFormat", d.f(size, this.f20717h));
            }
            this.f20721l = size;
            size += this.f20722m;
        }
        if (this.f20713d == 4) {
            size += 8;
        }
        if (f20705w) {
            for (int i11 = 0; i11 < f20693k0.length; i11++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i11), Integer.valueOf(iArr[i11]), Integer.valueOf(this.f20715f[i11].size()), Integer.valueOf(iArr2[i11]), Integer.valueOf(size)));
            }
        }
        if (!this.f20715f[1].isEmpty()) {
            this.f20715f[0].put(f20694l0[1].f20747b, d.f(iArr[1], this.f20717h));
        }
        if (!this.f20715f[c7].isEmpty()) {
            this.f20715f[0].put(f20694l0[c7].f20747b, d.f(iArr[c7], this.f20717h));
        }
        if (!this.f20715f[c8].isEmpty()) {
            this.f20715f[1].put(f20694l0[c8].f20747b, d.f(iArr[c8], this.f20717h));
        }
        int i12 = this.f20713d;
        if (i12 == 4) {
            if (size > 65535) {
                throw new IllegalStateException("Size of exif data (" + size + " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)");
            }
            cVar.j(size);
            cVar.write(f20700r0);
        } else if (i12 == 13) {
            cVar.e(size);
            cVar.e(1700284774);
        } else if (i12 == 14) {
            cVar.write(f20671O);
            cVar.e(size);
        }
        int size2 = cVar.f20740l.size();
        cVar.f(this.f20717h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.a(this.f20717h);
        cVar.j(42);
        cVar.i(8L);
        int i13 = 0;
        while (i13 < f20693k0.length) {
            if (this.f20715f[i13].isEmpty()) {
                j7 = j8;
            } else {
                cVar.j(this.f20715f[i13].size());
                int size3 = iArr[i13] + 2 + (this.f20715f[i13].size() * 12) + 4;
                for (Map.Entry entry : this.f20715f[i13].entrySet()) {
                    int i14 = ((e) f20696n0[i13].get(entry.getKey())).f20746a;
                    d dVar = (d) entry.getValue();
                    int iP2 = dVar.p();
                    cVar.j(i14);
                    cVar.j(dVar.f20742a);
                    cVar.e(dVar.f20743b);
                    if (iP2 > 4) {
                        cVar.i(size3);
                        size3 += iP2;
                    } else {
                        cVar.write(dVar.f20745d);
                        if (iP2 < 4) {
                            while (iP2 < 4) {
                                cVar.d(0);
                                iP2++;
                            }
                        }
                    }
                }
                if (i13 != 0 || this.f20715f[4].isEmpty()) {
                    j7 = 0;
                    cVar.i(0L);
                } else {
                    cVar.i(iArr[4]);
                    j7 = 0;
                }
                Iterator it3 = this.f20715f[i13].entrySet().iterator();
                while (it3.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it3.next()).getValue()).f20745d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
            i13++;
            j8 = j7;
        }
        if (this.f20718i) {
            cVar.write(v());
        }
        if (this.f20713d == 14 && size % 2 == 1) {
            cVar.d(0);
        }
        cVar.a(ByteOrder.BIG_ENDIAN);
        return size2;
    }

    public final d j(String str) {
        d dVar;
        d dVar2;
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f20705w) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        if ("Xmp".equals(str) && x(this.f20713d) == 2 && (dVar2 = this.f20730u) != null) {
            return dVar2;
        }
        for (int i7 = 0; i7 < f20693k0.length; i7++) {
            d dVar3 = (d) this.f20715f[i7].get(str);
            if (dVar3 != null) {
                return dVar3;
            }
        }
        if (!"Xmp".equals(str) || (dVar = this.f20730u) == null) {
            return null;
        }
        return dVar;
    }

    public final void j0(c cVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f20725p = cVar.f20740l.size() + i0(new c(byteArrayOutputStream, ByteOrder.BIG_ENDIAN));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        cVar.write(byteArray);
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray, 4, byteArray.length - 4);
        cVar.e((int) crc32.getValue());
    }

    public final void k(g gVar, int i7) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIC files is supported from SDK 28 and above");
        }
        if (i7 == 15 && i8 < 31) {
            throw new UnsupportedOperationException("Reading EXIF from AVIF files is supported from SDK 31 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                AbstractC1437b.a.a(mediaMetadataRetriever, new C0239a(gVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f20715f[0].put("ImageWidth", d.j(Integer.parseInt(strExtractMetadata), this.f20717h));
                }
                if (strExtractMetadata3 != null) {
                    this.f20715f[0].put("ImageLength", d.j(Integer.parseInt(strExtractMetadata3), this.f20717h));
                }
                if (strExtractMetadata2 != null) {
                    int i9 = Integer.parseInt(strExtractMetadata2);
                    this.f20715f[0].put("Orientation", d.j(i9 != 90 ? i9 != 180 ? i9 != 270 ? 1 : 8 : 3 : 6, this.f20717h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i10 = Integer.parseInt(strExtractMetadata4);
                    int i11 = Integer.parseInt(strExtractMetadata5);
                    if (i11 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    gVar.n(i10);
                    byte[] bArr = new byte[6];
                    gVar.readFully(bArr);
                    int i12 = i10 + 6;
                    int i13 = i11 - 6;
                    if (!Arrays.equals(bArr, f20700r0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i13];
                    gVar.readFully(bArr2);
                    this.f20725p = i12;
                    S(bArr2, 0);
                }
                String strExtractMetadata8 = mediaMetadataRetriever.extractMetadata(41);
                String strExtractMetadata9 = mediaMetadataRetriever.extractMetadata(42);
                if (strExtractMetadata8 != null && strExtractMetadata9 != null) {
                    int i14 = Integer.parseInt(strExtractMetadata8);
                    int i15 = Integer.parseInt(strExtractMetadata9);
                    long j7 = i14;
                    gVar.n(j7);
                    byte[] bArr3 = new byte[i15];
                    gVar.readFully(bArr3);
                    this.f20730u = new d(1, i15, j7, bArr3);
                    this.f20731v = true;
                }
                if (f20705w) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata3 + ", rotation " + strExtractMetadata2);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
            } finally {
            }
        } catch (RuntimeException e7) {
            throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e7);
        }
    }

    public final void k0(c cVar) throws IOException {
        cVar.e(this.f20730u.f20745d.length + 22);
        CRC32 crc32 = new CRC32();
        cVar.e(1767135348);
        f0(crc32, 1767135348);
        byte[] bArr = f20668L;
        cVar.write(bArr);
        crc32.update(bArr);
        cVar.write(this.f20730u.f20745d);
        crc32.update(this.f20730u.f20745d);
        cVar.e((int) crc32.getValue());
        this.f20731v = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x016e, code lost:
    
        r20.i(r19.f20717h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0173, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x00ab. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x00ae. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x00b1. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015c A[LOOP:0: B:10:0x0037->B:57:0x015c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0162 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(p0.C1436a.b r20, int r21, int r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.l(p0.a$b, int, int):void");
    }

    public final int m(BufferedInputStream bufferedInputStream) throws Throwable {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (E(bArr)) {
            return 4;
        }
        if (H(bArr)) {
            return 9;
        }
        int iD = D(bArr);
        if (iD != 0) {
            return iD;
        }
        if (F(bArr)) {
            return 7;
        }
        if (I(bArr)) {
            return 10;
        }
        if (G(bArr)) {
            return 13;
        }
        return N(bArr) ? 14 : 0;
    }

    public final void n(g gVar) throws Throwable {
        int i7;
        int i8;
        q(gVar);
        d dVar = (d) this.f20715f[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f20745d);
            gVar2.i(this.f20717h);
            byte[] bArr = f20665I;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.n(0L);
            byte[] bArr3 = f20666J;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.n(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.n(12L);
            }
            T(gVar2, 6);
            d dVar2 = (d) this.f20715f[7].get("PreviewImageStart");
            d dVar3 = (d) this.f20715f[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                this.f20715f[5].put("JPEGInterchangeFormat", dVar2);
                this.f20715f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) this.f20715f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.f20717h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i9 = iArr[2];
                int i10 = iArr[0];
                if (i9 <= i10 || (i7 = iArr[3]) <= (i8 = iArr[1])) {
                    return;
                }
                int i11 = (i9 - i10) + 1;
                int i12 = (i7 - i8) + 1;
                if (i11 < i12) {
                    int i13 = i11 + i12;
                    i12 = i13 - i12;
                    i11 = i13 - i12;
                }
                d dVarJ = d.j(i11, this.f20717h);
                d dVarJ2 = d.j(i12, this.f20717h);
                this.f20715f[0].put("ImageWidth", dVarJ);
                this.f20715f[0].put("ImageLength", dVarJ2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r17.f20731v = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(p0.C1436a.b r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.o(p0.a$b):void");
    }

    public final void p(b bVar) throws Throwable {
        boolean z7 = f20705w;
        if (z7) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.j(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i7 = ByteBuffer.wrap(bArr).getInt();
        int i8 = ByteBuffer.wrap(bArr2).getInt();
        int i9 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i8];
        bVar.j(i7 - bVar.d());
        bVar.readFully(bArr4);
        l(new b(bArr4), i7, 5);
        bVar.j(i9 - bVar.d());
        bVar.i(ByteOrder.BIG_ENDIAN);
        int i10 = bVar.readInt();
        if (z7) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i10);
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f20688f0.f20746a) {
                short s7 = bVar.readShort();
                short s8 = bVar.readShort();
                d dVarJ = d.j(s7, this.f20717h);
                d dVarJ2 = d.j(s8, this.f20717h);
                this.f20715f[0].put("ImageLength", dVarJ);
                this.f20715f[0].put("ImageWidth", dVarJ2);
                if (f20705w) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s7) + ", width: " + ((int) s8));
                    return;
                }
                return;
            }
            bVar.j(unsignedShort2);
        }
    }

    public final void q(g gVar) throws Throwable {
        d dVar;
        P(gVar);
        T(gVar, 0);
        g0(gVar, 0);
        g0(gVar, 5);
        g0(gVar, 4);
        h0();
        if (this.f20713d != 8 || (dVar = (d) this.f20715f[1].get("MakerNote")) == null) {
            return;
        }
        g gVar2 = new g(dVar.f20745d);
        gVar2.i(this.f20717h);
        gVar2.j(6);
        T(gVar2, 9);
        d dVar2 = (d) this.f20715f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f20715f[1].put("ColorSpace", dVar2);
        }
    }

    public int r() {
        switch (i("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void s(g gVar) throws Throwable {
        if (f20705w) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        q(gVar);
        d dVar = (d) this.f20715f[0].get("JpgFromRaw");
        if (dVar != null) {
            l(new b(dVar.f20745d), (int) dVar.f20744c, 5);
        }
        d dVar2 = (d) this.f20715f[0].get("ISO");
        d dVar3 = (d) this.f20715f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f20715f[1].put("PhotographicSensitivity", dVar2);
    }

    public final boolean t(g gVar) throws IOException {
        byte[] bArr = f20700r0;
        byte[] bArr2 = new byte[bArr.length];
        gVar.readFully(bArr2);
        if (!Arrays.equals(bArr2, bArr)) {
            Log.w("ExifInterface", "Given data is not EXIF-only.");
            return false;
        }
        byte[] bArrE = gVar.e();
        this.f20725p = bArr.length;
        S(bArrE, 0);
        return true;
    }

    public byte[] u() {
        int i7 = this.f20724o;
        if (i7 == 6 || i7 == 7) {
            return v();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] v() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r8.f20718i
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            byte[] r1 = r8.f20723n
            if (r1 == 0) goto Ld
            return r1
        Ld:
            android.content.res.AssetManager$AssetInputStream r1 = r8.f20712c     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            if (r1 == 0) goto L2f
            boolean r3 = r1.markSupported()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
            if (r3 == 0) goto L26
            r1.reset()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
        L1a:
            r3 = r2
            goto L58
        L1c:
            r0 = move-exception
            r3 = r2
        L1e:
            r2 = r1
            goto L90
        L21:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L82
        L26:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
            p0.AbstractC1437b.b(r1)
            return r2
        L2f:
            java.lang.String r1 = r8.f20710a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            if (r1 == 0) goto L43
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            java.lang.String r3 = r8.f20710a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            goto L1a
        L3b:
            r0 = move-exception
            r3 = r2
            goto L90
        L3e:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
            goto L82
        L43:
            java.io.FileDescriptor r1 = r8.f20711b     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            java.io.FileDescriptor r1 = android.system.Os.dup(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            int r3 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r4 = 0
            android.system.Os.lseek(r1, r4, r3)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r7 = r3
            r3 = r1
            r1 = r7
        L58:
            p0.a$b r4 = new p0.a$b     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r5 = r8.f20721l     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r6 = r8.f20725p     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r5 = r5 + r6
            r4.j(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r5 = r8.f20722m     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4.readFully(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r8.f20723n = r5     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            p0.AbstractC1437b.b(r1)
            if (r3 == 0) goto L76
            p0.AbstractC1437b.a(r3)
        L76:
            return r5
        L77:
            r0 = move-exception
            goto L1e
        L79:
            r4 = move-exception
            goto L82
        L7b:
            r0 = move-exception
            r3 = r1
            goto L90
        L7e:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
        L82:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> L77
            p0.AbstractC1437b.b(r1)
            if (r3 == 0) goto L8f
            p0.AbstractC1437b.a(r3)
        L8f:
            return r2
        L90:
            p0.AbstractC1437b.b(r2)
            if (r3 == 0) goto L98
            p0.AbstractC1437b.a(r3)
        L98:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.v():byte[]");
    }

    public final void w(b bVar) throws Throwable {
        if (f20705w) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.i(ByteOrder.LITTLE_ENDIAN);
        bVar.j(f20669M.length);
        int i7 = bVar.readInt() + 8;
        byte[] bArr = f20670N;
        bVar.j(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i8 = bVar.readInt();
                int i9 = length + 8;
                if (Arrays.equals(f20671O, bArr2)) {
                    byte[] bArrCopyOfRange = new byte[i8];
                    bVar.readFully(bArrCopyOfRange);
                    byte[] bArr3 = f20700r0;
                    if (AbstractC1437b.f(bArrCopyOfRange, bArr3)) {
                        bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOfRange, bArr3.length, i8);
                    }
                    this.f20725p = i9;
                    S(bArrCopyOfRange, 0);
                    c0(new b(bArrCopyOfRange));
                    return;
                }
                if (i8 % 2 == 1) {
                    i8++;
                }
                length = i9 + i8;
                if (length == i7) {
                    return;
                }
                if (length > i7) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.j(i8);
            } catch (EOFException e7) {
                throw new IOException("Encountered corrupt WebP file.", e7);
            }
        }
    }

    public final void z(b bVar, HashMap map) throws Throwable {
        d dVar = (d) map.get("JPEGInterchangeFormat");
        d dVar2 = (d) map.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int iM = dVar.m(this.f20717h);
        int iM2 = dVar2.m(this.f20717h);
        if (this.f20713d == 7) {
            iM += this.f20726q;
        }
        if (iM > 0 && iM2 > 0) {
            this.f20718i = true;
            if (this.f20710a == null && this.f20712c == null && this.f20711b == null) {
                byte[] bArr = new byte[iM2];
                bVar.j(iM);
                bVar.readFully(bArr);
                this.f20723n = bArr;
            }
            this.f20721l = iM;
            this.f20722m = iM2;
        }
        if (f20705w) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM + ", length: " + iM2);
        }
    }

    /* renamed from: p0.a$b */
    public static class b extends InputStream implements DataInput {

        /* renamed from: l, reason: collision with root package name */
        public final DataInputStream f20735l;

        /* renamed from: m, reason: collision with root package name */
        public int f20736m;

        /* renamed from: n, reason: collision with root package name */
        public ByteOrder f20737n;

        /* renamed from: o, reason: collision with root package name */
        public byte[] f20738o;

        /* renamed from: p, reason: collision with root package name */
        public int f20739p;

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.f20739p = bArr.length;
        }

        public int a() {
            return this.f20739p;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f20735l.available();
        }

        public int d() {
            return this.f20736m;
        }

        public byte[] e() throws IOException {
            byte[] bArrCopyOf = new byte[1024];
            int i7 = 0;
            while (true) {
                if (i7 == bArrCopyOf.length) {
                    bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                }
                int i8 = this.f20735l.read(bArrCopyOf, i7, bArrCopyOf.length - i7);
                if (i8 == -1) {
                    return Arrays.copyOf(bArrCopyOf, i7);
                }
                i7 += i8;
                this.f20736m += i8;
            }
        }

        public long f() {
            return readInt() & 4294967295L;
        }

        public void i(ByteOrder byteOrder) {
            this.f20737n = byteOrder;
        }

        public void j(int i7) throws IOException {
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i7 - i8;
                int iSkip = (int) this.f20735l.skip(i9);
                if (iSkip <= 0) {
                    if (this.f20738o == null) {
                        this.f20738o = new byte[8192];
                    }
                    iSkip = this.f20735l.read(this.f20738o, 0, Math.min(8192, i9));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i7 + " bytes.");
                    }
                }
                i8 += iSkip;
            }
            this.f20736m += i8;
        }

        @Override // java.io.InputStream
        public void mark(int i7) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f20736m++;
            return this.f20735l.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f20736m++;
            return this.f20735l.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f20736m++;
            int i7 = this.f20735l.read();
            if (i7 >= 0) {
                return (byte) i7;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f20736m += 2;
            return this.f20735l.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i7, int i8) throws IOException {
            this.f20736m += i8;
            this.f20735l.readFully(bArr, i7, i8);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f20736m += 4;
            int i7 = this.f20735l.read();
            int i8 = this.f20735l.read();
            int i9 = this.f20735l.read();
            int i10 = this.f20735l.read();
            if ((i7 | i8 | i9 | i10) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20737n;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i10 << 24) + (i9 << 16) + (i8 << 8) + i7;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i7 << 24) + (i8 << 16) + (i9 << 8) + i10;
            }
            throw new IOException("Invalid byte order: " + this.f20737n);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f20736m += 8;
            int i7 = this.f20735l.read();
            int i8 = this.f20735l.read();
            int i9 = this.f20735l.read();
            int i10 = this.f20735l.read();
            int i11 = this.f20735l.read();
            int i12 = this.f20735l.read();
            int i13 = this.f20735l.read();
            int i14 = this.f20735l.read();
            if ((i7 | i8 | i9 | i10 | i11 | i12 | i13 | i14) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20737n;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i14 << 56) + (i13 << 48) + (i12 << 40) + (i11 << 32) + (i10 << 24) + (i9 << 16) + (i8 << 8) + i7;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i7 << 56) + (i8 << 48) + (i9 << 40) + (i10 << 32) + (i11 << 24) + (i12 << 16) + (i13 << 8) + i14;
            }
            throw new IOException("Invalid byte order: " + this.f20737n);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f20736m += 2;
            int i7 = this.f20735l.read();
            int i8 = this.f20735l.read();
            if ((i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20737n;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((i8 << 8) + i7);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((i7 << 8) + i8);
            }
            throw new IOException("Invalid byte order: " + this.f20737n);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f20736m += 2;
            return this.f20735l.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f20736m++;
            return this.f20735l.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f20736m += 2;
            int i7 = this.f20735l.read();
            int i8 = this.f20735l.read();
            if ((i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20737n;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i8 << 8) + i7;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i7 << 8) + i8;
            }
            throw new IOException("Invalid byte order: " + this.f20737n);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i7) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = this.f20735l.read(bArr, i7, i8);
            this.f20736m += i9;
            return i9;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f20736m += bArr.length;
            this.f20735l.readFully(bArr);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f20735l = dataInputStream;
            dataInputStream.mark(0);
            this.f20736m = 0;
            this.f20737n = byteOrder;
            this.f20739p = inputStream instanceof b ? ((b) inputStream).a() : -1;
        }
    }

    /* renamed from: p0.a$g */
    public static class g extends b {
        public g(byte[] bArr) {
            super(bArr);
            this.f20735l.mark(Integer.MAX_VALUE);
        }

        public void n(long j7) throws IOException {
            int i7 = this.f20736m;
            if (i7 > j7) {
                this.f20736m = 0;
                this.f20735l.reset();
            } else {
                j7 -= i7;
            }
            j((int) j7);
        }

        public g(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f20735l.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* renamed from: p0.a$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f20746a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20747b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20748c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20749d;

        public e(String str, int i7, int i8) {
            this.f20747b = str;
            this.f20746a = i7;
            this.f20748c = i8;
            this.f20749d = -1;
        }

        public boolean a(int i7) {
            int i8;
            int i9 = this.f20748c;
            if (i9 == 7 || i7 == 7 || i9 == i7 || (i8 = this.f20749d) == i7) {
                return true;
            }
            if ((i9 == 4 || i8 == 4) && i7 == 3) {
                return true;
            }
            if ((i9 == 9 || i8 == 9) && i7 == 8) {
                return true;
            }
            return (i9 == 12 || i8 == 12) && i7 == 11;
        }

        public e(String str, int i7, int i8, int i9) {
            this.f20747b = str;
            this.f20746a = i7;
            this.f20748c = i8;
            this.f20749d = i9;
        }
    }

    public C1436a(InputStream inputStream) {
        this(inputStream, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1436a(java.io.InputStream r3, int r4) {
        /*
            r2 = this;
            r2.<init>()
            p0.a$e[][] r0 = p0.C1436a.f20693k0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r2.f20715f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r2.f20716g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r2.f20717h = r0
            if (r3 == 0) goto L57
            r0 = 0
            r2.f20710a = r0
            r1 = 1
            if (r4 != r1) goto L1f
            goto L20
        L1f:
            r1 = 0
        L20:
            r2.f20714e = r1
            if (r1 == 0) goto L29
            r2.f20712c = r0
            r2.f20711b = r0
            goto L53
        L29:
            boolean r4 = r3 instanceof android.content.res.AssetManager.AssetInputStream
            if (r4 == 0) goto L35
            r4 = r3
            android.content.res.AssetManager$AssetInputStream r4 = (android.content.res.AssetManager.AssetInputStream) r4
            r2.f20712c = r4
            r2.f20711b = r0
            goto L53
        L35:
            boolean r4 = r3 instanceof java.io.FileInputStream
            if (r4 == 0) goto L4f
            r4 = r3
            java.io.FileInputStream r4 = (java.io.FileInputStream) r4
            java.io.FileDescriptor r1 = r4.getFD()
            boolean r1 = J(r1)
            if (r1 == 0) goto L4f
            r2.f20712c = r0
            java.io.FileDescriptor r4 = r4.getFD()
            r2.f20711b = r4
            goto L53
        L4f:
            r2.f20712c = r0
            r2.f20711b = r0
        L53:
            r2.O(r3)
            return
        L57:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "inputStream cannot be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C1436a.<init>(java.io.InputStream, int):void");
    }

    /* renamed from: p0.a$a, reason: collision with other inner class name */
    public class C0239a extends MediaDataSource {

        /* renamed from: l, reason: collision with root package name */
        public long f20732l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ g f20733m;

        public C0239a(g gVar) {
            this.f20733m = gVar;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j7, byte[] bArr, int i7, int i8) {
            if (i8 == 0) {
                return 0;
            }
            if (j7 < 0) {
                return -1;
            }
            try {
                long j8 = this.f20732l;
                if (j8 != j7) {
                    if (j8 >= 0 && j7 >= j8 + this.f20733m.available()) {
                        return -1;
                    }
                    this.f20733m.n(j7);
                    this.f20732l = j7;
                }
                if (i8 > this.f20733m.available()) {
                    i8 = this.f20733m.available();
                }
                int i9 = this.f20733m.read(bArr, i7, i8);
                if (i9 >= 0) {
                    this.f20732l += i9;
                    return i9;
                }
            } catch (IOException unused) {
            }
            this.f20732l = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
