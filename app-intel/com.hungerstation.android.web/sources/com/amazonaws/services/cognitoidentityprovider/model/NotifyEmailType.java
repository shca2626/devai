package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class NotifyEmailType implements Serializable {
    private String htmlBody;
    private String subject;
    private String textBody;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NotifyEmailType)) {
            return false;
        }
        NotifyEmailType notifyEmailType = (NotifyEmailType) obj;
        if ((notifyEmailType.getSubject() == null) ^ (getSubject() == null)) {
            return false;
        }
        if (notifyEmailType.getSubject() != null && !notifyEmailType.getSubject().equals(getSubject())) {
            return false;
        }
        if ((notifyEmailType.getHtmlBody() == null) ^ (getHtmlBody() == null)) {
            return false;
        }
        if (notifyEmailType.getHtmlBody() != null && !notifyEmailType.getHtmlBody().equals(getHtmlBody())) {
            return false;
        }
        if ((notifyEmailType.getTextBody() == null) ^ (getTextBody() == null)) {
            return false;
        }
        return notifyEmailType.getTextBody() == null || notifyEmailType.getTextBody().equals(getTextBody());
    }

    public String getHtmlBody() {
        return this.htmlBody;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTextBody() {
        return this.textBody;
    }

    public int hashCode() {
        return (((((getSubject() == null ? 0 : getSubject().hashCode()) + 31) * 31) + (getHtmlBody() == null ? 0 : getHtmlBody().hashCode())) * 31) + (getTextBody() != null ? getTextBody().hashCode() : 0);
    }

    public void setHtmlBody(String str) {
        this.htmlBody = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setTextBody(String str) {
        this.textBody = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getSubject() != null) {
            sb2.append("Subject: " + getSubject() + ",");
        }
        if (getHtmlBody() != null) {
            sb2.append("HtmlBody: " + getHtmlBody() + ",");
        }
        if (getTextBody() != null) {
            sb2.append("TextBody: " + getTextBody());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public NotifyEmailType withHtmlBody(String str) {
        this.htmlBody = str;
        return this;
    }

    public NotifyEmailType withSubject(String str) {
        this.subject = str;
        return this;
    }

    public NotifyEmailType withTextBody(String str) {
        this.textBody = str;
        return this;
    }
}
