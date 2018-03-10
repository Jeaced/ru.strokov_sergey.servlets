package controllers;

import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;


public class ContentDAO {
    private static final Logger logger = Logger.getLogger(ContentDAO.class);

    public static void addRecord(String text, String login) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:PORT/DB_name","username", "password");
            PreparedStatement statement = con.prepareStatement("INSERT INTO records(text, login) VALUES(?, ?);");
            statement.setString(1, text);
            statement.setString(2, login);
            statement.execute();
        } catch(ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage(), e);

        }
    }

    public static ArrayList<String> getRecords(String login) {
        //String[] result = null;
        ArrayList<String> result = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diaries","postgres", "Sergeyumnov1");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM RECORDS WHERE login=?;");
            statement.setString(1, login);
            ResultSet returned = statement.executeQuery();
            /*if(returned.next()) {
                Array arr = returned.getArray("text");
                result = (String[])arr.getArray();
            }*/

            while(returned.next()) {
                result.add(returned.getString("text"));
            }
        } catch(ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
