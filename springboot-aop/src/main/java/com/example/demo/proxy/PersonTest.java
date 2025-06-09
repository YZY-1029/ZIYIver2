package com.example.demo.proxy;

public class PersonTest {
	public static void main(String[] args) {
//		// 一般用法 
//		Person man = new Man();
//		Person woman = new Woman();
//		man.work();
//		woman.work();
		
		// 使用代理
		// 這裡使用 PersonProxy 跟 Person 的差別在於使用 Person 的耦合性會低很多
		// 而 PersonProxy 的耦合性會很高, 當未來替換成其他實作的時候 就需要改寫程式碼
		PersonProxy man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());  
		man.work();
		woman.work();
		
		
	}
}
