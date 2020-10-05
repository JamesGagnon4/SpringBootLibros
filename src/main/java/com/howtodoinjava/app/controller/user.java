package com.howtodoinjava.app.controller;

public class user {
        private long id;
        private String username, password;
public user(){

}
        public user(String username, String password) {

            this.username = username;
            this.password = password;
        }

//        @Override
//        public String toString() {
//            return String.format(
//                    "User[id=%d, UserName='%s', Password='%s']",
//                    id, username, password);
      //  }
public String getUsername(){
            return this.username;
}
    public String getPassword(){
        return this.password;
    }

    public void setName(String name) {
    }

    public void setPass(String password) {
    }
    // getters & setters omitted for brevity
    }

