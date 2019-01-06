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
@Table(name = "tongiao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tongiao.findAll", query = "SELECT t FROM Tongiao t")
    , @NamedQuery(name = "Tongiao.findByMaTongiao", query = "SELECT t FROM Tongiao t WHERE t.maTongiao = :maTongiao")
    , @NamedQuery(name = "Tongiao.findByTenTongiao", query = "SELECT t FROM Tongiao t WHERE t.tenTongiao = :tenTongiao")})
public class Tongiao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_tongiao", nullable = false)
    private Integer maTongiao;
    @Column(name = "ten_tongiao", length = 2147483647)
    private String tenTongiao;
    @OneToMany(mappedBy = "maTongiao", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Tongiao() {
    }

    public Tongiao(Integer maTongiao) {
        this.maTongiao = maTongiao;
    }

    public Integer getMaTongiao() {
        return maTongiao;
    }

    public void setMaTongiao(Integer maTongiao) {
        this.maTongiao = maTongiao;
    }

    public String getTenTongiao() {
        return tenTongiao;
    }

    public void setTenTongiao(String tenTongiao) {
        this.tenTongiao = tenTongiao;
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
        hash += (maTongiao != null ? maTongiao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tongiao)) {
            return false;
        }
        Tongiao other = (Tongiao) object;
        if ((this.maTongiao == null && other.maTongiao != null) || (this.maTongiao != null && !this.maTongiao.equals(other.maTongiao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.Tongiao[ maTongiao=" + maTongiao + " ]";
    }
    
}
