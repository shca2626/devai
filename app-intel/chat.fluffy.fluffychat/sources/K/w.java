package K;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final String f4994a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f4995b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence[] f4996c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4997d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4998e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f4999f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f5000g;

    public static class a {
        public static RemoteInput a(w wVar) {
            Set setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(wVar.i()).setLabel(wVar.h()).setChoices(wVar.e()).setAllowFreeFormInput(wVar.c()).addExtras(wVar.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = wVar.d()) != null) {
                Iterator it = setD.iterator();
                while (it.hasNext()) {
                    b.a(builderAddExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.a(builderAddExtras, wVar.f());
            }
            return builderAddExtras.build();
        }
    }

    public static class b {
        public static RemoteInput.Builder a(RemoteInput.Builder builder, String str, boolean z7) {
            return builder.setAllowDataType(str, z7);
        }
    }

    public static class c {
        public static RemoteInput.Builder a(RemoteInput.Builder builder, int i7) {
            return builder.setEditChoicesBeforeSending(i7);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f5001a;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f5004d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence[] f5005e;

        /* renamed from: b, reason: collision with root package name */
        public final Set f5002b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f5003c = new Bundle();

        /* renamed from: f, reason: collision with root package name */
        public boolean f5006f = true;

        /* renamed from: g, reason: collision with root package name */
        public int f5007g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f5001a = str;
        }

        public w a() {
            return new w(this.f5001a, this.f5004d, this.f5005e, this.f5006f, this.f5007g, this.f5003c, this.f5002b);
        }

        public d b(String str, boolean z7) {
            if (z7) {
                this.f5002b.add(str);
                return this;
            }
            this.f5002b.remove(str);
            return this;
        }

        public d c(boolean z7) {
            this.f5006f = z7;
            return this;
        }

        public d d(CharSequence[] charSequenceArr) {
            this.f5005e = charSequenceArr;
            return this;
        }

        public d e(CharSequence charSequence) {
            this.f5004d = charSequence;
            return this;
        }
    }

    public w(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z7, int i7, Bundle bundle, Set set) {
        this.f4994a = str;
        this.f4995b = charSequence;
        this.f4996c = charSequenceArr;
        this.f4997d = z7;
        this.f4998e = i7;
        this.f4999f = bundle;
        this.f5000g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput a(w wVar) {
        return a.a(wVar);
    }

    public static RemoteInput[] b(w[] wVarArr) {
        if (wVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[wVarArr.length];
        for (int i7 = 0; i7 < wVarArr.length; i7++) {
            remoteInputArr[i7] = a(wVarArr[i7]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }

    public boolean c() {
        return this.f4997d;
    }

    public Set d() {
        return this.f5000g;
    }

    public CharSequence[] e() {
        return this.f4996c;
    }

    public int f() {
        return this.f4998e;
    }

    public Bundle g() {
        return this.f4999f;
    }

    public CharSequence h() {
        return this.f4995b;
    }

    public String i() {
        return this.f4994a;
    }

    public boolean k() {
        if (c()) {
            return false;
        }
        return ((e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
