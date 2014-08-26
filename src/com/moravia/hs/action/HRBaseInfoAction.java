package com.moravia.hs.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.ContracttypeDAO;
import com.moravia.hs.base.dao.CostcenterDAO;
import com.moravia.hs.base.dao.DepartmentDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.EmptypeDAO;
import com.moravia.hs.base.dao.MboDAO;
import com.moravia.hs.base.dao.PositiontitleDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Contracttype;
import com.moravia.hs.base.entity.Costcenter;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Emptype;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Positiontitle;
import com.moravia.hs.base.entity.Vacationtype;

@Controller("hRBaseInfoAction")
public class HRBaseInfoAction extends BaseAction {

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

	@Resource(name = "empDAO")
	private EmpDAO empDAO;

	private String operationFlag_tohbip; // Operation flag

	// position title related
	private String hrbip_savePt_titleName;
	private String hrbip_savePt_desc;

	private String hrbip_editPt_titleId;
	private String hrbip_editPt_titleName;
	private String hrbip_editPt_desc;

	private String hrbip_deletePt_titleId;

	// depart related
	private String hrbip_editDepart_Id;
	private String hrbip_editDepart_Name;
	private String hrbip_editDepart_Desc;
	private String hrbip_editDepart_Manager;

	private String hrbip_addDepart_Name;
	private String hrbip_addDepart_Desc;
	private String hrbip_addDepart_Manager;

	private String hrbip_deleteDepart_Id;

	// MBO related
	private String hrbip_editMBO_Id;
	private String hrbip_editMBO_Rate;
	private String hrbip_editMBO_PaidPeriod;
	private String hrbip_editMBO_Desc;

	private String hrbip_deleteMBO_Id;

	private String hrbip_addMBO_Rate;
	private String hrbip_addMBO_PaidPeriod;
	private String hrbip_addMBO_Desc;

	// Cost Center Related
	private String hrbip_editCostCenter_Id;
	private String hrbip_editCostCenter_Name;
	private String hrbip_editCostCenter_Parent;
	private String hrbip_editCostCenter_Owner;
	private String hrbip_editCostCenter_Description;

	private String hrbip_addCostCenter_Name;
	private String hrbip_addCostCenter_Parent;
	private String hrbip_addCostCenter_Owner;
	private String hrbip_addCostCenter_Desc;

	private String hrbip_deleteCostCenter_Id;

	// Vacation Type
	private String hrbip_editVacation_Id;
	private String hrbip_editVacation_Name;
	private String hrbip_editVacation_TsId;
	private String hrbip_editVacation_PaidRate;
	private String hrbip_editVacation_Desc;

	private String hrbip_addVacation_Name;
	private String hrbip_addVacation_TsId;
	private String hrbip_addVacation_PaidRate;
	private String hrbip_addVacation_Desc;

	// Contract Type
	private String hrbip_editContractType_Id;
	private String hrbip_editContractType_Name;
	private String hrbip_editContractType_Desc;

	private String hrbip_deleteContractType_Id;

	private String hrbip_addContractType_Name;
	private String hrbip_addContractType_Desc;

	// Emp Type
	private String hrbip_editEmpType_Id;
	private String hrbip_editEmpType_Name;
	private String hrbip_editEmpType_Desc;

	private String hrbip_deleteEmpType_Id;

	private String hrbip_addEmpType_Name;
	private String hrbip_addEmpType_Desc;
	

	public String getHrbip_editEmpType_Id() {
		return hrbip_editEmpType_Id;
	}

	public void setHrbip_editEmpType_Id(String hrbip_editEmpType_Id) {
		this.hrbip_editEmpType_Id = hrbip_editEmpType_Id;
	}

	public String getHrbip_editEmpType_Name() {
		return hrbip_editEmpType_Name;
	}

	public void setHrbip_editEmpType_Name(String hrbip_editEmpType_Name) {
		this.hrbip_editEmpType_Name = hrbip_editEmpType_Name;
	}

	public String getHrbip_editEmpType_Desc() {
		return hrbip_editEmpType_Desc;
	}

	public void setHrbip_editEmpType_Desc(String hrbip_editEmpType_Desc) {
		this.hrbip_editEmpType_Desc = hrbip_editEmpType_Desc;
	}

