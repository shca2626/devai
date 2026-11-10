package N3;

import D3.f;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    public static final e[] f6393h = a();

    /* renamed from: a, reason: collision with root package name */
    public final int f6394a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6395b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6396c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6397d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6398e;

    /* renamed from: f, reason: collision with root package name */
    public final c f6399f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6400g;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6401a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6402b;

        public int a() {
            return this.f6401a;
        }

        public int b() {
            return this.f6402b;
        }

        public b(int i7, int i8) {
            this.f6401a = i7;
            this.f6402b = i8;
        }
    }

    public e(int i7, int i8, int i9, int i10, int i11, c cVar) {
        this.f6394a = i7;
        this.f6395b = i8;
        this.f6396c = i9;
        this.f6397d = i10;
        this.f6398e = i11;
        this.f6399f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f6400g = iA;
    }

    public static e[] a() {
        int i7 = 1;
        int i8 = 5;
        e eVar = new e(1, 10, 10, 8, 8, new c(i8, new b(i7, 3)));
        e eVar2 = new e(2, 12, 12, 10, 10, new c(7, new b(i7, i8)));
        int i9 = 8;
        e eVar3 = new e(3, 14, 14, 12, 12, new c(10, new b(i7, i9)));
        int i10 = 12;
        e eVar4 = new e(4, 16, 16, 14, 14, new c(i10, new b(i7, i10)));
        int i11 = 18;
        e eVar5 = new e(5, 18, 18, 16, 16, new c(14, new b(i7, i11)));
        e eVar6 = new e(6, 20, 20, 18, 18, new c(i11, new b(i7, 22)));
        e eVar7 = new e(7, 22, 22, 20, 20, new c(20, new b(i7, 30)));
        int i12 = 36;
        e eVar8 = new e(8, 24, 24, 22, 22, new c(24, new b(i7, i12)));
        e eVar9 = new e(9, 26, 26, 24, 24, new c(28, new b(i7, 44)));
        int i13 = 62;
        e eVar10 = new e(10, 32, 32, 14, 14, new c(i12, new b(i7, i13)));
        int i14 = 42;
        e eVar11 = new e(11, 36, 36, 16, 16, new c(i14, new b(i7, 86)));
        e eVar12 = new e(12, 40, 40, 18, 18, new c(48, new b(i7, 114)));
        int i15 = 56;
        e eVar13 = new e(13, 44, 44, 20, 20, new c(i15, new b(i7, 144)));
        int i16 = 68;
        e eVar14 = new e(14, 48, 48, 22, 22, new c(i16, new b(i7, 174)));
        int i17 = 2;
        e eVar15 = new e(15, 52, 52, 24, 24, new c(i14, new b(i17, 102)));
        e eVar16 = new e(16, 64, 64, 14, 14, new c(i15, new b(i17, 140)));
        int i18 = 4;
        e eVar17 = new e(17, 72, 72, 16, 16, new c(i12, new b(i18, 92)));
        e eVar18 = new e(18, 80, 80, 18, 18, new c(48, new b(i18, 114)));
        e eVar19 = new e(19, 88, 88, 20, 20, new c(i15, new b(i18, 144)));
        e eVar20 = new e(20, 96, 96, 22, 22, new c(i16, new b(i18, 174)));
        int i19 = 6;
        e eVar21 = new e(21, 104, 104, 24, 24, new c(i15, new b(i19, 136)));
        e eVar22 = new e(22, 120, 120, 18, 18, new c(i16, new b(i19, 175)));
        e eVar23 = new e(23, 132, 132, 20, 20, new c(i13, new b(i9, 163)));
        e eVar24 = new e(24, 144, 144, 22, 22, new c(i13, new b(i9, 156), new b(i17, 155)));
        int i20 = 1;
        e eVar25 = new e(25, 8, 18, 6, 16, new c(7, new b(i20, 5)));
        e eVar26 = new e(26, 8, 32, 6, 14, new c(11, new b(i20, 10)));
        int i21 = 1;
        e eVar27 = new e(27, 12, 26, 10, 24, new c(14, new b(i21, 16)));
        e eVar28 = new e(28, 12, 36, 10, 16, new c(18, new b(i21, 22)));
        int i22 = 32;
        e eVar29 = new e(29, 16, 36, 14, 16, new c(24, new b(1, i22)));
        int i23 = 1;
        e eVar30 = new e(30, 16, 48, 14, 22, new c(28, new b(i23, 49)));
        e eVar31 = new e(31, 8, 48, 6, 22, new c(15, new b(i23, 18)));
        int i24 = 1;
        e eVar32 = new e(32, 8, 64, 6, 14, new c(18, new b(i24, 24)));
        e eVar33 = new e(33, 8, 80, 6, 18, new c(22, new b(i24, i22)));
        int i25 = 38;
        int i26 = 1;
        return new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11, eVar12, eVar13, eVar14, eVar15, eVar16, eVar17, eVar18, eVar19, eVar20, eVar21, eVar22, eVar23, eVar24, eVar25, eVar26, eVar27, eVar28, eVar29, eVar30, eVar31, eVar32, eVar33, new e(34, 8, 96, 6, 22, new c(28, new b(1, i25))), new e(35, 8, 120, 6, 18, new c(i22, new b(1, 49))), new e(36, 8, 144, 6, 22, new c(i12, new b(1, 63))), new e(37, 12, 64, 10, 14, new c(27, new b(1, 43))), new e(38, 12, 88, 10, 20, new c(i12, new b(i26, 64))), new e(39, 16, 64, 14, 14, new c(i12, new b(i26, i13))), new e(40, 20, 36, 18, 16, new c(28, new b(i26, 44))), new e(41, 20, 44, 18, 20, new c(34, new b(i26, i15))), new e(42, 20, 64, 18, 14, new c(42, new b(1, 84))), new e(43, 22, 48, 20, 22, new c(i25, new b(1, 72))), new e(44, 24, 48, 22, 22, new c(41, new b(1, 80))), new e(45, 24, 64, 22, 14, new c(46, new b(1, 108))), new e(46, 26, 40, 24, 18, new c(i25, new b(1, 70))), new e(47, 26, 48, 24, 22, new c(42, new b(1, 90))), new e(48, 26, 64, 24, 14, new c(50, new b(1, 118)))};
    }

    public static e h(int i7, int i8) throws f {
        if ((i7 & 1) != 0 || (i8 & 1) != 0) {
            throw f.a();
        }
        for (e eVar : f6393h) {
            if (eVar.f6395b == i7 && eVar.f6396c == i8) {
                return eVar;
            }
        }
        throw f.a();
    }

    public int b() {
        return this.f6398e;
    }

    public int c() {
        return this.f6397d;
    }

    public c d() {
        return this.f6399f;
    }

    public int e() {
        return this.f6396c;
    }

    public int f() {
        return this.f6395b;
    }

    public int g() {
        return this.f6400g;
    }

    public int i() {
        return this.f6394a;
    }

    public String toString() {
        return String.valueOf(this.f6394a);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f6403a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f6404b;

        public b[] a() {
            return this.f6404b;
        }

        public int b() {
            return this.f6403a;
        }

        public c(int i7, b bVar) {
            this.f6403a = i7;
            this.f6404b = new b[]{bVar};
        }

        public c(int i7, b bVar, b bVar2) {
            this.f6403a = i7;
            this.f6404b = new b[]{bVar, bVar2};
        }
    }
}
