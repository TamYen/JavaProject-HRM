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
@Table(name = "quocgia", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quocgia.findAll", query = "SELECT q FROM Quocgia q")
    , @NamedQuery(name = "Quocgia.findByMaQuocgia", query = "SELECT q FROM Quocgia q WHERE q.maQuocgia = :maQuocgia")
    , @NamedQuery(name = "Quocgia.findByTenQuocgia", query = "SELECT q FROM Quocgia q WHERE q.tenQuocgia = :tenQuocgia")})
public class Quocgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_quocgia")
    private Integer maQuocgia;
    @Column(name = "ten_quocgia")
    private String tenQuocgia;
    @OneToMany(mappedBy = "quoctich")
    private List<Employee> employeeList;

    public Quocgia() {
    }

    public Quocgia(Integer maQuocgia) {
        this.maQuocgia = maQuocgia;
    }

    public Integer getMaQuocgia() {
        return maQuocgia;
    }

    public void setMaQuocgia(Integer maQuocgia) {
        this.maQuocgia = maQuocgia;
    }

    public String getTenQuocgia() {
        return tenQuocgia;
    }

    public void setTenQuocgia(String tenQuocgia) {
        this.tenQuocgia = tenQuocgia;
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
        hash += (maQuocgia != null ? maQuocgia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quocgia)) {
            return false;
        }
        Quocgia other = (Quocgia) object;
        if ((this.maQuocgia == null && other.maQuocgia != null) || (this.maQuocgia != null && !this.maQuocgia.equals(other.maQuocgia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenQuocgia;
    }
    
}
