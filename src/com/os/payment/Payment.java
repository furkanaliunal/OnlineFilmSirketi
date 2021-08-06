package com.os.payment;

public abstract class Payment {
	float amount;
	int userID;
	String note;
	PaymentType paymentType = PaymentType.Undefined;
	public void addNote(String note) {
		this.note = note;
	}
	public PaymentType getPaymentType() {
		return this.paymentType;
	}
	public int getUserID() {
		return this.userID;
	}
	public float getAmount() {
		return this.amount;
	}
}
