package reusableComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DB_Operation {
	
	public synchronized HashMap<String,String> getSQLResultsInMap(String sqlQuery) {
		HashMap<String,String> data_map=new HashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qdpm_qa","root","");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qdpm_qa","admin","admin");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sqlQuery);
			ResultSetMetaData  md=rs.getMetaData();
			
			while(rs.next()) {
				for(int i=1;i<=md.getColumnCount();i++) {
					data_map.put(md.getColumnName(i), rs.getString(i));
				}
			}
			System.out.println(data_map);
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data_map;
	}
	

}