package B0;

import E0.U;
import android.media.AudioAttributes;
import android.os.Build;

/* renamed from: B0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0300b {

    /* renamed from: i, reason: collision with root package name */
    public static final C0300b f612i = new d().a();

    /* renamed from: j, reason: collision with root package name */
    public static final String f613j = U.A0(0);

    /* renamed from: k, reason: collision with root package name */
    public static final String f614k = U.A0(1);

    /* renamed from: l, reason: collision with root package name */
    public static final String f615l = U.A0(2);

    /* renamed from: m, reason: collision with root package name */
    public static final String f616m = U.A0(3);

    /* renamed from: n, reason: collision with root package name */
    public static final String f617n = U.A0(4);

    /* renamed from: o, reason: collision with root package name */
    public static final String f618o = U.A0(5);

    /* renamed from: p, reason: collision with root package name */
    public static final String f619p = U.A0(6);

    /* renamed from: a, reason: collision with root package name */
    public final int f620a;

    /* renamed from: b, reason: collision with root package name */
    public final int f621b;

    /* renamed from: c, reason: collision with root package name */
    public final int f622c;

    /* renamed from: d, reason: collision with root package name */
    public final int f623d;

    /* renamed from: e, reason: collision with root package name */
    public final int f624e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f625f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f626g;

    /* renamed from: h, reason: collision with root package name */
    public AudioAttributes f627h;

    /* renamed from: B0.b$b, reason: collision with other inner class name */
    public static final class C0009b {
        public static void b(AudioAttributes.Builder builder, int i7) {
            builder.setAllowedCapturePolicy(i7);
        }

        public static void c(AudioAttributes.Builder builder, boolean z7) {
            builder.setHapticChannelsMuted(z7);
        }
    }

    /* renamed from: B0.b$c */
    public static final class c {
        public static void a(AudioAttributes.Builder builder, boolean z7) {
            builder.setIsContentSpatialized(z7);
        }

        public static void b(AudioAttributes.Builder builder, int i7) {
            builder.setSpatializationBehavior(i7);
        }
    }

    /* renamed from: B0.b$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public int f628a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f629b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f630c = 1;

        /* renamed from: d, reason: collision with root package name */
        public int f631d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f632e = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f633f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f634g = true;

        public C0300b a() {
            return new C0300b(this.f628a, this.f629b, this.f630c, this.f631d, this.f632e, this.f633f, this.f634g);
        }

        public d b(int i7) {
            this.f628a = i7;
            return this;
        }

        public d c(int i7) {
            this.f629b = i7;
            return this;
        }

        public d d(int i7) {
            this.f630c = i7;
            return this;
        }
    }

    public AudioAttributes a() {
        if (this.f627h == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f620a).setFlags(this.f621b).setUsage(this.f622c);
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 29) {
                C0009b.b(usage, this.f623d);
                C0009b.c(usage, this.f626g);
            }
            if (i7 >= 32) {
                c.b(usage, this.f624e);
                c.a(usage, this.f625f);
            }
            this.f627h = usage.build();
        }
        return this.f627h;
    }

    public int b() {
        if ((this.f621b & 1) == 1) {
            return 1;
        }
        switch (this.f622c) {
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0300b.class == obj.getClass()) {
            C0300b c0300b = (C0300b) obj;
            if (this.f620a == c0300b.f620a && this.f621b == c0300b.f621b && this.f622c == c0300b.f622c && this.f623d == c0300b.f623d && this.f624e == c0300b.f624e && this.f625f == c0300b.f625f && this.f626g == c0300b.f626g) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((527 + this.f620a) * 31) + this.f621b) * 31) + this.f622c) * 31) + this.f623d) * 31) + this.f624e) * 31) + (this.f625f ? 1 : 0)) * 31) + (this.f626g ? 1 : 0);
    }

    public C0300b(int i7, int i8, int i9, int i10, int i11, boolean z7, boolean z8) {
        this.f620a = i7;
        this.f621b = i8;
        this.f622c = i9;
        this.f623d = i10;
        this.f624e = i11;
        this.f625f = z7;
        this.f626g = z8;
    }
}
