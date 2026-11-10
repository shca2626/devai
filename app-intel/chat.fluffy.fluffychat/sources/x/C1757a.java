package x;

import android.os.Bundle;

/* renamed from: x.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1757a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f23420a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f23421b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f23422c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f23423d;

    /* renamed from: x.a$a, reason: collision with other inner class name */
    public static final class C0285a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f23424a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f23425b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f23426c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f23427d;

        public C1757a a() {
            return new C1757a(this.f23424a, this.f23425b, this.f23426c, this.f23427d);
        }
    }

    public C1757a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f23420a = num;
        this.f23421b = num2;
        this.f23422c = num3;
        this.f23423d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f23420a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f23421b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f23422c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f23423d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
