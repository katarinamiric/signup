/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author korisnik
 */
public class Form {
    String form;
    String date;
    String gender;

    public Form() {
    }

    
    public Form(String form, String date, String gender) {
        this.form = form;
        this.date = date;
        this.gender = gender;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    

    
    
    
    
}
