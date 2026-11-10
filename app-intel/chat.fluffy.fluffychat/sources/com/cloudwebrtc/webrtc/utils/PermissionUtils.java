package com.cloudwebrtc.webrtc.utils;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PermissionUtils {
    private static final String GRANT_RESULTS = "GRANT_RESULT";
    private static final String PERMISSIONS = "PERMISSION";
    private static final String REQUEST_CODE = "REQUEST_CODE";
    private static final String RESULT_RECEIVER = "RESULT_RECEIVER";
    private static int requestCode;

    public interface Callback {
        void invoke(String[] strArr, int[] iArr);
    }

    public static class RequestPermissionsFragment extends Fragment {
        private void checkSelfPermissions(boolean z7) {
            Bundle arguments = getArguments();
            String[] stringArray = arguments.getStringArray(PermissionUtils.PERMISSIONS);
            int length = stringArray.length;
            Activity activity = getActivity();
            int[] iArr = new int[length];
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < length; i7++) {
                String str = stringArray[i7];
                int iCheckSelfPermission = activity.checkSelfPermission(str);
                iArr[i7] = iCheckSelfPermission;
                if (iCheckSelfPermission != 0) {
                    arrayList.add(str);
                }
            }
            int i8 = arguments.getInt(PermissionUtils.REQUEST_CODE, 0);
            if (!arrayList.isEmpty() && z7) {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i8);
            } else {
                finish();
                PermissionUtils.send((ResultReceiver) arguments.getParcelable(PermissionUtils.RESULT_RECEIVER), i8, stringArray, iArr);
            }
        }

        private void finish() {
            Activity activity = getActivity();
            if (activity != null) {
                activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            }
        }

        @Override // android.app.Fragment
        public void onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
            Bundle arguments = getArguments();
            if (arguments.getInt(PermissionUtils.REQUEST_CODE, 0) != i7) {
                return;
            }
            if (strArr.length != 0 && iArr.length != 0) {
                checkSelfPermissions(false);
            } else {
                finish();
                PermissionUtils.requestPermissions(getContext(), getActivity(), arguments.getStringArray(PermissionUtils.PERMISSIONS), (ResultReceiver) arguments.getParcelable(PermissionUtils.RESULT_RECEIVER));
            }
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            checkSelfPermissions(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestPermissions(Context context, Activity activity, String[] strArr, ResultReceiver resultReceiver) {
        int length = strArr.length;
        int[] iArr = new int[length];
        boolean z7 = true;
        for (int i7 = 0; i7 < length; i7++) {
            int iCheckSelfPermission = activity != null ? activity.checkSelfPermission(strArr[i7]) : L.b.a(context, strArr[i7]);
            iArr[i7] = iCheckSelfPermission;
            if (iCheckSelfPermission != 0) {
                z7 = false;
            }
        }
        int i8 = requestCode + 1;
        requestCode = i8;
        if (z7 || context.getApplicationInfo().targetSdkVersion < 23) {
            send(resultReceiver, i8, strArr, iArr);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(REQUEST_CODE, i8);
        bundle.putParcelable(RESULT_RECEIVER, resultReceiver);
        bundle.putStringArray(PERMISSIONS, strArr);
        RequestPermissionsFragment requestPermissionsFragment = new RequestPermissionsFragment();
        requestPermissionsFragment.setArguments(bundle);
        if (activity != null) {
            try {
                activity.getFragmentManager().beginTransaction().add(requestPermissionsFragment, RequestPermissionsFragment.class.getName() + "-" + i8).commit();
            } catch (IllegalStateException unused) {
                send(resultReceiver, i8, strArr, iArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void send(ResultReceiver resultReceiver, int i7, String[] strArr, int[] iArr) {
        Bundle bundle = new Bundle();
        bundle.putStringArray(PERMISSIONS, strArr);
        bundle.putIntArray(GRANT_RESULTS, iArr);
        resultReceiver.send(i7, bundle);
    }

    public static void requestPermissions(Context context, Activity activity, String[] strArr, final Callback callback) {
        requestPermissions(context, activity, strArr, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.cloudwebrtc.webrtc.utils.PermissionUtils.1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i7, Bundle bundle) {
                callback.invoke(bundle.getStringArray(PermissionUtils.PERMISSIONS), bundle.getIntArray(PermissionUtils.GRANT_RESULTS));
            }
        });
    }
}
