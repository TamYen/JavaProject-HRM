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
@Table(name = "xeploai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Xeploai.findAll", query = "SELECT x FROM Xeploai x")
    , @NamedQuery(name = "Xeploai.findByMaLoai", query = "SELECT x FROM Xeploai x WHERE x.maLoai = :maLoai")
    , @NamedQuery(name = "Xeploai.findByTenloai", query = "SELECT x FROM Xeploai x WHERE x.tenloai = :tenloai")})
public class Xeploai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_loai", nullable = false)
    private Integer maLoai;
    @Column(name = "tenloai", length = 2147483647)
    private String tenloai;
    @OneToMany(mappedBy = "maLoai", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Xeploai() {
    }

    public Xeploai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
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
        hash += (maLoai != null ? maLoai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Xeploai)) {
            return false;
        }
        Xeploai other = (Xeploai) object;
        if ((this.maLoai == null && other.maLoai != null) || (this.maLoai != null && !this.maLoai.equals(other.maLoai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.Xeploai[ maLoai=" + maLoai + " ]";
    }
    
}
