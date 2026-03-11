package Utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtil {
	private static Connection connection;
	
	public static void connect() throws Exception{
		if(connection== null || connection.isClosed())
			return;
		
		Properties property = new Properties();
		property.load(new FileInputStream("src/test/resources/config.properties"));
		String DBUrl = property.getProperty("db.url");
		String DBUsername = property.getProperty("username");
		String DBPassword = property.getProperty("password");
		connection = DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
	}
	
	public static List<String[]> executeQuery(String query) throws Exception {
        List<String[]> results = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            while (rs.next()) {
                String[] row = new String[cols];
                for (int i = 1; i <= cols; i++) {
                    row[i - 1] = rs.getString(i);
                }
                results.add(row);
            }
        }
        return results;
    }

	
	
	public static void closeConnection() throws SQLException {
		if(connection!=null || !(connection.isClosed()) ){
			connection.close();
		}
	}
	
	

}
