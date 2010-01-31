package com.hackin.sma.dao;

public class DaoFactory {

	public enum DbmsType {
		MYSQL, DERBY, POSTGRESQL;
	}
	
	private DbmsType dbmsType = DbmsType.MYSQL;
	
	public DaoFactory() {
		
	}
	
}
