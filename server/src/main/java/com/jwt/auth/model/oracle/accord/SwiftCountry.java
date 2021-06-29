package com.jwt.auth.model.oracle.accord;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "COUNTRY", schema = "SR_BANK")
public class SwiftCountry {
    private int id;
    private String code;
    private String a2;
    private String name;
    private String englishName;
    private String nameRuss;
    private String a3;
    @Temporal(TemporalType.DATE)
    private Date dClose;
    @Temporal(TemporalType.DATE)
    private Date dOpen;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "A2")
    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
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
    @Column(name = "ENGLISH_NAME")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "NAME_RUSS")
    public String getNameRuss() {
        return nameRuss;
    }

    public void setNameRuss(String nameRuss) {
        this.nameRuss = nameRuss;
    }

    @Basic
    @Column(name = "A3")
    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    @Basic
    @Column(name = "D_CLOSE")
    public Date getdClose() {
        return dClose;
    }

    public void setdClose(Date dClose) {
        this.dClose = dClose;
    }

    @Basic
    @Column(name = "D_OPEN")
    public Date getdOpen() {
        return dOpen;
    }

    public void setdOpen(Date dOpen) {
        this.dOpen = dOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwiftCountry country = (SwiftCountry) o;
        return id == country.id &&
                Objects.equals(code, country.code) &&
                Objects.equals(a2, country.a2) &&
                Objects.equals(name, country.name) &&
                Objects.equals(englishName, country.englishName) &&
                Objects.equals(nameRuss, country.nameRuss) &&
                Objects.equals(a3, country.a3) &&
                Objects.equals(dClose, country.dClose) &&
                Objects.equals(dOpen, country.dOpen);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, code, a2, name, englishName, nameRuss, a3, dClose, dOpen);
    }
}
