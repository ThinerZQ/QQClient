/**
 * 这是客户与服务器保持通信的线程
 */


package com.qq.client.tools;
import java.io.*;
import com.qq.client.view.*;
import java.net.*;

import com.qq.common.Massage;
public class ClientConnectServerThread extends Thread{

	private Socket s;
	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	//构造函数
	public ClientConnectServerThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			//不停地读取从服务器端发来的消息
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Massage m = (Massage)ois.readObject();
				System.out.println("读取到从服务器发送的消息："+m.getSender()+" 对 "+m.getGetter()+" 说 "+m.getNews());
				
				//把服务器获得消息显示到聊天界面
				QqChat qqchat = (QqChat)ManageQqChat.getQqChat(m.getGetter()+" "+m.getSender());
				qqchat.showMassage(m);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
