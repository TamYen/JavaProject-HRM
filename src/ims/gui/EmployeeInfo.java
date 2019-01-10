/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.gui;

import ims.bll.ChuyennganhBLL;
import ims.bll.DantocBLL;
import ims.bll.EmployeeBLL;
import ims.bll.KhoaDaotaoBLL;
import ims.bll.NghenghiepBLL;
import ims.bll.QuocgiaBLL;
import ims.bll.ThanhphanGiadinhBLL;
import ims.bll.TinhthanhBLL;
import ims.bll.TongiaoBLL;
import ims.bll.TrinhdoDaotaoBLL;
import ims.bll.TruongDaotaoBLL;
import ims.bll.XeploaiBLL;
import ims.model.Chuyennganh;
import ims.model.Dantoc;
import ims.model.Employee;
import ims.model.KhoaDaotao;
import ims.model.Nghenghiep;
import ims.model.Quocgia;
import ims.model.ThanhphanGiadinh;
import ims.model.Tinhthanh;
import ims.model.Tongiao;
import ims.model.TrinhdoDaotao;
import ims.model.TruongDaotao;
import ims.model.Xeploai;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author NAT
 */
public class EmployeeInfo extends JDialog {

    private Employee e;

    public Employee getEmployee() {
        return e;
    }

    public void setEmployee(Employee employee) {
        
        this.e = employee;
        
    }
    
    public void setContentToEdit(){
        setTitle("Sua nhan vien");
        stateButton(true);
        txtMaNV.setText(e.getMaNv());
        txtMaCC.setText(e.getMaChamcong());
        txtHoDem.setText(e.getTenHoDem());
        txtTen.setText(e.getTen());
        txtHoTen.setText(e.getTenHoDem()+" "+e.getTen());
        txtNoiCapCMND.setText(e.getNoicapCmnd());
        txtSoHoChieu.setText(e.getSohochieu());
        txtNoiSinh.setText(e.getNoisinh());
        txtNguyenQuan.setText(e.getNguyenquan().getTentinhthanh());
        cbxNguyenQuan.setSelectedItem(e.getNguyenquan());
        txtCMND.setText(e.getCmnd());
        ////////////////////
        if(e.getCmndNgaycap() != null)
            txtNgayCapCMND.setText(parseDate(e.getCmndNgaycap().toString()));
        if(e.getNgaySinh() != null)
            txtNgaysinh.setText(parseDate(e.getNgaySinh().toString()));
        if(e.getNgaycapHochieu() != null)
            txtNgaycapHC.setText(parseDate(e.getNgaycapHochieu().toString()));
        if(e.getHethanHochieu() != null)
            txtNgayHetHC.setText(parseDate(e.getHethanHochieu().toString()));
        txtNoiCapHC.setText(e.getNoicapHochieu());
        /////////////////
        if(e.getTinhtrangHonnhan() == null){
            cbxHonNhan.setSelectedIndex(-1);
        }else if(e.getTinhtrangHonnhan() == false){
            cbxHonNhan.setSelectedIndex(1);
        }else cbxHonNhan.setSelectedIndex(0);
        
        if(e.getSex() == false){
            cbxSex.setSelectedItem(1);
        }else cbxSex.setSelectedItem(0);
        
        cbxGiaDinh.setSelectedItem(e.getIdTp());
        cbxDanToc.setSelectedItem(e.getMaDantoc());
        cbxTonGiao.setSelectedItem(e.getMaTongiao());
        cbxQuocTich.setSelectedItem(e.getQuoctich());
        txtTrinhDoVanHoa.setText(e.getTrinhdovanhoa());
        cbxTrinhDoDaoTao.setSelectedItem(e.getChuyennganh().getMaTrinhdo());
        cbxUniversity.setSelectedItem(e.getChuyennganh().getMaKhoa().getIdDaotao());
        cbxKhoaDaoTao.setSelectedItem(e.getChuyennganh().getMaKhoa());
        cbxChuyenNganh.setSelectedItem(e.getChuyennganh());
        spnNamTotNghiep.setValue(e.getNamtotnghiep());
        cbxXepLoai.setSelectedItem(e.getMaLoai());
        cbxNgheNghiep.setSelectedItem(e.getMaNghe());
    }
    
    public EmployeeInfo(Frame owner) {
        super(owner, true);
        initComponents();
        setTitle("Them nhan vien");
        stateButton(false);
        setInfoDialog();
        fillInfoCbx();
    }
    /**
     * Creates new form Employee
     */
    public EmployeeInfo() {
        initComponents();
        this.setBackground(Color.yellow);
        stateButton(false);
        setInfoDialog();
        fillInfoCbx();
        
    }
    
    private static SessionFactory factory;
    
