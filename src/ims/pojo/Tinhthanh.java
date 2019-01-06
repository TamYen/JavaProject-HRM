/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ANHB
 */
@Entity
@Table(name = "Tinhthanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tinhthanh.findAll", query = "SELECT t FROM Tinhthanh t")
    , @NamedQuery(name = "Tinhthanh.findByMatinhthanh", query = "SELECT t FROM Tinhthanh t WHERE t.matinhthanh = :matinhthanh")
    , @NamedQuery(name = "Tinhthanh.findByTentinhthanh", query = "SELECT t FROM Tinhthanh t WHERE t.tentinhthanh = :tentinhthanh")})
public class Tinhthanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Ma_tinhthanh", nullable = false)
    private Integer matinhthanh;
    @Column(name = "tentinhthanh", length = 2147483647)
    private String tentinhthanh;
    @OneToMany(mappedBy = "nguyenquan", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "noicapCmnd", fetch = FetchType.LAZY)
    private List<Employee> employeeList1;
    @OneToMany(mappedBy = "noicapHochieu", fetch = FetchType.LAZY)
    private List<Employee> employeeList2;
    @OneToMany(mappedBy = "noisinh", fetch = FetchType.LAZY)
    private List<Employee> employeeList3;

    public Tinhthanh() {
    }

    public Tinhthanh(Integer matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    public Integer getMatinhthanh() {
        return matinhthanh;
    }

    public void setMatinhthanh(Integer matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    public String getTentinhthanh() {
        return tentinhthanh;
    }

    public void setTentinhthanh(String tentinhthanh) {
        this.tentinhthanh = tentinhthanh;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @XmlTransient
    public List<Employee> getEmployeeList1() {
        return employeeList1;
    }

    public void setEmployeeList1(List<Employee> employeeList1) {
        this.employeeList1 = employeeList1;
    }

    @XmlTransient
    public List<Employee> getEmployeeList2() {
        return employeeList2;
    }

    public void setEmployeeList2(List<Employee> employeeList2) {
        this.employeeList2 = employeeList2;
    }

    @XmlTransient
    public List<Employee> getEmployeeList3() {
        return employeeList3;
    }

    public void setEmployeeList3(List<Employee> employeeList3) {
        this.employeeList3 = employeeList3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matinhthanh != null ? matinhthanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tinhthanh)) {
            return false;
        }
        Tinhthanh other = (Tinhthanh) object;
        if ((this.matinhthanh == null && other.matinhthanh != null) || (this.matinhthanh != null && !this.matinhthanh.equals(other.matinhthanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.Tinhthanh[ matinhthanh=" + matinhthanh + " ]";
    }
    
}
