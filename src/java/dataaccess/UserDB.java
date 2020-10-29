package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.*;

/**
 *
 * @author Alex Tompkins - 821984
 */
public class UserDB {
    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet usersSet = null;
        ResultSet roleSet = null;
        
        String getUsers = "SELECT * FROM user";
        String getRole = "SELECT role_name FROM role where role_id=?";
        try {
            statement = connection.prepareStatement(getUsers);
            usersSet = statement.executeQuery();
            while (usersSet.next()) {
                String email = usersSet.getString(1);
                boolean active = usersSet.getBoolean(2);
                String firstName = usersSet.getString(3);
                String lastName = usersSet.getString(4);
                String password = usersSet.getString(5);
                int roleId = usersSet.getInt(6);
                
                statement = connection.prepareStatement(getRole);
                statement.setInt(1, roleId);
                roleSet = statement.executeQuery();
                
                Role role = new Role(roleId, roleSet.getString(1));
                
                User user = new User(email, active, firstName, lastName, password, role);
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(usersSet);
            DBUtil.closePreparedStatement(statement);
            pool.freeConnection(connection);
        }
        return users;
    }
    
    public User get(int userId) throws Exception {
        //TODO: actually do something.
        return null;
    }
    
    public void insert(User user) throws Exception {
        //TODO: actually do something.
    }
    
    public void update(User user) throws Exception {
        //TODO: actually do something.
    }
    
    public void delete(User user) throws Exception {
        //TODO: actually do something.
    }
}
