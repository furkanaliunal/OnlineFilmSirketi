package com.os.transaction;

import com.os.film.FilmManager;
import com.os.film.IFilm;
import com.os.payment.*;
import com.os.user.IUser;
import com.os.user.SubUser;
import com.os.user.UserManager;
import com.os.user.UserType;

public class TransactionsManager {
	private FilmManager filmManager;
	private UserManager userManager;
	
	public TransactionsManager(FilmManager filmManager, UserManager userManager) {
		this.filmManager = filmManager;
		this.userManager = userManager;
	}
	
	public Boolean PurchaseCredit(Payment purchase) {
		switch(purchase.getPaymentType()) {
			case Undefined:
				return false;
			case Credit:
				return PurhcaseByCreditCard((Credit)purchase);
			case GiftCode:
				return PurchaseByGiftCard((GiftCode)purchase);
		}
		return false;
	}
	
	private Boolean PurhcaseByCreditCard(Credit purchase) {
		if (!isValidCreditCard()) {
			return false;
		}
		return addCurrency(purchase);
	}
	
	private Boolean PurchaseByGiftCard(GiftCode purchase) {
		if (!isValidGiftCard()) {
			return false;
		}
		return addCurrency(purchase);
	}
	
	private Boolean addCurrency(Payment purchase) {
		IUser user = this.userManager.getIUserFromID(purchase.getUserID());
		user.addCurrency(purchase.getAmount());
		return true;
	}
	
	private Boolean isValidCreditCard() {
		//an api to check is credit card valid
		return true;
	}
	private Boolean isValidGiftCard() {
		//an api to manage and check giftcards
		return true;
	}
	
	public Boolean RentFilm(int userID, int filmID) {
		IUser user = userManager.getIUserFromID(userID);
		IFilm film = filmManager.getIFilmFromID(filmID);
		if (user == null || film == null || user.getUserType() != UserType.SUBSCRIBED) {
			return false;
		}
		Boolean transaction = user.pay(film.getRentPrice());
		
		((SubUser)user).getRentedFilms().add(filmID);
		
		return transaction;
		
	}
	public Boolean PurchaseFilm(int userID, int filmID) {
		IUser user = userManager.getIUserFromID(userID);
		IFilm film = filmManager.getIFilmFromID(filmID);
		if (user == null || film == null) {
			return false;
		}
		Boolean transaction = user.pay(film.getSellPrice());
		
		user.getPurchasedFilms().add(filmID);

		return transaction;
		
	}
	
}