	public String getHrbip_deleteEmpType_Id() {
		return hrbip_deleteEmpType_Id;
	}

	public void setHrbip_deleteEmpType_Id(String hrbip_deleteEmpType_Id) {
		this.hrbip_deleteEmpType_Id = hrbip_deleteEmpType_Id;
	}

	public String getHrbip_addEmpType_Name() {
		return hrbip_addEmpType_Name;
	}

	public void setHrbip_addEmpType_Name(String hrbip_addEmpType_Name) {
		this.hrbip_addEmpType_Name = hrbip_addEmpType_Name;
	}

	public String getHrbip_addEmpType_Desc() {
		return hrbip_addEmpType_Desc;
	}

	public void setHrbip_addEmpType_Desc(String hrbip_addEmpType_Desc) {
		this.hrbip_addEmpType_Desc = hrbip_addEmpType_Desc;
	}

	public String getHrbip_editContractType_Id() {
		return hrbip_editContractType_Id;
	}

	public void setHrbip_editContractType_Id(String hrbip_editContractType_Id) {
		this.hrbip_editContractType_Id = hrbip_editContractType_Id;
	}

	public String getHrbip_editContractType_Name() {
		return hrbip_editContractType_Name;
	}

	public void setHrbip_editContractType_Name(
			String hrbip_editContractType_Name) {
		this.hrbip_editContractType_Name = hrbip_editContractType_Name;
	}

	public String getHrbip_editContractType_Desc() {
		return hrbip_editContractType_Desc;
	}

	public void setHrbip_editContractType_Desc(
			String hrbip_editContractType_Desc) {
		this.hrbip_editContractType_Desc = hrbip_editContractType_Desc;
	}

	public String getHrbip_deleteContractType_Id() {
		return hrbip_deleteContractType_Id;
	}

	public void setHrbip_deleteContractType_Id(
			String hrbip_deleteContractType_Id) {
		this.hrbip_deleteContractType_Id = hrbip_deleteContractType_Id;
	}

	public String getHrbip_addContractType_Name() {
		return hrbip_addContractType_Name;
	}

	public void setHrbip_addContractType_Name(String hrbip_addContractType_Name) {
		this.hrbip_addContractType_Name = hrbip_addContractType_Name;
	}

	public String getHrbip_addContractType_Desc() {
		return hrbip_addContractType_Desc;
	}

	public void setHrbip_addContractType_Desc(String hrbip_addContractType_Desc) {
		this.hrbip_addContractType_Desc = hrbip_addContractType_Desc;
	}

	private String hrbip_deleteVacation_Id;

	public String getHrbip_editVacation_Id() {
		return hrbip_editVacation_Id;
	}

	public void setHrbip_editVacation_Id(String hrbip_editVacation_Id) {
		this.hrbip_editVacation_Id = hrbip_editVacation_Id;
	}

	public String getHrbip_editVacation_Name() {
		return hrbip_editVacation_Name;
	}

	public void setHrbip_editVacation_Name(String hrbip_editVacation_Name) {
		this.hrbip_editVacation_Name = hrbip_editVacation_Name;
	}

	public String getHrbip_editVacation_TsId() {
		return hrbip_editVacation_TsId;
	}

	public void setHrbip_editVacation_TsId(String hrbip_editVacation_TsId) {
		this.hrbip_editVacation_TsId = hrbip_editVacation_TsId;
	}

	public String getHrbip_editVacation_PaidRate() {
		return hrbip_editVacation_PaidRate;
	}

	public void setHrbip_editVacation_PaidRate(
			String hrbip_editVacation_PaidRate) {
		this.hrbip_editVacation_PaidRate = hrbip_editVacation_PaidRate;
	}

	public String getHrbip_editVacation_Desc() {
		return hrbip_editVacation_Desc;
	}

	public void setHrbip_editVacation_Desc(String hrbip_editVacation_Desc) {
		this.hrbip_editVacation_Desc = hrbip_editVacation_Desc;
	}

	public String getHrbip_addVacation_Name() {
		return hrbip_addVacation_Name;
	}

	public void setHrbip_addVacation_Name(String hrbip_addVacation_Name) {
		this.hrbip_addVacation_Name = hrbip_addVacation_Name;
	}

