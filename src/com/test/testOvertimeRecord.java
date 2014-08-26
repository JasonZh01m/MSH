package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.moravia.hs.base.dao.OvertimerecordDAO;
import com.moravia.hs.base.dao.OvertimerequestitemDAO;
import com.moravia.hs.base.entity.Overtimerecord;
import com.moravia.hs.base.entity.Overtimerequestitem;
import com.moravia.hs.base.entity.other.PageBean;


public class testOvertimeRecord {
	
	public static void main(String[] args) {
		
		BaseTest bt = new BaseTest();
		
		OvertimerecordDAO dao = (OvertimerecordDAO) bt.getBean("overtimerecordDAO");
		OvertimerequestitemDAO itemdao = (OvertimerequestitemDAO) bt.getBean("overtimerequestitemDAO");
		Overtimerequestitem item = itemdao.findById(16);
		
		System.out.println(item.getOtherPaidRate());
		
		/*Overtimerecord or = dao.findById(2);
		
		System.out.println(or.getApplicant() + "\t" + or.getComments() + "\t" + or.getTotalhours());
		
		PageBean pageBean = dao.findByApplicant("abbys", 5, 1);
		List<Overtimerecord> olist = pageBean.getList();
		System.out.println(olist.size());
		for (Overtimerecord overtimerecord : olist) {
			System.out.println(overtimerecord.getApplicant() + "\t" + overtimerecord.getId());
		}*/
		
	}
	

}
