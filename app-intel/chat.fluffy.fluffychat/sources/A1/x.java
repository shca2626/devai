package A1;

import E0.AbstractC0333s;
import g1.V;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f222a;

    /* renamed from: b, reason: collision with root package name */
    public final String f223b;

    /* renamed from: c, reason: collision with root package name */
    public final V.a f224c;

    /* renamed from: d, reason: collision with root package name */
    public final int f225d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f226e;

    public x(boolean z7, String str, int i7, byte[] bArr, int i8, int i9, byte[] bArr2) {
        j3.o.d((bArr2 == null) ^ (i7 == 0));
        this.f222a = z7;
        this.f223b = str;
        this.f225d = i7;
        this.f226e = bArr2;
        this.f224c = new V.a(a(str), bArr, i8, i9);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c7 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c7 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c7 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c7 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c7 = 3;
                    break;
                }
                break;
        }
        switch (c7) {
            case 0:
            case 1:
                return 2;
            default:
                AbstractC0333s.h("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