	public String getHrbip_addVacation_TsId() {
		return hrbip_addVacation_TsId;
	}

	public void setHrbip_addVacation_TsId(String hrbip_addVacation_TsId) {
		this.hrbip_addVacation_TsId = hrbip_addVacation_TsId;
	}

	public String getHrbip_addVacation_PaidRate() {
		return hrbip_addVacation_PaidRate;
	}

	public void setHrbip_addVacation_PaidRate(String hrbip_addVacation_PaidRate) {
		this.hrbip_addVacation_PaidRate = hrbip_addVacation_PaidRate;
	}

	public String getHrbip_addVacation_Desc() {
		return hrbip_addVacation_Desc;
	}

	public void setHrbip_addVacation_Desc(String hrbip_addVacation_Desc) {
		this.hrbip_addVacation_Desc = hrbip_addVacation_Desc;
	}

	public String getHrbip_deleteVacation_Id() {
		return hrbip_deleteVacation_Id;
	}

	public void setHrbip_deleteVacation_Id(String hrbip_deleteVacation_Id) {
		this.hrbip_deleteVacation_Id = hrbip_deleteVacation_Id;
	}

	public String getHrbip_editCostCenter_Id() {
		return hrbip_editCostCenter_Id;
	}

	public void setHrbip_editCostCenter_Id(String hrbip_editCostCenter_Id) {
		this.hrbip_editCostCenter_Id = hrbip_editCostCenter_Id;
	}

	public String getHrbip_editCostCenter_Name() {
		return hrbip_editCostCenter_Name;
	}

	public void setHrbip_editCostCenter_Name(String hrbip_editCostCenter_Name) {
		this.hrbip_editCostCenter_Name = hrbip_editCostCenter_Name;
	}

	public String getHrbip_editCostCenter_Parent() {
		return hrbip_editCostCenter_Parent;
	}

	public void setHrbip_editCostCenter_Parent(
			String hrbip_editCostCenter_Parent) {
		this.hrbip_editCostCenter_Parent = hrbip_editCostCenter_Parent;
	}

	public String getHrbip_editCostCenter_Owner() {
		return hrbip_editCostCenter_Owner;
	}

	public void setHrbip_editCostCenter_Owner(String hrbip_editCostCenter_Owner) {
		this.hrbip_editCostCenter_Owner = hrbip_editCostCenter_Owner;
	}

	public String getHrbip_editCostCenter_Description() {
		return hrbip_editCostCenter_Description;
	}

	public void setHrbip_editCostCenter_Description(
			String hrbip_editCostCenter_Description) {
		this.hrbip_editCostCenter_Description = hrbip_editCostCenter_Description;
	}

	public String getHrbip_addCostCenter_Name() {
		return hrbip_addCostCenter_Name;
	}

	public void setHrbip_addCostCenter_Name(String hrbip_addCostCenter_Name) {
		this.hrbip_addCostCenter_Name = hrbip_addCostCenter_Name;
	}

	public String getHrbip_addCostCenter_Parent() {
		return hrbip_addCostCenter_Parent;
	}

	public void setHrbip_addCostCenter_Parent(String hrbip_addCostCenter_Parent) {
		this.hrbip_addCostCenter_Parent = hrbip_addCostCenter_Parent;
	}

	public String getHrbip_addCostCenter_Owner() {
		return hrbip_addCostCenter_Owner;
	}

	public void setHrbip_addCostCenter_Owner(String hrbip_addCostCenter_Owner) {
		this.hrbip_addCostCenter_Owner = hrbip_addCostCenter_Owner;
	}

	public String getHrbip_addCostCenter_Desc() {
		return hrbip_addCostCenter_Desc;
	}

	public void setHrbip_addCostCenter_Desc(String hrbip_addCostCenter_Desc) {
		this.hrbip_addCostCenter_Desc = hrbip_addCostCenter_Desc;
	}

	public String getHrbip_deleteCostCenter_Id() {
		return hrbip_deleteCostCenter_Id;
	}

	public void setHrbip_deleteCostCenter_Id(String hrbip_deleteCostCenter_Id) {
		this.hrbip_deleteCostCenter_Id = hrbip_deleteCostCenter_Id;
	}

