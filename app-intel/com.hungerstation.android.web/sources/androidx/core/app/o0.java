package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6305a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f6306b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence[] f6307c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f6308d;

    /* renamed from: e, reason: collision with root package name */
    private final int f6309e;

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f6310f;

    /* renamed from: g, reason: collision with root package name */
    private final Set<String> f6311g;

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(o0 o0Var) {
            Set<String> setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(o0Var.i()).setLabel(o0Var.h()).setChoices(o0Var.e()).setAllowFreeFormInput(o0Var.c()).addExtras(o0Var.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = o0Var.d()) != null) {
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, o0Var.f());
            }
            return builderAddExtras.build();
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class b {
        static void a(o0 o0Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(o0.a(o0Var), intent, map);
        }

        static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z12) {
            return builder.setAllowDataType(str, z12);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder b(RemoteInput.Builder builder, int i12) {
            return builder.setEditChoicesBeforeSending(i12);
        }
    }

    static RemoteInput a(o0 o0Var) {
        return a.b(o0Var);
    }

    static RemoteInput[] b(o0[] o0VarArr) {
        if (o0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[o0VarArr.length];
        for (int i12 = 0; i12 < o0VarArr.length; i12++) {
            remoteInputArr[i12] = a(o0VarArr[i12]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f6308d;
    }

    public Set<String> d() {
        return this.f6311g;
    }

    public CharSequence[] e() {
        return this.f6307c;
    }

    public int f() {
        return this.f6309e;
    }

    public Bundle g() {
        return this.f6310f;
    }

    public CharSequence h() {
        return this.f6306b;
    }

    public String i() {
        return this.f6305a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
