package com.rest.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;

public class Conexion {
	
//	private static String connectionURL = "jdbc:db2://75.126.155.153:50000/SQLDB";
//	private static String user = "user04379";
//	private static String pass = "lsWMOfCGCGIa";
//	private static String driver = "com.ibm.db2.jcc.DB2Driver";
	private Connection con;
	
    public  Conexion(){
    	
    	
    	
		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(connectionURL, user, pass);
			
			 InitialContext context = new InitialContext();
			 javax.sql.DataSource dataSource = (javax.sql.DataSource) context.lookup("jdbc/comidas");
			 con = dataSource.getConnection();
		}catch(Exception e){
			System.out.println("ERROR Conexion ---> " + e.getMessage());
			e.getStackTrace();	
		}			
    }    
        
    public Connection getConnection(){
    	
    	return con;
    }
	
}
