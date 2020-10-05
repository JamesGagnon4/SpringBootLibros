package com.howtodoinjava.app.controller;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity // This tells Hibernate to make a table out of this class
public class book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private   Integer id;
    private   String authorName;
    private   String title;
    private   String genre;
    private   Long price;

    public  String getTitle(){ return this.title;}
    public  String getGenre(){ return this.genre;}
    public String getAuthor(){ return this.authorName;}
    public void setId(Integer bid) {
        id= bid;
    }
    public  Long getPrice() {
        return this.price;
    }
    public void setName(String name) {
        this.authorName = name;
    }

    public String title() {
        return this.title;
    }

    public  void setTitle(String title1) {
        this.title = title1;
    }
    public String genre() {
        return this.genre;
    }

    public void setGenre(String genre1) {
        this.genre = genre1;
    }
    public Long price() {
        return this.price;
    }

    public void setPrice(Long price1) {
        this.price = price1;
    }

    public String getAuthorName() {
        return authorName;
    }
    public String toString(){
        String string = this.title+" " + this.authorName+" "+this.genre;
        return string;
    }
    public book (int bid, String authorName1, String title1, String genre1){
this. id = bid;
this.authorName = authorName1;
this.title = title1;
this.genre = genre1;
    }
    public book(String authorName, String title,String Genre, Long Price){
 this.authorName = authorName;
 this.title = title;
 this.genre = Genre;
 this.price = Price;
    }
    public book(int bid, String authorName1, String title1, String genre1, Long Price1){
        this.id = bid;
        this.authorName = authorName1;
        this.title = title1;
        this.genre = genre1;
        this.price = Price1;
    }
    public book(){

    }

    public Integer getGetId() {
        return id;
    }
}