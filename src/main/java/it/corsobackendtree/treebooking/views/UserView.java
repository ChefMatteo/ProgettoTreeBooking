package it.corsobackendtree.treebooking.views;

import it.corsobackendtree.treebooking.Gender;

import java.time.LocalDate;

public class UserView {

    private final String username;
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private final Gender gender;
    private final String password;

    //Constructor
    public UserView(String username, String name, String surname, LocalDate birthDate, Gender gender, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.password = password;
    }

    //Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Gender getGender() {
        return gender;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
}
