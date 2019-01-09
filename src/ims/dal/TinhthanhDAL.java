/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Tinhthanh;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class TinhthanhDAL extends BaseDAL{

    public TinhthanhDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Tinhthanh> getAll() throws Exception{
        List<Tinhthanh> result = new ArrayList<>();
        result = session.createQuery("from Tinhthanh").list();
        close();
        return result;
    }
}
