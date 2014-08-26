package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Payrollrecord;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;
import com.moravia.hs.base.entity.other.FinancialStatement_SumSeason;

public class testPayrollRecord {

	public static void main(String[] args) throws ParseException {
		
		  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );
		  PayrollrecordDAO payrollrecordDAO = (PayrollrecordDAO) context.getBean("payrollrecordDAO");
		  DepartmentDAO departmentDao = (DepartmentDAO) context.getBean("departmentDAO");
		  BasesalarypropertiesDAO bpDao = (BasesalarypropertiesDAO) context.getBean("basesalarypropertiesDAO");
		  EmpDAO empdao = (EmpDAO) context.getBean("empDAO");
		  
		  /*Emp emp = empdao.findById(49);
		   * 
//		  List<Payrollrecord> list = payrollrecordDAO.findByEmpAndDate(emp, "2013-03-01", "2013-03-31");
//		  System.out.println(list.size());
//		  for (Payrollrecord payrollrecord : list) {
//			System.out.println(payrollrecord.getOvertime() + "\t" + payrollrecord.getCreateDate());
//		}
//		  System.out.println("list.get(0).getCreateDate(): " + list.get(0).getCreateDate());
		
		  Payrollrecord pr = payrollrecordDAO.findByEmpAndDate(emp, "2013-03-01", "2013-03-31");
		  System.out.println(pr.getCreateDate());
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  System.out.println(sdf.format(pr.getCreateDate()));*/
//		  System.out.println(sdf.format(pr.getCreateDate().getDate()));
		  
//		  Department de = departmentDao.findById(1);
//		  Set<Emp> emps = de.getEmps();
//		  
//		  System.out.println(emps.size());
		  
//		  List<FinancialStatement_SumSeason> fss_list =payrollrecordDAO.findFinancialStatementFilterByDepartment("2013-03-01", "2013-03-31");
//		  
//		  System.out.println(fss_list.size());
//		  System.out.println(fss_list.get(0).getCostSum());
		  
//		  List<FinancialStatement_ByDepartOrCostCenter> fsd_lsit = payrollrecordDAO.findFinancialStatementFilterByDepartOrCostCenter("cost_center_name", "2013-02-01", "2013-03-31");
		  /*System.out.println(fsd_lsit.size());
		  System.out.println(fsd_lsit.get(0).getHousingFundCompany());*/
		  
//		  List<FinancialStatement_ByDepartOrCostCenter> fsd_list2 = payrollrecordDAO.findFinancialStatementFilterByCustomized2("('jennifers', 'jasonzh', 'jasonl', 'abbys')", "2013-02-01", "2013-03-31");
//		  System.out.println(fsd_list2.size());
//		  System.out.println(fsd_list2.get(0).getTotal());
		  
//		  List<Payrollrecord> pList = payrollrecordDAO.findAllByDate("2013-02-01", "2013-03-31");
//		  System.out.println("pList.size(): " + pList.size());
//		  
//		  for (Payrollrecord payrollrecord : pList) {
//			System.out.println(payrollrecord.getDepartmentName() + "\t" + payrollrecord.getBaseSalary());
//		}
//		  
		  
		  
//		  List<Payrollrecord> pList = payrollrecordDAO.findAllByDate("2013-03-01", "2013-03-31");
//		  System.out.println(pList.size());
//		  for (Payrollrecord payrollrecord : pList) {
//			System.out.println(payrollrecord.getEmpEmpLoginId() + "\t" + payrollrecord.getTotalTimeSheetHrs() + "\t" + payrollrecord.getBaseSalary() + "\t" + payrollrecord.getIncomeTax());
//		  }
		  
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		  
//		  Basesalaryproperties bp = bpDao.findLastCreated();
//		  
//		  System.out.println("startDate: " + sdf.format(bp.getStartDate()) + "\tendDate: " + sdf.format(bp.getEndDate()));
		  
		  
		 /* String loginids = "'abbys','alicey','alicez','alisal'";
		  payrollrecordDAO.updatePayDate("2013-03-11", loginids);*/
//		  Basesalaryproperties bp = bpDao.findLastCreated();
//		  Date date = bp.getStartDate();
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//		  System.out.println(sdf.format(date));
		  
//		  Payrollrecord pr = payrollrecordDAO.findByEmpAndDate("jasonzh", "2014-04-01", "2014-04-30");
//		  System.out.println(pr.getEmpEmpLoginId() + "\t" + pr.getDepartmentName());
		  List<Payrollrecord> pys = payrollrecordDAO.findByEmp("abbys");
		  System.out.println(pys.size());
		  for (Payrollrecord pr : pys) {
			System.out.println(pr.getEmpEmpLoginId() + "\t" + pr.getMonth() + "\t" + pr.getPayrollNote());
		  }
		  
	}
	
}
