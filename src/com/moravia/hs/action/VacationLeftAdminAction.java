package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.CompensatoryleaveinfoDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.VacationchangerecordDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Compensatoryleaveinfo;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Vacationchangerecord;
import com.moravia.hs.base.entity.Vacationtype;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.base.entity.other.PageBean;
import com.moravia.hs.base.entity.other.VacationLeftAdminEntity;

@Controller("vacationLeftAdminAction")
public class VacationLeftAdminAction extends BaseAction {

	@Autowired
	private EmpDAO empDAO;

	@Autowired
	private CompensatoryleaveinfoDAO compensatoryleaveinfoDAO;
	
	@Autowired
	private VacationchangerecordDAO vacationchangerecordDAO;
	
	@Autowired
	private VacationtypeDAO vacationtypeDAO;

	private VacationLeftAdminEntity vLeftAdminEntity;
	private VacationLeftAdminEntity myvacationEntity;
	private VacationLeftAdminEntity vacationLeftAdminEntity;
	private String request_pageno;
	
	private String vacationinfo_emploginid;
	
	
	public VacationLeftAdminEntity getMyvacationEntity() {
		return myvacationEntity;
	}

	public void setMyvacationEntity(VacationLeftAdminEntity myvacationEntity) {
		this.myvacationEntity = myvacationEntity;
	}

	public String getRequest_pageno() {
		return request_pageno;
	}

	public void setRequest_pageno(String request_pageno) {
		this.request_pageno = request_pageno;
	}

	public VacationLeftAdminEntity getVacationLeftAdminEntity() {
		return vacationLeftAdminEntity;
	}

	public void setVacationLeftAdminEntity(
			VacationLeftAdminEntity vacationLeftAdminEntity) {
		this.vacationLeftAdminEntity = vacationLeftAdminEntity;
	}


	
	
	public String getVacationinfo_emploginid() {
		return vacationinfo_emploginid;
	}

	public void setVacationinfo_emploginid(String vacationinfo_emploginid) {
		this.vacationinfo_emploginid = vacationinfo_emploginid;
	}

	public VacationLeftAdminEntity getvLeftAdminEntity() {
		return vLeftAdminEntity;
	}

	public void setvLeftAdminEntity(VacationLeftAdminEntity vLeftAdminEntity) {
		this.vLeftAdminEntity = vLeftAdminEntity;
	}
	
