package V5;

/* loaded from: classes.dex */
public class m {
    public static void a(Appendable appendable, Object obj, L5.l lVar) {
        M5.m.e(appendable, "<this>");
        if (lVar != null) {
            appendable.append((CharSequence) lVar.a(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }
}
