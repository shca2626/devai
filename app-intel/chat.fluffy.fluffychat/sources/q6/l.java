package q6;

import java.util.List;

/* loaded from: classes3.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f21644a = new a();

    boolean a(int i7, v6.g gVar, int i8, boolean z7);

    boolean b(int i7, List list);

    boolean c(int i7, List list, boolean z7);

    void d(int i7, b bVar);

    public class a implements l {
        @Override // q6.l
        public boolean a(int i7, v6.g gVar, int i8, boolean z7) {
            gVar.skip(i8);
            return true;
        }

        @Override // q6.l
        public boolean b(int i7, List list) {
            return true;
        }

        @Override // q6.l
        public boolean c(int i7, List list, boolean z7) {
            return true;
        }

        @Override // q6.l
        public void d(int i7, b bVar) {
        }
    }
}
