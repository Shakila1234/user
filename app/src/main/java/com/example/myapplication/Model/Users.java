package com.example.myapplication.Model;

public class Users {
    private String Name, Password, Address,  Phone,Email;



    public Users(String name, String password, String address, String phone, String email) {
        this.Name = name;
        this.Password = password;
        this.Address = address;
        this.Phone = phone;
        this.Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}

