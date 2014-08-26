package com.moravia.hs.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Payrollrecord;
import com.moravia.hs.util.SendMail;
import com.moravia.hs.util.SendMailThread;

@Controller("sendPayrollMailAction")
public class SendPayrollMailAction extends BaseAction{

	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	
	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;
	
	private String pcp_loginids;
	private String pcp_startDate;
	private String pcp_endDate;
	
	public String getPcp_startDate() {
		return pcp_startDate;
	}

	public void setPcp_startDate(String pcp_startDate) {
		this.pcp_startDate = pcp_startDate;
	}

	public String getPcp_endDate() {
		return pcp_endDate;
	}

	public void setPcp_endDate(String pcp_endDate) {
		this.pcp_endDate = pcp_endDate;
	}

	public String getPcp_loginids() {
		return pcp_loginids;
	}

	public void setPcp_loginids(String pcp_loginids) {
		this.pcp_loginids = pcp_loginids;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		List<Emp> empList = empDAO.findAll();
		// System.out.println("empList.size(): " + empList.size());
		List<Payrollrecord> pList = payrollrecordDAO.findAllByDate(pcp_startDate, pcp_endDate);
		// System.out.println("pList.size(): " + pList.size());
		// System.out.println(pcp_loginids);
		
		String[] nameArray = pcp_loginids.split(",");
		// System.out.println("pcp_startDate: " + pcp_startDate + "\t" + "pcp_endDate: " + pcp_endDate);
		// System.out.println("array.length: " + nameArray.length);
		
		String email = null;
		SendMailThread sm = null;
		DecimalFormat df = new DecimalFormat("#.00");	// 四舍五入
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(date);
		String loginids = "";
		
		for (String name : nameArray) {
			// 遍历loginId，并根据LoginId, 查询payroll和email信息
			for (Emp emp : empList) {
				// 取得员工email信息
				if(emp.getEmpLoginId().equalsIgnoreCase(name)) {
					if(emp.getEmail() != null) {
						email = emp.getEmail().trim();
					}
				}
			}
			for (Payrollrecord pr : pList) {
				// 取得员工payroll信息
				if(pr.getEmpEmpLoginId().equalsIgnoreCase(name)) {
					if(email != null) {
						sm = new SendMailThread(); 
						sm.setFrom("payroll@moravia.com");
						
						sm.setTo(email);
						sm.setSubject("Payroll");
						sm.setEmpLoginName(name);
						sm.setMonth(pr.getMonth().toString());
						
						sm.setTotalWorkHrs(pr.getTotalWorkHrs().toString());
						sm.setOvertime(pr.getOvertime().toString());
						sm.setBaseSalary(pr.getBaseSalary().toString());
						sm.setPostAllowance(pr.getPostAllowance().toString());
						sm.setBonus(pr.getBonus().toString());
						sm.setOvertimePay(pr.getOvertimePay().toString());
						
						// totalMonthlySalary
						Double totalMonthlySalary = pr.getBaseSalary() + pr.getQuartBonus() + pr.getPostAllowance() + pr.getTransportAllowance()
								 + pr.getBonus() + pr.getMealSubsidy() + pr.getOvertimePay() + pr.getOtherPay();
						
						sm.setTotalMonthlySalary(df.format(totalMonthlySalary).toString());
						
						sm.setQuartBonus(pr.getQuartBonus().toString());
						sm.setTransAllowance(pr.getTransportAllowance().toString());
						sm.setMealSubsidy(pr.getMealSubsidy().toString());
						sm.setOtherPay(pr.getOtherPay().toString());
						sm.setNote(pr.getPayrollNote());
						sm.setPensionPersonal(pr.getPensionPersonal().toString());
						sm.setMedicalPersonal(pr.getMedicalPersonal().toString());
						sm.setAccumFundPersonal(pr.getAccumFundPersonal().toString());
						sm.setUnempInsuPersonal(pr.getUnempInsuPersonal().toString());
						sm.setIncomeTax(pr.getIncomeTax().toString());
						
						// socialPersonalTotal
						Double socialPersonalTotal = pr.getPensionPersonal() + pr.getMedicalPersonal() + pr.getAccumFundPersonal() + pr.getUnempInsuPersonal() + pr.getIncomeTax();
						sm.setSocialPersonalTotal(df.format(socialPersonalTotal).toString());
						
						sm.setPensionCompany(pr.getPensionCompany().toString());
						sm.setMedicalCompany(pr.getMedicalCompany().toString());
						sm.setAccumFundCompany(pr.getAccumFundCompany().toString());
						sm.setUnempInsuCompany(pr.getUnempInsuCompany().toString());
						sm.setOccupInjureMaternity(pr.getOccupInjureMaternity().toString());
						
						// socialCompanyTotal
						Double socialCompanyTotal = pr.getPensionCompany() + pr.getMedicalCompany() + pr.getAccumFundCompany() + pr.getUnempInsuCompany() + pr.getOccupInjureMaternity();
						
						sm.setSocialCompanyTotal(df.format(socialCompanyTotal).toString());
						
						// totalSalary
						Double totalSalary = totalMonthlySalary + socialCompanyTotal;
						sm.setTotalSalary(df.format(totalSalary).toString());
						
						// takeHomeMoney
						Double takeHomeMoney = totalMonthlySalary - socialPersonalTotal;
						sm.setTakeHomeMoney(df.format(takeHomeMoney).toString());
						sm.start();
						
						loginids += "'" + name + "',";
					}
				}
			}
		}
		payrollrecordDAO.updatePayDate(strdate, loginids.substring(0, loginids.lastIndexOf(",")));
		return SUCCESS;
	}
	
	
}
