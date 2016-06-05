package com.dreamchain.skeleton.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Configuration {
	private static int pageSize = 5;
	
	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		Configuration.pageSize = pageSize;
	}
	
}
