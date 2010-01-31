package com.hackin.sma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DbmsManager {
	
	private static final String DB_DRIVER;
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;

	static {

		// ��ȡ�����ļ��� value
		DB_DRIVER = ConfigureFileReader.getInstance().getValue("db_driver");
		DB_URL = ConfigureFileReader.getInstance().getValue("db_url");
		DB_USER = ConfigureFileReader.getInstance().getValue("db_user");
		DB_PWD = ConfigureFileReader.getInstance().getValue("db_pwd");

		//��������
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ������ݿ�����
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	// �����ѯ���ݿ��SQL��䣬����ResultSet
	public static ResultSet getResultSet(String sql) {

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		if((conn = getConnection()) != null) {
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	// ����������ݿ��SQL���
	public static boolean update(String sql) {
		
		Statement stmt = null;
		Connection conn = null;
		
		if((conn = getConnection()) != null) {
			
			try {
				stmt = conn.createStatement();
				return stmt.execute(sql);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	// �ͷ�ϵͳ��Դ
	public static void realease(ResultSet rs, Statement st, Connection conn) {

		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �ͷ�ϵͳ��Դ
	public static void realease(Object obj) {

		try {
			if (obj != null) {
				if (obj instanceof ResultSet) {
					((ResultSet) obj).close();
				} else if (obj instanceof Statement) {
					((Statement) obj).close();
				} else if (obj instanceof Connection) {
					((Connection) obj).close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
