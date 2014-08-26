package com.moravia.hs.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Payrollrecord;
import com.moravia.hs.base.entity.other.Login;

@Controller("myPayrollAction")
public class MyPayrollAction extends BaseAction{

	@Autowired
	private PayrollrecordDAO payrollrecordDAO;
	
	private String mypayroll_month;
	private Payrollrecord payrollrecord;
	

	public String getMypayroll_month() {
		return mypayroll_month;
	}

	public void setMypayroll_month(String mypayroll_month) {
		this.mypayroll_month = mypayroll_month;
	}

	public Payrollrecord getPayrollrecord() {
		return payrollrecord;
	}

	public void setPayrollrecord(Payrollrecord payrollrecord) {
		this.payrollrecord = payrollrecord;
	}

	
	public String toMyPayrollPage() {
		System.out.println("##进入toMyPayrollPage()##");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		List<Integer> months = payrollrecordDAO.findAllMonthByEmp(login.getEmp().getEmpLoginId());
		Payrollrecord pr = null;
		if(months.size() > 0) {
			List<Payrollrecord> prs = payrollrecordDAO.findByEmpAndMonth(login.getEmp().getEmpLoginId(), months.get(0));
			if(prs.size() > 0) {
				pr = prs.get(0);
			}
		}
		session.put("mypayroll_months", months);
		session.put("mypayroll_pr", pr);
		return SUCCESS;
	}
	
	
	
	public String getMyPayrollByMonth() {
		System.out.println("##进入getMyPayrollByMonth()##");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		int month = Integer.parseInt(mypayroll_month.trim());
		List<Payrollrecord> prs = payrollrecordDAO.findByEmpAndMonth(login.getEmp().getEmpLoginId(), month);
		payrollrecord = prs.get(0);
		
		return SUCCESS;
	}
	
	
}
