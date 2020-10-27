<%-- 
    Document   : users
    Created on : Oct 27, 2020, 9:17:28 AM
    Author     : 584893
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <style>
            .grid-container {
                display: grid;
                grid-template-columns: auto auto auto;
                padding: 10px;
            }
            .grid-item {

            }

            .grid-item > h3 {
                /*                text-align: center;*/
            }
        </style>
    </head>
    <body>

        <div class="grid-container">
            <div class="grid-item">
                <h3>Add User</h3>
                <form>
                    <input placeholder="Email" type="email" required name="email" />
                    <br>
                    <input placeholder="First Name" type="text" required name="firstname" />
                    <br>
                    <input placeholder="Last Name" type="text" required name="lastname" />
                    <br>
                    <input placeholder="Password" type="password" required name="password" />
                    <br>
                    <select name="role">
                        <option value="system admin">System Admin</option>
                        <option value="regular user">Regular User</option>
                        <option value="company admin">Company Admin</option>
                    </select>
                    <br>
                    <input type="submit" value="Save" />
                </form>
            </div>

            <div class="grid-item">
                <h3>Manage Users</h3>
                <table border="1">
                    <tr>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.email}</td>
                            <td>${user.firstname}</td>
                            <td>${user.lastname}</td>
                            <td>${user.role}</td>
                            <td><a href="action=edit">Edit</a></td>
                            <td><a href="action=delete">Delete</a></td>
                        </tr>

                    </c:forEach>
                </table>
            </div>

            <div class="grid-item">
                <h3>Edit User</h3>
            </div>  
        </div>
    </body>
</html>
