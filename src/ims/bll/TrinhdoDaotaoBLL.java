/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.TrinhdoDaotaoDAL;
import ims.model.TrinhdoDaotao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class TrinhdoDaotaoBLL {
    private TrinhdoDaotaoDAL trinhdoDaotaoDAL;

    public TrinhdoDaotaoBLL() {
        trinhdoDaotaoDAL = new TrinhdoDaotaoDAL(TrinhdoDaotao.class);
    }
    
    public List<TrinhdoDaotao> getAll(){
        try {
            return trinhdoDaotaoDAL.getAll();
        } catch (Exception ex) {
            Logger.getLogger(TrinhdoDaotaoBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
