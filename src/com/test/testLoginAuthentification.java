package com.test;

import com.moravia.hs.util.LoginAuthentification;

public class testLoginAuthentification {

	public static void main(String[] args) {
		LoginAuthentification auth = new LoginAuthentification("jason zhou", "+-");
		System.out.println(auth.authentificate());
		
	}
	
}
