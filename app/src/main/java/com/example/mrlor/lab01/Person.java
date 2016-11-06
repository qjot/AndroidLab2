package com.example.mrlor.lab01;

/**
 * Created by mrlor on 25.10.2016.
 */

public class Person {

    private String name;
    private String surname;

    public Person(String n, String s){
        name = n;
        surname = s;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
    return "Name: '" + this.name + "', Surname: '" + this.surname + "'";
    }

}
