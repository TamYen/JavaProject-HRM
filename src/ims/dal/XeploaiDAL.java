/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Xeploai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class XeploaiDAL extends BaseDAL{

    public XeploaiDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Xeploai> getAll() throws Exception{
        List<Xeploai> result = new ArrayList<>();
        result = session.createQuery("from Xeploai").list();
        close();
        return result;
    }
}
