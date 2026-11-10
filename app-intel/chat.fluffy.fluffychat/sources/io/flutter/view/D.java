package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* loaded from: classes.dex */
public class D {

    /* renamed from: e, reason: collision with root package name */
    public static D f17925e;

    /* renamed from: f, reason: collision with root package name */
    public static b f17926f;

    /* renamed from: b, reason: collision with root package name */
    public FlutterJNI f17928b;

    /* renamed from: a, reason: collision with root package name */
    public long f17927a = -1;

    /* renamed from: c, reason: collision with root package name */
    public c f17929c = new c(0);

    /* renamed from: d, reason: collision with root package name */
    public final FlutterJNI.b f17930d = new a();

    public class a implements FlutterJNI.b {
        public a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j7) {
            Choreographer.getInstance().postFrameCallback(b(j7));
        }

        public final Choreographer.FrameCallback b(long j7) {
            if (D.this.f17929c == null) {
                return D.this.new c(j7);
            }
            D.this.f17929c.f17934a = j7;
            c cVar = D.this.f17929c;
            D.this.f17929c = null;
            return cVar;
        }
    }

    public class b implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        public DisplayManager f17932a;

        public b(DisplayManager displayManager) {
            this.f17932a = displayManager;
        }

        public void a() {
            this.f17932a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i7) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i7) {
            if (i7 == 0) {
                float refreshRate = this.f17932a.getDisplay(0).getRefreshRate();
                D.this.f17927a = (long) (1.0E9d / refreshRate);
                D.this.f17928b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i7) {
        }
    }

    public class c implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        public long f17934a;

        public c(long j7) {
            this.f17934a = j7;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j7) {
            long jNanoTime = System.nanoTime() - j7;
            D.this.f17928b.onVsync(jNanoTime < 0 ? 0L : jNanoTime, D.this.f17927a, this.f17934a);
            D.this.f17929c = this;
        }
    }

    public D(FlutterJNI flutterJNI) {
        this.f17928b = flutterJNI;
    }

    public static D f(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f17925e == null) {
            f17925e = new D(flutterJNI);
        }
        if (f17926f == null) {
            D d7 = f17925e;
            Objects.requireNonNull(d7);
            b bVar = d7.new b(displayManager);
            f17926f = bVar;
            bVar.a();
        }
        if (f17925e.f17927a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f17925e.f17927a = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f17925e;
    }

    public void g() {
        this.f17928b.setAsyncWaitForVsyncDelegate(this.f17930d);
    }
}
