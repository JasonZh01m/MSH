package com.moravia.hs.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BasesocialinsuranceDAO;
import com.moravia.hs.base.entity.Basesocialinsurance;

@Controller("saveSocialInsurInfoAction")
public class SaveSocialInsurInfoAction extends BaseAction {

	@Resource(name = "basesocialinsuranceDAO")
	private BasesocialinsuranceDAO basesocialinsuranceDAO;

	private String ssp_pensionPersonal_Rate2;
	private String ssp_pensionPersonal_Additional2;
	private String ssp_pensionCompany_Rate2;
	private String ssp_pensionCompany_Additional2;
	private String ssp_medicalPersonal_Rate2;
	private String ssp_medicalPersonal_Additional2;
	private String ssp_medicalCompany_Rate2;
	private String ssp_medicalCompany_Additional2;
	private String ssp_accumFundPersonal_Rate2;
	private String ssp_accumFundPersonal_Additional2;
	private String ssp_accumFundCompany_Rate2;
	private String ssp_accumFundCompany_Additional2;
	private String ssp_unempInsuPersonal_Rate2;
	private String ssp_unempInsuPersonal_Additional2;
	private String ssp_unempInsuCompany_Rate2;
	private String ssp_unempInsuCompany_Additional2;
	private String ssp_occupInjurePersonal_Rate2;
	private String ssp_occupInjurePersonal_Additional2;
	private String ssp_occupInjureCompany_Rate2;
	private String ssp_occupInjureCompany_Additional2;
	private String ssp_maternityPersonal_Rate2;
	private String ssp_maternityPersonal_Additional2;
	private String ssp_maternityCompany_Rate2;
	private String ssp_maternityCompany_Additional2;

	public void setBasesocialinsuranceDAO(
			BasesocialinsuranceDAO basesocialinsuranceDAO) {
		this.basesocialinsuranceDAO = basesocialinsuranceDAO;
	}

	public void setSsp_pensionPersonal_Rate2(String ssp_pensionPersonal_Rate2) {
		this.ssp_pensionPersonal_Rate2 = ssp_pensionPersonal_Rate2;
	}

	public void setSsp_pensionPersonal_Additional2(
			String ssp_pensionPersonal_Additional2) {
		this.ssp_pensionPersonal_Additional2 = ssp_pensionPersonal_Additional2;
	}

	public void setSsp_pensionCompany_Rate2(String ssp_pensionCompany_Rate2) {
		this.ssp_pensionCompany_Rate2 = ssp_pensionCompany_Rate2;
	}

	public void setSsp_pensionCompany_Additional2(
			String ssp_pensionCompany_Additional2) {
		this.ssp_pensionCompany_Additional2 = ssp_pensionCompany_Additional2;
	}

	public void setSsp_medicalPersonal_Rate2(String ssp_medicalPersonal_Rate2) {
		this.ssp_medicalPersonal_Rate2 = ssp_medicalPersonal_Rate2;
	}

	public void setSsp_medicalPersonal_Additional2(
			String ssp_medicalPersonal_Additional2) {
		this.ssp_medicalPersonal_Additional2 = ssp_medicalPersonal_Additional2;
	}

	public void setSsp_medicalCompany_Rate2(String ssp_medicalCompany_Rate2) {
		this.ssp_medicalCompany_Rate2 = ssp_medicalCompany_Rate2;
	}

	public void setSsp_medicalCompany_Additional2(
			String ssp_medicalCompany_Additional2) {
		this.ssp_medicalCompany_Additional2 = ssp_medicalCompany_Additional2;
	}

	public void setSsp_accumFundPersonal_Rate2(
			String ssp_accumFundPersonal_Rate2) {
		this.ssp_accumFundPersonal_Rate2 = ssp_accumFundPersonal_Rate2;
	}

	public void setSsp_accumFundPersonal_Additional2(
			String ssp_accumFundPersonal_Additional2) {
		this.ssp_accumFundPersonal_Additional2 = ssp_accumFundPersonal_Additional2;
	}

	public void setSsp_accumFundCompany_Rate2(String ssp_accumFundCompany_Rate2) {
		this.ssp_accumFundCompany_Rate2 = ssp_accumFundCompany_Rate2;
	}

	public void setSsp_accumFundCompany_Additional2(
			String ssp_accumFundCompany_Additional2) {
		this.ssp_accumFundCompany_Additional2 = ssp_accumFundCompany_Additional2;
	}

