package A0;

import K.j;
import K.k;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;

/* loaded from: classes.dex */
public class c extends k.AbstractC0047k {

    /* renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f26f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f27g;

    /* renamed from: h, reason: collision with root package name */
    public int f28h;

    /* renamed from: i, reason: collision with root package name */
    public PendingIntent f29i;

    /* renamed from: e, reason: collision with root package name */
    public int[] f25e = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f30j = false;

    @Override // K.k.AbstractC0047k
    public void b(j jVar) {
        if (Build.VERSION.SDK_INT >= 34) {
            a.d(jVar.a(), a.b(b.a(a.a(), this.f27g, this.f28h, this.f29i, Boolean.valueOf(this.f30j)), this.f25e, this.f26f));
        } else {
            a.d(jVar.a(), a.b(a.a(), this.f25e, this.f26f));
        }
    }

    @Override // K.k.AbstractC0047k
    public RemoteViews i(j jVar) {
        return null;
    }

    @Override // K.k.AbstractC0047k
    public RemoteViews j(j jVar) {
        return null;
    }
}
