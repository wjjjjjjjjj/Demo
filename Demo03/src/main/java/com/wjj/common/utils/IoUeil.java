package com.wjj.common.utils;

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

public class IoUeil {

	//文本文件的拷贝和赋值
	public static void copyTxtFile(String src,String des) {
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			reader = new BufferedReader(new FileReader(src));
			writer = new BufferedWriter(new FileWriter(des));
			String context="";
			while ((context=reader.readLine())!=null) {
				writer.write(context);
				writer.newLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IoUeil.close(reader,writer);
		}
	}
	
	//二进制文件的拷贝和赋值
	public static void copyBinary(String src,String des) {
		FileInputStream in = null;
		FileOutputStream out =null;
		try {
			in = new FileInputStream(src);
			out= new FileOutputStream(des);
			byte[] temp=new byte[1024];
			int len=0;
			while ((len=in.read(temp))!=-1) {
				out.write(temp,0,len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IoUeil.close(in,out);
		}
	}
	
	//序列化:将对象存在磁盘上
	public static void toDisk(Object obj,String src) {
		ObjectOutputStream out=null;
		try {
			out=new ObjectOutputStream(new FileOutputStream(src));
			out.writeObject(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IoUeil.close(out);
		}
	}
	
	//反序列化
	public static Object readObject(String src) {
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream(new FileInputStream(src));
			return in.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IoUeil.close(in);
		}
		return null;
	}
	
	
	//关流
	public static void close(Closeable...closeables) {
		for (Closeable c : closeables) {
			if (c!=null) {
				try {
					c.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		close();
	}
	
}
