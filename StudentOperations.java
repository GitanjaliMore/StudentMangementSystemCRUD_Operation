package com.edu;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentOperations {
private static Connection conn;
private static Statement stmt;
private static ResultSet rs;
private static int sid,sage,ret;
private static float sfees;
private static String semail,sname,sdob;
private static String sql;
private static Scanner sc = new Scanner(System.in);

	public static void getAllStudents() throws ClassNotFoundException, SQLException {
		conn = DatabaseConnection.getConnection();
		stmt = conn.createStatement();
		//System.out.println("connection ="+conn);
		 sql = "select * from student";
		 rs = stmt.executeQuery(sql);
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s","SID","SNAME","SAGE","SEMAIL","SFFES","SDOB");
		  System.out.println();
		  while(rs.next()) {
			  sid = rs.getInt("sid"); //rs.getInt(1);
			  sname = rs.getString("sname");
			  sage = rs.getInt("sage");
			  semail = rs.getString("semail");
			  sfees = rs.getFloat("sfees");
			  sdob = rs.getString("sdob");
		//System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+semail+"\t"+sfees+"\t"+sdob);
			  System.out.printf("%-20d%-20s%-20d%-20s%-20.2f%-20s",sid,sname,sage,semail,sfees,sdob);	
	          System.out.println();  
		  }
		
	}

	public static void getStudentById() throws ClassNotFoundException, SQLException {
		conn = DatabaseConnection.getConnection();
		stmt = conn.createStatement();
		System.out.println("Enter student id");
		sid = sc.nextInt();
		sql = "select * from student where sid="+sid;
		
         rs = stmt.executeQuery(sql);
	    
	    if(rs.next()) {
	    	//System.out.println("SID\tSNAME\tSAGE\tSEMAIL\tSFEES\tSDOB");
	    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s","SID","SNAME","SAGE","SEMAIL","SFFES","SDOB");
	    System.out.println();
	    sid = rs.getInt("sid"); //rs.getInt(1);
			  sname = rs.getString("sname");
			  sage = rs.getInt("sage");
			  semail = rs.getString("semail");
			  sfees = rs.getFloat("sfees");
			  sdob = rs.getString("sdob");
		//System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+semail+"\t"+sfees+"\t"+sdob);
   System.out.printf("%-20d%-20s%-20d%-20s%-20f%-20s",sid,sname,sage,semail,sfees,sdob);	
              System.out.println();
	    
	    }
	    else {
	    	System.out.println("Student not exists");
	    }
		
	}

	public static void updateStudentById() throws ClassNotFoundException, SQLException {
		conn = DatabaseConnection.getConnection();
		stmt = conn.createStatement();
		System.out.println("Enter student id");
		sid = sc.nextInt();
		String newemail,newname;
		
String s = "select * from student where sid ="+sid;
		
	    rs = stmt.executeQuery(s);
       
	    if(rs.next()) {
	    	while(true) {
	    	 //menu
	    	System.out.println("****Update menu*******");
	    	System.out.println("1.Update email");
	    	System.out.println("2.change name");
	    	System.out.println("3.Change age");
	    	System.out.println("4.Change DOB");
	    	System.out.println("5.Change fees");
	    	
	    	System.out.println("Enter your choice");
	    	int upch =sc.nextInt();
	    	
	    	switch(upch) {
	    	case 1: //change email
	    		    System.out.println("Change email");
	    		    System.out.println("Enter new email id");
	    		    newemail = sc.next();
	    		    sql = "update student set semail='"+newemail+"' where sid="+sid;
	    		    ret = stmt.executeUpdate(sql);
	    		    if(ret>0) {
	    		    	System.out.println("Email is changed successfully");
	    		    }else {
	    		    	System.out.println("Error");
	    		    }
	    		    break;
	    	case 2: //change name
    		    System.out.println("Change name");
    		    System.out.println("Enter new name ");
    		    newname = sc.next();
    		    sql = "update student set Sname='"+newname+"' where sid="+sid;
    		    ret = stmt.executeUpdate(sql);
    		    if(ret>0) {
    		    	System.out.println("name is changed successfully");
    		    }else {
    		    	System.out.println("Error");
    		    }
    		    break;
	    	case 3: //Change age
	    		    System.out.println("Change age");
	    		    System.out.println("Enter new age ");
	    		    int newage = sc.nextInt();
	    		    sql = "update student set sage='"+newage+"' where sid="+sid;
	    		    ret = stmt.executeUpdate(sql);
	    		    if(ret>0) {
	    		    	System.out.println("Age is changed successfully");
	    		    }else {
	    		    	System.out.println("Error");
	    		    }
	    		     
	    		    break;
	    	case 4: //change dob
	    		    System.out.println("Change dob");
	    		    System.out.println("Enter new dob ");
	    		    String newdob = sc.next();
	    		    sql = "update student set sdob='"+newdob+"' where sid="+sid;
	    		    ret = stmt.executeUpdate(sql);
	    		    if(ret>0) {
	    		    	System.out.println("dob is changed successfully");
	    		    }else {
	    		    	System.out.println("Error");
	    		    }
	    		     
	    		    
	    		    break;
	    	case 5: //change fees
	    		     System.out.println("Change fees");
	    		     System.out.println("Enter new fees ");
		    		    float newfees = sc.nextFloat();
		    		    sql = "update student set sfees='"+newfees+"' where sid="+sid;
		    		    ret = stmt.executeUpdate(sql);
		    		    if(ret>0) {
		    		    	System.out.println("fees is changed successfully");
		    		    }else {
		    		    	System.out.println("Error");
		    		    }
		    		     
	    		     break;
	        default: System.out.println("Invalid input (choice can be between 1 to 4");
	    		    
    	}
	    	System.out.println("Do you want to countinue update operation");
	    	System.out.println("press yes to continue else no to stop");
	    	String up = sc.next();
	    	if(up.equals("no"))
	    		break;
	    	
	  	}//while true
	    	
	   }else {
		System.out.println("ID not exits");
	}
	}
	public static void deleteStudentById() throws ClassNotFoundException, SQLException {
		conn = DatabaseConnection.getConnection();

		//create statment

		stmt = conn.createStatement();
		System.out.println("Enter student id");
		sid = sc.nextInt();
		String s ="select * from student where sid="+sid;
		rs=stmt.executeQuery(s);
		if(rs.next()) {
			String del=" delete from student where sid="+sid;
			
			int ret=stmt.executeUpdate(del);
			if(ret>0){
				System.out.println("Record is deleted");
			}
			else{
				System.out.println("database error");
			}
		}else
			{
				System.out.println("Student not exists");
			}
			
		}
	

	public static void addStudent() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		conn = DatabaseConnection.getConnection();
		//create statment

				stmt = conn.createStatement();
				System.out.println("Enter student id");
				sid = sc.nextInt();
				String s ="select * from student where sid="+sid;
				rs=stmt.executeQuery(s);
				if(rs.next()) {
					System.out.println("student id already exists cannot add record");
					
				
				}
					else{//not there go for insert
						System.out.println("Enter name");
						sname=sc.nextLine();
						
						sname=sc.nextLine();
						  System.out.println("Enter age");
						  sage = sc.nextInt();
						  System.out.println("Enter email");
						  semail = sc.next();
						  System.out.println("Enter fees");
						  sfees = sc.nextFloat();
						  System.out.println("Enter dob (yyyy-mm-dd)");
						  sdob = sc.next();
						  //| sid | sname  | sage | semail| sfees | sdob       |
				String ins ="insert into student values("+sid+",'"+sname+"',"+sage+",'"+semail+"',"+sfees+",'"+sdob+"')";
				          int ret = stmt.executeUpdate(ins);
				          if(ret>0) {
				        	  System.out.println("Registerd successfully");
				          }else {
				        	  System.out.println("database error");
				          }
					  }
				
	}

}
