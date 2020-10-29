/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.Serializable;
/**
 *
 * @author 808735
 */
public class User implements Serializable {
    private String email;
    private Boolean active=true;
    private String firstName;
    private String lastName;
    private String password;



    public User () {
    }

    public User(String email, boolean active, String firstName, String lastName, String password) {
        this.email = email;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }



    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(int noteId) {
        this.firstName = firstName;
    }
    

    public String lastName() {
        return lastName;
    }

    public void setlastName(String title) {
        this.lastName = lastName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String contents) {
        this.password = password;
    }

    public String email() {
        return email;
    }

    public void setemail(String owner) {
        this.email = email;
    }
    
}
