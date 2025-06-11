package com.example.demo.study.encryption;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import com.example.demo.study.security.KeyUtil;

// AES 對稱式加密
public class AESSample {

	// 建立一個 AES Key(256bits, 32bytes)
	//private static final String Key = "999888777666555444333222111000AB"; // 32個字
	
	public static void main(String[] args) throws Throwable {
		String originalText = "今天是好天氣";     // 這是明文(需要被加密ㄉ)
		System.out.printf("明文: %s%n", originalText);
		System.out.println("------------------------------------");
		// 再來利用 AES 進行加密
		// 加密流程: 明文 -> 加密 (encryptedECB) -> 進行Base64編碼(以利儲存)
		// 解密流程: 進行 Base64 解碼 -> 解密(decryptedECB) -> 明文
		
		//--------------------------------------------------------------------
		
		// 1. 建立 AES 密鑰規範
		//SecretKeySpec aesKeySpec = new SecretKeySpec(Key.getBytes(), "AES");
		String filePath = "aes_key.key";
		SecretKeySpec aesKeySpec = loadKeyFromFile(filePath);
		// 2. 選擇使用 ECB模式 對明文進行加密
		byte[] encryptedECB = KeyUtil.encryptWithAESKey(aesKeySpec, originalText);
		// 3. 印出加密後ㄉ資訊
		System.out.printf("加密後ㄉ:%s%n",Arrays.toString(encryptedECB));
		// 由於這樣子印出來ㄉ是陣列(會逾法存進資料庫), 所以在這邊將我們ㄉ byte[] 轉為 Base64(編碼)
		String encodeingECBBase64 = Base64.getEncoder().encodeToString(encryptedECB);
		System.out.printf("編碼後(Base64): %s%n", encodeingECBBase64);
		System.out.println("------------------------------------");
		
		//--------------------------------------------------------------------
		
		// 利用 AES 進行解密
		// 1. Base64 轉 byte[] (解碼)
		byte[] decodingECBBase64 = Base64.getDecoder().decode(encodeingECBBase64);
		System.out.printf("解碼後: %s%n", Arrays.toString(decodingECBBase64));
		// 2. 進行解密
		String decryptedECB = KeyUtil.decryptWithAESKey(aesKeySpec, decodingECBBase64);
		System.out.printf("解密後ㄉ明文: %s%n", decryptedECB);
	}
	
	// 讀取金鑰檔
	public static SecretKeySpec loadKeyFromFile(String filePath) throws Exception {
		String key = Files.readString(Path.of(filePath));
		return new SecretKeySpec(key.getBytes(), "AES");
	}
}