	public String getHrbip_editMBO_Id() {
		return hrbip_editMBO_Id;
	}

	public void setHrbip_editMBO_Id(String hrbip_editMBO_Id) {
		this.hrbip_editMBO_Id = hrbip_editMBO_Id;
	}

	public String getHrbip_editMBO_Rate() {
		return hrbip_editMBO_Rate;
	}

	public void setHrbip_editMBO_Rate(String hrbip_editMBO_Rate) {
		this.hrbip_editMBO_Rate = hrbip_editMBO_Rate;
	}

	public String getHrbip_editMBO_PaidPeriod() {
		return hrbip_editMBO_PaidPeriod;
	}

	public void setHrbip_editMBO_PaidPeriod(String hrbip_editMBO_PaidPeriod) {
		this.hrbip_editMBO_PaidPeriod = hrbip_editMBO_PaidPeriod;
	}

	public String getHrbip_editMBO_Desc() {
		return hrbip_editMBO_Desc;
	}

	public void setHrbip_editMBO_Desc(String hrbip_editMBO_Desc) {
		this.hrbip_editMBO_Desc = hrbip_editMBO_Desc;
	}

	public String getHrbip_deleteMBO_Id() {
		return hrbip_deleteMBO_Id;
	}

	public void setHrbip_deleteMBO_Id(String hrbip_deleteMBO_Id) {
		this.hrbip_deleteMBO_Id = hrbip_deleteMBO_Id;
	}

	public String getHrbip_addMBO_Rate() {
		return hrbip_addMBO_Rate;
	}

	public void setHrbip_addMBO_Rate(String hrbip_addMBO_Rate) {
		this.hrbip_addMBO_Rate = hrbip_addMBO_Rate;
	}

	public String getHrbip_addMBO_PaidPeriod() {
		return hrbip_addMBO_PaidPeriod;
	}

	public void setHrbip_addMBO_PaidPeriod(String hrbip_addMBO_PaidPeriod) {
		this.hrbip_addMBO_PaidPeriod = hrbip_addMBO_PaidPeriod;
	}

	public String getHrbip_addMBO_Desc() {
		return hrbip_addMBO_Desc;
	}

	public void setHrbip_addMBO_Desc(String hrbip_addMBO_Desc) {
		this.hrbip_addMBO_Desc = hrbip_addMBO_Desc;
	}

	public String getHrbip_editDepart_Id() {
		return hrbip_editDepart_Id;
	}

	public String getHrbip_editDepart_Manager() {
		return hrbip_editDepart_Manager;
	}

	public void setHrbip_editDepart_Manager(String hrbip_editDepart_Manager) {
		this.hrbip_editDepart_Manager = hrbip_editDepart_Manager;
	}

	public String getHrbip_addDepart_Manager() {
		return hrbip_addDepart_Manager;
	}

	public void setHrbip_addDepart_Manager(String hrbip_addDepart_Manager) {
		this.hrbip_addDepart_Manager = hrbip_addDepart_Manager;
	}

	public void setHrbip_editDepart_Id(String hrbip_editDepart_Id) {
		this.hrbip_editDepart_Id = hrbip_editDepart_Id;
	}

	public String getHrbip_editDepart_Name() {
		return hrbip_editDepart_Name;
	}

	public void setHrbip_editDepart_Name(String hrbip_editDepart_Name) {
		this.hrbip_editDepart_Name = hrbip_editDepart_Name;
	}

	public String getHrbip_editDepart_Desc() {
		return hrbip_editDepart_Desc;
	}

	public void setHrbip_editDepart_Desc(String hrbip_editDepart_Desc) {
		this.hrbip_editDepart_Desc = hrbip_editDepart_Desc;
	}

	public String getHrbip_addDepart_Name() {
		return hrbip_addDepart_Name;
	}

	public void setHrbip_addDepart_Name(String hrbip_addDepart_Name) {
		this.hrbip_addDepart_Name = hrbip_addDepart_Name;
	}

	public String getHrbip_addDepart_Desc() {
		return hrbip_addDepart_Desc;
	}

	public void setHrbip_addDepart_Desc(String hrbip_addDepart_Desc) {
		this.hrbip_addDepart_Desc = hrbip_addDepart_Desc;
	}

