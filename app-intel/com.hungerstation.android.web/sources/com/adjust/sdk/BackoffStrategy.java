package com.adjust.sdk;

import com.incognia.core.SeH;

/* loaded from: classes.dex */
public enum BackoffStrategy {
    LONG_WAIT(1, 120000, SeH.f34149e, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, 3600000, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);

    public double maxRange;
    public long maxWait;
    public long milliSecondMultiplier;
    public double minRange;
    public int minRetries;

    BackoffStrategy(int i12, long j12, long j13, double d12, double d13) {
        this.minRetries = i12;
        this.milliSecondMultiplier = j12;
        this.maxWait = j13;
        this.minRange = d12;
        this.maxRange = d13;
    }
}
