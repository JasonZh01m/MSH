package com.test;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.entity.Department;

public class testDepartmentDAO {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentDAO dao = (DepartmentDAO) context.getBean("departmentDAO");
		Department depart = new Department(null, "abc2", "des2", new Timestamp(new Date().getTime()), null);
//		depart.setDepartName("abc");
//		depart.setDepartDesc("departDesc");
		dao.save(depart);
		
		
	}
	

}
