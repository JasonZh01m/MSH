package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.EmpchangerecordDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Payrollrecord;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author jasonzh Save payroll record
 */
@Controller("savePayrollAction")
public class SavePayrollAction extends BaseAction {
	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;
	@Resource(name = "empchangerecordDAO")
	private EmpchangerecordDAO empchangerecordDAO;

	private String sip_monthlyPaidHrs2;
	private String sip_monthlyOverTimeHrs2;

	private String sip_monthlyBaseSalary2;
	private String sip_quarterlyBonus2;
	private String sip_postAllowance2;
	private String sip_transAllowance2;
	private String sip_Bonus2;
	private String sip_mealSubsidy2;
	private String sip_overTimePay2;
	private String sip_otherPay2;
	private String sip_otherPayNote2;
	private String pension_Personal2;
	private String pension_Company2;
	private String medical_Personal2;
	private String medical_Company2;
	private String accum_Fund_Personal2;
	private String accum_Fund_Company2;
	private String unemp_Insu_Personal2;
	private String unemp_Insu_Company2;
	private String sip_incomtax2;
	private String occupInjure_maternity_Company2;

	// Portion related
	private String sip_mboPortion;
	private String sip_annuBonusPortion;

	public String getSip_mboPortion() {
		return sip_mboPortion;
	}

	public void setSip_mboPortion(String sip_mboPortion) {
		this.sip_mboPortion = sip_mboPortion;
	}

	public String getSip_annuBonusPortion() {
		return sip_annuBonusPortion;
	}

	public void setSip_annuBonusPortion(String sip_annuBonusPortion) {
		this.sip_annuBonusPortion = sip_annuBonusPortion;
	}

	public String getSip_otherPayNote2() {
		return sip_otherPayNote2;
	}

	public void setSip_otherPayNote2(String sip_otherPayNote2) {
		this.sip_otherPayNote2 = sip_otherPayNote2;
	}

	public String getSip_otherPay2() {
		return sip_otherPay2;
	}

	public void setSip_otherPay2(String sip_otherPay2) {
		this.sip_otherPay2 = sip_otherPay2;
	}

	public String getSip_monthlyBaseSalary2() {
		return sip_monthlyBaseSalary2;
	}

	public void setSip_monthlyBaseSalary2(String sip_monthlyBaseSalary2) {
		this.sip_monthlyBaseSalary2 = sip_monthlyBaseSalary2;
	}

	public String getSip_quarterlyBonus2() {
		return sip_quarterlyBonus2;
	}

	public void setSip_quarterlyBonus2(String sip_quarterlyBonus2) {
		this.sip_quarterlyBonus2 = sip_quarterlyBonus2;
	}

	public String getSip_postAllowance2() {
		return sip_postAllowance2;
	}

	public void setSip_postAllowance2(String sip_postAllowance2) {
		this.sip_postAllowance2 = sip_postAllowance2;
	}

	public String getSip_transAllowance2() {
		return sip_transAllowance2;
	}

	public void setSip_transAllowance2(String sip_transAllowance2) {
		this.sip_transAllowance2 = sip_transAllowance2;
	}

	public String getSip_Bonus2() {
		return sip_Bonus2;
	}

	public void setSip_Bonus2(String sip_Bonus2) {
		this.sip_Bonus2 = sip_Bonus2;
	}

	public String getSip_mealSubsidy2() {
		return sip_mealSubsidy2;
	}

	public void setSip_mealSubsidy2(String sip_mealSubsidy2) {
		this.sip_mealSubsidy2 = sip_mealSubsidy2;
	}

	public String getSip_overTimePay2() {
		return sip_overTimePay2;
	}

	public void setSip_overTimePay2(String sip_overTimePay2) {
		this.sip_overTimePay2 = sip_overTimePay2;
	}

	public String getPension_Personal2() {
		return pension_Personal2;
	}

	public void setPension_Personal2(String pension_Personal2) {
		this.pension_Personal2 = pension_Personal2;
	}

	public String getPension_Company2() {
		return pension_Company2;
	}

	public void setPension_Company2(String pension_Company2) {
		this.pension_Company2 = pension_Company2;
	}

	public String getMedical_Personal2() {
		return medical_Personal2;
	}

	public void setMedical_Personal2(String medical_Personal2) {
		this.medical_Personal2 = medical_Personal2;
	}

	public String getMedical_Company2() {
		return medical_Company2;
	}

	public void setMedical_Company2(String medical_Company2) {
		this.medical_Company2 = medical_Company2;
	}

	public String getAccum_Fund_Personal2() {
		return accum_Fund_Personal2;
	}

	public void setAccum_Fund_Personal2(String accum_Fund_Personal2) {
		this.accum_Fund_Personal2 = accum_Fund_Personal2;
	}

	public String getAccum_Fund_Company2() {
		return accum_Fund_Company2;
	}

