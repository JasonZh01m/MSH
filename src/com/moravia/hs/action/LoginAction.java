package com.moravia.hs.action;

import java.io.IOException;
import java.security.Key;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.AbsenceinfoviewDAO;
import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.CompensatoryleaveinfoDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.TokenAbsenceDAO;
import com.moravia.hs.base.dao.TokenOvertimeDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.base.entity.other.PageBean;
import com.moravia.hs.base.entity.other.VacationUsedInfo;
import com.moravia.hs.base.entity.view.Absenceinfoview;
import com.moravia.hs.base.entity.view.Loginview;
import com.moravia.hs.util.DesUtil;
import com.moravia.hs.util.LoginAuthentification;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import org.springframework.web.struts.ActionSupport;
@Controller("loginAction")
public class LoginAction extends BaseAction {
	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;
	
	@Autowired
	private TokenAbsenceDAO tokenAbsenceDAO;
	
	@Autowired
	private TokenOvertimeDAO tokenOvertimeDAO;
	
	@Autowired
	private CompensatoryleaveinfoDAO compensatoryleaveinfoDAO;
	
	@Autowired
	private AbsencerecordDAO absencerecordDAO;
	
	@Autowired
	private AbsenceinfoviewDAO absenceinfoviewDAO;
	
	
	
	private String username;
	private String password;
	private String remember;
	private String login_remember;
	
	private String redirectloginid;
	

	public String getLogin_remember() {
		return login_remember;
	}

