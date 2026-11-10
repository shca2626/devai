package C5;

import C5.i;
import L5.p;
import M5.m;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final j f1392l = new j();

    @Override // C5.i
    public Object R(Object obj, p pVar) {
        m.e(pVar, "operation");
        return obj;
    }

    @Override // C5.i
    public i.b a(i.c cVar) {
        m.e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // C5.i
    public i n(i iVar) {
        m.e(iVar, "context");
        return iVar;
    }

    @Override // C5.i
    public i o(i.c cVar) {
        m.e(cVar, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
