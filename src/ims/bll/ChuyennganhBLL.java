/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.ChuyennganhDAL;
import ims.model.Chuyennganh;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class ChuyennganhBLL {
    private ChuyennganhDAL chuyennganhDAL;

    public ChuyennganhBLL() {
        chuyennganhDAL = new ChuyennganhDAL(Chuyennganh.class);
    }
    
    public List<Chuyennganh> getAll(){
        return chuyennganhDAL.getAll();
    }
    
    public List<Chuyennganh> findByKhoa(int maKhoa){
        try {
            return chuyennganhDAL.findByKhoa(maKhoa);
        } catch (Exception ex) {
            Logger.getLogger(ChuyennganhBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
