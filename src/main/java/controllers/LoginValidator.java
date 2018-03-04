package controllers;

import java.sql.*;

public class LoginValidator {

    protected static boolean checkLogIn(String login, String password) {
        boolean result = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diaries","postgres", "Sergeyumnov1");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM USERS WHERE login=? AND password=?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet returned = statement.executeQuery();
            result = returned.next();
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    protected static boolean checkRegistration (String login) {
        boolean result = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diaries","postgres", "Sergeyumnov1");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM USERS WHERE login=?");
            statement.setString(1, login);
            ResultSet returned = statement.executeQuery();
            result = !returned.next();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
