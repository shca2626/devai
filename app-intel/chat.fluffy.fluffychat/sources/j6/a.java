package j6;

import M5.m;
import android.content.Context;
import android.graphics.Rect;
import com.journeyapps.barcodescanner.BarcodeView;
import k4.s;

/* loaded from: classes3.dex */
public final class a extends BarcodeView {

    /* renamed from: T, reason: collision with root package name */
    public static final C0212a f18782T = new C0212a(null);

    /* renamed from: S, reason: collision with root package name */
    public int f18783S;

    /* renamed from: j6.a$a, reason: collision with other inner class name */
    public static final class C0212a {
        public /* synthetic */ C0212a(M5.g gVar) {
            this();
        }

        public C0212a() {
        }
    }

    public a(Context context) {
        super(context);
        this.f18783S = -1;
    }

    public final void O(int i7, int i8, int i9) {
        this.f18783S = i9;
        setFramingRectSize(new s(i7, i8));
    }

    @Override // com.journeyapps.barcodescanner.a
    public Rect k(Rect rect, Rect rect2) {
        m.e(rect, "container");
        m.e(rect2, "surface");
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        Rect rectK = super.k(rect, rect2);
        if (this.f18783S != -1) {
            Rect rect4 = new Rect(rectK);
            int i7 = rect4.bottom;
            int i8 = this.f18783S;
            rect4.bottom = i7 - i8;
            rect4.top -= i8;
            if (rect4.intersect(rect3)) {
                return rect4;
            }
        }
        m.b(rectK);
        return rectK;
    }
}
