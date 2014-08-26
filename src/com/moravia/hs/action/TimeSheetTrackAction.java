package com.moravia.hs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Timesheet;

@Controller("timeSheetTrackAction")
public class TimeSheetTrackAction extends BaseAction {

	@Resource(name = "timesheetDAO")
	private TimesheetDAO timesheetDAO;

	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;

	private String operationFlag_tstp;
	private String tstp_empLoginId;
	private String tstp_startDate;
	private String tstp_endDate;

	public String getOperationFlag_tstp() {
		return operationFlag_tstp;
	}

	public void setOperationFlag_tstp(String operationFlag_tstp) {
		this.operationFlag_tstp = operationFlag_tstp;
	}

	public String getTstp_empLoginId() {
		return tstp_empLoginId;
	}

	public void setTstp_empLoginId(String tstp_empLoginId) {
		this.tstp_empLoginId = tstp_empLoginId;
	}

	public String getTstp_startDate() {
		return tstp_startDate;
	}

	public void setTstp_startDate(String tstp_startDate) {
		this.tstp_startDate = tstp_startDate;
	}

	public String getTstp_endDate() {
		return tstp_endDate;
	}

	public void setTstp_endDate(String tstp_endDate) {
		this.tstp_endDate = tstp_endDate;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = getSession();
		// List<String> tstp_loginviewList

		// System.out.println("tstp_empLoginId: " + tstp_empLoginId);
		// System.out.println("startDate: " + tstp_startDate);
		// System.out.println("endDate: " + tstp_endDate);

		List<Timesheet> tsList = null;
		if (session.get("tstp_loginviewList") == null) {
			// System.out.println("tstp_loginviewList is null...");
			session.put("tstp_loginviewList", loginviewDAO.findAllLoginId());
		}

		if (operationFlag_tstp.trim().equalsIgnoreCase("totimesheettrackpage")) {
			return SUCCESS;
		}

		if (operationFlag_tstp.trim().equalsIgnoreCase("tstp_filterOperate")) {
			tsList = timesheetDAO.findAllByEmpAndDate(tstp_empLoginId.trim(),
					tstp_startDate.trim(), tstp_endDate.trim());

			session.put("tstp_startDate", tstp_startDate.trim());
			session.put("tstp_endDate", tstp_endDate.trim());
			session.put("tstp_empLoginId", tstp_empLoginId.trim());
			session.put("tstp_tsList", tsList);
		}

		return SUCCESS;
	}

}
