package com.howtodoinjava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class JdbcRepository {
@Autowired
public static JdbcTemplate jdbcTemplate;
    private static final String deleteSql = "DELETE FROM CART WHERE bid = ?";
    public void insertCart() {
        jdbcTemplate.update("INSERT INTO CART (title, author_name, genre) VALUES ('book name', 'book description', 'test')");
    }
    public static void deleteRecord(int id) {

        // define query arguments
        Object[] params = { id };


        // define SQL types of the arguments
        int[] types = {Types.BIGINT};


        int rows = jdbcTemplate.update(deleteSql, params, types);



        System.out.println(rows + " row(s) deleted.");


    }
}