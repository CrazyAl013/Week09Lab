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
        
        // TODO: Request the users from the database
        UserService us = new UserService();
//        List<User> users = us.getAll();
// TODO: UserService is missin getAll()
        
        // TODO: Add the users to the request object
//        request.setAttribute("users", users);
           
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // TODO: Get the edit or delete action (action=edit) (action=delete) (action=add)
            
        // TODO: Perform methods based on the action
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }


}
