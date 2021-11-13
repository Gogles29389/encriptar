package com.example.demo;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncriptarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncriptarApplication.class, args);
	}

	private static String  ENCRYPT_KEY="clave-compartida-no-reveloar-nunca";

	private static String encript(String text) throws Exception {	
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, aesKey);

		byte[] encrypted = cipher.doFinal(text.getBytes());
			
		return Base64.encodeBytes(encrypted);
		}

	private static String decrypt(String encrypted) throws Exception {
		byte[] encryptedBytes=Base64.decode( encrypted.replace("\n", "") );
			
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, aesKey);

		String decrypted = new String(cipher.doFinal(encryptedBytes));
	        
		return decrypted;
		}
	
}
