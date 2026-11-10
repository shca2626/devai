package com.checkout.models;

/* loaded from: classes7.dex */
public class CardProvider {
    private boolean cvvRequired;

    /* renamed from: id, reason: collision with root package name */
    private String f19542id;
    private String name;

    public CardProvider(String str, String str2, boolean z12) {
        this.f19542id = str;
        this.name = str2;
        this.cvvRequired = z12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CardProvider cardProvider = (CardProvider) obj;
        if (this.cvvRequired != cardProvider.cvvRequired) {
            return false;
        }
        String str = this.f19542id;
        if (str == null ? cardProvider.f19542id != null : !str.equals(cardProvider.f19542id)) {
            return false;
        }
        String str2 = this.name;
        String str3 = cardProvider.name;
        if (str2 != null) {
            if (str2.equals(str3)) {
                return true;
            }
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f19542id + " - " + this.name + " - " + this.cvvRequired;
    }
}