	public void setSsp_unempInsuPersonal_Rate2(
			String ssp_unempInsuPersonal_Rate2) {
		this.ssp_unempInsuPersonal_Rate2 = ssp_unempInsuPersonal_Rate2;
	}

	public void setSsp_unempInsuPersonal_Additional2(
			String ssp_unempInsuPersonal_Additional2) {
		this.ssp_unempInsuPersonal_Additional2 = ssp_unempInsuPersonal_Additional2;
	}

	public void setSsp_unempInsuCompany_Rate2(String ssp_unempInsuCompany_Rate2) {
		this.ssp_unempInsuCompany_Rate2 = ssp_unempInsuCompany_Rate2;
	}

	public void setSsp_unempInsuCompany_Additional2(
			String ssp_unempInsuCompany_Additional2) {
		this.ssp_unempInsuCompany_Additional2 = ssp_unempInsuCompany_Additional2;
	}

	public void setSsp_occupInjurePersonal_Rate2(
			String ssp_occupInjurePersonal_Rate2) {
		this.ssp_occupInjurePersonal_Rate2 = ssp_occupInjurePersonal_Rate2;
	}

	public void setSsp_occupInjurePersonal_Additional2(
			String ssp_occupInjurePersonal_Additional2) {
		this.ssp_occupInjurePersonal_Additional2 = ssp_occupInjurePersonal_Additional2;
	}

	public void setSsp_occupInjureCompany_Rate2(
			String ssp_occupInjureCompany_Rate2) {
		this.ssp_occupInjureCompany_Rate2 = ssp_occupInjureCompany_Rate2;
	}

	public void setSsp_occupInjureCompany_Additional2(
			String ssp_occupInjureCompany_Additional2) {
		this.ssp_occupInjureCompany_Additional2 = ssp_occupInjureCompany_Additional2;
	}

	public void setSsp_maternityPersonal_Rate2(
			String ssp_maternityPersonal_Rate2) {
		this.ssp_maternityPersonal_Rate2 = ssp_maternityPersonal_Rate2;
	}

	public void setSsp_maternityPersonal_Additional2(
			String ssp_maternityPersonal_Additional2) {
		this.ssp_maternityPersonal_Additional2 = ssp_maternityPersonal_Additional2;
	}

	public void setSsp_maternityCompany_Rate2(String ssp_maternityCompany_Rate2) {
		this.ssp_maternityCompany_Rate2 = ssp_maternityCompany_Rate2;
	}

	public void setSsp_maternityCompany_Additional2(
			String ssp_maternityCompany_Additional2) {
		this.ssp_maternityCompany_Additional2 = ssp_maternityCompany_Additional2;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("ssp_pensionPersonal_Rate2: " + ssp_pensionPersonal_Rate2.trim());
		// System.out.println("ssp_pensionPersonal_Additional2: " + (Double.parseDouble(ssp_pensionPersonal_Additional2.trim()) + 6));
		
		List<Double> rateList = new ArrayList<Double>();
		List<Double> additionalList = new ArrayList<Double>();
		
		rateList.add(Double.parseDouble(ssp_pensionPersonal_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_pensionCompany_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_medicalPersonal_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_medicalCompany_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_accumFundPersonal_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_accumFundCompany_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_unempInsuPersonal_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_unempInsuCompany_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_occupInjurePersonal_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_occupInjureCompany_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_maternityPersonal_Rate2.trim()));
		rateList.add(Double.parseDouble(ssp_maternityCompany_Rate2.trim()));

		additionalList.add(Double.parseDouble(ssp_pensionPersonal_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_pensionCompany_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_medicalPersonal_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_medicalCompany_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_accumFundPersonal_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_accumFundCompany_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_unempInsuPersonal_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_unempInsuCompany_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_occupInjurePersonal_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_occupInjureCompany_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_maternityPersonal_Additional2.trim()));
		additionalList.add(Double.parseDouble(ssp_maternityCompany_Additional2.trim()));
		
		List<Basesocialinsurance> bsps = basesocialinsuranceDAO.findAll();
		for(int i = 0; i < bsps.size(); i++) {
			bsps.get(i).setBsiRate(rateList.get(i));
			bsps.get(i).setBsiAdditional(additionalList.get(i));
		}
		
		for (Basesocialinsurance bsp : bsps) {
			basesocialinsuranceDAO.saveOrUpdate(bsp);
		}
		
		// System.out.println("Save or Update success...");
		
		return super.execute();
		
		
		
	}

}
