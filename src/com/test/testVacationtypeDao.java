package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Vacationtype;


public class testVacationtypeDao {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		VacationtypeDAO vcdao = (VacationtypeDAO) context.getBean("vacationtypeDAO");
		
		
//		List<Integer> list = dao.findTimeSheetOrderID();
//		
//		for (Integer integer : list) {
//			System.out.println(integer);
//		}
		
//		List<Vacationtype> list = dao.findAll();
//		for (Vacationtype vacationtype : list) {
//			System.out.println(vacationtype.getTimeSheetOrderId() + "\t\t" + vacationtype.getVacationTypeDesc());
//		}
		
//		List<Vacationtype> list = dao.findAll();
//		for (Vacationtype vacationtype : list) {
//			System.out.println(vacationtype.getTimeSheetOrderId() + "\t" + vacationtype.getVacationPaidRate());
//		}
		
		
		
	}
	
	
}
