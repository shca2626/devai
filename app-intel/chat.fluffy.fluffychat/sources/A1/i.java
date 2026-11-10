package A1;

import g1.S;

/* loaded from: classes.dex */
public final class i implements S {

    /* renamed from: b, reason: collision with root package name */
    public static final i f151b = new i(true);

    /* renamed from: c, reason: collision with root package name */
    public static final i f152c = new i(false);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f153a;

    public i(boolean z7) {
        this.f153a = z7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IncorrectFragmentation{expected=");
        sb.append(!this.f153a);
        sb.append("}");
        return sb.toString();
    }
}
