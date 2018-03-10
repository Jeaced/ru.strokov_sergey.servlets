package controllers;

import org.apache.log4j.Logger;

import java.sql.*;

public class LoginValidator {

    private static final Logger logger = Logger.getLogger(LoginValidator.class);

    protected static boolean checkLogIn(String login, String password) {
        boolean result = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:PORT/DB_name","username", "password");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM USERS WHERE login=? AND password=?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet returned = statement.executeQuery();
            result = returned.next();
        } catch(ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage(), e);
        }

        return result;
    }

    protected static boolean checkRegistration (String login) {
        boolean result = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:PORT/DB_name","username", "password");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM USERS WHERE login=?");
            statement.setString(1, login);
            ResultSet returned = statement.executeQuery();
            result = !returned.next();
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage(), e);
        }

        return result;
    }
}
