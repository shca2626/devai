package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public final class k implements Comparable, Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final Calendar f14551l;

    /* renamed from: m, reason: collision with root package name */
    public final int f14552m;

    /* renamed from: n, reason: collision with root package name */
    public final int f14553n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14554o;

    /* renamed from: p, reason: collision with root package name */
    public final int f14555p;

    /* renamed from: q, reason: collision with root package name */
    public final long f14556q;

    /* renamed from: r, reason: collision with root package name */
    public String f14557r;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return k.f(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i7) {
            return new k[i7];
        }
    }

    public k(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = r.d(calendar);
        this.f14551l = calendarD;
        this.f14552m = calendarD.get(2);
        this.f14553n = calendarD.get(1);
        this.f14554o = calendarD.getMaximum(7);
        this.f14555p = calendarD.getActualMaximum(5);
        this.f14556q = calendarD.getTimeInMillis();
    }

    public static k f(int i7, int i8) {
        Calendar calendarI = r.i();
        calendarI.set(1, i7);
        calendarI.set(2, i8);
        return new k(calendarI);
    }

    public static k h(long j7) {
        Calendar calendarI = r.i();
        calendarI.setTimeInMillis(j7);
        return new k(calendarI);
    }

    public static k i() {
        return new k(r.g());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return this.f14551l.compareTo(kVar.f14551l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f14552m == kVar.f14552m && this.f14553n == kVar.f14553n;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f14552m), Integer.valueOf(this.f14553n)});
    }

    public int j(int i7) {
        int i8 = this.f14551l.get(7);
        if (i7 <= 0) {
            i7 = this.f14551l.getFirstDayOfWeek();
        }
        int i9 = i8 - i7;
        return i9 < 0 ? i9 + this.f14554o : i9;
    }

    public long k(int i7) {
        Calendar calendarD = r.d(this.f14551l);
        calendarD.set(5, i7);
        return calendarD.getTimeInMillis();
    }

    public int l(long j7) {
        Calendar calendarD = r.d(this.f14551l);
        calendarD.setTimeInMillis(j7);
        return calendarD.get(5);
    }

    public String m() {
        if (this.f14557r == null) {
            this.f14557r = e.c(this.f14551l.getTimeInMillis());
        }
        return this.f14557r;
    }

    public long n() {
        return this.f14551l.getTimeInMillis();
    }

    public k o(int i7) {
        Calendar calendarD = r.d(this.f14551l);
        calendarD.add(2, i7);
        return new k(calendarD);
    }

    public int p(k kVar) {
        if (this.f14551l instanceof GregorianCalendar) {
            return ((kVar.f14553n - this.f14553n) * 12) + (kVar.f14552m - this.f14552m);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f14553n);
        parcel.writeInt(this.f14552m);
    }
}
