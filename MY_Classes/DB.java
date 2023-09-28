package MY_Classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DB {
    
  private static String serverName="localhost"; 
  private static String userName="root"; 
  private static String dbName="project"; 
  private static Integer portNumber=3306; 
  private static String password="mohit2303"; 



  public static Connection getConnection()
  { 
    Connection connection=null;
    MysqlDataSource datasource=new MysqlDataSource();
    datasource.setServerName(serverName);
    datasource.setUser(userName);
    datasource.setDatabaseName(dbName);
    datasource.setPortNumber(portNumber);
    datasource.setPassword(password);

    try{
        connection=datasource.getConnection();

    }catch(SQLException e){
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE,null,e);}

    return connection;
  }
}
