package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import j2.C1226a;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* renamed from: b, reason: collision with root package name */
    public SidecarDeviceState f13474b;

    /* renamed from: d, reason: collision with root package name */
    public final C1226a f13476d;

    /* renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f13477e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f13473a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Map f13475c = new WeakHashMap();

    public DistinctElementSidecarCallback(C1226a c1226a, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f13476d = c1226a;
        this.f13477e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f13473a) {
            try {
                if (this.f13476d.a(this.f13474b, sidecarDeviceState)) {
                    return;
                }
                this.f13474b = sidecarDeviceState;
                this.f13477e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f13473a) {
            try {
                if (this.f13476d.d((SidecarWindowLayoutInfo) this.f13475c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f13475c.put(iBinder, sidecarWindowLayoutInfo);
                this.f13477e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
