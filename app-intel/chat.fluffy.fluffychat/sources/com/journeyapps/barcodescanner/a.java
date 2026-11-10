package com.journeyapps.barcodescanner;

import H3.k;
import H3.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.r;
import k4.s;
import k4.u;
import l4.C1312g;
import l4.i;
import l4.j;
import l4.l;
import l4.m;
import l4.n;
import l4.q;

/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: L, reason: collision with root package name */
    public static final String f14904L = "a";

    /* renamed from: A, reason: collision with root package name */
    public s f14905A;

    /* renamed from: B, reason: collision with root package name */
    public Rect f14906B;

    /* renamed from: C, reason: collision with root package name */
    public Rect f14907C;

    /* renamed from: D, reason: collision with root package name */
    public s f14908D;

    /* renamed from: E, reason: collision with root package name */
    public double f14909E;

    /* renamed from: F, reason: collision with root package name */
    public q f14910F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f14911G;

    /* renamed from: H, reason: collision with root package name */
    public final SurfaceHolder.Callback f14912H;

    /* renamed from: I, reason: collision with root package name */
    public final Handler.Callback f14913I;

    /* renamed from: J, reason: collision with root package name */
    public k4.q f14914J;

    /* renamed from: K, reason: collision with root package name */
    public final f f14915K;

    /* renamed from: l, reason: collision with root package name */
    public C1312g f14916l;

    /* renamed from: m, reason: collision with root package name */
    public WindowManager f14917m;

    /* renamed from: n, reason: collision with root package name */
    public Handler f14918n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14919o;

    /* renamed from: p, reason: collision with root package name */
    public SurfaceView f14920p;

    /* renamed from: q, reason: collision with root package name */
    public TextureView f14921q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14922r;

    /* renamed from: s, reason: collision with root package name */
    public r f14923s;

    /* renamed from: t, reason: collision with root package name */
    public int f14924t;

    /* renamed from: u, reason: collision with root package name */
    public List f14925u;

    /* renamed from: v, reason: collision with root package name */
    public m f14926v;

    /* renamed from: w, reason: collision with root package name */
    public i f14927w;

    /* renamed from: x, reason: collision with root package name */
    public s f14928x;

    /* renamed from: y, reason: collision with root package name */
    public s f14929y;

    /* renamed from: z, reason: collision with root package name */
    public Rect f14930z;

    /* renamed from: com.journeyapps.barcodescanner.a$a, reason: collision with other inner class name */
    public class TextureViewSurfaceTextureListenerC0148a implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC0148a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i7, int i8) {
            onSurfaceTextureSizeChanged(surfaceTexture, i7, i8);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i7, int i8) {
            a.this.f14905A = new s(i7, i8);
            a.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i7, int i8, int i9) {
            if (surfaceHolder == null) {
                Log.e(a.f14904L, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            a.this.f14905A = new s(i8, i9);
            a.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            a.this.f14905A = null;
        }
    }

    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == k.f3440j) {
                a.this.w((s) message.obj);
                return true;
            }
            if (i7 != k.f3434d) {
                if (i7 != k.f3433c) {
                    return false;
                }
                a.this.f14915K.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!a.this.r()) {
                return false;
            }
            a.this.u();
            a.this.f14915K.b(exc);
            return false;
        }
    }

    public class d implements k4.q {
        public d() {
        }

        @Override // k4.q
        public void a(int i7) {
            a.this.f14918n.postDelayed(new Runnable() { // from class: k4.c
                @Override // java.lang.Runnable
                public final void run() {
                    com.journeyapps.barcodescanner.a.this.z();
                }
            }, 250L);
        }
    }

    public class e implements f {
        public e() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
            Iterator it = a.this.f14925u.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
            Iterator it = a.this.f14925u.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
            Iterator it = a.this.f14925u.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
            Iterator it = a.this.f14925u.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
            Iterator it = a.this.f14925u.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    public interface f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public a(Context context) {
        super(context);
        this.f14919o = false;
        this.f14922r = false;
        this.f14924t = -1;
        this.f14925u = new ArrayList();
        this.f14927w = new i();
        this.f14906B = null;
        this.f14907C = null;
        this.f14908D = null;
        this.f14909E = 0.1d;
        this.f14910F = null;
        this.f14911G = false;
        this.f14912H = new b();
        this.f14913I = new c();
        this.f14914J = new d();
        this.f14915K = new e();
        p(context, null, 0, 0);
    }

    private int getDisplayRotation() {
        return this.f14917m.getDefaultDisplay().getRotation();
    }

    public final void A() {
        if (this.f14919o) {
            TextureView textureView = new TextureView(getContext());
            this.f14921q = textureView;
            textureView.setSurfaceTextureListener(D());
            addView(this.f14921q);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f14920p = surfaceView;
        surfaceView.getHolder().addCallback(this.f14912H);
        addView(this.f14920p);
    }

    public final void B(j jVar) {
        if (this.f14922r || this.f14916l == null) {
            return;
        }
        Log.i(f14904L, "Starting preview");
        this.f14916l.w(jVar);
        this.f14916l.y();
        this.f14922r = true;
        x();
        this.f14915K.e();
    }

    public final void C() {
        Rect rect;
        s sVar = this.f14905A;
        if (sVar == null || this.f14929y == null || (rect = this.f14930z) == null) {
            return;
        }
        if (this.f14920p != null && sVar.equals(new s(rect.width(), this.f14930z.height()))) {
            B(new j(this.f14920p.getHolder()));
            return;
        }
        TextureView textureView = this.f14921q;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.f14929y != null) {
            this.f14921q.setTransform(l(new s(this.f14921q.getWidth(), this.f14921q.getHeight()), this.f14929y));
        }
        B(new j(this.f14921q.getSurfaceTexture()));
    }

    public final TextureView.SurfaceTextureListener D() {
        return new TextureViewSurfaceTextureListenerC0148a();
    }

    public C1312g getCameraInstance() {
        return this.f14916l;
    }

    public i getCameraSettings() {
        return this.f14927w;
    }

    public Rect getFramingRect() {
        return this.f14906B;
    }

    public s getFramingRectSize() {
        return this.f14908D;
    }

    public double getMarginFraction() {
        return this.f14909E;
    }

    public Rect getPreviewFramingRect() {
        return this.f14907C;
    }

    public q getPreviewScalingStrategy() {
        q qVar = this.f14910F;
        return qVar != null ? qVar : this.f14921q != null ? new l() : new n();
    }

    public s getPreviewSize() {
        return this.f14929y;
    }

    public void i(f fVar) {
        this.f14925u.add(fVar);
    }

    public final void j() {
        s sVar;
        m mVar;
        s sVar2 = this.f14928x;
        if (sVar2 == null || (sVar = this.f14929y) == null || (mVar = this.f14926v) == null) {
            this.f14907C = null;
            this.f14906B = null;
            this.f14930z = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i7 = sVar.f19100l;
        int i8 = sVar.f19101m;
        int i9 = sVar2.f19100l;
        int i10 = sVar2.f19101m;
        Rect rectD = mVar.d(sVar);
        if (rectD.width() <= 0 || rectD.height() <= 0) {
            return;
        }
        this.f14930z = rectD;
        this.f14906B = k(new Rect(0, 0, i9, i10), this.f14930z);
        Rect rect = new Rect(this.f14906B);
        Rect rect2 = this.f14930z;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i7) / this.f14930z.width(), (rect.top * i8) / this.f14930z.height(), (rect.right * i7) / this.f14930z.width(), (rect.bottom * i8) / this.f14930z.height());
        this.f14907C = rect3;
        if (rect3.width() > 0 && this.f14907C.height() > 0) {
            this.f14915K.a();
            return;
        }
        this.f14907C = null;
        this.f14906B = null;
        Log.w(f14904L, "Preview frame is too small");
    }

    public Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f14908D != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f14908D.f19100l) / 2), Math.max(0, (rect3.height() - this.f14908D.f19101m) / 2));
            return rect3;
        }
        int iMin = (int) Math.min(rect3.width() * this.f14909E, rect3.height() * this.f14909E);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public Matrix l(s sVar, s sVar2) {
        float f7;
        float f8 = sVar.f19100l / sVar.f19101m;
        float f9 = sVar2.f19100l / sVar2.f19101m;
        float f10 = 1.0f;
        if (f8 < f9) {
            float f11 = f9 / f8;
            f7 = 1.0f;
            f10 = f11;
        } else {
            f7 = f8 / f9;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f7);
        int i7 = sVar.f19100l;
        int i8 = sVar.f19101m;
        matrix.postTranslate((i7 - (i7 * f10)) / 2.0f, (i8 - (i8 * f7)) / 2.0f);
        return matrix;
    }

    public final void m(s sVar) {
        this.f14928x = sVar;
        C1312g c1312g = this.f14916l;
        if (c1312g == null || c1312g.n() != null) {
            return;
        }
        m mVar = new m(getDisplayRotation(), sVar);
        this.f14926v = mVar;
        mVar.e(getPreviewScalingStrategy());
        this.f14916l.u(this.f14926v);
        this.f14916l.m();
        boolean z7 = this.f14911G;
        if (z7) {
            this.f14916l.x(z7);
        }
    }

    public C1312g n() {
        C1312g c1312g = new C1312g(getContext());
        c1312g.t(this.f14927w);
        return c1312g;
    }

    public final void o() {
        if (this.f14916l != null) {
            Log.w(f14904L, "initCamera called twice");
            return;
        }
        C1312g c1312gN = n();
        this.f14916l = c1312gN;
        c1312gN.v(this.f14918n);
        this.f14916l.r();
        this.f14924t = getDisplayRotation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        m(new s(i9 - i7, i10 - i8));
        SurfaceView surfaceView = this.f14920p;
        if (surfaceView == null) {
            TextureView textureView = this.f14921q;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f14930z;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.f14911G);
        return bundle;
    }

    public final void p(Context context, AttributeSet attributeSet, int i7, int i8) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.f14917m = (WindowManager) context.getSystemService("window");
        this.f14918n = new Handler(this.f14913I);
        this.f14923s = new r();
    }

    public void q(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f3457i);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(o.f3459k, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(o.f3458j, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f14908D = new s(dimension, dimension2);
        }
        this.f14919o = typedArrayObtainStyledAttributes.getBoolean(o.f3461m, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(o.f3460l, -1);
        if (integer == 1) {
            this.f14910F = new l();
        } else if (integer == 2) {
            this.f14910F = new n();
        } else if (integer == 3) {
            this.f14910F = new l4.o();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean r() {
        return this.f14916l != null;
    }

    public boolean s() {
        C1312g c1312g = this.f14916l;
        return c1312g == null || c1312g.p();
    }

    public void setCameraSettings(i iVar) {
        this.f14927w = iVar;
    }

    public void setFramingRectSize(s sVar) {
        this.f14908D = sVar;
    }

    public void setMarginFraction(double d7) {
        if (d7 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.f14909E = d7;
    }

    public void setPreviewScalingStrategy(q qVar) {
        this.f14910F = qVar;
    }

    public void setTorch(boolean z7) {
        this.f14911G = z7;
        C1312g c1312g = this.f14916l;
        if (c1312g != null) {
            c1312g.x(z7);
        }
    }

    public void setUseTextureView(boolean z7) {
        this.f14919o = z7;
    }

    public boolean t() {
        return this.f14922r;
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        u.a();
        Log.d(f14904L, "pause()");
        this.f14924t = -1;
        C1312g c1312g = this.f14916l;
        if (c1312g != null) {
            c1312g.l();
            this.f14916l = null;
            this.f14922r = false;
        } else {
            this.f14918n.sendEmptyMessage(k.f3433c);
        }
        if (this.f14905A == null && (surfaceView = this.f14920p) != null) {
            surfaceView.getHolder().removeCallback(this.f14912H);
        }
        if (this.f14905A == null && (textureView = this.f14921q) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f14928x = null;
        this.f14929y = null;
        this.f14907C = null;
        this.f14923s.f();
        this.f14915K.c();
    }

    public void v() throws InterruptedException {
        C1312g cameraInstance = getCameraInstance();
        u();
        long jNanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.p() && System.nanoTime() - jNanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void w(s sVar) {
        this.f14929y = sVar;
        if (this.f14928x != null) {
            j();
            requestLayout();
            C();
        }
    }

    public void x() {
    }

    public void y() {
        u.a();
        Log.d(f14904L, "resume()");
        o();
        if (this.f14905A != null) {
            C();
        } else {
            SurfaceView surfaceView = this.f14920p;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f14912H);
            } else {
                TextureView textureView = this.f14921q;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.f14921q.getSurfaceTexture(), this.f14921q.getWidth(), this.f14921q.getHeight());
                    } else {
                        this.f14921q.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.f14923s.e(getContext(), this.f14914J);
    }

    public final void z() {
        if (!r() || getDisplayRotation() == this.f14924t) {
            return;
        }
        u();
        y();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14919o = false;
        this.f14922r = false;
        this.f14924t = -1;
        this.f14925u = new ArrayList();
        this.f14927w = new i();
        this.f14906B = null;
        this.f14907C = null;
        this.f14908D = null;
        this.f14909E = 0.1d;
        this.f14910F = null;
        this.f14911G = false;
        this.f14912H = new b();
        this.f14913I = new c();
        this.f14914J = new d();
        this.f14915K = new e();
        p(context, attributeSet, 0, 0);
    }
}