	public String getHrbip_deleteDepart_Id() {
		return hrbip_deleteDepart_Id;
	}

	public void setHrbip_deleteDepart_Id(String hrbip_deleteDepart_Id) {
		this.hrbip_deleteDepart_Id = hrbip_deleteDepart_Id;
	}

	public String getHrbip_deletePt_titleId() {
		return hrbip_deletePt_titleId;
	}

	public void setHrbip_deletePt_titleId(String hrbip_deletePt_titleId) {
		this.hrbip_deletePt_titleId = hrbip_deletePt_titleId;
	}

	public String getHrbip_editPt_titleId() {
		return hrbip_editPt_titleId;
	}

	public void setHrbip_editPt_titleId(String hrbip_editPt_titleId) {
		this.hrbip_editPt_titleId = hrbip_editPt_titleId;
	}

	public String getHrbip_editPt_titleName() {
		return hrbip_editPt_titleName;
	}

	public void setHrbip_editPt_titleName(String hrbip_editPt_titleName) {
		this.hrbip_editPt_titleName = hrbip_editPt_titleName;
	}

	public String getHrbip_editPt_desc() {
		return hrbip_editPt_desc;
	}

	public void setHrbip_editPt_desc(String hrbip_editPt_desc) {
		this.hrbip_editPt_desc = hrbip_editPt_desc;
	}

	public void setHrbip_savePt_titleName(String hrbip_savePt_titleName) {
		this.hrbip_savePt_titleName = hrbip_savePt_titleName;
	}

	public void setHrbip_savePt_desc(String hrbip_savePt_desc) {
		this.hrbip_savePt_desc = hrbip_savePt_desc;
	}

