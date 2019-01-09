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
@Table(name = "khoa_daotao", catalog = "quanlinhanvien", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhoaDaotao.findAll", query = "SELECT k FROM KhoaDaotao k")
    , @NamedQuery(name = "KhoaDaotao.findByMaKhoa", query = "SELECT k FROM KhoaDaotao k WHERE k.maKhoa = :maKhoa")
    , @NamedQuery(name = "KhoaDaotao.findByTenKhoa", query = "SELECT k FROM KhoaDaotao k WHERE k.tenKhoa = :tenKhoa")})
public class KhoaDaotao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_khoa")
    private Integer maKhoa;
    @Column(name = "ten_khoa")
    private String tenKhoa;
    @OneToMany(mappedBy = "maKhoa")
    private List<Chuyennganh> chuyennganhList;
    @JoinColumn(name = "id_daotao", referencedColumnName = "id_daotao")
    @ManyToOne(optional = false)
    private TruongDaotao idDaotao;

    public KhoaDaotao() {
    }

    public KhoaDaotao(Integer maKhoa) {
        this.maKhoa = maKhoa;
    }

    public Integer getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(Integer maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @XmlTransient
    public List<Chuyennganh> getChuyennganhList() {
        return chuyennganhList;
    }

    public void setChuyennganhList(List<Chuyennganh> chuyennganhList) {
        this.chuyennganhList = chuyennganhList;
    }

    public TruongDaotao getIdDaotao() {
        return idDaotao;
    }

    public void setIdDaotao(TruongDaotao idDaotao) {
        this.idDaotao = idDaotao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhoa != null ? maKhoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhoaDaotao)) {
            return false;
        }
        KhoaDaotao other = (KhoaDaotao) object;
        if ((this.maKhoa == null && other.maKhoa != null) || (this.maKhoa != null && !this.maKhoa.equals(other.maKhoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenKhoa;
    }
    
}
