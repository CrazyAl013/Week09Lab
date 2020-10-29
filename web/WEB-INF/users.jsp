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
                margin: 15px;
            }

            .grid-item > h3 {
                /*                text-align: center;*/
            }

            table {
                width: 100%;
            }

            input, select {
                width: 100%;
                margin-bottom: 8px;
            }

            #messageBox {
                padding: 12px;
                color: red;
                text-align: center;
            }


        </style>
    </head>
    <body>
        <div id="messageBox">
            <p>${message}</p>
        </div>

        <div class="grid-container">
            <div class="grid-item">
                <h3>Add User</h3>
                <form method="POST" action="users">
                    <input placeholder="Email" type="email" required name="email" />
                    <br>
                    <input placeholder="First Name" type="text" required name="firstname" />
                    <br>
                    <input placeholder="Last Name" type="text" required name="lastname" />
                    <br>
                    <input placeholder="Password" type="password" required name="password" />
                    <br>
                    <input type="hidden" name="action" value="add" />
                    <select name="role">
                        <option value="1" <c:if test="${user.role.id == 1}">selected</c:if>>System Admin</option>
                        <option value="2" <c:if test="${user.role.id == 2}">selected</c:if>>Regular User</option>
                        <option value="3" <c:if test="${user.role.id == 3}">selected</c:if>>Company Admin</option>
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
                            <td>${user.role.name}</td>
                            <td><a href="?action=edit&<c:out value='${user.email}'/>">Edit</a></td>
                            <td><a href="?action=delete&<c:out value='${user.email}'/>">Delete</a></td>
                        </tr>

                    </c:forEach>
                </table>
            </div>

            <div class="grid-item">
                <h3>Edit User</h3>
                <form method="POST" action="users">
                    <input placeholder="First Name" type="text" required name="firstname" value="${editUser.firstname}" />
                    <br>
                    <input placeholder="Last Name" type="text" required name="lastname" value="${editUser.lastname}" />
                    <br>
                    <input type="hidden" name="email" value="${editUser.email}" />
                    <input type="hidden" name="action" value="update" />
                    <select name="role">
                        <option value="1" <c:if test="${user.role.id == 1}">selected</c:if>>System Admin</option>
                        <option value="2" <c:if test="${user.role.id == 2}">selected</c:if>>Regular User</option>
                        <option value="3" <c:if test="${user.role.id == 3}">selected</c:if>>Company Admin</option>
                    </select>
                    <br>
                    <input type="submit" value="Save" />
                </form>
            </div>  
        </div>
    </body>
</html>
