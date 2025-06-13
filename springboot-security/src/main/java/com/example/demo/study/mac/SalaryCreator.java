package com.example.demo.study.mac;

import java.io.File;

import javax.crypto.SecretKey;

import com.example.demo.study.security.KeyUtil;

/*
 * 情境描述：
 * 在一家大型企業，HR部門每月都會發送電子薪資明細給員工。
 * 為了確保薪資明細的安全性，HR部門決定對薪資明細檔案進行雜湊和 MAC 保護。
 * 雜湊保護確保薪資明細的完整性，而MAC則確保薪資明細確實來自HR部門，並未被其他部門或外部攻擊者更改。
 * 薪資檔案位置   : my_salary.txt
 * macKey檔案位置: macKey.key
 * */

public class SalaryCreator {
	
	public static void main(String[] args) throws Throwable{
		String salaryFilePath = "src/main/java/com/example/demo/study/mac/my_salary.txt";
		String macKeyFilePath = "src/main/java/com/example/demo/study/mac/mackey.key";

		
		// 生成 mackey
		SecretKey macKey = null;
		if (new File(macKeyFilePath).exists()) {
			macKey = KeyUtil.getSecretKeyFromFile("HmacSHA256", macKeyFilePath);
		} else {
			macKey = KeyUtil.generateKeyForHmac();
			// 將 mackey 儲存進檔案
			KeyUtil.saveSecretKeyToFile(macKey, macKeyFilePath);
		}
		
		// 得到 my_salary.txt ㄉ macValue(Hex)
		String salaryMacHexValue = KeyUtil.generateMac("HmacSHA256", macKey, salaryFilePath);
		System.out.println("得到 hr 發布ㄉ salaryMacHexValue:" + salaryMacHexValue);
		
	}
	
	
}
