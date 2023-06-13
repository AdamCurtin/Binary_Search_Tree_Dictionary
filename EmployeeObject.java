/*
Programmers: Adam Curtin and Meghan Flaherty
CS 145 Java
Date: 5/25/2023
Purpose: Represents an employee record with various attributes
*/

package adamMeghanBinarySearchTree;

public class ACMFEmployeeObject extends ACMFMainDictionary {
    
    private int numberID;
    private String firstName;
    private String lastName;
	private String streetAddress;
	private String city;
	private int zipCode;
	private String email;
	private String phoneNumber;

    public ACMFEmployeeObject(int numberID, String firstName, String lastName, String streetAddress,
			String city, int zipCode, String email, String phoneNumber) {
		 if (numberID < 0) {
	            throw new IllegalArgumentException("Number ID must be non-negative.");
	        }
	        if (zipCode < 0) {
	            throw new IllegalArgumentException("Zip code must be non-negative.");
	        }
		this.numberID = numberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	// Getters
	public int getNumberID() {
		return numberID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	// end getters
	
	// Setters
	public void setNumberID(int numberID) {
		this.numberID = numberID;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void setZipCode(int zipCode) {
	    this.zipCode = zipCode;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	// end setters
	
	// to string method
	public String toString() {
		return "ID: " + numberID + "\n" +
				"Name: " + firstName + " " + lastName + "\n" +
				"Address: " + streetAddress + ", " + city + ", " + zipCode + "\n" +
				"Email: " + email + "\n" +				
				"Phone: " + phoneNumber;
	} // end toString
		
} // end EmployeeObject Class

