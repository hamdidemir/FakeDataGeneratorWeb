package com.demir.FakeDataGeneratorWeb.Generators.Fundamentals;


import java.sql.*;

// The database used for Turkish surnames comes from: https://gist.github.com/BedirYilmaz/7e47550023a157dcc71dfcb6412f0b31
public class GenerateSurnames {
    public static String surnameGenerator() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        String surname = null;

        // Connection to database.
        connection = DriverManager.getConnection("jdbc:h2:~/SurnameRepo".replace("~",System.getProperty("user.home")));
        // Create a statement.
        stmt = connection.createStatement();

        //Create SQL statement to obtain a random surname
        String sql="SELECT soyisim FROM soyisimler ORDER BY RAND() LIMIT 1";

//      Execute the query.
        rs = stmt.executeQuery(sql);

//      Process the results.
        if (rs.next()) {
            surname = rs.getString("soyisim");
        }
//            System.out.println("Random name: " + name);

        return surname;



    }
}
