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
@Table(name = "trinhdo_daotao", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrinhdoDaotao.findAll", query = "SELECT t FROM TrinhdoDaotao t")
    , @NamedQuery(name = "TrinhdoDaotao.findByMaTrinhdo", query = "SELECT t FROM TrinhdoDaotao t WHERE t.maTrinhdo = :maTrinhdo")
    , @NamedQuery(name = "TrinhdoDaotao.findByTrinhdo", query = "SELECT t FROM TrinhdoDaotao t WHERE t.trinhdo = :trinhdo")})
public class TrinhdoDaotao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_trinhdo")
    private Integer maTrinhdo;
    @Column(name = "trinhdo")
    private String trinhdo;
    @OneToMany(mappedBy = "maTrinhdo")
    private List<Chuyennganh> chuyennganhList;

    public TrinhdoDaotao() {
    }

    public TrinhdoDaotao(Integer maTrinhdo) {
        this.maTrinhdo = maTrinhdo;
    }

    public Integer getMaTrinhdo() {
        return maTrinhdo;
    }

    public void setMaTrinhdo(Integer maTrinhdo) {
        this.maTrinhdo = maTrinhdo;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    @XmlTransient
    public List<Chuyennganh> getChuyennganhList() {
        return chuyennganhList;
    }

    public void setChuyennganhList(List<Chuyennganh> chuyennganhList) {
        this.chuyennganhList = chuyennganhList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTrinhdo != null ? maTrinhdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrinhdoDaotao)) {
            return false;
        }
        TrinhdoDaotao other = (TrinhdoDaotao) object;
        if ((this.maTrinhdo == null && other.maTrinhdo != null) || (this.maTrinhdo != null && !this.maTrinhdo.equals(other.maTrinhdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return trinhdo;
    }
    
}
