package com.jdbcConnection;

import java.sql.*;

public class insertValue {


    public static void main(String[] args)  throws Exception
    {
         int ID = 2;
         String CompanyName= "HDFC";
         String query = "insert into CarrierCompany   values (?,?)";

        //load Mysql supplied JDBC driver class
         Class.forName("com.mysql.cj.jdbc.Driver");
          //get the fixed connection to database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","krish");
       //the query which has parameter
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1,ID);
        st.setString(2,CompanyName);
        int count  = st.executeUpdate();
        System.out.println(count + "rows affected");

         st.close();
         con.close();

    }
}
