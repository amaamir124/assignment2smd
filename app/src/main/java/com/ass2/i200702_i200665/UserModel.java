package com.ass2.i200702_i200665;

public class UserModel {

    private String UserId, Name,Email,ContactNo,Password;
    public UserModel(String userId,String name, String email, String contactNo, String password) {
        Name = name;
        Email = email;
        ContactNo = contactNo;
        Password = password;
        UserId=userId;

    }

    public UserModel() {

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
