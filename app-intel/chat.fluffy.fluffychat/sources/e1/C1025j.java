package e1;

import R0.C0585w;
import android.view.Surface;

/* renamed from: e1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1025j extends C0585w {

    /* renamed from: o, reason: collision with root package name */
    public final int f15400o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f15401p;

    public C1025j(Throwable th, R0.x xVar, Surface surface) {
        super(th, xVar);
        this.f15400o = System.identityHashCode(surface);
        this.f15401p = surface == null || surface.isValid();
    }
}
