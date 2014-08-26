package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.ContracttypeDAO;
import com.moravia.hs.base.dao.CostcenterDAO;
import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.EmpchangerecordDAO;
import com.moravia.hs.base.dao.EmptypeDAO;
import com.moravia.hs.base.dao.MboDAO;
import com.moravia.hs.base.dao.PositiontitleDAO;
import com.moravia.hs.base.dao.RoleDAO;
import com.moravia.hs.base.entity.Contracttype;
import com.moravia.hs.base.entity.Costcenter;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Empchangerecord;
import com.moravia.hs.base.entity.Emptype;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Positiontitle;
import com.moravia.hs.base.entity.Role;

@Controller("createEmpAction")
public class CreateEmpAction extends BaseAction {

	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	
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
	
	@Resource(name = "empchangerecordDAO")
	private EmpchangerecordDAO empchangerecordDAO;
	
	private String operationFlag;
	private String eeip_loginid;
	private String eeip_chinesename;
	private String eeip_englishname;
	private String eeip_gender;
	private String eeip_birthday;
	private String eeip_address;
	private String eeip_mobile;
	private String eeip_officephone;
	private String eeip_skype;
	private String eeip_contractstartdate;
	private String eeip_contractenddate;
	private String eeip_contracttype;
	private String eeip_emptype;
	private String[] eeip_withprobation; // checkbox for with probation
	// private String eeip_withprobation;
	private String eeip_probationstartdate;
	private String eeip_probationenddate;
	private String eeip_entrydate;
	private String eeip_leavedate;
	private String eeip_email;
	private String eeip_linemanager;
	private String eeip_workingage;
	private String eeip_workplace;
	private String eeip_positiontitle;
	private String eeip_department;
	private String eeip_basesalary;
	private String eeip_mbo;
	private String eeip_socialinsurance;
	private String eeip_costcenter;
	private String eeip_creditcard;
	private String eeip_annualleaveleft;
	private String eeip_systemrole;
	private String[] eeip_onjob;
	private String eeip_identitycard;
	
	private String eeip_positiontitle_validate;
	private String eeip_depart_validate;
	private String eeip_linemanager_validate;
	private String eeip_basesalary_validate;
	private String eeip_socialinsurance_validate;
	private String eeip_mbo_validate;
	private String eeip_costcenter_validate;
	
//	private String[] positionOption;
	// private String eeip_onjob;

	/*
	 * public void setTestfield(String testfield) { this.testfield = testfield;
	 * }
	 */
	
	
	public String getEeip_positiontitle_validate() {
		return eeip_positiontitle_validate;
	}

	public String getEeip_identitycard() {
		return eeip_identitycard;
	}

	public void setEeip_identitycard(String eeip_identitycard) {
		this.eeip_identitycard = eeip_identitycard;
	}

	public void setEeip_positiontitle_validate(String eeip_positiontitle_validate) {
		this.eeip_positiontitle_validate = eeip_positiontitle_validate;
	}

	public String getEeip_depart_validate() {
		return eeip_depart_validate;
	}

	public void setEeip_depart_validate(String eeip_depart_validate) {
		this.eeip_depart_validate = eeip_depart_validate;
	}

	public String getEeip_linemanager_validate() {
		return eeip_linemanager_validate;
	}

	public void setEeip_linemanager_validate(String eeip_linemanager_validate) {
		this.eeip_linemanager_validate = eeip_linemanager_validate;
	}

	public String getEeip_basesalary_validate() {
		return eeip_basesalary_validate;
	}

	public void setEeip_basesalary_validate(String eeip_basesalary_validate) {
		this.eeip_basesalary_validate = eeip_basesalary_validate;
	}

	public String getEeip_socialinsurance_validate() {
		return eeip_socialinsurance_validate;
	}

	public void setEeip_socialinsurance_validate(
			String eeip_socialinsurance_validate) {
		this.eeip_socialinsurance_validate = eeip_socialinsurance_validate;
	}

	public String getEeip_mbo_validate() {
		return eeip_mbo_validate;
	}

	public void setEeip_mbo_validate(String eeip_mbo_validate) {
		this.eeip_mbo_validate = eeip_mbo_validate;
	}

	public String getEeip_costcenter_validate() {
		return eeip_costcenter_validate;
	}

