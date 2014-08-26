package com.moravia.hs.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;
import com.moravia.hs.base.entity.other.FinancialStatement_SumSeason;
import com.moravia.hs.base.entity.other.MasterStatusList;

/**
 * 
 * @author jasonzh This action's purpose is to get 'startDate', 'endDate' and
 *         'filter by' from FinancialStatement.jsp page and filter financial
 *         statement info with 'payrollrecordDAO' and then, return to
 *         FinancialStatement.jsp to display.
 */
@Controller("financialStatementAction")
public class FinancialStatementAction extends BaseAction {
	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;

	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	
	private String fsip_startDate;
	private String fsip_endDate;
	private String fsip_filter;
	private String fsip_customChooseEmp;

	public String getFsip_customChooseEmp() {
		return fsip_customChooseEmp;
	}

	public void setFsip_customChooseEmp(String fsip_customChooseEmp) {
		this.fsip_customChooseEmp = fsip_customChooseEmp;
	}

	public void setPayrollrecordDAO(PayrollrecordDAO payrollrecordDAO) {
		this.payrollrecordDAO = payrollrecordDAO;
	}

	public void setFsip_startDate(String fsip_startDate) {
		this.fsip_startDate = fsip_startDate;
	}

	public void setFsip_endDate(String fsip_endDate) {
		this.fsip_endDate = fsip_endDate;
	}

	public void setFsip_filter(String fsip_filter) {
		this.fsip_filter = fsip_filter;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("P");
		// System.out.println("fsip_customChooseEmp: " + fsip_customChooseEmp);
//		// System.out.println("forTest: " + forTest);
//		for (Integer i : masterStatusLists) {
//	        // System.out.println(i);
//	    }
//		// System.out.println(masterStatusLists.size());
		
		// System.out.println("fsip_startDate: " + fsip_startDate);
		// System.out.println("fsip_endDate.length(): " + fsip_endDate.length());
		Map<String, Object> session = getSession();
		List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list =null;
		
		List<String> fsip_loginviewList = loginviewDAO.findAllLoginId(); 
		session.put("fsip_loginviewList", fsip_loginviewList);
		
		String piedata = "";	//pie data
		String bardata = "";	//bar data
		String ticks = "";  //bar data department name
		
		if (fsip_filter.trim().equals("1")) {
			if (fsip_startDate.trim() != "" && fsip_endDate.trim() != "") {
				fsdoc_list = payrollrecordDAO.findFinancialStatementFilterByDepartOrCostCenter2("department_name", fsip_startDate.trim(), fsip_endDate.trim());
				// System.out.println("fsdoc_list.size(): " + fsdoc_list.size());
				
				session.put("fsdoc_list", fsdoc_list);
				session.put("fsip_startDate", fsip_startDate.trim());
				session.put("fsip_endDate", fsip_endDate.trim());
				session.put("fsip_filter", fsip_filter);
				
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
				
				/*// System.out.println("piedata: " + piedata);
				// System.out.println("bardata: " + bardata);
				// System.out.println("ticks:" + ticks);*/
				return SUCCESS;
			}else {
				// System.out.println("fsip_startDate or fsip_endDate is empty.");
				return ERROR;
			}
		} else if (fsip_filter.trim().equals("2")) {
			if (fsip_startDate.trim() != "" && fsip_endDate.trim() != "") {
				fsdoc_list = payrollrecordDAO.findFinancialStatementFilterByDepartOrCostCenter2("costcenter_name", fsip_startDate.trim(), fsip_endDate.trim());
				// System.out.println("fsdoc_list.size(): " + fsdoc_list.size());
				
				session.put("fsdoc_list", fsdoc_list);
				session.put("fsip_startDate", fsip_startDate.trim());
				session.put("fsip_endDate", fsip_endDate.trim());
				session.put("fsip_filter", fsip_filter);
				
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
				
				/*// System.out.println("piedata: " + piedata);
				// System.out.println("bardata: " + bardata);
				// System.out.println("ticks:" + ticks);*/
				
				
				return SUCCESS;
			} else {
				// System.out.println("fsip_startDate or fsip_endDate is empty.");
				return ERROR;
			}
		} else if (fsip_filter.trim().equals("3")) {
			if (fsip_startDate.trim() != "" && fsip_endDate.trim() != "") {
				// System.out.println("fsip_customChooseEmp: " + fsip_customChooseEmp);
				
				String[] strs = fsip_customChooseEmp.trim().split(",");
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < strs.length; i++) {
					sb.append("'" + strs[i].trim() + "'");
					if(i < strs.length - 1) {
						sb.append(",");
					}
				}
				String loginIds = "(" + sb.toString() + ")";
				
				// System.out.println(loginIds);
				fsdoc_list = payrollrecordDAO.findFinancialStatementFilterByCustomized2(loginIds, fsip_startDate.trim(), fsip_endDate.trim());
				
				session.put("fsdoc_list", fsdoc_list);
				session.put("fsip_startDate", fsip_startDate.trim());
				session.put("fsip_endDate", fsip_endDate.trim());
				session.put("fsip_filter", fsip_filter);
				
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
				
				/*// System.out.println("piedata: " + piedata);
				// System.out.println("bardata: " + bardata);
				// System.out.println("ticks:" + ticks);*/
				
				return SUCCESS;
			} else {
				// System.out.println("fsip_startDate or fsip_endDate is empty.");
				return ERROR;
			}
		}
		else {
			// System.out.println("fsip_filter is not 'department'");
			return ERROR;
		}
	}

}
