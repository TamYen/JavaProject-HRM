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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "chuyennganh", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chuyennganh.findAll", query = "SELECT c FROM Chuyennganh c")
    , @NamedQuery(name = "Chuyennganh.findByMaNganh", query = "SELECT c FROM Chuyennganh c WHERE c.maNganh = :maNganh")
    , @NamedQuery(name = "Chuyennganh.findByTenNganh", query = "SELECT c FROM Chuyennganh c WHERE c.tenNganh = :tenNganh")})
public class Chuyennganh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_nganh")
    private Integer maNganh;
    @Column(name = "ten_nganh")
    private String tenNganh;
    @JoinColumn(name = "ma_khoa", referencedColumnName = "ma_khoa")
    @ManyToOne
    private KhoaDaotao maKhoa;
    @JoinColumn(name = "ma_trinhdo", referencedColumnName = "ma_trinhdo")
    @ManyToOne
    private TrinhdoDaotao maTrinhdo;
    @OneToMany(mappedBy = "chuyennganh")
    private List<Employee> employeeList;

    public Chuyennganh() {
    }

    public Chuyennganh(Integer maNganh) {
        this.maNganh = maNganh;
    }

    public Integer getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(Integer maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public KhoaDaotao getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(KhoaDaotao maKhoa) {
        this.maKhoa = maKhoa;
    }

    public TrinhdoDaotao getMaTrinhdo() {
        return maTrinhdo;
    }

    public void setMaTrinhdo(TrinhdoDaotao maTrinhdo) {
        this.maTrinhdo = maTrinhdo;
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
        hash += (maNganh != null ? maNganh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chuyennganh)) {
            return false;
        }
        Chuyennganh other = (Chuyennganh) object;
        if ((this.maNganh == null && other.maNganh != null) || (this.maNganh != null && !this.maNganh.equals(other.maNganh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.model.Chuyennganh[ maNganh=" + maNganh + " ]";
    }
    
}
