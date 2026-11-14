package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import b2.AbstractC0840a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC0840a abstractC0840a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f11895a = abstractC0840a.p(iconCompat.f11895a, 1);
        iconCompat.f11897c = abstractC0840a.j(iconCompat.f11897c, 2);
        iconCompat.f11898d = abstractC0840a.r(iconCompat.f11898d, 3);
        iconCompat.f11899e = abstractC0840a.p(iconCompat.f11899e, 4);
        iconCompat.f11900f = abstractC0840a.p(iconCompat.f11900f, 5);
        iconCompat.f11901g = (ColorStateList) abstractC0840a.r(iconCompat.f11901g, 6);
        iconCompat.f11903i = abstractC0840a.t(iconCompat.f11903i, 7);
        iconCompat.f11904j = abstractC0840a.t(iconCompat.f11904j, 8);
        iconCompat.w();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC0840a abstractC0840a) {
        abstractC0840a.x(true, true);
        iconCompat.x(abstractC0840a.f());
        int i7 = iconCompat.f11895a;
        if (-1 != i7) {
            abstractC0840a.F(i7, 1);
        }
        byte[] bArr = iconCompat.f11897c;
        if (bArr != null) {
            abstractC0840a.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f11898d;
        if (parcelable != null) {
            abstractC0840a.H(parcelable, 3);
        }
        int i8 = iconCompat.f11899e;
        if (i8 != 0) {
            abstractC0840a.F(i8, 4);
        }
        int i9 = iconCompat.f11900f;
        if (i9 != 0) {
            abstractC0840a.F(i9, 5);
        }
        ColorStateList colorStateList = iconCompat.f11901g;
        if (colorStateList != null) {
            abstractC0840a.H(colorStateList, 6);
        }
        String str = iconCompat.f11903i;
        if (str != null) {
            abstractC0840a.J(str, 7);
        }
        String str2 = iconCompat.f11904j;
        if (str2 != null) {
            abstractC0840a.J(str2, 8);
        }
    }
}
