package ah;

/* loaded from: classes8.dex */
public enum h {
    NOT_AVAILABLE(null, -1),
    START_OBJECT("{", 1),
    END_OBJECT("}", 2),
    START_ARRAY("[", 3),
    END_ARRAY("]", 4),
    FIELD_NAME(null, 5),
    VALUE_EMBEDDED_OBJECT(null, 12),
    VALUE_STRING(null, 6),
    VALUE_NUMBER_INT(null, 7),
    VALUE_NUMBER_FLOAT(null, 8),
    VALUE_TRUE("true", 9),
    VALUE_FALSE("false", 10),
    VALUE_NULL("null", 11);


    /* renamed from: b, reason: collision with root package name */
    final String f1156b;

    /* renamed from: c, reason: collision with root package name */
    final char[] f1157c;

    /* renamed from: d, reason: collision with root package name */
    final byte[] f1158d;

    /* renamed from: e, reason: collision with root package name */
    final int f1159e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f1160f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f1161g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f1162h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f1163i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f1164j;

    h(String str, int i12) {
        boolean z12 = false;
        if (str == null) {
            this.f1156b = null;
            this.f1157c = null;
            this.f1158d = null;
        } else {
            this.f1156b = str;
            char[] charArray = str.toCharArray();
            this.f1157c = charArray;
            int length = charArray.length;
            this.f1158d = new byte[length];
            for (int i13 = 0; i13 < length; i13++) {
                this.f1158d[i13] = (byte) this.f1157c[i13];
            }
        }
        this.f1159e = i12;
        this.f1163i = i12 == 10 || i12 == 9;
        this.f1162h = i12 == 7 || i12 == 8;
        boolean z13 = i12 == 1 || i12 == 3;
        this.f1160f = z13;
        boolean z14 = i12 == 2 || i12 == 4;
        this.f1161g = z14;
        if (!z13 && !z14 && i12 != 5 && i12 != -1) {
            z12 = true;
        }
        this.f1164j = z12;
    }

    public final String b() {
        return this.f1156b;
    }

    public final int c() {
        return this.f1159e;
    }

    public final boolean f() {
        return this.f1161g;
    }

    public final boolean k() {
        return this.f1160f;
    }
}
