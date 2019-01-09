/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.DantocDAL;
import ims.model.Dantoc;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class DantocBLL {
    private DantocDAL dantocDAL;

    public DantocBLL() {
        dantocDAL = new DantocDAL(Dantoc.class);
    }
    
    public List<Dantoc> getAll(){
        try {
            return dantocDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(DantocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
