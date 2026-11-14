package r0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.AbstractC0805j;
import java.util.ArrayList;
import r0.AbstractC1524S;

/* renamed from: r0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1533b implements Parcelable {
    public static final Parcelable.Creator<C1533b> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final int[] f21886l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f21887m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f21888n;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f21889o;

    /* renamed from: p, reason: collision with root package name */
    public final int f21890p;

    /* renamed from: q, reason: collision with root package name */
    public final String f21891q;

    /* renamed from: r, reason: collision with root package name */
    public final int f21892r;

    /* renamed from: s, reason: collision with root package name */
    public final int f21893s;

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence f21894t;

    /* renamed from: u, reason: collision with root package name */
    public final int f21895u;

    /* renamed from: v, reason: collision with root package name */
    public final CharSequence f21896v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f21897w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f21898x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f21899y;

    /* renamed from: r0.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1533b createFromParcel(Parcel parcel) {
            return new C1533b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1533b[] newArray(int i7) {
            return new C1533b[i7];
        }
    }

    public C1533b(C1532a c1532a) {
        int size = c1532a.f21784c.size();
        this.f21886l = new int[size * 6];
        if (!c1532a.f21790i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f21887m = new ArrayList(size);
        this.f21888n = new int[size];
        this.f21889o = new int[size];
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            AbstractC1524S.a aVar = (AbstractC1524S.a) c1532a.f21784c.get(i8);
            int i9 = i7 + 1;
            this.f21886l[i7] = aVar.f21801a;
            ArrayList arrayList = this.f21887m;
            ComponentCallbacksC1548q componentCallbacksC1548q = aVar.f21802b;
            arrayList.add(componentCallbacksC1548q != null ? componentCallbacksC1548q.f22040q : null);
            int[] iArr = this.f21886l;
            iArr[i9] = aVar.f21803c ? 1 : 0;
            iArr[i7 + 2] = aVar.f21804d;
            iArr[i7 + 3] = aVar.f21805e;
            int i10 = i7 + 5;
            iArr[i7 + 4] = aVar.f21806f;
            i7 += 6;
            iArr[i10] = aVar.f21807g;
            this.f21888n[i8] = aVar.f21808h.ordinal();
            this.f21889o[i8] = aVar.f21809i.ordinal();
        }
        this.f21890p = c1532a.f21789h;
        this.f21891q = c1532a.f21792k;
        this.f21892r = c1532a.f21849v;
        this.f21893s = c1532a.f21793l;
        this.f21894t = c1532a.f21794m;
        this.f21895u = c1532a.f21795n;
        this.f21896v = c1532a.f21796o;
        this.f21897w = c1532a.f21797p;
        this.f21898x = c1532a.f21798q;
        this.f21899y = c1532a.f21799r;
    }

    public final void b(C1532a c1532a) {
        int i7 = 0;
        int i8 = 0;
        while (true) {
            boolean z7 = true;
            if (i7 >= this.f21886l.length) {
                c1532a.f21789h = this.f21890p;
                c1532a.f21792k = this.f21891q;
                c1532a.f21790i = true;
                c1532a.f21793l = this.f21893s;
                c1532a.f21794m = this.f21894t;
                c1532a.f21795n = this.f21895u;
                c1532a.f21796o = this.f21896v;
                c1532a.f21797p = this.f21897w;
                c1532a.f21798q = this.f21898x;
                c1532a.f21799r = this.f21899y;
                return;
            }
            AbstractC1524S.a aVar = new AbstractC1524S.a();
            int i9 = i7 + 1;
            aVar.f21801a = this.f21886l[i7];
            if (AbstractC1516J.J0(2)) {
                Log.v("FragmentManager", "Instantiate " + c1532a + " op #" + i8 + " base fragment #" + this.f21886l[i9]);
            }
            aVar.f21808h = AbstractC0805j.b.values()[this.f21888n[i8]];
            aVar.f21809i = AbstractC0805j.b.values()[this.f21889o[i8]];
            int[] iArr = this.f21886l;
            int i10 = i7 + 2;
            if (iArr[i9] == 0) {
                z7 = false;
            }
            aVar.f21803c = z7;
            int i11 = iArr[i10];
            aVar.f21804d = i11;
            int i12 = iArr[i7 + 3];
            aVar.f21805e = i12;
            int i13 = i7 + 5;
            int i14 = iArr[i7 + 4];
            aVar.f21806f = i14;
            i7 += 6;
            int i15 = iArr[i13];
            aVar.f21807g = i15;
            c1532a.f21785d = i11;
            c1532a.f21786e = i12;
            c1532a.f21787f = i14;
            c1532a.f21788g = i15;
            c1532a.e(aVar);
            i8++;
        }
    }

    public C1532a c(AbstractC1516J abstractC1516J) {
        C1532a c1532a = new C1532a(abstractC1516J);
        b(c1532a);
        c1532a.f21849v = this.f21892r;
        for (int i7 = 0; i7 < this.f21887m.size(); i7++) {
            String str = (String) this.f21887m.get(i7);
            if (str != null) {
                ((AbstractC1524S.a) c1532a.f21784c.get(i7)).f21802b = abstractC1516J.g0(str);
            }
        }
        c1532a.q(1);
        return c1532a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeIntArray(this.f21886l);
        parcel.writeStringList(this.f21887m);
        parcel.writeIntArray(this.f21888n);
        parcel.writeIntArray(this.f21889o);
        parcel.writeInt(this.f21890p);
        parcel.writeString(this.f21891q);
        parcel.writeInt(this.f21892r);
        parcel.writeInt(this.f21893s);
        TextUtils.writeToParcel(this.f21894t, parcel, 0);
        parcel.writeInt(this.f21895u);
        TextUtils.writeToParcel(this.f21896v, parcel, 0);
        parcel.writeStringList(this.f21897w);
        parcel.writeStringList(this.f21898x);
        parcel.writeInt(this.f21899y ? 1 : 0);
    }

    public C1533b(Parcel parcel) {
        this.f21886l = parcel.createIntArray();
        this.f21887m = parcel.createStringArrayList();
        this.f21888n = parcel.createIntArray();
        this.f21889o = parcel.createIntArray();
        this.f21890p = parcel.readInt();
        this.f21891q = parcel.readString();
        this.f21892r = parcel.readInt();
        this.f21893s = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f21894t = (CharSequence) creator.createFromParcel(parcel);
        this.f21895u = parcel.readInt();
        this.f21896v = (CharSequence) creator.createFromParcel(parcel);
        this.f21897w = parcel.createStringArrayList();
        this.f21898x = parcel.createStringArrayList();
        this.f21899y = parcel.readInt() != 0;
    }
}
