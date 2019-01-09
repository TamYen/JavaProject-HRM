/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.TongiaoDAL;
import ims.model.Tongiao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class TongiaoBLL {
    private TongiaoDAL tongiaoDAL;

    public TongiaoBLL() {
        tongiaoDAL = new TongiaoDAL(Tongiao.class);
    }
    
    public List<Tongiao> getAll(){
        try {
            return tongiaoDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(TongiaoBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
