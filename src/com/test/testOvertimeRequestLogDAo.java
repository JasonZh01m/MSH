package com.test;

import java.util.List;

import com.moravia.hs.base.dao.OvertimerequestlogDAO;
import com.moravia.hs.base.entity.Overtimerecord;
import com.moravia.hs.base.entity.Overtimerequestlog;

public class testOvertimeRequestLogDAo {
	
	public static void main(String[] args) {
		BaseTest bt = new BaseTest();
		OvertimerequestlogDAO odao = (OvertimerequestlogDAO) bt.getBean("overtimerequestlogDAO");
		
		List<Overtimerequestlog> logs = odao.findByOvertimeRecordId(19);
		for (Overtimerequestlog log : logs) {
			System.out.println(log.getId() + "\t" + log.getChangeDate());
		}
		
	}
	

}
