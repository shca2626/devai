package j0;

import M5.m;
import androidx.datastore.preferences.protobuf.C0791v;
import h0.C1129d;
import java.io.InputStream;

/* renamed from: j0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1219d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18668a = new a(null);

    /* renamed from: j0.d$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1221f a(InputStream inputStream) throws C1129d {
            m.e(inputStream, "input");
            try {
                C1221f c1221fY = C1221f.Y(inputStream);
                m.d(c1221fY, "{\n                Prefer…From(input)\n            }");
                return c1221fY;
            } catch (C0791v e7) {
                throw new C1129d("Unable to parse preferences proto.", e7);
            }
        }

        public a() {
        }
    }
}
