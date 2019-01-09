/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import ims.model.Tongiao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANHB
 */
public class TongiaoDAL extends BaseDAL{

    public TongiaoDAL(Class annotatedClass) {
        super(annotatedClass);
    }
    public List<Tongiao> getAll() throws Exception{
        List<Tongiao> result = new ArrayList<>();
        result = session.createQuery("from Tongiao").list();
        close();
        return result;
    }
}
