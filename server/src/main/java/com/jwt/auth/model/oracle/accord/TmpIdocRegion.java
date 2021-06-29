package com.jwt.auth.model.oracle.accord;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TMP_IDOC_REGION", schema = "SR_BANK")
public class TmpIdocRegion {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nameRegion;
    private String fio;
    private String email;
    private String phone;
    private Integer orderCode;
    private Integer codeRegion;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME_REGION")
    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    @Basic
    @Column(name = "FIO")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ORDER_CODE")
    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    @Basic
    @Column(name = "CODE_REGION")
    public Integer getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(Integer codeRegion) {
        this.codeRegion = codeRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmpIdocRegion that = (TmpIdocRegion) o;
        return id == that.id &&
                Objects.equals(nameRegion, that.nameRegion) &&
                Objects.equals(fio, that.fio) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(orderCode, that.orderCode) &&
                Objects.equals(codeRegion, that.codeRegion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nameRegion, fio, email, phone, orderCode, codeRegion);
    }
}
