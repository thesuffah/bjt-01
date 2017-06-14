package com.bitguiders.bjt_01._reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaReflection_ {

	public static void classStats(String clas) throws Exception{
		Class c= Class.forName(clas);
	      
	    System.out.println("Fields........");  
	    Field f[]=c.getDeclaredFields();  
	    for(int i=0;i<f.length;i++)  
	        System.out.println(f[i]);  
	      
	    System.out.println("Constructors........");  
	    Constructor con[]=c.getDeclaredConstructors();  
	    for(int i=0;i<con.length;i++)  
	        System.out.println(con[i]);  
	      
	        System.out.println("Methods........");  
	    Method m[]=c.getDeclaredMethods();  
	    for(int i=0;i<m.length;i++)  
	        System.out.println(m[i]);  
	   }  
	public static void printFields(Class clas,String... fields)throws Exception{
		Class c= clas;//Class.forName(clas);
	      
	    System.out.println("Fields........");  
	    Field f[]=c.getDeclaredFields();  
	    for(int i=0;i<f.length;i++)  
	        System.out.println(f[i]);  

	}
	public static void main(String[] args) throws Exception {
		printFields(Person.class);
	}
}
 class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
    }
}