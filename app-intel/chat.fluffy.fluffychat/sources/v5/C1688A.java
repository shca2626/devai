package v5;

import java.util.Map;

/* renamed from: v5.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1688A {

    /* renamed from: e, reason: collision with root package name */
    public static final a f23047e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f23048a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23049b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23050c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23051d;

    /* renamed from: v5.A$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1688A a(Map map) {
            M5.m.e(map, "formatMap");
            Object obj = map.get("bitsPerSample");
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 16;
            Object obj2 = map.get("sampleRate");
            Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
            int iIntValue2 = num2 != null ? num2.intValue() : 48000;
            Object obj3 = map.get("channels");
            Integer num3 = obj3 instanceof Integer ? (Integer) obj3 : null;
            int iIntValue3 = num3 != null ? num3.intValue() : 1;
            Object obj4 = map.get("commonFormat");
            String str = obj4 instanceof String ? (String) obj4 : null;
            if (str == null) {
                str = "int16";
            }
            return new C1688A(iIntValue, iIntValue2, iIntValue3, str);
        }

        public a() {
        }
    }

    public C1688A(int i7, int i8, int i9, String str) {
        M5.m.e(str, "commonFormat");
        this.f23048a = i7;
        this.f23049b = i8;
        this.f23050c = i9;
        this.f23051d = str;
    }

    public final String a() {
        return this.f23051d;
    }

    public final int b() {
        return this.f23050c;
    }

    public final int c() {
        return this.f23049b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1688A)) {
            return false;
        }
        C1688A c1688a = (C1688A) obj;
        return this.f23048a == c1688a.f23048a && this.f23049b == c1688a.f23049b && this.f23050c == c1688a.f23050c && M5.m.a(this.f23051d, c1688a.f23051d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f23048a) * 31) + Integer.hashCode(this.f23049b)) * 31) + Integer.hashCode(this.f23050c)) * 31) + this.f23051d.hashCode();
    }

    public String toString() {
        return "RendererAudioFormat(bitsPerSample=" + this.f23048a + ", sampleRate=" + this.f23049b + ", numberOfChannels=" + this.f23050c + ", commonFormat=" + this.f23051d + ')';
    }
}
