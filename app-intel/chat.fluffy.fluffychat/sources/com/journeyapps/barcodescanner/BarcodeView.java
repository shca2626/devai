package com.journeyapps.barcodescanner;

import D3.e;
import H3.k;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.List;
import k4.InterfaceC1284a;
import k4.i;
import k4.j;
import k4.l;
import k4.m;
import k4.u;

/* loaded from: classes.dex */
public class BarcodeView extends com.journeyapps.barcodescanner.a {

    /* renamed from: M, reason: collision with root package name */
    public b f14871M;

    /* renamed from: N, reason: collision with root package name */
    public InterfaceC1284a f14872N;

    /* renamed from: O, reason: collision with root package name */
    public l f14873O;

    /* renamed from: P, reason: collision with root package name */
    public j f14874P;

    /* renamed from: Q, reason: collision with root package name */
    public Handler f14875Q;

    /* renamed from: R, reason: collision with root package name */
    public final Handler.Callback f14876R;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == k.f3437g) {
                k4.b bVar = (k4.b) message.obj;
                if (bVar != null && BarcodeView.this.f14872N != null && BarcodeView.this.f14871M != b.NONE) {
                    BarcodeView.this.f14872N.a(bVar);
                    if (BarcodeView.this.f14871M == b.SINGLE) {
                        BarcodeView.this.N();
                    }
                }
                return true;
            }
            if (i7 == k.f3436f) {
                return true;
            }
            if (i7 != k.f3438h) {
                return false;
            }
            List list = (List) message.obj;
            if (BarcodeView.this.f14872N != null && BarcodeView.this.f14871M != b.NONE) {
                BarcodeView.this.f14872N.b(list);
            }
            return true;
        }
    }

    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context) {
        super(context);
        this.f14871M = b.NONE;
        this.f14872N = null;
        this.f14876R = new a();
        K();
    }

    public final i G() {
        if (this.f14874P == null) {
            this.f14874P = H();
        }
        k4.k kVar = new k4.k();
        HashMap map = new HashMap();
        map.put(e.NEED_RESULT_POINT_CALLBACK, kVar);
        i iVarA = this.f14874P.a(map);
        kVar.b(iVarA);
        return iVarA;
    }

    public j H() {
        return new m();
    }

    public void I(InterfaceC1284a interfaceC1284a) {
        this.f14871M = b.CONTINUOUS;
        this.f14872N = interfaceC1284a;
        L();
    }

    public void J(InterfaceC1284a interfaceC1284a) {
        this.f14871M = b.SINGLE;
        this.f14872N = interfaceC1284a;
        L();
    }

    public final void K() {
        this.f14874P = new m();
        this.f14875Q = new Handler(this.f14876R);
    }

    public final void L() {
        M();
        if (this.f14871M == b.NONE || !t()) {
            return;
        }
        l lVar = new l(getCameraInstance(), G(), this.f14875Q);
        this.f14873O = lVar;
        lVar.i(getPreviewFramingRect());
        this.f14873O.k();
    }

    public final void M() {
        l lVar = this.f14873O;
        if (lVar != null) {
            lVar.l();
            this.f14873O = null;
        }
    }

    public void N() {
        this.f14871M = b.NONE;
        this.f14872N = null;
        M();
    }

    public j getDecoderFactory() {
        return this.f14874P;
    }

    public void setDecoderFactory(j jVar) {
        u.a();
        this.f14874P = jVar;
        l lVar = this.f14873O;
        if (lVar != null) {
            lVar.j(G());
        }
    }

    @Override // com.journeyapps.barcodescanner.a
    public void u() {
        M();
        super.u();
    }

    @Override // com.journeyapps.barcodescanner.a
    public void x() {
        super.x();
        L();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14871M = b.NONE;
        this.f14872N = null;
        this.f14876R = new a();
        K();
    }
}
