package com.moravia.hs.action.test;

import java.io.IOException;
import java.security.Key;
import java.sql.Timestamp;
import java.util.Date;
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
@Controller("testAction1")
public class TestAction1 extends BaseAction {
	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	@Resource(name = "roleDAO")
	private RoleDAO roleDAO;
	
	private String testGetLoginID;

	public String getTestGetLoginID() {
		return testGetLoginID;
	}

	public void setTestGetLoginID(String testGetLoginID) {
		this.testGetLoginID = testGetLoginID;
	}



	public String execute() {
		/*int n = Integer.parseInt(insertNum);
		Emp emp = new Emp();
//		emp.setEmpId(n);
		emp.setEmpLoginId("Bbb5");
		emp.setNameEnglish("english name5");
		emp.setRole(roleDAO.findById(5));
		emp.setCreateDate(new Timestamp(new Date().getTime()));
		empDAO.save(emp);*/
		
		Map<String, Object> session = getSession();
		Loginview lv = loginviewDAO.findByLoginId(testGetLoginID);
		session.put("test_empEnglishName", lv.getNameEnglish());
		session.put(testGetLoginID + "test_empEnglishName", lv.getNameEnglish());
		
		return SUCCESS;
	}
}
