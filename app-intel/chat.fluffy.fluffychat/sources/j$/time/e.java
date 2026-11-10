package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class e implements j$.time.temporal.p, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final e f18265c = new e(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a, reason: collision with root package name */
    public final long f18266a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18267b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        int iCompare = Long.compare(this.f18266a, eVar.f18266a);
        return iCompare != 0 ? iCompare : this.f18267b - eVar.f18267b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static e F(long j7) {
        long j8 = j7 / 1000000000;
        int i7 = (int) (j7 % 1000000000);
        if (i7 < 0) {
            i7 = (int) (i7 + 1000000000);
            j8--;
        }
        return A(j8, i7);
    }

    public static e A(long j7, int i7) {
        if ((i7 | j7) == 0) {
            return f18265c;
        }
        return new e(j7, i7);
    }

    public e(long j7, int i7) {
        this.f18266a = j7;
        this.f18267b = i7;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        long j7 = this.f18266a;
        if (j7 != 0) {
            mVar = mVar.d(j7, j$.time.temporal.b.SECONDS);
        }
        int i7 = this.f18267b;
        return i7 != 0 ? mVar.d(i7, j$.time.temporal.b.NANOS) : mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f18266a == eVar.f18266a && this.f18267b == eVar.f18267b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j7 = this.f18266a;
        return (this.f18267b * 51) + ((int) (j7 ^ (j7 >>> 32)));
    }

    public final String toString() {
        if (this == f18265c) {
            return "PT0S";
        }
        long j7 = this.f18266a;
        if (j7 < 0 && this.f18267b > 0) {
            j7++;
        }
        long j8 = j7 / 3600;
        int i7 = (int) ((j7 % 3600) / 60);
        int i8 = (int) (j7 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j8 != 0) {
            sb.append(j8);
            sb.append('H');
        }
        if (i7 != 0) {
            sb.append(i7);
            sb.append('M');
        }
        if (i8 == 0 && this.f18267b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f18266a < 0 && this.f18267b > 0 && i8 == 0) {
            sb.append("-0");
        } else {
            sb.append(i8);
        }
        if (this.f18267b > 0) {
            int length = sb.length();
            if (this.f18266a < 0) {
                sb.append(2000000000 - this.f18267b);
            } else {
                sb.append(this.f18267b + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new u((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
