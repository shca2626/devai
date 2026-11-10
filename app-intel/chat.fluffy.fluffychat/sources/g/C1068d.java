package g;

import M5.m;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.provider.MediaStore;
import f.C1046j;
import g.AbstractC1065a;
import g.f;
import java.util.List;
import z5.C1881o;

/* renamed from: g.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1068d extends AbstractC1065a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15912b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f15913a;

    /* renamed from: g.d$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final int a() {
            if (f.f15914a.d()) {
                return MediaStore.getPickImagesMaxLimit();
            }
            return Integer.MAX_VALUE;
        }

        public a() {
        }
    }

    public C1068d() {
        this(0, 1, null);
    }

    @Override // g.AbstractC1065a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, C1046j c1046j) {
        f.e eVarD;
        m.e(context, "context");
        m.e(c1046j, "input");
        f.a aVar = f.f15914a;
        if (aVar.d()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.b(c1046j.e()));
            int iMin = Math.min(this.f15913a, c1046j.c());
            if (iMin <= 1 || iMin > MediaStore.getPickImagesMaxLimit()) {
                throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", iMin);
            intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", c1046j.b().a());
            intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", c1046j.g());
            if (c1046j.f()) {
                intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", c1046j.a());
            }
            if (Build.VERSION.SDK_INT >= 33 && (eVarD = c1046j.d()) != null) {
                intent.putExtra("android.provider.extra.MEDIA_CAPABILITIES", eVarD.a());
            }
            return intent;
        }
        if (!aVar.c(context)) {
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(aVar.b(c1046j.e()));
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent2.getType() == null) {
                intent2.setType("*/*");
                intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            return intent2;
        }
        ResolveInfo resolveInfoA = aVar.a(context);
        if (resolveInfoA == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ActivityInfo activityInfo = resolveInfoA.activityInfo;
        Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
        intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
        intent3.setType(aVar.b(c1046j.e()));
        int iMin2 = Math.min(this.f15913a, c1046j.c());
        if (iMin2 <= 1) {
            throw new IllegalArgumentException("Max items must be greater than 1");
        }
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", iMin2);
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", c1046j.b().a());
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", c1046j.g());
        if (c1046j.f()) {
            intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", c1046j.a());
        }
        return intent3;
    }

    @Override // g.AbstractC1065a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC1065a.C0168a b(Context context, C1046j c1046j) {
        m.e(context, "context");
        m.e(c1046j, "input");
        return null;
    }

    @Override // g.AbstractC1065a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List c(int i7, Intent intent) {
        List listA;
        if (i7 != -1) {
            intent = null;
        }
        return (intent == null || (listA = C1066b.f15911a.a(intent)) == null) ? C1881o.i() : listA;
    }

    public C1068d(int i7) {
        this.f15913a = i7;
        if (i7 <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    public /* synthetic */ C1068d(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? f15912b.a() : i7);
    }
}
