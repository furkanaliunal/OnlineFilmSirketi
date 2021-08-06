package com.os.user;

import java.util.Collection;
import java.util.HashMap;


public class UserManager {
	private HashMap<Integer, IUser> users;
	private int lastID = 1;
	
	String error1 = "UNDEFINED users are not allowed";
	String error2 = "SUBSCRIBED user cant subscribe again";
	String error3 = "This ID is not avaible";
	String error4 = "Nothing found with id";
	
	public UserManager() {
		users = new HashMap<>();
	}
	
	public IUser addUser(IUser u) {
		/*if (users.get(u.getID()) != null) {
			System.out.println(error3);
			return;
		}*/
		switch (u.getUserType()) {
			case UNDEFINED:
				System.out.println(error1);
				break;
			case ORDINARY:
				OrdUser ordUser = new OrdUser(u.getName(), lastID, u.getPurchasedFilms());
				users.put(lastID++, ordUser);
				return ordUser;
			case SUBSCRIBED:
				SubUser subUser = new SubUser(u.getName(), lastID, u.getPurchasedFilms());
				users.put(lastID++, subUser);
				return subUser;
		}
		return null;
		
	}
	public void removeUser(int id) {
		users.remove(id);
	}
	public User getUserFromID(int id) {
		return (User)getUserFromID(id);
	}
	public IUser getIUserFromID(int id) {
		if (users.get(id) == null) {
			System.out.println(error4 + ": " + id);
			return null;
		}
		return users.get(id);
	}
	public Collection<IUser> getAllUsers(){
		return users.values();
	}
	public void subscribeUser(int id) {
		IUser u = users.get(id);
		if (isSubscribed(u)) {
			System.out.println(error2);
			return;
		}
		removeUser(id);
		addUser(new SubUser(u.getName(), id, u.getPurchasedFilms()));
	}
	public void subscribeUser(IUser user) {
		subscribeUser(user.getID());
	}
	public Boolean isSubscribed(IUser u) {
		if (u.getUserType() == UserType.SUBSCRIBED) {
			return true;
		}
		return false;
	}
	
}
