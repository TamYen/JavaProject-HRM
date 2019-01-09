/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.ThanhphanGiadinh;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class ThanhphanGiadinhDAL extends BaseDAL{

    public ThanhphanGiadinhDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<ThanhphanGiadinh> getALl() throws Exception{
        List<ThanhphanGiadinh> result = new ArrayList<>();
        result = session.createQuery("from ThanhphanGiadinh").list();
        close();
        return result;
    }
}
