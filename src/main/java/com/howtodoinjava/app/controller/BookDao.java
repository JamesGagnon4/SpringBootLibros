package com.howtodoinjava.app.controller;


import java.sql.Connection;
import java.util.List;

public interface BookDao {

    //public List<book> bookList();
List<book> viewTable(Connection Con, String q);
List<book> viewTable(Connection Con, String q, String stat);
}
