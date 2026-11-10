package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f3080a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f3081b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f3082c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f3083d;

    /* renamed from: androidx.browser.customtabs.a$a, reason: collision with other inner class name */
    public static final class C0046a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f3084a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f3085b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f3086c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f3087d;

        public a a() {
            return new a(this.f3084a, this.f3085b, this.f3086c, this.f3087d);
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f3080a = num;
        this.f3081b = num2;
        this.f3082c = num3;
        this.f3083d = num4;
    }

    Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f3080a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f3081b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f3082c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f3083d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
