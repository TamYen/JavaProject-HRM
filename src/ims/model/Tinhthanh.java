/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tinhthanh", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tinhthanh.findAll", query = "SELECT t FROM Tinhthanh t")
    , @NamedQuery(name = "Tinhthanh.findByMaTinhthanh", query = "SELECT t FROM Tinhthanh t WHERE t.maTinhthanh = :maTinhthanh")
    , @NamedQuery(name = "Tinhthanh.findByTentinhthanh", query = "SELECT t FROM Tinhthanh t WHERE t.tentinhthanh = :tentinhthanh")})
public class Tinhthanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_tinhthanh")
    private Integer maTinhthanh;
    @Column(name = "tentinhthanh")
    private String tentinhthanh;
    @OneToMany(mappedBy = "nguyenquan")
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "noicapCmnd")
    private List<Employee> employeeList1;
    @OneToMany(mappedBy = "noicapHochieu")
    private List<Employee> employeeList2;
    @OneToMany(mappedBy = "noisinh")
    private List<Employee> employeeList3;

    public Tinhthanh() {
    }

    public Tinhthanh(Integer maTinhthanh) {
        this.maTinhthanh = maTinhthanh;
    }

    public Integer getMaTinhthanh() {
        return maTinhthanh;
    }

    public void setMaTinhthanh(Integer maTinhthanh) {
        this.maTinhthanh = maTinhthanh;
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
        hash += (maTinhthanh != null ? maTinhthanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tinhthanh)) {
            return false;
        }
        Tinhthanh other = (Tinhthanh) object;
        if ((this.maTinhthanh == null && other.maTinhthanh != null) || (this.maTinhthanh != null && !this.maTinhthanh.equals(other.maTinhthanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.model.Tinhthanh[ maTinhthanh=" + maTinhthanh + " ]";
    }
    
}
