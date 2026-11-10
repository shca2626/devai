package u2;

import M5.m;
import V5.y;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22784a;

    public d(Context context) {
        m.e(context, "context");
        this.f22784a = context;
    }

    @Override // u2.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        String authority;
        m.e(uri, "data");
        if (!m.a(uri.getScheme(), "android.resource") || (authority = uri.getAuthority()) == null || y.L(authority)) {
            return false;
        }
        List<String> pathSegments = uri.getPathSegments();
        m.d(pathSegments, "data.pathSegments");
        return pathSegments.size() == 2;
    }

    @Override // u2.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Uri b(Uri uri) throws PackageManager.NameNotFoundException {
        m.e(uri, "data");
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        Resources resourcesForApplication = this.f22784a.getPackageManager().getResourcesForApplication(authority);
        m.d(resourcesForApplication, "context.packageManager.g…rApplication(packageName)");
        List<String> pathSegments = uri.getPathSegments();
        m.d(pathSegments, "pathSegments");
        int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        if (!(identifier != 0)) {
            throw new IllegalStateException(m.j("Invalid android.resource URI: ", uri).toString());
        }
        Uri uri2 = Uri.parse("android.resource://" + authority + JsonPointer.SEPARATOR + identifier);
        m.d(uri2, "parse(this)");
        return uri2;
    }
}
