package org.dissan.restaurant.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public abstract class LoggedUser {
    protected String username;
    protected String password;
    protected String name;
    protected String surname;
    protected String dateOfBirth;
    protected int age;

    protected LoggedUser(String usr, String pwd) {
        this.username = usr;
        this.password = pwd;
    }

    protected LoggedUser(String usr, String pwd, String name, String surname, String date) throws ParseException {
        this.setUsername(usr);
        this.setPassword(pwd);
        this.setName(name);
        this.setSurname(surname);
        this.setDateOfBirth(date);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateToConvert = null;
        try {
            dateToConvert = format.parse(date);
        } catch (ParseException e) {
            format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                dateToConvert = format.parse(date);
            } catch (ParseException ex) {
                format = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    dateToConvert = format.parse(date);
                } catch (ParseException exc) {
                    throw new ParseException("Bad date: " + date, exc.getErrorOffset());
                }
            }
        }
        LocalDate now = LocalDate.now();
        LocalDate birth = LocalDate.parse(toFormat.format(dateToConvert));

        this.age = Period.between(birth, now).getYears();


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
