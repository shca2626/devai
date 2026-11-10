package com.checkout.models;

/* loaded from: classes7.dex */
public class CustDetails {
    private String address1;
    private String address2;
    private String city;
    private String country;
    private Phone phone;
    private String postCode;
    private String state;

    class Phone {
        private String countryCode;
        private String number;

        public Phone(String str, String str2) {
            this.number = str2;
            this.countryCode = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Phone phone = (Phone) obj;
            String str = this.countryCode;
            if (str == null ? phone.countryCode != null : !str.equals(phone.countryCode)) {
                return false;
            }
            String str2 = this.number;
            String str3 = phone.number;
            if (str2 != null) {
                if (str2.equals(str3)) {
                    return true;
                }
            } else if (str3 == null) {
                return true;
            }
            return false;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public String getNumber() {
            return this.number;
        }
    }

    public CustDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.address1 = str;
        this.address2 = str2;
        this.postCode = str3;
        this.country = str4;
        this.city = str5;
        this.state = str6;
        this.phone = new Phone(str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustDetails custDetails = (CustDetails) obj;
        String str = this.address1;
        if (str == null ? custDetails.address1 != null : !str.equals(custDetails.address1)) {
            return false;
        }
        String str2 = this.address2;
        if (str2 == null ? custDetails.address2 != null : !str2.equals(custDetails.address2)) {
            return false;
        }
        String str3 = this.postCode;
        if (str3 == null ? custDetails.postCode != null : !str3.equals(custDetails.postCode)) {
            return false;
        }
        String str4 = this.country;
        if (str4 == null ? custDetails.country != null : !str4.equals(custDetails.country)) {
            return false;
        }
        String str5 = this.city;
        if (str5 == null ? custDetails.city != null : !str5.equals(custDetails.city)) {
            return false;
        }
        String str6 = this.state;
        if (str6 == null ? custDetails.state != null : !str6.equals(custDetails.state)) {
            return false;
        }
        Phone phone = this.phone;
        Phone phone2 = custDetails.phone;
        if (phone != null) {
            if (phone.equals(phone2)) {
                return true;
            }
        } else if (phone2 == null) {
            return true;
        }
        return false;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.phone.getCountryCode();
    }

    public String getNumber() {
        return this.phone.getNumber();
    }

    public String getPostCode() {
        return this.postCode;
    }

    public String getState() {
        return this.state;
    }
}
