package io.flutter.embedding.engine;

import X4.a;
import a5.C0765d;
import android.content.Context;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.platform.C1190w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f17587a = new ArrayList();

    public class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ io.flutter.embedding.engine.a f17588a;

        public a(io.flutter.embedding.engine.a aVar) {
            this.f17588a = aVar;
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            b.this.f17587a.remove(this.f17588a);
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
        }
    }

    /* renamed from: io.flutter.embedding.engine.b$b, reason: collision with other inner class name */
    public static class C0201b {

        /* renamed from: a, reason: collision with root package name */
        public Context f17590a;

        /* renamed from: b, reason: collision with root package name */
        public a.c f17591b;

        /* renamed from: c, reason: collision with root package name */
        public String f17592c;

        /* renamed from: d, reason: collision with root package name */
        public List f17593d;

        /* renamed from: e, reason: collision with root package name */
        public C1190w f17594e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f17595f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f17596g = false;

        public C0201b(Context context) {
            this.f17590a = context;
        }

        public boolean a() {
            return this.f17595f;
        }

        public Context b() {
            return this.f17590a;
        }

        public a.c c() {
            return this.f17591b;
        }

        public List d() {
            return this.f17593d;
        }

        public String e() {
            return this.f17592c;
        }

        public C1190w f() {
            return this.f17594e;
        }

        public boolean g() {
            return this.f17596g;
        }

        public C0201b h(boolean z7) {
            this.f17595f = z7;
            return this;
        }

        public C0201b i(a.c cVar) {
            this.f17591b = cVar;
            return this;
        }

        public C0201b j(List list) {
            this.f17593d = list;
            return this;
        }

        public C0201b k(String str) {
            this.f17592c = str;
            return this;
        }

        public C0201b l(boolean z7) {
            this.f17596g = z7;
            return this;
        }
    }

    public b(Context context, String[] strArr) {
        C0765d c0765dC = U4.a.e().c();
        if (c0765dC.p()) {
            return;
        }
        c0765dC.r(context.getApplicationContext());
        c0765dC.f(context.getApplicationContext(), strArr);
    }

    public io.flutter.embedding.engine.a a(C0201b c0201b) {
        io.flutter.embedding.engine.a aVarG;
        Context contextB = c0201b.b();
        a.c cVarC = c0201b.c();
        String strE = c0201b.e();
        List listD = c0201b.d();
        C1190w c1190wF = c0201b.f();
        if (c1190wF == null) {
            c1190wF = new C1190w();
        }
        C1190w c1190w = c1190wF;
        boolean zA = c0201b.a();
        boolean zG = c0201b.g();
        if (cVarC == null) {
            cVarC = a.c.a();
        }
        a.c cVar = cVarC;
        if (this.f17587a.size() == 0) {
            aVarG = b(contextB, c1190w, zA, zG);
            if (strE != null) {
                aVarG.q().c(strE);
            }
            aVarG.l().k(cVar, listD);
        } else {
            aVarG = ((io.flutter.embedding.engine.a) this.f17587a.get(0)).G(contextB, cVar, strE, listD, c1190w, zA, zG);
        }
        this.f17587a.add(aVarG);
        aVarG.f(new a(aVarG));
        return aVarG;
    }

    public io.flutter.embedding.engine.a b(Context context, C1190w c1190w, boolean z7, boolean z8) {
        return new io.flutter.embedding.engine.a(context, null, null, c1190w, null, z7, z8, this);
    }
}
