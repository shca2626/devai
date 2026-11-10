package io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.plugin.platform.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1182n implements InterfaceC1181m {

    /* renamed from: a, reason: collision with root package name */
    public final Map f17853a = new HashMap();

    @Override // io.flutter.plugin.platform.InterfaceC1181m
    public boolean a(String str, AbstractC1180l abstractC1180l) {
        if (this.f17853a.containsKey(str)) {
            return false;
        }
        this.f17853a.put(str, abstractC1180l);
        return true;
    }

    public AbstractC1180l b(String str) {
        return (AbstractC1180l) this.f17853a.get(str);
    }
}
