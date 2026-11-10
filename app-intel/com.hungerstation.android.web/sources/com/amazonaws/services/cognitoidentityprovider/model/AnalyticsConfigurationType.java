package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class AnalyticsConfigurationType implements Serializable {
    private String applicationId;
    private String externalId;
    private String roleArn;
    private Boolean userDataShared;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AnalyticsConfigurationType)) {
            return false;
        }
        AnalyticsConfigurationType analyticsConfigurationType = (AnalyticsConfigurationType) obj;
        if ((analyticsConfigurationType.getApplicationId() == null) ^ (getApplicationId() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getApplicationId() != null && !analyticsConfigurationType.getApplicationId().equals(getApplicationId())) {
            return false;
        }
        if ((analyticsConfigurationType.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getRoleArn() != null && !analyticsConfigurationType.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((analyticsConfigurationType.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getExternalId() != null && !analyticsConfigurationType.getExternalId().equals(getExternalId())) {
            return false;
        }
        if ((analyticsConfigurationType.getUserDataShared() == null) ^ (getUserDataShared() == null)) {
            return false;
        }
        return analyticsConfigurationType.getUserDataShared() == null || analyticsConfigurationType.getUserDataShared().equals(getUserDataShared());
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public Boolean getUserDataShared() {
        return this.userDataShared;
    }

    public int hashCode() {
        return (((((((getApplicationId() == null ? 0 : getApplicationId().hashCode()) + 31) * 31) + (getRoleArn() == null ? 0 : getRoleArn().hashCode())) * 31) + (getExternalId() == null ? 0 : getExternalId().hashCode())) * 31) + (getUserDataShared() != null ? getUserDataShared().hashCode() : 0);
    }

    public Boolean isUserDataShared() {
        return this.userDataShared;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setUserDataShared(Boolean bool) {
        this.userDataShared = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getApplicationId() != null) {
            sb2.append("ApplicationId: " + getApplicationId() + ",");
        }
        if (getRoleArn() != null) {
            sb2.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getExternalId() != null) {
            sb2.append("ExternalId: " + getExternalId() + ",");
        }
        if (getUserDataShared() != null) {
            sb2.append("UserDataShared: " + getUserDataShared());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public AnalyticsConfigurationType withApplicationId(String str) {
        this.applicationId = str;
        return this;
    }

    public AnalyticsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public AnalyticsConfigurationType withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AnalyticsConfigurationType withUserDataShared(Boolean bool) {
        this.userDataShared = bool;
        return this;
    }
}
