package com.login;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

public class Validation {

	public static boolean checkUser(Key key) {
		boolean status = false;
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		try {
			ds.get(key);

			status = true;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			status = false;
		}

		return status;
	}

	public static boolean loginNullCheck(String userName, String password) {
		if (userName != "" && password != "")
			return true;
		else
			return false;
	}
}
