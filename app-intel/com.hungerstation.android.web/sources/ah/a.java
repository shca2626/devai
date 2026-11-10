package ah;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes8.dex */
public final class a implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    private final transient int[] f1072b;

    /* renamed from: c, reason: collision with root package name */
    private final transient char[] f1073c;

    /* renamed from: d, reason: collision with root package name */
    private final transient byte[] f1074d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f1075e;

    /* renamed from: f, reason: collision with root package name */
    protected final transient boolean f1076f;

    /* renamed from: g, reason: collision with root package name */
    protected final transient char f1077g;

    /* renamed from: h, reason: collision with root package name */
    protected final transient int f1078h;

    public a(String str, String str2, boolean z12, char c12, int i12) {
        int[] iArr = new int[UserVerificationMethods.USER_VERIFY_PATTERN];
        this.f1072b = iArr;
        char[] cArr = new char[64];
        this.f1073c = cArr;
        this.f1074d = new byte[64];
        this.f1075e = str;
        this.f1076f = z12;
        this.f1077g = c12;
        this.f1078h = i12;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i13 = 0; i13 < length; i13++) {
            char c13 = this.f1073c[i13];
            this.f1074d[i13] = (byte) c13;
            this.f1072b[c13] = i13;
        }
        if (z12) {
            this.f1072b[c12] = -2;
        }
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return this.f1075e.hashCode();
    }

    public String toString() {
        return this.f1075e;
    }

    public a(a aVar, String str, int i12) {
        this(aVar, str, aVar.f1076f, aVar.f1077g, i12);
    }

    public a(a aVar, String str, boolean z12, char c12, int i12) {
        int[] iArr = new int[UserVerificationMethods.USER_VERIFY_PATTERN];
        this.f1072b = iArr;
        char[] cArr = new char[64];
        this.f1073c = cArr;
        byte[] bArr = new byte[64];
        this.f1074d = bArr;
        this.f1075e = str;
        byte[] bArr2 = aVar.f1074d;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = aVar.f1073c;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = aVar.f1072b;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f1076f = z12;
        this.f1077g = c12;
        this.f1078h = i12;
    }
}