	public void setPositiontitleDAO(PositiontitleDAO positiontitleDAO) {
		this.positiontitleDAO = positiontitleDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public void setMboDAO(MboDAO mboDAO) {
		this.mboDAO = mboDAO;
	}

	public void setCostcenterDAO(CostcenterDAO costcenterDAO) {
		this.costcenterDAO = costcenterDAO;
	}

	public void setContracttypeDAO(ContracttypeDAO contracttypeDAO) {
		this.contracttypeDAO = contracttypeDAO;
	}

	public void setEmptypeDAO(EmptypeDAO emptypeDAO) {
		this.emptypeDAO = emptypeDAO;
	}

	public void setOperationFlag_tohbip(String operationFlag_tohbip) {
		this.operationFlag_tohbip = operationFlag_tohbip;
	}

	public void setVacationtypeDAO(VacationtypeDAO vacationtypeDAO) {
		this.vacationtypeDAO = vacationtypeDAO;
	}

	@Override
	public String execute() throws Exception {

		// TODO Auto-generated method stub
		Map<String, Object> session = getSession();
		// List<Positiontitle> positiontitleList = null;
		// List<Department> departmentList = null;
		// List<Mbo> mboList = null;
		// List<Costcenter> costcenterList = null;
		// List<Vacationtype> vacationtypeList = null;
		// List<Contracttype> contracttypeList = null;
		// List<Emptype> emptypeList = null;
		Date date = new Date();

		if (operationFlag_tohbip.trim().equals("savePositionTitle")) {
			// Add Position title
			Positiontitle pt = new Positiontitle();
			pt.setPositionTitleName(hrbip_savePt_titleName.trim());
			pt.setPositionTitleDesc(hrbip_savePt_desc.trim());
			pt.setCreateDate(new Timestamp(date.getTime()));

			positiontitleDAO.save(pt);

			return SUCCESS;
		} else if (operationFlag_tohbip.trim().equals("editPositionTitle")) {
			// Edit Position title
			Integer titleId = Integer.parseInt(hrbip_editPt_titleId.trim());
			Positiontitle pt = positiontitleDAO.findById(titleId);
			pt.setPositionTitleName(hrbip_editPt_titleName.trim());
			pt.setPositionTitleDesc(hrbip_editPt_desc.trim());

			positiontitleDAO.saveOrUpdate(pt);
			return SUCCESS;
		} else if (operationFlag_tohbip.trim().equals("deletePositionTitle")) {
			// Delete Position
			Integer titleId = Integer.parseInt(hrbip_deletePt_titleId.trim());
			Positiontitle pt = positiontitleDAO.findById(titleId);
			positiontitleDAO.delete(pt);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("addDepart")) {
			// Add Depart
			// System.out.println("addDepart....");
			// System.out.println("hrbip_addDepart_Manager: "
//					+ hrbip_addDepart_Manager);
			Department depart = new Department();

			Emp manager = empDAO
					.findByLoginName(hrbip_addDepart_Manager.trim());

			depart.setDepartName(hrbip_addDepart_Name.trim());
			depart.setDepartDesc(hrbip_addDepart_Desc.trim());
			depart.setCreateDate(new Timestamp(date.getTime()));
			depart.setEmp(manager);
			departmentDAO.save(depart);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("editDepart")) {
			// Edit Depart
			// System.out.println("editDepart...");
			Integer departId = Integer.parseInt(hrbip_editDepart_Id.trim());

			Department depart = departmentDAO.findById(departId);
			depart.setDepartName(hrbip_editDepart_Name.trim());
			depart.setDepartDesc(hrbip_editDepart_Desc.trim());

			Emp manager = empDAO.findByLoginName(hrbip_editDepart_Manager
					.trim());

			depart.setEmp(manager);

			departmentDAO.saveOrUpdate(depart);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("deleteDepart")) {
			// Edit Depart
			Integer departId = Integer.parseInt(hrbip_deleteDepart_Id.trim());
			Department depart = departmentDAO.findById(departId);
			departmentDAO.delete(depart);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("editMBO")) {
			// Edit MBO
			// System.out.println("editMBO...");
			Integer mboId = Integer.parseInt(hrbip_editMBO_Id.trim());

			Mbo mbo = mboDAO.findById(mboId);
			mbo.setMboRate(Double.parseDouble(hrbip_editMBO_Rate.trim()));
			mbo.setMboPaidPeriod(Integer.parseInt(hrbip_editMBO_PaidPeriod
					.trim()));
			mbo.setMboDesc(hrbip_editMBO_Desc.trim());

			mboDAO.saveOrUpdate(mbo);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("deleteMBO")) {
			// Delete MBO
			// System.out.println("deleteMBO...");
			Integer mboId = Integer.parseInt(hrbip_deleteMBO_Id.trim());

			Mbo mbo = mboDAO.findById(mboId);
			mboDAO.delete(mbo);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("addMBO")) {
			// Add MBO
			// System.out.println("addMBO...");

			// System.out.println("hrbip_addMBO_PaidPeriod.trim(): " + hrbip_addMBO_PaidPeriod.trim());
			
			Mbo mbo = new Mbo();
			mbo.setMboRate(Double.parseDouble(hrbip_addMBO_Rate.trim()));
			mbo.setMboPaidPeriod(Integer.parseInt(hrbip_addMBO_PaidPeriod.trim()));
			mbo.setMboDesc(hrbip_addMBO_Desc.trim());

			mboDAO.saveOrUpdate(mbo);

			return SUCCESS;
		} else if (operationFlag_tohbip.trim().equals("editCostCenter")) {
			// Edit Cost Center
			// System.out.println("editCostCenter...");
			Integer ccId = Integer.parseInt(hrbip_editCostCenter_Id.trim());
			Costcenter cc = costcenterDAO.findById(ccId);
			cc.setCostCenterName(hrbip_editCostCenter_Name.trim());
			cc.setCostCenterParent(hrbip_editCostCenter_Parent.trim());
			cc.setCostCenterOwner(hrbip_editCostCenter_Owner.trim());
			cc.setCostCenterDesc(hrbip_editCostCenter_Description.trim());

			costcenterDAO.saveOrUpdate(cc);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("deleteCostCenter")) {
			// Delete Cost Center
			// System.out.println("deleteCostCenter...");
			Integer ccId = Integer.parseInt(hrbip_deleteCostCenter_Id.trim());

			Costcenter cc = costcenterDAO.findById(ccId);

			costcenterDAO.delete(cc);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("addCostCenter")) {
			// Add Cost Center
			// System.out.println("addCostCenter...");

			Costcenter cc = new Costcenter();
			cc.setCostCenterName(hrbip_addCostCenter_Name.trim());
			cc.setCostCenterParent(hrbip_addCostCenter_Parent.trim());
			cc.setCostCenterOwner(hrbip_addCostCenter_Owner.trim());
			cc.setCostCenterDesc(hrbip_addCostCenter_Desc.trim());

			costcenterDAO.saveOrUpdate(cc);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("editVacation")) {
			// Edit Vacation
			// System.out.println("editVacation...");
			Integer vtId = Integer.parseInt(hrbip_editVacation_Id.trim());
			Integer tsId = Integer.parseInt(hrbip_editVacation_TsId.trim());
			Vacationtype vt = vacationtypeDAO.findById(vtId);

			vt.setVacationTypeName(hrbip_editVacation_Name.trim());
			vt.setTimeSheetOrderId(tsId);
			vt.setVacationPaidRate(Double
					.parseDouble(hrbip_editVacation_PaidRate.trim()));
			vt.setVacationTypeDesc(hrbip_editVacation_Desc.trim());

			vacationtypeDAO.saveOrUpdate(vt);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("deleteVacation")) {
			// Delete Vacation
			// System.out.println("deleteVacation...");
			Integer vtId = Integer.parseInt(hrbip_deleteVacation_Id.trim());

			Vacationtype vt = vacationtypeDAO.findById(vtId);

			vacationtypeDAO.delete(vt);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("addVacation")) {
			// Add Vacation
			// System.out.println("addVacation...");

			Vacationtype vt = new Vacationtype();
			vt.setVacationTypeName(hrbip_addVacation_Name.trim());
			vt.setTimeSheetOrderId(Integer.parseInt(hrbip_addVacation_TsId
					.trim()));
			vt.setVacationPaidRate(Double
					.parseDouble(hrbip_addVacation_PaidRate.trim()));
			vt.setVacationTypeDesc(hrbip_addVacation_Desc.trim());

			vacationtypeDAO.save(vt);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("editContractType")) {
			// Edit Contract Type
			// System.out.println("editContractType...");
			Integer ctId = Integer.parseInt(hrbip_editContractType_Id.trim());

			Contracttype ct = contracttypeDAO.findById(ctId);

			ct.setContractTypeName(hrbip_editContractType_Name.trim());
			ct.setContractTypeDesc(hrbip_editContractType_Desc.trim());

			contracttypeDAO.saveOrUpdate(ct);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("deleteContractType")) {
			// Delete Contract
			// System.out.println("deleteContractType...");
			Integer ctId = Integer.parseInt(hrbip_deleteContractType_Id.trim());

			Contracttype ct = contracttypeDAO.findById(ctId);

			contracttypeDAO.delete(ct);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("addContractType")) {
			// Add Contracy
			// System.out.println("addContractType...");

			Contracttype ct = new Contracttype();
			ct.setContractTypeName(hrbip_addContractType_Name.trim());
			ct.setContractTypeDesc(hrbip_addContractType_Desc.trim());

			contracttypeDAO.saveOrUpdate(ct);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("editEmpType")) {
			// Edit Emp Type
			// System.out.println("editEmpType...");
			
			Integer etId = Integer.parseInt(hrbip_editEmpType_Id.trim());
			Emptype et = emptypeDAO.findById(etId);
			
			et.setEmpTypeName(hrbip_editEmpType_Name.trim());
			et.setEmpTypeDesc(hrbip_editEmpType_Desc.trim());
			
			emptypeDAO.saveOrUpdate(et);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("deleteEmpType")) {
			// Delete Emp Type
			// System.out.println("deleteEmpType...");
			
			Integer etId = Integer.parseInt(hrbip_deleteEmpType_Id.trim());
			
			Emptype et = emptypeDAO.findById(etId);
			
			emptypeDAO.delete(et);

			return SUCCESS;

		} else if (operationFlag_tohbip.trim().equals("addEmpType")) {
			// Add Emp Type
			// System.out.println("addEmpType...");

			Emptype et = new Emptype();
			et.setEmpTypeName(hrbip_addEmpType_Name.trim());
			et.setEmpTypeDesc(hrbip_addEmpType_Desc.trim());
			
			emptypeDAO.saveOrUpdate(et);

			return SUCCESS;

		}

		return SUCCESS;
	}

}
