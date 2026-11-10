package w;

import android.os.Bundle;

/* renamed from: w.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1722a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f23238a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f23239b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f23240c;

    /* renamed from: w.a$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Integer f23241a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f23242b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f23243c;

        public C1722a a() {
            return new C1722a(this.f23241a, this.f23242b, this.f23243c);
        }
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f23238a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f23239b;
        if (num2 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f23240c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num3.intValue());
        }
        return bundle;
    }

    public C1722a(Integer num, Integer num2, Integer num3) {
        this.f23238a = num;
        this.f23239b = num2;
        this.f23240c = num3;
    }
}
