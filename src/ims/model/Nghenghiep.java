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
@Table(name = "nghenghiep", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nghenghiep.findAll", query = "SELECT n FROM Nghenghiep n")
    , @NamedQuery(name = "Nghenghiep.findByMaNghe", query = "SELECT n FROM Nghenghiep n WHERE n.maNghe = :maNghe")
    , @NamedQuery(name = "Nghenghiep.findByTennghe", query = "SELECT n FROM Nghenghiep n WHERE n.tennghe = :tennghe")})
public class Nghenghiep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_nghe")
    private Integer maNghe;
    @Column(name = "tennghe")
    private String tennghe;
    @OneToMany(mappedBy = "maNghe")
    private List<Employee> employeeList;

    public Nghenghiep() {
    }

    public Nghenghiep(Integer maNghe) {
        this.maNghe = maNghe;
    }

    public Integer getMaNghe() {
        return maNghe;
    }

    public void setMaNghe(Integer maNghe) {
        this.maNghe = maNghe;
    }

    public String getTennghe() {
        return tennghe;
    }

    public void setTennghe(String tennghe) {
        this.tennghe = tennghe;
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
        hash += (maNghe != null ? maNghe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nghenghiep)) {
            return false;
        }
        Nghenghiep other = (Nghenghiep) object;
        if ((this.maNghe == null && other.maNghe != null) || (this.maNghe != null && !this.maNghe.equals(other.maNghe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.model.Nghenghiep[ maNghe=" + maNghe + " ]";
    }
    
}
