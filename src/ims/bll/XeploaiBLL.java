/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.XeploaiDAL;
import ims.model.Xeploai;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class XeploaiBLL {
    private XeploaiDAL xeploaiDAL;

    public XeploaiBLL() {
        xeploaiDAL = new XeploaiDAL(Xeploai.class);
    }
    
    public List<Xeploai> getAll(){
        try {
            return xeploaiDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(XeploaiBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
