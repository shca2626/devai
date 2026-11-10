package K0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class T implements Executor {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Handler f5083l;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f5083l.post(runnable);
    }
}
