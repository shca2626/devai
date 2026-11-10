package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.y;
import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements X1.b {
    @Override // X1.b
    public List a() {
        return C1881o.i();
    }

    @Override // X1.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0808n b(Context context) {
        M5.m.e(context, "context");
        X1.a aVarE = X1.a.e(context);
        M5.m.d(aVarE, "getInstance(...)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0805k.a(context);
        y.b bVar = y.f12452t;
        bVar.b(context);
        return bVar.a();
    }
}
