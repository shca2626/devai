package com.amazonaws.logging;

/* loaded from: classes7.dex */
public interface Log {
    void debug(Object obj);

    void debug(Object obj, Throwable th2);

    void error(Object obj);

    void error(Object obj, Throwable th2);

    void info(Object obj);

    void info(Object obj, Throwable th2);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void trace(Object obj);

    void trace(Object obj, Throwable th2);

    void warn(Object obj);

    void warn(Object obj, Throwable th2);
}
