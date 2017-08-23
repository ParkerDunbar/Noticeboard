package dunbar.parker.pro100.noticeboard.controller;

import java.time.LocalDate;

import dunbar.parker.pro100.noticeboard.model.User;
import dunbar.parker.pro100.noticeboard.view.LoginScreen;
import javafx.application.Application;

public class Main {
	
	public void initialize() throws Exception {
		loadOnLaunch();
		Application.launch(LoginScreen.class);
		saveOnClose();
	}
	
	public boolean createUser(String firstName, String lastName, String city, String state,
			String username, String password, LocalDate dob) {
		if(firstName == null || lastName == null || city == null || state == null ||
				username == null || password == null || dob == null) {
			return false;
		}
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setCity(city);
		newUser.setState(state);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setDob(dob);
		return true;
	}
	
	public void loadOnLaunch() {
		
	}
	
	public void saveOnClose() {
		
	}
}
