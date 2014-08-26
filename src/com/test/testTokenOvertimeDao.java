package com.test;

import java.util.List;

import com.moravia.hs.base.dao.Pagination;
import com.moravia.hs.base.dao.TokenOvertimeDAO;
import com.moravia.hs.base.entity.TokenOvertime;
import com.moravia.hs.base.entity.other.PageBean;

public class testTokenOvertimeDao {
	
	public static void main(String[] args) {
		BaseTest bt = new BaseTest();
		TokenOvertimeDAO todao = (TokenOvertimeDAO) bt.getBean("tokenOvertimeDAO");
		
		PageBean pageBean = todao.findByExecutorWithPageSize("JasonZh", 1, 5, 1);
		List<TokenOvertime> tokens = pageBean.getList();
		
		System.out.println(tokens.size());
		for (TokenOvertime token : tokens) {
			System.out.println(token.getTokenExecutor() + "\t" + token.getTokenState() + "\t" + token.getTokenId());
		}
	}
}
