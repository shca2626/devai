package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class e0 {

    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0775f f12024a;

        public a(AbstractC0775f abstractC0775f) {
            this.f12024a = abstractC0775f;
        }

        @Override // androidx.datastore.preferences.protobuf.e0.b
        public byte a(int i7) {
            return this.f12024a.g(i7);
        }

        @Override // androidx.datastore.preferences.protobuf.e0.b
        public int size() {
            return this.f12024a.size();
        }
    }

    public interface b {
        byte a(int i7);

        int size();
    }

    public static String a(AbstractC0775f abstractC0775f) {
        return b(new a(abstractC0775f));
    }

    public static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i7 = 0; i7 < bVar.size(); i7++) {
            byte bA = bVar.a(i7);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bA);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        return a(AbstractC0775f.l(str));
    }
}
