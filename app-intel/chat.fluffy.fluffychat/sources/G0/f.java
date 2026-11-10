package G0;

import B0.InterfaceC0309k;
import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public interface f extends InterfaceC0309k {

    public interface a {
        f a();
    }

    void close();

    void l(x xVar);

    default Map n() {
        return Collections.EMPTY_MAP;
    }

    Uri r();

    long s(j jVar);
}
