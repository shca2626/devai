package w5;

import M5.m;
import android.R;
import android.content.res.Resources;
import c5.InterfaceC0911a;
import h5.i;
import h5.j;

/* renamed from: w5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1755a implements InterfaceC0911a, j.c {

    /* renamed from: l, reason: collision with root package name */
    public j f23422l;

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC0911a.b f23423m;

    public final int[] a(Resources resources) {
        return new int[]{resources.getColor(R.color.system_accent1_1000, null), resources.getColor(R.color.system_accent1_900, null), resources.getColor(R.color.system_accent1_800, null), resources.getColor(R.color.system_accent1_700, null), resources.getColor(R.color.system_accent1_600, null), resources.getColor(R.color.system_accent1_500, null), resources.getColor(R.color.system_accent1_400, null), resources.getColor(R.color.system_accent1_300, null), resources.getColor(R.color.system_accent1_200, null), resources.getColor(R.color.system_accent1_100, null), resources.getColor(R.color.system_accent1_50, null), resources.getColor(R.color.system_accent1_10, null), resources.getColor(R.color.system_accent1_0, null), resources.getColor(R.color.system_accent2_1000, null), resources.getColor(R.color.system_accent2_900, null), resources.getColor(R.color.system_accent2_800, null), resources.getColor(R.color.system_accent2_700, null), resources.getColor(R.color.system_accent2_600, null), resources.getColor(R.color.system_accent2_500, null), resources.getColor(R.color.system_accent2_400, null), resources.getColor(R.color.system_accent2_300, null), resources.getColor(R.color.system_accent2_200, null), resources.getColor(R.color.system_accent2_100, null), resources.getColor(R.color.system_accent2_50, null), resources.getColor(R.color.system_accent2_10, null), resources.getColor(R.color.system_accent2_0, null), resources.getColor(R.color.system_accent3_1000, null), resources.getColor(R.color.system_accent3_900, null), resources.getColor(R.color.system_accent3_800, null), resources.getColor(R.color.system_accent3_700, null), resources.getColor(R.color.system_accent3_600, null), resources.getColor(R.color.system_accent3_500, null), resources.getColor(R.color.system_accent3_400, null), resources.getColor(R.color.system_accent3_300, null), resources.getColor(R.color.system_accent3_200, null), resources.getColor(R.color.system_accent3_100, null), resources.getColor(R.color.system_accent3_50, null), resources.getColor(R.color.system_accent3_10, null), resources.getColor(R.color.system_accent3_0, null), resources.getColor(R.color.system_neutral1_1000, null), resources.getColor(R.color.system_neutral1_900, null), resources.getColor(R.color.system_neutral1_800, null), resources.getColor(R.color.system_neutral1_700, null), resources.getColor(R.color.system_neutral1_600, null), resources.getColor(R.color.system_neutral1_500, null), resources.getColor(R.color.system_neutral1_400, null), resources.getColor(R.color.system_neutral1_300, null), resources.getColor(R.color.system_neutral1_200, null), resources.getColor(R.color.system_neutral1_100, null), resources.getColor(R.color.system_neutral1_50, null), resources.getColor(R.color.system_neutral1_10, null), resources.getColor(R.color.system_neutral1_0, null), resources.getColor(R.color.system_neutral2_1000, null), resources.getColor(R.color.system_neutral2_900, null), resources.getColor(R.color.system_neutral2_800, null), resources.getColor(R.color.system_neutral2_700, null), resources.getColor(R.color.system_neutral2_600, null), resources.getColor(R.color.system_neutral2_500, null), resources.getColor(R.color.system_neutral2_400, null), resources.getColor(R.color.system_neutral2_300, null), resources.getColor(R.color.system_neutral2_200, null), resources.getColor(R.color.system_neutral2_100, null), resources.getColor(R.color.system_neutral2_50, null), resources.getColor(R.color.system_neutral2_10, null), resources.getColor(R.color.system_neutral2_0, null)};
    }

    @Override // c5.InterfaceC0911a
    public void onAttachedToEngine(InterfaceC0911a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
        j jVar = new j(bVar.b(), "io.material.plugins/dynamic_color");
        this.f23422l = jVar;
        jVar.e(this);
        this.f23423m = bVar;
    }

    @Override // c5.InterfaceC0911a
    public void onDetachedFromEngine(InterfaceC0911a.b bVar) {
        m.e(bVar, "binding");
        j jVar = this.f23422l;
        if (jVar == null) {
            m.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        m.e(iVar, "call");
        m.e(dVar, "result");
        if (!m.a(iVar.f16895a, "getCorePalette")) {
            dVar.notImplemented();
            return;
        }
        InterfaceC0911a.b bVar = null;
        if (!V2.a.a()) {
            dVar.success(null);
            return;
        }
        InterfaceC0911a.b bVar2 = this.f23423m;
        if (bVar2 == null) {
            m.o("binding");
        } else {
            bVar = bVar2;
        }
        Resources resources = bVar.a().getResources();
        m.d(resources, "getResources(...)");
        dVar.success(a(resources));
    }
}
