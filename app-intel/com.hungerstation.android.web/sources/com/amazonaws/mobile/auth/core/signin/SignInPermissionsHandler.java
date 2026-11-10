package com.amazonaws.mobile.auth.core.signin;

/* loaded from: classes7.dex */
public interface SignInPermissionsHandler {
    int getPermissionRequestCode();

    void handleRequestPermissionsResult(int i12, String[] strArr, int[] iArr);
}
