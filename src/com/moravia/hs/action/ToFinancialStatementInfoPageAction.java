package com.moravia.hs.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;

@Controller("toFinancialStatementInfoPageAction")
public class ToFinancialStatementInfoPageAction extends BaseAction{
	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	
	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;
	
	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<String> fsip_loginviewList = loginviewDAO.findAllLoginId(); 
		Basesalaryproperties bsp = basesalarypropertiesDAO.findLastCreated();
		
		String piedata = "";	//pie data
		String bardata = "";	//bar data
		String ticks = "";  //bar data department name
		
		session.put("fsip_loginviewList", fsip_loginviewList);
		session.put("fsip_startDate", sdf.format(bsp.getStartDate()));
		session.put("fsip_endDate", sdf.format(bsp.getEndDate()));
		
		
		List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list =null;
		fsdoc_list = payrollrecordDAO.findFinancialStatementFilterByDepartOrCostCenter2("department_name", sdf.format(bsp.getStartDate()), sdf.format(bsp.getEndDate()));
		session.put("fsdoc_list", fsdoc_list);
		
		int index = fsdoc_list.size();
		for (int i = 0; i < index; i++) {
			piedata += "{label: '" + fsdoc_list.get(i).getSection_name() + "', data: " + fsdoc_list.get(i).getTotal() + " }";
			bardata += "{data:[[" + i + "," + fsdoc_list.get(i).getTotal() + "]]}";
			ticks += "[" + i + ",'" + fsdoc_list.get(i).getSection_name() + "']";
			if(i < index -1) {
				piedata += ",";
				bardata += ",";
				ticks += ",";
			}
		}
		
		piedata = "[" + piedata + "];";
		bardata = "[" + bardata + "];";
		ticks = "[" + ticks + "]"; 
		session.put("fsip_piedata", piedata);
		session.put("fsip_bardata", bardata);
		session.put("fsip_ticks", ticks);
		
		return SUCCESS;
	}
	
	
	

}
