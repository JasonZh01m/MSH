package com.test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;










import com.moravia.hs.base.dao.Pagination;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.EmptypeDAO;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Menuinfo;
import com.moravia.hs.base.entity.Positiontitle;
import com.moravia.hs.base.entity.Rolemenu;
import com.moravia.hs.base.entity.other.PageBean;


public class testEmpDAO{
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDAO empdao = (EmpDAO) context.getBean("empDAO");
		EmptypeDAO emptypeDAO = (EmptypeDAO) context.getBean("emptypeDAO");
		Pagination abdao = (Pagination) context.getBean("pagination");
		
//		PageBean pb = empdao.testqueryForPage(5, 5);
//		List<Positiontitle> pts = pb.getList();
//		for (Positiontitle pt : pts) {
//			System.out.println(pt.getPositionTitleName() + "\t" + pt.getPositionTitleDesc());
//		}
		
		Emp emp = empdao.findByLoginName("jasonzh");
//		System.out.println(emp.getEmp().getEmpLoginId());
		Set<Rolemenu> rms = emp.getRole().getRolemenus();
		for (Rolemenu rm : rms) {
			Menuinfo mi = rm.getMenuinfo();
			System.out.println(mi.getMenuName() + "\t" + mi.getDesc());
		}
		
		/*long t1 = System.currentTimeMillis();
		List<Emp> list = empdao.findAll();
		long t2 = System.currentTimeMillis();
		
		System.out.println(list.size());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String loginid = "";
		String chineseName = "";
		String englishName = "";
		String gender = "";
		String address = "";
		String mobile = "";*/
		
//		List<Department> list = empdao.queryForPage("from Department", 5, 10);
//		List<Emp> list = abdao.queryForPage("from Emp", 5, 5);
//		ABaseDAO abdao = new ABaseDAO();
//		List<Emp> list = abdao.queryForPage("from Emp", 5, 10);
//		PageBean pagebean = empdao.queryForPage(5, 3);
//		List<Emp> list = pagebean.getList();
		
//		for (Emp emp : list) {
//			loginid = emp.getEmpLoginId();
//			chineseName = emp.getNameChinese();
//			englishName = emp.getNameEnglish();
//			gender = emp.getGender();
//			address = emp.getAddress();
//			mobile = emp.getMobile();
			
//			emp.setEmpLoginId(loginid.trim());
//			emp.setNameChinese(chineseName.trim());
//			emp.setNameEnglish(englishName.trim());
//			emp.setGender(gender.trim());
//			emp.setAddress(address.trim());
//			emp.setMobile(mobile.trim());
			
//			System.out.println(loginid + "@moravia.com");
//			emp.setEmail(loginid + "@moravia.com");
//			empdao.saveOrUpdate(emp);
//			System.out.println("update successful:---" + loginid.trim());
//			System.out.println(emp.getEmpLoginId());
////			System.out.println(depart.getDepartName() + "\t" + depart.getDepartDesc());
//		}
		
		
//		System.out.println("time cost: " + (t2 - t1));
		
//		System.out.println(emptypeDAO.findById(1).getEmpTypeDesc());
		
//		System.out.println(sdf.format(list.get(1).getPositionTitleValidate()));
//		System.out.println(sdf.format(list.get(1).getDepartmentValidate()));
//		System.out.println(sdf.format(list.get(1).getLineManagerValidate()));
////		System.out.println(sdf.format(list.get(1).getSystemRoleValidate()));
//		System.out.println(sdf.format(list.get(1).getBaseSalaryValidate()));
//		System.out.println(sdf.format(list.get(1).getSocialInsurBaseValidate()));
//		System.out.println(sdf.format(list.get(1).getMboValidate()));
//		System.out.println(sdf.format(list.get(1).getCostCenterValidate()));
		
		
		
//		System.out.println(sdf.format(list.get(1).getDepartmentValidate()));
//		System.out.println(sdf.format(list.get(1).getDepartmentValidate()));
//		System.out.println(list.get(48).getNameEnglish());
		
		
		
		
		
//		Emp e = empdao.findByLoginName("jennifers");
//		System.out.println(e.getNameChinese());
//		System.out.println(e.getEmp().getNameChinese());
//		System.out.println(e.getNameEnglish());
	}
	
}
