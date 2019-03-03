// Program: ContactsTest
// Author : Xiaohui Wang
// Student ID: 260719359
// Created: September 2018
// Purpose: To exhaustively validate Contacts*.java class methods

//package contactBook;

import java.util.*;

public class ContactsTest {
	
	static List<Contacts> contacts = new ArrayList<>();
	
	public static void main(String[] args) {
			
		// test all methods in Contacts.java
		testConstructor();  
		testSetter1();
		testSetter2();
		testSetter3();
		testGet();
		testToString();
		testDisplay();
		
	}
	
	// test the constructors
	// The expectation is that all three types of contacts can be created and no errors are thrown
	
    private static void testConstructor(){
    	try {
	        Contacts contact1 = new ContactsAcquaintance("Acquaintance","Amy","13131313"); 
	        contacts.add(contact1);
	        Contacts contact2 = new ContactsBusiness("Business","Kyle","12223222","898 Cresent","Company Jade");
			contacts.add(contact2);
			Contacts contact3 = new ContactsFriend("Friend","Jane","5151514222","garden st.","98/10/9");
			contacts.add(contact3);          
        } catch (Exception e) {
            System.out.println("Error! Fail to support creation of all contacts");
        }
    }

	// For the 3 setter methods in Contacts,
	// The expectation is that some data of the contact is reset and no errors are thrown
	
	public static void testSetter1() {
		System.out.println("\nTest case for methods in Contacts "+ "setAddress" + " :");		

		System.out.println("before set:");
		System.out.println(contacts.get(1).toString()); 
		
		System.out.println("\nNow change the address to 'Montreal City'");		
		try {contacts.get(1).setAddress("Montreal City");} catch(Exception e){}
		
		System.out.println(contacts.get(1).toString()); 			
	}
	
	public static void testSetter2() {
		System.out.println("\nTest case for methods in Contacts "+ "setBName" + " :");		

		System.out.println("before set:");
		System.out.println(contacts.get(1).toString()); 

		System.out.println("\nNow change the business name to 'Ben & Jerry'");	
		try {contacts.get(1).setBName("Ben & Jerry");} catch(Exception e){}
		
		System.out.println(contacts.get(1).toString()); 	
	}
	
	public static void testSetter3() {
		System.out.println("\nTest case for methods in Contacts "+ "setBirthday" + " :");		

		System.out.println("before set:");
		System.out.println(contacts.get(2).toString()); 

		System.out.println("\nNow change the birthday to '97/2/9'");	
		try {contacts.get(2).setBirthday("97/2/9");} catch(Exception e){}
		
		System.out.println(contacts.get(2).toString()); 	
	}
	
	
	// For the getter methods in Contacts, 
	// The expectation is that all data can be returned and no errors are thrown
	
	public static void testGet() {
		System.out.println("\nTest case for methods in Contacts "+ "get" + " :");	
		try {
			for(int i = 0;i<contacts.size(); i++) {
	            System.out.println(contacts.get(i).getName());
	            System.out.println(contacts.get(i).getType());
	            System.out.println(contacts.get(i).getPhone());
	            System.out.println(contacts.get(i).getAddress());
	            System.out.println(contacts.get(i).getBussinessName());
	            System.out.println(contacts.get(i).getBirthday());
	            System.out.println("Executed without error\n");
			}
            
        } catch (Exception e) {
            System.out.println("Unable to retrieve info through get!");
        }		
	}
	

	// The expectation is that the data of particular contact can be returned in formatted way and no errors are thrown	
	// Note: toString method in Contacts.java can be overridden 
	
	public static void testToString() {
		System.out.println("\nTest case for methods in Contacts "+ "toString" + " :");	
		try {
			System.out.println(contacts.get(0).toString());
			System.out.println(contacts.get(1).toString());
            System.out.println(contacts.get(2).toString() + "\n");
        } catch (Exception e) {
            System.out.println("Unable to execute test!");
        }		
	}
	
	// The expectation is that info of contact can be returned as formatted table entry and no errors are thrown	
	// Note: display method in Contacts.java can be overridden
	
	public static void testDisplay() {
		System.out.println("\nTest case for methods in Contacts "+ "display" + " :");
		System.out.println(String.format("%15s%15s%20s%20s%20s%20s\n", 
				"TYPE","NAME","PHONE","ADRESS","BUSINESS NAME","BIRTHDATE"));  
		try {
			System.out.println(contacts.get(0).display());
			System.out.println(contacts.get(1).display());
            System.out.println(contacts.get(2).display() + "\n");
        } catch (Exception e) {
            System.out.println("Unable to execute test!");
        }
		
		System.out.println("\nTEST END\n");
	}
	
}
