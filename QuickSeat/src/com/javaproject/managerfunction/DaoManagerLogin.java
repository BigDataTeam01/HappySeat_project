package com.javaproject.managerfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javaproject.base.*;

public class DaoManagerLogin {
	
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	String adminID;
	String adminPW;
	
	public DaoManagerLogin() {
		
	}
	
	
	public DaoManagerLogin(String adminID, String adminPW) {
		super();
		this.adminID = adminID;
		this.adminPW = adminPW;
	}


	public boolean checkAdminLogin() {
		String dbAdmin_id = "";
		String dbAdmin_pw = "";
		
		String where1 = "select admin_id, admin_pw from admin";
		String where2 = " where admin_id = '" + adminID + "' and admin_pw = '" + adminPW + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1+where2);
			
			if(rs.next()) {
				dbAdmin_id = rs.getString(1);
				dbAdmin_pw = rs.getString(2);
			}
			
			conn_mysql.close();
			
			if(adminID.equals(dbAdmin_id)) {
				if(adminPW.equals(dbAdmin_pw)) {
					return true;
				}
			}
			
		}catch(Exception e) {
			JOptionPane.showInternalMessageDialog(null, "check Login Error");
			return false;
		}
		return false;
	}
	
}
