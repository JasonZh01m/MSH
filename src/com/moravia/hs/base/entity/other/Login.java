package com.moravia.hs.base.entity.other;

import java.util.List;

import com.moravia.hs.base.entity.Emp;

/*
 * This class used to memory all info related to a login emp.
 */
public class Login {
	
	private Emp emp;	// 员工
	private List<String> allLoginIds;	// 公司所有的loginId
	
	private String startDate;	// 开始日期
	private String endDate;		// 结束日期
	
//	private Integer affairsNum;	// 等待处理的事物总数
//	private Integer affaristotalpage;	// 等待处理的事物总数页数
	
//	private Double compensatoryLeft;	// 剩余调休假总小时数
	private Double usableCompensatoryLeave;	// 可以申请调休的调休假(实际剩余调休假 - 正在流程中的调休假)
	
	private Double usableAnnualLeave;	// 可以请的年假(实际剩余年假 - 正在流程中的年假) 
	
	private PageBean pageBean;	// affairs related pageBean
	
	private PageBean pageBeanOvertimeRequests;
	
	private PageBean absenceHistoryPageBean;	// history related page bean
	
	private PageBean overtimeHistoryPageBean;	
	
	private VacationUsedInfo vacationUsedInfo; 	 // 员工假期使用情况
	

	// 添加其他属性。。。
	
	public Emp getEmp() {
		return emp;
	}
	
	public Double getUsableCompensatoryLeave() {
		return usableCompensatoryLeave;
	}

	public void setUsableCompensatoryLeave(Double usableCompensatoryLeave) {
		this.usableCompensatoryLeave = usableCompensatoryLeave;
	}

	public Double getUsableAnnualLeave() {
		return usableAnnualLeave;
	}

	public void setUsableAnnualLeave(Double usableAnnualLeave) {
		this.usableAnnualLeave = usableAnnualLeave;
	}

	public PageBean getPageBeanOvertimeRequests() {
		return pageBeanOvertimeRequests;
	}

	public void setPageBeanOvertimeRequests(PageBean pageBeanOvertimeRequests) {
		this.pageBeanOvertimeRequests = pageBeanOvertimeRequests;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public List<String> getAllLoginIds() {
		return allLoginIds;
	}
	public void setAllLoginIds(List<String> allLoginIds) {
		this.allLoginIds = allLoginIds;
	}
	@Deprecated
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	@Deprecated
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	/*public Double getCompensatoryLeft() {
		return compensatoryLeft;
	}
	public void setCompensatoryLeft(Double compensatoryLeft) {
		this.compensatoryLeft = compensatoryLeft;
	}*/
	public PageBean getAbsenceHistoryPageBean() {
		return absenceHistoryPageBean;
	}
	public void setAbsenceHistoryPageBean(PageBean absenceHistoryPageBean) {
		this.absenceHistoryPageBean = absenceHistoryPageBean;
	}
	public VacationUsedInfo getVacationUsedInfo() {
		return vacationUsedInfo;
	}
	public void setVacationUsedInfo(VacationUsedInfo vacationUsedInfo) {
		this.vacationUsedInfo = vacationUsedInfo;
	}

	public PageBean getOvertimeHistoryPageBean() {
		return overtimeHistoryPageBean;
	}

	public void setOvertimeHistoryPageBean(PageBean overtimeHistoryPageBean) {
		this.overtimeHistoryPageBean = overtimeHistoryPageBean;
	}
	
	
	
}
