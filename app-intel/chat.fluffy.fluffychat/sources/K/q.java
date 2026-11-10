package K;

import K.k;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4955a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f4956b = new Object();

    public static Bundle a(k.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.q() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    public static Bundle b(w wVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", wVar.i());
        bundle.putCharSequence("label", wVar.h());
        bundle.putCharSequenceArray("choices", wVar.e());
        bundle.putBoolean("allowFreeFormInput", wVar.c());
        bundle.putBundle("extras", wVar.g());
        Set setD = wVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] c(w[] wVarArr) {
        if (wVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[wVarArr.length];
        for (int i7 = 0; i7 < wVarArr.length; i7++) {
            bundleArr[i7] = b(wVarArr[i7]);
        }
        return bundleArr;
    }
}
