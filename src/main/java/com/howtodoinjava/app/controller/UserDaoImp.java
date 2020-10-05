package com.howtodoinjava.app.controller;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    public static JdbcTemplate jdbcTemp;

    public UserDaoImp(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Override
    public List<user> viewTable(Connection con, String q) {

        List<user>list = new ArrayList<user>();
        PreparedStatement ps = null;
        ResultSet rs = null;      //using prepared statements to prevent SQL Injection

        String s = IndexController.tempusername;
        String query = "SELECT PASSWORD FROM USERS WHERE USERNAME =  ?";
        int id = 0;
        int i = 0;
        try (Statement stmt = con.createStatement()) {
            ps = con.prepareStatement(query);

            //set the parameters
            ps.setString(1, "%"+s+"%");


            rs = ps.executeQuery();
            while (rs.next()) {
               user user = new user();

                id = i;
                String username = rs.getString("username");
                String password = rs.getString("password");
                user.setName(username);
                user.setPass(password);
                list.add(user);
               System.out.println("USER NAME AND PASSWORD ARE: "+ username +" "+password);

                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
