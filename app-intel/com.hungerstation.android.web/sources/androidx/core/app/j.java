package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final b f6255a;

    private static class a extends b {

        /* renamed from: e, reason: collision with root package name */
        private static HandlerThread f6256e;

        /* renamed from: f, reason: collision with root package name */
        private static Handler f6257f;

        /* renamed from: a, reason: collision with root package name */
        int f6258a;

        /* renamed from: b, reason: collision with root package name */
        SparseIntArray[] f6259b = new SparseIntArray[9];

        /* renamed from: c, reason: collision with root package name */
        private final ArrayList<WeakReference<Activity>> f6260c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f6261d = new WindowOnFrameMetricsAvailableListenerC0110a();

        /* renamed from: androidx.core.app.j$a$a, reason: collision with other inner class name */
        class WindowOnFrameMetricsAvailableListenerC0110a implements Window.OnFrameMetricsAvailableListener {
            WindowOnFrameMetricsAvailableListenerC0110a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i12) {
                a aVar = a.this;
                if ((aVar.f6258a & 1) != 0) {
                    aVar.e(aVar.f6259b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f6258a & 2) != 0) {
                    aVar2.e(aVar2.f6259b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f6258a & 4) != 0) {
                    aVar3.e(aVar3.f6259b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f6258a & 8) != 0) {
                    aVar4.e(aVar4.f6259b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f6258a & 16) != 0) {
                    aVar5.e(aVar5.f6259b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f6258a & 64) != 0) {
                    aVar6.e(aVar6.f6259b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f6258a & 32) != 0) {
                    aVar7.e(aVar7.f6259b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f6258a & UserVerificationMethods.USER_VERIFY_PATTERN) != 0) {
                    aVar8.e(aVar8.f6259b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f6258a & 256) != 0) {
                    aVar9.e(aVar9.f6259b[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i12) {
            this.f6258a = i12;
        }

        @Override // androidx.core.app.j.b
        public void a(Activity activity) {
            if (f6256e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f6256e = handlerThread;
                handlerThread.start();
                f6257f = new Handler(f6256e.getLooper());
            }
            for (int i12 = 0; i12 <= 8; i12++) {
                SparseIntArray[] sparseIntArrayArr = this.f6259b;
                if (sparseIntArrayArr[i12] == null && (this.f6258a & (1 << i12)) != 0) {
                    sparseIntArrayArr[i12] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f6261d, f6257f);
            this.f6260c.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.j.b
        public SparseIntArray[] b() {
            return this.f6259b;
        }

        @Override // androidx.core.app.j.b
        public SparseIntArray[] c(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f6260c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.f6260c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f6261d);
            return this.f6259b;
        }

        @Override // androidx.core.app.j.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f6259b;
            this.f6259b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        void e(SparseIntArray sparseIntArray, long j12) {
            if (sparseIntArray != null) {
                int i12 = (int) ((500000 + j12) / 1000000);
                if (j12 >= 0) {
                    sparseIntArray.put(i12, sparseIntArray.get(i12) + 1);
                }
            }
        }
    }

    private static class b {
        b() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }
    }

    public j() {
        this(1);
    }

    public void a(Activity activity) {
        this.f6255a.a(activity);
    }

    public SparseIntArray[] b() {
        return this.f6255a.b();
    }

    public SparseIntArray[] c(Activity activity) {
        return this.f6255a.c(activity);
    }

    public SparseIntArray[] d() {
        return this.f6255a.d();
    }

    public j(int i12) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6255a = new a(i12);
        } else {
            this.f6255a = new b();
        }
    }
}
