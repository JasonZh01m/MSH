package com.moravia.hs.util;

import java.util.Properties;
import javax.naming.*;
import javax.naming.directory.*;

public class LoginAuthentification {
	private String loginName;
	private String loginPassword;

	public LoginAuthentification(String loginName, String loginPassword) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}

	public boolean authentificate() {
		String ldapHost = "ldap://10.20.1.24:389"; // ldap host + port number
		String DN = "cn=" + loginName + ", ou=Users_CN, ou=Users_ALL, dc=CZ, dc=moravia-it,dc=com"; // DN
		// authenticated
//		String password = loginPassword; // DN's password
		// ***************** End of user information
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		// for websphere 4.0 and 5.0
		// props.put(Context.INITIAL_CONTEXT_FACTORY,
		// "com.ibm.jndi.LDAPCtxFactory");
		// for WebSphere 3.5 release
		props.put(Context.SECURITY_AUTHENTICATION, "simple"); // use simple
		props.put(Context.SECURITY_CREDENTIALS, loginPassword);
		props.put(Context.SECURITY_PRINCIPAL, DN);
		props.put(Context.PROVIDER_URL, ldapHost);

//		long start = System.currentTimeMillis();
//		long end = 0;
//		long time = 0;

		try {
			System.out.println("authenticating...");
			DirContext ctx = new InitialDirContext(props);
//			System.out.println("authenticated");
//			end = System.currentTimeMillis();
//			time = end - start;
//			System.out.println("authentication takes = " + time + " millis");
			System.out.println("successfully authenticate DN: " + DN);
			return true;

		} catch (Exception ex) {
//			end = System.currentTimeMillis();
//			time = end - start;
//			System.out.println("Exception is " + ex.toString());
//			ex.printStackTrace();
//			System.out.println("authentication takes = " + time + " millis");
			System.out.println("fail to authenticate DN: " + DN);
			return false;
		}
	}
}
