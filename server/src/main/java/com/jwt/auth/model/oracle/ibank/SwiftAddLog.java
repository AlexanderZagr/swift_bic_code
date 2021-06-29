package com.jwt.auth.model.oracle.ibank;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "SWIFT_ADD_LOG", schema = "IBANK2UA")
public class SwiftAddLog {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(sequenceName = "SEC_UID", name = "SEC_UID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_UID")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ADD")
    private Date dataAdd;
    @Basic
    @Column(name = "USER_ADD")
    private String userAdd;
    @Basic
    @Column(name = "BIC")
    private String bic;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CITY")
    private String city;
    @Basic
    @Column(name = "ADDRESS")
    private String address;
    @Basic
    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public Date getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(Date dataAdd) {
        this.dataAdd = dataAdd;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
        SwiftAddLog that = (SwiftAddLog) o;
        return id == that.id &&
                Objects.equals(dataAdd, that.dataAdd) &&
                Objects.equals(userAdd, that.userAdd) &&
                Objects.equals(bic, that.bic) &&
                Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(address, that.address) &&
                Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dataAdd, userAdd, bic, name, city, address, countryCode);
    }
}
