package X5;

import W5.G0;
import android.os.Looper;
import b6.InterfaceC0883s;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements InterfaceC0883s {
    @Override // b6.InterfaceC0883s
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // b6.InterfaceC0883s
    public G0 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new e(g.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // b6.InterfaceC0883s
    public int c() {
        return 1073741823;
    }
}
