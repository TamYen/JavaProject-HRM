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
@Table(name = "dantoc", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dantoc.findAll", query = "SELECT d FROM Dantoc d")
    , @NamedQuery(name = "Dantoc.findByMaDantoc", query = "SELECT d FROM Dantoc d WHERE d.maDantoc = :maDantoc")
    , @NamedQuery(name = "Dantoc.findByDantoc", query = "SELECT d FROM Dantoc d WHERE d.dantoc = :dantoc")})
public class Dantoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_dantoc")
    private Integer maDantoc;
    @Column(name = "dantoc")
    private String dantoc;
    @OneToMany(mappedBy = "maDantoc")
    private List<Employee> employeeList;

    public Dantoc() {
    }

    public Dantoc(Integer maDantoc) {
        this.maDantoc = maDantoc;
    }

    public Integer getMaDantoc() {
        return maDantoc;
    }

    public void setMaDantoc(Integer maDantoc) {
        this.maDantoc = maDantoc;
    }

    public String getDantoc() {
        return dantoc;
    }

    public void setDantoc(String dantoc) {
        this.dantoc = dantoc;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDantoc != null ? maDantoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dantoc)) {
            return false;
        }
        Dantoc other = (Dantoc) object;
        if ((this.maDantoc == null && other.maDantoc != null) || (this.maDantoc != null && !this.maDantoc.equals(other.maDantoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dantoc;
    }
    
}
