package com.example.demo.study.mac;

import javax.crypto.SecretKey;

import com.example.demo.study.security.KeyUtil;

public class SalaryVerify {
	public static void main(String[] args) throws Throwable{
		String salaryFilePath = "src/main/java/com/example/demo/study/mac/my_salary.txt";
		String macKeyFilePath = "src/main/java/com/example/demo/study/mac/mackey.key";

		SecretKey mackey = KeyUtil.getSecretKeyFromFile("HmacSHA256", macKeyFilePath);	
		
		// 已知(COPY 自 SalaryCreator.java 執行ㄉ結果)
		String salaryMacHexValue = "a40d73ec15ac9c08ee4a9b9b9561148a0fa507c2706a5c17d03e92a7b2506f89";
		
		// 生成 computedSalaryMacHexValue
		String computedSalaryMacHexValue = KeyUtil.generateMac("HmacSHA256", mackey, macKeyFilePath);
		
		// 驗證
		if (salaryMacHexValue.equals(computedSalaryMacHexValue)) {
			System.out.println("MAC 驗證成功, 資料來自於 HR");
		} else {
			System.out.println("MAC 驗證失敗" + salaryMacHexValue);
		}
		
	
	
	
	}
	
	
}
