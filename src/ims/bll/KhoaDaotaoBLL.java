/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.KhoaDaotaoDAL;
import ims.model.KhoaDaotao;
import ims.model.TruongDaotao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class KhoaDaotaoBLL {
    private KhoaDaotaoDAL khoaDaotaoDAL;

    public KhoaDaotaoBLL() {
        khoaDaotaoDAL = new KhoaDaotaoDAL(KhoaDaotao.class);
    }
    
    public List<KhoaDaotao> findByUniversity(int id){
        try {
            return khoaDaotaoDAL.findByUniversity(id);
        } catch (Exception ex) {
            Logger.getLogger(KhoaDaotaoBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<KhoaDaotao> findByUniversity(TruongDaotao t){
        try {
            return khoaDaotaoDAL.findByUniversity(t);
        } catch (Exception ex) {
            Logger.getLogger(KhoaDaotaoBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
