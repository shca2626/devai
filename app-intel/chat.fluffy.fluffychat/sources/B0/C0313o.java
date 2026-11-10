package B0;

import E0.U;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* renamed from: B0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0313o implements Comparator, Parcelable {
    public static final Parcelable.Creator<C0313o> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final b[] f678l;

    /* renamed from: m, reason: collision with root package name */
    public int f679m;

    /* renamed from: n, reason: collision with root package name */
    public final String f680n;

    /* renamed from: o, reason: collision with root package name */
    public final int f681o;

    /* renamed from: B0.o$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0313o createFromParcel(Parcel parcel) {
            return new C0313o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0313o[] newArray(int i7) {
            return new C0313o[i7];
        }
    }

    /* renamed from: B0.o$b */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: l, reason: collision with root package name */
        public int f682l;

        /* renamed from: m, reason: collision with root package name */
        public final UUID f683m;

        /* renamed from: n, reason: collision with root package name */
        public final String f684n;

        /* renamed from: o, reason: collision with root package name */
        public final String f685o;

        /* renamed from: p, reason: collision with root package name */
        public final byte[] f686p;

        /* renamed from: B0.o$b$a */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i7) {
                return new b[i7];
            }
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public boolean b(b bVar) {
            return e() && !bVar.e() && f(bVar.f683m);
        }

        public b c(byte[] bArr) {
            return new b(this.f683m, this.f684n, this.f685o, bArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return this.f686p != null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f684n, bVar.f684n) && Objects.equals(this.f685o, bVar.f685o) && Objects.equals(this.f683m, bVar.f683m) && Arrays.equals(this.f686p, bVar.f686p);
        }

        public boolean f(UUID uuid) {
            return AbstractC0307i.f638a.equals(this.f683m) || uuid.equals(this.f683m);
        }

        public int hashCode() {
            if (this.f682l == 0) {
                int iHashCode = this.f683m.hashCode() * 31;
                String str = this.f684n;
                this.f682l = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f685o.hashCode()) * 31) + Arrays.hashCode(this.f686p);
            }
            return this.f682l;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeLong(this.f683m.getMostSignificantBits());
            parcel.writeLong(this.f683m.getLeastSignificantBits());
            parcel.writeString(this.f684n);
            parcel.writeString(this.f685o);
            parcel.writeByteArray(this.f686p);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.f683m = (UUID) j3.o.q(uuid);
            this.f684n = str;
            this.f685o = z.u((String) j3.o.q(str2));
            this.f686p = bArr;
        }

        public b(Parcel parcel) {
            this.f683m = new UUID(parcel.readLong(), parcel.readLong());
            this.f684n = parcel.readString();
            this.f685o = (String) U.i(parcel.readString());
            this.f686p = parcel.createByteArray();
        }
    }

    public C0313o(List list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    public static boolean c(ArrayList arrayList, int i7, UUID uuid) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (((b) arrayList.get(i8)).f683m.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static C0313o f(C0313o c0313o, C0313o c0313o2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (c0313o != null) {
            str = c0313o.f680n;
            for (b bVar : c0313o.f678l) {
                if (bVar.e()) {
                    arrayList.add(bVar);
                }
            }
        } else {
            str = null;
        }
        if (c0313o2 != null) {
            if (str == null) {
                str = c0313o2.f680n;
            }
            int size = arrayList.size();
            for (b bVar2 : c0313o2.f678l) {
                if (bVar2.e() && !c(arrayList, size, bVar2.f683m)) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C0313o(str, arrayList);
    }

    @Override // java.util.Comparator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = AbstractC0307i.f638a;
        return uuid.equals(bVar.f683m) ? uuid.equals(bVar2.f683m) ? 0 : 1 : bVar.f683m.compareTo(bVar2.f683m);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public C0313o e(String str) {
        return Objects.equals(this.f680n, str) ? this : new C0313o(str, false, this.f678l);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0313o.class == obj.getClass()) {
            C0313o c0313o = (C0313o) obj;
            if (Objects.equals(this.f680n, c0313o.f680n) && Arrays.equals(this.f678l, c0313o.f678l)) {
                return true;
            }
        }
        return false;
    }

    public b g(int i7) {
        return this.f678l[i7];
    }

    public C0313o h(C0313o c0313o) {
        String str;
        String str2 = this.f680n;
        j3.o.v(str2 == null || (str = c0313o.f680n) == null || TextUtils.equals(str2, str));
        String str3 = this.f680n;
        if (str3 == null) {
            str3 = c0313o.f680n;
        }
        return new C0313o(str3, (b[]) U.U0(this.f678l, c0313o.f678l));
    }

    public int hashCode() {
        if (this.f679m == 0) {
            String str = this.f680n;
            this.f679m = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f678l);
        }
        return this.f679m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f680n);
        parcel.writeTypedArray(this.f678l, 0);
    }

    public C0313o(String str, List list) {
        this(str, false, (b[]) list.toArray(new b[0]));
    }

    public C0313o(b... bVarArr) {
        this((String) null, bVarArr);
    }

    public C0313o(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public C0313o(String str, boolean z7, b... bVarArr) {
        this.f680n = str;
        bVarArr = z7 ? (b[]) bVarArr.clone() : bVarArr;
        this.f678l = bVarArr;
        this.f681o = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public C0313o(Parcel parcel) {
        this.f680n = parcel.readString();
        b[] bVarArr = (b[]) U.i((b[]) parcel.createTypedArray(b.CREATOR));
        this.f678l = bVarArr;
        this.f681o = bVarArr.length;
    }
}
