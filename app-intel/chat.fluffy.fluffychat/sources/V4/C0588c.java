package V4;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: V4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0588c {

    /* renamed from: f, reason: collision with root package name */
    public static final Matrix f8755f = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final FlutterRenderer f8756a;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8758c;

    /* renamed from: e, reason: collision with root package name */
    public int f8760e;

    /* renamed from: d, reason: collision with root package name */
    public final Map f8759d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final S f8757b = S.a();

    public C0588c(FlutterRenderer flutterRenderer, boolean z7) {
        this.f8756a = flutterRenderer;
        this.f8758c = z7;
    }

    public final void a(MotionEvent motionEvent, int i7, int i8, int i9, Matrix matrix, ByteBuffer byteBuffer) {
        b(motionEvent, i7, i8, i9, matrix, byteBuffer, null);
    }

    public final void b(MotionEvent motionEvent, int i7, int i8, int i9, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        int i10;
        int i11;
        long j7;
        long j8;
        double min;
        double max;
        double dC;
        double dG;
        InputDevice.MotionRange motionRange;
        int i12 = -1;
        if (i8 == -1) {
            return;
        }
        int iM = m(motionEvent, i7);
        int iF = f(motionEvent.getToolType(i7));
        float[] fArr = {motionEvent.getX(i7), motionEvent.getY(i7)};
        matrix.mapPoints(fArr);
        if (iF == 1) {
            i11 = 0;
            j7 = 0;
            long buttonState = motionEvent.getButtonState() & 31;
            if (buttonState == 0) {
                i10 = 1;
                if (motionEvent.getSource() == 8194 && i8 == 4) {
                    this.f8759d.put(Integer.valueOf(iM), fArr);
                }
            } else {
                i10 = 1;
            }
            j8 = buttonState;
        } else {
            i10 = 1;
            i11 = 0;
            j7 = 0;
            j8 = iF == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean zContainsKey = this.f8759d.containsKey(Integer.valueOf(iM));
        if (zContainsKey) {
            int iE = e(i8);
            if (iE == -1) {
                return;
            } else {
                i12 = iE;
            }
        }
        long jD = this.f8758c ? this.f8757b.c(motionEvent).d() : j7;
        int i13 = motionEvent.getActionMasked() == 8 ? i10 : i11;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(jD);
        byteBuffer.putLong(eventTime);
        if (zContainsKey) {
            byteBuffer.putLong(i12);
            byteBuffer.putLong(4L);
        } else {
            byteBuffer.putLong(i8);
            byteBuffer.putLong(iF);
        }
        byteBuffer.putLong(i13);
        byteBuffer.putLong(iM);
        byteBuffer.putLong(j7);
        if (zContainsKey) {
            float[] fArr2 = (float[]) this.f8759d.get(Integer.valueOf(iM));
            byteBuffer.putDouble(fArr2[i11]);
            byteBuffer.putDouble(fArr2[i10]);
        } else {
            byteBuffer.putDouble(fArr[i11]);
            byteBuffer.putDouble(fArr[i10]);
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(j8);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i7));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            min = 0.0d;
            max = 1.0d;
        } else {
            min = motionRange.getMin();
            max = motionRange.getMax();
        }
        byteBuffer.putDouble(min);
        byteBuffer.putDouble(max);
        if (iF == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i7));
            byteBuffer.putDouble(0.0d);
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(motionEvent.getSize(i7));
        byteBuffer.putDouble(motionEvent.getToolMajor(i7));
        byteBuffer.putDouble(motionEvent.getToolMinor(i7));
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i7));
        if (iF == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i7));
        } else {
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putLong(i9);
        if (i13 == i10) {
            if (context != null) {
                dC = c(context);
                dG = g(context);
            } else {
                dC = 48.0d;
                dG = 48.0d;
            }
            byteBuffer.putDouble(dC * (-motionEvent.getAxisValue(10, i7)));
            byteBuffer.putDouble(dG * (-motionEvent.getAxisValue(9, i7)));
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        if (zContainsKey) {
            float[] fArr3 = (float[]) this.f8759d.get(Integer.valueOf(iM));
            byteBuffer.putDouble(fArr[i11] - fArr3[i11]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(0L);
        if (zContainsKey && i12 == 9) {
            this.f8759d.remove(Integer.valueOf(iM));
        }
    }

    public final float c(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? ViewConfiguration.get(context).getScaledHorizontalScrollFactor() : i(context);
    }

    public final int d(int i7) {
        if (i7 == 0) {
            return 4;
        }
        if (i7 == 1) {
            return 6;
        }
        if (i7 == 5) {
            return 4;
        }
        if (i7 == 6) {
            return 6;
        }
        if (i7 == 2) {
            return 5;
        }
        if (i7 == 7) {
            return 3;
        }
        if (i7 == 3) {
            return 0;
        }
        return i7 == 8 ? 3 : -1;
    }

    public final int e(int i7) {
        if (i7 == 4) {
            return 7;
        }
        if (i7 == 5) {
            return 8;
        }
        return (i7 == 6 || i7 == 0) ? 9 : -1;
    }

    public final int f(int i7) {
        if (i7 == 1) {
            return 0;
        }
        if (i7 == 2) {
            return 2;
        }
        if (i7 != 3) {
            return i7 != 4 ? 5 : 3;
        }
        return 1;
    }

    public final float g(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? h(context) : i(context);
    }

    public final float h(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    public final int i(Context context) {
        if (this.f8760e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.f8760e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f8760e;
    }

    public boolean j(MotionEvent motionEvent, Context context) {
        boolean zIsFromSource = motionEvent.isFromSource(2);
        boolean z7 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!zIsFromSource || !z7) {
            return false;
        }
        int iD = d(motionEvent.getActionMasked());
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        b(motionEvent, motionEvent.getActionIndex(), iD, 0, f8755f, byteBufferAllocateDirect, context);
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f8756a.n(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }

    public boolean k(MotionEvent motionEvent) {
        return l(motionEvent, f8755f);
    }

    public boolean l(MotionEvent motionEvent, Matrix matrix) {
        int actionMasked = motionEvent.getActionMasked();
        int iD = d(motionEvent.getActionMasked());
        boolean z7 = actionMasked == 0 || actionMasked == 5;
        boolean z8 = !z7 && (actionMasked == 1 || actionMasked == 6);
        int i7 = (z8 && f(motionEvent.getToolType(motionEvent.getActionIndex())) == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((pointerCount + i7) * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z7) {
            a(motionEvent, motionEvent.getActionIndex(), iD, 0, matrix, byteBufferAllocateDirect);
        } else if (z8) {
            for (int i8 = 0; i8 < pointerCount; i8++) {
                if (i8 != motionEvent.getActionIndex() && motionEvent.getToolType(i8) == 1) {
                    a(motionEvent, i8, 5, 1, matrix, byteBufferAllocateDirect);
                }
            }
            a(motionEvent, motionEvent.getActionIndex(), iD, 0, matrix, byteBufferAllocateDirect);
            if (i7 != 0) {
                a(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, byteBufferAllocateDirect);
            }
        } else {
            for (int i9 = 0; i9 < pointerCount; i9++) {
                a(motionEvent, i9, iD, (pointerCount << 8) | 2, matrix, byteBufferAllocateDirect);
            }
        }
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.f8756a.n(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }

    public final int m(MotionEvent motionEvent, int i7) {
        return (motionEvent.getToolType(i7) & 7) | (motionEvent.getPointerId(i7) << 3);
    }
}
