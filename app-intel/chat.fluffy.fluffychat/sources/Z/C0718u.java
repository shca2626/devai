package Z;

import java.util.Objects;

/* renamed from: Z.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0718u {

    /* renamed from: b, reason: collision with root package name */
    public static final C0718u f10072b = new C0718u("", 0, 0, 1.0f, 0, 0, 0, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final a f10073a;

    /* renamed from: Z.u$a */
    public interface a {
    }

    /* renamed from: Z.u$b */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10074a;

        /* renamed from: b, reason: collision with root package name */
        public final float f10075b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10076c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10077d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10078e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10079f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10080g;

        /* renamed from: h, reason: collision with root package name */
        public final float f10081h;

        public b(String str, int i7, int i8, float f7, int i9, int i10, int i11, float f8) {
            this.f10074a = str;
            this.f10076c = i7;
            this.f10077d = i8;
            this.f10075b = f7;
            this.f10078e = i9;
            this.f10079f = i10;
            this.f10080g = i11;
            this.f10081h = f8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f10074a, bVar.f10074a) && this.f10076c == bVar.f10076c && this.f10077d == bVar.f10077d && this.f10075b == bVar.f10075b && this.f10078e == bVar.f10078e && this.f10079f == bVar.f10079f && this.f10080g == bVar.f10080g && this.f10081h == bVar.f10081h;
        }

        public int hashCode() {
            return Objects.hash(this.f10074a, Integer.valueOf(this.f10076c), Integer.valueOf(this.f10077d), Float.valueOf(this.f10075b), Integer.valueOf(this.f10078e), Integer.valueOf(this.f10079f), Integer.valueOf(this.f10080g), Float.valueOf(this.f10081h));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DisplayShapeCompat{ spec=");
            String str = this.f10074a;
            sb.append(str != null ? Integer.valueOf(str.hashCode()) : "null");
            sb.append(" displayWidth=");
            sb.append(this.f10076c);
            sb.append(" displayHeight=");
            sb.append(this.f10077d);
            sb.append(" physicalPixelDisplaySizeRatio=");
            sb.append(this.f10075b);
            sb.append(" rotation=");
            sb.append(this.f10078e);
            sb.append(" offsetX=");
            sb.append(this.f10079f);
            sb.append(" offsetY=");
            sb.append(this.f10080g);
            sb.append(" scale=");
            sb.append(this.f10081h);
            sb.append("}");
            return sb.toString();
        }
    }

    public C0718u(String str, int i7, int i8, float f7, int i9, int i10, int i11, float f8) {
        this.f10073a = new b(str, i7, i8, f7, i9, i10, i11, f8);
    }

    public static C0718u a(int i7, int i8, boolean z7, int i9, int i10, int i11, int i12) {
        return new C0718u(b(i7, i8, z7, i9, i10, i11, i12), i7, i8, 1.0f, 0, 0, 0, 1.0f);
    }

    public static String b(int i7, int i8, boolean z7, int i9, int i10, int i11, int i12) {
        if (z7) {
            int i13 = i7 / 2;
            int i14 = i8 / 2;
            return "M0," + i14 + " A" + i13 + "," + i14 + " 0 1,1 " + i7 + "," + i14 + " A" + i13 + "," + i14 + " 0 1,1 0," + i14 + " Z";
        }
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(i7 / 2, i8 / 2);
        int iMin2 = Math.min(iMin, i9);
        int iMin3 = Math.min(iMin, i10);
        int iMin4 = Math.min(iMin, i11);
        int iMin5 = Math.min(iMin, i12);
        sb.append("M ");
        sb.append(iMin2);
        sb.append(",0");
        sb.append(" L ");
        sb.append(i7 - iMin3);
        sb.append(",0");
        if (iMin3 > 0) {
            sb.append(" A ");
            sb.append(iMin3);
            sb.append(",");
            sb.append(iMin3);
            sb.append(" 0 0,1 ");
            sb.append(i7);
            sb.append(",");
            sb.append(iMin3);
        }
        sb.append(" L ");
        sb.append(i7);
        sb.append(",");
        sb.append(i8 - iMin4);
        if (iMin4 > 0) {
            sb.append(" A ");
            sb.append(iMin4);
            sb.append(",");
            sb.append(iMin4);
            sb.append(" 0 0,1 ");
            sb.append(i7 - iMin4);
            sb.append(",");
            sb.append(i8);
        }
        sb.append(" L ");
        sb.append(iMin5);
        sb.append(",");
        sb.append(i8);
        if (iMin5 > 0) {
            sb.append(" A ");
            sb.append(iMin5);
            sb.append(",");
            sb.append(iMin5);
            sb.append(" 0 0,1 ");
            sb.append(0);
            sb.append(",");
            sb.append(i8 - iMin5);
        }
        if (iMin2 > 0) {
            sb.append(" L ");
            sb.append(0);
            sb.append(",");
            sb.append(iMin2);
            sb.append(" A ");
            sb.append(iMin2);
            sb.append(",");
            sb.append(iMin2);
            sb.append(" 0 0,1 ");
            sb.append(iMin2);
            sb.append(",");
            sb.append(0);
        }
        sb.append(" Z");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0718u) {
            return Objects.equals(this.f10073a, ((C0718u) obj).f10073a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f10073a);
    }

    public String toString() {
        return this.f10073a.toString();
    }
}
