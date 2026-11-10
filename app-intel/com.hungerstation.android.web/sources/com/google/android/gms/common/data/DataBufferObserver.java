package com.google.android.gms.common.data;

/* loaded from: classes8.dex */
public interface DataBufferObserver {

    public interface Observable {
        void addObserver(DataBufferObserver dataBufferObserver);

        void removeObserver(DataBufferObserver dataBufferObserver);
    }

    void onDataChanged();

    void onDataRangeChanged(int i12, int i13);

    void onDataRangeInserted(int i12, int i13);

    void onDataRangeMoved(int i12, int i13, int i14);

    void onDataRangeRemoved(int i12, int i13);
}
