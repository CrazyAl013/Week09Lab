/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.DBUtil;
import dataaccess.RoleDB;
import models.*;
import dataaccess.UserDB;
import java.util.List;
import javax.persistence.EntityManager;
import static org.eclipse.persistence.platform.database.oracle.plsql.OraclePLSQLTypes.Int;

/**
 *
 * @author BTran
 */
public class UserService {
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void insert(String email, boolean activity, String first_name, String last_name, String password, int roleID) throws Exception{
        //TODO:
        // replace Role role parameter with a int id, then get a Role object from RoleDB using the role id. then assign it to the user
        // also add user to the Role User list
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        User user = new User(email, activity, first_name, last_name, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean activity, String first_name, String last_name, String password, int roleID) throws Exception{
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setRole(role);
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}






