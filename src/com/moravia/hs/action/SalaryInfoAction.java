package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.AbsenceinfoviewDAO;
import com.moravia.hs.base.dao.BaseincomtaxDAO;
import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.BasesocialinsuranceDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.EmpchangerecordDAO;
import com.moravia.hs.base.dao.MboDAO;
import com.moravia.hs.base.dao.OvertimeinfoviewDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.dao.SalaryviewDAO;
import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Baseincomtax;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Basesocialinsurance;
import com.moravia.hs.base.entity.Department;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Mbo;
import com.moravia.hs.base.entity.Payrollrecord;
import com.moravia.hs.base.entity.Vacationtype;
import com.moravia.hs.base.entity.other.TsInfoGroupByOrderId;
import com.moravia.hs.base.entity.other.TsMonthlyAbsenceInfo;
import com.moravia.hs.base.entity.view.Overtimeinfoview;
import com.moravia.hs.base.entity.view.Salaryview;

@Controller("salaryInfoAction")
public class SalaryInfoAction extends BaseAction {
//	private String loginName;
	
	private String empLoginId;
	
	@Resource(name = "timesheetDAO")
	private TimesheetDAO timesheetDAO;
	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;
	@Resource(name = "baseincomtaxDAO")
	private BaseincomtaxDAO baseincomtaxDAO;
	@Resource(name = "basesocialinsuranceDAO")
	private BasesocialinsuranceDAO basesocialinsuranceDAO;
	@Resource(name = "vacationtypeDAO")
	private VacationtypeDAO vacationtypeDAO;
	@Resource(name = "salaryviewDAO")
	private SalaryviewDAO salaryviewDAO;
	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO; 
	@Resource(name = "empchangerecordDAO")
	private EmpchangerecordDAO empchangerecordDAO;
	@Resource(name = "mboDAO")
	private MboDAO mboDAO;
	@Autowired
	private OvertimeinfoviewDAO overtimeinfoviewDAO;
	@Autowired
	private AbsenceinfoviewDAO absenceinfoviewDAO;
	
	/*public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}*/
	
	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}
	
	public String getEmpLoginId() {
		return empLoginId;
	}
	
	
	List<Integer> unPaidOrderIdList = new ArrayList<Integer>(); // 不支付工资的timesheet OrderId号，
	
	
	Double monthlyTotalHrs = 0.0; // 每月timesheet总小时数
	Double monthlyPaidHrs = 0.0; // 每月有偿timesheet总小时数
	Double monthlyOverTimeHrs = 0.0; // 每月加班小时数
	
	Integer monthlyTsDays = 0; // 每月timesheet总的填写天数
	Integer absenceMoreThan4HrsDays = 0; // 请假超过4小时的天数 -- 计算餐补
	Integer absenceMoreThan8HrsDays = 0; // 请假超过8小时的天数 -- 计算交通补贴
	Integer overtimeMoreThan11HrsDays = 0; // 一天timesheet超过11小时的天数 -- 计算餐补
	String startDate = ""; // 开始日期
	String endDate = ""; // 结束日期
	
	
	Double monthlyBaseSalary = 0.0; //月基本工资
	Double quarterlyBonus = 0.0;    //季度奖金
