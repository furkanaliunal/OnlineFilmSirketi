package com.os.payment;

public class GiftCode extends Payment{
	String giftCode;
	public GiftCode(String giftCode, float amount, int userID) {
		this.giftCode = giftCode;
		this.amount = amount;
		this.userID = userID;
		this.paymentType = PaymentType.GiftCode;
	}
}
