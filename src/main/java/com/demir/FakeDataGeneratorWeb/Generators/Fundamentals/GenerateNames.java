package com.demir.FakeDataGeneratorWeb.Generators.Fundamentals;


import com.demir.FakeDataGeneratorWeb.FakeDataGeneratorWebApplication;

import java.sql.Statement;
import java.sql.*;
import java.util.Random;

// The database for the Turkish names comes from https://gist.github.com/ismailbaskin/1325813
public class GenerateNames {
    public static char Gender;
    public static String NameGenerator() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        String name = null;
        String sql= null;

        Random random = new Random();

        // Connection to database.
        connection = DriverManager.getConnection("jdbc:h2:~/src/main/resources/databases/nameRepo".replace("~",System.getProperty("user.dir")));

        // Create a statement.
        stmt = connection.createStatement();

        //Sql statement for getting either male or female name with 50% probability.
        if (random.nextBoolean()) {
            Gender = 'M';
            sql = "SELECT isimler FROM isimler WHERE cinsiyet IN ('E', 'U') ORDER BY RAND() LIMIT 1";
        } else {
            Gender = 'F';
            sql = "SELECT isimler FROM isimler WHERE cinsiyet IN ('K', 'U') ORDER BY RAND() LIMIT 1";
        }

//       Execute the query.
        rs = stmt.executeQuery(sql);

//        Process the results.
        if (rs.next()) {
            name = rs.getString("isimler");
        }
//        System.out.println("Random name: " + name);
        return name;
    }
}