    private void fillInfoCbx(){
        setContentCbxQuocTich();
        setContentCbxDantoc();
        setContentCbxTonGiao();
//        setContentCbxChuyenNganh();
        
        setContentCbxNgheNghiep();
        setContentCbxThanhphanGiadinh();
        setContentCbxNguyenQuan();
//        setContentCbxTrinhdoDaotao();
        setContentCbxNoiDaotao();
        setContentCbxXeploai();
    }

    private  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("width: "+ getWidth()+ " dimension.getWidth(): "+ dimension.getWidth());
        System.out.println("width: "+ getHeight()+ " dimension.getWidth(): "+ dimension.getHeight());
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(true);
    }
    public void stateButton(boolean value){
        
//        btNew.setVisible(value);
        btEdit.setVisible(value);
        btDelete.setVisible(value);
        btPrint.setVisible(value);
        btClose.setVisible(value);
        btSave.setVisible(!value);
        btCancel.setVisible(!value);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelRight = new javax.swing.JPanel();
        spnNamTotNghiep = new javax.swing.JSpinner();
        cbxChuyenNganh = new javax.swing.JComboBox<>();
        cbxUniversity = new javax.swing.JComboBox<>();
        btnFa = new javax.swing.JButton();
        btnMajor = new javax.swing.JButton();
        btnTrinhdo = new javax.swing.JButton();
        cbxXepLoai = new javax.swing.JComboBox<>();
        btnUniversity = new javax.swing.JButton();
        cbxTrinhDoDaoTao = new javax.swing.JComboBox<>();
        btnJob = new javax.swing.JButton();
        cbxKhoaDaoTao = new javax.swing.JComboBox<>();
        cbxNgheNghiep = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnRank = new javax.swing.JButton();
        txtTrinhDoVanHoa = new javax.swing.JFormattedTextField();
        panelLeft = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNoiCapCMND = new javax.swing.JTextField();
        txtNoiCapHC = new javax.swing.JTextField();
        cbxHonNhan = new javax.swing.JComboBox<>();
        cbxTonGiao = new javax.swing.JComboBox<>();
        cbxDanToc = new javax.swing.JComboBox<>();
        cbxQuocTich = new javax.swing.JComboBox<>();
        cbxGiaDinh = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txtNgayHetHC = new javax.swing.JFormattedTextField();
        txtNgayCapCMND = new javax.swing.JFormattedTextField();
        txtNgaycapHC = new javax.swing.JFormattedTextField();
        txtSoHoChieu = new javax.swing.JFormattedTextField();
        txtCMND = new javax.swing.JFormattedTextField();
        panelTop = new javax.swing.JPanel();
        txtMaNV = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtHoDem = new javax.swing.JTextField();
        txtNoiSinh = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxSex = new javax.swing.JComboBox<>();
        txtMaCC = new javax.swing.JTextField();
        txtNguyenQuan = new javax.swing.JTextField();
        panelImage = new javax.swing.JPanel();
        cbxNguyenQuan = new javax.swing.JComboBox<>();
        txtNgaysinh = new javax.swing.JFormattedTextField();
        panelButton = new javax.swing.JPanel();
        btSave = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelRight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 204, 255))); // NOI18N
        panelRight.setMinimumSize(new java.awt.Dimension(525, 275));
        panelRight.setPreferredSize(new java.awt.Dimension(525, 275));
        panelRight.setLayout(new java.awt.GridBagLayout());

        spnNamTotNghiep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnNamTotNghiep.setModel(new javax.swing.SpinnerNumberModel(2010, 1960, 2100, 1));
        spnNamTotNghiep.setMinimumSize(new java.awt.Dimension(140, 30));
        spnNamTotNghiep.setPreferredSize(new java.awt.Dimension(140, 30));
        spnNamTotNghiep.setValue(2015);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(spnNamTotNghiep, gridBagConstraints);

        cbxChuyenNganh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxChuyenNganh.setMinimumSize(new java.awt.Dimension(280, 30));
        cbxChuyenNganh.setPreferredSize(new java.awt.Dimension(280, 30));
        cbxChuyenNganh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxChuyenNganhItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(cbxChuyenNganh, gridBagConstraints);

        cbxUniversity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxUniversity.setMinimumSize(new java.awt.Dimension(280, 30));
        cbxUniversity.setPreferredSize(new java.awt.Dimension(280, 30));
        cbxUniversity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUniversityItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(cbxUniversity, gridBagConstraints);

        btnFa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFa.setText("...");
        btnFa.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(btnFa, gridBagConstraints);

        btnMajor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMajor.setText("...");
        btnMajor.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(btnMajor, gridBagConstraints);

        btnTrinhdo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTrinhdo.setText("...");
        btnTrinhdo.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(btnTrinhdo, gridBagConstraints);

        cbxXepLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxXepLoai.setMinimumSize(new java.awt.Dimension(280, 30));
        cbxXepLoai.setPreferredSize(new java.awt.Dimension(280, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(cbxXepLoai, gridBagConstraints);

        btnUniversity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUniversity.setText("...");
        btnUniversity.setMargin(new java.awt.Insets(1, -4, 1, -4));
        btnUniversity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUniversityActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(btnUniversity, gridBagConstraints);

        cbxTrinhDoDaoTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTrinhDoDaoTao.setMinimumSize(new java.awt.Dimension(280, 30));
        cbxTrinhDoDaoTao.setPreferredSize(new java.awt.Dimension(280, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        panelRight.add(cbxTrinhDoDaoTao, gridBagConstraints);

        btnJob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnJob.setText("...");
        btnJob.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(btnJob, gridBagConstraints);

        cbxKhoaDaoTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxKhoaDaoTao.setMinimumSize(new java.awt.Dimension(280, 30));
        cbxKhoaDaoTao.setPreferredSize(new java.awt.Dimension(280, 30));
        cbxKhoaDaoTao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxKhoaDaoTaoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(cbxKhoaDaoTao, gridBagConstraints);

        cbxNgheNghiep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxNgheNghiep.setMinimumSize(new java.awt.Dimension(280, 30));
        cbxNgheNghiep.setPreferredSize(new java.awt.Dimension(280, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(cbxNgheNghiep, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Trình độ văn hóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        panelRight.add(jLabel1, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Trình độ đào tạo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nơi đào tạo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel9, gridBagConstraints);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Khoa đào tạo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel25, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Chuyên ngành");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel26, gridBagConstraints);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Năm tốt nghiệp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel27, gridBagConstraints);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Xếp loại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel28, gridBagConstraints);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Nghề nghiệp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(jLabel29, gridBagConstraints);

        btnRank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRank.setText("...");
        btnRank.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelRight.add(btnRank, gridBagConstraints);

        try {
            txtTrinhDoVanHoa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTrinhDoVanHoa.setMinimumSize(new java.awt.Dimension(316, 30));
        txtTrinhDoVanHoa.setPreferredSize(new java.awt.Dimension(316, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelRight.add(txtTrinhDoVanHoa, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.ipadx = -45;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        getContentPane().add(panelRight, gridBagConstraints);

        panelLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 204, 255))); // NOI18N
        panelLeft.setMinimumSize(new java.awt.Dimension(490, 340));
        panelLeft.setOpaque(false);
        panelLeft.setPreferredSize(new java.awt.Dimension(490, 340));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Số hộ chiếu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel17, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Nơi cấp CMND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        panelLeft.add(jLabel16, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("TP Gia đình");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel21, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Số CMND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel15, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Quốc tịch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel24, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Tôn giáo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel23, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Ngày cấp HC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel18, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Nơi cấp HC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel19, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Dân tộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel22, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("TT hôn nhân");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelLeft.add(jLabel20, gridBagConstraints);

        txtNoiCapCMND.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoiCapCMND.setMinimumSize(new java.awt.Dimension(391, 30));
        txtNoiCapCMND.setPreferredSize(new java.awt.Dimension(391, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(txtNoiCapCMND, gridBagConstraints);

        txtNoiCapHC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoiCapHC.setMinimumSize(new java.awt.Dimension(391, 30));
        txtNoiCapHC.setPreferredSize(new java.awt.Dimension(391, 30));
        txtNoiCapHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoiCapHCActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(txtNoiCapHC, gridBagConstraints);

        cbxHonNhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxHonNhan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã kết hôn", "Độc thân" }));
        cbxHonNhan.setMinimumSize(new java.awt.Dimension(335, 30));
        cbxHonNhan.setPreferredSize(new java.awt.Dimension(335, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(cbxHonNhan, gridBagConstraints);

        cbxTonGiao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTonGiao.setMinimumSize(new java.awt.Dimension(335, 30));
        cbxTonGiao.setPreferredSize(new java.awt.Dimension(335, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(cbxTonGiao, gridBagConstraints);

        cbxDanToc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxDanToc.setMinimumSize(new java.awt.Dimension(335, 30));
        cbxDanToc.setPreferredSize(new java.awt.Dimension(335, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(cbxDanToc, gridBagConstraints);

        cbxQuocTich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxQuocTich.setMinimumSize(new java.awt.Dimension(335, 30));
        cbxQuocTich.setPreferredSize(new java.awt.Dimension(335, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(cbxQuocTich, gridBagConstraints);

        cbxGiaDinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxGiaDinh.setMinimumSize(new java.awt.Dimension(335, 30));
        cbxGiaDinh.setPreferredSize(new java.awt.Dimension(335, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(cbxGiaDinh, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ngày cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelLeft.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày hết hạn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelLeft.add(jLabel3, gridBagConstraints);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("...");
        jButton8.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        panelLeft.add(jButton8, gridBagConstraints);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("...");
        jButton7.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        panelLeft.add(jButton7, gridBagConstraints);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("...");
        jButton11.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        panelLeft.add(jButton11, gridBagConstraints);

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("...");
        jButton12.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        panelLeft.add(jButton12, gridBagConstraints);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("...");
        jButton9.setMargin(new java.awt.Insets(1, -4, 1, -4));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        panelLeft.add(jButton9, gridBagConstraints);

        txtNgayHetHC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txtNgayHetHC.setMinimumSize(new java.awt.Dimension(125, 30));
        txtNgayHetHC.setPreferredSize(new java.awt.Dimension(125, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        panelLeft.add(txtNgayHetHC, gridBagConstraints);

        txtNgayCapCMND.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txtNgayCapCMND.setMinimumSize(new java.awt.Dimension(125, 30));
        txtNgayCapCMND.setPreferredSize(new java.awt.Dimension(125, 30));
        panelLeft.add(txtNgayCapCMND, new java.awt.GridBagConstraints());

        txtNgaycapHC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txtNgaycapHC.setMinimumSize(new java.awt.Dimension(150, 30));
        txtNgaycapHC.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(txtNgaycapHC, gridBagConstraints);

        txtSoHoChieu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###############"))));
        txtSoHoChieu.setMinimumSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(txtSoHoChieu, gridBagConstraints);

        txtCMND.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###############"))));
        txtCMND.setMinimumSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panelLeft.add(txtCMND, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        getContentPane().add(panelLeft, gridBagConstraints);

        panelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelTop.setMinimumSize(new java.awt.Dimension(1030, 170));
        panelTop.setPreferredSize(new java.awt.Dimension(1030, 170));
        panelTop.setLayout(new java.awt.GridBagLayout());

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaNV.setMinimumSize(new java.awt.Dimension(230, 30));
        txtMaNV.setPreferredSize(new java.awt.Dimension(230, 30));
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtMaNV, gridBagConstraints);

        txtTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTen.setMinimumSize(new java.awt.Dimension(307, 30));
        txtTen.setPreferredSize(new java.awt.Dimension(307, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtTen, gridBagConstraints);

        txtHoDem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHoDem.setMinimumSize(new java.awt.Dimension(230, 30));
        txtHoDem.setPreferredSize(new java.awt.Dimension(230, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtHoDem, gridBagConstraints);

        txtNoiSinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoiSinh.setMinimumSize(new java.awt.Dimension(680, 30));
        txtNoiSinh.setPreferredSize(new java.awt.Dimension(680, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtNoiSinh, gridBagConstraints);

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHoTen.setMinimumSize(new java.awt.Dimension(230, 30));
        txtHoTen.setPreferredSize(new java.awt.Dimension(230, 30));
        txtHoTen.setRequestFocusEnabled(false);
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtHoTen, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Mã N.Viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Họ và đệm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Họ và tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nơi sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Nguyên quán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel14, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã chấm công");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 47, 0, 0);
        panelTop.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Giới tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        panelTop.add(jLabel7, gridBagConstraints);

        cbxSex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbxSex.setMinimumSize(new java.awt.Dimension(75, 30));
        cbxSex.setPreferredSize(new java.awt.Dimension(75, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(cbxSex, gridBagConstraints);

        txtMaCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaCC.setMinimumSize(new java.awt.Dimension(307, 30));
        txtMaCC.setPreferredSize(new java.awt.Dimension(307, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtMaCC, gridBagConstraints);

        txtNguyenQuan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNguyenQuan.setMinimumSize(new java.awt.Dimension(450, 30));
        txtNguyenQuan.setPreferredSize(new java.awt.Dimension(450, 30));
        txtNguyenQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNguyenQuanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        panelTop.add(txtNguyenQuan, gridBagConstraints);

        panelImage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình ảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 255))); // NOI18N
        panelImage.setMinimumSize(new java.awt.Dimension(130, 170));
        panelImage.setPreferredSize(new java.awt.Dimension(130, 162));

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        panelImageLayout.setVerticalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 29, 0, 4);
        panelTop.add(panelImage, gridBagConstraints);

        cbxNguyenQuan.setMinimumSize(new java.awt.Dimension(220, 30));
        cbxNguyenQuan.setPreferredSize(new java.awt.Dimension(220, 30));
        cbxNguyenQuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNguyenQuanItemStateChanged(evt);
            }
        });
        cbxNguyenQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNguyenQuanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelTop.add(cbxNguyenQuan, gridBagConstraints);

        txtNgaysinh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        txtNgaysinh.setMinimumSize(new java.awt.Dimension(150, 30));
        txtNgaysinh.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        panelTop.add(txtNgaysinh, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 13, 0);
        getContentPane().add(panelTop, gridBagConstraints);

        btSave.setText("Ghi");
        btSave.setMaximumSize(new java.awt.Dimension(40, 23));
        btSave.setMinimumSize(new java.awt.Dimension(40, 23));
        btSave.setPreferredSize(new java.awt.Dimension(65, 25));
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        panelButton.add(btSave);

        btEdit.setText("Sửa");
        btEdit.setMinimumSize(new java.awt.Dimension(40, 23));
        btEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        panelButton.add(btEdit);

        btDelete.setText("Xóa");
        btDelete.setMinimumSize(new java.awt.Dimension(40, 23));
        btDelete.setPreferredSize(new java.awt.Dimension(75, 23));
        panelButton.add(btDelete);

        btPrint.setText("In");
        btPrint.setMinimumSize(new java.awt.Dimension(40, 23));
        btPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });
        panelButton.add(btPrint);

        btCancel.setText("Hủy");
        btCancel.setMinimumSize(new java.awt.Dimension(40, 23));
        btCancel.setPreferredSize(new java.awt.Dimension(70, 25));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        panelButton.add(btCancel);

        btClose.setText("Thoát");
        btClose.setPreferredSize(new java.awt.Dimension(75, 23));
        panelButton.add(btClose);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 17, 0);
        getContentPane().add(panelButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if(validateInput())
            dispose();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
//        stateButton(false);
        if(validateInput())
            dispose();
    }//GEN-LAST:event_btEditActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
         stateButton(true);// TODO add your handling code here:
    }//GEN-LAST:event_btCancelActionPerformed

    private void btnUniversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUniversityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUniversityActionPerformed

    private void txtNoiCapHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoiCapHCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoiCapHCActionPerformed

    private void txtNguyenQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNguyenQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNguyenQuanActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        factory = new Configuration().configure().addAnnotatedClass(ims.model.Employee.class).buildSessionFactory();
        Session session = factory.openSession();
        List<Employee> list;
        list = session.createQuery("FROM Employee").list();
        System.out.println(list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }//GEN-LAST:event_btPrintActionPerformed

    private void cbxNguyenQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNguyenQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNguyenQuanActionPerformed

    private void cbxUniversityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUniversityItemStateChanged
        // TODO add your handling code here:
        Object selectedItem = cbxUniversity.getSelectedItem();
        TruongDaotao t = (TruongDaotao) selectedItem;
        
        cbxChuyenNganh.removeAllItems();
        cbxKhoaDaoTao.removeAllItems();
        setContentCbxKhoaDaotao(t.getIdDaotao());
    }//GEN-LAST:event_cbxUniversityItemStateChanged

    private void cbxKhoaDaoTaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxKhoaDaoTaoItemStateChanged
        // TODO add your handling code here:
        Object selectedItem =  cbxKhoaDaoTao.getSelectedItem();
        KhoaDaotao k = (KhoaDaotao) selectedItem;
        cbxChuyenNganh.removeAllItems();
        if(k != null)
            setContentCbxChuyenNganh(k.getMaKhoa());
    }//GEN-LAST:event_cbxKhoaDaoTaoItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        setEmployee(null);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setEmployee(null);
    }//GEN-LAST:event_formWindowClosing

    private void cbxChuyenNganhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxChuyenNganhItemStateChanged
        // TODO add your handling code here:
        Object selectedItem =  cbxChuyenNganh.getSelectedItem();
        Chuyennganh c = (Chuyennganh) selectedItem;
        cbxTrinhDoDaoTao.removeAllItems();
        if(c != null)
            setContentCbxTrinhdoDaotao(c.getMaNganh());
    }//GEN-LAST:event_cbxChuyenNganhItemStateChanged

    private void cbxNguyenQuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNguyenQuanItemStateChanged
        // TODO add your handling code here:
        String s = cbxNguyenQuan.getSelectedItem().toString();
        txtNguyenQuan.setText(s);
        txtNoiCapHC.setText(s);
        txtNoiCapCMND.setText(s);
    }//GEN-LAST:event_cbxNguyenQuanItemStateChanged

    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        // TODO add your handling code here:
        txtHoTen.setText(txtHoDem.getText() + " " + txtTen.getText());
    }//GEN-LAST:event_txtHoTenFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnFa;
    private javax.swing.JButton btnJob;
    private javax.swing.JButton btnMajor;
    private javax.swing.JButton btnRank;
    private javax.swing.JButton btnTrinhdo;
    private javax.swing.JButton btnUniversity;
    private javax.swing.JComboBox<Chuyennganh> cbxChuyenNganh;
    private javax.swing.JComboBox<Dantoc> cbxDanToc;
    private javax.swing.JComboBox<ThanhphanGiadinh> cbxGiaDinh;
    private javax.swing.JComboBox<String> cbxHonNhan;
    private javax.swing.JComboBox<KhoaDaotao> cbxKhoaDaoTao;
    private javax.swing.JComboBox<Nghenghiep> cbxNgheNghiep;
    private javax.swing.JComboBox<Tinhthanh> cbxNguyenQuan;
    private javax.swing.JComboBox<Quocgia> cbxQuocTich;
    private javax.swing.JComboBox<String> cbxSex;
    private javax.swing.JComboBox<Tongiao> cbxTonGiao;
    private javax.swing.JComboBox<TrinhdoDaotao> cbxTrinhDoDaoTao;
    private javax.swing.JComboBox<TruongDaotao> cbxUniversity;
    private javax.swing.JComboBox<Xeploai> cbxXepLoai;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelImage;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    private javax.swing.JSpinner spnNamTotNghiep;
    private javax.swing.JFormattedTextField txtCMND;
    private javax.swing.JTextField txtHoDem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JFormattedTextField txtNgayCapCMND;
    private javax.swing.JFormattedTextField txtNgayHetHC;
    private javax.swing.JFormattedTextField txtNgaycapHC;
    private javax.swing.JFormattedTextField txtNgaysinh;
    private javax.swing.JTextField txtNguyenQuan;
    private javax.swing.JTextField txtNoiCapCMND;
    private javax.swing.JTextField txtNoiCapHC;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JFormattedTextField txtSoHoChieu;
    private javax.swing.JTextField txtTen;
    private javax.swing.JFormattedTextField txtTrinhDoVanHoa;
    // End of variables declaration//GEN-END:variables

        public void setContentCbxQuocTich(){
        QuocgiaBLL qbll = new QuocgiaBLL();
        List<Quocgia> list = qbll.getAll();
        for(Quocgia q : list){
            cbxQuocTich.addItem(q);
        }
    }
    public void setContentCbxDantoc(){
        DantocBLL qbll = new DantocBLL();
        List<Dantoc> list = qbll.getAll();
        for(Dantoc q : list){
            cbxDanToc.addItem(q);
        }
    }
    private void setContentCbxTonGiao() {

        TongiaoBLL bll = new TongiaoBLL();
        List<Tongiao> list = bll.getAll();
        for(Tongiao t : list){
            cbxTonGiao.addItem(t);
        }
    }

    private void setContentCbxChuyenNganh(int maKhoa) {
        ChuyennganhBLL bll = new ChuyennganhBLL();
        List<Chuyennganh> list = bll.findByKhoa(maKhoa);
        if(list != null){
            for(Chuyennganh c : list){
            cbxChuyenNganh.addItem(c);
            }
        }else{
            cbxChuyenNganh.removeAllItems();
        }
        
    }

    private void setContentCbxKhoaDaotao(int id) {
        KhoaDaotaoBLL bll = new KhoaDaotaoBLL();
        List<KhoaDaotao> list = bll.findByUniversity(id);
        for(KhoaDaotao k : list){
            cbxKhoaDaoTao.addItem(k);
        }
    }
    
    private void setContentCbxKhoaDaotao(TruongDaotao id) {
        KhoaDaotaoBLL bll = new KhoaDaotaoBLL();
        List<KhoaDaotao> list = bll.findByUniversity(id);
        for(KhoaDaotao k : list){
            cbxKhoaDaoTao.addItem(k);
        }
    }

    private void setContentCbxNgheNghiep() {
        NghenghiepBLL bll = new NghenghiepBLL();
        List<Nghenghiep> list = bll.getAll();
        for(Nghenghiep n : list){
            cbxNgheNghiep.addItem(n);
        }
    }

    private void setContentCbxThanhphanGiadinh() {
        ThanhphanGiadinhBLL bll = new ThanhphanGiadinhBLL();
        List<ThanhphanGiadinh> list = bll.getALl();
        for(ThanhphanGiadinh t : list){
            cbxGiaDinh.addItem(t);
        }
    }

    private void setContentCbxNguyenQuan() {
        TinhthanhBLL bll = new TinhthanhBLL();
        List<Tinhthanh> list = bll.getAll();
        for(Tinhthanh t : list){
            cbxNguyenQuan.addItem(t);
        }
    }

    private void setContentCbxTrinhdoDaotao(int idChuyennganh) {
        ChuyennganhBLL bll = new ChuyennganhBLL();
        List<TrinhdoDaotao> list = bll.findTrinhdoDaotao(idChuyennganh);
        for(TrinhdoDaotao t : list){
            cbxTrinhDoDaoTao.addItem(t);
        }
    }
    private void setContentCbxTrinhdoDaotao(String Chuyennganh) {
        ChuyennganhBLL bll = new ChuyennganhBLL();
        List<TrinhdoDaotao> list = bll.findTrinhdoDaotao(Chuyennganh);
        for(TrinhdoDaotao t : list){
            cbxTrinhDoDaoTao.addItem(t);
        }
    }

    private void setContentCbxNoiDaotao() {
        TruongDaotaoBLL bll = new TruongDaotaoBLL();
        List<TruongDaotao> list = bll.getAll();
        for(TruongDaotao t : list){
            cbxUniversity.addItem(t);
        }
    }

    private void setContentCbxXeploai() {
        XeploaiBLL bll = new XeploaiBLL();
        List<Xeploai> list = bll.getAll();
        for(Xeploai x : list){
            cbxXepLoai.addItem(x);
        }
    }
    
    private java.sql.Date frmDate(String date) throws ParseException{
        if(date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date dateUtil;
        dateUtil = sdf.parse(date);
        System.out.println(dateUtil + "," + dateUtil.getTime());
        java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
        System.out.println(dateSql);
        return dateSql;
    }
    
    private Tinhthanh getNguyenquanByCombobox() {
        if(cbxNguyenQuan.getSelectedIndex() == -1){
            return null;
        }
        return (Tinhthanh) cbxNguyenQuan.getSelectedItem();
//        return t;
    }

    private ThanhphanGiadinh getTpGdByCombobox() {
        if(cbxGiaDinh.getSelectedIndex() == -1)
            return null;
        return (ThanhphanGiadinh) cbxGiaDinh.getSelectedItem();
    }

    private Dantoc getDantocByCombobox() {
        if(cbxDanToc.getSelectedIndex() == -1)
            return null;
        return (Dantoc) cbxDanToc.getSelectedItem();
    }

    private Tongiao getTongiaoByCombobox() {
        if(cbxTonGiao.getSelectedIndex() == -1)
            return null;
        return (Tongiao) cbxTonGiao.getSelectedItem();
    }

    private Quocgia getQuoctichByCombobox() {
        if(cbxQuocTich.getSelectedIndex() == -1)
            return null;
        return (Quocgia) cbxQuocTich.getSelectedItem();
    }

    private Chuyennganh getChuyennganhByCombobox() {
        if(cbxChuyenNganh.getSelectedIndex() == -1)
            return null;
        return (Chuyennganh) cbxChuyenNganh.getSelectedItem();
    }

    private Xeploai getXeploaiByCombobox() {
        if(cbxXepLoai.getSelectedIndex() == -1)
            return null;
        return (Xeploai) cbxXepLoai.getSelectedItem();
    }

    private Nghenghiep getNghenghiepByCombobox() {
        if(cbxNgheNghiep.getSelectedIndex() == -1)
            return null;
        return (Nghenghiep) cbxNgheNghiep.getSelectedItem();
    }
    
    private TrinhdoDaotao getTrinhdoByCombobox() {
        if(cbxTrinhDoDaoTao.getSelectedIndex() == -1)
            return null;
        return (TrinhdoDaotao) cbxTrinhDoDaoTao.getSelectedItem();
    }
    
    private boolean validateInput(){
        try {
            String maNV = txtMaNV.getText();
            String maCC = txtMaCC.getText();
            String tenHoDem = txtHoDem.getText();
            String ten = txtTen.getText();
            String noiSinh = txtNoiSinh.getText();
            String noiCapCMND = txtNoiCapCMND.getText();
            String soHoChieu = txtSoHoChieu.getText();
            String noiCapHC = txtNoiCapHC.getText();
            String cmnd = txtCMND.getText();
            String trinhDoVH = txtTrinhDoVanHoa.getText();
            int namTotNghiep = (Integer) spnNamTotNghiep.getValue();
            
            String ngaysinh = (txtNgaysinh.getText());
            String ngayCapHC = (txtNgaycapHC.getText());
            String hetHanHC = (txtNgayHetHC.getText());
            String ngayCapCmnd = (txtNgayCapCMND.getText());
            ////////////////////////////////////////////////
            try{
                frmDate(ngaysinh);
            }catch(ParseException e){
                JOptionPane.showMessageDialog(this, "Nhap sai ngay!");
                txtNgaysinh.requestFocus();
                return false;
            }
            // ngay cap k bat buoc
            if(!ngayCapHC.equals("")){
                try{
                    frmDate(ngayCapHC);
                }catch(ParseException e){
                JOptionPane.showMessageDialog(this, "Nhap sai ngay!");
                txtNgaycapHC.requestFocus();
                return false;
                }
            }
            if(!hetHanHC.equals("")){
                try{
                    frmDate(hetHanHC);
                }catch(ParseException e){
                JOptionPane.showMessageDialog(this, "Nhap sai ngay!");
                txtNgayHetHC.requestFocus();
                return false;
                }
            }
            if(!ngayCapCmnd.equals("")){
                try{
                    frmDate(ngayCapCmnd);
                }catch(ParseException e){
                JOptionPane.showMessageDialog(this, "Nhap sai ngay!");
                txtNgayCapCMND.requestFocus();
                return false;
                }
            }
            if(e == null){
                e = new Employee();
            }
            e.setMaNv(maNV);
                e.setMaChamcong(maCC);
                e.setTenHoDem(tenHoDem);
                e.setTen(ten);
                e.setNoisinh(noiSinh);
                e.setTrinhdovanhoa(trinhDoVH);
                e.setNamtotnghiep(namTotNghiep);
                e.setNgaySinh(frmDate(ngaysinh));

                e.setNguyenquan(getNguyenquanByCombobox());
                e.setIdTp(getTpGdByCombobox());
                e.setMaDantoc(getDantocByCombobox());
                e.setMaTongiao(getTongiaoByCombobox());
                e.setQuoctich(getQuoctichByCombobox());
                
                e.setMaLoai(getXeploaiByCombobox());
                e.setMaNghe(getNghenghiepByCombobox());
                e.setChuyennganh(getChuyennganhByCombobox());
                
                e.setSohochieu(soHoChieu);
                try{
                    e.setNgaycapHochieu(frmDate(ngayCapHC));
                }catch(ParseException ex){
                    e.setNgaycapHochieu(null);
                }
                    
                e.setNoicapHochieu(noiCapHC);
                try{
                    e.setHethanHochieu(frmDate(hetHanHC));
                }catch(ParseException ex){
                    e.setHethanHochieu(null);
                }
                    
                e.setCmnd(cmnd);
                e.setNoicapCmnd(noiCapCMND); 
                try{
                    e.setCmndNgaycap(frmDate(ngayCapCmnd));
                }catch(ParseException ex){
                    e.setCmndNgaycap(null);
                }
                    
                    
            /////////////////////////////////////////////
            
            
            if(maNV.equals("")){
                JOptionPane.showMessageDialog(this, "Nhap ma NV!");
                txtMaNV.requestFocus();
                return false;
            }else if(maCC.equals("")){
                JOptionPane.showMessageDialog(this, "Nhap ma CC!");
                txtMaCC.requestFocus();
                return false;
            }else if(tenHoDem.equals("")){
                JOptionPane.showMessageDialog(this, "Nhap Ho dem!");
                txtHoDem.requestFocus();
                return false;
            }else if(noiSinh.equals("")){
                JOptionPane.showMessageDialog(this, "Nhap noi sinh!");
                txtNoiSinh.requestFocus();
                return false;
            }else if(trinhDoVH.equals("")){
                JOptionPane.showMessageDialog(this, "Nhap Trinh do VH!");
                txtTrinhDoVanHoa.requestFocus();
                return false;
            }
            if(soHoChieu.equals("")){ // khong ho chieu
                if( ! noiCapHC.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap Ho chieu!");
                    txtSoHoChieu.requestFocus();
                    return false;
                    
                }else if( ! ngayCapHC.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap Ho chieu!");
                    txtSoHoChieu.requestFocus();
                    return false;
                }else if( ! hetHanHC.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap Ho chieu!");
                    txtSoHoChieu.requestFocus();
                    return false;
                }
            }
            if(!soHoChieu.equals("")){
                if(noiCapHC.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap noi cap Ho chieu!");
                    txtNoiCapHC.requestFocus();
                    return false;
                }else if( ngayCapHC.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap ngay cap Ho chieu!");
                    txtNgaycapHC.requestFocus();
                    return false;
                }else if( hetHanHC.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap ngay het han Ho chieu!");
                    txtNgayHetHC.requestFocus();
                    return false;
                }
            }
            if(cmnd.equals("")){ // not cmnd not noiCap & ngayCap
                if(! noiCapCMND.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap CMND!");
                    txtCMND.requestFocus();
                    return false;
                    
                }else if ( ! ngayCapCmnd.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap CMND!");
                    txtCMND.requestFocus();
                    return false;
                }
            }
            if(!cmnd.equals("")){
                if(noiCapCMND.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap noi cap CMND!");
                    txtNoiCapCMND.requestFocus();
                    return false;
                }else if(ngayCapCmnd.equals("")){
                    JOptionPane.showMessageDialog(this, "Nhap ngay cap CMND!");
                    txtNgayCapCMND.requestFocus();
                    return false;
                }
            }
            
                //////////////////////////////////

                if(cbxSex.getSelectedIndex() == -1){
                    e.setSex(null);
                }else{
                    e.setSex(cbxSex.getSelectedIndex()==0); // 0 male, 1 female
                }

                if(cbxHonNhan.getSelectedIndex() == -1){
                    e.setTinhtrangHonnhan(null);
                }else{
                    e.setTinhtrangHonnhan(cbxHonNhan.getSelectedIndex() == 0);
                }
                
                

                return true;
            
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeInfo.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(this, ex);
            return false;
        }
    }

    public String parseDate(String s){
        ArrayList date = new ArrayList();
        for(int i =0; i<s.length(); i++){
            date.add(s.charAt(i));
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@" +date.size());
        String dd = date.get(8).toString()+date.get(9).toString();
        String mm = date.get(5).toString()+date.get(6).toString();
        String yyyy = date.get(0).toString()+date.get(1).toString()+date.get(2).toString()+date.get(3).toString();
        String dfm = dd + "-" + mm + "-" + yyyy;
        return dfm;
    }
    
}
