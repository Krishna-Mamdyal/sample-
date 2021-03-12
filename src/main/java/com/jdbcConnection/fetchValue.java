package com.jdbcConnection;
import  java.sql.*;

public class fetchValue {
    public static void main(String[] args) {
        try {
            String query = "select * from  CarrierCompany ";


            //load Mysql supplied JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get the fixed connection to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "krish");
            //the query which is not requre  parameter
            Statement st = con.createStatement();
            // to execute the query we should use the resultset
            ResultSet rs = st.executeQuery(query);
            //
            String userData = "";
            while (rs.next())
            {
                String userdata = rs.getInt(1) + ":" + rs.getString(2);
                System.out.println(userdata);
            }
            // close all the
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e+":Error");
                }
        }
}
