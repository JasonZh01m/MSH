package com.moravia.hs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.ContracttypeDAO;
import com.moravia.hs.base.dao.CostcenterDAO;
import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.EmptypeDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.MboDAO;
import com.moravia.hs.base.dao.PositiontitleDAO;
import com.moravia.hs.base.dao.RoleDAO;
import com.moravia.hs.base.entity.Contracttype;
import com.moravia.hs.base.entity.Costcenter;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Emptype;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Positiontitle;
import com.moravia.hs.base.entity.Role;
import com.moravia.hs.base.entity.view.Loginview;

@Controller("toCreateEmpPageAction")
public class toCreateEmpPageAction extends BaseAction{
	
	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	
	@Resource(name = "positiontitleDAO")
	private PositiontitleDAO positiontitleDAO;
	
	@Resource(name = "departmentDAO")
	private DepartmentDAO departmentDAO;
	
	@Resource(name = "roleDAO")
	private RoleDAO roleDAO;
	
	@Resource(name = "mboDAO")
	private MboDAO mboDAO;
	
	@Resource(name = "costcenterDAO")
	private CostcenterDAO costcenterDAO;
	
	@Resource(name = "contracttypeDAO")
	private ContracttypeDAO contracttypeDAO;
	
	@Resource(name = "emptypeDAO")
	private EmptypeDAO emptypeDAO;


	@Override
	public String execute() throws Exception {
		Map<String, Object> session = getSession();
		
		
		List<String> loginviewList = loginviewDAO.findAllLoginId();
		
		List<Positiontitle> positiontitleList = positiontitleDAO.findAll();
		
		List<Department> departmentList = departmentDAO.findAll();
		
		List<Mbo> mboList = mboDAO.findAll();
		
		List<Costcenter> costcenterList = costcenterDAO.findAll();
		
		List<Contracttype> contracttypeList = contracttypeDAO.findAll();
		
		List<Emptype> emptypeList = emptypeDAO.findAll();
		
		List<Role> roleList = roleDAO.findAll();
		
		session.put("loginviewList", loginviewList);
		session.put("positiontitleList", positiontitleList);
		session.put("departmentList", departmentList);
		session.put("mboList", mboList);
		session.put("costcenterList", costcenterList);
		session.put("contracttypeList", contracttypeList);
		session.put("emptypeList", emptypeList);
		session.put("roleList", roleList);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

























