package com.hyuyuna.narcissus.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtill {
	private  static	SqlUtill db = new SqlUtill();
	private SqlUtill() {}
	public static SqlUtill getInstance() {
		return db;
	}
	public Connection getConnection() {
		Connection conn =null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/fate","root","1234");
        } catch( Exception  e) {
        	e.printStackTrace();
		}	  
        return conn;	   
	}
	
	public  static void  close( PreparedStatement pstmt , Connection conn) {
    	if(pstmt != null ) {
    		try {
				if (!pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
    	}
    	
      	if(conn != null ) {
    		try {
				if (!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn =null ;
			}
    	}      	
	}

	public  static void  close(ResultSet rs ,PreparedStatement pstmt , Connection conn) {
		  	if(rs != null ) {
				try {
					if (!rs.isClosed()) rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					rs =null ;
				}
			}
		   
	   	if(pstmt != null ) {
			try {
				if (!pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt =null ;
			}
		}
		
	  	if(conn != null ) {
			try {
				if (!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn =null ;
			}
		}  		   
	}
	
}