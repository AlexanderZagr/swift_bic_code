package com.jwt.auth.model.oracle.accord;

import javax.persistence.*;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TMP_IDOC_COMBINE_WORKER", schema = "SR_BANK")
public class TmpIdocCombineWorker implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "BRANCH_CODE")
    private Long branchCode;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "SUBDIVISION")
    private String subdivision;

  //  @Column(name = "CODE_ISPRO")
   // private String codeIspro;

    @Column(name = "OKPO")
    private String okpo;

    @Column(name = "STATE")
    private String state;

    @Column(name = "AD_E_MAIL")
    private String adEMail;

    @Column(name = "AD_FIO")
    private String adFio;

    @Column(name = "AD_POSITION")
    private String adPosition;

    @Column(name = "AD_IPHONE")
    private String adIphone;

    @Column(name = "AD_MOBPHONE")
    private String adMobphone;

    @Column(name = "AD_WORKPHONE")
    private String adWorkphone;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_UPDATE")
    private Date dateUpdate;

    @Column(name = "PHOTO_SRC")
    private String photoSrc;

    @Column(name = "PARENT_CODE_ISPRO")
    private String parentCodeIspro;

    @Column(name = "COMMENT_ERR")
    private String commentErr;

    @Column(name = "CUSTFIRSTNAME")
    private String custfirstname;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "CODE_DOL_ISPRO")
    private String codeDolIspro;

    @Temporal(TemporalType.DATE)
    @Column(name = "WR_DTUVL")
    private Date wrDtuvl;

    @Column(name = "ORDER_BY_POS")
    private Integer orderByPos;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "WR_DTSTR")
    private Date wrDtstr;

    @Column(name = "WR_DEKRET")
    private Integer wrDekret;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "code_ispro",
            referencedColumnName = "code_ispro"
    )
    private TmpIdocDepartment codeIspro;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    public Long getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Long branchCode) {
        this.branchCode = branchCode;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public TmpIdocDepartment getCodeIspro() {
        return codeIspro;
    }

    public void setCodeIspro(TmpIdocDepartment codeIspro) {
        this.codeIspro = codeIspro;
    }


    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getAdEMail() {
        return adEMail;
    }

    public void setAdEMail(String adEMail) {
        this.adEMail = adEMail;
    }


    public String getAdFio() {
        return adFio;
    }

    public void setAdFio(String adFio) {
        this.adFio = adFio;
    }


    public String getAdPosition() {
        return adPosition;
    }

    public void setAdPosition(String adPosition) {
        this.adPosition = adPosition;
    }


    public String getAdIphone() {
        return adIphone;
    }

    public void setAdIphone(String adIphone) {
        this.adIphone = adIphone;
    }


    public String getAdMobphone() {
        return adMobphone;
    }

    public void setAdMobphone(String adMobphone) {
        this.adMobphone = adMobphone;
    }


    public String getAdWorkphone() {
        return adWorkphone;
    }

    public void setAdWorkphone(String adWorkphone) {
        this.adWorkphone = adWorkphone;
    }


    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }




    @Basic
    @Column(name = "PARENT_CODE_ISPRO")
    public String getParentCodeIspro() {
        return parentCodeIspro;
    }

    public void setParentCodeIspro(String parentCodeIspro) {
        this.parentCodeIspro = parentCodeIspro;
    }


    public String getCommentErr() {
        return commentErr;
    }

    public void setCommentErr(String commentErr) {
        this.commentErr = commentErr;
    }


    public String getCustfirstname() {
        return custfirstname;
    }

    public void setCustfirstname(String custfirstname) {
        this.custfirstname = custfirstname;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getCodeDolIspro() {
        return codeDolIspro;
    }

    public void setCodeDolIspro(String codeDolIspro) {
        this.codeDolIspro = codeDolIspro;
    }


    public Date getWrDtuvl() {
        return wrDtuvl;
    }

    public void setWrDtuvl(Date wrDtuvl) {
        this.wrDtuvl = wrDtuvl;
    }


    public Integer getOrderByPos() {
        return orderByPos;
    }

    public void setOrderByPos(Integer orderByPos) {
        this.orderByPos = orderByPos;
    }


    public Date getWrDtstr() {
        return wrDtstr;
    }

    public void setWrDtstr(Date wrDtstr) {
        this.wrDtstr = wrDtstr;
    }

    public Integer getWrDekret() {
        return wrDekret;
    }

    public void setWrDekret(Integer wrDekret) {
        this.wrDekret = wrDekret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmpIdocCombineWorker that = (TmpIdocCombineWorker) o;
        return id == that.id &&
                Objects.equals(fio, that.fio) &&
                Objects.equals(branch, that.branch) &&
                Objects.equals(branchCode, that.branchCode) &&
                Objects.equals(department, that.department) &&
                Objects.equals(division, that.division) &&
                Objects.equals(position, that.position) &&
                Objects.equals(subdivision, that.subdivision) &&
                Objects.equals(codeIspro, that.codeIspro) &&
                Objects.equals(okpo, that.okpo) &&
                Objects.equals(state, that.state) &&
                Objects.equals(adEMail, that.adEMail) &&
                Objects.equals(adFio, that.adFio) &&
                Objects.equals(adPosition, that.adPosition) &&
                Objects.equals(adIphone, that.adIphone) &&
                Objects.equals(adMobphone, that.adMobphone) &&
                Objects.equals(adWorkphone, that.adWorkphone) &&
                Objects.equals(dateUpdate, that.dateUpdate) &&
                Objects.equals(photoSrc, that.photoSrc) &&
                Objects.equals(parentCodeIspro, that.parentCodeIspro) &&
                Objects.equals(commentErr, that.commentErr) &&
                Objects.equals(custfirstname, that.custfirstname) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(codeDolIspro, that.codeDolIspro) &&
                Objects.equals(wrDtuvl, that.wrDtuvl) &&
                Objects.equals(orderByPos, that.orderByPos) &&
                Objects.equals(wrDtstr, that.wrDtstr) &&
                Objects.equals(wrDekret, that.wrDekret);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fio, branch, branchCode, department, division, position, subdivision, codeIspro, okpo, state, adEMail, adFio, adPosition, adIphone, adMobphone, adWorkphone, dateUpdate, photoSrc, parentCodeIspro, commentErr, custfirstname, firstname, lastname, codeDolIspro, wrDtuvl, orderByPos, wrDtstr, wrDekret);
    }


}
