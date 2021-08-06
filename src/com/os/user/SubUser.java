package com.os.user;

import java.util.ArrayList;

public class SubUser extends User{
	private ArrayList<Integer> rentedFilms;
	
	public SubUser (String name) {
		super(name, UserType.SUBSCRIBED, new ArrayList<>());
		this.rentedFilms = new ArrayList<>();
	}
	protected SubUser (String name, int id, ArrayList<Integer> purchasedFilms) {
		super(name, UserType.SUBSCRIBED, id, purchasedFilms);
		this.rentedFilms = new ArrayList<>();
	}
	

	public ArrayList<Integer> getRentedFilms(){
		return this.rentedFilms;
	}
	
	
	@Override
	public String toStringDetailed() {
		return "\n----------------------------"+
				"\nUser with id: "+ getID() +" with type "+getUserType()+": " + getName() + 
				"\nCurrency: " + getCurrency() + 
				"\nPurchased films: " + getPurchasedFilms().toString()+
				"\nRented films: " + getRentedFilms().toString()+
				"\n----------------------------";
	}

}
