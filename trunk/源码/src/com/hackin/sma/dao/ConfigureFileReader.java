/**
 * 

 * DBConfig.java
 * 
 * ����
 * 		���������ļ� readConfig()
 * 
 * 		�ṩ��ñ���Ψһʵ���ķ��� getInstance()
 * 
 * 		�ṩ��������ļ�ֵ�ķ��� getValue()
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
	 * ˽�й��췽����ʹ�ò������ⲿ���ڴ�������ʵ��
	 */
	private ConfigureFileReader() {
		readConfig();
	}

	/**
	 * ���������ļ�
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
	 * ��������Ψһ����
	 * 
	 * @return ��������
	 */
	public synchronized static ConfigureFileReader getInstance() {

		if (configReader == null)
			configReader = new ConfigureFileReader();

		return configReader;
	}

	/**
	 * @param key
	 * @return key��Ӧ��valueֵ
	 */
	public String getValue(String key) {

		return pro.getProperty(key);
	}

	public static void main(String[] args) {

		System.out.println(ConfigureFileReader.getInstance().getValue("db_driver"));
	}
}
