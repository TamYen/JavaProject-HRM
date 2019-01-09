/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.TruongDaotao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class TruongDaotaoDAL extends BaseDAL{

    public TruongDaotaoDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<TruongDaotao> getAll() throws Exception{
        List<TruongDaotao> result = new ArrayList<>();
        result = session.createQuery("from TruongDaotao").list();
        close();
        return result;
    }
}
