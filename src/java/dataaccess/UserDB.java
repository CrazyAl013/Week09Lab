package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author Alex Tompkins - 821984
 */
public class UserDB {
    public List<User> getAll(String owner) throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT * FROM user";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString(1);
                boolean active = resultSet.getBoolean(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                String password = resultSet.getString(5);
                User user = new User(email, active, firstName, lastName, password);
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(statement);
            pool.freeConnection(connection);
        }
        //TODO: actually do something.
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