//	Double postAllowance = 0.0; 	//岗位津贴
	Double mealSubsidy = 0.0; // 午餐补贴
	Double transAllowance = 0.0; // 交通补贴
	Double overTimePay = 0.0;	//加班费
	Double incomTax = 0.0;
	
	Double socialInsurBase = 0.0; // 社保基数
	Double mboRate = 0.0;	//MBO Rate
	Integer mboPaidPeriod = 0; //MBO Paid Period
	String sip_departmentName = ""; //部门名称
	
	Double pension_Personal = 0.0; // 养老保险(个人)
	Double pension_Company = 0.0; // 养老保险(公司)
	Double medical_Personal = 0.0; // 医疗保险(个人)
	Double medical_Company = 0.0; // 医疗保险(公司)
	Double accum_Fund_Personal = 0.0; // 公积金(个人)
	Double accum_Fund_Company = 0.0; // 公积金(公司)
	Double unemp_Insu_Personal = 0.0; // 失业保险(个人)
	Double unemp_Insu_Company = 0.0; // 失业保险(公司)
	Double occupInjure_Personal = 0.0; // 工伤保险(个人)
	Double occupInjure_Company = 0.0; // 工伤保险(公司)
	Double maternity_Personal = 0.0; // 生育保险(个人)
	Double maternity_Company = 0.0; // 生育保险(公司)

	//Portion Related
	//分摊到每个月的季度奖金
	Double sip_mboPortion = 0.0;
	//分摊到每个月的年终奖金
	Double sip_annuBonusPortion = 0.0;
	
	public String salaryCalculate() {
		//get Session
		System.out.println("进入salaryInfoAction...");
		Map<String, Object> session = getSession();
		DecimalFormat df = new DecimalFormat("#.00");  //四舍五入保留2位
//		DecimalFormat df0 = new DecimalFormat("#.0");  //四舍五入保留1位
		
		//基本基数
		Basesalaryproperties bsp = basesalarypropertiesDAO.findLastCreated();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startDate = sdf.format(bsp.getStartDate());
		endDate = sdf.format(bsp.getEndDate());
		
		
		//员工个人信息薪资部分
		Salaryview sv = salaryviewDAO.findByLoginName(empLoginId);
		if(sv == null) {
			return ERROR;
		}
		Emp emp = empDAO.findById(sv.getEmpId());
		
		if(emp == null) {
			return ERROR;
		}
		
		
		//Timesheet信息(按照OrderId分类)
		List<TsInfoGroupByOrderId> TsInfoList = null;
		try {
			TsInfoList = timesheetDAO.findTsInfoGroupByOrderId(empLoginId, startDate, endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//timesheet每月请假信息
		List<TsMonthlyAbsenceInfo> tsMonthlyAbsenceInfoList = null;
		try {
			tsMonthlyAbsenceInfoList = timesheetDAO.findTsMonthlyAbsenceInfo(empLoginId, startDate, endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//假期类型
		List<Vacationtype> vacationtypeList = vacationtypeDAO.findAll();
		
		//个税税率
		List<Baseincomtax> baseIncomTaxList = baseincomtaxDAO.findAll();
		
		//社保基数
		List<Basesocialinsurance> baseSocialInsuranceList = basesocialinsuranceDAO.findAll();
		
		//&得到Unpaid OrderId
		for (Vacationtype vt : vacationtypeList) {
			if(vt.getVacationPaidRate() == 0) {
				unPaidOrderIdList.add(vt.getTimeSheetOrderId());
			}
		}
		
		//&计算需要支付工资的小时数
		monthlyPaidHrs = 0.0;
		monthlyTotalHrs = 0.0;
		for (TsInfoGroupByOrderId tig : TsInfoList) {
			if(!unPaidOrderIdList.contains(tig.getOrderId())) {
				monthlyPaidHrs += tig.getSumDiff();
			}
			monthlyTotalHrs += tig.getSumDiff();
		}
		
		monthlyOverTimeHrs = 0.0;
		overTimePay = 0.0;
		
		Timestamp startTime = new Timestamp(bsp.getStartDate().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(bsp.getEndDate());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Timestamp endTime = new Timestamp(cal.getTime().getTime());
		
		
		
		// 加班信息
		List<Overtimeinfoview> overtimeInfos = overtimeinfoviewDAO.findByEmp(empLoginId, startTime, endTime, "Done");
		
		System.out.println("加班信息。。。");
		System.out.println("startTime.toString(): " + startTime.toString());
		System.out.println("endTime.toString(): " + endTime.toString());
		System.out.println(overtimeInfos.size());
		
		for (Overtimeinfoview or : overtimeInfos) {
			System.out.println(or.getEmploginid() + "\t" + or.getCostcenter() + "\t" + or.getHours());
		}
		
		System.out.println("加班信息结束。。。");
		
		//根据Validate确定基本工资/同理确定Social Insurance和 MBO
		Double emp_baseSalary = 0.0;
		Date baseSalaryValidate = emp.getBaseSalaryValidate();
		Date socialInsValidate = emp.getSocialInsurBaseValidate();
		Date mboValidate = emp.getMboValidate();
		
		/*
		 * EMP_BASESALARY
		 */
		if(baseSalaryValidate.compareTo(bsp.getStartDate()) < 0) {
			//emp_baseSalary为员工最新的基本工资
			emp_baseSalary = emp.getBaseSalary();
		} else if (baseSalaryValidate.compareTo(bsp.getStartDate()) >= 0 && baseSalaryValidate.compareTo(bsp.getEndDate()) <= 0) {
			//emp_baseSalary为员工最新的基本工资
			emp_baseSalary = emp.getBaseSalary();
		} else if (baseSalaryValidate.compareTo(bsp.getEndDate()) > 0){
			//从历史记录当中找到最新的基本工资记录
			emp_baseSalary = empchangerecordDAO.getLatestBaseSalary(emp.getEmpLoginId(), endDate);
			 System.out.println("Get emp_baseSalary by history, emp_baseSalary = " + emp_baseSalary);
			
			if(emp_baseSalary == null) {
				 System.out.println("There is no emp_baseSalary in empchangeRecord table for this employee.");
				emp_baseSalary = 0.0;
				session.put("globalError", "There is no emp_baseSalary in empchangeRecord table for this employee.");
				return ERROR;
			}
			
		}

		
		/*
		 * SOCIAL INSURANCE
		 */
		socialInsurBase = 0.0;
		if(socialInsValidate.compareTo(bsp.getStartDate()) < 0) {
			//socialInsurBase为员工最新的基本工资
			socialInsurBase = emp.getSocialInsurBase();
		} else if (socialInsValidate.compareTo(bsp.getStartDate()) >= 0 && socialInsValidate.compareTo(bsp.getEndDate()) <= 0) {
			//socialInsurBase为员工最新的基本工资
			socialInsurBase = emp.getSocialInsurBase();
		} else if (socialInsValidate.compareTo(bsp.getEndDate()) > 0){
			//从历史记录当中找到最新的基本工资记录
			socialInsurBase = empchangerecordDAO.getLatestSocialIns(emp.getEmpLoginId(), endDate);
			 System.out.println("Get socialInsurBase by history, socialInsurBase = " + socialInsurBase);
			
			if(socialInsurBase == null) {
				 System.out.println("There is no socialInsurBase in empchangeRecord table for this employee, please check.");
				socialInsurBase = 0.0;
			}
			
		}
		
		
		// 加班情况统计
		System.out.println("初始加班费: " + overTimePay);
		for (Overtimeinfoview oinfo : overtimeInfos) {
			monthlyOverTimeHrs += oinfo.getHours();	// 计算加班时间
			if(oinfo.getPaidRate() != null) {
				System.out.println("加班费率: " + oinfo.getPaidRate());
				// 加班费 += 加班时间 * 加班费率 / 100 * （基本工资 / 174）
				overTimePay += (oinfo.getHours() * oinfo.getPaidRate() / 100) * (emp_baseSalary / bsp.getBaseSalaryHrs());
			} else {
				session.put("globalError", "加班支付费率不存在...员工： " + empLoginId);
				return ERROR;
			}
		}
		System.out.println("计算完毕之后的加班费: " + overTimePay);
		
		if(monthlyOverTimeHrs != (monthlyTotalHrs - bsp.getTotalWorkHours())) {
			session.put("sip_overtimeNotMatchError", "TimeSheet 时间跟加班单时间不符。加班总时间为: " + monthlyOverTimeHrs + ", 而TimeSheet总时间为： " + monthlyTotalHrs + ", 比当月正常时间多了" + (monthlyTotalHrs - bsp.getTotalWorkHours()) + "小时。");
		}
		
		//加班费--TEMP
//		overTimePay = emp_baseSalary / bsp.getBaseSalaryHrs() * monthlyOverTimeHrs * 1.5;

		//月基本工资为： (个人基本工资/174) * (timesheet支付总小时数 - 加班小时数)
		monthlyBaseSalary = emp_baseSalary / bsp.getBaseSalaryHrs() * (monthlyPaidHrs - monthlyOverTimeHrs);
		
		/*
		 * MBO
		 */
		Mbo sip_mbo = null;
		if(mboValidate.compareTo(bsp.getStartDate()) < 0) {
			//sip_mbo为员工最新的基本工资
			sip_mbo = emp.getMbo();
		} else if (mboValidate.compareTo(bsp.getStartDate()) >= 0 && mboValidate.compareTo(bsp.getEndDate()) <= 0) {
			//sip_mbo为员工最新的基本工资
			sip_mbo = emp.getMbo();
		} else if (mboValidate.compareTo(bsp.getEndDate()) > 0){
			//从历史记录当中找到最新的基本工资记录
			Double rateNew = empchangerecordDAO.getLatestMBORate(emp.getEmpLoginId(), endDate);
			
			if(rateNew == null) {
				 System.out.println("There is no record for sip_mbo in empchangerecord table, please check.");
				/*
				 *This annotation should be removed here
				 *sip_mbo = null;
				 *return ERROR;
				 *
				 */
				sip_mbo = emp.getMbo();
				
			} else {
				sip_mbo =  mboDAO.findByMBORate(rateNew);
				 System.out.println("Get sip_mbo by history sip_mbo.Rate = " + sip_mbo.getMboRate());
			}
		}
		
		//There is no need to check paid period for mbo.
		/*switch (sip_mbo.getMboPaidPeriod()) {
			case 1:
				//MBO 为季度
				sip_mboPortion = sip_mbo.getMboRate() * emp_baseSalary / 3;
				break;
			case 2:
				//MBO 为年度
				sip_mboPortion = sip_mbo.getMboRate() * emp_baseSalary / 12;
				break;
			default:
				// System.out.println("MBO Paid Period is not 1 or 2");
				return ERROR;
			}*/
		
		//分摊到每个月的季度奖金（与174等基本参数无关，直接用 MBO * BaseSalary）
		sip_mboPortion = sip_mbo.getMboRate() / 100 * emp_baseSalary;
		// System.out.println("Calculated sip_mboPortion is: " + sip_mboPortion);
		// System.out.println("sip_mboPortion in salary info action is : " + sip_mboPortion);
		//分摊到每个月的年终奖金（直接用 BaseSalary / 12）
		sip_annuBonusPortion = emp_baseSalary / 12;
		// System.out.println("Calculated sip_annuBonusPortion is: " + sip_annuBonusPortion);
		
		if(sip_mbo != null) {
			mboRate = sip_mbo.getMboRate();
			mboPaidPeriod = sip_mbo.getMboPaidPeriod();
//			if(mboPaidPeriod == 1) {
//				quarterlyBonus = sip_mbo.getMboRate() * emp_baseSalary * 1;
//			}
//			if(mboPaidPeriod == 2) {
//				quarterlyBonus = sip_mbo.getMboRate() * emp_baseSalary * 3;
//			}
//			if(mboPaidPeriod == 3) {
//				quarterlyBonus = sip_mbo.getMboRate() * emp_baseSalary * 12;
//			}
		} else {
			mboRate = 0.0;
			// System.out.println("Set the mbo rate is 0.0");
		}
		Department sip_department = emp.getDepartment();
		if(sip_department != null) {
			sip_departmentName = sip_department.getDepartName();
		}
		
		//午餐补贴为： （timesheet总工作天数(包括加班) - 一天请假超过4小时的天数 + 一天工作超过11小时的天数 ） * 15
		// 一天请假超过4小时的天数
		absenceMoreThan4HrsDays = 0;
		absenceMoreThan8HrsDays = 0;
		for (TsMonthlyAbsenceInfo tma : tsMonthlyAbsenceInfoList) {
			if(tma.getSumDiff() > 4) {
				absenceMoreThan4HrsDays++;
			} 
			if (tma.getSumDiff() >= 8) {
				absenceMoreThan8HrsDays++;
			}
		}
//// System.out.println("absenceMoreThan8HrsDays: " + absenceMoreThan8HrsDays);
//一天timesheet超过11小时的天数
		try {
			overtimeMoreThan11HrsDays = timesheetDAO.findTsMonthlyOvertimeMoreThan11Hrs(empLoginId, startDate, endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		// System.out.println("一天请假超过4小时的天数: " + absenceMoreThan4HrsDays + "\t" + "一天timesheet超过11小时的天数: " + overtimeMoreThan11HrsDays);
		
		//timesheet每月总填写天数：
		try {
			monthlyTsDays = timesheetDAO.findTsMonthlyDays(empLoginId, startDate, endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mealSubsidy = (monthlyTsDays - absenceMoreThan4HrsDays + overtimeMoreThan11HrsDays) * bsp.getDailyMealSubsidy();
//		// System.out.println("餐补为：" + mealSubsidy);
		
		//交通补贴为：(100 / 月正常工作天数) * (月timesheet填写天数 - 一天中请假为8小时的天数);
//		// System.out.println("bsp.getMonthlyTransAllowance(): " + bsp.getMonthlyTransAllowance() + "\t" + bsp.getTotalWorkDays());
		transAllowance = (bsp.getMonthlyTransAllowance() / bsp.getTotalWorkDays()) * (monthlyTsDays - absenceMoreThan8HrsDays);
		
//		// System.out.println("交通补贴为： " + df.format(transAllowance));
		
		//五险一金
		for (Basesocialinsurance bsi : baseSocialInsuranceList) {
			if(bsi.getBsiName().equalsIgnoreCase("Pension_Personal")) {
				pension_Personal = socialInsurBase * bsi.getBsiRate() / 100  + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Pension_Company")) {
				pension_Company = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Medical_Personal")) {
				medical_Personal = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Medical_Company")) {
				medical_Company = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Accum_Fund_Personal")) {
				accum_Fund_Personal = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Accum_Fund_Company")) {
				accum_Fund_Company = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Unemp_Insu_Personal")) {
				unemp_Insu_Personal = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Unemp_Insu_Company")) {
				unemp_Insu_Company = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("OccupInjure_Personal")) {
				occupInjure_Personal = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("OccupInjure_Company")) {
				occupInjure_Company = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Maternity_Personal")) {
				maternity_Personal = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Maternity_Company")) {
				maternity_Company = socialInsurBase * bsi.getBsiRate() / 100 + bsi.getBsiAdditional();
			}
		}
		
		session.put("Emp", emp);	//员工信息
		session.put("sip_positiontitle", emp.getPositiontitle().getPositionTitleName());
		session.put("sip_mbo", mboRate);
		session.put("sip_department", sip_departmentName);
		
		//个税计算 (工资 + 奖金 + 补贴 + 加班费 - 五险一金(个人) - 3500) 再税率计算  
		double incomBase = (monthlyBaseSalary + quarterlyBonus + transAllowance + mealSubsidy + overTimePay) - (pension_Personal + medical_Personal + accum_Fund_Personal + unemp_Insu_Personal - maternity_Personal - occupInjure_Personal);
		//岗位津贴，奖励和Adjustment一开始是没有的，不需要带入incomBase计算
		double threshold = bsp.getIncomtaxThreshold(); 
		double figure = incomBase - threshold;
		incomTax = 0.0;
		Collections.reverse(baseIncomTaxList);
		for (Baseincomtax baseincomtax : baseIncomTaxList) {
			if(figure > baseincomtax.getIncomtaxValue()) {
				incomTax += (figure - baseincomtax.getIncomtaxValue()) * baseincomtax.getIncomtaxRate() / 100;
				figure = baseincomtax.getIncomtaxValue();
			}
		}
		
		/*List<Double> incomTaxListNumberic = new ArrayList<Double>();
		for (Baseincomtax baseincomtax : baseIncomTaxList) {
			incomTaxListNumberic.add(baseincomtax.get)
		}
		*/
		session.put("startDate", startDate); //开始日期
		session.put("endDate", endDate);	//结束日期
		session.put("sip_baseIncomTaxList", baseIncomTaxList);  //Base Income Tax List
		
		session.put("tsInfoList", TsInfoList);	//timesheet info
		
		session.put("sip_monthlyTotalHrs", monthlyTotalHrs);	//timesheet总小时数
//		// System.out.println("sip_monthlyTotalHrs: " + monthlyTotalHrs);
		
		session.put("sip_Year", startDate.substring(0, 4));	//年
		session.put("sip_Month", startDate.substring(5, 7)); //月
		
		Payrollrecord pr = payrollrecordDAO.findByEmpAndDate(emp.getEmpLoginId(), startDate, endDate);
		//Payrollrecord 不为空的情况下，说明之前有确认并且保存过工资信息。
		if(pr != null) {
			// System.out.println("payrollrecord is not null....");
			// 如果存在历史记录，那么筛选出符合历史记录的以下信息
			session.put("sip_emp_baseSalary", emp_baseSalary); // 历史记录的合同基本工资
			session.put("sip_emp_socialInsBase", socialInsurBase); // 历史记录的socialInsurBase
//			session.put("sip_emp_mboRate", sip_mbo.getMboRate()); // 历史记录的mbo rate
			 
			session.put("sip_payrollId", pr.getPayrollId()); //PayrollID
			// System.out.println("pr.getPayrollId(): " + pr.getPayrollId());
			 
			session.put("sip_monthlyPaidHrs", pr.getTotalWorkHrs());	// 每月有偿timesheet总小时数
			session.put("sip_monthlyOverTimeHrs", pr.getOvertime());	//每月加班时间
			
			session.put("sip_monthlyBaseSalary", pr.getBaseSalary());	//月基本工资
			session.put("sip_quarterlyBonus", pr.getQuartBonus());	//季度奖金
			session.put("sip_postAllowance", pr.getPostAllowance());  //岗位津贴
			session.put("sip_Bonus", pr.getBonus());  //奖励
			session.put("sip_transAllowance", pr.getTransportAllowance());	//交通津贴
			session.put("sip_mealSubsidy", pr.getMealSubsidy());	//餐补
			session.put("sip_overTimePay", pr.getOvertimePay());	//加班费
			session.put("sip_otherPay", pr.getOtherPay());	//调整
			session.put("sip_otherPayNote", pr.getPayrollNote());	//调整说明
			
			session.put("pension_Personal", pr.getPensionPersonal());	// 养老保险(个人)
			session.put("pension_Company", pr.getPensionCompany());	// 养老保险(公司)
			session.put("medical_Personal", pr.getMedicalPersonal());	// 医疗保险(个人)
			session.put("medical_Company", pr.getMedicalCompany());	// 医疗保险(公司)
			session.put("accum_Fund_Personal", pr.getAccumFundPersonal());	 // 公积金(个人)
			session.put("accum_Fund_Company", pr.getAccumFundCompany());	// 公积金(公司)
			session.put("unemp_Insu_Personal", pr.getUnempInsuPersonal());	// 失业保险(个人)
			session.put("unemp_Insu_Company", pr.getUnempInsuCompany());	// 失业保险(公司)
			session.put("occupInjure_maternity_Company", pr.getOccupInjureMaternity());		// 工伤生育保险(公司)
			session.put("sip_incomtax",pr.getIncomeTax()); //个税
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			session.put("payrollCreateDate", sdf2.format(pr.getCreateDate()));  //Payroll 创建日期
			
			//Portion Related
			session.put("sip_mboPortion", pr.getMboMonthlyPortion());
			session.put("sip_annuBonusPortion", pr.getAnnualBonusMonthlyPortion());
			
			// System.out.println("payrollCreateDate:  " + sdf2.format(pr.getCreateDate()));
			
			 // System.out.println("return success");
			 return SUCCESS;
			 
		} else {
			// System.out.println("payrollrecord is null....");
			// 如果存在历史记录，那么筛选出符合历史记录的以下信息
			session.put("sip_emp_baseSalary", emp_baseSalary); // 历史记录的合同基本工资
			session.put("sip_emp_socialInsBase", socialInsurBase); // 历史记录的socialInsurBase
//			session.put("sip_emp_mboRate", sip_mbo.getMboRate()); // 历史记录的mbo rate
			
			
			session.put("sip_payrollId", 0); //PayrollID设置为 0
			
			session.put("sip_monthlyPaidHrs", monthlyPaidHrs);	// 每月有偿timesheet总小时数
			session.put("sip_monthlyOverTimeHrs", monthlyOverTimeHrs);	//每月加班时间
			
			session.put("sip_monthlyBaseSalary", Double.parseDouble(df.format(monthlyBaseSalary)));	//月基本工资
			session.put("sip_quarterlyBonus", 0);	//季度奖金
			session.put("sip_postAllowance", 0);  //岗位津贴
			session.put("sip_Bonus", 0);  //奖励
			session.put("sip_transAllowance", Double.parseDouble(df.format(transAllowance)));	//交通津贴
			session.put("sip_mealSubsidy", Double.parseDouble(df.format(mealSubsidy)));	//餐补
			session.put("sip_overTimePay", Double.parseDouble(df.format(overTimePay)));	//加班费
			session.put("sip_otherPay", 0);	//调整 设置为空
			session.put("sip_otherPayNote", "");	//调整说明 设置为空
			
			session.put("pension_Personal", Double.parseDouble(df.format(pension_Personal)));	// 养老保险(个人)
			session.put("pension_Company", Double.parseDouble(df.format(pension_Company)));	// 养老保险(公司)
			session.put("medical_Personal", Double.parseDouble(df.format(medical_Personal)));	// 医疗保险(个人)
			session.put("medical_Company", Double.parseDouble(df.format(medical_Company)));	// 医疗保险(公司)
			session.put("accum_Fund_Personal", Double.parseDouble(df.format(accum_Fund_Personal)));	 // 公积金(个人)
			session.put("accum_Fund_Company", Double.parseDouble(df.format(accum_Fund_Company)));	// 公积金(公司)
			session.put("unemp_Insu_Personal", Double.parseDouble(df.format(unemp_Insu_Personal)));	// 失业保险(个人)
			session.put("unemp_Insu_Company", Double.parseDouble(df.format(unemp_Insu_Company)));	// 失业保险(公司)
//			session.put("occupInjure_Personal", df.format(occupInjure_Personal));	// 工伤保险(个人)
//			session.put("occupInjure_Company", df.format(occupInjure_Company));	// 工伤保险(公司)
//			session.put("maternity_Personal", df.format(maternity_Personal));	// 生育保险(个人)
			session.put("occupInjure_maternity_Company", df.format(maternity_Company + occupInjure_Company));		// 工伤生育保险(公司)
			
			//Portion Related
			session.put("sip_mboPortion", df.format(sip_mboPortion));
			session.put("sip_annuBonusPortion", df.format(sip_annuBonusPortion));
			
			if(incomTax > 0) {
				session.put("sip_incomtax", df.format(incomTax));
			} else {
				session.put("sip_incomtax", df.format(incomTax));
			}
			
		}
		
		System.out.println("salaryInfoAction结束...");
		
		return SUCCESS;
	}

}
