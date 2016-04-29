/**
 * 这是客户端连接服务器类，后台
 * 
 */

package com.qq.client.model;
import java.io.*;
import com.qq.client.tools.*;
import com.qq.common.*;
import java.net.*;
import java.util.*;
public class QqClientConnectionServer {

	
	public  Socket s;
	public boolean sendUserMassageToServer(Object o)
	{
		boolean b =false;
		try {
			 s = new Socket("127.0.0.1",9999);
			
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			
			Massage m = (Massage)ois.readObject();
			//这里验证用户登录
			if(m.getMassageType().equals("1"))
			{
				//这里创建一个QQ号和服务器通讯连接的线程
				ClientConnectServerThread ccst = new ClientConnectServerThread(s);
				//启动通讯线程
				ccst.start();
				//把登录的QQ取出来放入到管理线程的类
				
				ManageClientConnectServerThread.addClientConnectServerThread(((User)o).getUserId(), ccst);
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
		return b;
	}
}
