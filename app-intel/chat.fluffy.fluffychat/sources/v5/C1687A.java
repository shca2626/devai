package v5;

import java.util.Map;

/* renamed from: v5.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1687A {

    /* renamed from: e, reason: collision with root package name */
    public static final a f23053e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f23054a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23055b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23056c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23057d;

    /* renamed from: v5.A$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1687A a(Map map) {
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
            return new C1687A(iIntValue, iIntValue2, iIntValue3, str);
        }

        public a() {
        }
    }

    public C1687A(int i7, int i8, int i9, String str) {
        M5.m.e(str, "commonFormat");
        this.f23054a = i7;
        this.f23055b = i8;
        this.f23056c = i9;
        this.f23057d = str;
    }

    public final String a() {
        return this.f23057d;
    }

    public final int b() {
        return this.f23056c;
    }

    public final int c() {
        return this.f23055b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1687A)) {
            return false;
        }
        C1687A c1687a = (C1687A) obj;
        return this.f23054a == c1687a.f23054a && this.f23055b == c1687a.f23055b && this.f23056c == c1687a.f23056c && M5.m.a(this.f23057d, c1687a.f23057d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f23054a) * 31) + Integer.hashCode(this.f23055b)) * 31) + Integer.hashCode(this.f23056c)) * 31) + this.f23057d.hashCode();
    }

    public String toString() {
        return "RendererAudioFormat(bitsPerSample=" + this.f23054a + ", sampleRate=" + this.f23055b + ", numberOfChannels=" + this.f23056c + ", commonFormat=" + this.f23057d + ')';
    }
}
