//package contactBook;

// Name: class ContactsFriend
// Creator: Xiaohui Wang
// Purpose: object of Friend type
// Notes:  inherit and override methods from parent class 

public class ContactsFriend extends Contacts {
	
	// constructor
	public ContactsFriend(String type,String name,String phone, 
			String address, String birthday) {
		
		super(type, name, phone);
		setAddress(address);	
		setBirthday(birthday);
	}

	// override method toString
	public String toString() {
		String result;
		result = "\nName: " + getName() + "\nPhone: " + getPhone()+ "\nAddress: " 
				+ getAddress() + "\nBirthday: " + getBirthday();
		return result;
    }
	
	// override method display in table form
	public String display() {
		String result;
		result = String.format("%15s%15s%20s%20s%20s%20s\n", getType(), getName(), getPhone(), getAddress(), "", getBirthday());
		return result;
	}
}
