package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public enum ExplicitAuthFlowsType {
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    CUSTOM_AUTH_FLOW_ONLY("CUSTOM_AUTH_FLOW_ONLY"),
    USER_PASSWORD_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD);

    private static final Map<String, ExplicitAuthFlowsType> enumMap;
    private String value;

    static {
        ExplicitAuthFlowsType explicitAuthFlowsType = ADMIN_NO_SRP_AUTH;
        ExplicitAuthFlowsType explicitAuthFlowsType2 = CUSTOM_AUTH_FLOW_ONLY;
        ExplicitAuthFlowsType explicitAuthFlowsType3 = USER_PASSWORD_AUTH;
        HashMap map = new HashMap();
        enumMap = map;
        map.put("ADMIN_NO_SRP_AUTH", explicitAuthFlowsType);
        map.put("CUSTOM_AUTH_FLOW_ONLY", explicitAuthFlowsType2);
        map.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD, explicitAuthFlowsType3);
    }

    ExplicitAuthFlowsType(String str) {
        this.value = str;
    }

    public static ExplicitAuthFlowsType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ExplicitAuthFlowsType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
