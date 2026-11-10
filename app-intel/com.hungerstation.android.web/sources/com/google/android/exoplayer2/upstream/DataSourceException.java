package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes8.dex */
public class DataSourceException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public final int f21624b;

    public DataSourceException(int i12) {
        this.f21624b = i12;
    }

    public static boolean a(IOException iOException) {
        for (IOException cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).f21624b == 2008) {
                return true;
            }
        }
        return false;
    }

    public DataSourceException(Throwable th2, int i12) {
        super(th2);
        this.f21624b = i12;
    }

    public DataSourceException(String str, int i12) {
        super(str);
        this.f21624b = i12;
    }

    public DataSourceException(String str, Throwable th2, int i12) {
        super(str, th2);
        this.f21624b = i12;
    }
}