	public void setAccum_Fund_Company2(String accum_Fund_Company2) {
		this.accum_Fund_Company2 = accum_Fund_Company2;
	}

	public String getUnemp_Insu_Personal2() {
		return unemp_Insu_Personal2;
	}

	public void setUnemp_Insu_Personal2(String unemp_Insu_Personal2) {
		this.unemp_Insu_Personal2 = unemp_Insu_Personal2;
	}

	public String getUnemp_Insu_Company2() {
		return unemp_Insu_Company2;
	}

	public void setUnemp_Insu_Company2(String unemp_Insu_Company2) {
		this.unemp_Insu_Company2 = unemp_Insu_Company2;
	}

	public String getSip_incomtax2() {
		return sip_incomtax2;
	}

	public void setSip_incomtax2(String sip_incomtax2) {
		this.sip_incomtax2 = sip_incomtax2;
	}

	public String getOccupInjure_maternity_Company2() {
		return occupInjure_maternity_Company2;
	}

	public void setOccupInjure_maternity_Company2(
			String occupInjure_maternity_Company2) {
		this.occupInjure_maternity_Company2 = occupInjure_maternity_Company2;
	}

	public String getSip_monthlyOverTimeHrs2() {
		return sip_monthlyOverTimeHrs2;
	}

	public void setSip_monthlyOverTimeHrs2(String sip_monthlyOverTimeHrs2) {
		this.sip_monthlyOverTimeHrs2 = sip_monthlyOverTimeHrs2;
	}

	public String getSip_monthlyPaidHrs2() {
		return sip_monthlyPaidHrs2;
	}

	public void setSip_monthlyPaidHrs2(String sip_monthlyPaidHrs2) {
		this.sip_monthlyPaidHrs2 = sip_monthlyPaidHrs2;
	}

