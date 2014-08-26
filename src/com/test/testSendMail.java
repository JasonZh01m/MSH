package com.test;

import com.moravia.hs.util.SendMail;

public class testSendMail {

	public static void main(String[] args) {
		
		SendMail sm = new SendMail();
		sm.setFrom("finance@moravia.com");
		sm.setTo("xinghuai_zhou@163.com");
		sm.setSubject("This is payroll test for send only once");
		
		sm.setTotalWorkHrs("175");
		sm.setOvertime("6");
		sm.setBaseSalary("2000");
		sm.setPostAllowance("100");
		sm.setBonus("100");
		sm.setOvertimePay("200");
		sm.setTotalMonthlySalary("4762.35");
		sm.setQuartBonus("120");
		sm.setTransAllowance("104.76");
		sm.setMealSubsidy("330");
		sm.setOtherPay("100");
		sm.setNote("好好学习，天天向上");
		sm.setPensionPersonal("288");
		sm.setMedicalPersonal("32");
		sm.setAccumFundPersonal("34");
		sm.setUnempInsuPersonal("100");
		sm.setIncomeTax("100");
		sm.setSocialPersonalTotal("100");
		sm.setPensionCompany("100");
		sm.setMedicalCompany("100");
		sm.setAccumFundCompany("100");
		sm.setUnempInsuCompany("100");
		sm.setOccupInjureMaternity("100");
		sm.setSocialCompanyTotal("100");
		sm.setTotalSalary("40000");
		sm.setTakeHomeMoney("50000");
		sm.sendMail();
	}
}
