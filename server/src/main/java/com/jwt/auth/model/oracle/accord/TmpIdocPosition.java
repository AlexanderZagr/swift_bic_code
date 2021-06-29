package com.jwt.auth.model.oracle.accord;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TMP_IDOC_POSITION", schema = "SR_BANK", catalog = "")
public class TmpIdocPosition {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String namePosition;
    @Basic
    @Column(name = "CODE_POSITION")
    private String codePosition;
    @Basic
    @Column(name = "ORDER_CODE")
    private Integer orderCode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME_POSITION")
    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public String getCodePosition() {
        return codePosition;
    }

    public void setCodePosition(String codePosition) {
        this.codePosition = codePosition;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmpIdocPosition that = (TmpIdocPosition) o;
        return id == that.id &&
                Objects.equals(namePosition, that.namePosition) &&
                Objects.equals(codePosition, that.codePosition) &&
                Objects.equals(orderCode, that.orderCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, namePosition, codePosition, orderCode);
    }
}
