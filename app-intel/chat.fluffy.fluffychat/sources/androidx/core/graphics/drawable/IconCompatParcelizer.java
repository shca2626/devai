package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import b2.AbstractC0839a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC0839a abstractC0839a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f11895a = abstractC0839a.p(iconCompat.f11895a, 1);
        iconCompat.f11897c = abstractC0839a.j(iconCompat.f11897c, 2);
        iconCompat.f11898d = abstractC0839a.r(iconCompat.f11898d, 3);
        iconCompat.f11899e = abstractC0839a.p(iconCompat.f11899e, 4);
        iconCompat.f11900f = abstractC0839a.p(iconCompat.f11900f, 5);
        iconCompat.f11901g = (ColorStateList) abstractC0839a.r(iconCompat.f11901g, 6);
        iconCompat.f11903i = abstractC0839a.t(iconCompat.f11903i, 7);
        iconCompat.f11904j = abstractC0839a.t(iconCompat.f11904j, 8);
        iconCompat.w();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC0839a abstractC0839a) {
        abstractC0839a.x(true, true);
        iconCompat.x(abstractC0839a.f());
        int i7 = iconCompat.f11895a;
        if (-1 != i7) {
            abstractC0839a.F(i7, 1);
        }
        byte[] bArr = iconCompat.f11897c;
        if (bArr != null) {
            abstractC0839a.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f11898d;
        if (parcelable != null) {
            abstractC0839a.H(parcelable, 3);
        }
        int i8 = iconCompat.f11899e;
        if (i8 != 0) {
            abstractC0839a.F(i8, 4);
        }
        int i9 = iconCompat.f11900f;
        if (i9 != 0) {
            abstractC0839a.F(i9, 5);
        }
        ColorStateList colorStateList = iconCompat.f11901g;
        if (colorStateList != null) {
            abstractC0839a.H(colorStateList, 6);
        }
        String str = iconCompat.f11903i;
        if (str != null) {
            abstractC0839a.J(str, 7);
        }
        String str2 = iconCompat.f11904j;
        if (str2 != null) {
            abstractC0839a.J(str2, 8);
        }
    }
}
