package com.test;

import java.util.List;

import com.moravia.hs.base.dao.VacationchangerecordDAO;
import com.moravia.hs.base.entity.Vacationchangerecord;
import com.moravia.hs.base.entity.other.PageBean;

public class testVacationChangeRecordDao {

	public static void main(String[] args) {
		
		BaseTest bt = new BaseTest();
		VacationchangerecordDAO vdao = (VacationchangerecordDAO) bt.getBean("vacationchangerecordDAO");
		PageBean pb = vdao.findPageBeanByEmp("jasonzh", 10, 0);
		List<Vacationchangerecord> vcs = pb.getList();
		
		for (Vacationchangerecord vc : vcs) {
//			vc.getChangeRecordId() + "\t" + vc.getChangeReason() + "\t" + vc.getChangeHours() + "\t" + 
			System.out.println(vc.getCreateDate());
		}
		
	}
	
	
}
