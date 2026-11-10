package be1;

/* loaded from: classes4.dex */
public class i0 implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    private String f13569b;

    /* renamed from: c, reason: collision with root package name */
    private float f13570c;

    /* renamed from: d, reason: collision with root package name */
    private float f13571d;

    public i0(String str, float f12, float f13) {
        this.f13569b = str;
        this.f13570c = f13;
        this.f13571d = f12;
    }

    private float a() {
        return (float) Math.sqrt((k() * k()) + (c() * c()));
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(i0 i0Var) {
        if (a() > i0Var.a()) {
            return 1;
        }
        a();
        i0Var.a();
        return -1;
    }

    public float c() {
        return this.f13570c;
    }

    public String f() {
        return this.f13569b;
    }

    public float k() {
        return this.f13571d;
    }
}
