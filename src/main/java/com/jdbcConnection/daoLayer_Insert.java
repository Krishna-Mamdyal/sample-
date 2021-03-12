package com.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class daoLayer_Insert {


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
         student s2 = new student();
         s2.ID= 07 ;
         s2.CompanyName = "Suraj";
          dao.connect();
         dao.addStudent(s2);
    }
}
 class StudentDAO
{
    Connection con = null;
    public  void connect ()
    {
        try{
            Class.forName("com.sql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myAlien","root","krish123@");
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void addStudent (student s)
        {
            String query = "insert into CarrierCompany values (? ?)";
            PreparedStatement pst ;
            try{
                pst = con.prepareStatement(query);
                pst.setInt(1,s.ID);
                pst.setString(2,s.CompanyName);
                pst.executeUpdate();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
}
class Student
{
    int ID;
    String CompanyName ;

}