package controllers;

import java.sql.*;
import java.util.ArrayList;

public class ContentDAO {
    public static void addRecord() {

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
                System.out.println(result.size());
            }
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
