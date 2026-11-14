package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.plugin.platform.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1183n implements InterfaceC1182m {

    /* renamed from: a, reason: collision with root package name */
    public final Map f17853a = new HashMap();

    @Override // io.flutter.plugin.platform.InterfaceC1182m
    public boolean a(String str, AbstractC1181l abstractC1181l) {
        if (this.f17853a.containsKey(str)) {
            return false;
        }
        this.f17853a.put(str, abstractC1181l);
        return true;
    }

    public AbstractC1181l b(String str) {
        return (AbstractC1181l) this.f17853a.get(str);
    }
}
