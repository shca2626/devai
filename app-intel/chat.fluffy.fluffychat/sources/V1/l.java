package V1;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract /* synthetic */ class l {
    public static final ArrayList a(Collection collection) {
        M5.m.e(collection, "<this>");
        return collection instanceof ArrayList ? (ArrayList) collection : new ArrayList(collection);
    }
}
