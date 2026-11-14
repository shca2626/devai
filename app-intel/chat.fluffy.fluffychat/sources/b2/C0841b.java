package b2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import y.C1786a;

/* renamed from: b2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0841b extends AbstractC0840a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f13711d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f13712e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13713f;

    /* renamed from: g, reason: collision with root package name */
    public final int f13714g;

    /* renamed from: h, reason: collision with root package name */
    public final String f13715h;

    /* renamed from: i, reason: collision with root package name */
    public int f13716i;

    /* renamed from: j, reason: collision with root package name */
    public int f13717j;

    /* renamed from: k, reason: collision with root package name */
    public int f13718k;

    public C0841b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C1786a(), new C1786a(), new C1786a());
    }

    @Override // b2.AbstractC0840a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f13712e.writeInt(-1);
        } else {
            this.f13712e.writeInt(bArr.length);
            this.f13712e.writeByteArray(bArr);
        }
    }

    @Override // b2.AbstractC0840a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f13712e, 0);
    }

    @Override // b2.AbstractC0840a
    public void E(int i7) {
        this.f13712e.writeInt(i7);
    }

    @Override // b2.AbstractC0840a
    public void G(Parcelable parcelable) {
        this.f13712e.writeParcelable(parcelable, 0);
    }

    @Override // b2.AbstractC0840a
    public void I(String str) {
        this.f13712e.writeString(str);
    }

    @Override // b2.AbstractC0840a
    public void a() {
        int i7 = this.f13716i;
        if (i7 >= 0) {
            int i8 = this.f13711d.get(i7);
            int iDataPosition = this.f13712e.dataPosition();
            this.f13712e.setDataPosition(i8);
            this.f13712e.writeInt(iDataPosition - i8);
            this.f13712e.setDataPosition(iDataPosition);
        }
    }

    @Override // b2.AbstractC0840a
    public AbstractC0840a b() {
        Parcel parcel = this.f13712e;
        int iDataPosition = parcel.dataPosition();
        int i7 = this.f13717j;
        if (i7 == this.f13713f) {
            i7 = this.f13714g;
        }
        return new C0841b(parcel, iDataPosition, i7, this.f13715h + "  ", this.f13708a, this.f13709b, this.f13710c);
    }

    @Override // b2.AbstractC0840a
    public boolean g() {
        return this.f13712e.readInt() != 0;
    }

    @Override // b2.AbstractC0840a
    public byte[] i() {
        int i7 = this.f13712e.readInt();
        if (i7 < 0) {
            return null;
        }
        byte[] bArr = new byte[i7];
        this.f13712e.readByteArray(bArr);
        return bArr;
    }

    @Override // b2.AbstractC0840a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f13712e);
    }

    @Override // b2.AbstractC0840a
    public boolean m(int i7) {
        while (this.f13717j < this.f13714g) {
            int i8 = this.f13718k;
            if (i8 == i7) {
                return true;
            }
            if (String.valueOf(i8).compareTo(String.valueOf(i7)) > 0) {
                return false;
            }
            this.f13712e.setDataPosition(this.f13717j);
            int i9 = this.f13712e.readInt();
            this.f13718k = this.f13712e.readInt();
            this.f13717j += i9;
        }
        return this.f13718k == i7;
    }

    @Override // b2.AbstractC0840a
    public int o() {
        return this.f13712e.readInt();
    }

    @Override // b2.AbstractC0840a
    public Parcelable q() {
        return this.f13712e.readParcelable(getClass().getClassLoader());
    }

    @Override // b2.AbstractC0840a
    public String s() {
        return this.f13712e.readString();
    }

    @Override // b2.AbstractC0840a
    public void w(int i7) {
        a();
        this.f13716i = i7;
        this.f13711d.put(i7, this.f13712e.dataPosition());
        E(0);
        E(i7);
    }

    @Override // b2.AbstractC0840a
    public void y(boolean z7) {
        this.f13712e.writeInt(z7 ? 1 : 0);
    }

    public C0841b(Parcel parcel, int i7, int i8, String str, C1786a c1786a, C1786a c1786a2, C1786a c1786a3) {
        super(c1786a, c1786a2, c1786a3);
        this.f13711d = new SparseIntArray();
        this.f13716i = -1;
        this.f13718k = -1;
        this.f13712e = parcel;
        this.f13713f = i7;
        this.f13714g = i8;
        this.f13717j = i7;
        this.f13715h = str;
    }
}
