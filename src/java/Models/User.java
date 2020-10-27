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
package Models;
import java.io.Serializable;
/**
 *
 * @author 808735
 */
public class User implements Serializable {
     
    private String firstName;
    private String lastName;
    private String password;
    private Boolean active=true;
    private String email;

    public User () {
    }

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
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
