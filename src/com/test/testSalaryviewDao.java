package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.SalaryviewDAO;
import com.moravia.hs.base.entity.view.Salaryview;

public class testSalaryviewDao {

	public static void main(String[] args) {
		
		ApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SalaryviewDAO salaryviewDAO = (SalaryviewDAO) cx.getBean("salaryviewDAO");
		
//		List<Salaryview> list = salaryviewDAO.findAll();
//		System.out.println(list.size());
		
		Salaryview sv = salaryviewDAO.findByLoginName("jennifers");
		
		System.out.println(sv.getBaseSalary());
		
	}
	
}
