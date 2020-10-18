package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Oleg", "Smirnov", (byte) 23);
        System.out.println("User с именем – Oleg добавлен в базу данных");
        userService.saveUser("Maria", "Sharapova", (byte) 42);
        System.out.println("User с именем – Maria добавлен в базу данных");
        userService.saveUser("Evgeniy", "Kotov", (byte) 27);
        System.out.println("User с именем – Evgeniy добавлен в базу данных");
        userService.saveUser("Vladimir", "Putin", (byte) 57);
        System.out.println("User с именем – Vladimir добавлен в базу данных");
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
