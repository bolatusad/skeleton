package com.dreamchain.skeleton.util;

public class StringUtil {
	/*
	 * 判断字符串是否为空
	 * */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断是否为非空
	 * */
	public static boolean isNotEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return false;
		}else{
			return true;
		}
	}
}
