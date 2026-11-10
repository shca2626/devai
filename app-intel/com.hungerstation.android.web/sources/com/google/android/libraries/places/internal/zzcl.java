package com.google.android.libraries.places.internal;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public final class zzcl {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(java.lang.String r8) {
        /*
            r0 = 13
            if (r8 != 0) goto L5
            return r0
        L5:
            int r1 = r8.hashCode()
            r2 = 3
            r3 = 4
            r4 = 1
            r5 = 0
            r6 = 5
            r7 = 2
            switch(r1) {
                case -1698126997: goto L4f;
                case -1125000185: goto L45;
                case -813482689: goto L3b;
                case 2524: goto L31;
                case 1023286998: goto L27;
                case 1776037267: goto L1d;
                case 1831775833: goto L13;
                default: goto L12;
            }
        L12:
            goto L59
        L13:
            java.lang.String r1 = "OVER_QUERY_LIMIT"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 2
            goto L5a
        L1d:
            java.lang.String r1 = "UNKNOWN_ERROR"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 6
            goto L5a
        L27:
            java.lang.String r1 = "NOT_FOUND"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 5
            goto L5a
        L31:
            java.lang.String r1 = "OK"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 0
            goto L5a
        L3b:
            java.lang.String r1 = "ZERO_RESULTS"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 1
            goto L5a
        L45:
            java.lang.String r1 = "INVALID_REQUEST"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 4
            goto L5a
        L4f:
            java.lang.String r1 = "REQUEST_DENIED"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L59
            r8 = 3
            goto L5a
        L59:
            r8 = -1
        L5a:
            if (r8 == 0) goto L73
            if (r8 == r4) goto L73
            if (r8 == r7) goto L70
            if (r8 == r2) goto L6d
            if (r8 == r3) goto L6a
            if (r8 == r6) goto L67
            return r0
        L67:
            r8 = 9013(0x2335, float:1.263E-41)
            return r8
        L6a:
            r8 = 9012(0x2334, float:1.2629E-41)
            return r8
        L6d:
            r8 = 9011(0x2333, float:1.2627E-41)
            return r8
        L70:
            r8 = 9010(0x2332, float:1.2626E-41)
            return r8
        L73:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcl.zza(java.lang.String):int");
    }

    public static String zza(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str2;
    }
}
