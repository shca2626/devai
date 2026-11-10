package ah;

import com.instabug.library.model.StepType;
import java.io.Serializable;

/* loaded from: classes8.dex */
public class e implements Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final e f1113g = new e("N/A", -1, -1, -1, -1);

    /* renamed from: b, reason: collision with root package name */
    final long f1114b;

    /* renamed from: c, reason: collision with root package name */
    final long f1115c;

    /* renamed from: d, reason: collision with root package name */
    final int f1116d;

    /* renamed from: e, reason: collision with root package name */
    final int f1117e;

    /* renamed from: f, reason: collision with root package name */
    final transient Object f1118f;

    public e(Object obj, long j12, int i12, int i13) {
        this(obj, -1L, j12, i12, i13);
    }

    public long b() {
        return this.f1114b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        Object obj2 = this.f1118f;
        if (obj2 == null) {
            if (eVar.f1118f != null) {
                return false;
            }
        } else if (!obj2.equals(eVar.f1118f)) {
            return false;
        }
        return this.f1116d == eVar.f1116d && this.f1117e == eVar.f1117e && this.f1115c == eVar.f1115c && b() == eVar.b();
    }

    public int hashCode() {
        Object obj = this.f1118f;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.f1116d) + this.f1117e) ^ ((int) this.f1115c)) + ((int) this.f1114b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(80);
        sb2.append("[Source: ");
        Object obj = this.f1118f;
        if (obj == null) {
            sb2.append(StepType.UNKNOWN);
        } else {
            sb2.append(obj.toString());
        }
        sb2.append("; line: ");
        sb2.append(this.f1116d);
        sb2.append(", column: ");
        sb2.append(this.f1117e);
        sb2.append(']');
        return sb2.toString();
    }

    public e(Object obj, long j12, long j13, int i12, int i13) {
        this.f1118f = obj;
        this.f1114b = j12;
        this.f1115c = j13;
        this.f1116d = i12;
        this.f1117e = i13;
    }
}
