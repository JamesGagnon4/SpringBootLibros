package com.howtodoinjava.app.controller;

import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;
import com.howtodoinjava.app.controller.book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BookDaoImp implements BookDao {
    public static JdbcTemplate jdbcTemp;

    public BookDaoImp(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Override
    public List<book> viewTable(Connection con, String q) {

        List<book>bookList = new ArrayList<book>();
        PreparedStatement ps = null;
        ResultSet rs = null;      //using prepared statements to prevent SQL Injection

        String s = IndexController.search1;
        String query = q;//"SELECT * FROM BOOKS WHERE title like ? OR author_name like ? OR Genre like ?";
        int id = 0;
        int i = 0;
        try (Statement stmt = con.createStatement()) {
             ps = con.prepareStatement(query);

            //set the parameters
            ps.setString(1, "%"+s+"%");
            ps.setString(2, "%"+s+"%");
            ps.setString(3, "%"+s+"%");

            rs = ps.executeQuery();
            while (rs.next()) {
                book book = new book();

                id = i;
                String author = rs.getString("Author_Name");
                String title = rs.getString("title");
                String genre = rs.getString("Genre");
                Long price =rs.getLong("Price");
                book.setTitle(title);
                book.setName(author);
                book.setGenre(genre);
                book.setPrice(price);
                bookList.add(book);
//                System.out.println(book.title() + ", " + book.getAuthorName() + ", " + book.genre() +
//                        ", " + book.price());

                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bookList;
    }
    @Override
    public List<book> viewTable(Connection con, String q, String stat) {

        List<book>bookList = new ArrayList<book>();
        PreparedStatement ps = null;
        ResultSet rs = null;      //using prepared statements to prevent SQL Injection


        String query = q;
        int id = 0;
        int i = 0;
        try (Statement stmt = con.createStatement()) {
            ps = con.prepareStatement(query);

            //set the parameters
            ps.setString(1, stat);

            rs = ps.executeQuery();
            while (rs.next()) {
                book book = new book();

                id = i;
                String author = rs.getString("Author_Name");
                String title = rs.getString("title");
                String genre = rs.getString("Genre");
                Long price =rs.getLong("Price");
                book.setTitle(title);
                book.setName(author);
                book.setGenre(genre);
                book.setPrice(price);
                bookList.add(book);
//                System.out.println(book.title() + ", " + book.getAuthorName() + ", " + book.genre() +
//                        ", " + book.price());

                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bookList;
    }
}
