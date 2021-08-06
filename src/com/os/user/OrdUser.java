package com.os.user;

import java.util.ArrayList;

public class OrdUser extends User{	
	
	public OrdUser (String name) {
		super(name, UserType.ORDINARY, new ArrayList<>());
	}
	protected OrdUser (String name, int id, ArrayList<Integer> purchasedFilms) {
		super(name, UserType.ORDINARY, id, purchasedFilms);
	}

}
