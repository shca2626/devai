package r0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.AbstractC0804j;
import java.util.ArrayList;
import r0.AbstractC1525S;

/* renamed from: r0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1534b implements Parcelable {
    public static final Parcelable.Creator<C1534b> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final int[] f21880l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f21881m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f21882n;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f21883o;

    /* renamed from: p, reason: collision with root package name */
    public final int f21884p;

    /* renamed from: q, reason: collision with root package name */
    public final String f21885q;

    /* renamed from: r, reason: collision with root package name */
    public final int f21886r;

    /* renamed from: s, reason: collision with root package name */
    public final int f21887s;

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence f21888t;

    /* renamed from: u, reason: collision with root package name */
    public final int f21889u;

    /* renamed from: v, reason: collision with root package name */
    public final CharSequence f21890v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f21891w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f21892x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f21893y;

    /* renamed from: r0.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1534b createFromParcel(Parcel parcel) {
            return new C1534b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1534b[] newArray(int i7) {
            return new C1534b[i7];
        }
    }

    public C1534b(C1533a c1533a) {
        int size = c1533a.f21778c.size();
        this.f21880l = new int[size * 6];
        if (!c1533a.f21784i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f21881m = new ArrayList(size);
        this.f21882n = new int[size];
        this.f21883o = new int[size];
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            AbstractC1525S.a aVar = (AbstractC1525S.a) c1533a.f21778c.get(i8);
            int i9 = i7 + 1;
            this.f21880l[i7] = aVar.f21795a;
            ArrayList arrayList = this.f21881m;
            ComponentCallbacksC1549q componentCallbacksC1549q = aVar.f21796b;
            arrayList.add(componentCallbacksC1549q != null ? componentCallbacksC1549q.f22034q : null);
            int[] iArr = this.f21880l;
            iArr[i9] = aVar.f21797c ? 1 : 0;
            iArr[i7 + 2] = aVar.f21798d;
            iArr[i7 + 3] = aVar.f21799e;
            int i10 = i7 + 5;
            iArr[i7 + 4] = aVar.f21800f;
            i7 += 6;
            iArr[i10] = aVar.f21801g;
            this.f21882n[i8] = aVar.f21802h.ordinal();
            this.f21883o[i8] = aVar.f21803i.ordinal();
        }
        this.f21884p = c1533a.f21783h;
        this.f21885q = c1533a.f21786k;
        this.f21886r = c1533a.f21843v;
        this.f21887s = c1533a.f21787l;
        this.f21888t = c1533a.f21788m;
        this.f21889u = c1533a.f21789n;
        this.f21890v = c1533a.f21790o;
        this.f21891w = c1533a.f21791p;
        this.f21892x = c1533a.f21792q;
        this.f21893y = c1533a.f21793r;
    }

    public final void b(C1533a c1533a) {
        int i7 = 0;
        int i8 = 0;
        while (true) {
            boolean z7 = true;
            if (i7 >= this.f21880l.length) {
                c1533a.f21783h = this.f21884p;
                c1533a.f21786k = this.f21885q;
                c1533a.f21784i = true;
                c1533a.f21787l = this.f21887s;
                c1533a.f21788m = this.f21888t;
                c1533a.f21789n = this.f21889u;
                c1533a.f21790o = this.f21890v;
                c1533a.f21791p = this.f21891w;
                c1533a.f21792q = this.f21892x;
                c1533a.f21793r = this.f21893y;
                return;
            }
            AbstractC1525S.a aVar = new AbstractC1525S.a();
            int i9 = i7 + 1;
            aVar.f21795a = this.f21880l[i7];
            if (AbstractC1517J.J0(2)) {
                Log.v("FragmentManager", "Instantiate " + c1533a + " op #" + i8 + " base fragment #" + this.f21880l[i9]);
            }
            aVar.f21802h = AbstractC0804j.b.values()[this.f21882n[i8]];
            aVar.f21803i = AbstractC0804j.b.values()[this.f21883o[i8]];
            int[] iArr = this.f21880l;
            int i10 = i7 + 2;
            if (iArr[i9] == 0) {
                z7 = false;
            }
            aVar.f21797c = z7;
            int i11 = iArr[i10];
            aVar.f21798d = i11;
            int i12 = iArr[i7 + 3];
            aVar.f21799e = i12;
            int i13 = i7 + 5;
            int i14 = iArr[i7 + 4];
            aVar.f21800f = i14;
            i7 += 6;
            int i15 = iArr[i13];
            aVar.f21801g = i15;
            c1533a.f21779d = i11;
            c1533a.f21780e = i12;
            c1533a.f21781f = i14;
            c1533a.f21782g = i15;
            c1533a.e(aVar);
            i8++;
        }
    }

    public C1533a c(AbstractC1517J abstractC1517J) {
        C1533a c1533a = new C1533a(abstractC1517J);
        b(c1533a);
        c1533a.f21843v = this.f21886r;
        for (int i7 = 0; i7 < this.f21881m.size(); i7++) {
            String str = (String) this.f21881m.get(i7);
            if (str != null) {
                ((AbstractC1525S.a) c1533a.f21778c.get(i7)).f21796b = abstractC1517J.g0(str);
            }
        }
        c1533a.q(1);
        return c1533a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeIntArray(this.f21880l);
        parcel.writeStringList(this.f21881m);
        parcel.writeIntArray(this.f21882n);
        parcel.writeIntArray(this.f21883o);
        parcel.writeInt(this.f21884p);
        parcel.writeString(this.f21885q);
        parcel.writeInt(this.f21886r);
        parcel.writeInt(this.f21887s);
        TextUtils.writeToParcel(this.f21888t, parcel, 0);
        parcel.writeInt(this.f21889u);
        TextUtils.writeToParcel(this.f21890v, parcel, 0);
        parcel.writeStringList(this.f21891w);
        parcel.writeStringList(this.f21892x);
        parcel.writeInt(this.f21893y ? 1 : 0);
    }

    public C1534b(Parcel parcel) {
        this.f21880l = parcel.createIntArray();
        this.f21881m = parcel.createStringArrayList();
        this.f21882n = parcel.createIntArray();
        this.f21883o = parcel.createIntArray();
        this.f21884p = parcel.readInt();
        this.f21885q = parcel.readString();
        this.f21886r = parcel.readInt();
        this.f21887s = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f21888t = (CharSequence) creator.createFromParcel(parcel);
        this.f21889u = parcel.readInt();
        this.f21890v = (CharSequence) creator.createFromParcel(parcel);
        this.f21891w = parcel.createStringArrayList();
        this.f21892x = parcel.createStringArrayList();
        this.f21893y = parcel.readInt() != 0;
    }
}
