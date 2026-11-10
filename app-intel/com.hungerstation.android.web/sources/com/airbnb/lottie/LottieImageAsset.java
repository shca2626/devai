package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes7.dex */
public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;

    /* renamed from: id, reason: collision with root package name */
    private final String f18085id;
    private final int width;

    public LottieImageAsset(int i12, int i13, String str, String str2, String str3) {
        this.width = i12;
        this.height = i13;
        this.f18085id = str;
        this.fileName = str2;
        this.dirName = str3;
    }

    public LottieImageAsset copyWithScale(float f12) {
        LottieImageAsset lottieImageAsset = new LottieImageAsset((int) (this.width * f12), (int) (this.height * f12), this.f18085id, this.fileName, this.dirName);
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            lottieImageAsset.setBitmap(Bitmap.createScaledBitmap(bitmap, lottieImageAsset.width, lottieImageAsset.height, true));
        }
        return lottieImageAsset;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f18085id;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasBitmap() {
        return this.bitmap != null || (this.fileName.startsWith("data:") && this.fileName.indexOf("base64,") > 0);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
