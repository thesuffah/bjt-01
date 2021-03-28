package com.bitguiders.bjt_01;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization  {
	public void seralize(Object obj){
		try {
			FileOutputStream fileStream = new FileOutputStream("serialized.txt");
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.writeObject(obj);
			objectStream.close();
			fileStream.close();
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
	public Object deserialize(){
		Object obj=null;
		try {
			FileInputStream fileStream = new FileInputStream("serialized.txt");
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			obj= objectStream.readObject();
			objectStream.close();
			fileStream.close();
		} catch (IOException|ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			
		}
		return obj;
	}
	public static void main(String[] args) {
		Employee e = new Employee("Abdul Kareem",34,10500);
		System.out.println(e.toString());
		
		Serialization s= new Serialization();
		s.seralize(e);
		
		Employee ee=null;
		ee = (Employee)s.deserialize();
		System.out.println("is ee null..?");
		System.out.println(ee.toString());

		//Externalizable example
		Employee2 e2 = new Employee2("Abdul Kareem",34,10500);
		System.out.println(e.toString());

		s.seralize(e2);
		
		Employee2 ee2=null;
		ee2 = (Employee2)s.deserialize();
		System.out.println("is ee2 null..?");
		System.out.println(ee2.toString());

	}

}
class Employee implements Serializable{
	String name=null;
	transient int    age=0;
	int salary=0;
	public Employee(String name,int age,int salary){this.name=name;this.age=age;this.salary=salary;}
	public String toString(){
		return "name="+name+",age="+age+",salary="+salary;
	}
}
class Employee2 implements Externalizable{
		String name=null;
	    int    age=0;
		int salary=0;
		public Employee2(){}
		public Employee2(String name,int age,int salary){this.name=name;this.age=age;this.salary=salary;}
		public String toString(){
			return "name="+name+",age="+age+",salary="+salary;
		}
		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(name);
			out.writeInt(salary);
			
		}
		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			name = (String)in.readObject();
			salary= in.readInt();
			
		}
}