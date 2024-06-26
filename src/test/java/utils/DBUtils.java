package utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {



    public static List<Map<String,String>> fetch(String query){



        List<Map<String,String>> tableData=new ArrayList<>();
        try {
            // creates a connection to the database
            Connection connection= DriverManager.getConnection(ConfigReader.read("dbURL"),ConfigReader.read("dbUsername"),ConfigReader.read("dbPassword"));
        /*
        take the queries from java code execute them on the database and bring the results back
        into your java program.
         */
            Statement statement=connection.createStatement();
            // Resultset contains the actual data from tables
            ResultSet resultset= statement.executeQuery(query);
            ResultSetMetaData rsm=resultset.getMetaData();


            //next() checks if there are any more rows in the ResultSet if yes it returns true
            // and moves the cursor to the next row
            while(resultset.next()){
                Map<String,String> rowMap=new LinkedHashMap<>();
                for (int i = 1; i <=rsm.getColumnCount() ; i++) {
                    //getting the column names from resultsetmetadata
                    String key=rsm.getColumnLabel(i);
                    //getting the actual data from rs
                    String value=resultset.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);

            }


            // Break till 11:52
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;

    }
}
