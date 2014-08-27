package com.moravia.hs.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.EmpchangerecordDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.entity.other.HistoryTrack;
import com.moravia.hs.base.entity.other.HistoryTrackD;
import com.moravia.hs.base.entity.other.Login;

@Controller("toEmpHistoryInfoPage")
public class ToEmpHistoryInfoPage extends BaseAction {

	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;

	@Resource(name = "empchangerecordDAO")
	private EmpchangerecordDAO empchangerecordDAO;

	private String ehisip_empLoginId;

	public String getEhisip_empLoginId() {
		return ehisip_empLoginId;
	}

	public void setEhisip_empLoginId(String ehisip_empLoginId) {
		this.ehisip_empLoginId = ehisip_empLoginId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = getSession();
		if(ehisip_empLoginId == null) {
			ehisip_empLoginId = "";
//			return ERROR;
		}

		ehisip_empLoginId = ehisip_empLoginId.trim();
		List<String> ehisip_loginviewList = loginviewDAO.findAllLoginId();

		List<HistoryTrackD> ehisip_salaryHistoryList = empchangerecordDAO
				.getHistroryTrack_BaseSalary(ehisip_empLoginId);
		List<HistoryTrackD> ehisip_socialInsList = empchangerecordDAO
				.getHistroryTrack_SocialIns(ehisip_empLoginId);
		List<HistoryTrackD> ehisip_mboList = empchangerecordDAO
				.getHistroryTrack_MBO(ehisip_empLoginId);

		List<HistoryTrack> ehisip_positionTitleList = empchangerecordDAO
				.getHistroryTrack_PositionTitleName(ehisip_empLoginId);
		List<HistoryTrack> ehisip_departList = empchangerecordDAO
				.getHistroryTrack_DepartName(ehisip_empLoginId);
		List<HistoryTrack> ehisip_lineManagerList = empchangerecordDAO
				.getHistroryTrack_LineManager(ehisip_empLoginId);
		List<HistoryTrack> ehisip_costCenterList = empchangerecordDAO
				.getHistroryTrack_CostCenter(ehisip_empLoginId);
		List<HistoryTrack> ehisip_contractTypeList = empchangerecordDAO.getHistroryTrack_ContractType(ehisip_empLoginId);
		List<HistoryTrack> ehisip_empTypeList = empchangerecordDAO.getHistroryTrack_EmpType(ehisip_empLoginId);
		
		
		session.put("ehisip_empLoginId", ehisip_empLoginId.trim());
		session.put("ehisip_loginviewList", ehisip_loginviewList);
		session.put("ehisip_salaryHistoryList", ehisip_salaryHistoryList);
		session.put("ehisip_socialInsList", ehisip_socialInsList);
		session.put("ehisip_mboList", ehisip_mboList);
		session.put("ehisip_positionTitleList", ehisip_positionTitleList);
		session.put("ehisip_departList", ehisip_departList);
		session.put("ehisip_lineManagerList", ehisip_lineManagerList);
		session.put("ehisip_costCenterList", ehisip_costCenterList);
		session.put("ehisip_contractTypeList", ehisip_contractTypeList);
		session.put("ehisip_empTypeList", ehisip_empTypeList);

		/*
		 * var data = [{ label: "United States", data: [[1990, 0], [1993, 12.2]]
		 * }, { label: "Russia", data: [[1990, 0], [1993, 12.2]] }];
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String salary_data = "";
		String socialIns_data = "";
		// String mboRate_data = "";
		int count1 = ehisip_salaryHistoryList.size();
		int count2 = ehisip_socialInsList.size();
		// int count3 = ehisip_mboList.size();
		Date date1 = null;
		Date date2 = null;
		for (int i = 0; i < count1; i++) {
			// date1 = ehisip_salaryHistoryList.get(i).getValidateDate();
			// date1.setDate(date1.getDate() + 1);
			salary_data += "[new Date(\""
					+ sdf.format(ehisip_salaryHistoryList.get(i)
							.getValidateDate()) + "\"), "
					+ ehisip_salaryHistoryList.get(i).getValue() + "]";
			if (i < count1 - 1) {
				salary_data += ",";
			}
		}

		for (int i = 0; i < count2; i++) {
			// date2 = ehisip_socialInsList.get(i).getValidateDate();
			// date2.setDate(date1.getDate() + 1);
			socialIns_data += "[new Date(\""
					+ sdf.format(ehisip_socialInsList.get(i).getValidateDate())
					+ "\"), " + ehisip_socialInsList.get(i).getValue() + "]";
			if (i < count1 - 1) {
				socialIns_data += ",";
			}
		}

		// for(int i = 0; i < count3; i++) {
		// mboRate_data += "[new Date(\"" +
		// sdf.format(ehisip_mboList.get(i).getValidateDate()) + "\"), " +
		// ehisip_mboList.get(i).getValue() + "]";
		// if(i < count1 - 1) {
		// mboRate_data += ",";
		// }
		// }

		// [[new Date("2009/08/26"), 0], [new Date("2010/02/27"), 10], [new
		// Date("2010/06/28"), 3], [new Date("2011/09/29"), 1], [new
		// Date("2016/02/30"), 4] ];

		salary_data = "[" + salary_data + "]";
		socialIns_data = "[" + socialIns_data + "]";
		// mboRate_data = "[" + mboRate_data + "]";

		session.put("ehisip_salary_data", salary_data);
		session.put("ehisip_socialIns_data", socialIns_data);
		// session.put("ehisip_mbo_data", mboRate_data);

		return SUCCESS;

	}
	
	
	public String myEmpHistory() {
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		String emploginid = login.getEmp().getEmpLoginId();
		
		List<String> myhis_loginviewList = loginviewDAO.findAllLoginId();

		List<HistoryTrackD> myhis_salaryHistoryList = empchangerecordDAO
				.getHistroryTrack_BaseSalary(emploginid);
		List<HistoryTrackD> myhis_socialInsList = empchangerecordDAO
				.getHistroryTrack_SocialIns(emploginid);
		List<HistoryTrackD> myhis_mboList = empchangerecordDAO
				.getHistroryTrack_MBO(emploginid);

		List<HistoryTrack> myhis_positionTitleList = empchangerecordDAO
				.getHistroryTrack_PositionTitleName(emploginid);
		List<HistoryTrack> myhis_departList = empchangerecordDAO
				.getHistroryTrack_DepartName(emploginid);
		List<HistoryTrack> myhis_lineManagerList = empchangerecordDAO
				.getHistroryTrack_LineManager(emploginid);
		List<HistoryTrack> myhis_costCenterList = empchangerecordDAO
				.getHistroryTrack_CostCenter(emploginid);
		List<HistoryTrack> myhis_contractTypeList = empchangerecordDAO.getHistroryTrack_ContractType(emploginid);
		List<HistoryTrack> myhis_empTypeList = empchangerecordDAO.getHistroryTrack_EmpType(emploginid);
		
		session.put("myhis_loginviewList", myhis_loginviewList);
		session.put("myhis_salaryHistoryList", myhis_salaryHistoryList);
		session.put("myhis_socialInsList", myhis_socialInsList);
		session.put("myhis_mboList", myhis_mboList);
		session.put("myhis_positionTitleList", myhis_positionTitleList);
		session.put("myhis_departList", myhis_departList);
		session.put("myhis_lineManagerList", myhis_lineManagerList);
		session.put("myhis_costCenterList", myhis_costCenterList);
		session.put("myhis_contractTypeList", myhis_contractTypeList);
		session.put("myhis_empTypeList", myhis_empTypeList);

		/*
		 * var data = [{ label: "United States", data: [[1990, 0], [1993, 12.2]]
		 * }, { label: "Russia", data: [[1990, 0], [1993, 12.2]] }];
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String salary_data = "";
		String socialIns_data = "";
		// String mboRate_data = "";
		int count1 = myhis_salaryHistoryList.size();
		int count2 = myhis_socialInsList.size();
		// int count3 = myhis_mboList.size();
		Date date1 = null;
		Date date2 = null;
		for (int i = 0; i < count1; i++) {
			// date1 = myhis_salaryHistoryList.get(i).getValidateDate();
			// date1.setDate(date1.getDate() + 1);
			salary_data += "[new Date(\""
					+ sdf.format(myhis_salaryHistoryList.get(i)
							.getValidateDate()) + "\"), "
					+ myhis_salaryHistoryList.get(i).getValue() + "]";
			if (i < count1 - 1) {
				salary_data += ",";
			}
		}

		for (int i = 0; i < count2; i++) {
			// date2 = myhis_socialInsList.get(i).getValidateDate();
			// date2.setDate(date1.getDate() + 1);
			socialIns_data += "[new Date(\""
					+ sdf.format(myhis_socialInsList.get(i).getValidateDate())
					+ "\"), " + myhis_socialInsList.get(i).getValue() + "]";
			if (i < count1 - 1) {
				socialIns_data += ",";
			}
		}

		// for(int i = 0; i < count3; i++) {
		// mboRate_data += "[new Date(\"" +
		// sdf.format(myhis_mboList.get(i).getValidateDate()) + "\"), " +
		// myhis_mboList.get(i).getValue() + "]";
		// if(i < count1 - 1) {
		// mboRate_data += ",";
		// }
		// }

		// [[new Date("2009/08/26"), 0], [new Date("2010/02/27"), 10], [new
		// Date("2010/06/28"), 3], [new Date("2011/09/29"), 1], [new
		// Date("2016/02/30"), 4] ];

		salary_data = "[" + salary_data + "]";
		socialIns_data = "[" + socialIns_data + "]";
		// mboRate_data = "[" + mboRate_data + "]";

		session.put("myhis_salary_data", salary_data);
		session.put("myhis_socialIns_data", socialIns_data);
		// session.put("myhis_mbo_data", mboRate_data);

		return SUCCESS;
	}

}
