package h0;

import java.io.IOException;

/* renamed from: h0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1128d extends IOException {
    public /* synthetic */ C1128d(String str, Throwable th, int i7, M5.g gVar) {
        this(str, (i7 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1128d(String str, Throwable th) {
        super(str, th);
        M5.m.e(str, "message");
    }
}
