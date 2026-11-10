package g;

import M5.m;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.media.ApplicationMediaCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import f.C1046j;
import g.AbstractC1065a;
import java.util.Iterator;
import java.util.Set;
import y5.C1811f;
import z5.C1865I;
import z5.C1889w;

/* loaded from: classes.dex */
public class f extends AbstractC1065a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15914a = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final ResolveInfo a(Context context) {
            m.e(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String b(g gVar) {
            m.e(gVar, "input");
            if (gVar instanceof d) {
                return "image/*";
            }
            if (gVar instanceof C0169f) {
                return "video/*";
            }
            if (gVar instanceof c) {
                return null;
            }
            throw new C1811f();
        }

        public final boolean c(Context context) {
            m.e(context, "context");
            return a(context) != null;
        }

        public final boolean d() {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 33) {
                return true;
            }
            return i7 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15915a = new a();

            /* renamed from: b, reason: collision with root package name */
            public static final int f15916b = 1;

            public a() {
                super(null);
            }

            @Override // g.f.b
            public int a() {
                return f15916b;
            }
        }

        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public abstract int a();

        public b() {
        }
    }

    public static final class c implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final c f15917a = new c();
    }

    public static final class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final d f15918a = new d();
    }

    public static final class e {

        /* renamed from: b, reason: collision with root package name */
        public static final a f15919b = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public Set f15920a = C1865I.d();

        public static final class a {
            public /* synthetic */ a(M5.g gVar) {
                this();
            }

            public a() {
            }
        }

        public final ApplicationMediaCapabilities a() {
            ApplicationMediaCapabilities.Builder builderA = g.g.a();
            builderA.addSupportedVideoMimeType("video/hevc");
            Iterator it = this.f15920a.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue == 0) {
                    builderA.addSupportedHdrType("android.media.feature.hdr.hlg");
                } else if (iIntValue == 1) {
                    builderA.addSupportedHdrType("android.media.feature.hdr.hdr10");
                } else if (iIntValue == 2) {
                    builderA.addSupportedHdrType("android.media.feature.hdr.hdr10_plus");
                } else if (iIntValue == 3) {
                    builderA.addSupportedHdrType("android.media.feature.hdr.dolby_vision");
                }
            }
            ApplicationMediaCapabilities applicationMediaCapabilitiesBuild = builderA.build();
            m.d(applicationMediaCapabilitiesBuild, "build(...)");
            return applicationMediaCapabilitiesBuild;
        }
    }

    /* renamed from: g.f$f, reason: collision with other inner class name */
    public static final class C0169f implements g {

        /* renamed from: a, reason: collision with root package name */
        public static final C0169f f15921a = new C0169f();
    }

    public interface g {
    }

    @Override // g.AbstractC1065a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, C1046j c1046j) {
        e eVarD;
        m.e(context, "context");
        m.e(c1046j, "input");
        a aVar = f15914a;
        if (aVar.d()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.b(c1046j.e()));
            intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", c1046j.b().a());
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
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", c1046j.b().a());
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
    public final Uri c(int i7, Intent intent) {
        if (i7 != -1) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        return data == null ? (Uri) C1889w.G(C1066b.f15911a.a(intent)) : data;
    }
}
