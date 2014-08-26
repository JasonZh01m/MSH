package com.moravia.hs.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.BasesalarypropertiesDAO;
import com.moravia.hs.base.dao.PayrollrecordDAO;
import com.moravia.hs.base.entity.Basesalaryproperties;
import com.moravia.hs.base.entity.Payrollrecord;

@Controller("payrollConfirmationAction")
public class PayrollConfirmationAction extends BaseAction {

	@Resource(name = "payrollrecordDAO")
	private PayrollrecordDAO payrollrecordDAO;

	@Resource(name = "basesalarypropertiesDAO")
	private BasesalarypropertiesDAO basesalarypropertiesDAO;

	private String pcp_startDate;
	private String pcp_endDate;

	public String getPcp_startDate() {
		return pcp_startDate;
	}

	public void setPcp_startDate(String pcp_startDate) {
		this.pcp_startDate = pcp_startDate;
	}

	public String getPcp_endDate() {
		return pcp_endDate;
	}

	public void setPcp_endDate(String pcp_endDate) {
		this.pcp_endDate = pcp_endDate;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("进入 payrollConfirmationActinon");
		Map<String, Object> session = getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfM = new SimpleDateFormat("yyyy-MM");
		
		if (pcp_startDate == null || pcp_startDate == "") {
			System.out.println("startDate is null");
			Basesalaryproperties bp = basesalarypropertiesDAO.findLastCreated();
			System.out.println("bp.getBaseConstantId(): " + bp.getBaseConstantId());
			pcp_startDate = sdf.format(bp.getStartDate());
			pcp_endDate = sdf.format(bp.getEndDate());
		}

		// System.out.println("startDate: " + pcp_startDate + "\tendDate: " + pcp_endDate);

		List<Payrollrecord> pList = payrollrecordDAO.findAllByDate(pcp_startDate,
				pcp_endDate);
		System.out.println("pList.size(): " + pList.size());
		Date date = sdf.parse(pcp_startDate);
		session.put("pcp_month", sdfM.format(date)); 
		session.put("pcp_startDate", pcp_startDate);
		session.put("pcp_endDate", pcp_endDate);
		session.put("pcp_pList", pList);

		// for (Payrollrecord payrollrecord : pList) {
		// // System.out.println(payrollrecord.getEmpEmpLoginId() + "\t" +
		// payrollrecord.getBaseSalary());
		// }

		return SUCCESS;
	}

}
