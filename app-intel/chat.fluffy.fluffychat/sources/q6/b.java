package q6;

/* loaded from: classes3.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* renamed from: l, reason: collision with root package name */
    public final int f21483l;

    b(int i7) {
        this.f21483l = i7;
    }

    public static b a(int i7) {
        for (b bVar : values()) {
            if (bVar.f21483l == i7) {
                return bVar;
            }
        }
        return null;
    }
}
