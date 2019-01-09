/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Dantoc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class DantocDAL extends BaseDAL{

    public DantocDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Dantoc> getAll() throws Exception{
        List<Dantoc> result = new ArrayList<Dantoc>();
        result = session.createQuery("from Dantoc").list();
        close();
        return result;
    }
}
