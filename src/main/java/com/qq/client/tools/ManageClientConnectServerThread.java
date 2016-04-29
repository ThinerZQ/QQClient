/**
 * 这是一个管理通讯客户端与服务器通讯的类
 *管理线程
 */

package com.qq.client.tools;
import java.io.*;
import java.util.*;
import java.net.*;
public class ManageClientConnectServerThread {

	private static HashMap hm = new HashMap<String, ClientConnectServerThread>();
	//把创建好的线程翻入到HASHmap
	public static void addClientConnectServerThread(String qqId,ClientConnectServerThread ccst)
	{
		hm.put(qqId,ccst);
	}
	//取出线程
	public static ClientConnectServerThread getClientConnectServerThread(String qqId)
	{
		return (ClientConnectServerThread)hm.get(qqId);
	}
}
