/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Nghenghiep;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class NghenghiepDAL extends BaseDAL{

    public NghenghiepDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Nghenghiep> getAll() throws Exception{
        List<Nghenghiep> result = new ArrayList<>();
        result = session.createQuery("from Nghenghiep").list();
        close();
        return result;
    }
}
