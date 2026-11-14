package x;

import android.os.Bundle;

/* renamed from: x.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1756a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f23426a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f23427b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f23428c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f23429d;

    /* renamed from: x.a$a, reason: collision with other inner class name */
    public static final class C0285a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f23430a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f23431b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f23432c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f23433d;

        public C1756a a() {
            return new C1756a(this.f23430a, this.f23431b, this.f23432c, this.f23433d);
        }
    }

    public C1756a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f23426a = num;
        this.f23427b = num2;
        this.f23428c = num3;
        this.f23429d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f23426a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f23427b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f23428c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f23429d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
