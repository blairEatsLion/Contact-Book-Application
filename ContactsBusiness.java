//package contactBook;

// Name: class ContactsBusiness
// Creator: Xiaohui Wang
//Purpose: object of Business type
// Notes:  inherit and override methods from parent class 

public class ContactsBusiness extends Contacts{

	// constructor
	public ContactsBusiness(String type,String name,String phone, 
			String address, String BussinessName) {
		
		super(type, name, phone);	
		setAddress(address);	
		setBName(BussinessName);
	}
	
	// override method toString
	public String toString() {
		String result;
		result = "\nName: " + getName() + "\nPhone: " + getPhone()
        + "\nAddress: " + getAddress() + "\nBusiness Name: " + getBussinessName();
		return result;
    }
	
	// override method display in table form	
	public String display() {
		String result;
		result = String.format("%15s%15s%20s%20s%20s%20s\n", getType(), getName(), getPhone(), getAddress(), getBussinessName(),"");
		return result;
	}
	
}
