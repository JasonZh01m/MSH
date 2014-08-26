package com.moravia.hs.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BaseincomtaxDAO;
import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.BasesocialinsuranceDAO;
import com.moravia.hs.base.entity.Baseincomtax;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Basesocialinsurance;
import com.moravia.hs.base.entity.other.Login;

@Controller("salarySettingAction")
public class SalarySettingAction extends BaseAction{

	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;
	@Resource(name = "basesocialinsuranceDAO")
	private BasesocialinsuranceDAO basesocialinsuranceDAO;
	@Resource(name = "baseincomtaxDAO")
	private BaseincomtaxDAO baseincomtaxDAO;
	
	@Override
	public String execute() {
		//get Session
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		if(login.getEmp().getRole().getSysRoleId() > 3) {
			System.out.println("权限控制管理。。。");
			session.clear();
			session.put("globalError", "You have no premission!");
			return ERROR;
		}
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Basesalaryproperties bsp = basesalarypropertiesDAO.findLastCreated();
		
		//基本基数
		session.put("ssp_startDate", sdf.format(bsp.getStartDate()));
		session.put("ssp_endDate", sdf.format(bsp.getEndDate()));
		session.put("ssp_bsp", bsp);
		
		//社保缴费税率
		List<Basesocialinsurance> bis = basesocialinsuranceDAO.findAll();
		for (Basesocialinsurance bi : bis) {
			//养老保险(个人)
			if(bi.getBsiName().equals("Pension_Personal")) {
				session.put("ssp_pensionPersonal", bi);
			}
			//养老保险(公司)
			if(bi.getBsiName().equals("Pension_Company")) {
				session.put("ssp_pensionCompany", bi);
			}
			//医疗保险(个人)
			if(bi.getBsiName().equals("Medical_Personal")) {
				session.put("ssp_medicalPersonal", bi);
			}
			//医疗保险(公司)
			if(bi.getBsiName().equals("Medical_Company")) {
				session.put("ssp_medicalCompany", bi);
			}
			//公积金(个人)
			if(bi.getBsiName().equals("Accum_Fund_Personal")) {
				session.put("ssp_accumFundPersonal", bi);
			}
			//公积金(公司)
			if(bi.getBsiName().equals("Accum_Fund_Company")) {
				session.put("ssp_accumFundCompany", bi);
			}
			//失业保险(个人)
			if(bi.getBsiName().equals("Unemp_Insu_Personal")) {
				session.put("ssp_unempInsuPersonal", bi);
			}
			//失业保险(公司)
			if(bi.getBsiName().equals("Unemp_Insu_Company")) {
				session.put("ssp_unempInsuCompany", bi);
			}
			//工伤保险(个人)
			if(bi.getBsiName().equals("OccupInjure_Personal")) {
				session.put("ssp_occupInjurePersonal", bi);
			}
			//工伤保险(公司)
			if(bi.getBsiName().equals("OccupInjure_Company")) {
				session.put("ssp_occupInjureCompany", bi);
			}
			//生育保险(个人)
			if(bi.getBsiName().equals("Maternity_Personal")) {
				session.put("ssp_maternityPersonal", bi);
			}
			//生育保险(公司)
			if(bi.getBsiName().equals("Maternity_Company")) {
				session.put("ssp_maternityCompany", bi);
			}
		}
		
		//个税税率
		List<Baseincomtax> bts = baseincomtaxDAO.findAll();  
		session.put("ssp_incomTaxList", bts);
		
		return SUCCESS;
	}

	
	
	
	
}
