package u4;

import M5.m;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import z5.AbstractC1860D;
import z5.C1878l;
import z5.C1882p;

/* loaded from: classes.dex */
public abstract class h {
    public static final int a(int[] iArr, int i7) {
        m.e(iArr, "values");
        int i8 = 0;
        int iAbs = Math.abs(iArr[0] - i7);
        int length = iArr.length;
        for (int i9 = 1; i9 < length; i9++) {
            int iAbs2 = Math.abs(iArr[i9] - i7);
            if (iAbs2 < iAbs) {
                i8 = i9;
                iAbs = iAbs2;
            }
        }
        if (i7 != iArr[i8]) {
            S5.c cVarW = C1878l.w(iArr);
            ArrayList arrayList = new ArrayList(C1882p.o(cVarW, 10));
            Iterator it = cVarW.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(iArr[((AbstractC1860D) it).nextInt()]));
            }
            Log.d("nearestValue", "Available values: " + arrayList);
            Log.d("nearestValue", "Adjusted to: " + iArr[i8]);
        }
        return iArr[i8];
    }
}
