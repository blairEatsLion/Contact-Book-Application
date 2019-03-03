// Program: contactBook
// Author : Xiaohui Wang
// Student ID: 260719359
// Created: September 2018
// Purpose: Develop basic structure with methods for the 3 contact types

//package contactBook;

abstract class Contacts {

	private String type;
	private String name;
	private String phone;
	private String address;
	private String BussinessName;
	private String birthday;
	
	// Contacts Constructor
	// Purpose: constructor for top-level contacts object
	// Parameters: type of contact, name and phone
	
	public Contacts(String type, String name, String phone) {
		this.type = type;
		this.name = name;
		this.phone = phone;		
	}
	
	
	// Setter methods
	// Purpose: public methods to set additional protected information
	// Inputs: the new string to be binded to private variable
	// Outputs: boolean - true if data is successfully set
	
	public boolean setAddress(String address) {
		this.address = address;
		return true;
	}
	public boolean setBName(String BussinessName) {
		this.BussinessName = BussinessName;
		return true;
	}
	public boolean setBirthday(String birthday) {
		this.birthday = birthday;
		return true;
	}
	
	// Getter methods
	// Purpose: return the private variables
	// Inputs: none	
	// Outputs: the private parameter for contacts
	
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getBussinessName() {
		return BussinessName;
	}
	public String getBirthday() {
		return birthday;
	}
	
	
    // toString method
    // Purpose: Returns a formatted string to give information about particular contact
    // Inputs: none	
	// Outputs: String
	
	public String toString() {
		String result;
		result = "\nName: " + getName() + "\nPhone: " + getPhone();
        return result;
    }
	
    // display method
    // Purpose: Returns a formatted string to display a record in table form
    // Inputs: none	
	// Outputs: String
	
	public String display() {
		String result;
		result = String.format("%15s%15s%20s%20s%20s%20s\n", getType(), getName(), getPhone(),"","","");
		return result;
	}
	 
	
}