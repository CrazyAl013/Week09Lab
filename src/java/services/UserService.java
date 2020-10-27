/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;

/**
 *
 * @author BTran
 */
public class UserService {
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public User get(boolean activity) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(activity);
        return user;
    }
    
    public User get(String first_name) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(first_name);
        return user;
    }
    
    public User get(String last_name) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(last_name);
        return user;
    }
    
    public User get(String password) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(password);
        return user;
    }
    
    public void insert(String email, boolean activity, String first_name, String last_name, String password, int role) throws Exception{
        User user = new User(0, email, activity, first_name, last_name, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(int userID, String email, boolean activity, String first_name, String last_name, String password, int role) throws Exception{
        User user = new User(0, email, activity, first_name, last_name, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void delete(int userID) throws Exception{
        User user = new User();
        user.setUserID(userID);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}






