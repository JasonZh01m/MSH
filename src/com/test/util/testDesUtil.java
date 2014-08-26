package com.test.util;

import com.moravia.hs.util.DesUtil;

public class testDesUtil {
	
	public static void main(String[] args) throws Exception {
		DesUtil du = new DesUtil();
		String pwd = "AbCDefG&^*";
		String key = "P@ssword+-";
		String encryptedPwd = "&&EncryptedPwd&:" + du.encrypt(pwd, key);
		System.out.println(encryptedPwd);
		System.out.println(du.decrypt(encryptedPwd.replace("&&EncryptedPwd&:", ""), key));
		
	}
	
}
