package com.cloudwebrtc.webrtc.video.camera;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Size;
import g5.k;
import java.util.Arrays;
import java.util.function.IntPredicate;

/* loaded from: classes.dex */
public final class CameraRegionUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: com.cloudwebrtc.webrtc.video.camera.CameraRegionUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;

        static {
            int[] iArr = new int[k.e.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr;
            try {
                iArr[k.e.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[k.e.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[k.e.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[k.e.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class MeteringRectangleFactory {
        public static MeteringRectangle create(int i7, int i8, int i9, int i10, int i11) {
            return new MeteringRectangle(i7, i8, i9, i10, i11);
        }
    }

    public static class SizeFactory {
        public static Size create(int i7, int i8) {
            return new Size(i7, i8);
        }
    }

    public static /* synthetic */ boolean a(int i7) {
        return i7 != 0;
    }

    public static MeteringRectangle convertPointToMeteringRectangle(Size size, double d7, double d8, k.e eVar) {
        int i7 = AnonymousClass1.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[eVar.ordinal()];
        if (i7 == 1) {
            d8 = 1.0d - d7;
            d7 = d8;
        } else if (i7 == 2) {
            double d9 = 1.0d - d8;
            d8 = d7;
            d7 = d9;
        } else if (i7 == 4) {
            d7 = 1.0d - d7;
            d8 = 1.0d - d8;
        }
        int iRound = (int) Math.round(d7 * (size.getWidth() - 1));
        int iRound2 = (int) Math.round(d8 * (size.getHeight() - 1));
        int iRound3 = (int) Math.round(size.getWidth() / 10.0d);
        int iRound4 = (int) Math.round(size.getHeight() / 10.0d);
        int i8 = iRound - (iRound3 / 2);
        int i9 = iRound2 - (iRound4 / 2);
        if (i8 < 0) {
            i8 = 0;
        }
        if (i9 < 0) {
            i9 = 0;
        }
        int width = (size.getWidth() - 1) - iRound3;
        int height = (size.getHeight() - 1) - iRound4;
        if (i8 > width) {
            i8 = width;
        }
        if (i9 > height) {
            i9 = height;
        }
        return MeteringRectangleFactory.create(i8, i9, iRound3, iRound4, 1);
    }

    public static Size getCameraBoundaries(CameraCharacteristics cameraCharacteristics, CaptureRequest.Builder builder) {
        if (!SdkCapabilityChecker.supportsDistortionCorrection() || !supportsDistortionCorrection(cameraCharacteristics)) {
            return getSensorInfoPixelArraySize(cameraCharacteristics);
        }
        Integer num = (Integer) builder.get(CaptureRequest.DISTORTION_CORRECTION_MODE);
        Rect sensorInfoPreCorrectionActiveArraySize = (num == null || num.intValue() == 0) ? getSensorInfoPreCorrectionActiveArraySize(cameraCharacteristics) : getSensorInfoActiveArraySize(cameraCharacteristics);
        return SizeFactory.create(sensorInfoPreCorrectionActiveArraySize.width(), sensorInfoPreCorrectionActiveArraySize.height());
    }

    public static Integer getControlMaxRegionsAutoExposure(CameraCharacteristics cameraCharacteristics) {
        return (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
    }

    public static int[] getDistortionCorrectionAvailableModes(CameraCharacteristics cameraCharacteristics) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (int[]) cameraCharacteristics.get(CameraCharacteristics.DISTORTION_CORRECTION_AVAILABLE_MODES);
        }
        return null;
    }

    public static Rect getSensorInfoActiveArraySize(CameraCharacteristics cameraCharacteristics) {
        return (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }

    public static Size getSensorInfoPixelArraySize(CameraCharacteristics cameraCharacteristics) {
        return (Size) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
    }

    public static Rect getSensorInfoPreCorrectionActiveArraySize(CameraCharacteristics cameraCharacteristics) {
        return (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
    }

    @TargetApi(28)
    private static boolean supportsDistortionCorrection(CameraCharacteristics cameraCharacteristics) {
        int[] distortionCorrectionAvailableModes = getDistortionCorrectionAvailableModes(cameraCharacteristics);
        if (distortionCorrectionAvailableModes == null) {
            distortionCorrectionAvailableModes = new int[0];
        }
        return Arrays.stream(distortionCorrectionAvailableModes).filter(new IntPredicate() { // from class: com.cloudwebrtc.webrtc.video.camera.c
            @Override // java.util.function.IntPredicate
            public final boolean test(int i7) {
                return CameraRegionUtils.a(i7);
            }
        }).count() > 0;
    }
}
