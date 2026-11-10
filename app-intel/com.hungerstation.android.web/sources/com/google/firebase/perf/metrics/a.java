package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0470a();

    /* renamed from: b, reason: collision with root package name */
    private final String f24585b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f24586c;

    /* renamed from: com.google.firebase.perf.metrics.a$a, reason: collision with other inner class name */
    class C0470a implements Parcelable.Creator<a> {
        C0470a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i12) {
            return new a[i12];
        }
    }

    /* synthetic */ a(Parcel parcel, C0470a c0470a) {
        this(parcel);
    }

    long a() {
        return this.f24586c.get();
    }

    String b() {
        return this.f24585b;
    }

    public void d(long j12) {
        this.f24586c.addAndGet(j12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void e(long j12) {
        this.f24586c.set(j12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i12) {
        parcel.writeString(this.f24585b);
        parcel.writeLong(this.f24586c.get());
    }

    public a(String str) {
        this.f24585b = str;
        this.f24586c = new AtomicLong(0L);
    }

    private a(Parcel parcel) {
        this.f24585b = parcel.readString();
        this.f24586c = new AtomicLong(parcel.readLong());
    }
}
