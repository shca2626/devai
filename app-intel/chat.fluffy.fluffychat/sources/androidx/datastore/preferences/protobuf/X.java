package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class X implements I {

    /* renamed from: a, reason: collision with root package name */
    public final K f11994a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11995b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f11996c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11997d;

    public X(K k7, String str, Object[] objArr) {
        this.f11994a = k7;
        this.f11995b = str;
        this.f11996c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f11997d = cCharAt;
            return;
        }
        int i7 = cCharAt & 8191;
        int i8 = 13;
        int i9 = 1;
        while (true) {
            int i10 = i9 + 1;
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 < 55296) {
                this.f11997d = i7 | (cCharAt2 << i8);
                return;
            } else {
                i7 |= (cCharAt2 & 8191) << i8;
                i8 += 13;
                i9 = i10;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public boolean a() {
        return (this.f11997d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public K b() {
        return this.f11994a;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public U c() {
        int i7 = this.f11997d;
        return (i7 & 1) != 0 ? U.PROTO2 : (i7 & 4) == 4 ? U.EDITIONS : U.PROTO3;
    }

    public Object[] d() {
        return this.f11996c;
    }

    public String e() {
        return this.f11995b;
    }
}
