/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANHB
 */
@Entity
@Table(name = "Employee", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CMND"})
    , @UniqueConstraint(columnNames = {"Sohochieu"})
    , @UniqueConstraint(columnNames = {"ma_chamcong"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByMaNV", query = "SELECT e FROM Employee e WHERE e.maNV = :maNV")
    , @NamedQuery(name = "Employee.findByMaChamcong", query = "SELECT e FROM Employee e WHERE e.maChamcong = :maChamcong")
    , @NamedQuery(name = "Employee.findByTenHoDem", query = "SELECT e FROM Employee e WHERE e.tenHoDem = :tenHoDem")
    , @NamedQuery(name = "Employee.findByTen", query = "SELECT e FROM Employee e WHERE e.ten = :ten")
    , @NamedQuery(name = "Employee.findByNgaySinh", query = "SELECT e FROM Employee e WHERE e.ngaySinh = :ngaySinh")
    , @NamedQuery(name = "Employee.findByCmnd", query = "SELECT e FROM Employee e WHERE e.cmnd = :cmnd")
    , @NamedQuery(name = "Employee.findByCMNDngaycap", query = "SELECT e FROM Employee e WHERE e.cMNDngaycap = :cMNDngaycap")
    , @NamedQuery(name = "Employee.findBySohochieu", query = "SELECT e FROM Employee e WHERE e.sohochieu = :sohochieu")
    , @NamedQuery(name = "Employee.findByNgaycapHochieu", query = "SELECT e FROM Employee e WHERE e.ngaycapHochieu = :ngaycapHochieu")
    , @NamedQuery(name = "Employee.findByHethanHochieu", query = "SELECT e FROM Employee e WHERE e.hethanHochieu = :hethanHochieu")
    , @NamedQuery(name = "Employee.findByTrinhdovanhoa", query = "SELECT e FROM Employee e WHERE e.trinhdovanhoa = :trinhdovanhoa")
    , @NamedQuery(name = "Employee.findByNamtotnghiep", query = "SELECT e FROM Employee e WHERE e.namtotnghiep = :namtotnghiep")
    , @NamedQuery(name = "Employee.findByHinhanh", query = "SELECT e FROM Employee e WHERE e.hinhanh = :hinhanh")
    , @NamedQuery(name = "Employee.findBySex", query = "SELECT e FROM Employee e WHERE e.sex = :sex")
    , @NamedQuery(name = "Employee.findByTinhtrangHonnhan", query = "SELECT e FROM Employee e WHERE e.tinhtrangHonnhan = :tinhtrangHonnhan")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNV", nullable = false, length = 2147483647)
    private String maNV;
    @Basic(optional = false)
    @Column(name = "ma_chamcong", nullable = false, length = 2147483647)
    private String maChamcong;
    @Column(name = "ten_ho_dem", length = 2147483647)
    private String tenHoDem;
    @Column(name = "ten", length = 2147483647)
    private String ten;
    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "CMND", length = 20)
    private String cmnd;
    @Column(name = "CMND_ngaycap")
    @Temporal(TemporalType.DATE)
    private Date cMNDngaycap;
    @Column(name = "Sohochieu", length = 20)
    private String sohochieu;
    @Column(name = "ngaycap_hochieu")
    @Temporal(TemporalType.DATE)
    private Date ngaycapHochieu;
    @Column(name = "hethan_hochieu")
    @Temporal(TemporalType.DATE)
    private Date hethanHochieu;
    @Column(name = "trinhdovanhoa", length = 2147483647)
    private String trinhdovanhoa;
    @Column(name = "namtotnghiep")
    private Integer namtotnghiep;
    @Column(name = "hinhanh", length = 2147483647)
    private String hinhanh;
    @Column(name = "sex")
    private Boolean sex;
    @Column(name = "tinhtrang_honnhan")
    private Boolean tinhtrangHonnhan;
    @JoinColumn(name = "ma_nghe", referencedColumnName = "ma_nghe")
    @ManyToOne(fetch = FetchType.LAZY)
    private NgheNghiep maNghe;
    @JoinColumn(name = "nguyenquan", referencedColumnName = "Ma_tinhthanh")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tinhthanh nguyenquan;
    @JoinColumn(name = "noicap_cmnd", referencedColumnName = "Ma_tinhthanh")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tinhthanh noicapCmnd;
    @JoinColumn(name = "noicap_hochieu", referencedColumnName = "Ma_tinhthanh")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tinhthanh noicapHochieu;
    @JoinColumn(name = "noisinh", referencedColumnName = "Ma_tinhthanh")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tinhthanh noisinh;
    @JoinColumn(name = "chuyennganh", referencedColumnName = "ma_nganh")
    @ManyToOne(fetch = FetchType.LAZY)
    private Chuyennganh chuyennganh;
    @JoinColumn(name = "ma_dantoc", referencedColumnName = "ma_dantoc")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dantoc maDantoc;
    @JoinColumn(name = "quoctich", referencedColumnName = "ma_quocgia")
    @ManyToOne(fetch = FetchType.LAZY)
    private QuocGia quoctich;
    @JoinColumn(name = "id_tp", referencedColumnName = "id_tp")
    @ManyToOne(fetch = FetchType.LAZY)
    private ThanhphanGiadinh idTp;
    @JoinColumn(name = "ma_tongiao", referencedColumnName = "ma_tongiao")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tongiao maTongiao;
    @JoinColumn(name = "ma_loai", referencedColumnName = "ma_loai")
    @ManyToOne(fetch = FetchType.LAZY)
    private Xeploai maLoai;

    public Employee() {
    }

    public Employee(String maNV) {
        this.maNV = maNV;
    }

    public Employee(String maNV, String maChamcong) {
        this.maNV = maNV;
        this.maChamcong = maChamcong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaChamcong() {
        return maChamcong;
    }

    public void setMaChamcong(String maChamcong) {
        this.maChamcong = maChamcong;
    }

    public String getTenHoDem() {
        return tenHoDem;
    }

    public void setTenHoDem(String tenHoDem) {
        this.tenHoDem = tenHoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getCMNDngaycap() {
        return cMNDngaycap;
    }

    public void setCMNDngaycap(Date cMNDngaycap) {
        this.cMNDngaycap = cMNDngaycap;
    }

    public String getSohochieu() {
        return sohochieu;
    }

    public void setSohochieu(String sohochieu) {
        this.sohochieu = sohochieu;
    }

    public Date getNgaycapHochieu() {
        return ngaycapHochieu;
    }

    public void setNgaycapHochieu(Date ngaycapHochieu) {
        this.ngaycapHochieu = ngaycapHochieu;
    }

    public Date getHethanHochieu() {
        return hethanHochieu;
    }

    public void setHethanHochieu(Date hethanHochieu) {
        this.hethanHochieu = hethanHochieu;
    }

    public String getTrinhdovanhoa() {
        return trinhdovanhoa;
    }

    public void setTrinhdovanhoa(String trinhdovanhoa) {
        this.trinhdovanhoa = trinhdovanhoa;
    }

    public Integer getNamtotnghiep() {
        return namtotnghiep;
    }

    public void setNamtotnghiep(Integer namtotnghiep) {
        this.namtotnghiep = namtotnghiep;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getTinhtrangHonnhan() {
        return tinhtrangHonnhan;
    }

    public void setTinhtrangHonnhan(Boolean tinhtrangHonnhan) {
        this.tinhtrangHonnhan = tinhtrangHonnhan;
    }

    public NgheNghiep getMaNghe() {
        return maNghe;
    }

    public void setMaNghe(NgheNghiep maNghe) {
        this.maNghe = maNghe;
    }

    public Tinhthanh getNguyenquan() {
        return nguyenquan;
    }

    public void setNguyenquan(Tinhthanh nguyenquan) {
        this.nguyenquan = nguyenquan;
    }

    public Tinhthanh getNoicapCmnd() {
        return noicapCmnd;
    }

    public void setNoicapCmnd(Tinhthanh noicapCmnd) {
        this.noicapCmnd = noicapCmnd;
    }

    public Tinhthanh getNoicapHochieu() {
        return noicapHochieu;
    }

    public void setNoicapHochieu(Tinhthanh noicapHochieu) {
        this.noicapHochieu = noicapHochieu;
    }

    public Tinhthanh getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(Tinhthanh noisinh) {
        this.noisinh = noisinh;
    }

    public Chuyennganh getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(Chuyennganh chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public Dantoc getMaDantoc() {
        return maDantoc;
    }

    public void setMaDantoc(Dantoc maDantoc) {
        this.maDantoc = maDantoc;
    }

    public QuocGia getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(QuocGia quoctich) {
        this.quoctich = quoctich;
    }

    public ThanhphanGiadinh getIdTp() {
        return idTp;
    }

    public void setIdTp(ThanhphanGiadinh idTp) {
        this.idTp = idTp;
    }

    public Tongiao getMaTongiao() {
        return maTongiao;
    }

    public void setMaTongiao(Tongiao maTongiao) {
        this.maTongiao = maTongiao;
    }

    public Xeploai getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Xeploai maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ims.pojo.Employee[ maNV=" + maNV + " ]";
    }
    
}
