package androidx.media;

import android.os.Bundle;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f8145a;

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f8146b;

    public d(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }
        this.f8145a = str;
        this.f8146b = bundle;
    }
}
