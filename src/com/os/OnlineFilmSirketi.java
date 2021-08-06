package com.os;

import java.util.Collection;
import java.util.Iterator;

import com.os.film.Film;
import com.os.film.FilmCategory;
import com.os.film.FilmManager;
import com.os.film.IFilm;
import com.os.payment.GiftCode;
import com.os.transaction.TransactionsManager;
import com.os.user.DefUser;
import com.os.user.IUser;
import com.os.user.OrdUser;
import com.os.user.SubUser;
import com.os.user.UserManager;
import com.os.user.UserType;

public class OnlineFilmSirketi {

	public static UserManager userManager;
	public static FilmManager filmManager;
	public static TransactionsManager transManager;
	
	public static void main(String [] args) {
		
		initalizingManagers();
		addingUsers();
		addingFilms();
		addingCategories();
		transactions();
		
	}
	
	public static void initalizingManagers() {
		
		userManager = new UserManager();
		filmManager = new FilmManager();
		transManager = new TransactionsManager(filmManager, userManager);//requires both managers
	}
	
	public static void addingUsers() {
		
		userManager.addUser(new OrdUser("Furkan"));
		userManager.addUser(new SubUser("Ali"));
		userManager.addUser(new DefUser("Fatma", UserType.SUBSCRIBED));
		
	}
	
	public static void addingFilms() {

		filmManager.addFilm(new Film("Interstaller"));
		filmManager.addFilm(new Film("Pirates of carrabien"));
		filmManager.addFilm(new Film("Akame ga kill"));
		filmManager.addFilm(new Film("Avengers Civil Var"));
	}
	
	public static void addingCategories() {
		Film f = new Film("Transformers");
		f.addCategory(FilmCategory.Action);
		filmManager.addFilm(f);
		
		IFilm film = filmManager.getFilmFromID(1);
		film.addCategory(FilmCategory.Action);
		film.addCategory(FilmCategory.Comedy);
	}
	
	public static void retrievingUsers() {
		
		Iterator<IUser> it = userManager.getAllUsers().iterator();
		while(it.hasNext()) {
			IUser u = it.next();
			System.out.println(u.toString());//Printing all users
		}
		
		IUser u = userManager.getIUserFromID(1);//Retrieving user with ID 1
		System.out.println(u.getID()+ ":"+ u.getName());
		
	}
	
	public static void retrievingFilms() {
			filmManager.listAllFilms();//Printing all films in the list

			System.out.println("Films with category Action");//Printing all films from a category
			filmManager.listAllFilmsFromCategory(FilmCategory.Action);
			
			IFilm film = filmManager.getIFilmFromID(1);
			
			Collection<IFilm> films = filmManager.getAllFilms();
	}
	
	public static void transactions() {
		transManager.PurchaseCredit(new GiftCode("happy-new-year-1500", 1000, 1));
		transManager.PurchaseCredit(new GiftCode("happy-new-year-1500", 1000, 2));
		
		IUser user1 = userManager.getIUserFromID(1);
		IUser user2 = (SubUser)userManager.getIUserFromID(2);//subscribed one
		IFilm film1 = filmManager.getFilmFromID(1);
		film1.setSellPrice(100f);
		film1.setRentPrice(10f);
		filmManager.getFilmFromID(2).setSellPrice(85f);
		
		transManager.PurchaseFilm(user1.getID(), film1.getFilmID());
		transManager.PurchaseFilm(user2.getID(), 2);
		transManager.RentFilm(user2.getID(), 1);
		System.out.println(user1.toStringDetailed());
		System.out.println(user2.toStringDetailed());
	}
	
}