	/**
	 * Load Vacation Admin Page
	 * @return
	 */
	public String loadVacationAdminPage() {
		System.out.println("进入 loadVacationAdminPage() 方法");
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		Emp searchEmp = null;
		if(vacationinfo_emploginid != null && vacationinfo_emploginid != "") {
			searchEmp = empDAO.findByLoginName(vacationinfo_emploginid.trim());
		} else {
			System.out.println("vacationinfo_emploginid is null, choose login emp as vacationinfo_emploginid");
			searchEmp = login.getEmp();
		}
		List<Compensatoryleaveinfo> compens = compensatoryleaveinfoDAO.findByEmp(searchEmp);

		List<String[]> compenList = new ArrayList<String[]>();
		
		VacationLeftAdminEntity vlan = new VacationLeftAdminEntity();
		
		vlan.setEmploginid(searchEmp.getEmpLoginId());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		String[] compenArr;
		int count = 1;
		long diff;
		double diffDay = 0.0;
		for (Compensatoryleaveinfo cominfo : compens) {
			cal2.setTime(cominfo.getExpirationDate());
			diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
			
			diffDay = diff / (24 * 60 * 60 * 1000);
			
			compenArr = new String[6];
			compenArr[0] = count++ + "";
			compenArr[1] = cominfo.getCompensatoryLeaveLeft() + "";
			compenArr[2] = sdf.format(cominfo.getExpirationDate());
			compenArr[3] = sdf.format(cominfo.getCreateDate());
			compenArr[4] = cominfo.getCompensatoryLeaveDesc();
			if(cominfo.getExpirationDate().compareTo(date) < 0) {
				compenArr[5] = "danger";
			} else if (diffDay < 10){
				compenArr[5] = "warning";
			}
			compenList.add(compenArr);
		}
		
		vlan.setCompensatorys(compenList);
		
		int pageSize = login.getPageBean().getPageSize();
		int page = 0;
		PageBean vadminPB = vacationchangerecordDAO.findPageBeanByEmp(searchEmp.getEmpLoginId(), pageSize, page);
		List<Vacationchangerecord> vcs = vadminPB.getList();
		List<String[]> histories = new ArrayList<>();
		String[] historyArr;
		int count2 = 1;
		for (Vacationchangerecord vc : vcs) {
			String vacationName = vc.getVacationtype() != null ? vc.getVacationtype().getVacationTypeName() : "";
			if(vacationName.equals("Annual_Leave")) {
				vacationName = "Annual";
			} else if(vacationName.equals("Compensatory_Leave")) {
				vacationName = "Compen";
			} else {
				vacationName = "null";
			}
			
			historyArr = new String[7];
			historyArr[0] = count2++ + "";
			historyArr[1] = vc.getVacationAddOrMinus() != null && vc.getVacationAddOrMinus() == 1 ? "+" : "-";
			historyArr[2] = vc.getChangeHours() + "";
			historyArr[3] = vacationName;
			historyArr[4] = vc.getChangeBy();
			historyArr[5] = sdf.format(vc.getCreateDate());
			historyArr[6] = vc.getChangeReason();
			histories.add(historyArr);
		}
		vlan.setHistories(histories);
		
		System.out.println("#222#vadminPB.getTotalPage(): " + vadminPB.getTotalPage());
		
		vlan.setTotalpage(vadminPB.getTotalPage());
		
		vlan.setCompenTotalLeft(compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(searchEmp, sdf.format(date)));
		vlan.setAnnualTotalLeft(searchEmp.getAnnualLeaveLeft());
		
		session.put("vacationAdminObject", vlan);
		
		return SUCCESS;
	}
	
	/**
	 * This is Load My Vacation Left/Used Info page.
	 * @return
	 */
	public String loadMyVacationInfoPage() {
		System.out.println("进入 loadMyVacationInfoPage() 方法");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		List<Compensatoryleaveinfo> compens = compensatoryleaveinfoDAO.findByEmp(login.getEmp());

		List<String[]> compenList = new ArrayList<String[]>();
		
		VacationLeftAdminEntity vlan = new VacationLeftAdminEntity();
		vlan.setEmploginid(login.getEmp().getEmpLoginId());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		String[] compenArr;
		int count = 1;
		long diff;
		double diffDay = 0.0;
		for (Compensatoryleaveinfo cominfo : compens) {
			cal2.setTime(cominfo.getExpirationDate());
			diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
			
			diffDay = diff / (24 * 60 * 60 * 1000);
			
			compenArr = new String[6];
			compenArr[0] = count++ + "";
			compenArr[1] = cominfo.getCompensatoryLeaveLeft() + "";
			compenArr[2] = sdf.format(cominfo.getExpirationDate());
			compenArr[3] = sdf.format(cominfo.getCreateDate());
			compenArr[4] = cominfo.getCompensatoryLeaveDesc();
			if(cominfo.getExpirationDate().compareTo(date) < 0) {
				compenArr[5] = "danger";
			} else if (diffDay < 10){
				compenArr[5] = "warning";
			}
			compenList.add(compenArr);
		}
		
		vlan.setCompensatorys(compenList);
		int pageSize = login.getPageBean().getPageSize();
		int page = 0;
		PageBean vadminPB = vacationchangerecordDAO.findPageBeanByEmp(login.getEmp().getEmpLoginId(), pageSize, page);
		List<Vacationchangerecord> vcs = vadminPB.getList();
		List<String[]> histories = new ArrayList<>();
		String[] historyArr;
		int count2 = 1;
		for (Vacationchangerecord vc : vcs) {
			String vacationName = vc.getVacationtype() != null ? vc.getVacationtype().getVacationTypeName() : "";
			if(vacationName.equals("Annual_Leave")) {
				vacationName = "Annual";
			} else if(vacationName.equals("Compensatory_Leave")) {
				vacationName = "Compen";
			} else {
				vacationName = "null";
			}
			
			historyArr = new String[7];
			historyArr[0] = count2++ + "";
			historyArr[1] = vc.getVacationAddOrMinus() != null && vc.getVacationAddOrMinus() == 1 ? "+" : "-";
			historyArr[2] = vc.getChangeHours() + "";
			historyArr[3] = vacationName;
			historyArr[4] = vc.getChangeBy();
			historyArr[5] = sdf.format(vc.getCreateDate());
			historyArr[6] = vc.getChangeReason();
			histories.add(historyArr);
		}
		vlan.setHistories(histories);
		
		vlan.setTotalpage(vadminPB.getTotalPage());
		
		vlan.setCompenTotalLeft(compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(login.getEmp(), sdf.format(date)));
		vlan.setAnnualTotalLeft(login.getEmp().getAnnualLeaveLeft());
		session.put("myvacationinfo", vlan);
		
		return SUCCESS;
	}
	
