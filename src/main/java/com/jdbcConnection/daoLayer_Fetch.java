package com.jdbcConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class daoLayer_Fetch {


    public static void main(String[] args)
    {

       StudentDao dao = new StudentDao();
       student s1 = dao.getstudent(1);
        System.out.println(s1.CompanyName);
    }
}
  class  StudentDao
  {
      public  student getstudent (int ID )
      {
          try {
              String query = "select * from CarrierCompany ";
              student s = new student();
              s.ID =ID;
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "krish");
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(query);
              rs.next();
              int Id =rs.getInt(1);
              String name = rs.getString(2);
              s.CompanyName = name;
              return s;
          } catch (Exception ex) {
              System.out.println(ex);
          }
          return null;
      }
  }

  class  student
  {
      int ID;
      String CompanyName ;
  }