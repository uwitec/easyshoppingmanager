/**
 * 

 * DBConfig.java
 * 
 * 功能
 * 		载入配置文件 readConfig()
 * 
 * 		提供获得本类唯一实例的方法 getInstance()
 * 
 * 		提供获得配置文件值的方法 getValue()
 */

package com.hackin.sma.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author hackin wood
 * @since 2009-10-6
 * 
 */
public class ConfigureFileReader {

	private static ConfigureFileReader configReader;
	
	private static Properties pro = new Properties();

	private String path = "com/hackin/sma/dao/db_connect_config.properties";

	/**
	 * 私有构造方法，使得不可在外部用于创建本类实例
	 */
	private ConfigureFileReader() {
		readConfig();
	}

	/**
	 * 载入配置文件
	 */
	private void readConfig() {

		try {
			//pro.load(ClassLoader.getSystemResourceAsStream(path));
			pro.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建本类唯一对象
	 * 
	 * @return 对象引用
	 */
	public synchronized static ConfigureFileReader getInstance() {

		if (configReader == null)
			configReader = new ConfigureFileReader();

		return configReader;
	}

	/**
	 * @param key
	 * @return key对应的value值
	 */
	public String getValue(String key) {

		return pro.getProperty(key);
	}

	public static void main(String[] args) {

		System.out.println(ConfigureFileReader.getInstance().getValue("db_driver"));
	}
}
