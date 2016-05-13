package com.effortmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.effortmanagement.dao.UserDatabase;
import com.effortmanagement.exceptions.PasswordsIsWrongException;
import com.effortmanagement.exceptions.UserNameAlreadyExistException;
import com.effortmanagement.model.ChangePasswort;
import com.effortmanagement.model.CreateUser;
import com.effortmanagement.model.User;

public class UserService {

	private UserDatabase userDatabase = new UserDatabase();

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	public User getUser(String userName) {
		User user = userDatabase.getUserByName(userName);
		return user;
	}

	public User getUser(int userId) {
		User user = userDatabase.getUserById(userId);
		return user;
	}

	public void changePasswort(int userId, ChangePasswort passwort) {
		if (passwort.getOldPasswort().equals(userDatabase.getPasswort(userId))) {
			userDatabase.changePasswort(userId, passwort.getNewPasswort());
		} else {
			logger.error("altest Passwort falsch(eingegeben, muss): " + passwort.getOldPasswort() + " , "
					+ userDatabase.getPasswort(userId));
			throw new PasswordsIsWrongException("Das eingegebene Passwort ist falsch");
		}

	}

	public void changeEmail(int userId, String newEmail) {
		userDatabase.changeEmail(userId, newEmail);

	}

	public void changeUserName(int userId, String newUserName) {
		logger.debug("NewUserName: " + newUserName);
		User testUser = userDatabase.getUserByName(newUserName);
		if (testUser != null) {
			logger.debug("testUser != null");
			if (testUser.getUserId() != userId) {
				logger.debug("testUser.getUserId,userId = " + testUser.getUserId() + " , " + userId);
				if (testUser.getUserName().equals(newUserName)) {
					throw new UserNameAlreadyExistException("Dieser User Name ist bereits vergeben");
				}
			}
		}
		userDatabase.changeUserName(userId, newUserName);

	}

	public void changeHochschule(int userId, String newHochschule) {
		userDatabase.changeHochschule(userId, newHochschule);
	}

	public void newUser(CreateUser user) {
		if (userDatabase.getUserByName(user.getUserName()) != null) {
			throw new UserNameAlreadyExistException("Dieser User Name ist bereits vergeben");
		}
		userDatabase.newUser(user);
	}

	public String getPasswort(int userId) {
		return userDatabase.getPasswort(userId);
	}
}
