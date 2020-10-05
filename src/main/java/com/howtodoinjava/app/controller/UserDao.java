package com.howtodoinjava.app.controller;


import java.sql.Connection;
import java.util.List;

public  interface UserDao {

    List<user> viewTable(Connection Con, String q);

}
