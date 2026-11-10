package com.android.volley;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f18221a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18222b;

    public e(String str, String str2) {
        this.f18221a = str;
        this.f18222b = str2;
    }

    public final String a() {
        return this.f18221a;
    }

    public final String b() {
        return this.f18222b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f18221a, eVar.f18221a) && TextUtils.equals(this.f18222b, eVar.f18222b);
    }

    public int hashCode() {
        return (this.f18221a.hashCode() * 31) + this.f18222b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f18221a + ",value=" + this.f18222b + "]";
    }
}
