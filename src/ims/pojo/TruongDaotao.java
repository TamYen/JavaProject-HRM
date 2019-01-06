/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "truong_daotao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TruongDaotao.findAll", query = "SELECT t FROM TruongDaotao t")
    , @NamedQuery(name = "TruongDaotao.findByIdDaotao", query = "SELECT t FROM TruongDaotao t WHERE t.idDaotao = :idDaotao")
    , @NamedQuery(name = "TruongDaotao.findByTenDaotao", query = "SELECT t FROM TruongDaotao t WHERE t.tenDaotao = :tenDaotao")})
public class TruongDaotao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_daotao", nullable = false)
    private Integer idDaotao;
    @Column(name = "ten_daotao", length = 2147483647)
    private String tenDaotao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDaotao", fetch = FetchType.LAZY)
    private List<KhoaDaotao> khoaDaotaoList;

    public TruongDaotao() {
    }

    public TruongDaotao(Integer idDaotao) {
        this.idDaotao = idDaotao;
    }

    public Integer getIdDaotao() {
        return idDaotao;
    }

    public void setIdDaotao(Integer idDaotao) {
        this.idDaotao = idDaotao;
    }

    public String getTenDaotao() {
        return tenDaotao;
    }

    public void setTenDaotao(String tenDaotao) {
        this.tenDaotao = tenDaotao;
    }

    @XmlTransient
    public List<KhoaDaotao> getKhoaDaotaoList() {
        return khoaDaotaoList;
    }

    public void setKhoaDaotaoList(List<KhoaDaotao> khoaDaotaoList) {
        this.khoaDaotaoList = khoaDaotaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDaotao != null ? idDaotao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TruongDaotao)) {
            return false;
        }
        TruongDaotao other = (TruongDaotao) object;
        if ((this.idDaotao == null && other.idDaotao != null) || (this.idDaotao != null && !this.idDaotao.equals(other.idDaotao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.TruongDaotao[ idDaotao=" + idDaotao + " ]";
    }
    
}