	public void setEeip_costcenter_validate(String eeip_costcenter_validate) {
		this.eeip_costcenter_validate = eeip_costcenter_validate;
	}

	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}

	public String[] getEeip_withprobation() {
		return eeip_withprobation;
	}

	public void setEeip_withprobation(String[] eeip_withprobation) {
		this.eeip_withprobation = eeip_withprobation;
	}

	public String[] getEeip_onjob() {
		return eeip_onjob;
	}

	public void setEeip_onjob(String[] eeip_onjob) {
		this.eeip_onjob = eeip_onjob;
	}

	public void setEeip_loginid(String eeip_loginid) {
		this.eeip_loginid = eeip_loginid;
	}

	// public void setEeip_withprobation(String eeip_withprobation) {
	// this.eeip_withprobation = eeip_withprobation;
	// }
	//
	// public void setEeip_onjob(String eeip_onjob) {
	// this.eeip_onjob = eeip_onjob;
	// }

	public void setEeip_chinesename(String eeip_chinesename) {
		this.eeip_chinesename = eeip_chinesename;
	}

	public void setEeip_englishname(String eeip_englishname) {
		this.eeip_englishname = eeip_englishname;
	}

	public void setEeip_gender(String eeip_gender) {
		this.eeip_gender = eeip_gender;
	}

	public void setEeip_birthday(String eeip_birthday) {
		this.eeip_birthday = eeip_birthday;
	}

	public void setEeip_address(String eeip_address) {
		this.eeip_address = eeip_address;
	}

	public void setEeip_mobile(String eeip_mobile) {
		this.eeip_mobile = eeip_mobile;
	}

	public void setEeip_officephone(String eeip_officephone) {
		this.eeip_officephone = eeip_officephone;
	}

	public void setEeip_skype(String eeip_skype) {
		this.eeip_skype = eeip_skype;
	}

	public void setEeip_contractstartdate(String eeip_contractstartdate) {
		this.eeip_contractstartdate = eeip_contractstartdate;
	}

	public void setEeip_contractenddate(String eeip_contractenddate) {
		this.eeip_contractenddate = eeip_contractenddate;
	}

	public void setEeip_contracttype(String eeip_contracttype) {
		this.eeip_contracttype = eeip_contracttype;
	}

	public void setEeip_emptype(String eeip_emptype) {
		this.eeip_emptype = eeip_emptype;
	}

	public void setEeip_probationstartdate(String eeip_probationstartdate) {
		this.eeip_probationstartdate = eeip_probationstartdate;
	}

	public void setEeip_probationenddate(String eeip_probationenddate) {
		this.eeip_probationenddate = eeip_probationenddate;
	}

	public void setEeip_entrydate(String eeip_entrydate) {
		this.eeip_entrydate = eeip_entrydate;
	}

	public void setEeip_leavedate(String eeip_leavedate) {
		this.eeip_leavedate = eeip_leavedate;
	}

	public void setEeip_email(String eeip_email) {
		this.eeip_email = eeip_email;
	}

	public void setEeip_linemanager(String eeip_linemanager) {
		this.eeip_linemanager = eeip_linemanager;
	}

	public void setEeip_workingage(String eeip_workingage) {
		this.eeip_workingage = eeip_workingage;
	}

	public void setEeip_workplace(String eeip_workplace) {
		this.eeip_workplace = eeip_workplace;
	}

	public void setEeip_positiontitle(String eeip_positiontitle) {
		this.eeip_positiontitle = eeip_positiontitle;
	}

	public void setEeip_department(String eeip_department) {
		this.eeip_department = eeip_department;
	}

	public void setEeip_basesalary(String eeip_basesalary) {
		this.eeip_basesalary = eeip_basesalary;
	}

	public void setEeip_mbo(String eeip_mbo) {
		this.eeip_mbo = eeip_mbo;
	}

	public void setEeip_socialinsurance(String eeip_socialinsurance) {
		this.eeip_socialinsurance = eeip_socialinsurance;
	}

	public void setEeip_costcenter(String eeip_costcenter) {
		this.eeip_costcenter = eeip_costcenter;
	}

	public void setEeip_creditcard(String eeip_creditcard) {
		this.eeip_creditcard = eeip_creditcard;
	}

	public void setEeip_annualleaveleft(String eeip_annualleaveleft) {
		this.eeip_annualleaveleft = eeip_annualleaveleft;
	}

	public void setEeip_systemrole(String eeip_systemrole) {
		this.eeip_systemrole = eeip_systemrole;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(operationFlag.equals("CreateEmp")) {
			// System.out.println("Operation: Create a new Emp");
			Emp emp = new Emp();
			// System.out.println("eeip_positiontitle: " + eeip_positiontitle);
			// System.out.println("eeip_chinesename: " + eeip_chinesename);
			// System.out.println("eeip_birthday" + eeip_birthday);
			
			emp.setNameChinese(eeip_chinesename.trim());
			emp.setNameEnglish(eeip_englishname.trim());
			emp.setEmpLoginId(eeip_loginid.trim());
			emp.setGender(eeip_gender.trim());
			if(eeip_birthday.trim().length() > 0) {
				emp.setBirthday(sdf.parse(eeip_birthday.trim()));
			} else {
				emp.setBirthday(null);
			}
			emp.setAddress(eeip_address.trim());
			emp.setMobile(eeip_mobile.trim());
			emp.setOfficePhone(eeip_officephone.trim());
			emp.setSkype(eeip_skype.trim());
			emp.setEmail(eeip_email.trim());
			emp.setBaseSalary(Double.parseDouble(eeip_basesalary.trim()));
			emp.setSocialInsurBase(Double.parseDouble(eeip_socialinsurance.trim()));
			
//			// System.out.println("eeip_creditcard.trim().length(): " + eeip_creditcard.trim().length());
			
			if(eeip_creditcard.trim().length() > 0) {
				emp.setCreditCardNumber(Long.parseLong(eeip_creditcard.trim()));
			}
			if(eeip_identitycard.trim().length() > 0) {
				emp.setIdentityCard(eeip_identitycard.trim());
			}
			
			emp.setAnnualLeaveLeft(Double.parseDouble(eeip_annualleaveleft.trim()));
			emp.setWorkplace(eeip_workplace.trim());
			emp.setWorkingAge(Integer.parseInt(eeip_workingage.trim()));
			if(eeip_contractenddate.trim().length() > 0) {
				emp.setContractEndDate(sdf.parse(eeip_contractenddate.trim()));
			} else {
				emp.setContractEndDate(null);
			}
			if(eeip_contractstartdate.trim().length() > 0) {
				emp.setContractStartDate(sdf.parse(eeip_contractstartdate.trim()));
			} else {
				emp.setContractStartDate(null);
			}
			emp.setEntryDate(sdf.parse(eeip_entrydate.trim()));
			
			//with probation 
			if(eeip_withprobation != null) {
//				&& eeip_withprobation.equals("on")
				// System.out.println("eeip_withprobation is not null");
				if(eeip_probationstartdate.trim() != "" && eeip_probationenddate.trim() != "") {
					// System.out.println(".trim() is not empty string");
				emp.setWithProbation(1);
				emp.setPorbationStartDate(sdf.parse(eeip_probationstartdate.trim()));
				emp.setPorbationEndDate(sdf.parse(eeip_probationenddate.trim()));
				}
				eeip_withprobation = null;
			} else {
				// System.out.println("eeip_withprobation is null");
				emp.setWithProbation(0);
				emp.setPorbationStartDate(null);
				emp.setPorbationEndDate(null);
				eeip_withprobation = null;
			}
			//on job
			if(eeip_onjob != null) {
				// && eeip_onjob.equals("on")
				// System.out.println("eeip_onjob is not null");
				emp.setOnJob(1);
				emp.setLeaveDate(null);
				eeip_onjob = null;
			} else {
				// System.out.println("eeip_onjob is null");
				if(eeip_leavedate.trim() != "") {
					emp.setOnJob(0);
					emp.setLeaveDate(sdf.parse(eeip_leavedate.trim()));
				}
				eeip_onjob = null;
			}
			
			Positiontitle pt = positiontitleDAO.findById(Integer.parseInt(eeip_positiontitle.trim()));
			Department de = departmentDAO.findById(Integer.parseInt(eeip_department.trim()));
			
			Emp lineManager = empDAO.findByLoginName(eeip_linemanager.trim());
			
			Role role = roleDAO.findById(Integer.parseInt(eeip_systemrole.trim()));
			Mbo mbo = mboDAO.findById(Integer.parseInt(eeip_mbo.trim()));
			Costcenter costcenter = costcenterDAO.findById(Integer.parseInt(eeip_costcenter.trim()));
			Contracttype ct = contracttypeDAO.findById(Integer.parseInt(eeip_contracttype.trim()));
			Emptype et = emptypeDAO.findById(Integer.parseInt(eeip_emptype.trim()));
			
			if(pt != null) {
				emp.setPositiontitle(pt);
			}
			if(de != null) {
				emp.setDepartment(de);
			}
			if(lineManager != null) {
				// System.out.println("lineManager.getEmpLoginId(): " + lineManager.getEmpLoginId());
				emp.setEmp(lineManager);
			}
			if(role != null) {
				emp.setRole(role);
			}
			if(mbo != null) {
				emp.setMbo(mbo);
			}
			if(costcenter != null) {
				emp.setCostcenter(costcenter);
			}
			if(ct != null) {
				emp.setContracttype(ct);
			}
			if(et != null) {
				emp.setEmptype(et);
			}
			
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			emp.setCreateDate(ts);
			
			if(eeip_positiontitle_validate.trim().length() > 0) {
				emp.setPositionTitleValidate(sdf.parse(eeip_positiontitle_validate.trim()));
			}
			if(eeip_depart_validate.trim().length() > 0) {
				// System.out.println("eeip_depart_validate.trim():" + eeip_depart_validate.trim());
				emp.setDepartmentValidate(sdf.parse(eeip_depart_validate.trim()));
			}
			if(eeip_linemanager_validate.trim().length() > 0) {
				// System.out.println("eeip_linemanager_validate.trim():" + eeip_linemanager_validate.trim());
				emp.setLineManagerValidate(sdf.parse(eeip_linemanager_validate.trim()));
			}
			if(eeip_basesalary_validate.trim().length() > 0) {
				emp.setBaseSalaryValidate(sdf.parse(eeip_basesalary_validate.trim()));
			}
			if(eeip_socialinsurance_validate.trim().length() > 0) {
				emp.setSocialInsurBaseValidate(sdf.parse(eeip_socialinsurance_validate.trim()));
			}
			if(eeip_mbo_validate.trim().length() > 0) {
				emp.setMboValidate(sdf.parse(eeip_mbo_validate.trim()));
			}
			if(eeip_costcenter_validate.trim().length() > 0) {
				emp.setCostCenterValidate(sdf.parse(eeip_costcenter_validate.trim()));
			}
			
			empDAO.save(emp);
			
			//Record a new empchangerecord
			Empchangerecord ecr = new Empchangerecord();
			ecr.setEmp(emp);
			ecr.setEmpLoginId(emp.getEmpLoginId());
			ecr.setNameChinese(emp.getNameChinese());
			ecr.setNameEnglish(emp.getNameEnglish());
			ecr.setContractType(emp.getContracttype().getContractTypeName());
			ecr.setEmpType(emp.getEmptype().getEmpTypeName());
			ecr.setEntryDate(emp.getEntryDate());
			ecr.setLeaveDate(emp.getLeaveDate());
			ecr.setLineManager(emp.getEmp().getEmpLoginId());
			ecr.setLineManagerValidate(emp.getLineManagerValidate());
			ecr.setWorkplace(emp.getWorkplace());
			ecr.setPositionTitleName(emp.getPositiontitle().getPositionTitleName());
			ecr.setPositionTitleValidate(emp.getPositionTitleValidate());
			ecr.setDepartmentName(emp.getDepartment().getDepartName());
			ecr.setDepartmentValidate(emp.getDepartmentValidate());
			ecr.setBaseSalary(emp.getBaseSalary());
			ecr.setBaseSalaryValidate(emp.getBaseSalaryValidate());
			ecr.setMbo(emp.getMbo().getMboRate());
			ecr.setMboValidate(emp.getMboValidate());
			ecr.setSocialInsurBase(emp.getSocialInsurBase());
			ecr.setSocialInsurValidate(emp.getSocialInsurBaseValidate());
			ecr.setCostCenter(emp.getCostcenter().getCostCenterName());
			ecr.setCostCenterValidate(emp.getCostCenterValidate());
			ecr.setSystemRole(emp.getRole().getSysRoleName());
			ecr.setOnJob(emp.getOnJob());
			
			ecr.setModifyDate(date);
			ecr.setCreateDate(new Timestamp(date.getTime()));
			
			empchangerecordDAO.save(ecr);
			
			
		}
		return SUCCESS;
	}

}
