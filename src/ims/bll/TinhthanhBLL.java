/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.TinhthanhDAL;
import ims.model.Tinhthanh;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class TinhthanhBLL {
    private TinhthanhDAL tinhthanhDAL;

    public TinhthanhBLL() {
        tinhthanhDAL = new TinhthanhDAL(Tinhthanh.class);
    }
    
    public List<Tinhthanh> getAll(){
        try {
            return tinhthanhDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(TinhthanhBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
