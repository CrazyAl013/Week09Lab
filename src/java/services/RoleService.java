/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.List;

/**
 *
 * @author BTran
 */
public class RoleService {
    public List<Role> getAll(int role) throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll(role);
        return roles;
    }
}