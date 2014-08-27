package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.AbsenceinfoviewDAO;
import com.moravia.hs.base.dao.OvertimeinfoviewDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.other.AbsenceOvertimeTrackEntity;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.base.entity.view.Absenceinfoview;
import com.moravia.hs.base.entity.view.Overtimeinfoview;

@Controller("absenceOvertimeTrackAction")
public class AbsenceOvertimeTrackAction extends BaseAction {

	@Autowired
	private OvertimeinfoviewDAO overtimeinfoviewDAO;

	@Autowired
	private AbsenceinfoviewDAO absenceinfoviewDAO;
	
	@Autowired
	private RequeststateDAO requeststateDAO;

	
	private AbsenceOvertimeTrackEntity aotentity;

	private AbsenceOvertimeTrackEntity myaotentity;
	
	
	public AbsenceOvertimeTrackEntity getMyaotentity() {
		return myaotentity;
	}

	public void setMyaotentity(AbsenceOvertimeTrackEntity myaotentity) {
		this.myaotentity = myaotentity;
	}

	public AbsenceOvertimeTrackEntity getAotentity() {
		return aotentity;
	}

	public void setAotentity(AbsenceOvertimeTrackEntity aotentity) {
		this.aotentity = aotentity;
	}

	
	public String loadAbsenceOvertimeTrack() {
		Map<String, Object> session = getSession();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		aotentity = new AbsenceOvertimeTrackEntity();
		
		List<Requeststate> rss = requeststateDAO.findAll();
		List<String> states = new ArrayList<String>();
		states.add("All");
		for (Requeststate rs : rss) {
			states.add(rs.getStateName());
		}
		aotentity.setStates(states);
		session.put("aotentity", aotentity);
		return SUCCESS;
	}
	
	public String loadMyAbsenceOvertimeTrack() {
		Map<String, Object> session = getSession();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		myaotentity = new AbsenceOvertimeTrackEntity();
		
		List<Requeststate> rss = requeststateDAO.findAll();
		List<String> states = new ArrayList<String>();
		states.add("All");
		for (Requeststate rs : rss) {
			states.add(rs.getStateName());
		}
		myaotentity.setStates(states);
		session.put("myaotentity", myaotentity);
		return SUCCESS;
	}
	
	/**
	 * Higher Authorization
	 * @return
	 * @throws ParseException
	 */
	public String getAbsenceOvertimeInfoByTime() throws ParseException {
		Map<String, Object> session = getSession();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startdate = sdf.parse(aotentity.getStartDate().trim());
		Date enddate = sdf.parse(aotentity.getEndDate().trim());
		
		Calendar endcal = Calendar.getInstance();
		endcal.setTime(enddate);
		endcal.add(Calendar.DAY_OF_MONTH, 1);
		
		enddate = endcal.getTime();
		
		
		Timestamp startTime = new Timestamp(startdate.getTime());
		Timestamp endTime = new Timestamp(enddate.getTime());
		
		List<Overtimeinfoview> overtimeInfos = null;
		List<Absenceinfoview> absenceInfos = null;
		
		if(aotentity.getState() != null && !aotentity.getState().trim().equals("All")) {
			overtimeInfos = overtimeinfoviewDAO.findByEmp(aotentity.getLoginId().trim(), startTime, endTime, aotentity.getState().trim());
			absenceInfos = absenceinfoviewDAO.findByEmp(aotentity.getLoginId().trim(), startTime, endTime, aotentity.getState().trim());
		} else {
			overtimeInfos = overtimeinfoviewDAO.findByEmpAllState(aotentity.getLoginId().trim(), startTime, endTime);
			absenceInfos = absenceinfoviewDAO.findByEmpAllState(aotentity.getLoginId().trim(), startTime, endTime);
		}
		
		AbsenceOvertimeTrackEntity aotentiy_new = new AbsenceOvertimeTrackEntity();
		
		aotentiy_new.setState(aotentity.getState());
		aotentiy_new.setStartDate(aotentity.getStartDate());
		aotentiy_new.setEndDate(aotentity.getEndDate());
		aotentiy_new.setLoginId(aotentity.getLoginId());
		
		List<Requeststate> rss = requeststateDAO.findAll();
		List<String> states = new ArrayList<String>();
		states.add("All");
		for (Requeststate rs : rss) {
			states.add(rs.getStateName());
		}
		aotentiy_new.setStates(states);
		
		session.put("aotentity", aotentiy_new);
		session.put("overtimeInfos", overtimeInfos);
		session.put("absenceInfos", absenceInfos);
		
		return SUCCESS;
	}
	
	
	/**
	 * Get My Info
	 * @return
	 * @throws ParseException
	 */
	public String getMyAbsenceOvertimeInfoByTime() throws ParseException {
Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startdate = sdf.parse(myaotentity.getStartDate().trim());
		Date enddate = sdf.parse(myaotentity.getEndDate().trim());
		
		Calendar endcal = Calendar.getInstance();
		endcal.setTime(enddate);
		endcal.add(Calendar.DAY_OF_MONTH, 1);
		
		enddate = endcal.getTime();
		
		
		Timestamp startTime = new Timestamp(startdate.getTime());
		Timestamp endTime = new Timestamp(enddate.getTime());
		
		List<Overtimeinfoview> overtimeInfos = null;
		List<Absenceinfoview> absenceInfos = null;
		
		if(myaotentity.getState() != null && !myaotentity.getState().trim().equals("All")) {
			overtimeInfos = overtimeinfoviewDAO.findByEmp(login.getEmp().getEmpLoginId(), startTime, endTime, myaotentity.getState().trim());
			absenceInfos = absenceinfoviewDAO.findByEmp(login.getEmp().getEmpLoginId(), startTime, endTime, myaotentity.getState().trim());
		} else {
			overtimeInfos = overtimeinfoviewDAO.findByEmpAllState(login.getEmp().getEmpLoginId(), startTime, endTime);
			absenceInfos = absenceinfoviewDAO.findByEmpAllState(login.getEmp().getEmpLoginId(), startTime, endTime);
		}
		
		AbsenceOvertimeTrackEntity aotentiy_new = new AbsenceOvertimeTrackEntity();
		
		aotentiy_new.setState(myaotentity.getState());
		aotentiy_new.setStartDate(myaotentity.getStartDate());
		aotentiy_new.setEndDate(myaotentity.getEndDate());
		aotentiy_new.setLoginId(myaotentity.getLoginId());
		
		List<Requeststate> rss = requeststateDAO.findAll();
		List<String> states = new ArrayList<String>();
		states.add("All");
		for (Requeststate rs : rss) {
			states.add(rs.getStateName());
		}
		aotentiy_new.setStates(states);
		
		session.put("myaotentity", aotentiy_new);
		session.put("myovertimeInfos", overtimeInfos);
		session.put("myabsenceInfos", absenceInfos);
		
		return SUCCESS;
	}

}
