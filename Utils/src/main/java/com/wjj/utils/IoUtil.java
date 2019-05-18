package com.wjj.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IoUtil {
	
	//文本文件的拷贝和赋值
	public static void copTxtFile(String src,String des){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(src));
			bw = new BufferedWriter(new FileWriter(des));
			String content = "";
			while((content = br.readLine()) != null){
				bw.write(content);
				bw.newLine();//换行
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IoUtil.close(br,bw);
		}
	}
	
	//二进制文件的拷贝和赋值
	public static void copyBinary(String src,String des){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(des);
			byte[] temp = new byte[1024];
			int len = 0;
			//fis.read(temp):返回每次读取的数据长度
			while((len = fis.read(temp)) != -1){
				fos.write(temp, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IoUtil.close(fis,fos);
		}
	}
	
	//序列化:将对象存在磁盘上
	public static void toDisk(Object obj,String src){
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(src));
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IoUtil.close(oos);
		}
	}
	
	//反序列化
	public static Object readObject(String src){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(src));
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IoUtil.close(ois);
		}
		return null;
	}
	
	//关闭流	Closeable...closeables:可变参数
	public static void close(Closeable...closeables){
		for(Closeable c : closeables){
			if(c != null){
				try {
					c.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		close();
	}
}
