package com.moravia.hs.action;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.TimesheetDAO;
import com.moravia.hs.base.entity.Timesheet;
import com.moravia.hs.util.TimesheetUtil;

@Controller("updateTSTableAction")
public class UpdateTSTableAction extends BaseAction {

	@Resource(name = "timesheetDAO")
	private TimesheetDAO timesheetDAO;

	private String uts_startDate;

	public String getUts_startDate() {
		return uts_startDate;
	}

	public void setUts_startDate(String uts_startDate) {
		this.uts_startDate = uts_startDate;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("uts_startDate: " + uts_startDate.trim());
		Map<String, Object> session = getSession();
		
		if(!uts_startDate.trim().matches("\\d{4}-\\d{2}-\\d{2}")) {
			session.put("globalError", "Bad formatted Date");
			return INPUT;
		}
		// 在CN数据库中取得特定时间段的内容
		TimesheetUtil tsu = new TimesheetUtil();
		Long t1 = System.currentTimeMillis();
		List<Timesheet> tss = tsu.getTimeSheetsAfterByDate(uts_startDate.trim());
		
		// 删除原有数据库内特定时间段的内容
		timesheetDAO.deleteByDate(uts_startDate.trim());
		
//		System.out.println("tss.size(): " + tss.size());
		
		// 保存新内容
		/*for (Timesheet ts : tss) {
			timesheetDAO.save(ts);
			System.out.println();
		}*/
		timesheetDAO.batchSave(tss);
		Long t2 = System.currentTimeMillis();
		System.out.println("t2-t1: " + (t2 - t1) / 1000.0);
		DecimalFormat df = new DecimalFormat("#.00");
		
		session.put("uts_consumetime", df.format((t2 - t1) / 1000.0));
		session.put("uts_sumrecords", tss.size());
		return SUCCESS;
	}
	
	
	
	

}
