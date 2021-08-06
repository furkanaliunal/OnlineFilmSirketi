package com.os.payment;

import java.util.Date;

public class Credit extends Payment{
	String cardHolder;
	String longNumber;
	Date expiryDate;
	char[] cvv = new char[3];
	public Credit(String cardHolder, String longNumber, Date expiryDate, char[] cvv, float amount, int userID) {
		this.cardHolder = cardHolder;
		this.longNumber = longNumber;
		this.expiryDate = expiryDate;
		this.amount = amount;
		this.userID = userID;
		this.paymentType = PaymentType.Credit;
	}
}
