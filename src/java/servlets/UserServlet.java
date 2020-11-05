/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;
import services.*;

/**
 *
 * @author 584893
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");

        // Perform methods based on the action
        try {
            switch (action) {
                case "edit":
                    User user = us.get(email);
                    request.setAttribute("editUser", user);
                    break;
                case "delete":
                    us.delete(email);
                    request.setAttribute("message", "User Deleted Successfully"); 
                    request.setAttribute("messageType", "success");
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            if (action != null) {
                request.setAttribute("message", "Could not perform action: " + action);
            }
        }
        
        try {
            List<User> users = us.getAll();
            
            request.setAttribute("users", users);
        } catch(Exception e)  {
            request.setAttribute("message", "No users found");  
            request.setAttribute("messageType", "error");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the edit or delete action (action=edit) (action=delete) (action=add)
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        int roleID = Integer.parseInt(request.getParameter("role"));
        Boolean active = false;
        
        // Create User Service
        UserService us = new UserService();

        // Perform methods based on the action
        try {
            switch (action) {
                case "add":
                    us.insert(email, active, firstname, lastname, password, roleID);
                    request.setAttribute("message", "User Added Successfully"); 
                    request.setAttribute("messageType", "success");
                    break;
                case "update":
                    us.update(email, active, firstname, lastname, password, roleID);
                    request.setAttribute("message", "User Updated Successfully"); 
                    request.setAttribute("messageType", "success");
                    break;
                
                default:
                    break;
            }

        } catch (Exception e) {
            request.setAttribute("message", "Could not perform action: " + action); 
            request.setAttribute("messageType", "error");
        }
        
        try {
            List<User> users = us.getAll();

            request.setAttribute("users", users);
        } catch(Exception e)  {
            request.setAttribute("message", "No users found");   
            request.setAttribute("messageType", "error");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
