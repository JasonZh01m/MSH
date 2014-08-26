package com.moravia.hs.util;

import javax.mail.MessagingException;

public class SendMailThread extends Thread{
	
	private String from;
	private String to;
	private String subject;
	private String empLoginName;
	private String month;
	
	private String totalWorkHrs;
	private String overtime;
	private String baseSalary;
	private String postAllowance;
	private String bonus;
	private String overtimePay;
	private String totalMonthlySalary;
	private String quartBonus;
	private String transAllowance;
	private String mealSubsidy;
	private String otherPay;
	private String note;
	private String pensionPersonal;
	private String medicalPersonal;
	private String accumFundPersonal;
	private String unempInsuPersonal;
	private String incomeTax;
	private String socialPersonalTotal;
	private String pensionCompany;
	private String medicalCompany;
	private String accumFundCompany;
	private String unempInsuCompany;
	private String occupInjureMaternity;
	private String socialCompanyTotal;
	private String totalSalary;
	private String takeHomeMoney;
	
	public String getEmpLoginName() {
		return empLoginName;
	}
	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTotalWorkHrs() {
		return totalWorkHrs;
	}
	public void setTotalWorkHrs(String totalWorkHrs) {
		this.totalWorkHrs = totalWorkHrs;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}
	public String getPostAllowance() {
		return postAllowance;
	}
	public void setPostAllowance(String postAllowance) {
		this.postAllowance = postAllowance;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(String overtimePay) {
		this.overtimePay = overtimePay;
	}
	public String getTotalMonthlySalary() {
		return totalMonthlySalary;
	}
	public void setTotalMonthlySalary(String totalMonthlySalary) {
		this.totalMonthlySalary = totalMonthlySalary;
	}
	public String getQuartBonus() {
		return quartBonus;
	}
	public void setQuartBonus(String quartBonus) {
		this.quartBonus = quartBonus;
	}
	public String getTransAllowance() {
		return transAllowance;
	}
	public void setTransAllowance(String transAllowance) {
		this.transAllowance = transAllowance;
	}
	public String getMealSubsidy() {
		return mealSubsidy;
	}
	public void setMealSubsidy(String mealSubsidy) {
		this.mealSubsidy = mealSubsidy;
	}
	public String getOtherPay() {
		return otherPay;
	}
	public void setOtherPay(String otherPay) {
		this.otherPay = otherPay;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPensionPersonal() {
		return pensionPersonal;
	}
	public void setPensionPersonal(String pensionPersonal) {
		this.pensionPersonal = pensionPersonal;
	}
	public String getMedicalPersonal() {
		return medicalPersonal;
	}
	public void setMedicalPersonal(String medicalPersonal) {
		this.medicalPersonal = medicalPersonal;
	}
	public String getAccumFundPersonal() {
		return accumFundPersonal;
	}
	public void setAccumFundPersonal(String accumFundPersonal) {
		this.accumFundPersonal = accumFundPersonal;
	}
	public String getUnempInsuPersonal() {
		return unempInsuPersonal;
	}
	public void setUnempInsuPersonal(String unempInsuPersonal) {
		this.unempInsuPersonal = unempInsuPersonal;
	}
	public String getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(String incomeTax) {
		this.incomeTax = incomeTax;
	}
	public String getSocialPersonalTotal() {
		return socialPersonalTotal;
	}
	public void setSocialPersonalTotal(String socialPersonalTotal) {
		this.socialPersonalTotal = socialPersonalTotal;
	}
	public String getPensionCompany() {
		return pensionCompany;
	}
	public void setPensionCompany(String pensionCompany) {
		this.pensionCompany = pensionCompany;
	}
	public String getMedicalCompany() {
		return medicalCompany;
	}
	public void setMedicalCompany(String medicalCompany) {
		this.medicalCompany = medicalCompany;
	}
	public String getAccumFundCompany() {
		return accumFundCompany;
	}
	public void setAccumFundCompany(String accumFundCompany) {
		this.accumFundCompany = accumFundCompany;
	}
	public String getUnempInsuCompany() {
		return unempInsuCompany;
	}
	public void setUnempInsuCompany(String unempInsuCompany) {
		this.unempInsuCompany = unempInsuCompany;
	}
	public String getOccupInjureMaternity() {
		return occupInjureMaternity;
	}
	public void setOccupInjureMaternity(String occupInjureMaternity) {
		this.occupInjureMaternity = occupInjureMaternity;
	}
	public String getSocialCompanyTotal() {
		return socialCompanyTotal;
	}
	public void setSocialCompanyTotal(String socialCompanyTotal) {
		this.socialCompanyTotal = socialCompanyTotal;
	}
	public String getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}
	public String getTakeHomeMoney() {
		return takeHomeMoney;
	}
	public void setTakeHomeMoney(String takeHomeMoney) {
		this.takeHomeMoney = takeHomeMoney;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
				String content = 
				"<html xmlns='http://www.w3.org/1999/xhtml'>\n" +
						"<head>\n" +
						"<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n" +
						"<title>Untitled Document</title>\n" +
						"</head>\n" +
						"<body>\n" +
						"<table width='600' border='0' align='center' cellpadding='0' cellspacing='0'>\n" +
						"  <tr>\n" +
						"    <td width='407' align='left' valign='middle' bgcolor='#000000' style='background-color:#000000; padding:20px; color:#ffffff;'>\n" +
						"     <div style='font-size:32px; color:#ffbe00;'>\n" +
						"      <i>Payroll</i>\n" +
						"      </div>\n" +
						"      \n" +
						"    </td>\n" +
						"    <td width='193' align='left' valign='middle' bgcolor='#000000' style='background-color:#000000; padding:20px; color:#ffffff;'>\n" +
						"       <div style='color:white; font-size:24px;'>" + empLoginName + "</div>\n" +
						"    </td>\n" +
						"  </tr>\n" +
						"</table>\n" +
						"<table width='600' border='0' align='center' cellpadding='0' cellspacing='1' bgcolor='#971800' style='background-color:#971800;'>\n" +
						"  <tr>\n" +
						"    <td align='center' valign='top' bgcolor='#ffffff' style='background-color:#ffffff;'><table width='100%' border='0' cellspacing='0' cellpadding='0'>\n" +
						"      <tr>\n" +
						"		 <td align='left' valign='top' bgcolor='#e7e0b7' style='background-color:#e7e0b7; padding:20px;'>\n" +
						"        <table width='100%' border='0' cellspacing='0' cellpadding='10' style='margin-bottom:10px;'>\n" +
						"        	<th colspan='2' align='left' style='padding:10px;'> <div style='font-size:22px; color:#CD7B00;'>\n" +
						"        	  <b>Salary Part</b>\n" +
						"        	</div></th>\n" +
						"            <tr>\n" +
						"            	 <td width='15%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"                 	<div style='margin-bottom:10px; font-weight:bold;'>工作时间：</div>\n" +
						"                 </td>\n" +
						"                 <td width='15%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"                 	<div style='margin-bottom:10px; font-weight:bold;'>" + totalWorkHrs + " hrs</div>\n" +
						"                 </td>\n" +
						"                 <td width='15%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"                 	<div style='margin-bottom:10px; font-weight:bold;'>加班时间：</div>\n" +
						"                 </td>\n" +
						"                 <td width='15%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"                 	<div style='margin-bottom:10px; font-weight:bold;'>" + overtime + " hrs</div>\n" +
						"                 </td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"              <td width='15%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>基本工资：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>岗位津贴：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>奖励：</div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>加班费：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>总计：</div>\n" +
						"              </div></td>\n" +
						"                <td width='15%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:11px; font-weight:bold;'>" + baseSalary + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + postAllowance + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + bonus + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + overtimePay + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + totalMonthlySalary + "</div>\n" +
						"              </div></td>\n" +
						"             <td width='15%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>季度奖金：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>交通津贴：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>餐补：</div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>Adjustment：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>Note：</div>\n" +
						"              </div></td>\n" +
						"              <td width='25%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"               <div>\n" +
						"					<div style='margin-bottom:11px; font-weight:bold;'>" + quartBonus + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + transAllowance + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + mealSubsidy + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + otherPay + "</div>\n" +
						"                    <div style='margin-bottom:11px;'>" + note + "</div>\n" +
						"              </div></td>\n" +
						"            </tr>\n" +
						"          </table>\n" +
						"        </td>\n" +
						"      </tr>\n" +
						"     \n" +
						"      <tr>\n" +
						"        <td align='left' valign='top' bgcolor='#e7e0b7' style='background-color:#e7e0b7; padding:20px;'>\n" +
						"        <table width='100%' border='0' cellspacing='0' cellpadding='10' style='margin-bottom:10px;'>\n" +
						"        	<th colspan='2' align='left' style='padding-top:0px;'> <div style='font-size:22px; color:#CD7B00;'><b>Social Insurance</b></div></th>\n" +
						"            <tr>\n" +
						"            	<td colspan='2' align='center' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight:bold; color:#53231A;'>\n" +
						"                	<div>个人部分：</div>\n" +
						"                </td>\n" +
						"            	<td colspan='2' align='center' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight:bold; color:#53231A;'>\n" +
						"                	<div>公司部分：</div>\n" +
						"                </td>\n" +
						"            </tr>\n" +
						"            <tr>\n" +
						"              <td width='15%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>养老保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>医疗保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>公积金：</div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>失业保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>本月扣税：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>总计：</div>\n" +
						"              </div></td>\n" +
						"                <td width='15%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:11px; font-weight:bold;'>" + pensionPersonal + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + medicalPersonal + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + accumFundPersonal + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + unempInsuPersonal + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + incomeTax + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + socialPersonalTotal + "</div>\n" +
						"              </div></td>\n" +
						"             <td width='20%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>养老保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>医疗保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>公积金：</div>\n" +
						"					<div style='margin-bottom:10px; font-weight:bold;'>失业保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>工伤生育保险：</div>\n" +
						"                    <div style='margin-bottom:10px; font-weight:bold;'>总计：</div>\n" +
						"              </div></td>\n" +
						"              <td width='25%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'>\n" +
						"              <div>\n" +
						"					<div style='margin-bottom:11px; font-weight:bold;'>" + pensionCompany + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + medicalCompany + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + accumFundCompany + "</div>\n" +
						"                    <div style='margin-bottom:11px; font-weight:bold;'>" + unempInsuCompany + "</div>\n" +
						"                     <div style='margin-bottom:11px; font-weight:bold;'>" + occupInjureMaternity + "</div>\n" +
						"                      <div style='margin-bottom:11px; font-weight:bold;'>" + socialCompanyTotal + "</div>\n" +
						"              </div></td>\n" +
						"            </tr>\n" +
						"          </table>\n" +
						"         </td>\n" +
						"      </tr>\n" +
						"      \n" +
						"      \n" +
						"      <tr>\n" +
						"        <td align='left' valign='top' bgcolor='#e7e0b7' style='background-color:#e7e0b7; padding:20px;'><table width='100%' border='0' cellspacing='0' cellpadding='10' style='margin-bottom:10px;'>\n" +
						"  			<th colspan='2' align='left' style='padding-top:0px;'> <div style='font-size:22px; color:#53231A;'>总计：</div></th>\n" +
						"              <tr>\n" +
						"                <td width='18%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'><div>\n" +
						"                  <div style='margin-bottom:10px; font-weight:bold;'>工资总计：</div>\n" +
						"                </div></td>\n" +
						"                <td width='15%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'><div>\n" +
						"                  <div style='margin-bottom:10px; font-weight:bold;'>" + totalSalary + "</div>\n" +
						"                </div></td>\n" +
						"                <td width='20%' align='right' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'><div>\n" +
						"                  <div style='margin-bottom:10px; font-weight:bold;'>实发工资：</div>\n" +
						"            </div></td>\n" +
						"                <td width='25%' align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:15px; color:#53231A;'><div>\n" +
						"                  <div style='margin-bottom:10px; font-weight:bold;'>" + takeHomeMoney + "</div>\n" +
						"                </div></td>\n" +
						"              </tr>\n" +
						"        </table>\n" +
						"          <table width='100%' border='0' cellspacing='0' cellpadding='10' style='margin-bottom:10px;'>\n" +
						"            <tr>\n" +
						"              <td align='left' valign='top' style='font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#000000;'><div><b>Month: </b>" + month + "</div></td>\n" +
						"            </tr>\n" +
						"          </table>\n" +
						"         </td>\n" +
						"      </tr>\n" +
						"    </table></td>\n" +
						"  </tr>\n" +
						"</table>\n" +
						"</body>\n" +
						"</html>";
			
				try {
					new Mailer("smtp.moravia-it.com", "false", null, from, "").send(
							new String[] {to}, null, null, subject,
							content);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	
	}
