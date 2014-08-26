package com.moravia.hs.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Vacationtype;
import com.moravia.hs.base.entity.other.SumTsInfo;
import com.moravia.hs.base.entity.other.TsInfoGroupByOrderId;
import com.moravia.hs.base.entity.other.TsMonthlyAbsenceInfo;
import com.moravia.hs.base.entity.other.TsSumDiffTime;
@Controller("summaryTsInfoAction")
public class SummaryTsInfoAction extends BaseAction{
	@Resource(name = "timesheetDAO")
	private TimesheetDAO timesheetDAO;
	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;
	@Resource(name = "vacationtypeDAO")
	private VacationtypeDAO vacationtypeDAO;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("executing summaryTsInfoAction...");
		Map<String, Object> session = getSession();
		
		Basesalaryproperties bsp = basesalarypropertiesDAO.findLastCreated();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sdf.format(bsp.getStartDate());	//get start date from basesalaryProperties
		String endDate = sdf.format(bsp.getEndDate());  // get end date
		Double monthNormalWorkHrs = bsp.getTotalWorkHours();
		
//		// System.out.println("startDate: " + startDate);
//		// System.out.println("endDate: " + endDate);
		
		/*//员工每月请假信息
		List<TsMonthlyAbsenceInfo> tsMonthlyAbsenceInfoList = null;
		//Timesheet信息(按照OrderId分类)
		List<TsInfoGroupByOrderId> TsInfoList = null;
		
		//假期类型信息
		List<Vacationtype> vacationtypeList = vacationtypeDAO.findAll();
		
		// 不支付工资的timesheet OrderId号
		List<Integer> unPaidOrderIdList = new ArrayList<Integer>(); 

		//&得到Unpaid OrderId
		for (Vacationtype vt : vacationtypeList) {
			if(vt.getVacationPaidRate() == 0) {
				unPaidOrderIdList.add(vt.getTimeSheetOrderId());
			}
		}
		
		List<TsSumDiffTime> ts_list = null;
		ts_list = timesheetDAO.findAllByLoginNameAndSumTime(startDate, endDate);
		
		
		
		List<SumTsInfo> stiList = new ArrayList<SumTsInfo>();  //result List
		
		Double absenceHrs = 0.0;
		Double monthlyPaidHrs = 0.0;
		Double monthlyNotPaidHrs = 0.0;
		
		for (TsSumDiffTime tsSumDiffTime : ts_list) {
			//clear to 0
			absenceHrs = 0.0;
			monthlyPaidHrs = 0.0;
			monthlyNotPaidHrs = 0.0;
			
			SumTsInfo sti = new SumTsInfo();
			sti.setLoginId(tsSumDiffTime.getLoginName());  //empLoginId
			sti.setTsHrs(tsSumDiffTime.getSumTime());  //Timesheet hours
			
			tsMonthlyAbsenceInfoList = timesheetDAO.findTsMonthlyAbsenceInfo(tsSumDiffTime.getLoginName(), startDate, endDate);
			TsInfoList = timesheetDAO.findTsInfoGroupByOrderId(tsSumDiffTime.getLoginName(), startDate, endDate);
			
			
			for (TsMonthlyAbsenceInfo tma : tsMonthlyAbsenceInfoList) {
				absenceHrs += tma.getSumDiff();
			}
			// Absence Hrs
			sti.setAbsenceHrs(absenceHrs);  

			//paid hours
			for (TsInfoGroupByOrderId tig : TsInfoList) {
				if(!unPaidOrderIdList.contains(tig.getOrderId())) {
					monthlyPaidHrs += tig.getSumDiff();
				}
			}
			sti.setPaidHrs(monthlyPaidHrs);
			//not paid hours
			sti.setNotPaidHrs(tsSumDiffTime.getSumTime() - monthlyPaidHrs);
			//overtime hours
			sti.setOverTime(tsSumDiffTime.getSumTime() - monthNormalWorkHrs);
			
			stiList.add(sti);
		}*/
		
		List<SumTsInfo> sti_List = timesheetDAO.SummaryTsInfo(startDate, endDate);
		// System.out.println("sti_List.size(): " + sti_List.size());
		for (SumTsInfo sti : sti_List) {
			//set overtime
			if((sti.getTsHrs() - monthNormalWorkHrs) == 0) {
				sti.setOverTime(null); 
			} else {
				sti.setOverTime(sti.getTsHrs() - monthNormalWorkHrs);
			}
			// set not paid hours
			if(sti.getNotPaidHrs() == null || sti.getNotPaidHrs() == 0) {
				sti.setNotPaidHrs(null);
			}
			
		}
		SimpleDateFormat sdfM = new SimpleDateFormat("yyyy-MM");
		session.put("sti_stiList", sti_List);
		session.put("sti_month", sdfM.format(bsp.getStartDate()));
		return SUCCESS;
	}
	
	
}
