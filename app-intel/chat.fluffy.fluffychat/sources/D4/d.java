package D4;

import M5.m;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1776c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final e f1777a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1778b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final d a(String str) {
            m.e(str, "jsonString");
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.isNull("taskEventType") ? e.f1780n : e.f1779m.a(jSONObject.getInt("taskEventType")), jSONObject.isNull("taskEventInterval") ? 5000L : jSONObject.getInt("taskEventInterval"));
        }

        public a() {
        }
    }

    public d(e eVar, long j7) {
        m.e(eVar, "type");
        this.f1777a = eVar;
        this.f1778b = j7;
    }

    public final long a() {
        return this.f1778b;
    }

    public final e b() {
        return this.f1777a;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (this.f1777a.d() == dVar.f1777a.d() && this.f1778b == dVar.f1778b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f1777a.d()), Long.valueOf(this.f1778b));
    }

    public String toString() {
        return "ForegroundTaskEventAction(type=" + this.f1777a + ", interval=" + this.f1778b + ")";
    }
}
