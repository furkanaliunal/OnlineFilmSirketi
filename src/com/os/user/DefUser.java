package com.os.user;

import java.util.ArrayList;

public class DefUser extends User{
	public DefUser (String name, UserType userType) {
		super(name, userType, new ArrayList<>());
	}
	protected DefUser (String name, UserType userType, int id) {
		super(name, userType,  id, new ArrayList<>());
	}

}
