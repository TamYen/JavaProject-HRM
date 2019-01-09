/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ANHB
 */
public class FormatDate {
    public Date frmDate(String date) throws ParseException{
        if(date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date dateUtil;
        dateUtil = sdf.parse(date);
        return dateUtil;
    }
}
