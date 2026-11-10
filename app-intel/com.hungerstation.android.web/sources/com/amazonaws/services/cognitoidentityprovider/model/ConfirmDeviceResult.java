package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class ConfirmDeviceResult implements Serializable {
    private Boolean userConfirmationNecessary;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmDeviceResult)) {
            return false;
        }
        ConfirmDeviceResult confirmDeviceResult = (ConfirmDeviceResult) obj;
        if ((confirmDeviceResult.getUserConfirmationNecessary() == null) ^ (getUserConfirmationNecessary() == null)) {
            return false;
        }
        return confirmDeviceResult.getUserConfirmationNecessary() == null || confirmDeviceResult.getUserConfirmationNecessary().equals(getUserConfirmationNecessary());
    }

    public Boolean getUserConfirmationNecessary() {
        return this.userConfirmationNecessary;
    }

    public int hashCode() {
        return 31 + (getUserConfirmationNecessary() == null ? 0 : getUserConfirmationNecessary().hashCode());
    }

    public Boolean isUserConfirmationNecessary() {
        return this.userConfirmationNecessary;
    }

    public void setUserConfirmationNecessary(Boolean bool) {
        this.userConfirmationNecessary = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getUserConfirmationNecessary() != null) {
            sb2.append("UserConfirmationNecessary: " + getUserConfirmationNecessary());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ConfirmDeviceResult withUserConfirmationNecessary(Boolean bool) {
        this.userConfirmationNecessary = bool;
        return this;
    }
}
