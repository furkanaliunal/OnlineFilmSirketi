package com.os.user;

import java.util.ArrayList;

public abstract class User implements IUser{
	private String name;
	private UserType userType;
	private int id;
	private float currency;
	private ArrayList<Integer> purchasedFilms;
	
	
	public User(String name, UserType userType, ArrayList<Integer> purchasedFilms) {
		this.name = name;
		this.userType = userType;
		this.currency = 0f;
		this.purchasedFilms = purchasedFilms;
	}
	protected User(String name, UserType userType, int id, ArrayList<Integer> purchasedFilms) {
		this.name = name;
		this.userType = userType;
		this.id = id;
		this.currency = 0f;
		this.purchasedFilms = purchasedFilms;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User with id: "+ this.id +" with type "+this.userType+": " + this.name;
	}
	
	public String toStringDetailed() {
		return "\n----------------------------"+
				"\nUser with id: "+ this.id +" with type "+this.userType+": " + this.name + 
				"\nCurrency: " + this.currency + 
				"\nPurchased films: " + this.purchasedFilms.toString()+
				"\n----------------------------";
	}
	
	@Override
	public UserType getUserType() {
		return this.userType;
	}
	
	@Override
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Override
	public int getID() {
		return id;
	}
	

	public void addCurrency(Float amount) {
		this.currency += amount;
	}
	

	public float getCurrency() {
		return this.currency;
	}

	public Boolean pay(Float amount) {
		if (this.currency < amount) {
			return false;
		}
		currency -= amount;
		return true;
	}
	

	public ArrayList<Integer> getPurchasedFilms(){
		return this.purchasedFilms;
	}
	
}
