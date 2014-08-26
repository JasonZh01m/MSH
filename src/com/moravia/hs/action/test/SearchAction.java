package com.moravia.hs.action.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("searchAction")
public class SearchAction extends ActionSupport {
	private String input;
	private List<String> keywords;
	
	public String getKeyword(){
		System.out.println("Into getKeyword method...");
		 //获取关键词，在真实项目中，关键词一般是从数据库查询得到
        String[] words = { "北京市","北京大学" ,"北大青鸟" ,"北大青鸟阿博泰克" ,"北大资源" };
		keywords = new ArrayList<String>();
		for(String s : words){
			if(s.indexOf(input) != -1){
				keywords.add(s);
			}
		}
		return SUCCESS;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
}
