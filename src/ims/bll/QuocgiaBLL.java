/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.QuocgiaDAL;
import ims.model.Quocgia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class QuocgiaBLL {
    private QuocgiaDAL quocgiaDAL;

    public QuocgiaBLL() {
        quocgiaDAL = new QuocgiaDAL(Quocgia.class);
    }
    
    public List<Quocgia> getAll(){
        try {
            return quocgiaDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(QuocgiaBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
