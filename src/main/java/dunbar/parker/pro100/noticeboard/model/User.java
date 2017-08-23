package dunbar.parker.pro100.noticeboard.model;

import java.time.LocalDate;

public class User {
	private String firstName, lastName, city, state, username, password;
	
	private LocalDate dob;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "User: " + getFirstName() + " " + getLastName() + " " + getCity() + " " + getState() + " " + getDob();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return this.getUsername().equals(other.getUsername());
	}

	
}
