package com.journeyapps.barcodescanner;

import D3.p;
import H3.j;
import H3.o;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.journeyapps.barcodescanner.a;
import java.util.ArrayList;
import java.util.List;
import k4.s;

/* loaded from: classes.dex */
public class ViewfinderView extends View {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f14889y = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: l, reason: collision with root package name */
    public final Paint f14890l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f14891m;

    /* renamed from: n, reason: collision with root package name */
    public int f14892n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14893o;

    /* renamed from: p, reason: collision with root package name */
    public final int f14894p;

    /* renamed from: q, reason: collision with root package name */
    public final int f14895q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14896r;

    /* renamed from: s, reason: collision with root package name */
    public int f14897s;

    /* renamed from: t, reason: collision with root package name */
    public List f14898t;

    /* renamed from: u, reason: collision with root package name */
    public List f14899u;

    /* renamed from: v, reason: collision with root package name */
    public com.journeyapps.barcodescanner.a f14900v;

    /* renamed from: w, reason: collision with root package name */
    public Rect f14901w;

    /* renamed from: x, reason: collision with root package name */
    public s f14902x;

    public class a implements a.f {
        public a() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14890l = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f3462n);
        this.f14892n = typedArrayObtainStyledAttributes.getColor(o.f3467s, resources.getColor(j.f3430d));
        this.f14893o = typedArrayObtainStyledAttributes.getColor(o.f3464p, resources.getColor(j.f3428b));
        this.f14894p = typedArrayObtainStyledAttributes.getColor(o.f3465q, resources.getColor(j.f3429c));
        this.f14895q = typedArrayObtainStyledAttributes.getColor(o.f3463o, resources.getColor(j.f3427a));
        this.f14896r = typedArrayObtainStyledAttributes.getBoolean(o.f3466r, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f14897s = 0;
        this.f14898t = new ArrayList(20);
        this.f14899u = new ArrayList(20);
    }

    public void a(p pVar) {
        if (this.f14898t.size() < 20) {
            this.f14898t.add(pVar);
        }
    }

    public void b() {
        com.journeyapps.barcodescanner.a aVar = this.f14900v;
        if (aVar == null) {
            return;
        }
        Rect framingRect = aVar.getFramingRect();
        s previewSize = this.f14900v.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f14901w = framingRect;
        this.f14902x = previewSize;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        s sVar;
        b();
        Rect rect = this.f14901w;
        if (rect == null || (sVar = this.f14902x) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f14890l.setColor(this.f14891m != null ? this.f14893o : this.f14892n);
        float f7 = width;
        canvas.drawRect(0.0f, 0.0f, f7, rect.top, this.f14890l);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f14890l);
        canvas.drawRect(rect.right + 1, rect.top, f7, rect.bottom + 1, this.f14890l);
        canvas.drawRect(0.0f, rect.bottom + 1, f7, height, this.f14890l);
        if (this.f14891m != null) {
            this.f14890l.setAlpha(160);
            canvas.drawBitmap(this.f14891m, (Rect) null, rect, this.f14890l);
            return;
        }
        if (this.f14896r) {
            this.f14890l.setColor(this.f14894p);
            Paint paint = this.f14890l;
            int[] iArr = f14889y;
            paint.setAlpha(iArr[this.f14897s]);
            this.f14897s = (this.f14897s + 1) % iArr.length;
            int iHeight = (rect.height() / 2) + rect.top;
            canvas.drawRect(rect.left + 2, iHeight - 1, rect.right - 1, iHeight + 2, this.f14890l);
        }
        float width2 = getWidth() / sVar.f19100l;
        float height2 = getHeight() / sVar.f19101m;
        if (!this.f14899u.isEmpty()) {
            this.f14890l.setAlpha(80);
            this.f14890l.setColor(this.f14895q);
            for (p pVar : this.f14899u) {
                canvas.drawCircle((int) (pVar.c() * width2), (int) (pVar.d() * height2), 3.0f, this.f14890l);
            }
            this.f14899u.clear();
        }
        if (!this.f14898t.isEmpty()) {
            this.f14890l.setAlpha(160);
            this.f14890l.setColor(this.f14895q);
            for (p pVar2 : this.f14898t) {
                canvas.drawCircle((int) (pVar2.c() * width2), (int) (pVar2.d() * height2), 6.0f, this.f14890l);
            }
            List list = this.f14898t;
            List list2 = this.f14899u;
            this.f14898t = list2;
            this.f14899u = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }

    public void setCameraPreview(com.journeyapps.barcodescanner.a aVar) {
        this.f14900v = aVar;
        aVar.i(new a());
    }

    public void setLaserVisibility(boolean z7) {
        this.f14896r = z7;
    }

    public void setMaskColor(int i7) {
        this.f14892n = i7;
    }
}
