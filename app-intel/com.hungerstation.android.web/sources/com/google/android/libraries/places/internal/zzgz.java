package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes8.dex */
public final class zzgz {
    static int zza(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i12 = ~(~(i12 + (next != null ? next.hashCode() : 0)));
        }
        return i12;
    }

    static boolean zza(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
