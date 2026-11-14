package a3;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import c3.C0905d;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    public float f10763c;

    /* renamed from: f, reason: collision with root package name */
    public C0905d f10766f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f10761a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final c3.f f10762b = new a();

    /* renamed from: d, reason: collision with root package name */
    public boolean f10764d = true;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference f10765e = new WeakReference(null);

    public class a extends c3.f {
        public a() {
        }

        @Override // c3.f
        public void a(int i7) {
            i.this.f10764d = true;
            b bVar = (b) i.this.f10765e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c3.f
        public void b(Typeface typeface, boolean z7) {
            if (z7) {
                return;
            }
            i.this.f10764d = true;
            b bVar = (b) i.this.f10765e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public i(b bVar) {
        g(bVar);
    }

    public final float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f10761a.measureText(charSequence, 0, charSequence.length());
    }

    public C0905d d() {
        return this.f10766f;
    }

    public TextPaint e() {
        return this.f10761a;
    }

    public float f(String str) {
        if (!this.f10764d) {
            return this.f10763c;
        }
        float fC = c(str);
        this.f10763c = fC;
        this.f10764d = false;
        return fC;
    }

    public void g(b bVar) {
        this.f10765e = new WeakReference(bVar);
    }

    public void h(C0905d c0905d, Context context) {
        if (this.f10766f != c0905d) {
            this.f10766f = c0905d;
            if (c0905d != null) {
                c0905d.o(context, this.f10761a, this.f10762b);
                b bVar = (b) this.f10765e.get();
                if (bVar != null) {
                    this.f10761a.drawableState = bVar.getState();
                }
                c0905d.n(context, this.f10761a, this.f10762b);
                this.f10764d = true;
            }
            b bVar2 = (b) this.f10765e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z7) {
        this.f10764d = z7;
    }

    public void j(Context context) {
        this.f10766f.n(context, this.f10761a, this.f10762b);
    }
}
