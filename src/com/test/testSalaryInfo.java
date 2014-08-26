package com.test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moravia.hs.base.dao.BaseincomtaxDAO;
import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.BasesocialinsuranceDAO;
import com.moravia.hs.base.dao.SalaryviewDAO;
import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Baseincomtax;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Basesocialinsurance;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Vacationtype;
import com.moravia.hs.base.entity.other.TsInfoGroupByOrderId;
import com.moravia.hs.base.entity.other.TsMonthlyAbsenceInfo;
import com.moravia.hs.base.entity.view.Salaryview;

public class testSalaryInfo {
	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TimesheetDAO timesheetDAO = (TimesheetDAO)context.getBean("timesheetDAO");
		BasesalarypropertiesDAO basesalarypropertiesDAO = (BasesalarypropertiesDAO)context.getBean("basesalarypropertiesDAO");
		BaseincomtaxDAO baseincomtaxDAO = (BaseincomtaxDAO)context.getBean("baseincomtaxDAO");
		BasesocialinsuranceDAO basesocialinsuranceDAO = (BasesocialinsuranceDAO)context.getBean("basesocialinsuranceDAO");
		VacationtypeDAO vacationtypeDAO = (VacationtypeDAO)context.getBean("vacationtypeDAO");
		SalaryviewDAO salaryviewDAO = (SalaryviewDAO) context.getBean("salaryviewDAO");
		
		List<Integer> unPaidOrderIdList = new ArrayList<Integer>(); // 不支付工资的timesheet OrderId号， 如：70
		String loginName = "jennifers";
		Double monthlyTotalHrs = 0.0; //每月timesheet总小时数
		Double monthlyPaidHrs = 0.0; //每月有偿timesheet总小时数
		Double monthlyOverTimeHrs = 0.0; //每月加班小时数
		Integer monthlyTsDays = 0; //每月timesheet总的填写天数
		Integer absenceMoreThan4HrsDays = 0; //请假超过4小时的天数 -- 计算餐补
		Integer absenceMoreThan8HrsDays = 0; //请假超过8小时的天数 -- 计算交通补贴
		Integer overtimeMoreThan11HrsDays = 0; //一天timesheet超过11小时的天数  -- 计算餐补
		String startDate = ""; //开始日期
		String endDate = "";	//结束日期
		Double mealSubsidy = 0.0; //午餐补贴
		Double transAllowance = 0.0; //交通补贴
		
		Double socialInsurBase = 0.0; //社保基数
		
		Double	pension_Personal	=	0.0	;	//	养老保险(个人)
		Double	pension_Company	=	0.0	;	//	养老保险(公司)
		Double	medical_Personal	=	0.0	;	//	医疗保险(个人)
		Double	medical_Company	=	0.0	;	//	医疗保险(公司)
		Double	accum_Fund_Personal	=	0.0	;	//	公积金(个人)
		Double	accum_Fund_Company	=	0.0	;	//	公积金(公司)
		Double	unemp_Insu_Personal	=	0.0	;	//	失业保险(个人)
		Double	unemp_Insu_Company	=	0.0	;	//	失业保险(公司)
		Double	occupInjure_Personal	=	0.0	;	//	工伤保险(个人)
		Double	occupInjure_Company	=	0.0	;	//	工伤保险(公司)
		Double	maternity_Personal	=	0.0	;	//	生育保险(个人)
		Double	maternity_Company	=	0.0	;	//	生育保险(公司)



		
		
		
		//基本基数
		Basesalaryproperties bsp = basesalarypropertiesDAO.findLastCreated();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startDate = sdf.format(bsp.getStartDate());
		endDate = sdf.format(bsp.getEndDate());
		
		//员工个人信息薪资部分
		Salaryview sv = salaryviewDAO.findByLoginName(loginName);
		
		
		System.out.println("startDate: " + startDate + "\tendDate: " + endDate);
		
		//Timesheet信息(按照OrderId分类)
		List<TsInfoGroupByOrderId> TsInfoList = timesheetDAO.findTsInfoGroupByOrderId(loginName, startDate, endDate);
		System.out.println(TsInfoList.size());
		for (TsInfoGroupByOrderId tsInfoGroupByOrderId : TsInfoList) {
			System.out.println(tsInfoGroupByOrderId.getLoginName() + "\t" + tsInfoGroupByOrderId.getOrderId() + "\t" + tsInfoGroupByOrderId.getSumDiff());
		}
		
		//timesheet每月总填写天数：
		monthlyTsDays = timesheetDAO.findTsMonthlyDays(loginName, startDate, endDate);
		System.out.println("timesheet填写天数： " + monthlyTsDays);
		
		//timesheet每月请假信息
		List<TsMonthlyAbsenceInfo> tsMonthlyAbsenceInfoList = timesheetDAO.findTsMonthlyAbsenceInfo(loginName, startDate, endDate);
		for (TsMonthlyAbsenceInfo tsMonthlyAbsenceInfo : tsMonthlyAbsenceInfoList) {
			System.out.println(tsMonthlyAbsenceInfo.getDate() + "\t" + tsMonthlyAbsenceInfo.getOrderId() + "\t" + tsMonthlyAbsenceInfo.getSumDiff());
		}
		
		
		//假期类型
		List<Vacationtype> vacationtypeList = vacationtypeDAO.findAll();
		/*for (Vacationtype vacationtype : vacationtypeList) {
			System.out.println(vacationtype.getVacationTypeName() + "\t" + vacationtype.getVacationPaidRate());
		}*/

