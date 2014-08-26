package com.moravia.hs.action.test;

import java.io.IOException;
import java.security.Key;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.BaseAction;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.RoleDAO;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Role;
import com.moravia.hs.base.entity.view.Loginview;
import com.moravia.hs.util.DesUtil;
import com.moravia.hs.util.LoginAuthentification;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import org.springframework.web.struts.ActionSupport;
@Controller("testLoginAction")
public class TestLoginAction extends BaseAction {
	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	@Resource(name = "empDAO")
	private EmpDAO empDAO; 
	@Resource(name = "roleDAO")
	private RoleDAO roleDAO;
	private String username;
	private String password;
	private String remember;

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
		System.out.println("execute method running...");
		String orig_username = username;
		username = username.replace("cz\\", "");
		username = username.replace("CZ\\", "");
		username = username.toLowerCase();
		Map<String, Object> session = getSession();
		Loginview loginview = loginviewDAO.findByLoginId(username);
		if (loginview != null) {
			DesUtil du = null;
			String key = "P@ssword+-";
			System.out.println("Original password is： " + password);
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
			 LoginAuthentification(loginview.getNameEnglish().toLowerCase(),
			 password);
			 if(auth.authentificate()) {
			 //Authentificated
//			 if(true) {
				// register cookies
				if(remember !=null && remember.equalsIgnoreCase("on")) {
				System.out.println("remember's value is on, save the cookies...");
				du = new DesUtil();
				try {
					//Encrypted password
					password = "&En@Pwd&" + du.encrypt(password, key);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("EncryptedPwd is :" + password);
				HttpServletResponse response = (HttpServletResponse) ActionContext
						.getContext().get(StrutsStatics.HTTP_RESPONSE);
				Cookie c_username = new Cookie("MSH_login_username", orig_username);
				Cookie c_password = new Cookie("MSH_login_password", password);
				c_username.setMaxAge(60 * 60 * 24 * 365);
				c_password.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(c_username);
				response.addCookie(c_password);
				}
				
//				Role role = roleDAO.findById(1);
//				Emp emp = new Emp();
////				emp.setEmpId(10);
//				emp.setNameEnglish("Bruce Weilis4");
//				emp.setEmpLoginId("BruceW4");
//				emp.setRole(role);
//				empDAO.save(emp);
//				
				
				Emp emp2 = empDAO.findById(109);
				session.put("Emp_ID", emp2.getEmpId());
				session.put("Name_English", emp2.getNameEnglish());
//				session.put("systemRole", emp2.getRole());
//				session.put("sysRoleName", loginview.getSysRoleName());
				session.put("sysRoleName", emp2.getRole().getSysRoleName());
				session.put("Authoritys", emp2.getRole().getRoleauths().size());
				
				return SUCCESS;
			} 
		} 
			//Not authentificated
		System.out.println("getText error: " + getText("login_error"));
//		request.clear();
		session.put("login_errorMsg", getText("login_error"));
		return INPUT;
	}
}
