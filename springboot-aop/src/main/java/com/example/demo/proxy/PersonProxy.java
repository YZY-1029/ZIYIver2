package com.example.demo.proxy;

// 靜態代理
// 用來執行(調用)被代理者ㄉ業務邏輯與實現公用邏輯
public class PersonProxy implements Person {
	
	// 代理對象 (被代理者)
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		// 實現公用邏輯 - 前置通知
		System.out.println("量體溫");
		System.out.println("出門戴口照");
		
		// 業務邏輯
		try {
			person.work();
		} catch (Exception e) {
			// 實現公用邏輯 - 例外通知
			System.out.println("工作中發ㄉ例外(例如紀錄log,就不用每個都寫log)" + e);
		}finally {
			// 實現公用邏輯 - 後置通知 (後置通知要放在finally裡面)
			System.out.println("回家脫口照");
		}
	}
}
