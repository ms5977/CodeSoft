package com.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMangementSystemApp {

	public static void main(String[] args) {
		Connection connection=null;
	   try {
		   connection=connectionProvider.getConnection();
		   System.out.println(connection);
		   while(true)
			{
				 System.out.println("Student Management System Menu:");
	             System.out.println("1. Add Student");
	             System.out.println("2. Remove Student");
	             System.out.println("3. Display All Students");
	             System.out.println("4. Search the Student.");
	             System.out.println("5. Exit");
	             System.out.print("Enter your choice: ");
	             Scanner scanner = new Scanner(System.in);
	             int choice = scanner.nextInt();
	             scanner.nextLine();
	             
	             switch(choice)
	             {
	             	case 1:
	             		addStudent(connection, scanner);
	             		break;
	             	case 2:
	             		removeStudent(connection, scanner);
	             		break;
	             	case 3:
	             		displayAllStudents(connection);
	             		break;
	             	case 4:
	             		 searchStudent(connection, scanner);
	             		 break;
	             	case 5:
                        connection.close();
                        System.out.println("ThankYou For Using Services.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;	
	             		
	             }
			}

		   
	   }
	   catch (Exception e) 
	   {
		   e.printStackTrace();
	   }
		
	}
	
//	Methods
	private static void addStudent(Connection con,Scanner scanner) throws SQLException
	{
		System.out.println("Enter student Name:");
		String name=scanner.nextLine();
		
		System.out.println("Enter roll No:");
		int rollno=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter Grade");
		String grade=scanner.nextLine();
		
		String sql="insert into student(name,rollno,grade)values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, rollno);
		pstmt.setString(3, grade);
		pstmt.executeUpdate();
		System.out.println("Student Added Succesfully");
		
	}
	
	private static void removeStudent(Connection con,Scanner scanner) throws SQLException
	{
		System.out.println("Enter roll number to remove");
		int rollNoRemove=scanner.nextInt();
		scanner.nextLine();
		
		String sql="delete from student where rollno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, rollNoRemove);
		int i=pstmt.executeUpdate();
		
		if (i>0) {
			System.out.println("Student Remove Successfully");
		}
		else {
			System.out.println("Student Not Found");
		}
	}
	
	private static void displayAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM student";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setName(resultSet.getString("name"));
            student.setRollno(resultSet.getInt("rollno"));
            student.setGrade(resultSet.getString("grade"));
            students.add(student);
        }

        System.out.println("List of Students:");
        for (Student student : students) {
        	System.out.println("Name of Student:"+student.getName());
        	System.out.println("Roll No:"+student.getRollno());
        	System.out.println("Grade:"+student.getGrade());
        	System.out.println("========================================================================");
        	
        	
        }
    }
	
	public static void searchStudent(Connection con,Scanner scanner) throws SQLException
	{
		System.out.println("Enter roll no to Search Student:");
		int rollsearch=scanner.nextInt();
		scanner.nextLine();
		
		String sql="select *from student where rollno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, rollsearch);
		
		ResultSet resultSet=pstmt.executeQuery();
		
		if(resultSet.next())
		{
			int rollno=resultSet.getInt("rollno");
			String name=resultSet.getString("name");
			String grade=resultSet.getString("grade");
			
			System.out.println("Student Details:");
			System.out.println("Name: "+name);
			System.out.println("Roll Number: "+rollno);
			System.out.println("Grade: "+grade);
		}
		else {
			System.out.println("Student Not found.");
		}
	}
	
	
	
	
	
	
	

}