	public void setLogin_remember(String login_remember) {
		this.login_remember = login_remember;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	public String execute() {
		// System.out.println("execute method running...");
		String orig_username = username;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		username = username.replace("cz\\", "");
		username = username.replace("CZ\\", "");
		username = username.toLowerCase();
		Map<String, Object> session = getSession();
		Loginview loginview = loginviewDAO.findByLoginId(username);
		
		if (loginview != null) {
			DesUtil du = null;
			String key = "P@ssword+-";
			// System.out.println("Original password is： " + password);
			//Decrypt password use key
			if(password.startsWith("&En@Pwd&")) {
				du = new DesUtil();
				try {
					password = du.decrypt(password.replace("&En@Pwd&", ""), key);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 LoginAuthentification auth = new
			 LoginAuthentification(loginview.getNameEnglish(),
			 password);
//			 if(auth.authentificate()) {
			 //Authentificated
			 if(true) {
				 HttpServletResponse response = (HttpServletResponse) ActionContext
							.getContext().get(StrutsStatics.HTTP_RESPONSE);
				// register cookies
				if(login_remember.trim().equals("on")) {
				// System.out.println("remember's value is on, save the cookies...");
				du = new DesUtil();
				try {
					//Encrypted password
					password = "&En@Pwd&" + du.encrypt(password, key);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("EncryptedPwd is :" + password);
				Cookie c_username = new Cookie("MSH_login_username", orig_username.replace("cz\\", "").replace("CZ\\", ""));
				Cookie c_password = new Cookie("MSH_login_password", password);
				c_username.setMaxAge(60 * 60 * 24 * 365);
				c_password.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(c_username);
				response.addCookie(c_password);
				} else if (login_remember.trim().equals("off")) {
					System.out.println("NOt checked, delete MSH_login_username");
					Cookie c_username = new Cookie("MSH_login_username", null);
					Cookie c_password = new Cookie("MSH_login_password", null);
					c_username.setMaxAge(0);
					c_password.setMaxAge(0);
					response.addCookie(c_username);
					response.addCookie(c_password);
				}
				
//				if(loginview.getSysRoleName().equalsIgnoreCase("admin") || loginview.getSysRoleName().equalsIgnoreCase("hr") || loginview.getSysRoleName().equalsIgnoreCase("finance")) {
//					Basesalaryproperties bsp = basesalarypropertiesDAO.findLastCreated();
					 
//					session.put("Login_Emp_ID", loginview.getEmpId());
//					session.put("Login_Emp_LoginID", loginview.getEmpLoginId());	// 用户loginId
//					session.put("Login_Name_English", loginview.getNameEnglish());	// 用户英文名
//					session.put("Login_systemRole", loginview.getSystemRole());		// 系统角色
//					session.put("Login_sysRoleName", loginview.getSysRoleName());	// 
//					session.put("Login_sysRoleName", empDAO.findById(loginview.getEmpId()).getRole().getSysRoleName());
//					session.put("Login_loginviewList", loginviewDAO.findAllLoginId());
//					session.put("index_startDate", sdf.format(bsp.getStartDate()));

				// 取得今年年初跟年终的时间，计算员工所有假期的使用情况。 
				Date date = new Date();
				SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdfyear = new SimpleDateFormat("yyyy");
				Calendar castart = Calendar.getInstance();
				Calendar caend = Calendar.getInstance();
				castart.set(Integer.parseInt(sdfyear.format(date)), 0, 0, 0, 0, 0);
				castart.add(Calendar.DATE, 1);
				caend.set(Integer.parseInt(sdfyear.format(date)) + 1, 0, 0, 0, 0, 0);
				
				System.out.println("castart.getTime(): " + sdftime.format(castart.getTime()));
				System.out.println("caend.getTime()): " + sdftime.format(caend.getTime()));
				
				/**
				 * Login Info
				 */
				Login login = new Login();
				Emp emp = empDAO.findById(loginview.getEmpId());
				login.setEmp(emp);
				login.setAllLoginIds(loginviewDAO.findAllLoginId());
				
//				VacationUsedInfo vci = absencerecordDAO.findVacationUsedInfo(emp.getEmpLoginId(), sdftime.format(castart.getTime()), sdftime.format(caend.getTime()));
				
				Timestamp startTime = new Timestamp(castart.getTimeInMillis());
				Timestamp endTime = new Timestamp(caend.getTimeInMillis());
				
				List<Absenceinfoview> avs2 = absenceinfoviewDAO.findByEmpAllState("jasonzh", startTime, endTime);
				
				VacationUsedInfo vci = new VacationUsedInfo();
				
				double annualLeave = 0.0;
				double compensatory = 0.0;
				double personalLeave = 0.0;
				double longSickMarriageLeave = 0.0;
				double sickMateryBreaveLeave = 0.0;
				
				double annualLeave_inprog = 0.0;
				double compensatory_inprog = 0.0;
				double personalLeave_inprog = 0.0;
				double longSickMarriageLeave_inprog = 0.0;
				double sickMateryBreaveLeave_inprog = 0.0;
				
				double annualLeave_reject = 0.0;
				double compensatory_reject = 0.0;
				double personalLeave_reject = 0.0;
				double longSickMarriageLeave_reject = 0.0;
				double sickMateryBreaveLeave_reject = 0.0;
				
				
				for (Absenceinfoview av : avs2) {
					if(av.getStateName().equalsIgnoreCase("Done")) {
						switch (av.getVacationTypeName()) {
							case "Personal_Unpaid_Leave":
								// 事假
								personalLeave += av.getAbsenceHours();
								break;
								
							case "Long_Sick_Marriage_Leave":
								// 长病假
								longSickMarriageLeave += av.getAbsenceHours();
								break;
								
							case "Sick_Maternity_Breavement_Leave":
								// 病假/哺乳假
								sickMateryBreaveLeave += av.getAbsenceHours();
								break;
								
							case "Compensatory_Leave":
								// 调休假
								compensatory += av.getAbsenceHours();
								break;
								
							case "Annual_Leave":
								// 年假
								annualLeave += av.getAbsenceHours();
								break;
			
							default:
								break;
						}
					} else if (av.getStateName().equalsIgnoreCase("Rejected")) {
						switch (av.getVacationTypeName()) {
							case "Personal_Unpaid_Leave":
								// 事假
								personalLeave_reject += av.getAbsenceHours();
								break;
								
							case "Long_Sick_Marriage_Leave":
								// 长病假
								longSickMarriageLeave_reject += av.getAbsenceHours();
								break;
								
							case "Sick_Maternity_Breavement_Leave":
								// 病假/哺乳假
								sickMateryBreaveLeave_reject += av.getAbsenceHours();
								break;
								
							case "Compensatory_Leave":
								// 调休假
								compensatory_reject += av.getAbsenceHours();
								break;
								
							case "Annual_Leave":
								// 年假
								annualLeave_reject += av.getAbsenceHours();
								break;
			
							default:
								break;
						}
						
					} else if (av.getStateName().equalsIgnoreCase("InProg")) {
						switch (av.getVacationTypeName()) {
							case "Personal_Unpaid_Leave":
								// 事假
								personalLeave_inprog += av.getAbsenceHours();
								break;
								
							case "Long_Sick_Marriage_Leave":
								// 长病假
								longSickMarriageLeave_inprog += av.getAbsenceHours();
								break;
								
							case "Sick_Maternity_Breavement_Leave":
								// 病假/哺乳假
								sickMateryBreaveLeave_inprog += av.getAbsenceHours();
								break;
								
							case "Compensatory_Leave":
								// 调休假
								compensatory_inprog += av.getAbsenceHours();
								break;
								
							case "Annual_Leave":
								// 年假
								annualLeave_inprog += av.getAbsenceHours();
								break;
			
							default:
								break;
						}
					
					}
				}
				
				vci.setAnnualLeave(annualLeave + annualLeave_inprog + annualLeave_reject); // 已用年假 = 实际使用年假 + 正在流程中年假
				vci.setCompensatory(compensatory + compensatory_inprog + compensatory_reject);	// 已用调休
				vci.setLongSickMarriageLeave(longSickMarriageLeave + longSickMarriageLeave_inprog + longSickMarriageLeave_reject);	// 已用长病假
				vci.setPersonalLeave(personalLeave + personalLeave_inprog + personalLeave_reject); 	// 已用事假
				vci.setSickMateryBreaveLeave(sickMateryBreaveLeave + sickMateryBreaveLeave_inprog + sickMateryBreaveLeave_reject); 	// 已用病假
				
				login.setVacationUsedInfo(vci);	// login 绑定vacationUserdInfo

				/*Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, -1);	// 申请日期往前推一个月
				
				Double comLeft = compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(emp, sdf.format(cal.getTime()));*/
				Double comLeft = compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(emp, sdf.format(new Date()));
				
				login.setUsableCompensatoryLeave(comLeft - compensatory_inprog - compensatory_reject);	// 可申请的调休假 = 实际剩余调休假 - 正在流转中的调休假 
				
				Double annualLeft = emp.getAnnualLeaveLeft();
				
				login.setUsableAnnualLeave(annualLeft - annualLeave_inprog - annualLeave_reject); 	// 可申请的年假 = 实际剩余年假 - 正在流转中的年假
				
				// 设置executor = loginId, requestState = 1, pageSize = 10, currentPage = 0
				PageBean pageBean = tokenAbsenceDAO.findByTokenExecutorWithPageSize(loginview.getEmpLoginId(), 1, 10, 0);
				login.setPageBean(pageBean);
				
				PageBean pageBeanOvertimeRequests = tokenOvertimeDAO.findByExecutorWithPageSize(loginview.getEmpLoginId(), 1, 10, 0);
				/*if(pageBeanOvertimeRequests.getTotalPage() == 0) {
					pageBeanOvertimeRequests.
				}*/
				System.out.println("pageBeanOvertimeRequests.totalPage in loginAction is: "+ pageBeanOvertimeRequests.getTotalPage());
				System.out.println("login set pageBeanOvertimeRequests, list size is: " + pageBeanOvertimeRequests.getList().size());
				login.setPageBeanOvertimeRequests(pageBeanOvertimeRequests);
				
				session.put("login", login);
				
				return SUCCESS;
//				} else {
//					session.clear();
//					session.put("login_errorMsg", getText("login_permissionDeny"));
//					return INPUT;
//				}
				
			}
		}
		//Not authentificated
		// System.out.println("getText error: " + getText("login_error"));
		session.clear();
		session.put("login_errorMsg", getText("login_error"));
		return INPUT;
	}
	
	
	
	public String logoff() {
		Map<String, Object> session = getSession();
		session.clear();
		System.out.println("session.clear();");
		return SUCCESS;
	}
}
