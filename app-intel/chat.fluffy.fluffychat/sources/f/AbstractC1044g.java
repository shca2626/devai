package f;

import M5.A;
import M5.m;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0805j;
import androidx.lifecycle.InterfaceC0807l;
import androidx.lifecycle.InterfaceC0809n;
import g.AbstractC1066a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: f.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1044g {

    /* renamed from: h, reason: collision with root package name */
    public static final b f15626h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map f15627a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f15628b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map f15629c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final List f15630d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient Map f15631e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Map f15632f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f15633g = new Bundle();

    /* renamed from: f.g$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1039b f15634a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1066a f15635b;

        public a(InterfaceC1039b interfaceC1039b, AbstractC1066a abstractC1066a) {
            m.e(interfaceC1039b, "callback");
            m.e(abstractC1066a, "contract");
            this.f15634a = interfaceC1039b;
            this.f15635b = abstractC1066a;
        }

        public final InterfaceC1039b a() {
            return this.f15634a;
        }

        public final AbstractC1066a b() {
            return this.f15635b;
        }
    }

    /* renamed from: f.g$b */
    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public b() {
        }
    }

    /* renamed from: f.g$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC0805j f15636a;

        /* renamed from: b, reason: collision with root package name */
        public final List f15637b;

        public c(AbstractC0805j abstractC0805j) {
            m.e(abstractC0805j, "lifecycle");
            this.f15636a = abstractC0805j;
            this.f15637b = new ArrayList();
        }

        public final void a(InterfaceC0807l interfaceC0807l) {
            m.e(interfaceC0807l, "observer");
            this.f15636a.a(interfaceC0807l);
            this.f15637b.add(interfaceC0807l);
        }

        public final void b() {
            Iterator it = this.f15637b.iterator();
            while (it.hasNext()) {
                this.f15636a.c((InterfaceC0807l) it.next());
            }
            this.f15637b.clear();
        }
    }

    /* renamed from: f.g$d */
    public static final class d extends AbstractC1041d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15639b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1066a f15640c;

        public d(String str, AbstractC1066a abstractC1066a) {
            this.f15639b = str;
            this.f15640c = abstractC1066a;
        }

        @Override // f.AbstractC1041d
        public void b(Object obj, K.c cVar) throws Exception {
            Object obj2 = AbstractC1044g.this.f15628b.get(this.f15639b);
            AbstractC1066a abstractC1066a = this.f15640c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                AbstractC1044g.this.f15630d.add(this.f15639b);
                try {
                    AbstractC1044g.this.k(iIntValue, this.f15640c, obj, cVar);
                    return;
                } catch (Exception e7) {
                    AbstractC1044g.this.f15630d.remove(this.f15639b);
                    throw e7;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC1066a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // f.AbstractC1041d
        public void c() {
            AbstractC1044g.this.r(this.f15639b);
        }
    }

    /* renamed from: f.g$e */
    public static final class e extends AbstractC1041d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15642b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1066a f15643c;

        public e(String str, AbstractC1066a abstractC1066a) {
            this.f15642b = str;
            this.f15643c = abstractC1066a;
        }

        @Override // f.AbstractC1041d
        public void b(Object obj, K.c cVar) throws Exception {
            Object obj2 = AbstractC1044g.this.f15628b.get(this.f15642b);
            AbstractC1066a abstractC1066a = this.f15643c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                AbstractC1044g.this.f15630d.add(this.f15642b);
                try {
                    AbstractC1044g.this.k(iIntValue, this.f15643c, obj, cVar);
                    return;
                } catch (Exception e7) {
                    AbstractC1044g.this.f15630d.remove(this.f15642b);
                    throw e7;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC1066a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // f.AbstractC1041d
        public void c() {
            AbstractC1044g.this.r(this.f15642b);
        }
    }

    public static final Integer j() {
        return Integer.valueOf(Q5.c.f7685l.d(2147418112) + 65536);
    }

    public static final void p(AbstractC1044g abstractC1044g, String str, InterfaceC1039b interfaceC1039b, AbstractC1066a abstractC1066a, InterfaceC0809n interfaceC0809n, AbstractC0805j.a aVar) {
        m.e(interfaceC0809n, "<unused var>");
        m.e(aVar, "event");
        if (AbstractC0805j.a.ON_START != aVar) {
            if (AbstractC0805j.a.ON_STOP == aVar) {
                abstractC1044g.f15631e.remove(str);
                return;
            } else {
                if (AbstractC0805j.a.ON_DESTROY == aVar) {
                    abstractC1044g.r(str);
                    return;
                }
                return;
            }
        }
        abstractC1044g.f15631e.put(str, new a(interfaceC1039b, abstractC1066a));
        if (abstractC1044g.f15632f.containsKey(str)) {
            Object obj = abstractC1044g.f15632f.get(str);
            abstractC1044g.f15632f.remove(str);
            interfaceC1039b.b(obj);
        }
        C1038a c1038a = (C1038a) V.d.a(abstractC1044g.f15633g, str, C1038a.class);
        if (c1038a != null) {
            abstractC1044g.f15633g.remove(str);
            interfaceC1039b.b(abstractC1066a.c(c1038a.c(), c1038a.b()));
        }
    }

    public final void e(int i7, String str) {
        this.f15627a.put(Integer.valueOf(i7), str);
        this.f15628b.put(str, Integer.valueOf(i7));
    }

    public final boolean f(int i7, int i8, Intent intent) {
        String str = (String) this.f15627a.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        h(str, i8, intent, (a) this.f15631e.get(str));
        return true;
    }

    public final boolean g(int i7, Object obj) {
        String str = (String) this.f15627a.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.f15631e.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.f15633g.remove(str);
            this.f15632f.put(str, obj);
            return true;
        }
        InterfaceC1039b interfaceC1039bA = aVar.a();
        m.c(interfaceC1039bA, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.f15630d.remove(str)) {
            return true;
        }
        interfaceC1039bA.b(obj);
        return true;
    }

    public final void h(String str, int i7, Intent intent, a aVar) {
        if ((aVar != null ? aVar.a() : null) == null || !this.f15630d.contains(str)) {
            this.f15632f.remove(str);
            this.f15633g.putParcelable(str, new C1038a(i7, intent));
        } else {
            aVar.a().b(aVar.b().c(i7, intent));
            this.f15630d.remove(str);
        }
    }

    public final int i() {
        for (Number number : U5.h.d(new L5.a() { // from class: f.f
            @Override // L5.a
            public final Object d() {
                return AbstractC1044g.j();
            }
        })) {
            if (!this.f15627a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public abstract void k(int i7, AbstractC1066a abstractC1066a, Object obj, K.c cVar);

    public final void l(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.f15630d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.f15633g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            String str = stringArrayList.get(i7);
            if (this.f15628b.containsKey(str)) {
                Integer num = (Integer) this.f15628b.remove(str);
                if (!this.f15633g.containsKey(str)) {
                    A.b(this.f15627a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i7);
            m.d(num2, "get(...)");
            int iIntValue = num2.intValue();
            String str2 = stringArrayList.get(i7);
            m.d(str2, "get(...)");
            e(iIntValue, str2);
        }
    }

    public final void m(Bundle bundle) {
        m.e(bundle, "outState");
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f15628b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f15628b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f15630d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.f15633g));
    }

    public final AbstractC1041d n(final String str, InterfaceC0809n interfaceC0809n, final AbstractC1066a abstractC1066a, final InterfaceC1039b interfaceC1039b) {
        m.e(str, "key");
        m.e(interfaceC0809n, "lifecycleOwner");
        m.e(abstractC1066a, "contract");
        m.e(interfaceC1039b, "callback");
        AbstractC0805j abstractC0805jA = interfaceC0809n.a();
        if (abstractC0805jA.b().d(AbstractC0805j.b.f12410o)) {
            throw new IllegalStateException(("LifecycleOwner " + interfaceC0809n + " is attempting to register while current state is " + abstractC0805jA.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        q(str);
        c cVar = (c) this.f15629c.get(str);
        if (cVar == null) {
            cVar = new c(abstractC0805jA);
        }
        cVar.a(new InterfaceC0807l() { // from class: f.e
            @Override // androidx.lifecycle.InterfaceC0807l
            public final void d(InterfaceC0809n interfaceC0809n2, AbstractC0805j.a aVar) {
                AbstractC1044g.p(this.f15622l, str, interfaceC1039b, abstractC1066a, interfaceC0809n2, aVar);
            }
        });
        this.f15629c.put(str, cVar);
        return new d(str, abstractC1066a);
    }

    public final AbstractC1041d o(String str, AbstractC1066a abstractC1066a, InterfaceC1039b interfaceC1039b) {
        m.e(str, "key");
        m.e(abstractC1066a, "contract");
        m.e(interfaceC1039b, "callback");
        q(str);
        this.f15631e.put(str, new a(interfaceC1039b, abstractC1066a));
        if (this.f15632f.containsKey(str)) {
            Object obj = this.f15632f.get(str);
            this.f15632f.remove(str);
            interfaceC1039b.b(obj);
        }
        C1038a c1038a = (C1038a) V.d.a(this.f15633g, str, C1038a.class);
        if (c1038a != null) {
            this.f15633g.remove(str);
            interfaceC1039b.b(abstractC1066a.c(c1038a.c(), c1038a.b()));
        }
        return new e(str, abstractC1066a);
    }

    public final void q(String str) {
        if (((Integer) this.f15628b.get(str)) != null) {
            return;
        }
        e(i(), str);
    }

    public final void r(String str) {
        Integer num;
        m.e(str, "key");
        if (!this.f15630d.contains(str) && (num = (Integer) this.f15628b.remove(str)) != null) {
            this.f15627a.remove(num);
        }
        this.f15631e.remove(str);
        if (this.f15632f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f15632f.get(str));
            this.f15632f.remove(str);
        }
        if (this.f15633g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((C1038a) V.d.a(this.f15633g, str, C1038a.class)));
            this.f15633g.remove(str);
        }
        c cVar = (c) this.f15629c.get(str);
        if (cVar != null) {
            cVar.b();
            this.f15629c.remove(str);
        }
    }
}
