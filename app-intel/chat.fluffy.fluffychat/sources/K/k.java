package K;

import K.u;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class k {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f4829a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f4830b;

        /* renamed from: c, reason: collision with root package name */
        public final w[] f4831c;

        /* renamed from: d, reason: collision with root package name */
        public final w[] f4832d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4833e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4834f;

        /* renamed from: g, reason: collision with root package name */
        public final int f4835g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f4836h;

        /* renamed from: i, reason: collision with root package name */
        public int f4837i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f4838j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f4839k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f4840l;

        /* renamed from: K.k$a$a, reason: collision with other inner class name */
        public static final class C0046a {

            /* renamed from: a, reason: collision with root package name */
            public final IconCompat f4841a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f4842b;

            /* renamed from: c, reason: collision with root package name */
            public final PendingIntent f4843c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f4844d;

            /* renamed from: e, reason: collision with root package name */
            public final Bundle f4845e;

            /* renamed from: f, reason: collision with root package name */
            public ArrayList f4846f;

            /* renamed from: g, reason: collision with root package name */
            public int f4847g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f4848h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f4849i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f4850j;

            public C0046a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0046a a(w wVar) {
                if (this.f4846f == null) {
                    this.f4846f = new ArrayList();
                }
                if (wVar != null) {
                    this.f4846f.add(wVar);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f4846f;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    int i7 = 0;
                    while (i7 < size) {
                        Object obj = arrayList3.get(i7);
                        i7++;
                        w wVar = (w) obj;
                        if (wVar.k()) {
                            arrayList.add(wVar);
                        } else {
                            arrayList2.add(wVar);
                        }
                    }
                }
                return new a(this.f4841a, this.f4842b, this.f4843c, this.f4845e, arrayList2.isEmpty() ? null : (w[]) arrayList2.toArray(new w[arrayList2.size()]), arrayList.isEmpty() ? null : (w[]) arrayList.toArray(new w[arrayList.size()]), this.f4844d, this.f4847g, this.f4848h, this.f4849i, this.f4850j);
            }

            public final void c() {
                if (this.f4849i && this.f4843c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0046a d(boolean z7) {
                this.f4844d = z7;
                return this;
            }

            public C0046a e(boolean z7) {
                this.f4849i = z7;
                return this;
            }

            public C0046a f(int i7) {
                this.f4847g = i7;
                return this;
            }

            public C0046a g(boolean z7) {
                this.f4848h = z7;
                return this;
            }

            public C0046a(int i7, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i7 != 0 ? IconCompat.o(null, "", i7) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0046a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, w[] wVarArr, boolean z7, int i7, boolean z8, boolean z9, boolean z10) {
                this.f4844d = true;
                this.f4848h = true;
                this.f4841a = iconCompat;
                this.f4842b = e.f(charSequence);
                this.f4843c = pendingIntent;
                this.f4845e = bundle;
                this.f4846f = wVarArr == null ? null : new ArrayList(Arrays.asList(wVarArr));
                this.f4844d = z7;
                this.f4847g = i7;
                this.f4848h = z8;
                this.f4849i = z9;
                this.f4850j = z10;
            }
        }

        public a(int i7, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i7 != 0 ? IconCompat.o(null, "", i7) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f4839k;
        }

        public boolean b() {
            return this.f4833e;
        }

        public Bundle c() {
            return this.f4829a;
        }

        public IconCompat d() {
            int i7;
            if (this.f4830b == null && (i7 = this.f4837i) != 0) {
                this.f4830b = IconCompat.o(null, "", i7);
            }
            return this.f4830b;
        }

        public w[] e() {
            return this.f4831c;
        }

        public int f() {
            return this.f4835g;
        }

        public boolean g() {
            return this.f4834f;
        }

        public CharSequence h() {
            return this.f4838j;
        }

        public boolean i() {
            return this.f4840l;
        }

        public boolean j() {
            return this.f4836h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, w[] wVarArr, w[] wVarArr2, boolean z7, int i7, boolean z8, boolean z9, boolean z10) {
            this.f4834f = true;
            this.f4830b = iconCompat;
            if (iconCompat != null && iconCompat.t() == 2) {
                this.f4837i = iconCompat.q();
            }
            this.f4838j = e.f(charSequence);
            this.f4839k = pendingIntent;
            this.f4829a = bundle == null ? new Bundle() : bundle;
            this.f4831c = wVarArr;
            this.f4832d = wVarArr2;
            this.f4833e = z7;
            this.f4835g = i7;
            this.f4834f = z8;
            this.f4836h = z9;
            this.f4840l = z10;
        }
    }

    public static class b extends AbstractC0047k {

        /* renamed from: e, reason: collision with root package name */
        public IconCompat f4851e;

        /* renamed from: f, reason: collision with root package name */
        public IconCompat f4852f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f4853g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f4854h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f4855i;

        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z7) {
                bigPictureStyle.showBigPictureWhenCollapsed(z7);
            }
        }

        public static IconCompat n(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.e((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.j((Bitmap) parcelable);
            }
            return null;
        }

        public static IconCompat q(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("android.picture");
            return parcelable != null ? n(parcelable) : n(bundle.getParcelable("android.pictureIcon"));
        }

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(jVar.a()).setBigContentTitle(this.f4944b);
            IconCompat iconCompat = this.f4851e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    a.a(bigContentTitle, this.f4851e.A(jVar instanceof p ? ((p) jVar).f() : null));
                } else if (iconCompat.t() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f4851e.p());
                }
            }
            if (this.f4853g) {
                if (this.f4852f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    bigContentTitle.bigLargeIcon(this.f4852f.A(jVar instanceof p ? ((p) jVar).f() : null));
                }
            }
            if (this.f4946d) {
                bigContentTitle.setSummaryText(this.f4945c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                a.c(bigContentTitle, this.f4855i);
                a.b(bigContentTitle, this.f4854h);
            }
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // K.k.AbstractC0047k
        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f4852f = n(bundle.getParcelable("android.largeIcon.big"));
                this.f4853g = true;
            }
            this.f4851e = q(bundle);
            this.f4855i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f4852f = bitmap == null ? null : IconCompat.j(bitmap);
            this.f4853g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.f4851e = bitmap == null ? null : IconCompat.j(bitmap);
            return this;
        }

        public b r(CharSequence charSequence) {
            this.f4944b = e.f(charSequence);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f4945c = e.f(charSequence);
            this.f4946d = true;
            return this;
        }

        public b t(boolean z7) {
            this.f4855i = z7;
            return this;
        }
    }

    public static class c extends AbstractC0047k {

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f4856e;

        @Override // K.k.AbstractC0047k
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(jVar.a()).setBigContentTitle(this.f4944b).bigText(this.f4856e);
            if (this.f4946d) {
                bigTextStyleBigText.setSummaryText(this.f4945c);
            }
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // K.k.AbstractC0047k
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f4856e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.f4856e = e.f(charSequence);
            return this;
        }

        public c o(CharSequence charSequence) {
            this.f4944b = e.f(charSequence);
            return this;
        }

        public c p(CharSequence charSequence) {
            this.f4945c = e.f(charSequence);
            this.f4946d = true;
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static class e {

        /* renamed from: A, reason: collision with root package name */
        public String f4857A;

        /* renamed from: C, reason: collision with root package name */
        public boolean f4859C;

        /* renamed from: D, reason: collision with root package name */
        public boolean f4860D;

        /* renamed from: E, reason: collision with root package name */
        public String f4861E;

        /* renamed from: F, reason: collision with root package name */
        public Bundle f4862F;

        /* renamed from: I, reason: collision with root package name */
        public Notification f4865I;

        /* renamed from: J, reason: collision with root package name */
        public RemoteViews f4866J;

        /* renamed from: K, reason: collision with root package name */
        public RemoteViews f4867K;

        /* renamed from: L, reason: collision with root package name */
        public RemoteViews f4868L;

        /* renamed from: M, reason: collision with root package name */
        public String f4869M;

        /* renamed from: O, reason: collision with root package name */
        public String f4871O;

        /* renamed from: P, reason: collision with root package name */
        public L.d f4872P;

        /* renamed from: Q, reason: collision with root package name */
        public long f4873Q;

        /* renamed from: T, reason: collision with root package name */
        public boolean f4876T;

        /* renamed from: U, reason: collision with root package name */
        public Notification f4877U;

        /* renamed from: V, reason: collision with root package name */
        public boolean f4878V;

        /* renamed from: W, reason: collision with root package name */
        public Object f4879W;

        /* renamed from: X, reason: collision with root package name */
        public ArrayList f4880X;

        /* renamed from: a, reason: collision with root package name */
        public Context f4881a;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f4885e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f4886f;

        /* renamed from: g, reason: collision with root package name */
        public String f4887g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f4888h;

        /* renamed from: i, reason: collision with root package name */
        public PendingIntent f4889i;

        /* renamed from: j, reason: collision with root package name */
        public RemoteViews f4890j;

        /* renamed from: k, reason: collision with root package name */
        public IconCompat f4891k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f4892l;

        /* renamed from: m, reason: collision with root package name */
        public int f4893m;

        /* renamed from: n, reason: collision with root package name */
        public int f4894n;

        /* renamed from: p, reason: collision with root package name */
        public boolean f4896p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f4897q;

        /* renamed from: r, reason: collision with root package name */
        public AbstractC0047k f4898r;

        /* renamed from: s, reason: collision with root package name */
        public CharSequence f4899s;

        /* renamed from: t, reason: collision with root package name */
        public CharSequence f4900t;

        /* renamed from: u, reason: collision with root package name */
        public CharSequence[] f4901u;

        /* renamed from: v, reason: collision with root package name */
        public int f4902v;

        /* renamed from: w, reason: collision with root package name */
        public int f4903w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f4904x;

        /* renamed from: y, reason: collision with root package name */
        public String f4905y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f4906z;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f4882b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f4883c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f4884d = new ArrayList();

        /* renamed from: o, reason: collision with root package name */
        public boolean f4895o = true;

        /* renamed from: B, reason: collision with root package name */
        public boolean f4858B = false;

        /* renamed from: G, reason: collision with root package name */
        public int f4863G = 0;

        /* renamed from: H, reason: collision with root package name */
        public int f4864H = 0;

        /* renamed from: N, reason: collision with root package name */
        public int f4870N = 0;

        /* renamed from: R, reason: collision with root package name */
        public int f4874R = 0;

        /* renamed from: S, reason: collision with root package name */
        public int f4875S = 0;

        public e(Context context, String str) {
            Notification notification = new Notification();
            this.f4877U = notification;
            this.f4881a = context;
            this.f4869M = str;
            notification.when = System.currentTimeMillis();
            this.f4877U.audioStreamType = -1;
            this.f4894n = 0;
            this.f4880X = new ArrayList();
            this.f4876T = true;
        }

        public static CharSequence f(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(int i7, int i8, int i9) {
            Notification notification = this.f4877U;
            notification.ledARGB = i7;
            notification.ledOnMS = i8;
            notification.ledOffMS = i9;
            notification.flags = ((i8 == 0 || i9 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e B(int i7) {
            this.f4893m = i7;
            return this;
        }

        public e C(boolean z7) {
            u(2, z7);
            return this;
        }

        public e D(boolean z7) {
            u(8, z7);
            return this;
        }

        public e E(int i7) {
            this.f4894n = i7;
            return this;
        }

        public e F(int i7, int i8, boolean z7) {
            this.f4902v = i7;
            this.f4903w = i8;
            this.f4904x = z7;
            return this;
        }

        public e G(String str) {
            this.f4871O = str;
            return this;
        }

        public e H(boolean z7) {
            this.f4895o = z7;
            return this;
        }

        public e I(boolean z7) {
            this.f4878V = z7;
            return this;
        }

        public e J(int i7) {
            this.f4877U.icon = i7;
            return this;
        }

        public e K(Uri uri) {
            Notification notification = this.f4877U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(4).setUsage(5);
            this.f4877U.audioAttributes = usage.build();
            return this;
        }

        public e L(AbstractC0047k abstractC0047k) {
            if (this.f4898r != abstractC0047k) {
                this.f4898r = abstractC0047k;
                if (abstractC0047k != null) {
                    abstractC0047k.m(this);
                }
            }
            return this;
        }

        public e M(CharSequence charSequence) {
            this.f4899s = f(charSequence);
            return this;
        }

        public e N(CharSequence charSequence) {
            this.f4877U.tickerText = f(charSequence);
            return this;
        }

        public e O(long j7) {
            this.f4873Q = j7;
            return this;
        }

        public e P(boolean z7) {
            this.f4896p = z7;
            return this;
        }

        public e Q(long[] jArr) {
            this.f4877U.vibrate = jArr;
            return this;
        }

        public e R(int i7) {
            this.f4864H = i7;
            return this;
        }

        public e S(long j7) {
            this.f4877U.when = j7;
            return this;
        }

        public e a(int i7, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f4882b.add(new a(i7, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f4882b.add(aVar);
            }
            return this;
        }

        public e c(a aVar) {
            if (aVar != null) {
                this.f4884d.add(aVar);
            }
            return this;
        }

        public Notification d() {
            return new p(this).c();
        }

        public Bundle e() {
            if (this.f4862F == null) {
                this.f4862F = new Bundle();
            }
            return this.f4862F;
        }

        public e g(boolean z7) {
            u(16, z7);
            return this;
        }

        public e h(String str) {
            this.f4861E = str;
            return this;
        }

        public e i(String str) {
            this.f4869M = str;
            return this;
        }

        public e j(boolean z7) {
            this.f4897q = z7;
            e().putBoolean("android.chronometerCountDown", z7);
            return this;
        }

        public e k(int i7) {
            this.f4863G = i7;
            return this;
        }

        public e l(boolean z7) {
            this.f4859C = z7;
            this.f4860D = true;
            return this;
        }

        public e m(PendingIntent pendingIntent) {
            this.f4888h = pendingIntent;
            return this;
        }

        public e n(CharSequence charSequence) {
            this.f4886f = f(charSequence);
            return this;
        }

        public e o(CharSequence charSequence) {
            this.f4885e = f(charSequence);
            return this;
        }

        public e p(RemoteViews remoteViews) {
            this.f4867K = remoteViews;
            return this;
        }

        public e q(RemoteViews remoteViews) {
            this.f4866J = remoteViews;
            return this;
        }

        public e r(RemoteViews remoteViews) {
            this.f4868L = remoteViews;
            return this;
        }

        public e s(int i7) {
            Notification notification = this.f4877U;
            notification.defaults = i7;
            if ((i7 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e t(PendingIntent pendingIntent) {
            this.f4877U.deleteIntent = pendingIntent;
            return this;
        }

        public final void u(int i7, boolean z7) {
            if (z7) {
                Notification notification = this.f4877U;
                notification.flags = i7 | notification.flags;
            } else {
                Notification notification2 = this.f4877U;
                notification2.flags = (~i7) & notification2.flags;
            }
        }

        public e v(PendingIntent pendingIntent, boolean z7) {
            this.f4889i = pendingIntent;
            u(128, z7);
            return this;
        }

        public e w(String str) {
            this.f4905y = str;
            return this;
        }

        public e x(int i7) {
            this.f4874R = i7;
            return this;
        }

        public e y(boolean z7) {
            this.f4906z = z7;
            return this;
        }

        public e z(Bitmap bitmap) {
            this.f4891k = bitmap == null ? null : IconCompat.j(k.b(this.f4881a, bitmap));
            return this;
        }
    }

    public static class f extends AbstractC0047k {

        /* renamed from: e, reason: collision with root package name */
        public int f4907e;

        /* renamed from: f, reason: collision with root package name */
        public u f4908f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f4909g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f4910h;

        /* renamed from: i, reason: collision with root package name */
        public PendingIntent f4911i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f4912j;

        /* renamed from: k, reason: collision with root package name */
        public Integer f4913k;

        /* renamed from: l, reason: collision with root package name */
        public Integer f4914l;

        /* renamed from: m, reason: collision with root package name */
        public IconCompat f4915m;

        /* renamed from: n, reason: collision with root package name */
        public CharSequence f4916n;

        public static class b {
            public static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i7) {
                return callStyle.setAnswerButtonColorHint(i7);
            }

            public static Notification.CallStyle e(Notification.CallStyle callStyle, int i7) {
                return callStyle.setDeclineButtonColorHint(i7);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, boolean z7) {
                return callStyle.setIsVideo(z7);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        public f() {
        }

        public static f n(u uVar, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "declineIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new f(1, uVar, null, pendingIntent, pendingIntent2);
        }

        public static f o(u uVar, PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            return new f(2, uVar, pendingIntent, null, null);
        }

        @Override // K.k.AbstractC0047k
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f4907e);
            bundle.putBoolean("android.callIsVideo", this.f4912j);
            u uVar = this.f4908f;
            if (uVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", a.b(uVar.k()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", uVar.l());
                }
            }
            IconCompat iconCompat = this.f4915m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", iconCompat.A(this.f4943a.f4881a));
            }
            bundle.putCharSequence("android.verificationText", this.f4916n);
            bundle.putParcelable("android.answerIntent", this.f4909g);
            bundle.putParcelable("android.declineIntent", this.f4910h);
            bundle.putParcelable("android.hangUpIntent", this.f4911i);
            Integer num = this.f4913k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f4914l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            int i7 = Build.VERSION.SDK_INT;
            CharSequence charSequenceQ = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceQ = null;
            if (i7 < 31) {
                Notification.Builder builderA = jVar.a();
                u uVar = this.f4908f;
                builderA.setContentTitle(uVar != null ? uVar.f() : null);
                Bundle bundle = this.f4943a.f4862F;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceQ = this.f4943a.f4862F.getCharSequence("android.text");
                }
                if (charSequenceQ == null) {
                    charSequenceQ = q();
                }
                builderA.setContentText(charSequenceQ);
                u uVar2 = this.f4908f;
                if (uVar2 != null) {
                    if (uVar2.d() != null) {
                        builderA.setLargeIcon(this.f4908f.d().A(this.f4943a.f4881a));
                    }
                    if (i7 >= 28) {
                        a.a(builderA, this.f4908f.k());
                    } else {
                        builderA.addPerson(this.f4908f.g());
                    }
                }
                builderA.setCategory("call");
                return;
            }
            int i8 = this.f4907e;
            if (i8 == 1) {
                callStyleA = b.a(this.f4908f.k(), this.f4910h, this.f4909g);
            } else if (i8 == 2) {
                callStyleA = b.b(this.f4908f.k(), this.f4911i);
            } else if (i8 == 3) {
                callStyleA = b.c(this.f4908f.k(), this.f4911i, this.f4909g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f4907e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(jVar.a());
                Integer num = this.f4913k;
                if (num != null) {
                    b.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f4914l;
                if (num2 != null) {
                    b.e(callStyleA, num2.intValue());
                }
                b.h(callStyleA, this.f4916n);
                IconCompat iconCompat = this.f4915m;
                if (iconCompat != null) {
                    b.g(callStyleA, iconCompat.A(this.f4943a.f4881a));
                }
                b.f(callStyleA, this.f4912j);
            }
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // K.k.AbstractC0047k
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f4907e = bundle.getInt("android.callType");
            this.f4912j = bundle.getBoolean("android.callIsVideo");
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
                this.f4908f = u.a(m.a(bundle.getParcelable("android.callPerson")));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f4908f = u.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (bundle.containsKey("android.verificationIcon")) {
                this.f4915m = IconCompat.e((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.f4915m = IconCompat.c(bundle.getBundle("android.verificationIconCompat"));
            }
            this.f4916n = bundle.getCharSequence("android.verificationText");
            this.f4909g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.f4910h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.f4911i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            this.f4913k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            this.f4914l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
        }

        public ArrayList p() {
            a aVarU = u();
            a aVarT = t();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(aVarU);
            ArrayList arrayList2 = this.f4943a.f4882b;
            int i7 = 2;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList2.get(i8);
                    i8++;
                    a aVar = (a) obj;
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!r(aVar)) {
                        arrayList.add(aVar);
                        i7--;
                    }
                    if (aVarT != null && i7 == 1) {
                        arrayList.add(aVarT);
                        i7--;
                    }
                }
            }
            if (aVarT != null && i7 >= 1) {
                arrayList.add(aVarT);
            }
            return arrayList;
        }

        public final String q() {
            int i7 = this.f4907e;
            if (i7 == 1) {
                return this.f4943a.f4881a.getResources().getString(J.f.f4352e);
            }
            if (i7 == 2) {
                return this.f4943a.f4881a.getResources().getString(J.f.f4353f);
            }
            if (i7 != 3) {
                return null;
            }
            return this.f4943a.f4881a.getResources().getString(J.f.f4354g);
        }

        public final boolean r(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a s(int i7, int i8, Integer num, int i9, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(L.b.b(this.f4943a.f4881a, i9));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f4943a.f4881a.getResources().getString(i8));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C0046a(IconCompat.n(this.f4943a.f4881a, i7), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        public final a t() {
            int i7 = J.d.f4300b;
            int i8 = J.d.f4299a;
            PendingIntent pendingIntent = this.f4909g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z7 = this.f4912j;
            return s(z7 ? i7 : i8, z7 ? J.f.f4349b : J.f.f4348a, this.f4913k, J.b.f4295a, pendingIntent);
        }

        public final a u() {
            int i7 = J.d.f4301c;
            PendingIntent pendingIntent = this.f4910h;
            return pendingIntent == null ? s(i7, J.f.f4351d, this.f4914l, J.b.f4296b, this.f4911i) : s(i7, J.f.f4350c, this.f4914l, J.b.f4296b, pendingIntent);
        }

        public f v(boolean z7) {
            this.f4912j = z7;
            return this;
        }

        public f w(CharSequence charSequence) {
            this.f4916n = charSequence;
            return this;
        }

        public f(int i7, u uVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
            if (uVar == null || TextUtils.isEmpty(uVar.f())) {
                throw new IllegalArgumentException("person must have a non-empty a name");
            }
            this.f4907e = i7;
            this.f4908f = uVar;
            this.f4909g = pendingIntent3;
            this.f4910h = pendingIntent2;
            this.f4911i = pendingIntent;
        }

        public static class a {
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            public static Parcelable b(Person person) {
                return person;
            }
        }
    }

    public static class g extends AbstractC0047k {

        public static class a {
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            jVar.a().setStyle(a.a());
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // K.k.AbstractC0047k
        public RemoteViews i(K.j jVar) {
            return null;
        }

        @Override // K.k.AbstractC0047k
        public RemoteViews j(K.j jVar) {
            return null;
        }

        @Override // K.k.AbstractC0047k
        public RemoteViews k(K.j jVar) {
            return null;
        }
    }

    public static class h extends AbstractC0047k {

        /* renamed from: e, reason: collision with root package name */
        public ArrayList f4917e = new ArrayList();

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(jVar.a()).setBigContentTitle(this.f4944b);
            if (this.f4946d) {
                bigContentTitle.setSummaryText(this.f4945c);
            }
            ArrayList arrayList = this.f4917e;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                bigContentTitle.addLine((CharSequence) obj);
            }
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // K.k.AbstractC0047k
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f4917e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f4917e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            if (charSequence != null) {
                this.f4917e.add(e.f(charSequence));
            }
            return this;
        }

        public h o(CharSequence charSequence) {
            this.f4944b = e.f(charSequence);
            return this;
        }

        public h p(CharSequence charSequence) {
            this.f4945c = e.f(charSequence);
            this.f4946d = true;
            return this;
        }
    }

    public static class j extends AbstractC0047k {

        /* renamed from: h, reason: collision with root package name */
        public boolean f4932h;

        /* renamed from: j, reason: collision with root package name */
        public IconCompat f4934j;

        /* renamed from: k, reason: collision with root package name */
        public IconCompat f4935k;

        /* renamed from: l, reason: collision with root package name */
        public IconCompat f4936l;

        /* renamed from: e, reason: collision with root package name */
        public List f4929e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public List f4930f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        public int f4931g = 0;

        /* renamed from: i, reason: collision with root package name */
        public boolean f4933i = true;

        public static final class a {
            public static void a(Notification.ProgressStyle progressStyle, int i7) {
                progressStyle.setProgress(i7);
            }

            public static void b(Notification.ProgressStyle progressStyle, Icon icon) {
                progressStyle.setProgressEndIcon(icon);
            }

            public static void c(Notification.ProgressStyle progressStyle, boolean z7) {
                progressStyle.setProgressIndeterminate(z7);
            }

            public static void d(Notification.ProgressStyle progressStyle, List<b> list) {
                for (b bVar : list) {
                    progressStyle.addProgressPoint(new Notification.ProgressStyle.Point(bVar.c()).setColor(bVar.a()).setId(bVar.b()));
                }
            }

            public static void e(Notification.ProgressStyle progressStyle, List<c> list) {
                for (c cVar : list) {
                    progressStyle.addProgressSegment(new Notification.ProgressStyle.Segment(cVar.c()).setColor(cVar.a()).setId(cVar.b()));
                }
            }

            public static void f(Notification.ProgressStyle progressStyle, Icon icon) {
                progressStyle.setProgressStartIcon(icon);
            }

            public static void g(Notification.ProgressStyle progressStyle, Icon icon) {
                progressStyle.setProgressTrackerIcon(icon);
            }

            public static void h(Notification.ProgressStyle progressStyle, boolean z7) {
                progressStyle.setStyledByProgress(z7);
            }
        }

        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public int f4937a;

            /* renamed from: b, reason: collision with root package name */
            public int f4938b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f4939c = 0;

            public b(int i7) {
                this.f4937a = i7;
            }

            public int a() {
                return this.f4939c;
            }

            public int b() {
                return this.f4938b;
            }

            public int c() {
                return this.f4937a;
            }

            public b d(int i7) {
                this.f4939c = i7;
                return this;
            }

            public b e(int i7) {
                this.f4938b = i7;
                return this;
            }
        }

        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            public int f4940a;

            /* renamed from: b, reason: collision with root package name */
            public int f4941b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f4942c = 0;

            public c(int i7) {
                this.f4940a = i7;
            }

            public int a() {
                return this.f4942c;
            }

            public int b() {
                return this.f4941b;
            }

            public int c() {
                return this.f4940a;
            }

            public c d(int i7) {
                this.f4942c = i7;
                return this;
            }

            public c e(int i7) {
                this.f4941b = i7;
                return this;
            }
        }

        private static IconCompat n(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.e((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.j((Bitmap) parcelable);
            }
            return null;
        }

        public static ArrayList p(List list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i7 = 0; i7 < list.size(); i7++) {
                    b bVar = (b) list.get(i7);
                    if (bVar.c() >= 0) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", bVar.c());
                        bundle.putInt("id", bVar.b());
                        bundle.putInt("colorInt", bVar.a());
                        arrayList.add(bundle);
                    }
                }
            }
            return arrayList;
        }

        public static List q(List list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i7 = 0; i7 < list.size(); i7++) {
                    Bundle bundle = (Bundle) list.get(i7);
                    int i8 = bundle.getInt("position");
                    if (i8 >= 0) {
                        arrayList.add(new b(i8).e(bundle.getInt("id")).d(bundle.getInt("colorInt", 0)));
                    }
                }
            }
            return arrayList;
        }

        public static ArrayList r(List list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i7 = 0; i7 < list.size(); i7++) {
                    c cVar = (c) list.get(i7);
                    if (cVar.c() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("length", cVar.c());
                        bundle.putInt("id", cVar.b());
                        bundle.putInt("colorInt", cVar.a());
                        arrayList.add(bundle);
                    }
                }
            }
            return arrayList;
        }

        public static List s(List list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i7 = 0; i7 < list.size(); i7++) {
                    Bundle bundle = (Bundle) list.get(i7);
                    int i8 = bundle.getInt("length");
                    if (i8 > 0) {
                        arrayList.add(new c(i8).e(bundle.getInt("id")).d(bundle.getInt("colorInt", 0)));
                    }
                }
            }
            return arrayList;
        }

        @Override // K.k.AbstractC0047k
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 36) {
                bundle.putParcelableArrayList("android.progressSegments", r(this.f4929e));
                bundle.putParcelableArrayList("android.progressPoints", p(this.f4930f));
                bundle.putInt("android.progress", this.f4931g);
                bundle.putBoolean("android.progressIndeterminate", this.f4932h);
                bundle.putInt("android.progressMax", o());
                bundle.putBoolean("android.styledByProgress", this.f4933i);
                e eVar = this.f4943a;
                Context context = eVar != null ? eVar.f4881a : null;
                if (context == null) {
                    return;
                }
                IconCompat iconCompat = this.f4934j;
                if (iconCompat != null) {
                    bundle.putParcelable("android.progressTrackerIcon", iconCompat.A(context));
                } else {
                    bundle.remove("android.progressTrackerIcon");
                }
                IconCompat iconCompat2 = this.f4935k;
                if (iconCompat2 != null) {
                    bundle.putParcelable("android.progressStartIcon", iconCompat2.A(context));
                } else {
                    bundle.remove("android.progressStartIcon");
                }
                IconCompat iconCompat3 = this.f4936l;
                if (iconCompat3 != null) {
                    bundle.putParcelable("android.progressEndIcon", iconCompat3.A(context));
                } else {
                    bundle.remove("android.progressEndIcon");
                }
            }
        }

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            Notification.Builder builderA = jVar.a();
            if (Build.VERSION.SDK_INT < 36) {
                int iO = o();
                builderA.setProgress(iO, Math.min(this.f4931g, iO), this.f4932h);
                return;
            }
            Context contextF = jVar instanceof p ? ((p) jVar).f() : null;
            Notification.ProgressStyle progressStyleA = n.a();
            a.h(progressStyleA, this.f4933i);
            a.a(progressStyleA, this.f4931g);
            a.c(progressStyleA, this.f4932h);
            IconCompat iconCompat = this.f4935k;
            a.f(progressStyleA, iconCompat != null ? iconCompat.A(contextF) : null);
            IconCompat iconCompat2 = this.f4936l;
            a.b(progressStyleA, iconCompat2 != null ? iconCompat2.A(contextF) : null);
            IconCompat iconCompat3 = this.f4934j;
            a.g(progressStyleA, iconCompat3 != null ? iconCompat3.A(contextF) : null);
            a.d(progressStyleA, this.f4930f);
            a.e(progressStyleA, this.f4929e);
            builderA.setStyle(progressStyleA);
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$ProgressStyle";
        }

        @Override // K.k.AbstractC0047k
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f4929e = s(V.d.b(bundle, "android.progressSegments", Bundle.class));
            this.f4931g = bundle.getInt("android.progress", 0);
            this.f4932h = bundle.getBoolean("android.progressIndeterminate", false);
            this.f4933i = bundle.getBoolean("android.styledByProgress", true);
            this.f4930f = q(V.d.b(bundle, "android.progressPoints", Bundle.class));
            this.f4934j = n((Parcelable) V.d.a(bundle, "android.progressTrackerIcon", Icon.class));
            this.f4935k = n((Parcelable) V.d.a(bundle, "android.progressStartIcon", Icon.class));
            this.f4936l = n((Parcelable) V.d.a(bundle, "android.progressEndIcon", Icon.class));
        }

        public int o() {
            List list = this.f4929e;
            if (list == null || list.isEmpty()) {
                return 100;
            }
            int i7 = 0;
            int iAddExact = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                int iC = ((c) list.get(i8)).c();
                if (iC > 0) {
                    try {
                        iAddExact = Math.addExact(iAddExact, iC);
                        i7++;
                    } catch (ArithmeticException unused) {
                        return 100;
                    }
                }
            }
            if (i7 == 0) {
                return 100;
            }
            return iAddExact;
        }
    }

    @Deprecated
    public k() {
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) throws Resources.NotFoundException {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(J.c.f4298b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(J.c.f4297a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * dMin), (int) Math.ceil(bitmap.getHeight() * dMin), true);
    }

    public static class i extends AbstractC0047k {

        /* renamed from: e, reason: collision with root package name */
        public final List f4918e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public final List f4919f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        public u f4920g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f4921h;

        /* renamed from: i, reason: collision with root package name */
        public Boolean f4922i;

        public static class a {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            public static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            public static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        public static class b {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        public static class c {
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z7) {
                return messagingStyle.setGroupConversation(z7);
            }
        }

        public i() {
        }

        public static i o(Notification notification) {
            AbstractC0047k abstractC0047kG = AbstractC0047k.g(notification);
            if (abstractC0047kG instanceof i) {
                return (i) abstractC0047kG;
            }
            return null;
        }

        @Override // K.k.AbstractC0047k
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f4920g.f());
            bundle.putBundle("android.messagingStyleUser", this.f4920g.l());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f4921h);
            if (this.f4921h != null && this.f4922i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f4921h);
            }
            if (!this.f4918e.isEmpty()) {
                bundle.putParcelableArray("android.messages", d.a(this.f4918e));
            }
            if (!this.f4919f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", d.a(this.f4919f));
            }
            Boolean bool = this.f4922i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // K.k.AbstractC0047k
        public void b(K.j jVar) {
            u(s());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? c.a(this.f4920g.k()) : a.b(this.f4920g.f());
            Iterator it = this.f4918e.iterator();
            while (it.hasNext()) {
                a.a(messagingStyleA, ((d) it.next()).k());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f4919f.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, ((d) it2.next()).k());
                }
            }
            if (this.f4922i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                a.c(messagingStyleA, this.f4921h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                c.b(messagingStyleA, this.f4922i.booleanValue());
            }
            messagingStyleA.setBuilder(jVar.a());
        }

        @Override // K.k.AbstractC0047k
        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // K.k.AbstractC0047k
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f4918e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.f4920g = u.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.f4920g = new u.c().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f4921h = charSequence;
            if (charSequence == null) {
                this.f4921h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f4918e.addAll(d.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f4919f.addAll(d.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f4922i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public i n(d dVar) {
            if (dVar != null) {
                this.f4918e.add(dVar);
                if (this.f4918e.size() > 25) {
                    this.f4918e.remove(0);
                }
            }
            return this;
        }

        public CharSequence p() {
            return this.f4921h;
        }

        public List q() {
            return this.f4918e;
        }

        public u r() {
            return this.f4920g;
        }

        public boolean s() {
            e eVar = this.f4943a;
            if (eVar != null && eVar.f4881a.getApplicationInfo().targetSdkVersion < 28 && this.f4922i == null) {
                return this.f4921h != null;
            }
            Boolean bool = this.f4922i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public i t(CharSequence charSequence) {
            this.f4921h = charSequence;
            return this;
        }

        public i u(boolean z7) {
            this.f4922i = Boolean.valueOf(z7);
            return this;
        }

        public i(u uVar) {
            if (!TextUtils.isEmpty(uVar.f())) {
                this.f4920g = uVar;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public static final class d {

            /* renamed from: a, reason: collision with root package name */
            public final CharSequence f4923a;

            /* renamed from: b, reason: collision with root package name */
            public final long f4924b;

            /* renamed from: c, reason: collision with root package name */
            public final u f4925c;

            /* renamed from: d, reason: collision with root package name */
            public Bundle f4926d = new Bundle();

            /* renamed from: e, reason: collision with root package name */
            public String f4927e;

            /* renamed from: f, reason: collision with root package name */
            public Uri f4928f;

            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j7, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j7, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public d(CharSequence charSequence, long j7, u uVar) {
                this.f4923a = charSequence;
                this.f4924b = j7;
                this.f4925c = uVar;
            }

            public static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i7 = 0; i7 < size; i7++) {
                    bundleArr[i7] = ((d) list.get(i7)).l();
                }
                return bundleArr;
            }

            public static d e(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        d dVar = new d(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.containsKey("person") ? u.b(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new u.c().f(bundle.getCharSequence("sender")).a() : null : u.a(m.a(bundle.getParcelable("sender_person"))));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            dVar.j(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey("extras")) {
                            dVar.d().putAll(bundle.getBundle("extras"));
                        }
                        return dVar;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public static List f(Parcelable[] parcelableArr) {
                d dVarE;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if ((parcelable instanceof Bundle) && (dVarE = e((Bundle) parcelable)) != null) {
                        arrayList.add(dVarE);
                    }
                }
                return arrayList;
            }

            public String b() {
                return this.f4927e;
            }

            public Uri c() {
                return this.f4928f;
            }

            public Bundle d() {
                return this.f4926d;
            }

            public u g() {
                return this.f4925c;
            }

            public CharSequence h() {
                return this.f4923a;
            }

            public long i() {
                return this.f4924b;
            }

            public d j(String str, Uri uri) {
                this.f4927e = str;
                this.f4928f = uri;
                return this;
            }

            public Notification.MessagingStyle.Message k() {
                Notification.MessagingStyle.Message messageA;
                u uVarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.b(h(), i(), uVarG != null ? uVarG.k() : null);
                } else {
                    messageA = a.a(h(), i(), uVarG != null ? uVarG.f() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f4923a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f4924b);
                u uVar = this.f4925c;
                if (uVar != null) {
                    bundle.putCharSequence("sender", uVar.f());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f4925c.k()));
                    } else {
                        bundle.putBundle("person", this.f4925c.l());
                    }
                }
                String str = this.f4927e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f4928f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f4926d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public static class b {
                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j7, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j7, person);
                }

                public static Parcelable a(Person person) {
                    return person;
                }
            }
        }
    }

    /* renamed from: K.k$k, reason: collision with other inner class name */
    public static abstract class AbstractC0047k {

        /* renamed from: a, reason: collision with root package name */
        public e f4943a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f4944b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f4945c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4946d = false;

        public static AbstractC0047k c(String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$ProgressStyle":
                    return new j();
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new g();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new b();
                case "androidx.core.app.NotificationCompat$CallStyle":
                    return new f();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new h();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new c();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new i();
                default:
                    return null;
            }
        }

        public static AbstractC0047k d(String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new b();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new c();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new h();
            }
            if (Build.VERSION.SDK_INT >= 36 && str.equals(o.a().getName())) {
                return new j();
            }
            if (str.equals(Notification.MessagingStyle.class.getName())) {
                return new i();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new g();
            }
            return null;
        }

        public static AbstractC0047k e(Bundle bundle) {
            AbstractC0047k abstractC0047kC = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            return abstractC0047kC != null ? abstractC0047kC : (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) ? new i() : (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) ? new b() : bundle.containsKey("android.bigText") ? new c() : bundle.containsKey("android.textLines") ? new h() : bundle.containsKey("android.callType") ? new f() : (bundle.containsKey("android.progressSegments") || bundle.containsKey("android.progressPoints")) ? new j() : d(bundle.getString("android.template"));
        }

        public static AbstractC0047k f(Bundle bundle) {
            AbstractC0047k abstractC0047kE = e(bundle);
            if (abstractC0047kE == null) {
                return null;
            }
            try {
                abstractC0047kE.l(bundle);
                return abstractC0047kE;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public static AbstractC0047k g(Notification notification) {
            Bundle bundleA = k.a(notification);
            if (bundleA == null) {
                return null;
            }
            return f(bundleA);
        }

        public void a(Bundle bundle) {
            if (this.f4946d) {
                bundle.putCharSequence("android.summaryText", this.f4945c);
            }
            CharSequence charSequence = this.f4944b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public String h() {
            return null;
        }

        public RemoteViews i(K.j jVar) {
            return null;
        }

        public RemoteViews j(K.j jVar) {
            return null;
        }

        public RemoteViews k(K.j jVar) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f4945c = bundle.getCharSequence("android.summaryText");
                this.f4946d = true;
            }
            this.f4944b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.f4943a != eVar) {
                this.f4943a = eVar;
                if (eVar != null) {
                    eVar.L(this);
                }
            }
        }

        public void b(K.j jVar) {
        }
    }
}
