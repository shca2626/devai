package com.amazonaws.event;

/* loaded from: classes7.dex */
public class ProgressEvent {
    public static final int CANCELED_EVENT_CODE = 16;
    public static final int COMPLETED_EVENT_CODE = 4;
    public static final int FAILED_EVENT_CODE = 8;
    public static final int PART_COMPLETED_EVENT_CODE = 2048;
    public static final int PART_FAILED_EVENT_CODE = 4096;
    public static final int PART_STARTED_EVENT_CODE = 1024;
    public static final int PREPARING_EVENT_CODE = 1;
    public static final int RESET_EVENT_CODE = 32;
    public static final int STARTED_EVENT_CODE = 2;
    protected long bytesTransferred;
    protected int eventCode;

    public ProgressEvent(long j12) {
        this.bytesTransferred = j12;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public void setBytesTransferred(long j12) {
        this.bytesTransferred = j12;
    }

    public void setEventCode(int i12) {
        this.eventCode = i12;
    }

    public ProgressEvent(int i12, long j12) {
        this.eventCode = i12;
        this.bytesTransferred = j12;
    }
}
