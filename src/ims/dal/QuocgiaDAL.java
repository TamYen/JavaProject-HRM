/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Quocgia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class QuocgiaDAL extends BaseDAL{

    public QuocgiaDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Quocgia> getAll() throws Exception{
        List<Quocgia> result = new ArrayList<>();
        result = session.createQuery("from Quocgia").list();
        close();
        return result;
    }
}