		//个税税率
		List<Baseincomtax> baseIncomTaxList = baseincomtaxDAO.findAll();
		
		/*for (Baseincomtax baseincomtax : baseIncomTaxList) {
			System.out.println(baseincomtax.getIncomtaxValue() + "\t" + baseincomtax.getIncomtaxRate());
		}*/
		
		//社保基数
		List<Basesocialinsurance> baseSocialInsuranceList = basesocialinsuranceDAO.findAll();
		/*for (Basesocialinsurance basesocialinsurance : baseSocialInsuranceList) {
			System.out.println(basesocialinsurance.getBsiName() + "\t" + basesocialinsurance.getBsiRate() + "\t" + basesocialinsurance.getBsiAdditional());
		}*/
		
		
		//&得到Unpaid OrderId
		for (Vacationtype vt : vacationtypeList) {
			if(vt.getVacationPaidRate() == 0) {
				unPaidOrderIdList.add(vt.getTimeSheetOrderId());
			}
		}
		
		//&计算需要支付工资的小时数
		for (TsInfoGroupByOrderId tig : TsInfoList) {
			if(!unPaidOrderIdList.contains(tig.getOrderId())) {
				monthlyPaidHrs += tig.getSumDiff();
			}
			monthlyTotalHrs += tig.getSumDiff();
		}
		
		if(monthlyTotalHrs - bsp.getTotalWorkHours() > 0) {
			monthlyOverTimeHrs = monthlyTotalHrs - bsp.getTotalWorkHours(); //加班小时数 = timesheet总小时数 - 正常工作小时数;
		}
		
		DecimalFormat df = new DecimalFormat("#.00");  //四舍五入
		
		System.out.println("monthlyPaidHrs: " + monthlyPaidHrs + "  monthlyTotalHrs: " + monthlyTotalHrs +  "  monthlyOverTimeHrs: " + (monthlyTotalHrs - bsp.getTotalWorkHours()));
		
		//月基本工资为： (个人基本工资/174) * (timesheet支付总小时数 - 加班小时数)
		System.out.println("月基本工资为：" + df.format(sv.getBaseSalary() / bsp.getBaseSalaryHrs() * (monthlyPaidHrs - monthlyOverTimeHrs)));
		
		
		//**MBO**
		
		
		//午餐补贴为： （timesheet总工作天数(包括加班) - 一天请假超过4小时的天数 + 一天工作超过11小时的天数 ） * 15
		// 一天请假超过4小时的天数
		for (TsMonthlyAbsenceInfo tma : tsMonthlyAbsenceInfoList) {
			if(tma.getSumDiff() > 4) {
				absenceMoreThan4HrsDays++;
			} 
			if (tma.getSumDiff() >= 8) {
				absenceMoreThan8HrsDays++;
			}
		}
		
		System.out.println("absenceMoreThan8HrsDays: " + absenceMoreThan8HrsDays);
		
		//一天timesheet超过11小时的天数
		overtimeMoreThan11HrsDays = timesheetDAO.findTsMonthlyOvertimeMoreThan11Hrs(loginName, startDate, endDate);
	
		System.out.println("一天请假超过4小时的天数: " + absenceMoreThan4HrsDays + "\t" + "一天timesheet超过11小时的天数: " + overtimeMoreThan11HrsDays);
		
		mealSubsidy = (monthlyTsDays - absenceMoreThan4HrsDays + overtimeMoreThan11HrsDays) * bsp.getDailyMealSubsidy();
		System.out.println("餐补为：" + mealSubsidy);
		
		//交通补贴为：(100 / 月正常工作天数) * (月timesheet填写天数 - 一天中请假为8小时的天数);
		System.out.println("bsp.getMonthlyTransAllowance(): " + bsp.getMonthlyTransAllowance() + "\t" + bsp.getTotalWorkDays());
		transAllowance = (bsp.getMonthlyTransAllowance() / bsp.getTotalWorkDays()) * (monthlyTsDays - absenceMoreThan8HrsDays);
		
		System.out.println("交通补贴为： " + df.format(transAllowance));
		
		
		//五险一金
		socialInsurBase = sv.getSocialInsurBase();
		for (Basesocialinsurance bsi : baseSocialInsuranceList) {
			if(bsi.getBsiName().equalsIgnoreCase("Pension_Personal")) {
				pension_Personal =socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Pension_Company")) {
				pension_Company = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Medical_Personal")) {
				medical_Personal = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Medical_Company")) {
				medical_Company = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Accum_Fund_Personal")) {
				accum_Fund_Personal = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Accum_Fund_Company")) {
				accum_Fund_Company = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Unemp_Insu_Personal")) {
				unemp_Insu_Personal = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Unemp_Insu_Company")) {
				unemp_Insu_Company = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("OccupInjure_Personal")) {
				occupInjure_Personal = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("OccupInjure_Company")) {
				occupInjure_Company = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Maternity_Personal")) {
				maternity_Personal = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
			if(bsi.getBsiName().equalsIgnoreCase("Maternity_Company")) {
				maternity_Company = socialInsurBase * bsi.getBsiRate() + bsi.getBsiAdditional();
			}
		}
		
		System.out.println("medical_Personal: " + medical_Personal);
		
		
		
	}

}
