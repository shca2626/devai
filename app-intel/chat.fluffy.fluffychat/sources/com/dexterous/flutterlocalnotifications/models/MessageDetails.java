package com.dexterous.flutterlocalnotifications.models;

import h.InterfaceC1116a;
import java.io.Serializable;

@InterfaceC1116a
/* loaded from: classes.dex */
public class MessageDetails implements Serializable {
    public String dataMimeType;
    public String dataUri;
    public PersonDetails person;
    public String text;
    public Long timestamp;

    public MessageDetails(String str, Long l7, PersonDetails personDetails, String str2, String str3) {
        this.text = str;
        this.timestamp = l7;
        this.person = personDetails;
        this.dataMimeType = str2;
        this.dataUri = str3;
    }
}
