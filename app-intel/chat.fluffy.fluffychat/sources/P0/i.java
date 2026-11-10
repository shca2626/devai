package P0;

import B0.G;
import B0.s;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: n, reason: collision with root package name */
    public static final i f7434n;

    /* renamed from: d, reason: collision with root package name */
    public final List f7435d;

    /* renamed from: e, reason: collision with root package name */
    public final List f7436e;

    /* renamed from: f, reason: collision with root package name */
    public final List f7437f;

    /* renamed from: g, reason: collision with root package name */
    public final List f7438g;

    /* renamed from: h, reason: collision with root package name */
    public final List f7439h;

    /* renamed from: i, reason: collision with root package name */
    public final List f7440i;

    /* renamed from: j, reason: collision with root package name */
    public final s f7441j;

    /* renamed from: k, reason: collision with root package name */
    public final List f7442k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f7443l;

    /* renamed from: m, reason: collision with root package name */
    public final List f7444m;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7445a;

        /* renamed from: b, reason: collision with root package name */
        public final s f7446b;

        /* renamed from: c, reason: collision with root package name */
        public final String f7447c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7448d;

        public a(Uri uri, s sVar, String str, String str2) {
            this.f7445a = uri;
            this.f7446b = sVar;
            this.f7447c = str;
            this.f7448d = str2;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7449a;

        /* renamed from: b, reason: collision with root package name */
        public final s f7450b;

        /* renamed from: c, reason: collision with root package name */
        public final String f7451c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7452d;

        /* renamed from: e, reason: collision with root package name */
        public final String f7453e;

        /* renamed from: f, reason: collision with root package name */
        public final String f7454f;

        public b(Uri uri, s sVar, String str, String str2, String str3, String str4) {
            this.f7449a = uri;
            this.f7450b = sVar;
            this.f7451c = str;
            this.f7452d = str2;
            this.f7453e = str3;
            this.f7454f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new s.b().j0("0").W("application/x-mpegURL").P(), null, null, null, null);
        }

        public b a(s sVar) {
            return new b(this.f7449a, sVar, this.f7451c, this.f7452d, this.f7453e, this.f7454f);
        }
    }

    static {
        List list = Collections.EMPTY_LIST;
        f7434n = new i("", list, list, list, list, list, list, null, list, false, Collections.EMPTY_MAP, list);
    }

    public i(String str, List list, List list2, List list3, List list4, List list5, List list6, s sVar, List list7, boolean z7, Map map, List list8) {
        super(str, list, z7);
        this.f7435d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f7436e = Collections.unmodifiableList(list2);
        this.f7437f = Collections.unmodifiableList(list3);
        this.f7438g = Collections.unmodifiableList(list4);
        this.f7439h = Collections.unmodifiableList(list5);
        this.f7440i = Collections.unmodifiableList(list6);
        this.f7441j = sVar;
        this.f7442k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f7443l = Collections.unmodifiableMap(map);
        this.f7444m = Collections.unmodifiableList(list8);
    }

    public static void b(List list, List list2) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            Uri uri = ((a) list.get(i7)).f7445a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static List d(List list, int i7, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i8 = 0; i8 < list.size(); i8++) {
            Object obj = list.get(i8);
            int i9 = 0;
            while (true) {
                if (i9 < list2.size()) {
                    G g7 = (G) list2.get(i9);
                    if (g7.f373m == i7 && g7.f374n == i8) {
                        arrayList.add(obj);
                        break;
                    }
                    i9++;
                }
            }
        }
        return arrayList;
    }

    public static i e(String str) {
        List listSingletonList = Collections.singletonList(b.b(Uri.parse(str)));
        List list = Collections.EMPTY_LIST;
        return new i("", list, listSingletonList, list, list, list, list, null, null, false, Collections.EMPTY_MAP, list);
    }

    public static List f(List list, List list2, List list3, List list4, List list5) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < list.size(); i7++) {
            Uri uri = ((b) list.get(i7)).f7449a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    @Override // T0.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i a(List list) {
        String str = this.f7455a;
        List list2 = this.f7456b;
        List listD = d(this.f7436e, 0, list);
        List list3 = Collections.EMPTY_LIST;
        return new i(str, list2, listD, list3, d(this.f7438g, 1, list), d(this.f7439h, 2, list), list3, this.f7441j, this.f7442k, this.f7457c, this.f7443l, this.f7444m);
    }
}
