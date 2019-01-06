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
@Table(name = "thanhphan_giadinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThanhphanGiadinh.findAll", query = "SELECT t FROM ThanhphanGiadinh t")
    , @NamedQuery(name = "ThanhphanGiadinh.findByIdTp", query = "SELECT t FROM ThanhphanGiadinh t WHERE t.idTp = :idTp")
    , @NamedQuery(name = "ThanhphanGiadinh.findByTenThanhphan", query = "SELECT t FROM ThanhphanGiadinh t WHERE t.tenThanhphan = :tenThanhphan")})
public class ThanhphanGiadinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tp", nullable = false)
    private Integer idTp;
    @Column(name = "ten_thanhphan", length = 2147483647)
    private String tenThanhphan;
    @OneToMany(mappedBy = "idTp", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public ThanhphanGiadinh() {
    }

    public ThanhphanGiadinh(Integer idTp) {
        this.idTp = idTp;
    }

    public Integer getIdTp() {
        return idTp;
    }

    public void setIdTp(Integer idTp) {
        this.idTp = idTp;
    }

    public String getTenThanhphan() {
        return tenThanhphan;
    }

    public void setTenThanhphan(String tenThanhphan) {
        this.tenThanhphan = tenThanhphan;
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
        hash += (idTp != null ? idTp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThanhphanGiadinh)) {
            return false;
        }
        ThanhphanGiadinh other = (ThanhphanGiadinh) object;
        if ((this.idTp == null && other.idTp != null) || (this.idTp != null && !this.idTp.equals(other.idTp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.ThanhphanGiadinh[ idTp=" + idTp + " ]";
    }
    
}
