/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.ThanhphanGiadinhDAL;
import ims.model.ThanhphanGiadinh;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class ThanhphanGiadinhBLL {
    private ThanhphanGiadinhDAL thanhphanGiadinhDAL;

    public ThanhphanGiadinhBLL() {
        thanhphanGiadinhDAL = new ThanhphanGiadinhDAL(ThanhphanGiadinh.class);
    }
    
    public List<ThanhphanGiadinh> getALl(){
        try {
            return thanhphanGiadinhDAL.getALl();
        } catch (Exception ex) {
            Logger.getLogger(ThanhphanGiadinhBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
