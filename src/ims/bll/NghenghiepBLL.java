/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.NghenghiepDAL;
import ims.model.Nghenghiep;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class NghenghiepBLL {
    private NghenghiepDAL nghenghiepDAL;

    public NghenghiepBLL() {
        nghenghiepDAL = new NghenghiepDAL(Nghenghiep.class);
    }
    
    public List<Nghenghiep> getAll(){
        try {
            return nghenghiepDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(NghenghiepBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
