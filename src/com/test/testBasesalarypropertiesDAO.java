package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;

public class testBasesalarypropertiesDAO {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BasesalarypropertiesDAO basesalarypropertiesDAO = (BasesalarypropertiesDAO) context.getBean("basesalarypropertiesDAO");
		
		Basesalaryproperties basesalaryproperties = basesalarypropertiesDAO.findById(2);
		System.out.println(basesalaryproperties.getTotalWorkDays() + "\t" + basesalaryproperties.getTotalWorkHours());
		
		Basesalaryproperties bp = basesalarypropertiesDAO.findLastCreated();
		System.out.println(bp.getStartDate() + "\t" + bp.getEndDate() + "\t" + bp.getTotalWorkDays() + "\t" + bp.getTotalWorkHours() + "\t" + bp.getBaseSalaryHrs());
		
	}
	
}
