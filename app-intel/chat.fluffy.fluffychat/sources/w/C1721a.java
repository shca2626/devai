package w;

import android.os.Bundle;

/* renamed from: w.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1721a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f23244a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f23245b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f23246c;

    /* renamed from: w.a$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Integer f23247a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f23248b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f23249c;

        public C1721a a() {
            return new C1721a(this.f23247a, this.f23248b, this.f23249c);
        }
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f23244a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f23245b;
        if (num2 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f23246c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num3.intValue());
        }
        return bundle;
    }

    public C1721a(Integer num, Integer num2, Integer num3) {
        this.f23244a = num;
        this.f23245b = num2;
        this.f23246c = num3;
    }
}
