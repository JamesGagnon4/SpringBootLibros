package com.howtodoinjava.app.controller;

import java.io.IOException;
import java.sql.*;
import java.util.*;


import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;


@Controller
public class IndexController {
public static String search1;
public static String password = "default";
public static String tempusername = "Guest";
public static String username = tempusername;

@Autowired
JdbcTemplate jdbcTemplate;
	@RequestMapping("/")
	public String home(Map<String, Object> model) {

		model.put("username", username);
		return "index";
	}

	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		return "next";
	}
	//@RequestParam(value = "id", defaultValue = "false")String id,@RequestParam
	@RequestMapping(value = "/adduser", method = {RequestMethod.POST, RequestMethod.GET})
	public String adduser(Map<String, Object> model,@RequestParam(name ="un", required = false) String un,@RequestParam(name ="pw", required = false)String pw) {

		tempusername = un;
		password = pw;
		jdbcTemplate.update(
				"INSERT INTO USERS (username, password) VALUES (?, ?)",
				tempusername, password
		);
		model.put("test", "You have registered Username: "+tempusername+" Password: "+password);
		jdbcTemplate.update("DELETE FROM USERS WHERE username = null" );
		return "adduser";
	}

	@Autowired
	private BookDao bookDao;

	@RequestMapping(value = "/book", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView listBook(@RequestParam(name ="title", required = false) String title1,
								 @RequestParam(name ="author", required = false) String author1,
								 @RequestParam(name ="genre", required = false) String genre1,
								 @RequestParam(name ="price", required = false) Long price,
								 ModelAndView model, HttpServletResponse response) throws IOException, SQLException {

		response.getWriter().println("You searched for "+search1);
		Connection con = jdbcTemplate.getDataSource().getConnection();
		String s = escape(search1);
		String q = "SELECT * FROM BOOKS WHERE title like ? OR author_name like ? OR Genre like ?";

		List<book> listBooks = bookDao.viewTable(con, q);

		Map<String,Object> allObjectsMap = new HashMap<String,Object>();
		allObjectsMap.put("Books", listBooks);
		model.addAllObjects(allObjectsMap);
		String status = "True";
		if(author1 == null || title1 == null || genre1 ==null){
	System.out.println("Null error in book insertion");
		}
		else{
        System.out.println("You have added "+title1+genre1+author1+" to your cart");
        		jdbcTemplate.update(
		"INSERT INTO CART (author_name, title, genre, price, status) VALUES (?, ?, ?, ?,?)",
				author1, title1, genre1,price, status
		);}
		return model;
	}


	@RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
	public String sendForm(Map<String, Object> model,@RequestParam(name ="sr", required = false) String sr) {
		search1 = sr;
		System.out.println(search1);
		model.put("username", username);

		return "/search";
	}

	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public String login(Map<String, Object> model, @RequestParam(name ="un", required = false) String un,@RequestParam(name ="pw", required = false)String pw) {

		tempusername = un;
		password = pw;
		System.out.println(username +" "+password);

		model.put("username", username);

		return "login";
	}


	@RequestMapping(value = "/Result2", method = {RequestMethod.POST, RequestMethod.GET})
	public String result2(Map<String, Object> model,@RequestParam(name ="un", required = false) String un, @RequestParam(name ="pw", required = false)String pw) throws SQLException {
		Connection con = jdbcTemplate.getDataSource().getConnection();
		System.out.println("Generating User Queries");
		tempusername = un;
        System.out.println(tempusername);
        String pass = "";
        System.out.println(pw);

		PreparedStatement ps = null;
		ResultSet rs;     //using prepared statements to prevent SQL Injection

		String s = escape(tempusername);
		System.out.println("QUERYING FOR "+s);

		String query = "SELECT * from users WHERE username = ?";
			System.out.println(query + s);
		user u = new user();
		try (Statement stmt = con.createStatement()) {
			System.out.println("PREPARING STATEMENT");
			ps = con.prepareStatement(query);
            System.out.println("STATEMENT PREPARED");
			//set the parameters
			ps.setString(1, s);
			System.out.println(ps.toString());
			System.out.println("Parameters set");

			rs = ps.executeQuery();
			System.out.println("QUERY EXECUTED");

			if (rs.next()) {
			pass = rs.getString("password");
				System.out.println("Password Set To "+pass);
				pw = escape(pw);
			}
if(pw.equals(pass)){
	System.out.println("Password Match");
	username = tempusername;
	String message = "Welcome back "+username+"!";
	model.put("message", message);
}
else{
	String message = "Invalid Username or Password.";
	model.put("message", message);
}
			//}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


		return "Result2";
	}
	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	public ModelAndView listBook( ) throws SQLException {
		ModelAndView model = new ModelAndView();
		PageContent pageContent = new PageContent();
		pageContent.setHeaderName("View Cart");
		model.addObject(pageContent);
		Connection con = jdbcTemplate.getDataSource().getConnection();
		String q = "SELECT * FROM CART WHERE STATUS = ?";
		String status = "True";
		List<book> listBooks = bookDao.viewTable(con, q, status);

		Map<String,Object> allObjectsMap = new HashMap<String,Object>();
		allObjectsMap.put("Books", listBooks);
		model.addAllObjects(allObjectsMap);

		model.setViewName("viewCart");
		return model;
	}

public static class Search{

	String search = search1;

}
//Escape from potentially malicious inputs.
	public String escape(String inputString){
		final String[] metaCharacters = {"\\","^","$","{","}","[","]","(",")",".","*","+","?","|","<",">","-","&","%"};

		for (int i = 0 ; i < metaCharacters.length ; i++){
			if(inputString.contains(metaCharacters[i])){
				inputString = inputString.replace(metaCharacters[i],"\\"+metaCharacters[i]);
			}
		}
		return inputString;
	}
}
