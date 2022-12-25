package com.example.bd_rgr.entity.storeDirection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "seller", schema = "public", catalog = "chain_of_stores")
public class SellerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "surname", nullable = true, length = 255)
    private String surname;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "middle_name", nullable = true, length = 255)
    private String middleName;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Basic
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;

    @Basic
    @Column(name = "passport_id", nullable = true, length = 255)
    private String passportId;

    @Basic
    @Column(name = "date_of_issue", nullable = true)
    private Date dateOfIssue;

    @Basic
    @Column(name = "institution", nullable = true, length = 255)
    private String institution;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference
    private Collection<RevenueEntity> revenues;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private DepartmentEntity department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Collection<RevenueEntity> getRevenues() {
        return revenues;
    }

    public void setRevenues(Collection<RevenueEntity> revenues) {
        this.revenues = revenues;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public String getFullName() {
        return name + " " + surname + " " + middleName;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }

}
