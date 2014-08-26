package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.BaseincomtaxDAO;
import com.moravia.hs.base.dao.CompensatoryleaveinfoDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.entity.Compensatoryleaveinfo;
import com.moravia.hs.base.entity.Emp;

public class testCompensatoryDao {
	
	public static void main(String[] args) throws ParseException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompensatoryleaveinfoDAO comdao = (CompensatoryleaveinfoDAO) context.getBean("compensatoryleaveinfoDAO");
		EmpDAO empdao = (EmpDAO) context.getBean("empDAO");
		
		/*Compensatoryleaveinfo ci = new Compensatoryleaveinfo();
		Emp emp = empdao.findByLoginName("jasonzh");
		
		ci.setEmp(emp);	// 关联员工
		ci.setCompensatoryLeaveLeft(8.0);	// 设定剩余假期
		Date date = new Date();
		ci.setCreateDate(date);
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.MONTH, 7);
		Date date2 = ca.getTime();
		ci.setExpirationDate(date2);	// 设定有效期为半年后
		ci.setCompensatoryLeaveDesc("加班补偿2");
		
		comdao.save(ci);*/
		
//		List<Compensatoryleaveinfo> coms = comdao.findAll();
//		for (Compensatoryleaveinfo co : coms) {
//			System.out.println(co.getCompensatoryLeaveId() + "\t\t" + co.getCompensatoryLeaveDesc());
//		}
//		
		
		Emp emp = empdao.findByLoginName("jasonzh");
		System.out.println("剩余年假: " + emp.getAnnualLeaveLeft());
		
		SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("总共剩余调休假小时数： " + comdao.findTotalCompensatoryLeaveLeft(emp, sdft.format(new Date())));
		
//		List<Compensatoryleaveinfo> coms = comdao.findByEmp(emp);
//		for (Compensatoryleaveinfo co : coms) {
//			System.out.println(co.getCompensatoryLeaveId() + "\t\t" + co.getCompensatoryLeaveDesc());
//		}
		
//		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat yearsdf = new SimpleDateFormat("yyyy");
		String d = "2013-04-01 16:00:00";
		Date date = sdf.parse(d);
		
		Calendar cl = Calendar.getInstance();
//		cl.set(Calendar.YEAR, Integer.parseInt(yearsdf.format(date)));
//		cl.set
		cl.set(Integer.parseInt(yearsdf.format(date)), 0, 0, 0, 0, 0);
		cl.add(Calendar.DATE, 1);
		System.out.println(sdf.format(cl.getTime()));
	}

}
