/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.KhoaDaotao;
import ims.model.TruongDaotao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class KhoaDaotaoDAL extends BaseDAL{

    public KhoaDaotaoDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<KhoaDaotao> findByUniversity(int idUniversity) throws Exception{
        List<KhoaDaotao> result = new ArrayList<>();
        result = session.createQuery("SELECT k FROM KhoaDaotao k WHERE k.idDaotao.idDaotao = "+idUniversity).list();
        close();
        return result;
    }
    
    public List<KhoaDaotao> findByUniversity(TruongDaotao t) throws Exception{
        List<KhoaDaotao> result = new ArrayList<>();
        result = session.createQuery("SELECT k FROM KhoaDaotao k WHERE k.idDaotao= "+t).list();
        close();
        return result;
    }
}
