package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Users " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, "+
                    "name VARCHAR(20), " +
                    "lastName VARCHAR(20), " +
                    "age TINYINT)");
        } catch (SQLException ignored) {
        }
    }

    public void dropUsersTable() {
        try(Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Users");
        } catch (SQLException ignored) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT Users(name, lastName, age) " +
                    "VALUES ('" + name + "', '" + lastName + "', " + age+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Users WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age"));
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
