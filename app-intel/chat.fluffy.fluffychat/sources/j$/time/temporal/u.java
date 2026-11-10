package j$.time.temporal;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a, reason: collision with root package name */
    public final long f18405a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18406b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18407c;

    /* renamed from: d, reason: collision with root package name */
    public final long f18408d;

    public static u f(long j7, long j8) {
        if (j7 > j8) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(j7, j7, j8, j8);
    }

    public static u g(long j7, long j8) {
        if (j7 > j8) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (1 > j8) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new u(1L, 1L, j7, j8);
    }

    public u(long j7, long j8, long j9, long j10) {
        this.f18405a = j7;
        this.f18406b = j8;
        this.f18407c = j9;
        this.f18408d = j10;
    }

    public final boolean d() {
        return this.f18405a >= -2147483648L && this.f18408d <= 2147483647L;
    }

    public final boolean e(long j7) {
        return j7 >= this.f18405a && j7 <= this.f18408d;
    }

    public final int a(long j7, q qVar) {
        if (d() && e(j7)) {
            return (int) j7;
        }
        throw new j$.time.c(c(j7, qVar));
    }

    public final void b(long j7, q qVar) {
        if (!e(j7)) {
            throw new j$.time.c(c(j7, qVar));
        }
    }

    public final String c(long j7, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j7;
        }
        return "Invalid value (valid values " + this + "): " + j7;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j7 = this.f18405a;
        long j8 = this.f18406b;
        if (j7 > j8) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j9 = this.f18407c;
        long j10 = this.f18408d;
        if (j9 > j10) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j8 > j10) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f18405a == uVar.f18405a && this.f18406b == uVar.f18406b && this.f18407c == uVar.f18407c && this.f18408d == uVar.f18408d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j7 = this.f18405a;
        long j8 = this.f18406b;
        long j9 = j7 + (j8 << 16) + (j8 >> 48);
        long j10 = this.f18407c;
        long j11 = j9 + (j10 << 32) + (j10 >> 32);
        long j12 = this.f18408d;
        long j13 = j11 + (j12 << 48) + (j12 >> 16);
        return (int) (j13 ^ (j13 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18405a);
        if (this.f18405a != this.f18406b) {
            sb.append(JsonPointer.SEPARATOR);
            sb.append(this.f18406b);
        }
        sb.append(" - ");
        sb.append(this.f18407c);
        if (this.f18407c != this.f18408d) {
            sb.append(JsonPointer.SEPARATOR);
            sb.append(this.f18408d);
        }
        return sb.toString();
    }
}
