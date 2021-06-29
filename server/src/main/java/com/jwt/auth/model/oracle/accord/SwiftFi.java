package com.jwt.auth.model.oracle.accord;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "SWIFT_FI", schema = "SR_BANK")
public class SwiftFi {
    private int id;
    private String bic;
    private String institutionName;
    private String branchInfo;
    private String city;
    private String subtypeInd;
    private String valueAddService;
    private String extraInfo;
    private String address;
    private String zipcode;
    private String vLocation;
    private String ctName;
    private boolean status;
    @Temporal(TemporalType.DATE)
    private Date dateValid;
    private String isKey;
    @Temporal(TemporalType.DATE)
    private Date dateClose;
    @Temporal(TemporalType.DATE)
    private Date modifyDate;
    private String typeClose;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BIC")
    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Basic
    @Column(name = "INSTITUTION_NAME")
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    @Basic
    @Column(name = "BRANCH_INFO")
    public String getBranchInfo() {
        return branchInfo;
    }

    public void setBranchInfo(String branchInfo) {
        this.branchInfo = branchInfo;
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
    @Column(name = "SUBTYPE_IND")
    public String getSubtypeInd() {
        return subtypeInd;
    }

    public void setSubtypeInd(String subtypeInd) {
        this.subtypeInd = subtypeInd;
    }

    @Basic
    @Column(name = "VALUE_ADD_SERVICE")
    public String getValueAddService() {
        return valueAddService;
    }

    public void setValueAddService(String valueAddService) {
        this.valueAddService = valueAddService;
    }

    @Basic
    @Column(name = "EXTRA_INFO")
    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
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
    @Column(name = "ZIPCODE")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "V_LOCATION")
    public String getvLocation() {
        return vLocation;
    }

    public void setvLocation(String vLocation) {
        this.vLocation = vLocation;
    }

    @Basic
    @Column(name = "CT_NAME")
    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    @Basic
    @Column(name = "STATUS")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "DATE_VALID")
    public Date getDateValid() {
        return dateValid;
    }

    public void setDateValid(Date dateValid) {
        this.dateValid = dateValid;
    }

    @Basic
    @Column(name = "IS_KEY")
    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    @Basic
    @Column(name = "DATE_CLOSE")
    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Basic
    @Column(name = "MODIFY_DATE")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "TYPE_CLOSE")
    public String getTypeClose() {
        return typeClose;
    }

    public void setTypeClose(String typeClose) {
        this.typeClose = typeClose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwiftFi swiftFi = (SwiftFi) o;
        return id == swiftFi.id &&
                status == swiftFi.status &&
                Objects.equals(bic, swiftFi.bic) &&
                Objects.equals(institutionName, swiftFi.institutionName) &&
                Objects.equals(branchInfo, swiftFi.branchInfo) &&
                Objects.equals(city, swiftFi.city) &&
                Objects.equals(subtypeInd, swiftFi.subtypeInd) &&
                Objects.equals(valueAddService, swiftFi.valueAddService) &&
                Objects.equals(extraInfo, swiftFi.extraInfo) &&
                Objects.equals(address, swiftFi.address) &&
                Objects.equals(zipcode, swiftFi.zipcode) &&
                Objects.equals(vLocation, swiftFi.vLocation) &&
                Objects.equals(ctName, swiftFi.ctName) &&
                Objects.equals(dateValid, swiftFi.dateValid) &&
                Objects.equals(isKey, swiftFi.isKey) &&
                Objects.equals(dateClose, swiftFi.dateClose) &&
                Objects.equals(modifyDate, swiftFi.modifyDate) &&
                Objects.equals(typeClose, swiftFi.typeClose);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bic, institutionName, branchInfo, city, subtypeInd, valueAddService, extraInfo, address, zipcode, vLocation, ctName, status, dateValid, isKey, dateClose, modifyDate, typeClose);
    }
}
