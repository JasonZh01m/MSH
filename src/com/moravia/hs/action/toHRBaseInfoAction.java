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
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Contracttype;
import com.moravia.hs.base.entity.Costcenter;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emptype;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Positiontitle;
import com.moravia.hs.base.entity.Vacationtype;

@Controller("toHRBaseInfoAction")
public class toHRBaseInfoAction extends BaseAction{

	@Resource(name = "loginviewDAO")
	private LoginviewDAO loginviewDAO;
	
	@Resource(name = "positiontitleDAO")
	private PositiontitleDAO positiontitleDAO;

	@Resource(name = "departmentDAO")
	private DepartmentDAO departmentDAO;

	@Resource(name = "mboDAO")
	private MboDAO mboDAO;

	@Resource(name = "costcenterDAO")
	private CostcenterDAO costcenterDAO;

	@Resource(name = "contracttypeDAO")
	private ContracttypeDAO contracttypeDAO;

	@Resource(name = "emptypeDAO")
	private EmptypeDAO emptypeDAO;

	@Resource(name = "vacationtypeDAO")
	private VacationtypeDAO vacationtypeDAO;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<Positiontitle> positiontitleList = null;
		List<Department> departmentList = null;
		List<Mbo> mboList = null;
		List<Costcenter> costcenterList = null;
		List<Vacationtype> vacationtypeList = null;
		List<Contracttype> contracttypeList = null;
		List<Emptype> emptypeList = null;
		List<String> loginviewList = loginviewDAO.findAllLoginId();
		Map<String, Object> session = getSession();
		
		 positiontitleList = positiontitleDAO.findAll();
		 departmentList = departmentDAO.findAll();
		 mboList = mboDAO.findAll();
		 costcenterList = costcenterDAO.findAll();
		 vacationtypeList = vacationtypeDAO.findAll();
		 contracttypeList = contracttypeDAO.findAll();
		 emptypeList = emptypeDAO.findAll();
		
		 session.put("hrbip_loginviewList", loginviewList);
		 session.put("hrbip_positiontitleList", positiontitleList);
		 session.put("hrbip_departmentList", departmentList);
		 session.put("hrbip_mboList", mboList);
		 session.put("hrbip_costcenterList", costcenterList);
		 session.put("hrbip_vacationtypeList", vacationtypeList);
		 session.put("hrbip_contracttypeList", contracttypeList);
		 session.put("hrbip_emptypeList", emptypeList);
			
		 return SUCCESS;
	}
	
	
	
	
}
