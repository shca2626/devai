package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class ResourceServerScopeType implements Serializable {
    private String scopeDescription;
    private String scopeName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResourceServerScopeType)) {
            return false;
        }
        ResourceServerScopeType resourceServerScopeType = (ResourceServerScopeType) obj;
        if ((resourceServerScopeType.getScopeName() == null) ^ (getScopeName() == null)) {
            return false;
        }
        if (resourceServerScopeType.getScopeName() != null && !resourceServerScopeType.getScopeName().equals(getScopeName())) {
            return false;
        }
        if ((resourceServerScopeType.getScopeDescription() == null) ^ (getScopeDescription() == null)) {
            return false;
        }
        return resourceServerScopeType.getScopeDescription() == null || resourceServerScopeType.getScopeDescription().equals(getScopeDescription());
    }

    public String getScopeDescription() {
        return this.scopeDescription;
    }

    public String getScopeName() {
        return this.scopeName;
    }

    public int hashCode() {
        return (((getScopeName() == null ? 0 : getScopeName().hashCode()) + 31) * 31) + (getScopeDescription() != null ? getScopeDescription().hashCode() : 0);
    }

    public void setScopeDescription(String str) {
        this.scopeDescription = str;
    }

    public void setScopeName(String str) {
        this.scopeName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getScopeName() != null) {
            sb2.append("ScopeName: " + getScopeName() + ",");
        }
        if (getScopeDescription() != null) {
            sb2.append("ScopeDescription: " + getScopeDescription());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ResourceServerScopeType withScopeDescription(String str) {
        this.scopeDescription = str;
        return this;
    }

    public ResourceServerScopeType withScopeName(String str) {
        this.scopeName = str;
        return this;
    }
}
