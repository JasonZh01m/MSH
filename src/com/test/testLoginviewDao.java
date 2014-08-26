package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.MboDAO;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.view.Loginview;

public class testLoginviewDao {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );
        LoginviewDAO dao = (LoginviewDAO)context.getBean("loginviewDAO");
        
        DepartmentDAO departdao = (DepartmentDAO) context.getBean("departmentDAO");
        
        
//        Department de = departdao.findById(4);
//        System.out.println(de.getDepartName());
        
        List<String> list = dao.findAllLoginId();
        
        for (String string : list) {
			System.out.println(string);
		}
        
        /*List<Loginview> list = dao.findAll();
		
        for (Loginview loginview : list) {
			System.out.println(loginview.getEmpLoginId());
		}*/
		
//        EmpDAO empdao = (EmpDAO) context.getBean("empDAO");
        
        
//        Emp emp = empdao.findById(47);
//        System.out.println(emp.getEmpLoginId());
//        System.out.println(emp.getMbo().getMboRate());
//        System.out.println("list.size(): " + list.size());
//        List<String> l = dao.findAllLoginId();
//        
//        for (String string : l) {
//			System.out.println(string);
//		}
	}
	
}
