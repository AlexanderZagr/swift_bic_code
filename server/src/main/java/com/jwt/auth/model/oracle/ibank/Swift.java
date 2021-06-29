package com.jwt.auth.model.oracle.ibank;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SWIFT", schema = "IBANK2UA")
public class Swift {
    private String bic;
    private String name;
    private String city;
    private String address;
    private String countryCode;

    @Id
    @Column(name = "BIC")
    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "COUNTRY_CODE")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Swift swift = (Swift) o;
        return Objects.equals(bic, swift.bic) &&
                Objects.equals(name, swift.name) &&
                Objects.equals(city, swift.city) &&
                Objects.equals(address, swift.address) &&
                Objects.equals(countryCode, swift.countryCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bic, name, city, address, countryCode);
    }
}
