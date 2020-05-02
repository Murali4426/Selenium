package Driverscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import java.sql.ResultSetMetaData;

public class DatabaseExample {
	
	

	public static void main(String[] args) {
		// JDBC driver name and database URL
		   final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
		   final String DB_URL = "jdbc:oracle:thin:@//QADB.NEWCORP.COM:1550/QA";

		   //  Database credentials
		   final String USER = "QAAUTOMT";
		   final String PASS = "Welcome789#";
		   Map map=null;
		   int i=0;
		   int column_count=0;

		   Connection conn = null;
		   Statement stmt = null;
		   ResultSet rs =null;
		   try{
		      //STEP 2: Register JDBC driver
		      //Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "select * from XX_AUTOMATION_EXE_RESULTS where CLIENT_NAME='aafes' and APPLICATION='CareCentral' and BUILD_NUMBER='1'";
		      rs = stmt.executeQuery(sql);
		      
		      //getting the column type
		      ResultSetMetaData rsmd = rs.getMetaData();
		      column_count = rsmd.getColumnCount();
		      System.out.println("result set column_count..."+column_count);
		      System.out.println("result set row_count..."+rs.getRow());
		      while(rs.next()) {
		    	  System.out.println("result set row_count......."+rs.getRow());
		    	  for (int j=1 ;j<=column_count;j++)
		    	  {
                  System.out.println(rs.getString(j));
		    	  }
                  i=i+1;
                  if(column_count==i)
                  {
                	  break;
                  }
		      }
		      
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   //System.out.println("Result Query"+map.toString());
		}//end main
		}//end FirstExample
