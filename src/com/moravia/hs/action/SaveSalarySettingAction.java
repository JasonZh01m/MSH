package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BaseincomtaxDAO;
import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.entity.Baseincomtax;
import com.moravia.hs.base.entity.Basesalaryproperties;

@Controller("saveSalarySettingAction")
public class SaveSalarySettingAction extends BaseAction {
	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;
	@Resource(name = "baseincomtaxDAO")
	private BaseincomtaxDAO baseincomtaxDAO;
	private String operationFlag_tossp;  //option Flag
	
	private String ssp_startDate2; //set baseSalaryProperties
	private String ssp_endDate2; //set baseSalaryProperties
	private String ssp_totalWorkHours2; //set baseSalaryProperties
	private String ssp_totalWorkDays2; //set baseSalaryProperties
	private String ssp_baseSalaryHrs2; //set baseSalaryProperties
	private String ssp_dailyMealSubsidy2; //set baseSalaryProperties
	private String ssp_monthlyTransAllowance2; //set baseSalaryProperties
	private String ssp_probationBaseRate2; //set baseSalaryProperties
	private String ssp_minimumWage2; //set baseSalaryProperties
	private String ssp_incomtaxThreshold2; //set baseSalaryProperties
	
	private String ssp_monthlyPaidIncomeMoney; //add new income tax
	private String ssp_monthlyPaidIncomeRate; //add new income tax
	private String ssp_monthlyPaidIncomeDesc; //add new income tax
	
	//Edit IncomeTax
	private String ssp_editIncomTax_Id;
	private String ssp_editIncomTaxMoney;
	private String ssp_editIncomTaxRate;
	private String ssp_editIncomTaxDesc;
	
	//Delete Income Tax
	private String ssp_deleteIncomTax_Id;
	
	
	public String getSsp_deleteIncomTax_Id() {
		return ssp_deleteIncomTax_Id;
	}

	public void setSsp_deleteIncomTax_Id(String ssp_deleteIncomTax_Id) {
		this.ssp_deleteIncomTax_Id = ssp_deleteIncomTax_Id;
	}

	public String getSsp_editIncomTax_Id() {
		return ssp_editIncomTax_Id;
	}

	public void setSsp_editIncomTax_Id(String ssp_editIncomTax_Id) {
		this.ssp_editIncomTax_Id = ssp_editIncomTax_Id;
	}

	public String getSsp_editIncomTaxMoney() {
		return ssp_editIncomTaxMoney;
	}

	public void setSsp_editIncomTaxMoney(String ssp_editIncomTaxMoney) {
		this.ssp_editIncomTaxMoney = ssp_editIncomTaxMoney;
	}

	public String getSsp_editIncomTaxRate() {
		return ssp_editIncomTaxRate;
	}

	public void setSsp_editIncomTaxRate(String ssp_editIncomTaxRate) {
		this.ssp_editIncomTaxRate = ssp_editIncomTaxRate;
	}

	public String getSsp_editIncomTaxDesc() {
		return ssp_editIncomTaxDesc;
	}

	public void setSsp_editIncomTaxDesc(String ssp_editIncomTaxDesc) {
		this.ssp_editIncomTaxDesc = ssp_editIncomTaxDesc;
	}


	public void setOperationFlag_tossp(String operationFlag_tossp) {
		this.operationFlag_tossp = operationFlag_tossp;
	}

	public void setBasesalarypropertiesDAO(
			BasesalarypropertiesDAO basesalarypropertiesDAO) {
		this.basesalarypropertiesDAO = basesalarypropertiesDAO;
	}

	public void setSsp_monthlyPaidIncomeMoney(String ssp_monthlyPaidIncomeMoney) {
		this.ssp_monthlyPaidIncomeMoney = ssp_monthlyPaidIncomeMoney;
	}

	public void setSsp_monthlyPaidIncomeRate(String ssp_monthlyPaidIncomeRate) {
		this.ssp_monthlyPaidIncomeRate = ssp_monthlyPaidIncomeRate;
	}

	public void setSsp_monthlyPaidIncomeDesc(String ssp_monthlyPaidIncomeDesc) {
		this.ssp_monthlyPaidIncomeDesc = ssp_monthlyPaidIncomeDesc;
	}


	public String getSsp_startDate2() {
		return ssp_startDate2;
	}

	public void setSsp_startDate2(String ssp_startDate2) {
		this.ssp_startDate2 = ssp_startDate2;
	}

	public String getSsp_endDate2() {
		return ssp_endDate2;
	}

	public void setSsp_endDate2(String ssp_endDate2) {
		this.ssp_endDate2 = ssp_endDate2;
	}

	public String getSsp_totalWorkHours2() {
		return ssp_totalWorkHours2;
	}

	public void setSsp_totalWorkHours2(String ssp_totalWorkHours2) {
		this.ssp_totalWorkHours2 = ssp_totalWorkHours2;
	}

	public String getSsp_totalWorkDays2() {
		return ssp_totalWorkDays2;
	}

	public void setSsp_totalWorkDays2(String ssp_totalWorkDays2) {
		this.ssp_totalWorkDays2 = ssp_totalWorkDays2;
	}

	public String getSsp_baseSalaryHrs2() {
		return ssp_baseSalaryHrs2;
	}

	public void setSsp_baseSalaryHrs2(String ssp_baseSalaryHrs2) {
		this.ssp_baseSalaryHrs2 = ssp_baseSalaryHrs2;
	}

