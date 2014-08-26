package com.moravia.hs.action.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.BaseAction;
import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.dao.TokenAbsenceDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.TokenAbsence;
import com.moravia.hs.base.entity.other.PageBean;
import com.opensymphony.xwork2.ActionSupport;

@Controller("dataAction")
public class DataAction extends ActionSupport {
	@Autowired
	private TokenAbsenceDAO tokenAbsenceDAO;
	
	@Autowired
	private RequeststateDAO requeststateDAO;
	
	@Autowired
	private AbsencerecordDAO absencerecordDAO;
	
	private String name;
	private int age;
	private User user;
	private List<User> users;
	private List<Absencerecord> abrs;
	
	public String getData(){
		name = "梅西";
		age = 25;
		user = new User(1,"admin","123456", 10);
		users = new ArrayList<User>();
		users.add(new User(1,"乔丹","111111", 11));
		users.add(new User(2,"詹姆斯","111111", 12));
		users.add(new User(3,"科比","111111", 13));
		
		return SUCCESS;
	}
	
	public String getData2() {
		PageBean pageBean = tokenAbsenceDAO.findByTokenExecutorWithPageSize("JasonL", 1, 5, 2);
//		PageBean pageBean = tokenAbsenceDAO.testqueryForPage(5, 2);
		List<TokenAbsence> tokens = pageBean.getList();
		System.out.println("tokens.size(): " + tokens.size());
		abrs = new ArrayList<Absencerecord>();
		for (TokenAbsence token : tokens) {
			Absencerecord ar = token.getAbsencerecord();
			abrs.add(ar);
		}
//		Absencerecord ar2 = absencerecordDAO.findById(2);
		System.out.println("abrs.size(): " + abrs.size());
		return SUCCESS;
	}
	
	/*public Absencerecord getAr() {
		return ar;
	}

	public void setAr(Absencerecord ar) {
		this.ar = ar;
	}*/

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		System.out.println("getUsers()");
		return users;
	}

	public void setUsers(List<User> users) {
		System.out.println("setUsers");
		this.users = users;
	}

	public List<Absencerecord> getAbrs() {
		return abrs;
	}

	public void setAbrs(List<Absencerecord> abrs) {
		this.abrs = abrs;
	}

	/*public List<Absencerecord> getRequestinfo() {
		System.out.println("getRequestinfo");
		return requestinfo;
	}

	public void setRequestinfo(List<Absencerecord> requestinfo) {
		System.out.println("setRequestinfo");
		this.requestinfo = requestinfo;
	}*/
}
