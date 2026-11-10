package M2;

import M2.c;
import N2.i;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Set f5682a;

    /* renamed from: b, reason: collision with root package name */
    public final c.b f5683b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a f5684c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5685d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5686e;

    /* renamed from: f, reason: collision with root package name */
    public c.d f5687f;

    public class a implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Context f5688l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f5689m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f5690n;

        public a(Context context, String str, String str2, c.InterfaceC0053c interfaceC0053c) {
            this.f5688l = context;
            this.f5689m = str;
            this.f5690n = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                r0 = 0
                M2.d r1 = M2.d.this     // Catch: M2.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f5688l     // Catch: M2.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.f5689m     // Catch: M2.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.f5690n     // Catch: M2.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                M2.d.a(r1, r2, r3, r4)     // Catch: M2.b -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: M2.d.a.run():void");
        }
    }

    public class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5692a;

        public b(String str) {
            this.f5692a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f5692a);
        }
    }

    public d() {
        this(new e(), new M2.a());
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.f5683b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f5685d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strA = this.f5683b.a(str);
        if (f.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, c.InterfaceC0053c interfaceC0053c) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        j("Beginning load of %s...", str);
        if (interfaceC0053c == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC0053c)).start();
        }
    }

    public final void g(Context context, String str, String str2) {
        d dVar;
        Context context2;
        i iVar;
        if (this.f5682a.contains(str) && !this.f5685d) {
            j("%s already loaded previously!", str);
            return;
        }
        try {
            this.f5683b.b(str);
            this.f5682a.add(str);
            j("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e7) {
            j("Loading the library normally failed: %s", Log.getStackTraceString(e7));
            j("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f5685d) {
                if (this.f5685d) {
                    j("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                dVar = this;
                context2 = context;
                this.f5684c.a(context2, this.f5683b.d(), this.f5683b.a(str), fileD, dVar);
            } else {
                dVar = this;
                context2 = context;
            }
            try {
                if (dVar.f5686e) {
                    try {
                        iVar = new i(fileD);
                        try {
                            List listE = iVar.e();
                            iVar.close();
                            Iterator it = listE.iterator();
                            while (it.hasNext()) {
                                e(context2, dVar.f5683b.c((String) it.next()));
                            }
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (iVar == null) {
                                throw th2;
                            }
                            iVar.close();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iVar = null;
                    }
                }
            } catch (IOException unused) {
            }
            dVar.f5683b.e(fileD.getAbsolutePath());
            dVar.f5682a.add(str);
            j("%s (%s) was re-linked!", str, str2);
        }
    }

    public d h(c.d dVar) {
        this.f5687f = dVar;
        return this;
    }

    public void i(String str) {
        c.d dVar = this.f5687f;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void j(String str, Object... objArr) {
        i(String.format(Locale.US, str, objArr));
    }

    public d(c.b bVar, c.a aVar) {
        this.f5682a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f5683b = bVar;
        this.f5684c = aVar;
    }
}
