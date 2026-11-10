package a4;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 a4.f, still in use, count: 1, list:
  (r0v0 a4.f) from 0x002e: FILLED_NEW_ARRAY (r1v1 a4.f), (r0v0 a4.f), (r3v2 a4.f), (r2v1 a4.f) A[WRAPPED] (LINE:47) elemType: a4.f
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: q, reason: collision with root package name */
    public static final f[] f10799q;

    /* renamed from: l, reason: collision with root package name */
    public final int f10801l;

    static {
        f10799q = new f[]{fVar, new f(1), fVar, new f(3)};
    }

    public f(int i7) {
        this.f10801l = i7;
    }

    public static f d(int i7) {
        if (i7 >= 0) {
            f[] fVarArr = f10799q;
            if (i7 < fVarArr.length) {
                return fVarArr[i7];
            }
        }
        throw new IllegalArgumentException();
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f10800r.clone();
    }
}
