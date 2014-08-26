package com.test;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.RoleDAO;
import com.moravia.hs.base.dao.RolemenuDAO;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Menuinfo;
import com.moravia.hs.base.entity.Role;
import com.moravia.hs.base.entity.Rolemenu;

public class testRoleDao {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleDAO dao = (RoleDAO) context.getBean("roleDAO");
		RolemenuDAO rmdao = (RolemenuDAO) context.getBean("rolemenuDAO");
		Role role = dao.findById(5);
		
//		Set<Emp> emps = role.getEmps();
//		System.out.println("emps.size(): " + emps.size());
//		System.out.println(role.getSysRoleName());
		System.out.println(role.getSysRoleName());
		Set<Rolemenu> rms = role.getRolemenus();
		System.out.println(rms.size());
		for (Rolemenu rm : rms) {
			Menuinfo mi = rm.getMenuinfo();
			System.out.println(mi.getMenuName() + "\t" + mi.getDesc() + "\t" + mi.getLink());
		}
	}
	
}
