package v2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class m implements Parcelable {

    /* renamed from: l, reason: collision with root package name */
    public static final a f22947l = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends m {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: m, reason: collision with root package name */
        public final String f22948m;

        /* renamed from: n, reason: collision with root package name */
        public final List f22949n;

        /* renamed from: o, reason: collision with root package name */
        public final y2.h f22950o;

        /* renamed from: p, reason: collision with root package name */
        public final Map f22951p;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b createFromParcel(Parcel parcel) {
                M5.m.e(parcel, "parcel");
                String string = parcel.readString();
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                y2.h hVar = (y2.h) parcel.readParcelable(b.class.getClassLoader());
                int i7 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i7);
                for (int i8 = 0; i8 != i7; i8++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new b(string, arrayListCreateStringArrayList, hVar, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final b[] newArray(int i7) {
                return new b[i7];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, List list, y2.h hVar, Map map) {
            super(null);
            M5.m.e(str, "base");
            M5.m.e(list, "transformations");
            M5.m.e(map, "parameters");
            this.f22948m = str;
            this.f22949n = list;
            this.f22950o = hVar;
            this.f22951p = map;
        }

        public final y2.h b() {
            return this.f22950o;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return M5.m.a(this.f22948m, bVar.f22948m) && M5.m.a(this.f22949n, bVar.f22949n) && M5.m.a(this.f22950o, bVar.f22950o) && M5.m.a(this.f22951p, bVar.f22951p);
        }

        public int hashCode() {
            int iHashCode = ((this.f22948m.hashCode() * 31) + this.f22949n.hashCode()) * 31;
            y2.h hVar = this.f22950o;
            return ((iHashCode + (hVar == null ? 0 : hVar.hashCode())) * 31) + this.f22951p.hashCode();
        }

        public String toString() {
            return "Complex(base=" + this.f22948m + ", transformations=" + this.f22949n + ", size=" + this.f22950o + ", parameters=" + this.f22951p + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            M5.m.e(parcel, "out");
            parcel.writeString(this.f22948m);
            parcel.writeStringList(this.f22949n);
            parcel.writeParcelable(this.f22950o, i7);
            Map map = this.f22951p;
            parcel.writeInt(map.size());
            for (Map.Entry entry : map.entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
    }

    public /* synthetic */ m(M5.g gVar) {
        this();
    }

    public m() {
    }
}
