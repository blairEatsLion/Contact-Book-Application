// Program: ContactsMain
// Author : Xiaohui Wang
// Student ID: 260719359
// Created: September 2018
// Purpose: a well-designed contacts application (a telephone book)

//package contactBook;

import java.util.*;

public class ContactsMain {
	
	//
	// initiate static integer variables for user input control
	// create an array list to keep track of all Contacts
	//
	
	static int choice;	
	static int contactType;	
	static Scanner scan = new Scanner(System.in);	
	static List<Contacts> contacts = new ArrayList<>();
		
	
	public static void main(String[] args) {
		
		choice = 0;
		
		// user begins with the loop asking choice of operation
		 validIn(scan);

		while(((choice == 1 || choice == 2)||choice == 3)){	
			
			//
			// case when new contact should be created, prompt user to choose a contact type
			//
			
			if(choice == 1) {		
				
				choice = 0;  // prevent infinite loop
				contactType = 0;  // allow user to choose contactType every time user want to add a new contact
		
				validRange(scan);
			
				//
				// 3 contact types handled with if statements
				//
				
				if(contactType==1) {
					
					// acquaintance type
					
					System.out.println("Enter name: ");
					String garbage= scan.nextLine(); // garbage collector
					String name = scan.nextLine();

					System.out.println("Enter phone: ");
					String phone = scan.nextLine();
					
					Contacts contact = new ContactsAcquaintance("Acquaintance",name,phone); // can see all methods in Contacts Class
					contacts.add(contact);
					
					System.out.println();			
				
					// ask whether user want to do another operation					
					 validIn(scan);
				}
				
				if(contactType==2) {
					
					// business type
					
					System.out.println("Enter name: ");
					String garbage= scan.nextLine(); // garbage collector
					String name = scan.nextLine();

					System.out.println("Enter phone: ");
					String phone = scan.nextLine();
					
					System.out.println("Enter address: ");
					String address = scan.nextLine();
					
					System.out.println("Enter bussiness name: ");
					String BussinessName = scan.nextLine();
		
					Contacts contact = new ContactsBusiness("Business",name,phone,address,BussinessName);
					contacts.add(contact);
					
					System.out.println();			
				
					 validIn(scan);								
				}
				
				if(contactType==3) {

					// friend type
					
					System.out.println("Enter name: ");
					String garbage= scan.nextLine(); // garbage collector
					String name = scan.nextLine();

					System.out.println("Enter phone: ");
					String phone = scan.nextLine();
					
					System.out.println("Enter address: ");
					String address = scan.nextLine();
					
					System.out.println("Enter birthday: ");
					String birthday = scan.nextLine();
		
					Contacts contact = new ContactsFriend("Friend",name,phone,address,birthday);
					contacts.add(contact);
					
					System.out.println();			
				
					 validIn(scan);								
				}
				
				
			}
			
			//
			// case when the program will search through contacts by name
			//
			
			if(choice == 2) {

				System.out.println("Enter a name to search: ");
				String garbage= scan.nextLine(); // garbage collector
				String targetName = scan.nextLine();

				boolean found = false; // record whether the first match has appeared
				int destination = -1;  //record the address of first matched record
				
				//
				// iterate the arrayList of contacts for first matched record
				//
				
				for(int i = 0; i < contacts.size(); i++){			
					if((contacts.get(i).getName().equals(targetName)) && (found == false)) {
						destination = i;
						found = true;
					}
				}

				if(!found) {
					System.out.println("Not found");
				}else {
					// call toString method to print the selected contact's information
					System.out.println(contacts.get(destination).toString());
				}
							
				System.out.println();
				
				choice = 0;  // to prevent infinite loop
				
				 validIn(scan);
			}
			
			//
			// case when displays all the contact information of all the users in a table-like format
			//
			
			if(choice == 3) {				
				choice = 0; // to prevent infinite loop
						
				System.out.println(String.format("%15s%15s%20s%20s%20s%20s\n", 
						"TYPE","NAME","PHONE","ADRESS","BUSINESS NAME","BIRTHDATE"));  // print header of table
				
				//
				// iterate through every entry of contact information
				// display the record accordingly for different contact types
				//
				
				for(int i = 0; i < contacts.size(); i++){				
					Contacts current = contacts.get(i);						
					System.out.println(current.display());				
					
				}	
				
				System.out.println();
				
				 validIn(scan);
			}
			
		}

		System.out.println("end of loop");
		
	}
	
	
	//
	// Helper methods to make main() less redundant and easier to debug
	//
	
	
	// Name: validIn
	// Creator: Xiaohui Wang
	// Purpose: provide stored access to prompt user input (for conciseness and optimality)
	//			Verify and prompt for valid choice option until satisfied
	// Inputs: Scanner
	// Outputs: None
	
	public static void validIn(Scanner scan){
		
		while(!(((choice == 1 || choice == 2)||choice ==3)||choice ==4)) {
		
			// print prompt
			String c1 = "New Contact";
			String c2 = "Find Contact";
			String c3 = "List All";
			String c4 = "Quit";
			
			System.out.println("1. " + c1 + "\n2. " + c2 + "\n3. " + c3 + "\n4. " + c4);
			
			// keep asking if input is not integer
			while(!scan.hasNextInt()) {
				System.out.println("Please enter a number");	
				System.out.println();
				System.out.println("1. " + c1 + "\n2. " + c2 + "\n3. " + c3 + "\n4. " + c4);	
				scan.next(); 
			}
			choice = scan.nextInt();
			
			// keep asking if input integer is outside the range
			if(!(((choice == 1 || choice == 2)||choice ==3)||choice ==4)) {
				System.out.println("Please enter an integer between 1 and 4");
			}

		}
	}
	
	
	// Name: validRange
	// Creator: Xiaohui Wang
	// Purpose: Verify and prompt for valid contact type until satisfied
	// Inputs: Scanner
	// Outputs: None
		
	public static void validRange(Scanner scan){
		
		while(!((contactType == 1 || contactType == 2)||contactType ==3)) {
				
			String s1 = "Acquaintance";
			String s2 = "Business";
			String s3 = "Friend";
			
			System.out.println();
			System.out.println("1. " + s1);
			System.out.println("2. " + s2);
			System.out.println("3. " + s3);			
			
			while(!scan.hasNextInt()) {
				System.out.println("Please enter a number");	
				System.out.println();
				System.out.println("1. " + s1 + "\n2. " + s2 + "\n3. " + s3);	
				scan.next(); 
			}
			contactType = scan.nextInt();
			
			if(!((contactType == 1 || contactType == 2)||contactType ==3)) {
				System.out.println("Please enter an integer between 1 and 3");
			}
		}
		
	}
	
}
