package controllers;

import java.sql.*;

public class RegistationDAO {
    protected static void register(String login, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diaries","postgres", "Sergeyumnov1");
            PreparedStatement statement = con.prepareStatement("INSERT INTO USERS(LOGIN, PASSWORD) VALUES(?, ?);");
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
