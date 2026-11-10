package g5;

import android.os.Build;
import android.util.DisplayMetrics;
import h5.C1144a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final a f16465a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final C1144a f16466b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue f16467a = new ConcurrentLinkedQueue();

        /* renamed from: b, reason: collision with root package name */
        public b f16468b;

        /* renamed from: c, reason: collision with root package name */
        public b f16469c;

        /* renamed from: g5.u$a$a, reason: collision with other inner class name */
        public class C0182a implements C1144a.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f16470a;

            public C0182a(b bVar) {
                this.f16470a = bVar;
            }

            @Override // h5.C1144a.e
            public void a(Object obj) {
                a.this.f16467a.remove(this.f16470a);
                if (a.this.f16467a.isEmpty()) {
                    return;
                }
                U4.b.b("SettingsChannel", "The queue becomes empty after removing config generation " + this.f16470a.f16473a);
            }
        }

        public static class b {

            /* renamed from: c, reason: collision with root package name */
            public static int f16472c = Integer.MIN_VALUE;

            /* renamed from: a, reason: collision with root package name */
            public final int f16473a;

            /* renamed from: b, reason: collision with root package name */
            public final DisplayMetrics f16474b;

            public b(DisplayMetrics displayMetrics) {
                int i7 = f16472c;
                f16472c = i7 + 1;
                this.f16473a = i7;
                this.f16474b = displayMetrics;
            }
        }

        public C1144a.e a(b bVar) {
            this.f16467a.add(bVar);
            b bVar2 = this.f16469c;
            this.f16469c = bVar;
            if (bVar2 == null) {
                return null;
            }
            return new C0182a(bVar2);
        }

        public b b(int i7) {
            b bVar;
            if (this.f16468b == null) {
                this.f16468b = (b) this.f16467a.poll();
            }
            while (true) {
                bVar = this.f16468b;
                if (bVar == null || bVar.f16473a >= i7) {
                    break;
                }
                this.f16468b = (b) this.f16467a.poll();
            }
            if (bVar == null) {
                U4.b.b("SettingsChannel", "Cannot find config with generation: " + i7 + ", after exhausting the queue.");
                return null;
            }
            if (bVar.f16473a == i7) {
                return bVar;
            }
            U4.b.b("SettingsChannel", "Cannot find config with generation: " + i7 + ", the oldest config is now: " + this.f16468b.f16473a);
            return null;
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Map f16475a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public DisplayMetrics f16476b;

        public b() {
        }

        public void a() {
            U4.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f16475a.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f16475a.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f16475a.get("platformBrightness"));
            DisplayMetrics displayMetrics = this.f16476b;
            if (!u.b() || displayMetrics == null) {
                u.this.f16466b.c(this.f16475a);
                return;
            }
            a.b bVar = new a.b(displayMetrics);
            C1144a.e eVarA = u.this.f16465a.a(bVar);
            this.f16475a.put("configurationId", Integer.valueOf(bVar.f16473a));
            u.this.f16466b.d(this.f16475a, eVarA);
        }

        public b b(boolean z7) {
            this.f16475a.put("brieflyShowPassword", Boolean.valueOf(z7));
            return this;
        }

        public b c(DisplayMetrics displayMetrics) {
            this.f16476b = displayMetrics;
            return this;
        }

        public b d(boolean z7) {
            this.f16475a.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z7));
            return this;
        }

        public b e(c cVar) {
            this.f16475a.put("platformBrightness", cVar.f16481l);
            return this;
        }

        public b f(float f7) {
            this.f16475a.put("textScaleFactor", Float.valueOf(f7));
            return this;
        }

        public b g(boolean z7) {
            this.f16475a.put("alwaysUse24HourFormat", Boolean.valueOf(z7));
            return this;
        }
    }

    public enum c {
        light("light"),
        dark("dark");


        /* renamed from: l, reason: collision with root package name */
        public String f16481l;

        c(String str) {
            this.f16481l = str;
        }
    }

    public u(X4.a aVar) {
        this.f16466b = new C1144a(aVar, "flutter/settings", h5.e.f16893a);
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public DisplayMetrics a(int i7) {
        a.b bVarB = this.f16465a.b(i7);
        if (bVarB == null) {
            return null;
        }
        return bVarB.f16474b;
    }

    public b c() {
        return new b();
    }
}
