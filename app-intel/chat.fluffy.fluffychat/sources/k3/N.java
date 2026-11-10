package k3;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public interface N extends Collection {

    public interface a {
        Object a();

        int getCount();
    }

    Set b();

    int d(Object obj);

    Set entrySet();

    @Override // java.util.Collection
    int size();
}
