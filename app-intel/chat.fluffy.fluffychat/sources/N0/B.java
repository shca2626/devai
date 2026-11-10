package N0;

import java.util.UUID;

/* loaded from: classes.dex */
public final class B implements H0.b {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f5788d;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f5789a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f5790b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5791c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    static {
        /*
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1e
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L1c
            java.lang.String r1 = "AFTB"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L1e
        L1c:
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            N0.B.f5788d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N0.B.<clinit>():void");
    }

    public B(UUID uuid, byte[] bArr) {
        this(uuid, bArr, false);
    }

    public B(UUID uuid, byte[] bArr, boolean z7) {
        this.f5789a = uuid;
        this.f5790b = bArr;
        this.f5791c = z7;
    }
}
