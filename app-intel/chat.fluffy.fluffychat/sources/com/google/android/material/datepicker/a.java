package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0143a();

    /* renamed from: l, reason: collision with root package name */
    public final k f14451l;

    /* renamed from: m, reason: collision with root package name */
    public final k f14452m;

    /* renamed from: n, reason: collision with root package name */
    public final c f14453n;

    /* renamed from: o, reason: collision with root package name */
    public k f14454o;

    /* renamed from: p, reason: collision with root package name */
    public final int f14455p;

    /* renamed from: q, reason: collision with root package name */
    public final int f14456q;

    /* renamed from: r, reason: collision with root package name */
    public final int f14457r;

    /* renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    public class C0143a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((k) parcel.readParcelable(k.class.getClassLoader()), (k) parcel.readParcelable(k.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (k) parcel.readParcelable(k.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i7) {
            return new a[i7];
        }
    }

    public interface c extends Parcelable {
        boolean a(long j7);
    }

    public /* synthetic */ a(k kVar, k kVar2, c cVar, k kVar3, int i7, C0143a c0143a) {
        this(kVar, kVar2, cVar, kVar3, i7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14451l.equals(aVar.f14451l) && this.f14452m.equals(aVar.f14452m) && Y.c.a(this.f14454o, aVar.f14454o) && this.f14455p == aVar.f14455p && this.f14453n.equals(aVar.f14453n);
    }

    public c h() {
        return this.f14453n;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14451l, this.f14452m, this.f14454o, Integer.valueOf(this.f14455p), this.f14453n});
    }

    public k i() {
        return this.f14452m;
    }

    public int j() {
        return this.f14455p;
    }

    public int k() {
        return this.f14457r;
    }

    public k l() {
        return this.f14454o;
    }

    public k m() {
        return this.f14451l;
    }

    public int n() {
        return this.f14456q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f14451l, 0);
        parcel.writeParcelable(this.f14452m, 0);
        parcel.writeParcelable(this.f14454o, 0);
        parcel.writeParcelable(this.f14453n, 0);
        parcel.writeInt(this.f14455p);
    }

    public a(k kVar, k kVar2, c cVar, k kVar3, int i7) {
        this.f14451l = kVar;
        this.f14452m = kVar2;
        this.f14454o = kVar3;
        this.f14455p = i7;
        this.f14453n = cVar;
        if (kVar3 != null && kVar.compareTo(kVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (kVar3 != null && kVar3.compareTo(kVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i7 < 0 || i7 > r.i().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f14457r = kVar.p(kVar2) + 1;
        this.f14456q = (kVar2.f14553n - kVar.f14553n) + 1;
    }

    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        public static final long f14458f = r.a(k.f(1900, 0).f14556q);

        /* renamed from: g, reason: collision with root package name */
        public static final long f14459g = r.a(k.f(2100, 11).f14556q);

        /* renamed from: a, reason: collision with root package name */
        public long f14460a;

        /* renamed from: b, reason: collision with root package name */
        public long f14461b;

        /* renamed from: c, reason: collision with root package name */
        public Long f14462c;

        /* renamed from: d, reason: collision with root package name */
        public int f14463d;

        /* renamed from: e, reason: collision with root package name */
        public c f14464e;

        public b() {
            this.f14460a = f14458f;
            this.f14461b = f14459g;
            this.f14464e = f.b(Long.MIN_VALUE);
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f14464e);
            k kVarH = k.h(this.f14460a);
            k kVarH2 = k.h(this.f14461b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l7 = this.f14462c;
            return new a(kVarH, kVarH2, cVar, l7 == null ? null : k.h(l7.longValue()), this.f14463d, null);
        }

        public b b(long j7) {
            this.f14462c = Long.valueOf(j7);
            return this;
        }

        public b(a aVar) {
            this.f14460a = f14458f;
            this.f14461b = f14459g;
            this.f14464e = f.b(Long.MIN_VALUE);
            this.f14460a = aVar.f14451l.f14556q;
            this.f14461b = aVar.f14452m.f14556q;
            this.f14462c = Long.valueOf(aVar.f14454o.f14556q);
            this.f14463d = aVar.f14455p;
            this.f14464e = aVar.f14453n;
        }
    }
}
