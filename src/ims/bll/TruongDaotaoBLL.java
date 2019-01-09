/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.TruongDaotaoDAL;
import ims.model.TruongDaotao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class TruongDaotaoBLL {
    private TruongDaotaoDAL truongDaotaoDAL;

    public TruongDaotaoBLL() {
        truongDaotaoDAL = new TruongDaotaoDAL(TruongDaotao.class);
    }
    
    public List<TruongDaotao> getAll(){
        try {
            return truongDaotaoDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(TruongDaotaoBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
