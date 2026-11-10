package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class GetSigningCertificateResult implements Serializable {
    private String certificate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSigningCertificateResult)) {
            return false;
        }
        GetSigningCertificateResult getSigningCertificateResult = (GetSigningCertificateResult) obj;
        if ((getSigningCertificateResult.getCertificate() == null) ^ (getCertificate() == null)) {
            return false;
        }
        return getSigningCertificateResult.getCertificate() == null || getSigningCertificateResult.getCertificate().equals(getCertificate());
    }

    public String getCertificate() {
        return this.certificate;
    }

    public int hashCode() {
        return 31 + (getCertificate() == null ? 0 : getCertificate().hashCode());
    }

    public void setCertificate(String str) {
        this.certificate = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCertificate() != null) {
            sb2.append("Certificate: " + getCertificate());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetSigningCertificateResult withCertificate(String str) {
        this.certificate = str;
        return this;
    }
}
