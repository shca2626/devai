package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0775f;
import androidx.datastore.preferences.protobuf.K;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0770a implements K {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0102a implements K.a {
        public static void l(Iterable iterable, List list) {
            AbstractC0789u.a(iterable);
            m(iterable, list);
        }

        public static void m(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        public static f0 o(K k7) {
            return new f0(k7);
        }

        @Override // 
        public abstract AbstractC0102a n();
    }

    public static void d(Iterable iterable, List list) {
        AbstractC0102a.l(iterable, list);
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public AbstractC0775f c() {
        try {
            AbstractC0775f.h hVarP = AbstractC0775f.p(f());
            g(hVarP.b());
            return hVarP.a();
        } catch (IOException e7) {
            throw new RuntimeException(l("ByteString"), e7);
        }
    }

    public int e() {
        throw new UnsupportedOperationException();
    }

    public int j(Z z7) {
        int iE = e();
        if (iE != -1) {
            return iE;
        }
        int iG = z7.g(this);
        n(iG);
        return iG;
    }

    public final String l(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public f0 m() {
        return new f0(this);
    }

    public void n(int i7) {
        throw new UnsupportedOperationException();
    }

    public void o(OutputStream outputStream) {
        AbstractC0778i abstractC0778iB0 = AbstractC0778i.b0(outputStream, AbstractC0778i.F(f()));
        g(abstractC0778iB0);
        abstractC0778iB0.Y();
    }
}
