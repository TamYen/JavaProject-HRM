/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Chuyennganh;
import ims.model.TrinhdoDaotao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class ChuyennganhDAL extends BaseDAL{

    public ChuyennganhDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Chuyennganh> getAll(){
        try {
            List<Chuyennganh> result = new ArrayList<Chuyennganh>();
            result = session.createQuery("from Chuyennganh").list();
            close();
            return result;
        } catch (Exception ex) {
            Logger.getLogger(ChuyennganhDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Chuyennganh> findByKhoa(int idKhoa) throws Exception{
        List<Chuyennganh> result = new ArrayList<Chuyennganh>();
        result = session.createQuery("SELECT c from Chuyennganh c where c.maKhoa.maKhoa = "+idKhoa).list();
        close();
        return result;
    }
    
    public List<TrinhdoDaotao> findTrinhdoDaotao(int idChuyennganh) throws Exception{
        List<TrinhdoDaotao> result = new ArrayList<>();
        result = session.createQuery("SELECT DISTINCT(c.maTrinhdo) from Chuyennganh c where c.maTrinhdo.maTrinhdo = "+idChuyennganh).list();
        close();
        return result;
    }
}
