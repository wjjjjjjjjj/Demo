package com.wjj.utils;

import java.io.File;

public class FileUtil {

	//获取系统临时目录
	public static String getSystem(){
		return System.getProperty("java.io.tmpdir");
	}
	
	//递归遍历某个文件夹下的所有文件夹和文件
	public static void listFile(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();//遍历改文件夹下的所有文件和文件夹
			for(File f : files){
				if(f.isDirectory()){
					listFile(f);
					System.out.println(f.getName());
				}else{
					System.out.println(f.getName());
				}
			}
		}
	}
	
	public static void delFile(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();//遍历改文件夹下的所有文件和文件夹
			for(File f : files){
				if(f.isDirectory()){
					delFile(f);
				}else{
					f.delete();
				}
			}
		}
	}
}
