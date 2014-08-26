package com.test.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class testEncrypt {
	
	public static void main(String[] args) {
		//Generator a DES key
		SecretKey key = createSecretkeyKey("DES");
		String encrypted_Str = encryptToDES(key, "Zxh350194768+-");
		System.out.println("加密后：" + encrypted_Str);
		//600ECC2B5F319F96A9ED0B2F1773A631
		//F20E779A309CC668ED53B624F7923FB5
		String decrypted_Str = decryptByDES(key, encrypted_Str);
		System.out.println("解密后：" + decrypted_Str);
	}
	
	//Create a Secret Key
	static SecretKey createSecretkeyKey(String algorithm) {
		KeyGenerator keygen;
		SecretKey deskey = null;
		try {
			keygen = KeyGenerator.getInstance(algorithm);
			deskey = keygen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return deskey;
	}
	
	//Use DES to encrypt a string
	static String encryptToDES(SecretKey key, String info) {
		//Definite encrypt method
		String cipher_algorithm = "DES/ECB/PKCS5Padding";
		SecureRandom sr = new SecureRandom();
		byte[] cipherByte = null;
		try {
			Cipher c1 = Cipher.getInstance(cipher_algorithm);
			c1.init(Cipher.ENCRYPT_MODE, key, sr);
			cipherByte = c1.doFinal(info.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byte2hex(cipherByte);
	}
	
	//USE DES to decrypt a string
//	static String decryptByDES(SecretKey key, String sInfo) {
//		String algorithm = "DES";
//		SecureRandom sr = new SecureRandom();
//		byte[] cipherbyte = null;
//		try {
//			Cipher c1 = Cipher.getInstance(algorithm);
//			c1.init(Cipher.DECRYPT_MODE, key, sr);
//			cipherbyte = c1.doFinal(hex2byte(sInfo));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new String(cipherbyte);
//	}
	
	
	 public static String decryptByDES(SecretKey key, String sInfo) {  
	        // 定义 加密算法,  
		 String cipher_algorithm = "DES/ECB/PKCS5Padding";
	        // 加密随机数生成器 (RNG)  
	        SecureRandom sr = new SecureRandom();  
	        byte[] cipherByte = null;  
	        try {  
	            // 得到加密/解密器  
	            Cipher c1 = Cipher.getInstance(cipher_algorithm);  
	            // 用指定的密钥和模式初始化Cipher对象  
	            c1.init(Cipher.DECRYPT_MODE, key, sr);  
	            // 对要解密的内容进行编码处理  
	            cipherByte = c1.doFinal(hex2byte(sInfo));
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        // return byte2hex(cipherByte);
	        return new String(cipherByte);  
	    }  
	
	//Transform byte to hex
	static String byte2hex(byte[] b) {  
        String hs = "";  
        String stmp = "";  
        for (int n = 0; n < b.length; n++) {  
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));  
            if (stmp.length() == 1) {  
                hs = hs + "0" + stmp;  
            } else {  
                hs = hs + stmp;  
            }  
        }  
        return hs.toUpperCase();  
    }  
	
	//Transform byte to hex
	 static byte[] hex2byte(String hex) {  
	        byte[] ret = new byte[8];  
	        byte[] tmp = hex.getBytes();  
	        for (int i = 0; i < 8; i++) {  
	            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);  
	        }  
	        return ret;  
	    }
	 
	 //Unite two ASCII codes to one
	 public static byte uniteBytes(byte src0, byte src1) {  
	        byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))  
	                .byteValue();  
	        _b0 = (byte) (_b0 << 4);  
	        byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))  
	                .byteValue();  
	        byte ret = (byte) (_b0 ^ _b1);  
	        return ret;  
	    }
}
