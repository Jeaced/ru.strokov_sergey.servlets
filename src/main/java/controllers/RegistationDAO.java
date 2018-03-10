package controllers;

import org.apache.log4j.Logger;

import java.sql.*;

public class RegistationDAO {

    private static final Logger logger = Logger.getLogger(RegistationDAO.class);

    protected static void register(String login, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:PORT/DB_name","username", "password");
            PreparedStatement statement = con.prepareStatement("INSERT INTO USERS(LOGIN, PASSWORD) VALUES(?, ?);");
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();
        } catch(ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
