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
@Table(name = "quocgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuocGia.findAll", query = "SELECT q FROM QuocGia q")
    , @NamedQuery(name = "QuocGia.findByMaQuocgia", query = "SELECT q FROM QuocGia q WHERE q.maQuocgia = :maQuocgia")
    , @NamedQuery(name = "QuocGia.findByTenQuocgia", query = "SELECT q FROM QuocGia q WHERE q.tenQuocgia = :tenQuocgia")})
public class QuocGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_quocgia", nullable = false)
    private Integer maQuocgia;
    @Column(name = "ten_quocgia", length = 2147483647)
    private String tenQuocgia;
    @OneToMany(mappedBy = "quoctich", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public QuocGia() {
    }

    public QuocGia(Integer maQuocgia) {
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
        if (!(object instanceof QuocGia)) {
            return false;
        }
        QuocGia other = (QuocGia) object;
        if ((this.maQuocgia == null && other.maQuocgia != null) || (this.maQuocgia != null && !this.maQuocgia.equals(other.maQuocgia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.QuocGia[ maQuocgia=" + maQuocgia + " ]";
    }
    
}
