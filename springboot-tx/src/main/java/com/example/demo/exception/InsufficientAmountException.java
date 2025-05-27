package com.example.demo.exception;


 // 餘額或庫存不足ㄉ例外
public class InsufficientAmountException extends Exception {

	public InsufficientAmountException(String message) {
		super(message);
	}
}