	@Override
	public String execute() throws Exception {
		// ActionContext.getContext().getSession().
		System.out.println("Save Payroll Action####");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println("sip_monthlyPaidHrs2:" + sip_monthlyPaidHrs2);
		// System.out.println("sip_otherPay2: " + sip_otherPay2.trim());
		// System.out.println("sip_otherPayNote2: " + sip_otherPayNote2.trim());
		// 直接get session?
		// Map<String, Object> session =
		// ActionContext.getContext().getSession();
		Map<String, Object> session = getSession();
		// // System.out.println(session.get("sip_incomtax"));
		//
		String startDate = (String) session.get("startDate");
		// // System.out.println("startDate: " + startDate);

		// String startDate2 = (String) session.get("startDate");
		// // System.out.println("startDate2: " + startDate2);

		// // System.out.println("sip_monthlyTotalHrs: " + startDate);
		//
		String endDate = (String) session.get("endDate");
		Double sip_monthlyTotalHrs = (Double) session
				.get("sip_monthlyTotalHrs");
		Emp emp = (Emp) session.get("Emp");

		// System.out.println("get Emp success");
		// System.out.println("emp.getMobile(): " + emp.getMobile());
		// System.out.println("Integer.parseInt: " +
		// Integer.parseInt(startDate.replace("-", "").substring(0, 6)));
		Integer payrollId = (Integer) session.get("sip_payrollId");
		System.out.println("This is payrollID: " + payrollId);
		Payrollrecord pr = null;
		if (payrollId == 0 || payrollId == null) {
			pr = new Payrollrecord();
//			System.out.println("payrollId == 0 || payrollId == null and return error");
//			return ERROR;
		} else {
			pr = payrollrecordDAO.findById(payrollId);
		}
		// Payroll set empLoginId
		pr.setEmpEmpLoginId(emp.getEmpLoginId());

		// System.out.println("save Emp success");

		pr.setMonth(Integer
				.parseInt(startDate.replace("-", "").substring(0, 6)));
		pr.setStartDate(sdf.parse(startDate));
		pr.setEndDate(sdf.parse(endDate));
		pr.setBaseSalary(Double.parseDouble(sip_monthlyBaseSalary2.trim()));
		pr.setQuartBonus(Double.parseDouble(sip_quarterlyBonus2.trim()));
		pr.setPostAllowance(Double.parseDouble(sip_postAllowance2.trim()));
		pr.setTransportAllowance(Double.parseDouble(sip_transAllowance2.trim()));
		pr.setBonus(Double.parseDouble(sip_Bonus2.trim()));
		pr.setMealSubsidy(Double.parseDouble(sip_mealSubsidy2.trim()));
		pr.setOvertime(Double.parseDouble(sip_monthlyOverTimeHrs2.trim()));
		pr.setOvertimePay(Double.parseDouble(sip_overTimePay2.trim()));
		pr.setOtherPay(Double.parseDouble(sip_otherPay2.trim()));
		if (sip_otherPayNote2 != null) {
			pr.setPayrollNote(sip_otherPayNote2.trim());
		} else {
			pr.setPayrollNote(null);
		}
		pr.setTotalWorkHrs(Double.parseDouble(sip_monthlyPaidHrs2.trim()));
		pr.setTotalTimeSheetHrs(sip_monthlyTotalHrs);
		pr.setPensionPersonal(Double.parseDouble(pension_Personal2.trim()));

		// 判断department有效性和costcenter有效性
		Date departValidate = emp.getDepartmentValidate();
		Date costcenterValidate = emp.getCostCenterValidate();

		if (departValidate.compareTo(sdf.parse(startDate)) < 0) {
			pr.setDepartmentName(emp.getDepartment().getDepartName());

		} else if (departValidate.compareTo(sdf.parse(startDate)) >= 0
				&& departValidate.compareTo(sdf.parse(endDate)) <= 0) {
			pr.setDepartmentName(emp.getDepartment().getDepartName());
		} else if (departValidate.compareTo(sdf.parse(endDate)) > 0) {
			// 从历史记录当中找到最新的department记录
			// e.g.
			String departname = empchangerecordDAO.getLatestDepartment(
					emp.getEmpLoginId(), endDate);
			if (departname != null) {
				pr.setDepartmentName(departname);
			} else {
				pr.setDepartmentName("ATestOldDepart");
			}

		}

		if (costcenterValidate.compareTo(sdf.parse(startDate)) < 0) {
			pr.setCostCenterName(emp.getCostcenter().getCostCenterName());
		} else if (costcenterValidate.compareTo(sdf.parse(startDate)) >= 0
				&& costcenterValidate.compareTo(sdf.parse(endDate)) <= 0) {
			pr.setCostCenterName(emp.getCostcenter().getCostCenterName());
		} else if (costcenterValidate.compareTo(sdf.parse(endDate)) > 0) {
			// 从历史记录当中找到最新的costcenter记录
			// e.g.
			String costcenter = empchangerecordDAO.getLatestCostCenter(
					emp.getEmpLoginId(), endDate);
			if (costcenter != null) {
				pr.setCostCenterName(costcenter);
			} else {
				pr.setCostCenterName("ATestOldCostCenter");
			}
		}

		// try {
		pr.setPensionCompany(Double.parseDouble(pension_Company2.trim()));
		// } catch (Exception e) {
		// // TODO: handle exception
		// // System.out.println("pension_Company2 exception throws...");
		// }

		pr.setMedicalPersonal(Double.parseDouble(medical_Personal2.trim()));
		pr.setMedicalCompany(Double.parseDouble(medical_Company2.trim()));
		pr.setAccumFundPersonal(Double.parseDouble(accum_Fund_Personal2.trim()));
		pr.setAccumFundCompany(Double.parseDouble(accum_Fund_Company2.trim()));
		pr.setUnempInsuPersonal(Double.parseDouble(unemp_Insu_Personal2.trim()));
		pr.setUnempInsuCompany(Double.parseDouble(unemp_Insu_Company2.trim()));
		pr.setIncomeTax(Double.parseDouble(sip_incomtax2.trim()));
		pr.setOccupInjureMaternity(Double
				.parseDouble(occupInjure_maternity_Company2.trim()));

		//Set Portion.
		if(sip_mboPortion.trim().length() > 0) {
			pr.setMboMonthlyPortion(Double.parseDouble(sip_mboPortion.trim()));
		}
		if(sip_annuBonusPortion.trim().length() > 0) {
			pr.setAnnualBonusMonthlyPortion(Double.parseDouble(sip_annuBonusPortion.trim()));
		}

		Date date = new Date();
		pr.setCreateDate(new Timestamp(date.getTime()));

		payrollrecordDAO.saveOrUpdate(pr);
		System.out.println("save payroll...");

		return SUCCESS;
	}

	public String savePortion() {
		Map<String, Object> session = getSession();
		// System.out.println("This is savePortion method...");
		// System.out.println("sip_mboPortion: " + sip_mboPortion);
		// System.out.println("sip_annuBonusPortion: " + sip_annuBonusPortion);
		
		Integer payrollId = (Integer) session.get("sip_payrollId");

		Payrollrecord pr = null;
		if (payrollId == 0 || payrollId == null) {
//			pr = new Payrollrecord();
			session.put("globalError", "You must confirm the payroll first, and then you can update the portion infomation.");
			return ERROR;
		} else {
			pr = payrollrecordDAO.findById(payrollId);
		}
		
		// System.out.println("get payroll successfully... PID is: " + pr.getPayrollId() + "\t, and empLoginId is: " + pr.getEmpEmpLoginId());
		pr.setMboMonthlyPortion(Double.parseDouble(sip_mboPortion.trim()));
		pr.setAnnualBonusMonthlyPortion(Double.parseDouble(sip_annuBonusPortion.trim()));
		payrollrecordDAO.save(pr);
		
		return SUCCESS;
	}

}
