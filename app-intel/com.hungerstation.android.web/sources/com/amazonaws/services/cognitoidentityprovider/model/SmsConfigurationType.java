package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class SmsConfigurationType implements Serializable {
    private String externalId;
    private String snsCallerArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SmsConfigurationType)) {
            return false;
        }
        SmsConfigurationType smsConfigurationType = (SmsConfigurationType) obj;
        if ((smsConfigurationType.getSnsCallerArn() == null) ^ (getSnsCallerArn() == null)) {
            return false;
        }
        if (smsConfigurationType.getSnsCallerArn() != null && !smsConfigurationType.getSnsCallerArn().equals(getSnsCallerArn())) {
            return false;
        }
        if ((smsConfigurationType.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        return smsConfigurationType.getExternalId() == null || smsConfigurationType.getExternalId().equals(getExternalId());
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getSnsCallerArn() {
        return this.snsCallerArn;
    }

    public int hashCode() {
        return (((getSnsCallerArn() == null ? 0 : getSnsCallerArn().hashCode()) + 31) * 31) + (getExternalId() != null ? getExternalId().hashCode() : 0);
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public void setSnsCallerArn(String str) {
        this.snsCallerArn = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getSnsCallerArn() != null) {
            sb2.append("SnsCallerArn: " + getSnsCallerArn() + ",");
        }
        if (getExternalId() != null) {
            sb2.append("ExternalId: " + getExternalId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public SmsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public SmsConfigurationType withSnsCallerArn(String str) {
        this.snsCallerArn = str;
        return this;
    }
}
