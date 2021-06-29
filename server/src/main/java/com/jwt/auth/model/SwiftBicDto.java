package com.jwt.auth.model;

public class SwiftBicDto {

    private String bic;
    private String institution_name;
    private String address;
    private String city;

    public SwiftBicDto(String bic,String institution_name, String address, String city) {
        this.bic = bic;
        this.institution_name=institution_name;
        this.address = address;
        this.city = city;
    }


    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getBic() {
        return bic;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
