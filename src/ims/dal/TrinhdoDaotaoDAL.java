/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.TrinhdoDaotao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class TrinhdoDaotaoDAL extends BaseDAL{

    public TrinhdoDaotaoDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<TrinhdoDaotao> getAll() throws Exception{
        List<TrinhdoDaotao> result = new ArrayList<>();
        result = session.createQuery("from TrinhdoDaotao").list();
        close();
        return result;
    }
}
