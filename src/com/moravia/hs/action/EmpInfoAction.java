package com.moravia.hs.action;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Role;
import com.moravia.hs.base.entity.view.Loginview;

@Controller("empInfoAction")
public class EmpInfoAction extends BaseAction{

	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	
	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO; 
	
	
	private String empLoginId;
	
	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//get Session
		Map<String, Object> session = getSession();
		
		Loginview lv = loginviewDAO.findByLoginId(empLoginId);
		Emp emp = empDAO.findById(lv.getEmpId());
		
		session.put("eip_emp", emp);
		
		// 根据出生日期计算年龄
		Date birthday = emp.getBirthday();
		
		if(birthday != null) {
		Calendar dob = Calendar.getInstance();  
        dob.setTime(birthday);
        Calendar today = Calendar.getInstance();  
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
        System.out.println(age);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
          age--;  
        }
        session.put("eip_emp_age", age);
		} else {
			session.put("eip_emp_age", 0);
		}
        
		return SUCCESS;
	} 
	

}