	public String getSsp_dailyMealSubsidy2() {
		return ssp_dailyMealSubsidy2;
	}

	public void setSsp_dailyMealSubsidy2(String ssp_dailyMealSubsidy2) {
		this.ssp_dailyMealSubsidy2 = ssp_dailyMealSubsidy2;
	}

	public String getSsp_monthlyTransAllowance2() {
		return ssp_monthlyTransAllowance2;
	}

	public void setSsp_monthlyTransAllowance2(String ssp_monthlyTransAllowance2) {
		this.ssp_monthlyTransAllowance2 = ssp_monthlyTransAllowance2;
	}

	public String getSsp_probationBaseRate2() {
		return ssp_probationBaseRate2;
	}

	public void setSsp_probationBaseRate2(String ssp_probationBaseRate2) {
		this.ssp_probationBaseRate2 = ssp_probationBaseRate2;
	}

	public String getSsp_minimumWage2() {
		return ssp_minimumWage2;
	}

	public void setSsp_minimumWage2(String ssp_minimumWage2) {
		this.ssp_minimumWage2 = ssp_minimumWage2;
	}

	public String getSsp_incomtaxThreshold2() {
		return ssp_incomtaxThreshold2;
	}

	public void setSsp_incomtaxThreshold2(String ssp_incomtaxThreshold2) {
		this.ssp_incomtaxThreshold2 = ssp_incomtaxThreshold2;
	}

	@Override
	public String execute() throws Exception{
		
//		// System.out.println("ssp_startDate2: " + ssp_startDate2);
//		// System.out.println("ssp_dailyMealSubsidy2: " + ssp_dailyMealSubsidy2.trim());
//		// System.out.println("ssp_dailyMealSubsidy2.length(): " + ssp_dailyMealSubsidy2.trim().length());
		
		if(operationFlag_tossp.equals("addNewIncomTax")) {
			// Add a new IncomeTax
			// System.out.println("addNewIncomTax......");
			
			// System.out.println("ssp_monthlyPaidIncomeRate: " + ssp_monthlyPaidIncomeRate);
			// System.out.println("ssp_monthlyPaidIncomeMoney: " + ssp_monthlyPaidIncomeMoney);
			// System.out.println("ssp_monthlyPaidIncomeDesc: " + ssp_monthlyPaidIncomeDesc);
			
			Baseincomtax bi = new Baseincomtax();
			
			bi.setIncomtaxValue(Double.parseDouble(ssp_monthlyPaidIncomeMoney.trim()));
			bi.setIncomtaxRate(Double.parseDouble(ssp_monthlyPaidIncomeRate.trim()));
			bi.setIncomtaxDesc(ssp_monthlyPaidIncomeDesc.trim());
			
			// System.out.println("saving Baseincomtax.....");
			
			baseincomtaxDAO.save(bi);
			
			operationFlag_tossp = null;
			return SUCCESS;
		}
		else if (operationFlag_tossp.equals("updateBaseSalaryProperties")) {
			//Update Base Salary Setting propreties
		// System.out.println("saving BaseSalaryProperties......");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Basesalaryproperties bsp = new Basesalaryproperties();
		bsp.setStartDate(sdf.parse(ssp_startDate2.trim()));
		bsp.setEndDate(sdf.parse(ssp_endDate2.trim()));
		bsp.setTotalWorkHours(Double.parseDouble(ssp_totalWorkHours2.trim()));
		bsp.setTotalWorkDays(Double.parseDouble(ssp_totalWorkDays2.trim()));
		bsp.setBaseSalaryHrs(Double.parseDouble(ssp_baseSalaryHrs2.trim()));
		bsp.setDailyMealSubsidy(Double.parseDouble(ssp_dailyMealSubsidy2.trim()));
		bsp.setMonthlyTransAllowance(Double.parseDouble(ssp_monthlyTransAllowance2.trim()));
		bsp.setProbationBaseRate(Double.parseDouble(ssp_probationBaseRate2.trim()));
		bsp.setMinimumWage(Double.parseDouble(ssp_minimumWage2.trim()));
		bsp.setIncomtaxThreshold(Double.parseDouble(ssp_incomtaxThreshold2.trim()));
		
		Date date = new Date();
		Timestamp t = new Timestamp(date.getTime()); 
		bsp.setCreateDate(t);
		
		basesalarypropertiesDAO.save(bsp);
		operationFlag_tossp = null;
		// TODO Auto-generated method stub
		return SUCCESS;
		
		} else if (operationFlag_tossp.equals("editIncomTax")) {
			// Delete a Income by id
			Integer editIncomTaxId = Integer.parseInt(ssp_editIncomTax_Id.trim());
			Baseincomtax bi = baseincomtaxDAO.findById(editIncomTaxId);
			bi.setIncomtaxValue(Double.parseDouble(ssp_editIncomTaxMoney.trim()));
			bi.setIncomtaxRate(Double.parseDouble(ssp_editIncomTaxRate.trim()));
			bi.setIncomtaxDesc(ssp_editIncomTaxDesc.trim());
			baseincomtaxDAO.saveOrUpdate(bi);
			return SUCCESS;
		} else if (operationFlag_tossp.equals("deleteIncomTax")) {
			// Delete a Income by id
//			baseincomtaxDAO
			if(ssp_deleteIncomTax_Id.trim() == "") {
				return ERROR;
			}
			baseincomtaxDAO.deleteById(Integer.parseInt(ssp_deleteIncomTax_Id.trim())); 
			
			return SUCCESS;
		}
		
		return ERROR;
	}

}
