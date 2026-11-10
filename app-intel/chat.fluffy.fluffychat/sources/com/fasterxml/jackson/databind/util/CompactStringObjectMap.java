package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class CompactStringObjectMap implements Serializable {
    private static final CompactStringObjectMap EMPTY = new CompactStringObjectMap(1, 0, new Object[4]);
    private static final long serialVersionUID = 1;
    private final Object[] _hashArea;
    private final int _hashMask;
    private final int _spillCount;

    private CompactStringObjectMap(int i7, int i8, Object[] objArr) {
        this._hashMask = i7;
        this._spillCount = i8;
        this._hashArea = objArr;
    }

    private final Object _find2(String str, int i7, Object obj) {
        if (obj == null) {
            return null;
        }
        int i8 = this._hashMask + 1;
        int i9 = ((i7 >> 1) + i8) << 1;
        Object obj2 = this._hashArea[i9];
        if (str.equals(obj2)) {
            return this._hashArea[i9 + 1];
        }
        if (obj2 != null) {
            int i10 = (i8 + (i8 >> 1)) << 1;
            int i11 = this._spillCount + i10;
            while (i10 < i11) {
                Object obj3 = this._hashArea[i10];
                if (obj3 == str || str.equals(obj3)) {
                    return this._hashArea[i10 + 1];
                }
                i10 += 2;
            }
        }
        return null;
    }

    public static <T> CompactStringObjectMap construct(Map<String, T> map) {
        if (map.isEmpty()) {
            return EMPTY;
        }
        int iFindSize = findSize(map.size());
        int i7 = iFindSize - 1;
        int i8 = (iFindSize >> 1) + iFindSize;
        Object[] objArrCopyOf = new Object[i8 * 2];
        int i9 = 0;
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                int iHashCode = key.hashCode() & i7;
                int i10 = iHashCode + iHashCode;
                if (objArrCopyOf[i10] != null) {
                    i10 = ((iHashCode >> 1) + iFindSize) << 1;
                    if (objArrCopyOf[i10] != null) {
                        i10 = (i8 << 1) + i9;
                        i9 += 2;
                        if (i10 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i10] = key;
                objArrCopyOf[i10 + 1] = entry.getValue();
            }
        }
        return new CompactStringObjectMap(i7, i9, objArrCopyOf);
    }

    private static final int findSize(int i7) {
        if (i7 <= 5) {
            return 8;
        }
        if (i7 <= 12) {
            return 16;
        }
        int i8 = 32;
        while (i8 < i7 + (i7 >> 2)) {
            i8 += i8;
        }
        return i8;
    }

    public Object find(String str) {
        int iHashCode = str.hashCode() & this._hashMask;
        int i7 = iHashCode << 1;
        Object obj = this._hashArea[i7];
        return (obj == str || str.equals(obj)) ? this._hashArea[i7 + 1] : _find2(str, iHashCode, obj);
    }

    public Object findCaseInsensitive(String str) {
        int length = this._hashArea.length;
        for (int i7 = 0; i7 < length; i7 += 2) {
            Object obj = this._hashArea[i7];
            if (obj != null && ((String) obj).equalsIgnoreCase(str)) {
                return this._hashArea[i7 + 1];
            }
        }
        return null;
    }

    public List<String> keys() {
        int length = this._hashArea.length;
        ArrayList arrayList = new ArrayList(length >> 2);
        for (int i7 = 0; i7 < length; i7 += 2) {
            Object obj = this._hashArea[i7];
            if (obj != null) {
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }
}
