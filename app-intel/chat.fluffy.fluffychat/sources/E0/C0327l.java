package E0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: E0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0327l implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public final Object f2169l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public final Map f2170m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public Set f2171n = Collections.EMPTY_SET;

    /* renamed from: o, reason: collision with root package name */
    public List f2172o = Collections.EMPTY_LIST;

    public Set b() {
        Set set;
        synchronized (this.f2169l) {
            set = this.f2171n;
        }
        return set;
    }

    public int d(Object obj) {
        int iIntValue;
        synchronized (this.f2169l) {
            try {
                iIntValue = this.f2170m.containsKey(obj) ? ((Integer) this.f2170m.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public void f(Object obj) {
        synchronized (this.f2169l) {
            try {
                ArrayList arrayList = new ArrayList(this.f2172o);
                arrayList.add(obj);
                this.f2172o = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f2170m.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f2171n);
                    hashSet.add(obj);
                    this.f2171n = Collections.unmodifiableSet(hashSet);
                }
                this.f2170m.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(Object obj) {
        synchronized (this.f2169l) {
            try {
                Integer num = (Integer) this.f2170m.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f2172o);
                arrayList.remove(obj);
                this.f2172o = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f2170m.remove(obj);
                    HashSet hashSet = new HashSet(this.f2171n);
                    hashSet.remove(obj);
                    this.f2171n = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f2170m.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f2169l) {
            it = this.f2172o.iterator();
        }
        return it;
    }
}
