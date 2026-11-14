package g;

import M5.m;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import g.AbstractC1066a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import z5.C1884o;

/* renamed from: g.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1067b extends AbstractC1066a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15911a = new a(null);

    /* renamed from: g.b$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final List a(Intent intent) {
            m.e(intent, "<this>");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return C1884o.i();
            }
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i7 = 0; i7 < itemCount; i7++) {
                    Uri uri = clipData.getItemAt(i7).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }

        public a() {
        }
    }

    @Override // g.AbstractC1066a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        m.e(context, "context");
        m.e(str, "input");
        Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        m.d(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @Override // g.AbstractC1066a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC1066a.C0168a b(Context context, String str) {
        m.e(context, "context");
        m.e(str, "input");
        return null;
    }

    @Override // g.AbstractC1066a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List c(int i7, Intent intent) {
        List listA;
        if (i7 != -1) {
            intent = null;
        }
        return (intent == null || (listA = f15911a.a(intent)) == null) ? C1884o.i() : listA;
    }
}
