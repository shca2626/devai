package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.webrtc.PeerConnectionFactory;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f11740d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static SparseIntArray f11741e;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f11742a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public boolean f11743b = true;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f11744c = new HashMap();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f11745a;

        /* renamed from: b, reason: collision with root package name */
        public final d f11746b = new d();

        /* renamed from: c, reason: collision with root package name */
        public final C0101c f11747c = new C0101c();

        /* renamed from: d, reason: collision with root package name */
        public final b f11748d = new b();

        /* renamed from: e, reason: collision with root package name */
        public final e f11749e = new e();

        /* renamed from: f, reason: collision with root package name */
        public HashMap f11750f = new HashMap();

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f11748d;
            bVar.f11672d = bVar2.f11792h;
            bVar.f11674e = bVar2.f11794i;
            bVar.f11676f = bVar2.f11796j;
            bVar.f11678g = bVar2.f11798k;
            bVar.f11680h = bVar2.f11799l;
            bVar.f11682i = bVar2.f11800m;
            bVar.f11684j = bVar2.f11801n;
            bVar.f11686k = bVar2.f11802o;
            bVar.f11688l = bVar2.f11803p;
            bVar.f11696p = bVar2.f11804q;
            bVar.f11697q = bVar2.f11805r;
            bVar.f11698r = bVar2.f11806s;
            bVar.f11699s = bVar2.f11807t;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f11755D;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f11756E;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f11757F;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f11758G;
            bVar.f11704x = bVar2.f11766O;
            bVar.f11705y = bVar2.f11765N;
            bVar.f11701u = bVar2.f11762K;
            bVar.f11703w = bVar2.f11764M;
            bVar.f11706z = bVar2.f11808u;
            bVar.f11640A = bVar2.f11809v;
            bVar.f11690m = bVar2.f11811x;
            bVar.f11692n = bVar2.f11812y;
            bVar.f11694o = bVar2.f11813z;
            bVar.f11641B = bVar2.f11810w;
            bVar.f11656Q = bVar2.f11752A;
            bVar.f11657R = bVar2.f11753B;
            bVar.f11645F = bVar2.f11767P;
            bVar.f11644E = bVar2.f11768Q;
            bVar.f11647H = bVar2.f11770S;
            bVar.f11646G = bVar2.f11769R;
            bVar.f11659T = bVar2.f11793h0;
            bVar.f11660U = bVar2.f11795i0;
            bVar.f11648I = bVar2.f11771T;
            bVar.f11649J = bVar2.f11772U;
            bVar.f11652M = bVar2.f11773V;
            bVar.f11653N = bVar2.f11774W;
            bVar.f11650K = bVar2.f11775X;
            bVar.f11651L = bVar2.f11776Y;
            bVar.f11654O = bVar2.f11777Z;
            bVar.f11655P = bVar2.f11779a0;
            bVar.f11658S = bVar2.f11754C;
            bVar.f11670c = bVar2.f11790g;
            bVar.f11666a = bVar2.f11786e;
            bVar.f11668b = bVar2.f11788f;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f11782c;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f11784d;
            String str = bVar2.f11791g0;
            if (str != null) {
                bVar.f11661V = str;
            }
            bVar.setMarginStart(bVar2.f11760I);
            bVar.setMarginEnd(this.f11748d.f11759H);
            bVar.a();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f11748d.a(this.f11748d);
            aVar.f11747c.a(this.f11747c);
            aVar.f11746b.a(this.f11746b);
            aVar.f11749e.a(this.f11749e);
            aVar.f11745a = this.f11745a;
            return aVar;
        }

        public final void d(int i7, ConstraintLayout.b bVar) {
            this.f11745a = i7;
            b bVar2 = this.f11748d;
            bVar2.f11792h = bVar.f11672d;
            bVar2.f11794i = bVar.f11674e;
            bVar2.f11796j = bVar.f11676f;
            bVar2.f11798k = bVar.f11678g;
            bVar2.f11799l = bVar.f11680h;
            bVar2.f11800m = bVar.f11682i;
            bVar2.f11801n = bVar.f11684j;
            bVar2.f11802o = bVar.f11686k;
            bVar2.f11803p = bVar.f11688l;
            bVar2.f11804q = bVar.f11696p;
            bVar2.f11805r = bVar.f11697q;
            bVar2.f11806s = bVar.f11698r;
            bVar2.f11807t = bVar.f11699s;
            bVar2.f11808u = bVar.f11706z;
            bVar2.f11809v = bVar.f11640A;
            bVar2.f11810w = bVar.f11641B;
            bVar2.f11811x = bVar.f11690m;
            bVar2.f11812y = bVar.f11692n;
            bVar2.f11813z = bVar.f11694o;
            bVar2.f11752A = bVar.f11656Q;
            bVar2.f11753B = bVar.f11657R;
            bVar2.f11754C = bVar.f11658S;
            bVar2.f11790g = bVar.f11670c;
            bVar2.f11786e = bVar.f11666a;
            bVar2.f11788f = bVar.f11668b;
            bVar2.f11782c = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f11784d = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f11755D = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f11756E = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f11757F = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f11758G = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f11767P = bVar.f11645F;
            bVar2.f11768Q = bVar.f11644E;
            bVar2.f11770S = bVar.f11647H;
            bVar2.f11769R = bVar.f11646G;
            bVar2.f11793h0 = bVar.f11659T;
            bVar2.f11795i0 = bVar.f11660U;
            bVar2.f11771T = bVar.f11648I;
            bVar2.f11772U = bVar.f11649J;
            bVar2.f11773V = bVar.f11652M;
            bVar2.f11774W = bVar.f11653N;
            bVar2.f11775X = bVar.f11650K;
            bVar2.f11776Y = bVar.f11651L;
            bVar2.f11777Z = bVar.f11654O;
            bVar2.f11779a0 = bVar.f11655P;
            bVar2.f11791g0 = bVar.f11661V;
            bVar2.f11762K = bVar.f11701u;
            bVar2.f11764M = bVar.f11703w;
            bVar2.f11761J = bVar.f11700t;
            bVar2.f11763L = bVar.f11702v;
            bVar2.f11766O = bVar.f11704x;
            bVar2.f11765N = bVar.f11705y;
            bVar2.f11759H = bVar.getMarginEnd();
            this.f11748d.f11760I = bVar.getMarginStart();
        }
    }

    public static class b {

        /* renamed from: k0, reason: collision with root package name */
        public static SparseIntArray f11751k0;

        /* renamed from: c, reason: collision with root package name */
        public int f11782c;

        /* renamed from: d, reason: collision with root package name */
        public int f11784d;

        /* renamed from: e0, reason: collision with root package name */
        public int[] f11787e0;

        /* renamed from: f0, reason: collision with root package name */
        public String f11789f0;

        /* renamed from: g0, reason: collision with root package name */
        public String f11791g0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f11778a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11780b = false;

        /* renamed from: e, reason: collision with root package name */
        public int f11786e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f11788f = -1;

        /* renamed from: g, reason: collision with root package name */
        public float f11790g = -1.0f;

        /* renamed from: h, reason: collision with root package name */
        public int f11792h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f11794i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f11796j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f11798k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f11799l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f11800m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f11801n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f11802o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f11803p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f11804q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f11805r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f11806s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f11807t = -1;

        /* renamed from: u, reason: collision with root package name */
        public float f11808u = 0.5f;

        /* renamed from: v, reason: collision with root package name */
        public float f11809v = 0.5f;

        /* renamed from: w, reason: collision with root package name */
        public String f11810w = null;

        /* renamed from: x, reason: collision with root package name */
        public int f11811x = -1;

        /* renamed from: y, reason: collision with root package name */
        public int f11812y = 0;

        /* renamed from: z, reason: collision with root package name */
        public float f11813z = 0.0f;

        /* renamed from: A, reason: collision with root package name */
        public int f11752A = -1;

        /* renamed from: B, reason: collision with root package name */
        public int f11753B = -1;

        /* renamed from: C, reason: collision with root package name */
        public int f11754C = -1;

        /* renamed from: D, reason: collision with root package name */
        public int f11755D = -1;

        /* renamed from: E, reason: collision with root package name */
        public int f11756E = -1;

        /* renamed from: F, reason: collision with root package name */
        public int f11757F = -1;

        /* renamed from: G, reason: collision with root package name */
        public int f11758G = -1;

        /* renamed from: H, reason: collision with root package name */
        public int f11759H = -1;

        /* renamed from: I, reason: collision with root package name */
        public int f11760I = -1;

        /* renamed from: J, reason: collision with root package name */
        public int f11761J = -1;

        /* renamed from: K, reason: collision with root package name */
        public int f11762K = -1;

        /* renamed from: L, reason: collision with root package name */
        public int f11763L = -1;

        /* renamed from: M, reason: collision with root package name */
        public int f11764M = -1;

        /* renamed from: N, reason: collision with root package name */
        public int f11765N = -1;

        /* renamed from: O, reason: collision with root package name */
        public int f11766O = -1;

        /* renamed from: P, reason: collision with root package name */
        public float f11767P = -1.0f;

        /* renamed from: Q, reason: collision with root package name */
        public float f11768Q = -1.0f;

        /* renamed from: R, reason: collision with root package name */
        public int f11769R = 0;

        /* renamed from: S, reason: collision with root package name */
        public int f11770S = 0;

        /* renamed from: T, reason: collision with root package name */
        public int f11771T = 0;

        /* renamed from: U, reason: collision with root package name */
        public int f11772U = 0;

        /* renamed from: V, reason: collision with root package name */
        public int f11773V = -1;

        /* renamed from: W, reason: collision with root package name */
        public int f11774W = -1;

        /* renamed from: X, reason: collision with root package name */
        public int f11775X = -1;

        /* renamed from: Y, reason: collision with root package name */
        public int f11776Y = -1;

        /* renamed from: Z, reason: collision with root package name */
        public float f11777Z = 1.0f;

        /* renamed from: a0, reason: collision with root package name */
        public float f11779a0 = 1.0f;

        /* renamed from: b0, reason: collision with root package name */
        public int f11781b0 = -1;

        /* renamed from: c0, reason: collision with root package name */
        public int f11783c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f11785d0 = -1;

        /* renamed from: h0, reason: collision with root package name */
        public boolean f11793h0 = false;

        /* renamed from: i0, reason: collision with root package name */
        public boolean f11795i0 = false;

        /* renamed from: j0, reason: collision with root package name */
        public boolean f11797j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f11751k0 = sparseIntArray;
            sparseIntArray.append(G.d.f3061q3, 24);
            f11751k0.append(G.d.f3067r3, 25);
            f11751k0.append(G.d.f3079t3, 28);
            f11751k0.append(G.d.f3085u3, 29);
            f11751k0.append(G.d.f3115z3, 35);
            f11751k0.append(G.d.f3109y3, 34);
            f11751k0.append(G.d.f2971b3, 4);
            f11751k0.append(G.d.f2965a3, 3);
            f11751k0.append(G.d.f2954Y2, 1);
            f11751k0.append(G.d.f2838E3, 6);
            f11751k0.append(G.d.f2844F3, 7);
            f11751k0.append(G.d.f3013i3, 17);
            f11751k0.append(G.d.f3019j3, 18);
            f11751k0.append(G.d.f3025k3, 19);
            f11751k0.append(G.d.f2867J2, 26);
            f11751k0.append(G.d.f3091v3, 31);
            f11751k0.append(G.d.f3097w3, 32);
            f11751k0.append(G.d.f3007h3, 10);
            f11751k0.append(G.d.f3001g3, 9);
            f11751k0.append(G.d.f2862I3, 13);
            f11751k0.append(G.d.f2880L3, 16);
            f11751k0.append(G.d.f2868J3, 14);
            f11751k0.append(G.d.f2850G3, 11);
            f11751k0.append(G.d.f2874K3, 15);
            f11751k0.append(G.d.f2856H3, 12);
            f11751k0.append(G.d.f2826C3, 38);
            f11751k0.append(G.d.f3049o3, 37);
            f11751k0.append(G.d.f3043n3, 39);
            f11751k0.append(G.d.f2820B3, 40);
            f11751k0.append(G.d.f3037m3, 20);
            f11751k0.append(G.d.f2814A3, 36);
            f11751k0.append(G.d.f2995f3, 5);
            f11751k0.append(G.d.f3055p3, 76);
            f11751k0.append(G.d.f3103x3, 76);
            f11751k0.append(G.d.f3073s3, 76);
            f11751k0.append(G.d.f2959Z2, 76);
            f11751k0.append(G.d.f2949X2, 76);
            f11751k0.append(G.d.f2885M2, 23);
            f11751k0.append(G.d.f2897O2, 27);
            f11751k0.append(G.d.f2909Q2, 30);
            f11751k0.append(G.d.f2915R2, 8);
            f11751k0.append(G.d.f2891N2, 33);
            f11751k0.append(G.d.f2903P2, 2);
            f11751k0.append(G.d.f2873K2, 22);
            f11751k0.append(G.d.f2879L2, 21);
            f11751k0.append(G.d.f2977c3, 61);
            f11751k0.append(G.d.f2989e3, 62);
            f11751k0.append(G.d.f2983d3, 63);
            f11751k0.append(G.d.f2832D3, 69);
            f11751k0.append(G.d.f3031l3, 70);
            f11751k0.append(G.d.f2939V2, 71);
            f11751k0.append(G.d.f2927T2, 72);
            f11751k0.append(G.d.f2933U2, 73);
            f11751k0.append(G.d.f2944W2, 74);
            f11751k0.append(G.d.f2921S2, 75);
        }

        public void a(b bVar) {
            this.f11778a = bVar.f11778a;
            this.f11782c = bVar.f11782c;
            this.f11780b = bVar.f11780b;
            this.f11784d = bVar.f11784d;
            this.f11786e = bVar.f11786e;
            this.f11788f = bVar.f11788f;
            this.f11790g = bVar.f11790g;
            this.f11792h = bVar.f11792h;
            this.f11794i = bVar.f11794i;
            this.f11796j = bVar.f11796j;
            this.f11798k = bVar.f11798k;
            this.f11799l = bVar.f11799l;
            this.f11800m = bVar.f11800m;
            this.f11801n = bVar.f11801n;
            this.f11802o = bVar.f11802o;
            this.f11803p = bVar.f11803p;
            this.f11804q = bVar.f11804q;
            this.f11805r = bVar.f11805r;
            this.f11806s = bVar.f11806s;
            this.f11807t = bVar.f11807t;
            this.f11808u = bVar.f11808u;
            this.f11809v = bVar.f11809v;
            this.f11810w = bVar.f11810w;
            this.f11811x = bVar.f11811x;
            this.f11812y = bVar.f11812y;
            this.f11813z = bVar.f11813z;
            this.f11752A = bVar.f11752A;
            this.f11753B = bVar.f11753B;
            this.f11754C = bVar.f11754C;
            this.f11755D = bVar.f11755D;
            this.f11756E = bVar.f11756E;
            this.f11757F = bVar.f11757F;
            this.f11758G = bVar.f11758G;
            this.f11759H = bVar.f11759H;
            this.f11760I = bVar.f11760I;
            this.f11761J = bVar.f11761J;
            this.f11762K = bVar.f11762K;
            this.f11763L = bVar.f11763L;
            this.f11764M = bVar.f11764M;
            this.f11765N = bVar.f11765N;
            this.f11766O = bVar.f11766O;
            this.f11767P = bVar.f11767P;
            this.f11768Q = bVar.f11768Q;
            this.f11769R = bVar.f11769R;
            this.f11770S = bVar.f11770S;
            this.f11771T = bVar.f11771T;
            this.f11772U = bVar.f11772U;
            this.f11773V = bVar.f11773V;
            this.f11774W = bVar.f11774W;
            this.f11775X = bVar.f11775X;
            this.f11776Y = bVar.f11776Y;
            this.f11777Z = bVar.f11777Z;
            this.f11779a0 = bVar.f11779a0;
            this.f11781b0 = bVar.f11781b0;
            this.f11783c0 = bVar.f11783c0;
            this.f11785d0 = bVar.f11785d0;
            this.f11791g0 = bVar.f11791g0;
            int[] iArr = bVar.f11787e0;
            if (iArr != null) {
                this.f11787e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f11787e0 = null;
            }
            this.f11789f0 = bVar.f11789f0;
            this.f11793h0 = bVar.f11793h0;
            this.f11795i0 = bVar.f11795i0;
            this.f11797j0 = bVar.f11797j0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G.d.f2861I2);
            this.f11780b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                int i8 = f11751k0.get(index);
                if (i8 == 80) {
                    this.f11793h0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f11793h0);
                } else if (i8 != 81) {
                    switch (i8) {
                        case 1:
                            this.f11803p = c.n(typedArrayObtainStyledAttributes, index, this.f11803p);
                            break;
                        case 2:
                            this.f11758G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11758G);
                            break;
                        case 3:
                            this.f11802o = c.n(typedArrayObtainStyledAttributes, index, this.f11802o);
                            break;
                        case 4:
                            this.f11801n = c.n(typedArrayObtainStyledAttributes, index, this.f11801n);
                            break;
                        case 5:
                            this.f11810w = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.f11752A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11752A);
                            break;
                        case 7:
                            this.f11753B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11753B);
                            break;
                        case 8:
                            this.f11759H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11759H);
                            break;
                        case 9:
                            this.f11807t = c.n(typedArrayObtainStyledAttributes, index, this.f11807t);
                            break;
                        case 10:
                            this.f11806s = c.n(typedArrayObtainStyledAttributes, index, this.f11806s);
                            break;
                        case 11:
                            this.f11764M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11764M);
                            break;
                        case 12:
                            this.f11765N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11765N);
                            break;
                        case 13:
                            this.f11761J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11761J);
                            break;
                        case StdKeyDeserializer.TYPE_URL /* 14 */:
                            this.f11763L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11763L);
                            break;
                        case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                            this.f11766O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11766O);
                            break;
                        case 16:
                            this.f11762K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11762K);
                            break;
                        case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                            this.f11786e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11786e);
                            break;
                        case 18:
                            this.f11788f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f11788f);
                            break;
                        case 19:
                            this.f11790g = typedArrayObtainStyledAttributes.getFloat(index, this.f11790g);
                            break;
                        case 20:
                            this.f11808u = typedArrayObtainStyledAttributes.getFloat(index, this.f11808u);
                            break;
                        case 21:
                            this.f11784d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f11784d);
                            break;
                        case 22:
                            this.f11782c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f11782c);
                            break;
                        case 23:
                            this.f11755D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11755D);
                            break;
                        case 24:
                            this.f11792h = c.n(typedArrayObtainStyledAttributes, index, this.f11792h);
                            break;
                        case 25:
                            this.f11794i = c.n(typedArrayObtainStyledAttributes, index, this.f11794i);
                            break;
                        case 26:
                            this.f11754C = typedArrayObtainStyledAttributes.getInt(index, this.f11754C);
                            break;
                        case 27:
                            this.f11756E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11756E);
                            break;
                        case 28:
                            this.f11796j = c.n(typedArrayObtainStyledAttributes, index, this.f11796j);
                            break;
                        case 29:
                            this.f11798k = c.n(typedArrayObtainStyledAttributes, index, this.f11798k);
                            break;
                        case 30:
                            this.f11760I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11760I);
                            break;
                        case 31:
                            this.f11804q = c.n(typedArrayObtainStyledAttributes, index, this.f11804q);
                            break;
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                            this.f11805r = c.n(typedArrayObtainStyledAttributes, index, this.f11805r);
                            break;
                        case CharsToNameCanonicalizer.HASH_MULT /* 33 */:
                            this.f11757F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11757F);
                            break;
                        case 34:
                            this.f11800m = c.n(typedArrayObtainStyledAttributes, index, this.f11800m);
                            break;
                        case 35:
                            this.f11799l = c.n(typedArrayObtainStyledAttributes, index, this.f11799l);
                            break;
                        case 36:
                            this.f11809v = typedArrayObtainStyledAttributes.getFloat(index, this.f11809v);
                            break;
                        case 37:
                            this.f11768Q = typedArrayObtainStyledAttributes.getFloat(index, this.f11768Q);
                            break;
                        case 38:
                            this.f11767P = typedArrayObtainStyledAttributes.getFloat(index, this.f11767P);
                            break;
                        case 39:
                            this.f11769R = typedArrayObtainStyledAttributes.getInt(index, this.f11769R);
                            break;
                        case 40:
                            this.f11770S = typedArrayObtainStyledAttributes.getInt(index, this.f11770S);
                            break;
                        default:
                            switch (i8) {
                                case 54:
                                    this.f11771T = typedArrayObtainStyledAttributes.getInt(index, this.f11771T);
                                    break;
                                case 55:
                                    this.f11772U = typedArrayObtainStyledAttributes.getInt(index, this.f11772U);
                                    break;
                                case 56:
                                    this.f11773V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11773V);
                                    break;
                                case 57:
                                    this.f11774W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11774W);
                                    break;
                                case 58:
                                    this.f11775X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11775X);
                                    break;
                                case 59:
                                    this.f11776Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11776Y);
                                    break;
                                default:
                                    switch (i8) {
                                        case 61:
                                            this.f11811x = c.n(typedArrayObtainStyledAttributes, index, this.f11811x);
                                            break;
                                        case 62:
                                            this.f11812y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11812y);
                                            break;
                                        case 63:
                                            this.f11813z = typedArrayObtainStyledAttributes.getFloat(index, this.f11813z);
                                            break;
                                        default:
                                            switch (i8) {
                                                case 69:
                                                    this.f11777Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f11779a0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.f11781b0 = typedArrayObtainStyledAttributes.getInt(index, this.f11781b0);
                                                    break;
                                                case 73:
                                                    this.f11783c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f11783c0);
                                                    break;
                                                case 74:
                                                    this.f11789f0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f11797j0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f11797j0);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f11751k0.get(index));
                                                    break;
                                                case 77:
                                                    this.f11791g0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f11751k0.get(index));
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    this.f11795i0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f11795i0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c, reason: collision with other inner class name */
    public static class C0101c {

        /* renamed from: h, reason: collision with root package name */
        public static SparseIntArray f11814h;

        /* renamed from: a, reason: collision with root package name */
        public boolean f11815a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f11816b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f11817c = null;

        /* renamed from: d, reason: collision with root package name */
        public int f11818d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f11819e = 0;

        /* renamed from: f, reason: collision with root package name */
        public float f11820f = Float.NaN;

        /* renamed from: g, reason: collision with root package name */
        public float f11821g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f11814h = sparseIntArray;
            sparseIntArray.append(G.d.f2945W3, 1);
            f11814h.append(G.d.f2955Y3, 2);
            f11814h.append(G.d.f2960Z3, 3);
            f11814h.append(G.d.f2940V3, 4);
            f11814h.append(G.d.f2934U3, 5);
            f11814h.append(G.d.f2950X3, 6);
        }

        public void a(C0101c c0101c) {
            this.f11815a = c0101c.f11815a;
            this.f11816b = c0101c.f11816b;
            this.f11817c = c0101c.f11817c;
            this.f11818d = c0101c.f11818d;
            this.f11819e = c0101c.f11819e;
            this.f11821g = c0101c.f11821g;
            this.f11820f = c0101c.f11820f;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G.d.f2928T3);
            this.f11815a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (f11814h.get(index)) {
                    case 1:
                        this.f11821g = typedArrayObtainStyledAttributes.getFloat(index, this.f11821g);
                        break;
                    case 2:
                        this.f11818d = typedArrayObtainStyledAttributes.getInt(index, this.f11818d);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f11817c = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f11817c = B.a.f324c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f11819e = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f11816b = c.n(typedArrayObtainStyledAttributes, index, this.f11816b);
                        break;
                    case 6:
                        this.f11820f = typedArrayObtainStyledAttributes.getFloat(index, this.f11820f);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11822a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f11823b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f11824c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f11825d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f11826e = Float.NaN;

        public void a(d dVar) {
            this.f11822a = dVar.f11822a;
            this.f11823b = dVar.f11823b;
            this.f11825d = dVar.f11825d;
            this.f11826e = dVar.f11826e;
            this.f11824c = dVar.f11824c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G.d.f3014i4);
            this.f11822a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == G.d.f3026k4) {
                    this.f11825d = typedArrayObtainStyledAttributes.getFloat(index, this.f11825d);
                } else if (index == G.d.f3020j4) {
                    this.f11823b = typedArrayObtainStyledAttributes.getInt(index, this.f11823b);
                    this.f11823b = c.f11740d[this.f11823b];
                } else if (index == G.d.f3038m4) {
                    this.f11824c = typedArrayObtainStyledAttributes.getInt(index, this.f11824c);
                } else if (index == G.d.f3032l4) {
                    this.f11826e = typedArrayObtainStyledAttributes.getFloat(index, this.f11826e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: n, reason: collision with root package name */
        public static SparseIntArray f11827n;

        /* renamed from: a, reason: collision with root package name */
        public boolean f11828a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f11829b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f11830c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f11831d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f11832e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f11833f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f11834g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f11835h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public float f11836i = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        public float f11837j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f11838k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public boolean f11839l = false;

        /* renamed from: m, reason: collision with root package name */
        public float f11840m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f11827n = sparseIntArray;
            sparseIntArray.append(G.d.f2851G4, 1);
            f11827n.append(G.d.f2857H4, 2);
            f11827n.append(G.d.f2863I4, 3);
            f11827n.append(G.d.f2839E4, 4);
            f11827n.append(G.d.f2845F4, 5);
            f11827n.append(G.d.f2815A4, 6);
            f11827n.append(G.d.f2821B4, 7);
            f11827n.append(G.d.f2827C4, 8);
            f11827n.append(G.d.f2833D4, 9);
            f11827n.append(G.d.f2869J4, 10);
            f11827n.append(G.d.f2875K4, 11);
        }

        public void a(e eVar) {
            this.f11828a = eVar.f11828a;
            this.f11829b = eVar.f11829b;
            this.f11830c = eVar.f11830c;
            this.f11831d = eVar.f11831d;
            this.f11832e = eVar.f11832e;
            this.f11833f = eVar.f11833f;
            this.f11834g = eVar.f11834g;
            this.f11835h = eVar.f11835h;
            this.f11836i = eVar.f11836i;
            this.f11837j = eVar.f11837j;
            this.f11838k = eVar.f11838k;
            this.f11839l = eVar.f11839l;
            this.f11840m = eVar.f11840m;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G.d.f3116z4);
            this.f11828a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (f11827n.get(index)) {
                    case 1:
                        this.f11829b = typedArrayObtainStyledAttributes.getFloat(index, this.f11829b);
                        break;
                    case 2:
                        this.f11830c = typedArrayObtainStyledAttributes.getFloat(index, this.f11830c);
                        break;
                    case 3:
                        this.f11831d = typedArrayObtainStyledAttributes.getFloat(index, this.f11831d);
                        break;
                    case 4:
                        this.f11832e = typedArrayObtainStyledAttributes.getFloat(index, this.f11832e);
                        break;
                    case 5:
                        this.f11833f = typedArrayObtainStyledAttributes.getFloat(index, this.f11833f);
                        break;
                    case 6:
                        this.f11834g = typedArrayObtainStyledAttributes.getDimension(index, this.f11834g);
                        break;
                    case 7:
                        this.f11835h = typedArrayObtainStyledAttributes.getDimension(index, this.f11835h);
                        break;
                    case 8:
                        this.f11836i = typedArrayObtainStyledAttributes.getDimension(index, this.f11836i);
                        break;
                    case 9:
                        this.f11837j = typedArrayObtainStyledAttributes.getDimension(index, this.f11837j);
                        break;
                    case 10:
                        this.f11838k = typedArrayObtainStyledAttributes.getDimension(index, this.f11838k);
                        break;
                    case 11:
                        this.f11839l = true;
                        this.f11840m = typedArrayObtainStyledAttributes.getDimension(index, this.f11840m);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11741e = sparseIntArray;
        sparseIntArray.append(G.d.f3082u0, 25);
        f11741e.append(G.d.f3088v0, 26);
        f11741e.append(G.d.f3100x0, 29);
        f11741e.append(G.d.f3106y0, 30);
        f11741e.append(G.d.f2835E0, 36);
        f11741e.append(G.d.f2829D0, 35);
        f11741e.append(G.d.f2974c0, 4);
        f11741e.append(G.d.f2968b0, 3);
        f11741e.append(G.d.f2956Z, 1);
        f11741e.append(G.d.f2883M0, 6);
        f11741e.append(G.d.f2889N0, 7);
        f11741e.append(G.d.f3016j0, 17);
        f11741e.append(G.d.f3022k0, 18);
        f11741e.append(G.d.f3028l0, 19);
        f11741e.append(G.d.f3069s, 27);
        f11741e.append(G.d.f3112z0, 32);
        f11741e.append(G.d.f2811A0, 33);
        f11741e.append(G.d.f3010i0, 10);
        f11741e.append(G.d.f3004h0, 9);
        f11741e.append(G.d.f2907Q0, 13);
        f11741e.append(G.d.f2925T0, 16);
        f11741e.append(G.d.f2913R0, 14);
        f11741e.append(G.d.f2895O0, 11);
        f11741e.append(G.d.f2919S0, 15);
        f11741e.append(G.d.f2901P0, 12);
        f11741e.append(G.d.f2853H0, 40);
        f11741e.append(G.d.f3070s0, 39);
        f11741e.append(G.d.f3064r0, 41);
        f11741e.append(G.d.f2847G0, 42);
        f11741e.append(G.d.f3058q0, 20);
        f11741e.append(G.d.f2841F0, 37);
        f11741e.append(G.d.f2998g0, 5);
        f11741e.append(G.d.f3076t0, 82);
        f11741e.append(G.d.f2823C0, 82);
        f11741e.append(G.d.f3094w0, 82);
        f11741e.append(G.d.f2962a0, 82);
        f11741e.append(G.d.f2951Y, 82);
        f11741e.append(G.d.f3099x, 24);
        f11741e.append(G.d.f3111z, 28);
        f11741e.append(G.d.f2876L, 31);
        f11741e.append(G.d.f2882M, 8);
        f11741e.append(G.d.f3105y, 34);
        f11741e.append(G.d.f2810A, 2);
        f11741e.append(G.d.f3087v, 23);
        f11741e.append(G.d.f3093w, 21);
        f11741e.append(G.d.f3081u, 22);
        f11741e.append(G.d.f2816B, 43);
        f11741e.append(G.d.f2894O, 44);
        f11741e.append(G.d.f2864J, 45);
        f11741e.append(G.d.f2870K, 46);
        f11741e.append(G.d.f2858I, 60);
        f11741e.append(G.d.f2846G, 47);
        f11741e.append(G.d.f2852H, 48);
        f11741e.append(G.d.f2822C, 49);
        f11741e.append(G.d.f2828D, 50);
        f11741e.append(G.d.f2834E, 51);
        f11741e.append(G.d.f2840F, 52);
        f11741e.append(G.d.f2888N, 53);
        f11741e.append(G.d.f2859I0, 54);
        f11741e.append(G.d.f3034m0, 55);
        f11741e.append(G.d.f2865J0, 56);
        f11741e.append(G.d.f3040n0, 57);
        f11741e.append(G.d.f2871K0, 58);
        f11741e.append(G.d.f3046o0, 59);
        f11741e.append(G.d.f2980d0, 61);
        f11741e.append(G.d.f2992f0, 62);
        f11741e.append(G.d.f2986e0, 63);
        f11741e.append(G.d.f2900P, 64);
        f11741e.append(G.d.f2947X0, 65);
        f11741e.append(G.d.f2936V, 66);
        f11741e.append(G.d.f2952Y0, 67);
        f11741e.append(G.d.f2937V0, 79);
        f11741e.append(G.d.f3075t, 38);
        f11741e.append(G.d.f2931U0, 68);
        f11741e.append(G.d.f2877L0, 69);
        f11741e.append(G.d.f3052p0, 70);
        f11741e.append(G.d.f2924T, 71);
        f11741e.append(G.d.f2912R, 72);
        f11741e.append(G.d.f2918S, 73);
        f11741e.append(G.d.f2930U, 74);
        f11741e.append(G.d.f2906Q, 75);
        f11741e.append(G.d.f2942W0, 76);
        f11741e.append(G.d.f2817B0, 77);
        f11741e.append(G.d.f2957Z0, 78);
        f11741e.append(G.d.f2946X, 80);
        f11741e.append(G.d.f2941W, 81);
    }

    public static int n(TypedArray typedArray, int i7, int i8) {
        int resourceId = typedArray.getResourceId(i7, i8);
        return resourceId == -1 ? typedArray.getInt(i7, -1) : resourceId;
    }

    public void c(ConstraintLayout constraintLayout) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void d(ConstraintLayout constraintLayout, boolean z7) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f11744c.keySet());
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            int id = childAt.getId();
            if (!this.f11744c.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + C.a.a(childAt));
            } else {
                if (this.f11743b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f11744c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f11744c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f11748d.f11785d0 = 1;
                        }
                        int i8 = aVar.f11748d.f11785d0;
                        if (i8 != -1 && i8 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f11748d.f11781b0);
                            barrier.setMargin(aVar.f11748d.f11783c0);
                            barrier.setAllowsGoneWidget(aVar.f11748d.f11797j0);
                            b bVar = aVar.f11748d;
                            int[] iArr = bVar.f11787e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f11789f0;
                                if (str != null) {
                                    bVar.f11787e0 = i(barrier, str);
                                    barrier.setReferencedIds(aVar.f11748d.f11787e0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.b(bVar2);
                        if (z7) {
                            androidx.constraintlayout.widget.a.c(childAt, aVar.f11750f);
                        }
                        childAt.setLayoutParams(bVar2);
                        d dVar = aVar.f11746b;
                        if (dVar.f11824c == 0) {
                            childAt.setVisibility(dVar.f11823b);
                        }
                        childAt.setAlpha(aVar.f11746b.f11825d);
                        childAt.setRotation(aVar.f11749e.f11829b);
                        childAt.setRotationX(aVar.f11749e.f11830c);
                        childAt.setRotationY(aVar.f11749e.f11831d);
                        childAt.setScaleX(aVar.f11749e.f11832e);
                        childAt.setScaleY(aVar.f11749e.f11833f);
                        if (!Float.isNaN(aVar.f11749e.f11834g)) {
                            childAt.setPivotX(aVar.f11749e.f11834g);
                        }
                        if (!Float.isNaN(aVar.f11749e.f11835h)) {
                            childAt.setPivotY(aVar.f11749e.f11835h);
                        }
                        childAt.setTranslationX(aVar.f11749e.f11836i);
                        childAt.setTranslationY(aVar.f11749e.f11837j);
                        childAt.setTranslationZ(aVar.f11749e.f11838k);
                        e eVar = aVar.f11749e;
                        if (eVar.f11839l) {
                            childAt.setElevation(eVar.f11840m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.f11744c.get(num);
            int i9 = aVar2.f11748d.f11785d0;
            if (i9 != -1 && i9 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f11748d;
                int[] iArr2 = bVar3.f11787e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.f11789f0;
                    if (str2 != null) {
                        bVar3.f11787e0 = i(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f11748d.f11787e0);
                    }
                }
                barrier2.setType(aVar2.f11748d.f11781b0);
                barrier2.setMargin(aVar2.f11748d.f11783c0);
                ConstraintLayout.b bVarD = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar2.b(bVarD);
                constraintLayout.addView(barrier2, bVarD);
            }
            if (aVar2.f11748d.f11778a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b bVarD2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.b(bVarD2);
                constraintLayout.addView(guideline, bVarD2);
            }
        }
    }

    public void e(int i7, int i8) {
        if (this.f11744c.containsKey(Integer.valueOf(i7))) {
            a aVar = (a) this.f11744c.get(Integer.valueOf(i7));
            switch (i8) {
                case 1:
                    b bVar = aVar.f11748d;
                    bVar.f11794i = -1;
                    bVar.f11792h = -1;
                    bVar.f11755D = -1;
                    bVar.f11761J = -1;
                    return;
                case 2:
                    b bVar2 = aVar.f11748d;
                    bVar2.f11798k = -1;
                    bVar2.f11796j = -1;
                    bVar2.f11756E = -1;
                    bVar2.f11763L = -1;
                    return;
                case 3:
                    b bVar3 = aVar.f11748d;
                    bVar3.f11800m = -1;
                    bVar3.f11799l = -1;
                    bVar3.f11757F = -1;
                    bVar3.f11762K = -1;
                    return;
                case 4:
                    b bVar4 = aVar.f11748d;
                    bVar4.f11801n = -1;
                    bVar4.f11802o = -1;
                    bVar4.f11758G = -1;
                    bVar4.f11764M = -1;
                    return;
                case 5:
                    aVar.f11748d.f11803p = -1;
                    return;
                case 6:
                    b bVar5 = aVar.f11748d;
                    bVar5.f11804q = -1;
                    bVar5.f11805r = -1;
                    bVar5.f11760I = -1;
                    bVar5.f11766O = -1;
                    return;
                case 7:
                    b bVar6 = aVar.f11748d;
                    bVar6.f11806s = -1;
                    bVar6.f11807t = -1;
                    bVar6.f11759H = -1;
                    bVar6.f11765N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void f(Context context, int i7) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i7, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f11744c.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f11743b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f11744c.containsKey(Integer.valueOf(id))) {
                this.f11744c.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f11744c.get(Integer.valueOf(id));
            aVar.f11750f = androidx.constraintlayout.widget.a.a(this.f11742a, childAt);
            aVar.d(id, bVar);
            aVar.f11746b.f11823b = childAt.getVisibility();
            aVar.f11746b.f11825d = childAt.getAlpha();
            aVar.f11749e.f11829b = childAt.getRotation();
            aVar.f11749e.f11830c = childAt.getRotationX();
            aVar.f11749e.f11831d = childAt.getRotationY();
            aVar.f11749e.f11832e = childAt.getScaleX();
            aVar.f11749e.f11833f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                e eVar = aVar.f11749e;
                eVar.f11834g = pivotX;
                eVar.f11835h = pivotY;
            }
            aVar.f11749e.f11836i = childAt.getTranslationX();
            aVar.f11749e.f11837j = childAt.getTranslationY();
            aVar.f11749e.f11838k = childAt.getTranslationZ();
            e eVar2 = aVar.f11749e;
            if (eVar2.f11839l) {
                eVar2.f11840m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f11748d.f11797j0 = barrier.l();
                aVar.f11748d.f11787e0 = barrier.getReferencedIds();
                aVar.f11748d.f11781b0 = barrier.getType();
                aVar.f11748d.f11783c0 = barrier.getMargin();
            }
        }
    }

    public void h(int i7, int i8, int i9, float f7) {
        b bVar = k(i7).f11748d;
        bVar.f11811x = i8;
        bVar.f11812y = i9;
        bVar.f11813z = f7;
    }

    public final int[] i(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objF;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i7 = 0;
        int i8 = 0;
        while (i7 < strArrSplit.length) {
            String strTrim = strArrSplit[i7].trim();
            try {
                iIntValue = G.c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objF = ((ConstraintLayout) view.getParent()).f(0, strTrim)) != null && (objF instanceof Integer)) {
                iIntValue = ((Integer) objF).intValue();
            }
            iArr[i8] = iIntValue;
            i7++;
            i8++;
        }
        return i8 != strArrSplit.length ? Arrays.copyOf(iArr, i8) : iArr;
    }

    public final a j(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G.d.f3063r);
        o(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public final a k(int i7) {
        if (!this.f11744c.containsKey(Integer.valueOf(i7))) {
            this.f11744c.put(Integer.valueOf(i7), new a());
        }
        return (a) this.f11744c.get(Integer.valueOf(i7));
    }

    public void l(Context context, int i7) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i7);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarJ = j(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarJ.f11748d.f11778a = true;
                    }
                    this.f11744c.put(Integer.valueOf(aVarJ.f11745a), aVarJ);
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        } catch (XmlPullParserException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x017e, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.m(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void o(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArray.getIndex(i7);
            if (index != G.d.f3075t && G.d.f2876L != index && G.d.f2882M != index) {
                aVar.f11747c.f11815a = true;
                aVar.f11748d.f11780b = true;
                aVar.f11746b.f11822a = true;
                aVar.f11749e.f11828a = true;
            }
            switch (f11741e.get(index)) {
                case 1:
                    b bVar = aVar.f11748d;
                    bVar.f11803p = n(typedArray, index, bVar.f11803p);
                    break;
                case 2:
                    b bVar2 = aVar.f11748d;
                    bVar2.f11758G = typedArray.getDimensionPixelSize(index, bVar2.f11758G);
                    break;
                case 3:
                    b bVar3 = aVar.f11748d;
                    bVar3.f11802o = n(typedArray, index, bVar3.f11802o);
                    break;
                case 4:
                    b bVar4 = aVar.f11748d;
                    bVar4.f11801n = n(typedArray, index, bVar4.f11801n);
                    break;
                case 5:
                    aVar.f11748d.f11810w = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f11748d;
                    bVar5.f11752A = typedArray.getDimensionPixelOffset(index, bVar5.f11752A);
                    break;
                case 7:
                    b bVar6 = aVar.f11748d;
                    bVar6.f11753B = typedArray.getDimensionPixelOffset(index, bVar6.f11753B);
                    break;
                case 8:
                    b bVar7 = aVar.f11748d;
                    bVar7.f11759H = typedArray.getDimensionPixelSize(index, bVar7.f11759H);
                    break;
                case 9:
                    b bVar8 = aVar.f11748d;
                    bVar8.f11807t = n(typedArray, index, bVar8.f11807t);
                    break;
                case 10:
                    b bVar9 = aVar.f11748d;
                    bVar9.f11806s = n(typedArray, index, bVar9.f11806s);
                    break;
                case 11:
                    b bVar10 = aVar.f11748d;
                    bVar10.f11764M = typedArray.getDimensionPixelSize(index, bVar10.f11764M);
                    break;
                case 12:
                    b bVar11 = aVar.f11748d;
                    bVar11.f11765N = typedArray.getDimensionPixelSize(index, bVar11.f11765N);
                    break;
                case 13:
                    b bVar12 = aVar.f11748d;
                    bVar12.f11761J = typedArray.getDimensionPixelSize(index, bVar12.f11761J);
                    break;
                case StdKeyDeserializer.TYPE_URL /* 14 */:
                    b bVar13 = aVar.f11748d;
                    bVar13.f11763L = typedArray.getDimensionPixelSize(index, bVar13.f11763L);
                    break;
                case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                    b bVar14 = aVar.f11748d;
                    bVar14.f11766O = typedArray.getDimensionPixelSize(index, bVar14.f11766O);
                    break;
                case 16:
                    b bVar15 = aVar.f11748d;
                    bVar15.f11762K = typedArray.getDimensionPixelSize(index, bVar15.f11762K);
                    break;
                case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                    b bVar16 = aVar.f11748d;
                    bVar16.f11786e = typedArray.getDimensionPixelOffset(index, bVar16.f11786e);
                    break;
                case 18:
                    b bVar17 = aVar.f11748d;
                    bVar17.f11788f = typedArray.getDimensionPixelOffset(index, bVar17.f11788f);
                    break;
                case 19:
                    b bVar18 = aVar.f11748d;
                    bVar18.f11790g = typedArray.getFloat(index, bVar18.f11790g);
                    break;
                case 20:
                    b bVar19 = aVar.f11748d;
                    bVar19.f11808u = typedArray.getFloat(index, bVar19.f11808u);
                    break;
                case 21:
                    b bVar20 = aVar.f11748d;
                    bVar20.f11784d = typedArray.getLayoutDimension(index, bVar20.f11784d);
                    break;
                case 22:
                    d dVar = aVar.f11746b;
                    dVar.f11823b = typedArray.getInt(index, dVar.f11823b);
                    d dVar2 = aVar.f11746b;
                    dVar2.f11823b = f11740d[dVar2.f11823b];
                    break;
                case 23:
                    b bVar21 = aVar.f11748d;
                    bVar21.f11782c = typedArray.getLayoutDimension(index, bVar21.f11782c);
                    break;
                case 24:
                    b bVar22 = aVar.f11748d;
                    bVar22.f11755D = typedArray.getDimensionPixelSize(index, bVar22.f11755D);
                    break;
                case 25:
                    b bVar23 = aVar.f11748d;
                    bVar23.f11792h = n(typedArray, index, bVar23.f11792h);
                    break;
                case 26:
                    b bVar24 = aVar.f11748d;
                    bVar24.f11794i = n(typedArray, index, bVar24.f11794i);
                    break;
                case 27:
                    b bVar25 = aVar.f11748d;
                    bVar25.f11754C = typedArray.getInt(index, bVar25.f11754C);
                    break;
                case 28:
                    b bVar26 = aVar.f11748d;
                    bVar26.f11756E = typedArray.getDimensionPixelSize(index, bVar26.f11756E);
                    break;
                case 29:
                    b bVar27 = aVar.f11748d;
                    bVar27.f11796j = n(typedArray, index, bVar27.f11796j);
                    break;
                case 30:
                    b bVar28 = aVar.f11748d;
                    bVar28.f11798k = n(typedArray, index, bVar28.f11798k);
                    break;
                case 31:
                    b bVar29 = aVar.f11748d;
                    bVar29.f11760I = typedArray.getDimensionPixelSize(index, bVar29.f11760I);
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                    b bVar30 = aVar.f11748d;
                    bVar30.f11804q = n(typedArray, index, bVar30.f11804q);
                    break;
                case CharsToNameCanonicalizer.HASH_MULT /* 33 */:
                    b bVar31 = aVar.f11748d;
                    bVar31.f11805r = n(typedArray, index, bVar31.f11805r);
                    break;
                case 34:
                    b bVar32 = aVar.f11748d;
                    bVar32.f11757F = typedArray.getDimensionPixelSize(index, bVar32.f11757F);
                    break;
                case 35:
                    b bVar33 = aVar.f11748d;
                    bVar33.f11800m = n(typedArray, index, bVar33.f11800m);
                    break;
                case 36:
                    b bVar34 = aVar.f11748d;
                    bVar34.f11799l = n(typedArray, index, bVar34.f11799l);
                    break;
                case 37:
                    b bVar35 = aVar.f11748d;
                    bVar35.f11809v = typedArray.getFloat(index, bVar35.f11809v);
                    break;
                case 38:
                    aVar.f11745a = typedArray.getResourceId(index, aVar.f11745a);
                    break;
                case 39:
                    b bVar36 = aVar.f11748d;
                    bVar36.f11768Q = typedArray.getFloat(index, bVar36.f11768Q);
                    break;
                case 40:
                    b bVar37 = aVar.f11748d;
                    bVar37.f11767P = typedArray.getFloat(index, bVar37.f11767P);
                    break;
                case 41:
                    b bVar38 = aVar.f11748d;
                    bVar38.f11769R = typedArray.getInt(index, bVar38.f11769R);
                    break;
                case 42:
                    b bVar39 = aVar.f11748d;
                    bVar39.f11770S = typedArray.getInt(index, bVar39.f11770S);
                    break;
                case 43:
                    d dVar3 = aVar.f11746b;
                    dVar3.f11825d = typedArray.getFloat(index, dVar3.f11825d);
                    break;
                case 44:
                    e eVar = aVar.f11749e;
                    eVar.f11839l = true;
                    eVar.f11840m = typedArray.getDimension(index, eVar.f11840m);
                    break;
                case 45:
                    e eVar2 = aVar.f11749e;
                    eVar2.f11830c = typedArray.getFloat(index, eVar2.f11830c);
                    break;
                case 46:
                    e eVar3 = aVar.f11749e;
                    eVar3.f11831d = typedArray.getFloat(index, eVar3.f11831d);
                    break;
                case 47:
                    e eVar4 = aVar.f11749e;
                    eVar4.f11832e = typedArray.getFloat(index, eVar4.f11832e);
                    break;
                case 48:
                    e eVar5 = aVar.f11749e;
                    eVar5.f11833f = typedArray.getFloat(index, eVar5.f11833f);
                    break;
                case 49:
                    e eVar6 = aVar.f11749e;
                    eVar6.f11834g = typedArray.getDimension(index, eVar6.f11834g);
                    break;
                case 50:
                    e eVar7 = aVar.f11749e;
                    eVar7.f11835h = typedArray.getDimension(index, eVar7.f11835h);
                    break;
                case 51:
                    e eVar8 = aVar.f11749e;
                    eVar8.f11836i = typedArray.getDimension(index, eVar8.f11836i);
                    break;
                case 52:
                    e eVar9 = aVar.f11749e;
                    eVar9.f11837j = typedArray.getDimension(index, eVar9.f11837j);
                    break;
                case 53:
                    e eVar10 = aVar.f11749e;
                    eVar10.f11838k = typedArray.getDimension(index, eVar10.f11838k);
                    break;
                case 54:
                    b bVar40 = aVar.f11748d;
                    bVar40.f11771T = typedArray.getInt(index, bVar40.f11771T);
                    break;
                case 55:
                    b bVar41 = aVar.f11748d;
                    bVar41.f11772U = typedArray.getInt(index, bVar41.f11772U);
                    break;
                case 56:
                    b bVar42 = aVar.f11748d;
                    bVar42.f11773V = typedArray.getDimensionPixelSize(index, bVar42.f11773V);
                    break;
                case 57:
                    b bVar43 = aVar.f11748d;
                    bVar43.f11774W = typedArray.getDimensionPixelSize(index, bVar43.f11774W);
                    break;
                case 58:
                    b bVar44 = aVar.f11748d;
                    bVar44.f11775X = typedArray.getDimensionPixelSize(index, bVar44.f11775X);
                    break;
                case 59:
                    b bVar45 = aVar.f11748d;
                    bVar45.f11776Y = typedArray.getDimensionPixelSize(index, bVar45.f11776Y);
                    break;
                case 60:
                    e eVar11 = aVar.f11749e;
                    eVar11.f11829b = typedArray.getFloat(index, eVar11.f11829b);
                    break;
                case 61:
                    b bVar46 = aVar.f11748d;
                    bVar46.f11811x = n(typedArray, index, bVar46.f11811x);
                    break;
                case 62:
                    b bVar47 = aVar.f11748d;
                    bVar47.f11812y = typedArray.getDimensionPixelSize(index, bVar47.f11812y);
                    break;
                case 63:
                    b bVar48 = aVar.f11748d;
                    bVar48.f11813z = typedArray.getFloat(index, bVar48.f11813z);
                    break;
                case 64:
                    C0101c c0101c = aVar.f11747c;
                    c0101c.f11816b = n(typedArray, index, c0101c.f11816b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f11747c.f11817c = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f11747c.f11817c = B.a.f324c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f11747c.f11819e = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C0101c c0101c2 = aVar.f11747c;
                    c0101c2.f11821g = typedArray.getFloat(index, c0101c2.f11821g);
                    break;
                case 68:
                    d dVar4 = aVar.f11746b;
                    dVar4.f11826e = typedArray.getFloat(index, dVar4.f11826e);
                    break;
                case 69:
                    aVar.f11748d.f11777Z = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f11748d.f11779a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f11748d;
                    bVar49.f11781b0 = typedArray.getInt(index, bVar49.f11781b0);
                    break;
                case 73:
                    b bVar50 = aVar.f11748d;
                    bVar50.f11783c0 = typedArray.getDimensionPixelSize(index, bVar50.f11783c0);
                    break;
                case 74:
                    aVar.f11748d.f11789f0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f11748d;
                    bVar51.f11797j0 = typedArray.getBoolean(index, bVar51.f11797j0);
                    break;
                case 76:
                    C0101c c0101c3 = aVar.f11747c;
                    c0101c3.f11818d = typedArray.getInt(index, c0101c3.f11818d);
                    break;
                case 77:
                    aVar.f11748d.f11791g0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f11746b;
                    dVar5.f11824c = typedArray.getInt(index, dVar5.f11824c);
                    break;
                case 79:
                    C0101c c0101c4 = aVar.f11747c;
                    c0101c4.f11820f = typedArray.getFloat(index, c0101c4.f11820f);
                    break;
                case 80:
                    b bVar52 = aVar.f11748d;
                    bVar52.f11793h0 = typedArray.getBoolean(index, bVar52.f11793h0);
                    break;
                case 81:
                    b bVar53 = aVar.f11748d;
                    bVar53.f11795i0 = typedArray.getBoolean(index, bVar53.f11795i0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f11741e.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f11741e.get(index));
                    break;
            }
        }
    }
}