	/**
	 * Add a compensatory record
	 * @return
	 * @throws ParseException
	 */
	public String addVacation() throws ParseException {
		System.out.println("#####进入：addVacation() 方法#########");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
				
		if(login == null) {
			session.put("globalError", "请先登录");
			return ERROR;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		

		System.out.println("vLeftAdminGet.getOperationFlag(): " + vacationLeftAdminEntity.getOperationFlag());
		Emp emp = empDAO.findByLoginName(vacationLeftAdminEntity.getEmploginid().trim());
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		// 添加vacation change record
		Vacationchangerecord vcr = new Vacationchangerecord();
		vcr.setEmp(emp);
		vcr.setCreateDate(ts);
		vcr.setChangeBy(login.getEmp().getEmpLoginId()); 	//　change By person
		vcr.setVacationAddOrMinus(1);
		
		if(vacationLeftAdminEntity.getOperationFlag().trim().equals("AddCompensatory")) {
			System.out.println("vLeftAdminGet.getOperationFlag() is ‘AddCompensatory’");
			// 添加调休假记录
			Compensatoryleaveinfo com = new Compensatoryleaveinfo();
			com.setEmp(emp);
			com.setExpirationDate(sdf.parse(vacationLeftAdminEntity.getCompenExpireDate()));
			com.setCompensatoryLeaveLeft(vacationLeftAdminEntity.getCompenAdd());
			com.setCompensatoryLeaveDesc(vacationLeftAdminEntity.getCompenDesc());
			com.setCreateDate(ts);
			compensatoryleaveinfoDAO.save(com);
			
			Vacationtype compenvtype = vacationtypeDAO.findById(5);	// 5 表示调休假
			vcr.setVacationtype(compenvtype);
			vcr.setChangeReason(login.getEmp().getEmpLoginId() + " Added a compensatory leave, added hours: " + vacationLeftAdminEntity.getCompenAdd() + ", expired date: " + vacationLeftAdminEntity.getCompenExpireDate());
			vcr.setChangeHours(vacationLeftAdminEntity.getCompenAdd());	// 变更的调休假小时数
			vacationchangerecordDAO.save(vcr);
			
		} else if (vacationLeftAdminEntity.getOperationFlag().trim().equals("AddAnnual")) {
			System.out.println("vLeftAdminGet.getOperationFlag() is ‘AddAnnual’");
			// 添加年假
			Double annualLeft = emp.getAnnualLeaveLeft();
			annualLeft += vacationLeftAdminEntity.getAnnualAdd();
			emp.setAnnualLeaveLeft(annualLeft);
			empDAO.saveOrUpdate(emp);
			
			// 添加vacation change record
			Vacationtype compenvtype = vacationtypeDAO.findById(6);	// 6表示年假
			vcr.setVacationtype(compenvtype);
			vcr.setChangeReason(login.getEmp().getEmpLoginId() + " Added an annual leave, added hours: " + vacationLeftAdminEntity.getAnnualAdd() + ", Desc: " + vacationLeftAdminEntity.getAnnualDesc());
			vcr.setChangeHours(vacationLeftAdminEntity.getAnnualAdd());	// 变更的年假小时数
			vacationchangerecordDAO.save(vcr);
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * getVacationLeftInfo
	 * @return
	 */
	public String getVacationLeftInfo() {
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		Emp loginEmp = login.getEmp();
		System.out.println("进入getVacationLeftInfo 方法》》》 RoleID: " + loginEmp.getRole().getSysRoleId());
		System.out.println("&&&#vacationinfo_emploginid: ###: " + vacationinfo_emploginid);
		if(loginEmp.getRole().getSysRoleId() > 3) { 
			// 权限在3以上，即：Manager 和 Normal
			if(vacationinfo_emploginid != null && !vacationinfo_emploginid.trim().equalsIgnoreCase(loginEmp.getEmpLoginId())) {
				System.out.println("你只能查看自己的信息，不能查看别人的信息。。。。重置 vacationinfo_emploginid为： " + loginEmp.getEmpLoginId());
			}
			vacationinfo_emploginid = loginEmp.getEmpLoginId();
		}
		
		Emp searchEmp = null;
		if(vacationinfo_emploginid != null && vacationinfo_emploginid != "") {
			searchEmp = empDAO.findByLoginName(vacationinfo_emploginid.trim());
		} else {
			System.out.println("vacationinfo_emploginid is null, choose login emp as vacationinfo_emploginid");
			searchEmp = loginEmp;
		}
		List<Compensatoryleaveinfo> compens = compensatoryleaveinfoDAO.findByEmp(searchEmp);
		
		List<String[]> compenList = new ArrayList<String[]>();
		
		VacationLeftAdminEntity vlan = new VacationLeftAdminEntity();
		
		vlan.setEmploginid(searchEmp.getEmpLoginId());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		String[] compenArr;
		int count = 1;
		long diff;
		double diffDay = 0.0;
		for (Compensatoryleaveinfo cominfo : compens) {
			cal2.setTime(cominfo.getExpirationDate());
			diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
			
			diffDay = diff / (24 * 60 * 60 * 1000);
			
			compenArr = new String[6];
			compenArr[0] = count++ + "";
			compenArr[1] = cominfo.getCompensatoryLeaveLeft() + "";
			compenArr[2] = sdf.format(cominfo.getExpirationDate());
			compenArr[3] = sdf.format(cominfo.getCreateDate());
			compenArr[4] = cominfo.getCompensatoryLeaveDesc();
			if(cominfo.getExpirationDate().compareTo(date) < 0) {
				compenArr[5] = "danger";
			} else if (diffDay < 10){
				compenArr[5] = "warning";
			}
			compenList.add(compenArr);
		}
		
		
		int pageSize = login.getPageBean().getPageSize();	
		int page = request_pageno != null && request_pageno != "" ? Integer.parseInt(request_pageno.trim()) : 0;	// 根据页面传递过来的pageNo来筛选数据
		
		if(page == 0) {
			System.out.println("getVacationLeftInfo 方法内部---ajax 请求 page is : " + page);
		}
		
		PageBean vadminPB = vacationchangerecordDAO.findPageBeanByEmp(searchEmp.getEmpLoginId(), pageSize, page);
		List<Vacationchangerecord> vcs = vadminPB.getList();
		List<String[]> histories = new ArrayList<>();
		String[] historyArr;
		int count2 = 1;
		for (Vacationchangerecord vc : vcs) {
			String vacationName = vc.getVacationtype() != null ? vc.getVacationtype().getVacationTypeName() : "";
			if(vacationName.equals("Annual_Leave")) {
				vacationName = "Annual";
			} else if(vacationName.equals("Compensatory_Leave")) {
				vacationName = "Compensatory";
			} else {
				vacationName = "null";
			}
			
			historyArr = new String[7];
			historyArr[0] = count2++ + "";
			historyArr[1] = vc.getVacationAddOrMinus() != null && vc.getVacationAddOrMinus() == 1 ? "+" : "-";
			historyArr[2] = vc.getChangeHours() + "";
			historyArr[3] = vacationName;
			historyArr[4] = vc.getChangeBy();
			historyArr[5] = sdf.format(vc.getCreateDate());
			historyArr[6] = vc.getChangeReason();
			histories.add(historyArr);
		}
		
		vlan.setHistories(histories);
		vlan.setTotalpage(vadminPB.getTotalPage());
		System.out.println("vadminPB.getTotalPage(): " + vadminPB.getTotalPage());
		vlan.setCompensatorys(compenList);
		vlan.setCompenTotalLeft(compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(searchEmp, sdf.format(date)));
		vlan.setAnnualTotalLeft(searchEmp.getAnnualLeaveLeft());
		
		session.put("vacationAdminObject", vlan);	// 加入到session中，防止刷新时出现bug
		
		vLeftAdminEntity = vlan;
		
		return SUCCESS;
	}
	
	
	/**
	 * getVacationLeftInfo
	 * @return
	 */
	public String getMyVacationInfoPagination() {
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		Emp searchEmp = login.getEmp();
		
		List<Compensatoryleaveinfo> compens = compensatoryleaveinfoDAO.findByEmp(searchEmp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		VacationLeftAdminEntity vlan = new VacationLeftAdminEntity();
		vlan.setEmploginid(searchEmp.getEmpLoginId());

		int pageSize = login.getPageBean().getPageSize();
		int page = request_pageno != null && request_pageno != "" ? Integer.parseInt(request_pageno.trim()) : 0;	// 根据页面传递过来的pageNo来筛选数据
		System.out.println("request_pageno: " + request_pageno);
		
		if(page == 0) {
			System.out.println("getVacationLeftInfo 方法内部---ajax 请求 page is : " + page);
		}
		
		PageBean vadminPB = vacationchangerecordDAO.findPageBeanByEmp(searchEmp.getEmpLoginId(), pageSize, page);
		List<Vacationchangerecord> vcs = vadminPB.getList();
		List<String[]> histories = new ArrayList<>();
		String[] historyArr;
		int count2 = 1;
		for (Vacationchangerecord vc : vcs) {
			String vacationName = vc.getVacationtype() != null ? vc.getVacationtype().getVacationTypeName() : "";
			if(vacationName.equals("Annual_Leave")) {
				vacationName = "Annual";
			} else if(vacationName.equals("Compensatory_Leave")) {
				vacationName = "Compensatory";
			} else {
				vacationName = "null";
			}
			
			historyArr = new String[7];
			historyArr[0] = count2++ + "";
			historyArr[1] = vc.getVacationAddOrMinus() != null && vc.getVacationAddOrMinus() == 1 ? "+" : "-";
			historyArr[2] = vc.getChangeHours() + "";
			historyArr[3] = vacationName;
			historyArr[4] = vc.getChangeBy();
			historyArr[5] = sdf.format(vc.getCreateDate());
			historyArr[6] = vc.getChangeReason();
			histories.add(historyArr);
		}
		
		vlan.setHistories(histories);
		vlan.setTotalpage(vadminPB.getTotalPage());
		
		myvacationEntity = vlan;
		
		return SUCCESS;
	}

}
